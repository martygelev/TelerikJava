package com.team6.beertagweb.services;


import com.team6.beertagweb.models.User;
import com.team6.beertagweb.repositories.base.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
    public class UserService {

        @Mock
        UserRepository UserRepository;

        private UserServiceImpl UserService;

        @Before
        public void beforeTest() {
            UserService = new UserServiceImpl(UserRepository);
        }



        @Test
        public void findUserById_whenUserIdIsPresented_ShouldReturnUser() {

            User User = new User();
            User.setId(1);

            when(UserRepository.getUserById(1)).thenReturn(User);
            User actualUser = UserService.getUserById(1);

            Assert.assertEquals(User.getId(), actualUser.getId());
        }

        @Test
        public void listAllUsers_whenUsersListIsPresented_ShouldReturnListOfUsers() {

            List<User> UserList = new ArrayList<>();
            User firstUser = new User();
            User secondUser = new User();
            User thirdUser = new User();

            UserList.add(firstUser);
            UserList.add(secondUser);
            UserList.add(thirdUser);

            when(UserRepository.getUsers()).thenReturn(UserList);
            List<User> actualUserList = UserService.getUsers();

            Assert.assertEquals(UserList.size(), actualUserList.size());
        }


}
