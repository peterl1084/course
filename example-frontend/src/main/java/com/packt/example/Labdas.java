package com.packt.example;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Labdas {

	public static void main(String... args) {
		Predicate<Person> ageCheck = p -> p.getAge() > 18;
		BiPredicate<Person, Integer> paramAgeCheck = (p, a) -> p.getAge() >= a;
		
		printPersons(p -> p.getAge() >= 18, p("a", 17), p("b", 21));
	}

	public static void printPersons(Predicate<Person> predicate,
			Person... persons) {
		Arrays.asList(persons).stream().filter(predicate)
				.map(p -> p.getName() + " " + p.getAge())
				.forEach(System.out::println);
	}

	public static Person p(String name, int age) {
		return new Person(name, age);
	}

	private static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}
}
