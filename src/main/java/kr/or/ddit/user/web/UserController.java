package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.model.UserValidator;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.FileInfo;
import oracle.jdbc.proxy.annotation.GetProxy;

@RequestMapping("user/")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userService")
	private IUserService userService;
	
	/**
	* Method : userView
	* 작성자 : PC-17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 상세화면 요청
	*/
	// 사용자가 localhost:8081/spring/user/view.do
	@RequestMapping("view.do")
	public String userView() {
		logger.debug("userController.userView()");
		
		return "user/view";
		
		// prefix + viewName + suffix
		// WEB-INF/views/user/view.jsp
	}
	
	/**
	* Method : userList
	* 작성자 : PC-17
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@RequestMapping(path="userList", method=RequestMethod.GET)
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		
		return "user/userList";
	}
	
	/**
	* Method : userListOnlyHalf
	* 작성자 : PC-17
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : 사용자 리스트 50명 조회
	*/
	@RequestMapping(path="userListOnlyHalf", method=RequestMethod.GET)
	public String userListOnlyHalf(Model model) {
		model.addAttribute("userList", userService.getUserListOnlyHalf());
		
		return "user/userListOnlyHalf";
	}
	
	/**
	* Method : userPagingList
	* 작성자 : PC-17
	* 변경이력 :
	* @param model
	* @param page
	* @return
	* Method 설명 : 페이징된 사용자 리스트 조회
	*/
	@RequestMapping(path= {"userPagingList", "list"}, method=RequestMethod.GET)
	public String userPagingList(Model model, Page page) {
		model.addAttribute("pageVo", page);
		model.addAllAttributes(userService.getUserPagingList(page));
		
		return "user/userPagingList";
	}
	
	/**
	* Method : userDetail
	* 작성자 : PC-17
	* 변경이력 :
	* @param model
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	@GetMapping("detail")
	public String userDetail(Model model, String userId) {
		model.addAttribute("user", userService.getUser(userId));
		
		return "user/user";
	}
	
	/**
	* Method : picture
	* 작성자 : PC-17
	* 변경이력 :
	* @param userId
	* @param response
	* @return
	* @throws IOException
	* Method 설명 : 사용자 사진 조회
	*/
	@GetMapping("picture/{userId}")
	public void picture(@PathVariable(name="userId") String userId, HttpServletResponse response) throws IOException {
		String path = userService.getUser(userId).getRealfilename();
		File picture = new File(path);
		
		ServletOutputStream sos = response.getOutputStream();
		FileImageInputStream fis = new FileImageInputStream(picture);
		
		byte[] buff = new byte[512];
		int len = 0;
		
		while ( (len = fis.read(buff, 0, buff.length)) != -1 ) {
			sos.write(buff, 0, len);
		}
		
		fis.close();
		sos.close();
	}
	
	/**
	* Method : userFormView
	* 작성자 : PC-17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 등록 화면 요청
	*/
	@RequestMapping(path="userForm", method=RequestMethod.GET)
	public String userFormView() {
		 return "user/userForm";
	}
	
	/**
	 * Method : userFormView
	 * 작성자 : PC-17
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 등록 요청
	 */
	@RequestMapping(path="userForm", method=RequestMethod.POST)
	public String userForm(User user, BindingResult result, @RequestPart("picture") MultipartFile picture) {
		
		new UserValidator().validate(user, result);
		
		if (result.hasErrors()) {
			return "user/userForm";
		}
		
		FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());

		// 첨부된 파일이 있을 경우만 업로드 처리
		if (picture.getSize() > 0) {
			try {
				picture.transferTo(fileInfo.getFile());
				user.setFilename(fileInfo.getOriginalFileName());
				user.setRealfilename(fileInfo.getFile().getPath());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		int insertCnt = userService.insertUser(user);
		
		if (insertCnt == 1) {
			return "redirect:/user/detail?userId=" + user.getUserId();
		} else {
			return "user/userForm";
		}
	}
	
	@GetMapping("modify/{userId}")
	public String modify(Model model, @PathVariable(name="userId") String userId) {
		model.addAttribute("user", userService.getUser(userId));
		
		return "user/userModify";
	}
	
	@PostMapping("modify")
	public String modifyPost(Model model, User user, BindingResult result, @RequestPart("picture") MultipartFile picture) {
		FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());
		
		User origin = userService.getUser(user.getUserId());
		
		user.setFilename(origin.getFilename());
		user.setRealfilename(origin.getRealfilename());

		// 첨부된 파일이 있을 경우만 업로드 처리
		if (picture.getSize() > 0) {
			try {
				picture.transferTo(fileInfo.getFile());
				user.setFilename(fileInfo.getOriginalFileName());
				user.setRealfilename(fileInfo.getFile().getPath());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		int insertCnt = userService.updateUser(user);
		
		if (insertCnt == 1) {
			return "redirect:/user/detail?userId=" + user.getUserId();
		} else {
			model.addAttribute("user", user);
			return "user/modify/";
		}
	}
}
