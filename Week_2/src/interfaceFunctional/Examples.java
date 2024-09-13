package interfaceFunctional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.*;
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
		// print some strings
		Consumer<String> printCons = str1 -> System.out.println(str1);
		printCons.accept("1.- i´m learning java");
		printCons.accept("2.- java is fun");
		
		//add to a list
		List<Integer> list = new ArrayList<>();
		Consumer<Integer> addToList = i -> list.add(i);
		addToList.accept(10);
		addToList.accept(15);
		addToList.accept(20);
		System.out.println(list);
		
		
		//number to Square
		Consumer<Integer> GetSquare = n -> System.out.println("Square: " + (n*n));
		GetSquare.accept(4);
		
		
		//Iterating over a collection
		List<String> list1 = Arrays.asList("a","e","i","o","u");
		Consumer<String> Check = l -> System.out.println("Check list: " + l);
		list1.forEach(Check);
		
		
		System.out.println("****");
		System.out.println("BiConsumer");
		//3.- Biconsumer
		//Print name and age
		BiConsumer<String, Integer> GetPerson = (str2, int2) -> System.out.println("Your name is: "+str2+" and your age is: "+int2);
		GetPerson.accept("Pedro", 22);
		
		//Product of two numbers
		BiConsumer<Integer, Integer> productOfTwo = (i1, i2) -> System.out.println("Product of: " +i1+" and " +i2+" = "+(i1*i2));
		productOfTwo.accept(2, 4);
		
		
		//Add map entries
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> addToMap = (key, value) -> map.put(key, value);
		addToMap.accept("HeadPhones", 1500);
		addToMap.accept("Computer",18000);
		System.out.println(map);
		
		//Concat two Strings
		StringBuilder sb1 = new StringBuilder("I´m good ");
		BiConsumer<StringBuilder, String> appendStr = (sb, str) -> sb.append(str);
		appendStr.accept(sb1, "at Java");
		System.out.println(sb1);
		
		
		
		System.out.println("****");
		System.out.println("Predicate");
		//4.- Predicate

		//Check if is a palindrome
		Predicate<String> isPalindrome = s -> new StringBuilder(s).reverse().toString().equals(s);
		System.out.println("is kayak a palindrome?: "+isPalindrome.test("kayak")+" is wolf a palindrome?: "+isPalindrome.test("wolf"));
		
		//Check if legal age 
		Predicate<Integer> CheckAge = n -> n>=16;
		System.out.println("Peter has 17 years old, Peter is allowed to drive: "+CheckAge.test(17)+" Alex has 12 years old, Alex is allowed to drive: "+CheckAge.test(12));
		//Check a letter in a String
		Predicate<String> CheckLetter = l -> l.contains("A") || l.contains("a");
		System.out.println("Have an a?"+" Accenture: "+CheckLetter.test("Accenture")+" apple: "+CheckLetter.test("apple")+" Project: "+CheckLetter.test("Project"));
		
		//Check if is even
		Predicate<Integer> GetEven = i -> i % 2 == 0;
		
		System.out.println("is 3 even?: "+GetEven.test(3));
		System.out.println("is 4 even?: "+GetEven.test(4));

		
		
		System.out.println("****");
		System.out.println("BiPredicate");
		
		//5.-BiPredicate
		//Check if sum is equal or greater than 100
		BiPredicate<Integer, Integer> CheckSum = (n1,n2) -> (n1+n2) >= 100;
		System.out.println("The sum of 50 and 34 is greater than 100? "+CheckSum.test(50,34)+" The sum of 60 and 70 is greater than 100? "+CheckSum.test(60, 70));
		//Check if two words are the same
		BiPredicate<String,String> CheckStr = (str1,str2) -> str1.equals(str2);
		System.out.println("Are the words: any, any the same? "+CheckStr.test("any", "any")+" Are the words: any, anything the same? "+CheckStr.test("any","anything"));
		//Check if two numbers are the same
		BiPredicate<Integer,Integer> CheckNum = (n1,n2) -> n1.equals(n2);
		System.out.println("The numbers: 2,2 are the same? "+CheckNum.test(2, 2)+" The numbers: 2,3 are the same? "+CheckNum.test(2, 3));
		//Check if the division is an integer number
		BiPredicate<Integer,Integer> divideNum = (n1,n2) -> (n1%n2)==0;
		System.out.println(divideNum.test(2, 3));
		
		
		
		System.out.println("****");
		System.out.println("Function");
		//6.-Function
		//Delete spaces out the sentence 
		Function<String,String> deleteSpace = strf -> strf.trim();
		System.out.println("   I like java     "+" Delete space: "+deleteSpace.apply("   I like java     "));
		//Add int to string
		Function<String,Integer> strToInt = nd -> Integer.parseInt(nd);
		System.out.println("Change 1 from str to int and then sum 2: "+(strToInt.apply("1")+2));
		//Check the size of a word
		Function<String,Integer> strLen = str -> str.length();
		System.out.println("The word ¨java¨ has "+strLen.apply("java")+" letters");
		//Converts a string to lower case string only
		Function<String,String> toLow = s -> s.toLowerCase();
		System.out.println("Converts str to lowcase, HELLO WORLD: "+toLow.apply("HELLO WORLD"));
		
		System.out.println("****");
		System.out.println("BiFunction");
		//7.- BiFunction
		//concat
		BiFunction<String,String,String> concatStr = (str1,str2) -> str1.concat(str2);
		System.out.println("Concat ¨para¨, ¨meter¨: "+ concatStr.apply("para", "meter"));
		//take two str numbers, converts to int and add them
		BiFunction<String,String,Integer> sumOfStr = (n1,n2) -> Integer.parseInt(n1)+Integer.parseInt(n2);
		System.out.println("Str 40 and 55 added are: "+sumOfStr.apply("40", "55"));
		//add a number to a len
		BiFunction<String, Integer, Integer> addToLen = (str, num) -> str.length() + num;
		System.out.println("Add a number to a len of a word ¨java¨"+addToLen.apply("Java", 5));
		//Max between two numbers
		BiFunction<Integer,Integer,Integer> max = (a,b) -> Math.max(a,b);
		System.out.println("Max between two numbers: 20,40: "+max.apply(20, 40));
		
		System.out.println("****");
		System.out.println("UnaryOperator");
		//8.-UnaryOperator
		//increment n + 1
		UnaryOperator<Integer> Increment = n ->  n + 1;
		System.out.println("increment n(6) + 1"+Increment.apply(6));
		//getting absolute value
		UnaryOperator<Integer> abs = n -> Math.abs(n);
		System.out.println("The absolute value of -12 is: " + abs.apply(-12));
		//returning a square root
		UnaryOperator <Double> sqrt = n -> Math.pow(n, 0.5);
		System.out.println("The square root of 2 is: "+sqrt.apply(2.0));
		//Reversing a string
		UnaryOperator <String> reversed = str -> new StringBuilder(str).reverse().toString();
		System.out.println("Java revered is: "+reversed.apply("Java"));
		//9.- BinaryOperator
		System.out.println("****");
		System.out.println("BinaryOperator");
		//Longest string
		BinaryOperator<String> longestStr = (str1,str2) -> str1.length() >= str2.length() ? str1:str2;
		System.out.println("The longest word between Java and Python is: "+longestStr.apply("Java", "Python"));
		//Concat
		BinaryOperator<String> ConcatBIop = (str1,str2) ->str1.concat(str2);
		System.out.println("Concat ¨sol¨, ¨ution¨: "+ConcatBIop.apply("sol","ution"));
		//multipy
		BinaryOperator <Integer> multBiOp = (n1,n2) -> n1 * n2;
		System.out.println("5 * 98 = " +multBiOp.apply(5, 98));
		//Testing bool
		BinaryOperator<Boolean> testBool = (b1,b2) -> b1 && b2;
		System.out.println("Testing: True,True: "+testBool.apply(true, true)+" Testing: True,False "+testBool.apply(true, false));

		
 
		

		
		
		



	



		

	}
	
	
	
	

}
