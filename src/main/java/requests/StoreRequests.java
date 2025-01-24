package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Order;

import static io.restassured.RestAssured.given;

public class StoreRequests {

    //this method returns pets inventory by Status
    public Response getInventory(){

        return given()
                .when()
                .get(Routes.inventory);
    }

    //This method places a new order for a pet
    public Response placeOrder(Order payload){

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.order);
    }

    //this method get a purchase order by ID
    public Response getOrderById(String orderId){

        return given()
                .pathParam("orderId", orderId)
                .when()
                .get(Routes.getOrder);
    }

    //This method deletes a purchase order by ID
    public Response deleteOrder(String orderId) {

        return given()
                .pathParam("orderId", orderId)
                .when()
                .delete(Routes.getOrder);
    }
}
