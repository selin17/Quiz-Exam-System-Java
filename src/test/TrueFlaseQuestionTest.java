package test;

import model.TrueFalseQuestion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TrueFlaseQuestionTest {
	@Test
    void shouldReturnTrueWhenAnswerIsCorrect() {
        TrueFalseQuestion q =
                new TrueFalseQuestion("Java OOP?", "true", 5);

        assertTrue(q.checkAnswer("t"));
        assertTrue(q.checkAnswer("TRUE"));
    }

    @Test
    void shouldReturnFalseWhenAnswerIsWrong() {
        TrueFalseQuestion q =
                new TrueFalseQuestion("Java OOP?", "true", 5);

        assertFalse(q.checkAnswer("f"));
        assertFalse(q.checkAnswer("false"));
    }

    @Test
    void shouldReturnFalseForInvalidInput() {
        TrueFalseQuestion q =
                new TrueFalseQuestion("Java OOP?", "true", 5);

        assertFalse(q.checkAnswer("yes"));
        assertFalse(q.checkAnswer(""));
        assertFalse(q.checkAnswer(null));
    }
}


