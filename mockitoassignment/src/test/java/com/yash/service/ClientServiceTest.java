package com.yash.service;

import com.yash.dao.ClientDao;
import com.yash.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by mayuri.patil on 20-09-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientDao clientDao;

    @Test
    public void getClientByIdTest(){
        Mockito.when(clientDao.getClientById(1)).thenReturn(new Client(1,"CL1"));
        Client client=clientService.getClientById(1);
        Assert.assertNotNull(client);
    }

}
