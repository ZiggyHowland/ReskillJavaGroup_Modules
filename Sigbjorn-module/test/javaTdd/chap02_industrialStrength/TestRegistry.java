package javaTdd.chap02_industrialStrength;

import javaTdd.chap02_IndustrialStrength.Registry;
import javaTdd.chap02_IndustrialStrength.Student;
import org.hamcrest.Matchers;
import org.junit.*;


//import static org.junit.Assert.assertThat;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class TestRegistry {
    Registry registry;

    @Before
    public void setup() {
        registry = new Registry();
        System.out.println("Before each test: " + Instant.now());
    }

    @Test
    public void newRegistry_withNoEntries_shouldReturnEmptyCollection() {
        assertThat(registry.getAllStudents(), Matchers.emptyCollectionOf(Student.class));
    }

    @Test
    public void registreringStudent_shouldReturnAStudentObject() {
        assertThat(registry.registerStudent("Alf"), Matchers.isA(Student.class));
    }

    @Test
    public void registeringStudent_withName_shouldReturnStudentObjectWithTheSameName() {
        Student s = registry.registerStudent("Alva");
        assertEquals("Alva", s.getName());
    }


    @Test
    public void findingStudent_afterRegistration_shouldReturnStudent() {
        Student s = registry.registerStudent("Sigbjørn");
//        assertThat(registry.getAllStudents(), Matchers.hasItem(s));
        String id = s.getId();
        assertEquals(s, registry.findStudent(id));
    }


    @Test(expected = RuntimeException.class)
    public void usingFindOnNewRegistry_withNoEntries_shouldReturnException() {
        registry.findStudent("AnyInput");
    }

    @Test(expected = RuntimeException.class)
    public void usingFindOnRegistry_withoutMatchingInput_shouldReturnException() {
        registry.registerStudent("Kåre");
        registry.findStudent("Olav");
    }




}
