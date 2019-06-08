package com.rajesh.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

	// array for number words
	static String one[] = { "", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
			"eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ",
			"nineteen " };

	static String ten[] = { "", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
			"ninety " };
	
	

	public String convertNumber(long num) throws Exception {

		try {

			 // stores word representation of given number n  
	        String out = ""; 
	  
	        // handles digits at ten millions and hundred  
	        // millions places (if any)  
	        out += numToWordsConverter((int) (num / 10000000), "crore "); 
	  
	        // handles digits at hundred thousands and one  
	        // millions places (if any)  
	        out += numToWordsConverter((int) ((num / 100000) % 100), "lakh "); 
	  
	        // handles digits at thousands and tens thousands  
	        // places (if any)  
	        out += numToWordsConverter((int) ((num / 1000) % 100), "thousand "); 
	  
	        // handles digit at hundreds places (if any)  
	        out += numToWordsConverter((int) ((num / 100) % 10), "hundred "); 
	  
	        if (num > 100 && num % 100 > 0) { 
	            out += "and "; 
	        } 
	  
	        // handles digits at ones and tens places (if any)  
	        out += numToWordsConverter((int) (num % 100), ""); 
	  
	        return out; 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	static String numToWordsConverter(int num, String s) {
		String str = "";
		// if n is more than 19, divide it
		if (num > 19) {
			str += ten[num / 10] + one[num % 10];
		} else {
			str += one[num];
		}

		// if n is non-zero
		if (num != 0) {
			str += s;
		}

		return str;
	}

}
