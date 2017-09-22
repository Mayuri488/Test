package com.yash.dao;

import com.yash.model.Field;
import com.yash.model.Organization;
import com.yash.resultsetextratcor.FieldResultSetExtratcor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mayuri.patil on 20-09-2017.
 */

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Organization findOrgById(Integer id) {
        Organization org=jdbcTemplate.queryForObject("SELECT * FROM organization where orgID = ? ", new Object[]{id}, new BeanPropertyRowMapper<Organization>(Organization.class));
        System.out.println("organization :::-> "+org);

        return  org;
    }

    public Organization getFieldsDetails(Integer orgId,Integer fieldId){

        System.out.println("In Dao");
        String query="SELECT * FROM organization LEFT OUTER JOIN client ON organization.orgid=client.fkorgid " +
                "LEFT OUTER JOIN form ON client.clientid=form.fkclientid " +
                "LEFT OUTER JOIN fields ON form.fromid=fields.fkformid " +
                "where organization.orgid=? and fields.fieldid=? and fields.fieldid IS NOT NULL";

        Organization organization=jdbcTemplate.query(query, new Object[]{orgId, fieldId}, new FieldResultSetExtratcor());
        System.out.println(organization);
        return organization;

    }


}
