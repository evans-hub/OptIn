package com.apptivate.OptIn.Controller;

import com.apptivate.OptIn.Auth.ApiPrincipal;
import com.apptivate.OptIn.Auth.CurrentUser;
import com.apptivate.OptIn.Entities.trial;
import com.apptivate.OptIn.Model.ClientModel;
import com.apptivate.OptIn.Service.ClientService;
import com.apptivate.OptIn.Service.impl.NetworkService;
import com.apptivate.OptIn.Utils.SingleItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class TimeManagementController {
    @Value("${stakeholder.service}")
    private String stakeholderService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private NetworkService networkService;

    @GetMapping("/correlator")
    public ResponseEntity<?> getCorrelatorForClient(@ApiIgnore @CurrentUser ApiPrincipal principal) {
        Object response;
        String url="";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HashMap<HttpHeaders, Object> dt = new HashMap<>();
        Integer id = principal.getAccount().getId();
        SingleItemResponse client = clientService.findById(id);

        if (client == null || client.getData() == null || !(client.getData() instanceof ClientModel)) {
            throw new UsernameNotFoundException("Client not found");
        }

        ClientModel clientData = (ClientModel) client.getData();
        String correlator = clientData.getCorrelator();

        if (correlator != null) {
            return ResponseEntity.ok().body("Client has opted in");
        } else {
            HttpEntity<SingleItemResponse> httpEntity=new HttpEntity<>(client,headers);
            ResponseEntity responseEntity=restTemplate.exchange(url,HttpMethod.POST,httpEntity, String.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                response = responseEntity.getBody();
            } else {
                response=responseEntity.getBody();
            }
            return ResponseEntity.ok().body(response);
        }
    }
/**/

    @GetMapping("/correlators/{id}")
    public ResponseEntity<?> check(@PathVariable("id") Long id) {
        SingleItemResponse hj=clientService.findById(id);
        trial gg= (trial) hj.getData();
        String vv=gg.getCorrelator();
        if (vv==null){
            return ResponseEntity.ok().body(gg);
        }
        return ResponseEntity.ok().body("vv");
    }
}


