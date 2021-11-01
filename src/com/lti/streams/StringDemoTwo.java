package com.lti.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringDemoTwo {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Stella Micheal", "Sheela John","Preethi","Dhivya");
		List<String> longnames = names.stream().filter(str-> str.length()>5 && str.length()<10).collect(Collectors.toList());
	
//		for(String s : longnames) {
//			System.out.println(s);
//		}
		longnames.forEach(System.out::println);
	}

}
