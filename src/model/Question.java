package model;
public abstract class Question implements Gradable{
	
	protected String questionText;
	protected String correctAnswer;
	protected int points;
	
	public Question(String questionText, String correctAnswer, int points) {
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
		this.points = points;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	@Override
	public int calculateScore() {
		return points;
	}
	
	public abstract boolean checkAnswer(String studentAnswer);
	public abstract void displayQuestion();
	
	
}


