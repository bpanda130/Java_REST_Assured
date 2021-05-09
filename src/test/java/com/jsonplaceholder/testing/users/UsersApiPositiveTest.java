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
@Tag("Positive")
public class UsersApiPositiveTest extends BaseTest{

	@Value("${post.User1}")
	private String searchUserName;
	
	
	
	@Test
	public void testUniqueRecordPresentForUserName() {
		users.getResponseByUserName(searchUserName).then().assertThat().statusCode(Constant.STATUS_CODE_SUCCESS);
		List<Integer> userIdList =users.getListOfValuesOfIDInResponse();
		assertAll(
				() -> assertFalse( 0 == userIdList.size(),"User Named "+ searchUserName +" Does Not exists"),
				() -> assertTrue(1 == userIdList.size(),"Multiple Records found for user name "+searchUserName)
				);
	}
	
	@Test
	public void testGetByUserNameOfUsersAPI() {
		users.getResponseByUserName(searchUserName).then().assertThat().statusCode(Constant.STATUS_CODE_SUCCESS);
		List<String> userNameList =users.getListOfValuesOfUserNameInResponse();
		userNameList.stream().forEach(userName -> assertEquals(userName,searchUserName));
	}
}
