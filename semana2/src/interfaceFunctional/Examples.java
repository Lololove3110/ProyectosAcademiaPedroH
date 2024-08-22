package interfaceFunctional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;


public class Examples {
	//This project is to show the capabilities functional programming has on java
	
	public static void main(String [] args) {
		
		System.out.println("****");
		System.out.println("Supplier");
		//1.- Supplier
		//Use when you want to generate or supply values. 
		//Date example. I generate a date value into localdate
		Supplier<LocalDate> s1 = () -> LocalDate.now();
		//Generates random number every time use .get() to RanNum
		Supplier<Integer> ranNum = () -> new Random().nextInt(100);
		//Generate random boolean
		Supplier<Boolean> ranBool = () -> new Random().nextBoolean();
		//Generate a list of strings
		Supplier<List<String>> StringListSup = () -> Arrays.asList("One","Two","Three");
		System.out.println("Date: "+s1.get()+" Random number: "+ranNum.get()+" Random Boolean: "+ ranBool.get()+" List of numbers: "+StringListSup.get());
		//without .get() prints memory´s space
		
		
		System.out.println("****");
		System.out.println("Consumer");

		
		//2.- Consumer
		// print string
		
		//add to a list
		
		//calculation
		
		//Iterating over a collection
		System.out.println("****");
		System.out.println("BiConsumer");
		//3.- Biconsumer
		//Print two strings
		
		//Product of two numbers
		
		//Add map entries
		
		//Concat two Strings
		System.out.println("****");
		System.out.println("Predicate");
		//4.- Predicate
		
		//Check if is a palindrome
		
		//Check if legal age
		
		//Check a letter in a String
		
		//Check if a list is empty
		
		
		
		
		
	
		
		
		
	}
	
	
	
	

}
