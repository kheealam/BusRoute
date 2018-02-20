package com.goeuro.assignment.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class BusRouteService {
	
	ArrayList<HashMap<String,Integer>> routeMap=new ArrayList<HashMap<String,Integer>>();
	
	
	public BusRouteService() {
		initializeBusRoutes();
	}
	
	public boolean isDirectPath(String departID,String arrivalID) {
		for(int i=0;i<routeMap.size();++i) {
			HashMap<String, Integer> map =routeMap.get(i);
			if(map.containsKey(departID)) {
				
				Integer indexOfDepart = map.get(departID);
				if(map.containsKey(arrivalID)) {
					Integer indexOfArrival = map.get(arrivalID);
					if(indexOfDepart<indexOfArrival) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void initializeBusRoutes() {
		
		try {
			routeMap=new ArrayList<HashMap<String,Integer>>();
			BufferedReader bReader = Files.newBufferedReader(Paths.get("data/example.txt"));
			String line = "";
			Integer busRouteCount = Integer.valueOf((bReader.readLine()));
			for(int i=0;i<busRouteCount;++i) {
				line = bReader.readLine();
				String[] arr =line.split(" ");
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				routeMap.add(map);
				for (int j=1;j<arr.length;++j) {
					map.put(arr[j],j);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
