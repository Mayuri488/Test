package com.yash.controller;

import com.yash.model.Organization;
import com.yash.service.OrganizationService;
import com.yash.service.OrganizationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

/**
 * Created by mayuri.patil on 19-09-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class OrgnaizationControllerTest {

    @InjectMocks
    private OrganizationController organizationController;

    @Mock
    private OrganizationService organizationService;

    @Test
    public void retrieveOrgByIdValidTest(){
        //organizationService.findOrgById(1);
         when(organizationService.findOrgById(1)).thenReturn(retrieveOrgData());
        // Assert.assertNotNull(retrieveOrgData());
        organizationController.getOrgById(1);


    }

    public Organization retrieveOrgData(){
        Organization organization=new Organization(1,"Yash");
        return organization;
    }
/*

    @Test
    public void retrieveOrgByIdNullTest(){
        //organizationService.findOrgById(1);
        when(organizationService.findOrgById(1)).thenReturn(null);
        Assert.assertNull(null);
    }
*/



}
