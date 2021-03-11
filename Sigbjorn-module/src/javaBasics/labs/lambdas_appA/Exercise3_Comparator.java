package javaBasics.labs.lambdas_appA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise3_Comparator {
    
    public static void main(String[] args) {
        
        List<Person> people = Arrays.asList(
                                new Person("Lukasz Fabianski", 30, false),
                                new Person("Neil Taylor", 26, true),
                                new Person("Angel Rangel", 32, false),
                                new Person("Ashley Williams", 30, true));
        
        
        // Part 1: Create a Comparator<Person> first, and then pass it to sort().
        Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
        displayPeople("Sorted by age", people);
        
        
        // Part 2: Create a Comparator<Person> and pass it to sort()  directly.
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        displayPeople("Sorted by name", people);
    }
    
    // Helper method.
    private static void displayPeople(String msg, List<Person> people) {
        System.out.printf("\n%s\n", msg);
        for (Person p : people) {
            System.out.println("    " + p);
        }
    }
}

