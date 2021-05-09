package com.jsonplaceholder.testing.users;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import com.jsonplaceholder.testing.BaseTest;
import com.jsonplaceholder.testing.utils.Constant;

@Tag("Users")
@Tag("Negative")
public class UsersApiNegativeTest extends BaseTest{

	@Value("${searchNegetiveUser}")
	private String searchNegetiveUser;
	
	@Value("${searchUser}")
	private String searchUser;
	
	@Value("${user.InvalidEndpoint}")
	private String InvalidEndpoint;
	
	@Value("${user.InvalidParam}")
	private String InvalidParam;
	
	@Test
	public void testNoRecordPresentForGivenUserName() {
		users.getResponseByUserName(searchNegetiveUser).then().assertThat().statusCode(Constant.STATUS_CODE_SUCCESS);
		List<Integer> userIdList =users.getListOfValuesOfIDInResponse();
		assertEquals(0,userIdList.size());
	}
	
	/*
	 * Validating GET user API with Invalid Parameter Variable Name.
	 * Expected: With Invalid Query Param Name (lets say as per Agreement) should return Bad Request.
	 * Actual: Current its returning response without any filter.
	 */
	@Test
	public void testInvalidUserAPIParamName() {
		String endpoint = null;
		users.getResponseByUserNameWithRequiredVariable(endpoint, InvalidParam, searchUser).then().assertThat().statusCode(Constant.STATUS_CODE_BAD_REQUEST);
	}
	
	/*
	 * Validating GET user API with Invalid Endpoint. Expected the API to return Not Found in response.
	 */
	@Test
	public void testInvalidUserAPIEndpoint() {
		users.getResponseByUserNameWithRequiredVariable(InvalidEndpoint, "username", searchUser).then().assertThat().statusCode(Constant.STATUS_CODE_NOT_FOUND);
	}
}
