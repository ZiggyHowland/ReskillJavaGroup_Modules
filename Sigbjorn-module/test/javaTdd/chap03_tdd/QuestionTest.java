package javaTdd.chap03_tdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class QuestionTest {
    private Question q;

    @Before
    public void setupTest() {
        // Arrange
        q = new Question();
    }

    @Test
    public void votesShouldBeIncrementedWhenQuestionIsVotedOn () {
        // Act
        q.vote(Question.VoteType.UP);

        // Assert
        assertEquals(1, q.getVotes());
    }


    @Test
    public void userRatingsShouldBeIncrementedWhenQuestionIsVotedOn() {
        // Act
        q.vote(Question.VoteType.UP);

        //Assert
        assertEquals(2, q.getUser().getRating());
    }

    @Test
    public void questionVotesAndUserRatingsShouldBeIncrementedWhenVotedUp() {
        q.vote(Question.VoteType.UP);
        assertTrue(q.getVotes() == 1 && q.getUser().getRating() == 2 );
    }

    @Test
    public void questionVotesAndUserRatingsShouldBeDecreasedWhenVotedDown() {
        q.vote(Question.VoteType.DOWN);
        assertTrue(q.getVotes() == -1 && q.getUser().getRating() == -2);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test // (expected = QuestionException.class)
    public void votingOnClosedQuestionShouldReturnAnException() {
        exceptionRule.expect(QuestionException.class);
        exceptionRule.expectMessage("The question is closed. No voting allowed.");
        q.setClosed(true);
        q.vote(Question.VoteType.UP);
    }



}