package model;
public class QuizResult {
    
	private Student student;
    private int score;
    private long durationSeconds;
    private String status;

    public QuizResult(Student student, int score, long durationSeconds, String status) {
        this.student = student;
        this.score = score;
        this.durationSeconds = durationSeconds;
        this.status = status;
    }

    public Student getStudent() { 
    	return student; 
    	}
    
    public int getScore() { 
    	return score; 
    	}
    
    public long getDurationSeconds() { 
    	return durationSeconds; 
    	}
    
    public String getStatus() { 
    	return status; 
    	}

    @Override
    public String toString() {
        return "QuizResult{" +
                "student=" + student +
                ", score=" + score +
                ", durationSeconds=" + durationSeconds +
                ", status='" + status + '\'' +
                '}';
    }
}