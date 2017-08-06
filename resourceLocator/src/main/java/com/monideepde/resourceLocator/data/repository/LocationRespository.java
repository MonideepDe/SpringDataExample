package com.monideepde.resourceLocator.data.repository;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;

import com.monideepde.resourceLocator.data.entity.Location;

import java.util.*;

@Resource
public interface LocationRespository extends CrudRepository<Location, Long>{
	Location findByName(String name);
	Location findByCityName(String cityName);
	ArrayList<Location> findByNameAndCityName(String name, String cityName);
	//void persist(Location location);
	//void persist(PostLocation location);
}
