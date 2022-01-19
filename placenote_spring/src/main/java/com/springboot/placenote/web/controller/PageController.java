package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.placenote.config.auth.PrincipalDetails;

@Controller
public class PageController {

	@GetMapping({ "/", "/index" })
	public String indexPage(@AuthenticationPrincipal PrincipalDetails principalDetails) {

		return "index";
	}

	@GetMapping("/auth/signin")
	public String signinPage() {
		return "/auth/signin";
	}

	@GetMapping("/auth/signup")
	public String signupPage() {
		return "/auth/signup";
	}

	@GetMapping("/feed/my_feed")
	public String MyfeedPage() {
		return "/feed/my_feed";

	}

	@GetMapping("/feed/my_feedImg")
	public String MyfeedImgPage() {
		return "/feed/my_feedImg";

	}

	@GetMapping("/feed/feed")
	public String feedPage() {
		return "/feed/feed";
	}

	@GetMapping("/feed/feedImg")
	public String feedImg() {
		return "/feed/feedImg";
	}

	@GetMapping("follow/follow")
	public String follow() {
		return "follow/follow";
	}

	@GetMapping("follow/following")
	public String following() {
		return "follow/following";
	}

}
