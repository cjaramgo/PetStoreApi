package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import model.User;

public class UserRequests {

    // this method creates a new user
    public Response createUser(User payload){

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.user);

    }

    //This method logs in a user
    public Response loginUser(String username, String password){

        return given()
                .when()
                .queryParam("username",username)
                .queryParam("password",password)
                .get(Routes.loginUser);
    }

    //This method gets an existing user by its username
    public Response getUserByUsername(String username){

        return given()
                .pathParam("username", username)
                .when()
                .get(Routes.getUser);
    }

    //This method updates an existing user
    public Response updateUser(String username, User payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(Routes.getUser);
    }

    //This method deletes an existing user
    public Response deleteUser(String username) {

        return given()
                .pathParam("username", username)
                .when()
                .delete(Routes.getUser);
    }

}
