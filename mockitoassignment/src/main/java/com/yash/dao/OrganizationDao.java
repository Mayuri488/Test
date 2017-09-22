package com.yash.dao;

import com.yash.model.Field;
import com.yash.model.Organization;

import java.util.List;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
public interface OrganizationDao {
    public Organization findOrgById(Integer id);
    public Organization getFieldsDetails(Integer orgId, Integer fieldId);
}
