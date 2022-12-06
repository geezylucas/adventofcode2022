import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Day1CalorieCounting
 */
public class Day1CalorieCounting {

    public static void main(String[] args) throws IOException {
        String pathFile = "Day1CalorieCounting.txt";
        System.out.println(caloriesCounting(pathFile));
        System.out.println(caloriesCountingTopThree(pathFile));

    }

    private static int caloriesCounting(String pathFile) throws IOException {
        int maxCalories = 0;
        try (Scanner reader = new Scanner(new File(pathFile))) {
            String line;
            int temp = 0;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (!line.isEmpty()) {
                    temp = temp + Integer.valueOf(line);
                }

                if (line.isEmpty() || !reader.hasNextLine()) {
                    if (temp > maxCalories) {
                        maxCalories = temp;
                    }
                    
                    temp = 0;
                }
            }
        }

        return maxCalories;
    }

    private static int caloriesCountingTopThree(String pathFile) throws IOException {
        int firstMaxCalories = 0;
        int secondMaxCalories = 0;
        int thirdMaxCalories = 0;
        try (Scanner reader = new Scanner(new File(pathFile))) {
            String line;
            int temp = 0;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (!line.isEmpty()) {
                    temp = temp + Integer.valueOf(line);
                }

                if (line.isEmpty() || !reader.hasNextLine()) {
                    if (temp > firstMaxCalories) {
                        thirdMaxCalories = secondMaxCalories;
                        secondMaxCalories = firstMaxCalories;
                        firstMaxCalories = temp;
                    } else if (temp > secondMaxCalories) {
                        thirdMaxCalories = secondMaxCalories;
                        secondMaxCalories = temp;
                    } else if (temp > thirdMaxCalories) {
                        thirdMaxCalories = temp;
                    }

                    temp = 0;
                }
            }

        }
        return firstMaxCalories + secondMaxCalories + thirdMaxCalories;
    }
}