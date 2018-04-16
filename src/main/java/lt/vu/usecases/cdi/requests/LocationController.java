package lt.vu.usecases.cdi.requests;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.LocationMapper;
import lt.vu.usecases.mybatis.model.Location;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
@Slf4j
public class LocationController {

    @Getter
    private List<Location> locations;

    @Getter
    private Location location = new Location();

    @PostConstruct
    public void init() {
        loadLocations();
    }

    @Inject
    private LocationMapper locationMapper;

    @Transactional
    public void createLocation() {
        List<Integer> ids = getLocationIds();
        int tempID = 1;
        while(ids.contains(tempID))
        {
            tempID++;
        }
        location.setId(tempID);
        locationMapper.insert(location);
        loadLocations();
    }

    private void loadLocations() {
        locations = locationMapper.selectAll();
    }

    @Transactional
    public List<String> getLocationNames(){
        List<String> names = new ArrayList<>();
        for (Location item:locations) {
            names.add(item.getName());
        }
        return names;
    }

    private List<Integer> getLocationIds(){
        List<Integer> ids = new ArrayList<>();
        for (Location item:locations) {
            ids.add(item.getId());
        }
        return ids;
    }
}

//package lt.vu.usecases.cdi.requests;
//
////package lt.vu.usecases.cdi.requests.JPA;
//
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import lt.vu.entities.Location;
//import lt.vu.usecases.cdi.dao.LocationDAO;
//import lt.vu.usecases.mybatis.dao.LocationMapper;
//
//import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Model;
//import javax.inject.Inject;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Model
//@Slf4j
//public class LocationController {
//
//    @Getter
//    private Location location = new Location();
//    @Getter
//    private List<Location> locations;
//
//    @PostConstruct
//    public void init() {
//        loadLocations();
//    }
//
//    @Inject
//    private LocationDAO locationDAO;
//
//    @Transactional
//    public void createLocation() {
//        List<Integer> ids = getLocationIds();
//        int tempID = 0;
//        while(ids.contains(tempID))
//        {
//            tempID++;
//        }
//        location.setId(tempID);
//        locationDAO.create(location);
//        loadLocations();
//    }
//
//    @Transactional
//    public List<String> getLocationNames() {
//        return locations.stream().map(Location::getName).collect(Collectors.toList());
//    }
//
//    public List<Integer> getLocationIds() {
//        return locations.stream().map(Location::getId).collect(Collectors.toList());
//    }
//
//    private void loadLocations() {
//        locations = locationDAO.getAllLocations();
//    }
//}