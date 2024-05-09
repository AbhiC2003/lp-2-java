import java.util.Scanner;

public class botchat{
    public static void main(String[] args) {
        greet("Sbot", "2021");
        remindName();
        guessAge();
        count();
        test();
        end();
    }

    public static void greet(String botName, String birthYear) {
        System.out.println("Hello! My name is " + botName);
        System.out.println("I was created in " + birthYear);
    }

    public static void remindName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, remind me your name.");
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    public static void guessAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        int rem3 = scanner.nextInt();
        int rem5 = scanner.nextInt();
        int rem7 = scanner.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;

        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    public static void count() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();

        for (int i = 0; i <= num; i++) {
            System.out.println(i);
        }
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        int answer = 2;
        int guess = scanner.nextInt();
        while (guess != answer) {
            System.out.println("Please, try again.");
            guess = scanner.nextInt();
        }

        System.out.println("Completed, have a nice day!");
        System.out.println(".................................");
        System.out.println(".................................");
        System.out.println(".................................");
    }

    public static void end() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Congratulations, have a nice day!");
        System.out.println(".................................");
        System.out.println(".................................");
        System.out.println(".................................");
        scanner.nextLine(); // To wait for user input before ending
    }
}
