package requests;

import utils.ReadProperties;

public class Routes {

    // Base URL
    public static String baseURI = ReadProperties.getProperty("baseURI");

    // User paths
    public static String user = baseURI + "/user";
    public static String loginUser = baseURI + "/user/login";
    public static String getUser = baseURI + "/user/{username}";

    //Pet paths
    public static String pet = baseURI + "/pet";
    public static String getPet = baseURI + "/pet/{petId}";
    public static String getPetByStatus = baseURI + "/pet/findByStatus";
    public static String getPetByTags = baseURI + "/pet/findByTags";

    //Store paths
    public static String inventory = baseURI + "/store/inventory";
    public static String order = baseURI + "/store/order";
    public static String getOrder = baseURI + "/store/order/{orderId}";
}
