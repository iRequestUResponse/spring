package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:kr/or/ddit/config/spring/context-root.xml",
		"classpath:kr/or/ddit/config/spring/context-datasource.xml",
		"classpath:kr/or/ddit/config/spring/context-transaction.xml"
		})
public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	// userDao를 테스트하기 위해 필요한 것
	// db 연결, 트랜잭션, dao
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	@Test
	public void getUserListTest() {
		/***Given***/

		/***When***/
		List<User> userList = userDao.getUserList();

		/***Then***/
		assertTrue(userList.size() > 105);
	}

	@Test
	public void getUserTest() {
		/***Given***/

		/***When***/
		User user = userDao.getUser("brown");
		logger.debug("brown : {}", user);

		/***Then***/
		assertNotNull(user);
	}

	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/

		/***When***/
		List userList = userDao.getUserListOnlyHalf();

		/***Then***/
		assertEquals(50, userList.size());
	}

	@Test
	public void getUserPagingListTest() {
		/***Given***/

		/***When***/
		List userList = userDao.getUserPagingList(new Page(2, 10));

		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid12", ((User) userList.get(0)).getUserId());
	}

	@Test
	public void getUserTotalCntTest() {
		/***Given***/

		/***When***/
		int cnt = userDao.getUserTotalCnt();

		/***Then***/
		assertTrue(cnt > 105);
	}

	@Test
	public void insertUserTest() {
		/***Given***/

		/***When***/
		int cnt = userDao.getUserTotalCnt();
		int success = userDao.insertUser(new User("delete", "", "", new Date(), "", "", "", "", "", ""));

		/***Then***/
		assertEquals(1, success);
		assertEquals(1, userDao.getUserTotalCnt() - cnt);
	}

	@Test
	public void deleteUserTest() {
		/***Given***/

		/***When***/
		int cnt = userDao.getUserTotalCnt();
		int success = userDao.deleteUser("delete");

		/***Then***/
		assertEquals(1, success);
		assertEquals(1, cnt - userDao.getUserTotalCnt());
	}

	@Test
	public void updateUserTest() {
		/***Given***/

		/***When***/
		User user = new User("delete", "hello", "", new Date(), "", "", "", "", "", "");
		logger.debug("user : {}", user);
		int cnt = userDao.updateUser(user);
		User updatedUser = userDao.getUser("delete");

		/***Then***/
		assertEquals(1, cnt);
		assertEquals("hello", updatedUser.getUserNm());
	}
}
