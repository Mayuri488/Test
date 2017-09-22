package com.yash.controller;

import com.yash.model.Field;
import com.yash.model.Organization;
import com.yash.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Organization> getOrgById(@PathVariable(value="id" ) Integer orgId){

        System.out.print("************\n");
        Organization organization=organizationService.findOrgById(orgId);
        System.out.println(organization);
        return new ResponseEntity<Organization>(organization, HttpStatus.OK);
    }


    @RequestMapping(value = "org/{orgId}/field/{fieldId}/field",method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Field>> getFieldsDetails(@PathVariable(value="orgId" ) Integer orgId,@PathVariable(value="fieldId" ) Integer fieldId){
        System.out.println("################");
        Organization  organization=organizationService.getFieldsDetails(orgId,fieldId);
        return new ResponseEntity(organization,HttpStatus.OK);
    }

    /*@RequestMapping(value = "/test",method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> retrieveData(){
        System.out.println("In Org Controller");
        return new ResponseEntity<String>("HI", HttpStatus.OK);
    }
*/
}
