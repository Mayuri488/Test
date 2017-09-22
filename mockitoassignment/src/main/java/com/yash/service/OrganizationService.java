package com.yash.service;

import com.yash.model.Field;
import com.yash.model.Organization;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mayuri.patil on 19-09-2017.
 */

public interface OrganizationService {
    public Organization findOrgById(Integer id);
    public Organization getFieldsDetails(Integer orgId, Integer fieldId);
}
