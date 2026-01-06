package test;
import model.MultipleChoiceQuestion;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MultipleChoiceQuestionTest {
	@Test
    void shouldReturnTrueForCorrectChoice() {
        MultipleChoiceQuestion q =
                new MultipleChoiceQuestion(
                        "Keyword?",
                        "class",
                        List.of("class", "dog", "apple"),
                        10
                );

        assertTrue(q.checkAnswer("A"));
    }

    @Test
    void shouldReturnFalseForWrongChoice() {
        MultipleChoiceQuestion q =
                new MultipleChoiceQuestion(
                        "Keyword?",
                        "class",
                        List.of("class", "dog", "apple"),
                        10
                );

        assertFalse(q.checkAnswer("B"));
    }

    @Test
    void shouldReturnFalseForInvalidInput() {
        MultipleChoiceQuestion q =
                new MultipleChoiceQuestion(
                        "Keyword?",
                        "class",
                        List.of("class", "dog", "apple"),
                        10
                );

        assertFalse(q.checkAnswer("Z"));
        assertFalse(q.checkAnswer(""));
        assertFalse(q.checkAnswer(null));
    }
}

