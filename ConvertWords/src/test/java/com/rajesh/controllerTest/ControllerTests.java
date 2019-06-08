package com.rajesh.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajesh.controller.ConvertWordsController;
import com.rajesh.service.ConverterService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ConverterService.class, ConvertWordsController.class })
public class ControllerTests {
	
	@MockBean
	ConverterService service;
	
	@Autowired
	ConvertWordsController controller;
	
	
	
	@Test
	public void test1() throws Exception {
		doReturn("twelve lakh thirty four thousand five hundred and fifty six ").when(service).convertNumber(anyInt());
		assertEquals("twelve lakh thirty four thousand five hundred and fifty six ", controller.convertNumber(1234556l));
	}
	
	@Test
	public void test2() throws Exception {
		doReturn("twelve lakh thirty four thousand five hundred and fifty seven ").when(service).convertNumber(anyInt());
		assertNotEquals("twelve lakh thirty four thousand six hundred and fifty six ", controller.convertNumber(1234556l));
	}
	
	
	@Test
	public void test3() throws Exception {
		doReturn("Please try after some time").when(service).convertNumber(anyInt());
		assertEquals("Please try after some time", controller.convertNumber(12345568888l));
	}
	

}
