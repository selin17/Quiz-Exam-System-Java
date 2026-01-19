package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvResultWriter {

	private static final String FILE_NAME = "quiz_results.csv";



    public static void writeResult(QuizResult result) {

        System.out.println("CSV writing to: " +
                new File(FILE_NAME).getAbsolutePath());

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {

            writer.append(
                result.getStudent().getStudentId() + "," +
                result.getStudent().getName() + "," +
                result.getScore() + "," +
                result.getDurationSeconds() + "," +
                result.getStatus() + "\n"
            );

        } catch (IOException e) {
            System.out.println("CSV write error: " + e.getMessage());
        }
    }
}
