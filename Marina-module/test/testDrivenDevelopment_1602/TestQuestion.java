package testDrivenDevelopment_1602;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestQuestion {

    // ANDY: This fails because there's a bug in your vote() method. See my comment there. Just as well you found the bug in your test :-)
    @Test
    public void vote_questionVotedUp_voteIncremented() { //throws exception. "The question is closed and cannot be voted on" - Why?
        Question q = new Question("Math question", "Is 2+2 = 4", new User(1, "Marina", "msh@gmail.com"));
        q.vote(true);
        q.setOpen(true);
        assertEquals(1, q.getVotes());
    }

    // ANDY: Same problem as above.
    @Test
    public void vote_questionVotedUp_userRatingIncremented() { //throws exception. "The question is closed and cannot be voted on" - Why?
        Question q = new Question("Math question", "Is 2+2 = 4", new User(1, "Marina", "msh@gmail.com"));
        q.vote(true);
        assertEquals(10, q.getUser().rating);
    }

    @Test
    public void vote_questionVotedDown_voteDecremented() {
        Question q = new Question("Math question", "Is 2+2 = 4", new User(1, "Marina", "msh@gmail.com"));
        q.vote(false);
        assertEquals(-1, q.getVotes());
    }

    @Test
    public void vote_questionVotedDown_userRatingDecremented() {
        Question q = new Question("Math question", "Is 2+2 = 4", new User(1, "Marina", "msh@gmail.com"));
        q.vote(false);
        assertEquals(-10, q.getUser().rating);
    }

    @Test (expected = QuestionException.class)
    public void vote_questionClosed_throwException() {
        Question q = new Question("Math question", "Is 2+2 = 4", new User(1, "Marina", "msh@gmail.com"));
        q.setOpen(false);
        q.vote(true);
    }

}
