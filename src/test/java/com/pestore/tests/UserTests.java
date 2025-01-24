package com.pestore.tests;

import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import payloads.UserPayload;
import requests.UserRequests;

import static io.qameta.allure.Allure.attachment;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTests {

    public UserPayload userPayload = new UserPayload();
    public static UserRequests user = new UserRequests();
    public static String username;
    public static String password;

    @Feature("Users")
    @Story("Create a new user")
    @Test
    @Order(1)
    @DisplayName("Create a new user")
    public void testCreateUser(){

        Response response = user.createUser(userPayload.postUser());
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

        String responseStr = response.asString();
        username = JsonPath.read(responseStr, "$.username");
        password = JsonPath.read(responseStr,"$.password");

    }

    @Feature("Users")
    @Story("Log in user")
    @Test
    @Order(2)
    @DisplayName("Log in user")
    public void testLoginUser(){

        Response response = user.loginUser(username, password);
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

    }

    @Feature("Users")
    @Story("Get a user detail by its username")
    @Test
    @Order(3)
    @DisplayName("Get user detail by username")
    public void testGetUserByUsername() {

        Response response = user.getUserByUsername(username);
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());
    }

    @Feature("Users")
    @Story("Verify a non-existent user")
    @Test
    @Order(6)
    @DisplayName("Verify non-existent user")
    public void testVerifyNonExistentUser() {

        Response response = user.getUserByUsername(username);
        attachment("Response", response.prettyPrint());

        assertEquals(404, response.getStatusCode());
    }

    @Feature("Users")
    @Story("Update a existing user")
    @Test
    @Order(4)
    @DisplayName("Update a user")
    public void testUpdateUser(){

        Response response = user.updateUser(username, userPayload.putUser());
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

    }

    @Feature("Users")
    @Story("Delete an existing user")
    @Test
    @Order(5)
    @DisplayName("Delete User")
    public void testDeleteUser() {

        Response response = user.deleteUser(username);
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());
    }

}
