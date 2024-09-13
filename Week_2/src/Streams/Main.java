package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
	private static Student[] studentArray = {
            new Student("Carlos", 60, 70),
            new Student("Ana", 80, 85),
            new Student("Luis", 50, 55),
            new Student("Maria", 90, 95),
            new Student("Jose", 45, 50),
            new Student("Elena", 85, 80),
            new Student("Fernando", 100, 90),
            new Student("Lucia", 40, 45),
            new Student("Miguel", 55, 65),
            new Student("Sofia", 95, 90),
            new Student("Pablo", 30, 35),
            new Student("Andrea", 75, 80),
            new Student("Jorge", 65, 70),
            new Student("Clara", 60, 60),
            new Student("Alberto", 70, 75),
            new Student("Raquel", 85, 90),
            new Student("Manuel", 40, 45),
            new Student("Teresa", 80, 85),
            new Student("Pedro", 35, 40),
            new Student("Laura", 95, 100)
    };

	public static void main(String[] args) {

        // Print the initial list of students
        System.out.println("Initial list of students:");
        Arrays.stream(studentArray).forEach(System.out::println);

        // Create a list of students who pass
        List<Student> updatedStudents = Arrays.stream(studentArray)
        		.filter(s->(s.getGradePeriod1()+s.getGradePeriod2())/2.0 < 65)
        		.peek(s -> System.out.println("Didn´t pass: "+s))
        		.collect(Collectors.toList());
        //Add five points
        updatedStudents.forEach(s ->{
        	s.setGradePeriod1(s.getGradePeriod1()+5);
        	s.setGradePeriod2(s.getGradePeriod2()+5);
        	
        });
               
        // Sort the updated students by highest average
        List<Student> sortedStudents = Arrays.stream(studentArray)
                .sorted(Comparator.comparingDouble(
                        s -> -(s.getGradePeriod1() + s.getGradePeriod2()) / 2.0))
                .collect(Collectors.toList());

        // Get the top five students
        List<Student> top5Students = sortedStudents.stream()
                .limit(5)
                .collect(Collectors.toList());

        // Print the final list of top 5 students
        System.out.println("\nTop 5 Students by Average:");
        top5Students.forEach(System.out::println);
    }
}
