package bdd.apis;

/**
 * 
 * enum is a special class in Java which can contains collection of constants or
 * methods
 * - these are implicitly static and final
 * - can not change their value once created.
 * - provides type-safety
 * 
 * We use this constants like API Path
 * API REST of Place Maps Services
 * 
 */
public enum APIMapsResources {

    ADD_PLACE_API("maps/api/place/add/json"),
    GET_PLACE_API("maps/api/place/get/json"),
    DELETE_PLACE_API("maps/api/place/delete/json");

    private String resource;

    /**
     * With String resource param we can invoke the constants String declared in this class
     * @param resource
     */
    APIMapsResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
