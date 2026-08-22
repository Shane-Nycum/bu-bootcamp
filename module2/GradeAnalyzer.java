import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // Step 1: read scores from file
        var scores = readScores("scores.txt");
        // Step 2: calculate statistics
        var average = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, "GradeReport.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        var testScores = new ArrayList<Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        var testScore = Integer.parseInt(line);
                        testScores.add(testScore);
                    } catch (NumberFormatException e) {
                        System.out.println("WARNING | Skipping non-integer line found in input file: " + line + "\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return testScores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
            double avg, int high, int low,
            String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80 && score <= 89) {
                countB++;
            } else if (score >= 70 && score <= 79) {
                countC++;
            } else if (score >= 60 && score <= 69) {
                countD++;
            } else {
                countF++;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Grade analysis report
            var line = "=== Grade Analysis Report ===\n";
            writer.write(line);
            System.out.println(line);

            // Total scores processed
            line = String.format("Total scores processed: %d%n", scores.size());
            writer.write(line);
            System.out.print(line);

            // Skip a line for section break
            writer.newLine();
            System.out.println();

            // Average score
            line = String.format("Average score: %.2f%n", avg);
            writer.write(line);
            System.out.print(line);

            // Highest score
            line = String.format("Highest score: %d%n", high);
            writer.write(line);
            System.out.print(line);
            
            // Lowest score
            line = String.format("Lowest score:  %d%n", low);
            writer.write(line);
            System.out.print(line);

            // Skip a line for section break
            writer.newLine();
            System.out.println();

            // Grade distribution line
            line = "Grade distribution:\n";
            writer.write(line);
            System.out.println(line);

            // A distribution
            line = String.format("  A (90-100):   %d%n", countA);
            writer.write(line);
            System.out.print(line);

            // B distribution
            line = String.format("  B (80-89):    %d%n", countB);
            writer.write(line);
            System.out.print(line);

            // C distribution
            line = String.format("  C (70-79):    %d%n", countC);
            writer.write(line);
            System.out.print(line);

            // D distribution
            line = String.format("  D (60-69):    %d%n", countD);
            writer.write(line);
            System.out.print(line);

            // F distribution
            line = "  F (below 60): " + countF;
            line = String.format("  F (below 60): %d%n", countF);
            writer.write(line);
            System.out.print(line);

        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}