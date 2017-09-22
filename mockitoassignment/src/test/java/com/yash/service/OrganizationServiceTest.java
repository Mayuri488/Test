package com.yash.service;

import com.yash.dao.OrganizationDao;
import com.yash.model.Organization;
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
public class OrganizationServiceTest {

    @InjectMocks
    private OrganizationServiceImpl organizationService;

    @Mock
    private OrganizationDao organizationDao;

    @Test
    public void  findOrgByIdTest()
    {
        Mockito.when(organizationDao.findOrgById(1)).thenReturn(new Organization(1,"Yash"));

        Organization organization=organizationService.findOrgById(1);
        Assert.assertNotNull(organization);
    }


}
