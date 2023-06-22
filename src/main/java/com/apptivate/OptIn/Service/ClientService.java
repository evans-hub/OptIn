package com.apptivate.OptIn.Service;

import com.apptivate.OptIn.Model.ClientModel;
import com.apptivate.OptIn.Utils.SingleItemResponse;

public interface ClientService {
      SingleItemResponse findById(Integer id);
      SingleItemResponse findById(Long id);

      SingleItemResponse<ClientModel> getClients(int id,String token);
}
