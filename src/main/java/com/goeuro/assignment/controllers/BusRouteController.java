package com.goeuro.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goeuro.assignment.models.RouteResponse;
import com.goeuro.assignment.services.BusRouteService;

@RestController
public class BusRouteController {

	@Autowired
	BusRouteService busRouteService;
	
	@RequestMapping("/api/direct")
	public RouteResponse isDirectPath(@RequestParam("dep_sid") String depID,@RequestParam("arr_sid") String arrID) {
		
		
		RouteResponse response = new RouteResponse();
		response.setDep_sid(depID);
		response.setArr_sid(arrID);
		response.setDirect_bus_route(busRouteService.isDirectPath(depID, arrID));
		return response;
		
	}
	

}
