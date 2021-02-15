package industrialStrength_1202;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TestRegistry {

    Registry fixture;
    Student marina, ole, janne;

    @Before
    public void setup() {
        fixture = new Registry();
        marina = fixture.registerStudent("Marina");
        ole = fixture.registerStudent("Ole");
        janne = fixture.registerStudent("Janne");
    }

    @Test
    public void createRegistry_noStudentsInitially() {
        Registry emptyRegistry = new Registry();
        assertThat(emptyRegistry.getRegisteredStudents(), empty());
    }

    @Test
    public void registerStudent_addTwo_correctlyAssignedId() {
        assertThat(marina.getId(),equalTo(1));
        assertThat(ole.getId(),equalTo(2));
        assertThat(janne.getId(),equalTo(3));
    }

    @Test
    public void findStudent_studentsExists_returnStudents() {
        assertThat(fixture.findStudent(1), sameInstance(marina));
        assertThat(fixture.findStudent(3), sameInstance(janne));
    }

    @Test (expected = IllegalArgumentException.class)
    public void findStudent_studentDoNotExists_throwsException() {
        fixture.findStudent(13);
    }

    @Test
    public void unregisterStudent_studentExists_removeStudents() {
        fixture.unregisterStudent(2);
        assertThat(fixture.getRegisteredStudents(), contains(marina,janne));
    }

    @Test (expected = IllegalArgumentException.class)
    public void unregisterStudent_studentDoNotExists_throwException() {
        fixture.unregisterStudent(5);
    }

}
