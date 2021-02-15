package javaTdd.chap03_tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    @Test
    public void votesShouldBeIncrementedWhenQuestionIsVotedOn () {
        // Arrange
        Question q = new Question();

        // Act
        q.vote();

        // Assert
        assertEquals(1, q.getVotes());
    }


    @Test
    public void userRatingsShouldBeIncrementedWhenQuestionIsVotedOn() {
        // Arrange
        Question q = new Question();

        // Act
        q.vote();

        //Assert
        assertEquals(2, q.getUser().getRating());
    }

}