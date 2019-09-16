package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.user.model.User;

public class UserServiceTest extends RootTestConfig {

	@Resource(name="userService")
	private IUserService userService;
	
	@Test
	public void getUserListTest() {
		/***Given***/

		/***When***/
		List<User> userList = userService.getUserList();

		/***Then***/
		assertTrue(userList.size() >= 105);
	}

	@Test
	public void getUserTest() {
		/***Given***/

		/***When***/
		User user = userService.getUser("brown");

		/***Then***/
		assertNotNull(user);
	}

	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/

		/***When***/
		List userList = userService.getUserListOnlyHalf();

		/***Then***/
		assertEquals(50, userList.size());
	}

	@Test
	public void getUserPagingListTest() {
		/***Given***/

		/***When***/
		List userList = userService.getUserPagingList(new Page(2, 10));

		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid13", ((User) userList.get(0)).getUserId());
	}

	@Test
	public void getUserTotalCntTest() {
		/***Given***/

		/***When***/
		int cnt = userService.getUserTotalCnt();

		/***Then***/
		assertTrue(cnt == 105);
	}

	@Test
	public void insertUserTest() {
		/***Given***/

		/***When***/
		int cnt = userService.getUserTotalCnt();
		int success = userService.insertUser(new User("delete", "", "", new Date(), "", "", "", "", "", ""));

		/***Then***/
		assertEquals(1, success);
		assertEquals(1, userService.getUserTotalCnt() - cnt);
	}

	@Test
	public void deleteUserTest() {
		/***Given***/

		/***When***/
		int cnt = userService.getUserTotalCnt();
		int success = userService.deleteUser("brown");

		/***Then***/
		assertEquals(1, success);
		assertEquals(1, cnt - userService.getUserTotalCnt());
	}

	@Test
	public void updateUserTest() {
		/***Given***/

		/***When***/
		User user = new User("brown", "hello", "", new Date(), "", "", "", "", "", "");
		int cnt = userService.updateUser(user);
		User updatedUser = userService.getUser("brown");

		/***Then***/
		assertEquals(1, cnt);
		assertEquals("hello", updatedUser.getUserNm());
	}
}
