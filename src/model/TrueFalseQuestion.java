package model;

public class TrueFalseQuestion extends Question {

    public TrueFalseQuestion(String questionText,
                              String correctAnswer,
                              int points) {
        super(questionText, correctAnswer, points);
    }

    @Override
    public void displayQuestion() {
        System.out.println("Question (True/False): " + getQuestionText());
        System.out.println("Your answer (T/F): ");
    }

    @Override
    public boolean checkAnswer(String studentAnswer) {
        if (studentAnswer == null) return false;

        studentAnswer = studentAnswer.trim().toLowerCase();
        String correct = correctAnswer.trim().toLowerCase();

        if (studentAnswer.equals("t") || studentAnswer.equals("true")) {
            return correct.equals("true");
        } else if (studentAnswer.equals("f") || studentAnswer.equals("false")) {
            return correct.equals("false");
        }
        return false;
    }
}
