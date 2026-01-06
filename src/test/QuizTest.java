package test;
import model.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import model.Quiz;
import model.QuizResult;
import model.Student;
import model.Question;
import model.TrueFalseQuestion;


public class QuizTest {
	@Test
    void scoreShouldBeSumOfCorrectAnswers() {
        Student student = new Student("Selin");

        Question q1 = new TrueFalseQuestion("Java?", "true", 10);
        Question q2 = new TrueFalseQuestion("Python?", "false", 5);

        Quiz quiz = new Quiz(List.of(q1, q2));

        QuizResult result =
                quiz.startQuiz(student, List.of("t", "f"));

        assertEquals(15, result.getScore());
    }

    @Test
    void scoreShouldBeZeroIfAllAnswersWrong() {
        Student student = new Student("Selin");

        Question q1 = new TrueFalseQuestion("Java?", "true", 10);
        Question q2 = new TrueFalseQuestion("Python?", "false", 5);

        Quiz quiz = new Quiz(List.of(q1, q2));

        QuizResult result =
                quiz.startQuiz(student, List.of("f", "t"));

        assertEquals(0, result.getScore());
    }
}


   
    
      
