package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bo.UserInfoBo;
import model.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserInfoBo userInfoBo;

	@Autowired
	public UserController(UserInfoBo userInfoBo) {
		this.userInfoBo = userInfoBo;
	}

	@GetMapping("/info")
	public String getUserInfo(@RequestParam String userId, ModelMap model) {
		UserInfo userInfo = userInfoBo.getUserInfo(userId);
		userInfo = userInfoBo.getUserInfo(userId);
		model.addAttribute("key", "UserInfo");
		model.addAttribute("value", userInfo);
		return "userInfo";
	}

	@GetMapping("/name")
	public String getUserName(@RequestParam String userId, ModelMap model) {
		String userName = userInfoBo.getUserName(userId);
		userName = userInfoBo.getUserName(userId);
		model.addAttribute("key", "UserName");
		model.addAttribute("value", userName);
		return "userInfo";
	}

	@GetMapping("/age")
	public String getUserAge(@RequestParam String userId, ModelMap model) {
		int userAge = userInfoBo.getUserAge(userId);
		userAge = userInfoBo.getUserAge(userId);
		model.addAttribute("key", "UserAge");
		model.addAttribute("value", userAge);
		return "userInfo";
	}
}