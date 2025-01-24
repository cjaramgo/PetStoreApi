package com.pestore.tests;

import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import payloads.OrderPayload;
import requests.StoreRequests;

import static io.qameta.allure.Allure.attachment;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreTests {

    public OrderPayload orderPayload = new OrderPayload();
    public static StoreRequests store = new StoreRequests();
    public static int orderId;
    public static String orderIdStr;

    @Feature("Store")
    @Story("Get all pet inventory by status")
    @Test
    @DisplayName("Get all pet inventory")
    public void testGetInventory()
    {
        Response response = store.getInventory();
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

    }

    @Feature("Store")
    @Story("Place a new order for a pet")
    @Test
    @Order(1)
    @DisplayName("Place a new order")
    public void testPlaceOrder()
    {
        Response response = store.placeOrder(orderPayload.postOrder());
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());

        String responseStr = response.asString();
        orderId = JsonPath.read(responseStr, "$.id");
        orderIdStr = String.valueOf(orderId);

    }

    @Feature("Store")
    @Story("Get an order detail by its Id")
    @Test
    @Order(2)
    @DisplayName("Get order detail")
    public void testGetOrderByID() {
        Response response = store.getOrderById(orderIdStr);
        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());
    }

    @Feature("Store")
    @Story("Verify an invalid order Id")
    @Test
    @Order(4)
    @DisplayName("Verify invalid order")
    public void testVerifyInvalidOrder() {
        Response response = store.getOrderById(orderIdStr);
        attachment("Response", response.prettyPrint());

        assertEquals(404, response.getStatusCode());
    }

    @Feature("Store")
    @Story("Delete an existing Order")
    @Test
    @Order(3)
    @DisplayName("Delete order")
    public void testDeleteOrder() {

        Response response = store.deleteOrder(orderIdStr);

        attachment("Response", response.prettyPrint());

        assertEquals(200, response.getStatusCode());
    }
}
