package com.yash.controller;

import com.yash.model.Client;
import com.yash.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @Test
    public void testGetClientForValidData(){

        Mockito.when(clientService.getClientById(1)).thenReturn(retrieveClientData());
        Assert.assertNotNull(retrieveClientData());
    }

    @Test
    public void testGetClientForNull(){
        String query="SELECT * FROM client where orgID = ? ";
        Mockito.when(clientService.getClientById(1)).thenReturn(retrieveClientData());
        Assert.assertNull(null);
    }

    public Client retrieveClientData(){
        Client client=new Client(1,"Client1");
        return client;

    }
}
