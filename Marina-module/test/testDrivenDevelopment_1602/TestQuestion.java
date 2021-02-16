package testDrivenDevelopment_1602;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestQuestion {

    Question q;

    @Before
    public void setup() {
        q = new Question("Math question", "Is 2+2 = 4", new User(1, "Marina", "msh@gmail.com"));
    }

    @Test
    public void vote_questionVotedUp_voteIncremented() {
        q.vote(true);
        q.setOpen(true);
        assertEquals(1, q.getVotes());
    }

    @Test
    public void vote_questionVotedUp_userRatingIncremented() {
        q.vote(true);
        assertEquals(10, q.getUser().rating);
    }

    @Test
    public void vote_questionVotedDown_voteDecremented() {
        q.vote(false);
        assertEquals(-1, q.getVotes());
    }

    @Test
    public void vote_questionVotedDown_userRatingDecremented() {
        q.vote(false);
        assertEquals(-10, q.getUser().rating);
    }

    @Test (expected = QuestionException.class)
    public void vote_questionClosed_throwException() {
        q.setOpen(false);
        q.vote(true);
    }

}
