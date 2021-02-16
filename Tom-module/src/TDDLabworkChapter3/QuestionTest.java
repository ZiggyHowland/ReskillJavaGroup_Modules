package dnb.reskill.tom.TDDLabworkChapter3;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {
    private Question q;
    private User testUser;

    @Before
    public void setUp() {

        q = new Question();
        testUser = new User();
    }
    @Test
    public void votes_Should_Be_Incremented_When_Question_Is_Voted_On()throws ClosedQuestionException {

        // Arrange

        boolean voteUp = true;
        // Act
        q.vote(voteUp,testUser);

        // Assert
        assertEquals(1, q.getVotes());
    }
    @Test
    public void votes_Should_Be_Decreased_When_Question_Is_Vote_Down() throws ClosedQuestionException{
        // Arrange
        boolean voteUp = false;
        // Act
        q.vote(voteUp,testUser);
        // Assert
        assertEquals(-1, q.getVotes());
    }
    @Test
    public void question_userRating_increase_when_voted_up() throws ClosedQuestionException{
        boolean voteUp = true;
        q.vote(voteUp,testUser);
        assertEquals(100,testUser.getRating());
    }
    @Test
    public void question_userRating_decrease_when_votedDown() throws ClosedQuestionException{
        boolean voteUp = false;
        q.vote(voteUp,testUser);
        assertEquals(-100,testUser.getRating());

    }
    @Test
    public void question_initially_NOT_closed() throws ClosedQuestionException{
        q.vote(true,testUser);
        assertEquals(q.isQuestionClosed(),false);
    }
    @Test
    public void question_possibility_to_be_closed() throws ClosedQuestionException{
        q.vote(true,testUser);
        q.setQuestionClosed(true);
        assertEquals(q.isQuestionClosed(),true);
    }
    @Test(expected=ClosedQuestionException.class)
    public void question_fail_when_trying_to_vote_on_closed_question() throws ClosedQuestionException{
        q.setQuestionClosed(true);
        q.vote(true,testUser);


    }
}
