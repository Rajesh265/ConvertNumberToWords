package com.rajesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.service.ConverterService;

@RestController
public class ConvertWordsController {
	@Autowired
	ConverterService service;

	@RequestMapping(value = "/getWords", method = RequestMethod.GET, produces = "application/json")
	public String convertNumber(@RequestParam(value = "num", defaultValue = "0") long num) {
		try {
			String words = service.convertNumber(num);
			System.out.println(words);
			return words;
		} catch (Exception e) {
			System.out.println("Some expection occured");
		}
		return "Please try after some time";
	}

}
