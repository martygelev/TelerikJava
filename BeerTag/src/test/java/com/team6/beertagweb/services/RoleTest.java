package com.team6.beertagweb.services;

import com.team6.beertagweb.models.Roles;
import com.team6.beertagweb.models.enums.RolesEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.management.ObjectName;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RoleTest {

    @Mock
    Role roleRepository;

    @InjectMocks
    Roles roleService;

    @Test
    public void loadRoleByRoleName_ReturnCorrectRole() {

    }

}