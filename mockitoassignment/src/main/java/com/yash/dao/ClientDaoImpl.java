package com.yash.dao;

import com.yash.model.Client;
import com.yash.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
@Repository
public class ClientDaoImpl implements  ClientDao{


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Client getClientById(Integer id) {
        Client client=jdbcTemplate.queryForObject("SELECT * FROM Client where orgID = ? ", new Object[]{id}, new BeanPropertyRowMapper<Client>(Client.class));
        return client;
    }


}
