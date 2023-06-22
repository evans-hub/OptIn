package com.apptivate.OptIn.Controller;

import com.apptivate.OptIn.Auth.ApiPrincipal;
import com.apptivate.OptIn.Auth.CurrentUser;
import com.apptivate.OptIn.Model.ClientModel;
import com.apptivate.OptIn.Service.ClientService;
import com.apptivate.OptIn.Utils.SingleItemResponse;
import com.apptivate.OptIn.Utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class TrialController {
    private final RestTemplate restTemplate;

    @Autowired
    public TrialController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Autowired
    private ClientService clientService;
    @GetMapping("/getClients/{id}")
    public ResponseEntity getClient(HttpServletRequest httpServletRequest, @ApiIgnore @CurrentUser  ApiPrincipal principal ){
       // SingleItemResponse singleItemResponse=clientService.getClients(principal.getAccount().getId(),Util.getToken(httpServletRequest));
        SingleItemResponse singleItemResponse=clientService.getClients(principal.getAccount().getId(),Util.getToken(httpServletRequest));
        return Util.getResponse(singleItemResponse.getStatus(),singleItemResponse);
    }



    @GetMapping("/api/consume")
    public ResponseEntity<ApiResponse> consumeApi() {
        String apiUrl = "http://127.0.0.1:8085/api/v1/correlators/5";

        try {
            ApiResponse response = restTemplate.getForObject(apiUrl, ApiResponse.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle any errors or exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
