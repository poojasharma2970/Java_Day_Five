package com.lti.streams;

import java.util.ArrayList;
import java.util.List;

public class StringDemoOne {

	public static void main(String[] args) {
		long count = 1;
		List<String> names = new ArrayList<String>();
		names.add("Stella");
		names.add("Priya");
		names.add("Stephen");
		
		for(String s:names) {
			if(s.length()>5) {
				System.out.println(count++);
			}
		}
		
		

	}

}
