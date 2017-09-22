package com.yash.dao;

import com.yash.model.Organization;
import com.yash.resultsetextratcor.FieldResultSetExtratcor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Objects;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrganizationDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private OrganizationDaoImpl organizationDao;

    /*@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }*/

    @Mock
    RowMapper<Organization> rowMapper;


    @Test
    public void findOrgById(){
        Organization organization=new Organization(1,"Yahs");
        when(jdbcTemplate.queryForObject(anyString(),anyObject(),any(BeanPropertyRowMapper.class))).thenReturn(organization);
        Organization org=organizationDao.findOrgById(1);
      // verify(organizationDao,times(1)).findOrgById(1);
       Assert.assertNotNull(org);
    }

    @Test
    public void fieldAgainstRequestedOrg(){
        Organization organization=new Organization(1,"Yash");
        when(jdbcTemplate.query(anyString(),any(Objects[].class),any(FieldResultSetExtratcor.class))).thenReturn(organization);
        Organization org=organizationDao.getFieldsDetails(1,1);
        Assert.assertNotNull(org);
        System.out.println("Organization :: "+org);
    }


}

