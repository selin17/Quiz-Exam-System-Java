package app;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class QuizApplication {

    public static void main(String[] args) {

        Student student = new Student("Selin");

        List<Question> questions = new ArrayList<>();

        questions.add(
            new TrueFalseQuestion(
                "Java platform independent?",
                "true",
                10
            )
        );

        questions.add(
            new MultipleChoiceQuestion(
                "Which one is a Java keyword?",
                "class",
                List.of("class", "dog", "apple", "car"),
                10
            )
        );

        Quiz quiz = new Quiz(questions);

        quiz.startQuiz(student);
    }
}
