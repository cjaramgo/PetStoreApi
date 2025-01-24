package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pet;

import static io.restassured.RestAssured.*;

public class PetRequests {

    //This method creates a new pet
    public Response  createPet(Pet payload)
    {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.pet);
    }

    //This method finds pets by status
    public Response getPetByStatus(String status)
    {
        return given()
                .queryParam("status", status)
                .when()
                .get(Routes.getPetByStatus);
    }

    //This method finds pets by tags
    public Response getPetByTags(String tag)
    {
        return given()
                .queryParam("tags", tag)
                .when()
                .get(Routes.getPetByTags);
    }

    //This method gets an existing pet by its ID
    public Response getPetById(String petId){

        return given()
                .pathParam("petId", petId)
                .when()
                .get(Routes.getPet);
    }

    //This method updates an existing Pet
    public Response updatePet(Pet payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.pet);
    }

    //This method deletes an existing Pet
    public Response deleteUser(String petId) {

        return given()
                .pathParam("petId", petId)
                .when()
                .delete(Routes.getPet);
    }
}
