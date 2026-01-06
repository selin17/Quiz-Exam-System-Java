package model;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private int studentId;
    private String name;

    private static final AtomicInteger nextId = new AtomicInteger(1000);

    public Student(String name) {
        this.name = name;
        this.studentId = nextId.getAndIncrement();  
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name;
    }
}
