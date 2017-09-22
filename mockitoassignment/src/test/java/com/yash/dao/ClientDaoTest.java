package com.yash.dao;

import com.yash.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ClientDaoImpl clientDaoImpl;

    @Test
    public void getClientByIdTest(){
        String query="SELECT * FROM client where ClientID = ? ";
        Integer id=1;
        Client client=new Client(1,"CL1");
        Mockito.when(jdbcTemplate.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<Client>(Client.class))).thenReturn(client);
        clientDaoImpl.getClientById(1);
    }

}

