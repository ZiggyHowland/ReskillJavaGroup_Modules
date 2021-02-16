package dnb.reskill.tom.TDDLabworkChapter3;

import lombok.Data;

import java.util.UUID;

@Data
public class Question {
    private UUID questionId;
    private int userID;
    private String title;
    private String message;
    private int votes=0;
    private int userIdentifier;
    private User userWhoOwnsQuestion;
    private static final int INCREMENT_RATING_VALUE_PER_VOTE=100;
    private boolean questionClosed=false;

    public void vote (boolean voteUp,User userWhoOwnsQuestion) throws ClosedQuestionException {
        if(voteUp) {
            if(questionClosed)
                throw new ClosedQuestionException("Question is closed");
            votes++;
            userWhoOwnsQuestion.setRating(userWhoOwnsQuestion.getRating()+INCREMENT_RATING_VALUE_PER_VOTE);
        }
        else {
            if(questionClosed)
                throw new ClosedQuestionException("Question is closed");
            votes--;
            userWhoOwnsQuestion.setRating(userWhoOwnsQuestion.getRating()-INCREMENT_RATING_VALUE_PER_VOTE);

        }
    }

}
