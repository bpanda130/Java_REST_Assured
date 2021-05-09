package com.jsonplaceholder.testing.posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jsonplaceholder.testing.api.RestTemplateUtil;
import com.jsonplaceholder.testing.users.Users;

import io.restassured.response.Response;
import net.minidev.json.JSONObject;
@Component
public class Posts extends RestTemplateUtil{
	
	protected static Logger LOG = Logger.getLogger(Users.class);
	
	private String ENDPOINT= "posts/";
	
	private static final String POST_ID= "id";
	
	private static final String USER_ID = "userId";
	
	private Response response;
	
	public Response getResponse() {
		return response;
	}
	
	public Response getResponseByUserID(String ID) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(USER_ID, ID);
		LOG.info("Executing GET request to Posts API with " +USER_ID+"="+ ID);
		response = executeGet(ENDPOINT, param);
		LOG.info("Response of Posts API: "+ response.asString());
		return response;
	}
	
	public Response getResponseByPostID(String ID) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(POST_ID, ID);
		LOG.info("Executing GET request to Posts API with " +POST_ID+"="+ ID);
		response = executeGet(ENDPOINT, param);
		LOG.info("Response of Posts API: "+ response.asString());
		return response;
	}
	
	public Response postRequest(JSONObject request) {
		response = executePost(ENDPOINT, request);
		return response;
	}
	
	public List<Integer> getListOfValuesOfUserIDInResponse() {
		return response.jsonPath().getList(USER_ID);
	}
	
	public List<Integer> getListOfValuesOfPostIDInResponse() {
		return response.jsonPath().getList(POST_ID);
	}
}

