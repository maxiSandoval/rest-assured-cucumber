package bdd.resources;

import java.util.ArrayList;
import java.util.List;

import bdd.pojo.googlemaps.AddPlace;
import bdd.pojo.googlemaps.Location;

public class TestDataBuild {

    public AddPlace addPlacePayload() {

        // Build an Object with POJO approach
        AddPlace addPlace = new AddPlace();

        addPlace.setAccuracy(50);
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setLanguage("French-IN");
        addPlace.setWebsite("http://google.com");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setName("Frontline house");

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
}
