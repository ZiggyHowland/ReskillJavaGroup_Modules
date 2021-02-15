package industrialStrength_1202;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class idMatcher extends TypeSafeMatcher<Integer> {


    @Override
    protected boolean matchesSafely(Integer studentId) {
        return studentId > 0 && studentId <5000;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("A valid student ID is positive and under 5 000. We have a capacity of 5000 student spots");
    }

    @Factory
    public static Matcher<Integer> isValidStudentId() {
        return new idMatcher();
    }

}
