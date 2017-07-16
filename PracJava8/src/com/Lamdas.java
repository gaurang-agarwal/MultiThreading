package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lamdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> nameList = Arrays.asList(new String []{"A","B","C","D","E","F"});
		
		nameList.stream().filter(s -> {System.out.println(s); return s.equals("A");}).count();
		
		List<Student> studentList = new ArrayList<Student>();
		for(int i=0;i<15;i++)
		{
			studentList.add(new Student("Student"+i, i%5));
		}
		
		
		//studentList.stream().collect( Collectors.groupingBy(student -> student.getAge(),Collectors.mapping(student1 -> student1.getName(), Collectors.toList()))).entrySet().forEach(e -> System.out.println(e.toString()) );
		
		studentList.stream().collect( Collectors.groupingBy(student -> student.getAge(),Collectors.counting())).entrySet().forEach(e -> System.out.println(e.toString()));
		
		
	}

	
	
	static class Student 
	{
		private int age;
		private String name;
		public Student(String name,int age) {
			this.age=age;
			this.name=name;
		}
		
		public String getName()
		{
			return name;
		}
		public int getAge()
		{
			return age;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name+":"+age;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			System.out.println("called");
			return this.age==((Student)obj).getAge();
			
		}
	}
	
}
