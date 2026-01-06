package model;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoiceQuestion extends Question {

    private List<String> choices;
    private int correctChoiceIndex;

    public MultipleChoiceQuestion(String text,
                                  String correctAnswer,
                                  List<String> allChoices,
                                  int points) {

        super(text, correctAnswer, points);

        
        this.choices = new ArrayList<>(allChoices);

        
        if (!choices.contains(correctAnswer)) {
            throw new IllegalArgumentException(
                "Correct answer must be one of the choices."
            );
        }

        
        Collections.shuffle(this.choices);

        
        this.correctChoiceIndex = this.choices.indexOf(correctAnswer);
    }

    @Override
    public void displayQuestion() {
        System.out.println("Question: " + getQuestionText());

        char option = 'A';
        for (String choice : choices) {
            System.out.println(option++ + ") " + choice);
        }

        System.out.print("Your answer (A/B/C/D/...): ");
    }

    @Override
    public boolean checkAnswer(String studentAnswer) {

        if (studentAnswer == null || studentAnswer.isEmpty()) {
            return false;
        }

        char answerChar = Character.toUpperCase(studentAnswer.charAt(0));
        int studentIndex = answerChar - 'A';

        if (studentIndex < 0 || studentIndex >= choices.size()) {
            return false;
        }

        return studentIndex == correctChoiceIndex;
    }
}
