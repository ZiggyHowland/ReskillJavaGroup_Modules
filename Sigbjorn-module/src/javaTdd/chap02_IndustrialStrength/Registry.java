package javaTdd.chap02_IndustrialStrength;

import java.util.Collection;
import java.util.HashMap;

public class Registry {
    HashMap<String, Student> students;

    public Registry() {
        students = new HashMap<>();
    }

    public Student registerStudent(String name) {
        String key = name.substring(0,2).toUpperCase();
        Student value = new Student(key, name);
        students.put(key, value);
        return value;
    }

    public Student findStudent(String id) {
        if (students.containsKey(id)) {
            return students.get(id);
        }
        else {
            throw new RuntimeException("Student key not found. Cannot find student.");
        }
    }

    public Collection<Student> getAllStudents() {
        //if (students.isEmpty()) {
        //    throw new RuntimeException("Empty list. Cannot return all students.");
        //}
        //else {
            return students.values();
        //}
    }


    public void unregisterStudent(String id) {
        if (students.containsKey(id)) {
            students.remove(id);
        }
        else {
            throw new RuntimeException("Student key not found. Cannot unregister.");
        }
    }


}


