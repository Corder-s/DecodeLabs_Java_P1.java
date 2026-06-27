import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {

                try {
                    System.out.print("Enter your guess: ");
                    int guess = sc.nextInt();

                    attempts++;

                    if (guess == targetNumber) {
                        System.out.println("\n🎉 Congratulations! You guessed correctly.");
                        System.out.println("Attempts Used: " + attempts);

                        score += (maxAttempts - attempts + 1);
                        guessedCorrectly = true;

                    } else if (guess > targetNumber) {
                        System.out.println("📈 Too High! Try Again.");

                    } else {
                        System.out.println("📉 Too Low! Try Again.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("❌ Invalid Input! Please enter a number.");
                    sc.next(); // clear invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n💀 You Lose!");
                System.out.println("Correct Number was: " + targetNumber);
            }

            System.out.println("🏆 Current Score: " + score);

            System.out.print("\nPlay Again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n=================================");
        System.out.println("Final Score: " + score);
        System.out.println("Thank you for playing!");
        System.out.println("=================================");

        sc.close();
    }
}