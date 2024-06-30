package bdd.resources.data;

import java.util.ArrayList;
import java.util.List;

import bdd.pojo.maps.AddPlace;
import bdd.pojo.maps.Location;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name, String language, String address) {

        // Build an Object with POJO approach
        AddPlace addPlace = new AddPlace();

        addPlace.setAccuracy(50);
        addPlace.setAddress(address);
        addPlace.setLanguage(language);
        addPlace.setWebsite("http://google.com");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setName(name);

        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shoe");

        addPlace.setTypes(myList);

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLat(33.427362);

        addPlace.setLocation(location);
        return addPlace;
    }

    public String deletePlacePayload(String placeId) {
        return "{\r\n    \"place_id\": \"" + placeId + "\"\r\n}";
    }
}
