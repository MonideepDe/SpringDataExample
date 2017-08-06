package com.monideepde.resourceLocator.data.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.monideepde.resourceLocator.data.repository.LocationRespository;
import com.monideepde.resourceLocator.data.entity.Location;
import java.util.*;

@RestController
public class LocationController {
	@Autowired
	private LocationRespository repository;
	
	@RequestMapping(value="/locations", method=RequestMethod.GET)
	List<Location> findAll(
			@RequestParam(required=false) String locationName, 
			@RequestParam(required=false) String cityName) {
		List<Location> locations = new ArrayList<>();
		if (null == locationName && null == cityName) {
			Iterable<Location> results = this.repository.findAll();
			results.forEach(location -> {locations.add(location);});
		} else if (null == locationName) {
			Location location = this.repository.findByCityName(cityName);
			if(null!=location) {
				locations.add(location);
			}
		} else if (null == cityName){
			Location location = this.repository.findByName(locationName);
			if(null!=location) {
				locations.add(location);
			}
		} else {
			return this.repository.findByNameAndCityName(locationName, cityName);
		}
		return locations;
	}
	
	@RequestMapping(value="/locations", method=RequestMethod.POST)
	ResponseEntity<String> addNewLocation(@RequestBody PostLocation postLocation) {
		Location location = new Location(postLocation.getCityName(), postLocation.getName());
		repository.save(location);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
