package com.packt.example;

import java.util.function.Function;

public class SimpleExample {

	public static void main(String... args) {
		Function<Integer, Integer> powerOfTwo = n -> (int)Math.pow(2, n);
		
		System.out.println(powerOfTwo.apply(4));
	}
}
