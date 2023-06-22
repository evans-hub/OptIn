package com.apptivate.OptIn.Service.impl;

import com.apptivate.OptIn.Entities.Client;
import com.apptivate.OptIn.Entities.trial;
import com.apptivate.OptIn.Model.ClientModel;
import com.apptivate.OptIn.Repos.ClientDao;
import com.apptivate.OptIn.Repos.TrialDao;
import com.apptivate.OptIn.Service.ClientService;
import com.apptivate.OptIn.Utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientDao clientDao;
    @Value("${base.url}")
    private String baseURL;
    @Value("${stakeholder.service}")
    private String stakeholderService;
    @Autowired
    private TrialDao trialDao;
    @Autowired
    private NetworkService networkService;
    private HashMap<String, String> getHeaders(String token, String appKey) {
        HashMap<String, String> headers = new HashMap<>();
        if (token != null) {
            headers.put("Authorization", "Bearer " + token);
        }

        if (appKey != null) {
            headers.put("App-Key", appKey);
        }
        headers.put("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
    private HashMap<String, String> getHeaders(String token) {
        return getHeaders(token, null);
    }

  /*  @Override
    public SingleItemResponse createUpdateClient(ClientRequest request, AccountModel account) {
        return null;
    }*/

    @Override
    public SingleItemResponse findById(Integer id) {
        Client client=clientDao.findById(id).get();
        return new SingleItemResponse<>(Response.SUCCESS.status(), client);
    }
    @Override
    public SingleItemResponse findById(Long id) {
        trial clientd=trialDao.findById(id).get();
        return new SingleItemResponse<>(Response.SUCCESS.status(), clientd);
    }

    @Override
    public SingleItemResponse<ClientModel> getClients(int id,String token) {
HashMap<String,Object> data=new HashMap<>();
ResponseEntity<String> responseEntity=networkService.getData(data,getHeaders(token), stakeholderService + "/clients/" + id);
       SingleItemResponse response=new SingleItemResponse();
       if (responseEntity.getStatusCodeValue()==200){
           response=new Util<SingleItemResponse>().fromJson(responseEntity.getBody(),SingleItemResponse.class);
           if (response==null){
               throw new UsernameNotFoundException("Client Not Found");
           }
           else {
              ClientModel client= (ClientModel) response.getData();
              String correlator=client.getCorrelator();
              if (correlator==null){
                  createClientInHr(client);
                  ResponseEntity.ok().body("Client has not opted in");
              }
              else {
                  ResponseEntity.ok().body("Client has opted in");
              }

           }
       }
       else {
           response.setStatus(new Util<Status>().fromJson(responseEntity.getBody(),Status.class));
       }
        return response;
    }

    private String createClientInHr(ClientModel client) {
        String response;
ResponseEntity<String> responseEntity=networkService.sendRequest("api/v1/hr101/clients",HttpMethod.GET,client);
        if (responseEntity.getStatusCodeValue() == 0) {
            response = responseEntity.getBody();
        } else {
            response=responseEntity.getBody();
        }
        return response;
    }


}
