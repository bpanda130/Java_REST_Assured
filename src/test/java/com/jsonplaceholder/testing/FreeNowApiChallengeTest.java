package com.jsonplaceholder.testing;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;


@Tag("AssignmentTask")
public class FreeNowApiChallengeTest extends BaseTest {

	protected static Logger LOG = Logger.getLogger(FreeNowApiChallengeTest.class);

	@Value("${searchUser}")
	private String searchUserName;

	@Test
	@DisplayName("Validate the format of Emails in comments section for all posts of a user")
	public void testValidateFormatOfEmailsInCommentsSectionForAllPostsOfAUser() {

		users.getResponseByUserName(searchUserName);
		List<Integer> userIdList = users.getListOfValuesOfIDInResponse();
		for (Integer userId : userIdList) {
			posts.getResponseByUserID(userId.toString());
			List<Integer> postIdList = posts.getListOfValuesOfPostIDInResponse();

			for (Integer PostId : postIdList) {
				comments.getResponseByPostID(PostId.toString());
				List<String> emails = comments.getListOfValuesOfEmailsInResponse();
				emails.stream().forEach(email -> Assert.assertTrue(comments.isValid(email)));
			}
		}

	}

}
