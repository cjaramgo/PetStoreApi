package com.pestore.tests;

import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import payloads.PetPayload;
import requests.PetRequests;

import static io.qameta.allure.Allure.attachment;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTests {

    public PetPayload petPayload = new PetPayload();
    public static PetRequests pet = new PetRequests();
    public static int petId;
    public static String petIdStr;

    @Feature("Pets")
    @Story("Create a new pet")
    @Test
    @Order(1)
    @DisplayName("Create a new pet")
    public void testCreatePet() {

        Response response = pet.createPet(petPayload.postPet());
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

        String responseStr = response.asString();
        petId = JsonPath.read(responseStr, "$.id");
        petIdStr = String.valueOf(petId);
    }


    @Feature("Pets")
    @Story("Get a pet detail by its Id")
    @Test
    @Order(2)
    @DisplayName("Get a pet")
    public void testGetPetByID() {
        Response response = pet.getPetById(petIdStr);
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());
    }

    @Feature("Pets")
    @Story("Verify invalid pet by its Id")
    @Test
    @Order(5)
    @DisplayName("Verify invalid pet")
    public void testInvalidPet() {
        Response response = pet.getPetById(petIdStr);
        attachment("Response", response.prettyPrint());

        assertEquals(404, response.getStatusCode());
    }

    @Feature("Pets")
    @Story("Get all pets by status")
    @Test
    @DisplayName("Get all pets by status")
    public void testGetPetsByStatus()
    {
        Response response = pet.getPetByStatus("available");
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

    }

    @Feature("Pets")
    @Story("Get all pets by tags")
    @Test
    @DisplayName("Get all pets by tags")
    public void testGetPetsByTags()
    {
        Response response = pet.getPetByTags("myTag");
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

    }

    @Feature("Pets")
    @Story("Update a existing Pet")
    @Test
    @Order(3)
    @DisplayName("Update a Pet")
    public void testUpdatePet(){

        Response response = pet.updatePet(petPayload.putPet(petId));
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

    }

    @Feature("Pets")
    @Story("Delete an existing Pet")
    @Test
    @Order(4)
    @DisplayName("Delete Pet")
    public void testDeletePet() {

        Response response = pet.deleteUser(petIdStr);
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());
    }

}