package bdd.apis;

/**
 * 
 * enum is a special class in Java which can contains collection of constants or methods
 * these are implicitly static and final
 * can not change their value once created. 
 * provides type-safety
 * 
 */
public enum APIMapsResources {

    ADD_PLACE_API("maps/api/place/add/json"),
    GET_PLACE_API("maps/api/place/get/json"),
    DELETE_PLACE_API("maps/api/place/delete/json");

    private String resource;

    APIMapsResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
