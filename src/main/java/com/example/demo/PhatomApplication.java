package com.example.demo;

import com.example.demo.service.Phantom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/")
@Controller
@SpringBootApplication
public class PhatomApplication {

	@Autowired
	private Phantom phantom;

	public static void main(String[] args) {
		SpringApplication.run(PhatomApplication.class, args);
	}

	@RequestMapping("/capture")
	@ResponseBody
	public String capture(String url, String componentId){
		String result = "";
		phantom.setUrl(url);
		phantom.setComponentId(componentId);
		try {
			result = phantom.executeJs();
		} catch (IOException e) {
			result = "failure";
			e.printStackTrace();
		}
		return result;
	}
}
