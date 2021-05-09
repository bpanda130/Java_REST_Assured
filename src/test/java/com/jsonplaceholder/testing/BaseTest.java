package com.jsonplaceholder.testing;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jsonplaceholder.testing.comments.Comments;
import com.jsonplaceholder.testing.configuration.ApiApplicationConfig;
import com.jsonplaceholder.testing.posts.Posts;
import com.jsonplaceholder.testing.users.Users;
import com.jsonplaceholder.testing.utils.JsonFileReader;

@Tag("All")
@ContextConfiguration(classes = {ApiApplicationConfig.class})
@ExtendWith({SpringExtension.class})
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

	protected Users users;
	
	protected Posts posts;
	
	protected Comments comments;	
	
	protected SoftAssertions softAssert;
	
	protected JsonFileReader jsonReader;
	
	@BeforeAll
	public void beforeAll() {
		comments = new Comments();
		users = new Users();
		posts = new Posts();
		softAssert = new SoftAssertions();
		jsonReader = new JsonFileReader();
	}
	
}
