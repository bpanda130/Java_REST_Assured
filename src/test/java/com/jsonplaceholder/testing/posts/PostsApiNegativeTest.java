package com.jsonplaceholder.testing.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.jsonplaceholder.testing.BaseTest;
import com.jsonplaceholder.testing.utils.Constant;
@Tag("Posts")
@Tag("Negative")
public class PostsApiNegativeTest extends BaseTest{
	
	@Test
	public void testGetByPostIDThatIsNotPresentOnSerevrReturnsNoRecord() {
		posts.getResponseByPostID("Random").then().assertThat().statusCode(Constant.STATUS_CODE_SUCCESS);
		List<Integer> userIdList =posts.getListOfValuesOfUserIDInResponse();
		assertEquals(0,userIdList.size());
	}

}
