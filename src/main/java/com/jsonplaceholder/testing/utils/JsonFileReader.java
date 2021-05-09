package com.jsonplaceholder.testing.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JsonFileReader {
	
	//This method will return object of json that we have to send in the request
	public JSONObject parseJson(String fileName){
		JSONParser parser=new JSONParser(1);
		JSONObject obj= new JSONObject();
		try {
			FileReader file=new FileReader(getClass().getClassLoader().getResource("template/"+fileName+".json").getFile());
			obj =(JSONObject) parser.parse(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
		
		
		
		
		