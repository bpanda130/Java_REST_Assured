package com.jsonplaceholder.testing.comments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jsonplaceholder.testing.api.RestTemplateUtil;
import com.jsonplaceholder.testing.utils.ComparatorUtil;

import io.restassured.response.Response;

@Component
public class Comments extends RestTemplateUtil{
	
	protected static Logger LOG = Logger.getLogger(Comments.class);
	
	private String ENDPOINT="comments/";
	
	private static final String POST_ID= "postId";
	
	private static final String EMAIL = "email";
	
	private Response response;
	
	public Response getResponse() {
		return response;
	}
	
	public Response getResponseByPostID(String ID) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(POST_ID, ID);
		LOG.info("Executing GET request to Comments API with " +POST_ID+"="+ ID);
		response = executeGet(ENDPOINT, param);
		LOG.info("Response of Users API: "+ response.asString());
		return response;
	}
	
	public List<String> getListOfValuesOfEmailsInResponse(){
		return response.jsonPath().getList(EMAIL);
	}
	
	public boolean isValid(String email) {
		return ComparatorUtil.regexMatcher(email, "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	}
	
}
