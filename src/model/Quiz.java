package model;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz implements Gradable {
    private long startTime;
    private long endTime;
    private Student currentStudent;
    private List<Question> questions;
    private int score = 0;
    private volatile boolean quizFinished = false;
    private Scanner scanner;
    private static final int QUIZ_DURATION_SECONDS = 900;

    public Quiz(List<Question> questions) {
        this.questions = new ArrayList<>(questions);
        Collections.shuffle(this.questions);
        this.scanner = new Scanner(System.in);
    }

    
    public void addToScore(Question question, boolean isCorrect) {
        if (isCorrect) score += question.calculateScore();
    }

    @Override
    public int calculateScore() { 
        return score; 
    }

    
    
    public QuizResult startQuiz(Student student) {
        return startQuiz(student, null); 
    }

    
    public QuizResult startQuiz(Student student, List<String> studentAnswers) {
        this.currentStudent = student;
        System.out.println("\n-----------");
        System.out.println("Hello " + student.getName()
                + ", Quiz is starting! (" + questions.size() + " Question)");
        System.out.println("-----------");

        this.startTime = System.currentTimeMillis();
        startTimer();

        int answerIndex = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (quizFinished) {
                System.out.println("\n--- Time is up! The exam was automatically terminated. ---");
                break;
            }

            Question currentQuestion = questions.get(i);
            System.out.println("\nSoru " + (i + 1));
            currentQuestion.displayQuestion();

            String studentAnswer;
            if (studentAnswers != null && answerIndex < studentAnswers.size()) {
                studentAnswer = studentAnswers.get(answerIndex++);
                System.out.println(studentAnswer); 
            } else {
                studentAnswer = scanner.nextLine();
            }

            boolean correct = currentQuestion.checkAnswer(studentAnswer);
            addToScore(currentQuestion, correct);

            System.out.println(correct ? "Doğru!" : "Yanlış.");
        }

        this.endTime = System.currentTimeMillis();
        quizFinished = true;

        return finalizeQuiz();
    }

    
    private QuizResult finalizeQuiz() {
        long durationSeconds = (endTime - startTime) / 1000;
        
        String status = durationSeconds <= QUIZ_DURATION_SECONDS ? "Completed" : "Time is up.";
        QuizResult result =
                new QuizResult(currentStudent, calculateScore(), durationSeconds, status);

        showResults(durationSeconds, status);
        CsvResultWriter.writeResult(result);

        return result;
    }

    
    private void startTimer() {
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                quizFinished = true;
                System.out.println("\n--- Time is up! Please press Enter. ---");
                timer.cancel();
            }
        }, QUIZ_DURATION_SECONDS * 1000);

        System.out.println("Quiz duration: " + (QUIZ_DURATION_SECONDS / 60) + " minutes.");
    }

   
    public void showResults(long durationSeconds, String status) {
        System.out.println("\n-------------");
        System.out.println("Quiz results:");
        System.out.println("-------------");
        System.out.println("Student: " + currentStudent.getName());
        System.out.println("Status: " + status);
        System.out.println("Total questions: " + questions.size());
        System.out.println("Total score: " + score);
        System.out.println("Time spent: " + durationSeconds + " seconds");
        System.out.println("-------------");
    }
}



