package com.jsonplaceholder.testing.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jsonplaceholder.testing.api.RestTemplateUtil;

import io.restassured.response.Response;

@Component
public class Users extends RestTemplateUtil{
	
	protected static Logger LOG = Logger.getLogger(Users.class);
	
	private String ENDPOINT= "users/";
	
	private static final String USER_ID= "id";
	
	private static final String USER_NAME = "username";
	
	private Response response;
	
	public Response getResponse() {
		return response;
	}

	public Response getResponseByUserName(String name) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(USER_NAME, name);
		LOG.info("Executing GET request to Users API with " +USER_NAME+"="+ name);
		response = executeGet(ENDPOINT, param);
		LOG.info("Response of Users API: "+ response.asString());
		return response;
	}
	
	public List<Integer> getListOfValuesOfIDInResponse() {
		return response.jsonPath().getList(USER_ID);
	}
	
	public List<String> getListOfValuesOfUserNameInResponse() {
		return response.jsonPath().getList(USER_NAME);
	}
	
	public Response getResponseByUserNameWithRequiredVariable(String endPoint, String ParamName, String ParamVal) {
		if(endPoint == null) {
			endPoint = ENDPOINT;
		}
		Map<String, String> param = new HashMap<String, String>();
		param.put(ParamName, ParamVal);
		LOG.info("Executing GET request to Users API with " +ParamName+"="+ ParamVal);
		response = executeGet(endPoint, param);
		LOG.info("Response of Users API: "+ response.asString());
		return response;
	}
}

