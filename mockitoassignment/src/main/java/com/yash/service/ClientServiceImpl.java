package com.yash.service;

import com.yash.dao.ClientDao;
import com.yash.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientDao clientDao;

    @Override
    public Client getClientById(Integer id) {
        Client client=clientDao.getClientById(id);
        return client;
    }
}
