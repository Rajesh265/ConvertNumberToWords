package com.rajesh.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajesh.controller.ConvertWordsController;
import com.rajesh.service.ConverterService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ConverterService.class, ConvertWordsController.class })
public class ServiceTests {
	
	@Autowired
	ConverterService service;
	
	
	
	@Test
	public void test1() throws Exception {
		assertEquals("twelve lakh thirty four thousand five hundred and fifty six ", service.convertNumber(1234556l));
	}
	
	@Test
	public void test2() throws Exception {
		assertNotEquals("twelve lakh thirty four thousand six hundred and fifty six", service.convertNumber(1234556l));
	}
	
	

}
