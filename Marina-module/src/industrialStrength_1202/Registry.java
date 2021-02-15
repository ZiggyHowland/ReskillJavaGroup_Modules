package industrialStrength_1202;

import java.util.Collection;
import java.util.HashMap;

public class Registry {

    private HashMap<Integer, Student> students = new HashMap<>();
    int id = 1;

    public Student registerStudent(String name) {
        Student student = new Student(id, name);
        students.put(id++, student);
        return student;
    }

    public int getId() {
        return id;
    }

    public Collection<Student> getRegisteredStudents() {
        return students.values();
    }

    public Student findStudent(int studentId) {
        if (!students.containsKey(studentId)) {
            throw new IllegalArgumentException("Cannot find student with id " + studentId);
        } else {
            return students.get(studentId);
        }
    }

    public void unregisterStudent(int studentId) {
        if (!students.containsKey(studentId)) {
            throw new IllegalArgumentException("Cannot find student with id " + studentId);
        } else {
            students.remove(studentId);
        }
    }

}
