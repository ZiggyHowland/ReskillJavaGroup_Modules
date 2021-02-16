package testDrivenDevelopment_1602;

import java.io.Serializable;
//I get an error about not catching the exception if I don't implement Serializable and make a constructor with "inner"

public class QuestionException extends RuntimeException implements Serializable {

    public QuestionException() {
    }

    public QuestionException(String message) {
        super(message);
    }

    public QuestionException(String message, Exception inner) {
        super(message,inner);
    }

}
