package kr.or.ddit.user.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.config.test.WebTestConfig;

public class UserControllerTest extends WebTestConfig {
	
	/**
	* Method : userListTest
	* 작성자 : PC-17
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	 * @throws Exception 
	*/
	@Test
	public void userListTest() throws Exception {
		mockMvc.perform(get("/user/userList"))
			.andExpect(model().attributeExists("userList"))
			.andExpect(view().name("user/userList"));
	}
	
	/**
	 * Method : userListTest
	 * 작성자 : PC-17
	 * 변경이력 :
	 * Method 설명 : 사용자 50명 리스트 조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void userListOnlyHalfTest() throws Exception {
		mockMvc.perform(get("/user/userListOnlyHalf"))
		.andExpect(model().attributeExists("userList"))
		.andExpect(view().name("user/userListOnlyHalf"));
	}
	
	/**
	 * Method : userListTest
	 * 작성자 : PC-17
	 * 변경이력 :
	 * Method 설명 : 사용자 전체 리스트 조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void userPagingListTest() throws Exception {
		mockMvc.perform(get("/user/userPagingList"))
		.andExpect(model().attributeExists("userList"))
		.andExpect(view().name("user/userPagingList"));
	}
}
