package com.lti.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemoFour {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Stella");
		names.add("Priya");
		names.add("Peter");
		names.add("Stephen");
		
		List<String> upper = names.stream().map(u->u.toUpperCase()).collect(Collectors.toList());
		upper.forEach(System.out::println);

	}

}
