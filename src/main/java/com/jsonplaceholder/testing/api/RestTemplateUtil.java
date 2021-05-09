package com.jsonplaceholder.testing.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class RestTemplateUtil {

	String baseURI = "https://jsonplaceholder.typicode.com/";

	protected Response executeGet(String endpoint, Map<String, String> params) {

		return given().contentType(ContentType.JSON).baseUri(baseURI).headers(createHeaders()).params(params)
				.get(endpoint);

	}

	protected Response executePost(String endpoint, JSONObject request) {
		return given().contentType(ContentType.JSON).baseUri(baseURI).headers(createHeaders()).body(request).when()
				.post(endpoint);
	}

	private Map<String, ?> createHeaders() {
		Map<String, Object> headers = new HashMap<String, Object>();
		return headers;
	}
}
