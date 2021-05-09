package com.jsonplaceholder.testing.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import com.jsonplaceholder.testing.BaseTest;
import com.jsonplaceholder.testing.utils.Constant;

import net.minidev.json.JSONObject;
@Tag("Posts")
@Tag("Positive")
public class PostsApiPositiveTest extends BaseTest{

	@Value("${searchUserId}")
	private String searchUserId;
	
	@Value("${searchPostId}")
	private String searchPostId;
	
	@Test
	public void testGetByUserIDOfPostsAPI() {
		posts.getResponseByUserID(searchUserId).then().assertThat().statusCode(Constant.STATUS_CODE_SUCCESS);
		List<Integer> userIdList =posts.getListOfValuesOfUserIDInResponse();
		userIdList.stream().forEach(userId -> assertEquals(userId,3));
	}
	
	@Test
	public void testGetByPostIDReturnsUniqueRecordOfPostsAPI() {
		posts.getResponseByPostID(searchPostId).then().assertThat().statusCode(Constant.STATUS_CODE_SUCCESS);
		List<Integer> userIdList =posts.getListOfValuesOfPostIDInResponse();
		assertEquals(1,userIdList.size());
	}
	
	@Test
	public void testPostFunctionalityOfPostsAPI() {
		JSONObject request= jsonReader.parseJson("posts");
		posts.postRequest(request).then().assertThat().statusCode(Constant.STATUS_CODE_CREATED);
	}

}
