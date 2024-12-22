import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}

public class QuizApplication {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Application!");

        Question[] questions = new Question[]{
                new Question("Who sang the title song for the latest Bond film, No Time to Die?", new String[]{"1. Adele", "2. Sam Smith", "3. Billie Eilish", "4. Ed Sheeran"}, 3),
                new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 2),
                new Question("What is the capital city of Australia?", new String[]{"1. Sydney", "2. Melbourne", "3. Canberra", "4. Brisbane"}, 3),
                new Question("Which element has the chemical symbol 'O'?", new String[]{"1. Gold", "2. Oxygen", "3. Osmium", "4. Zinc"}, 2),
                new Question("Who wrote the play 'Romeo and Juliet'?", new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Jane Austen", "4. Mark Twain"}, 2)
        };

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(questions[i].questionText);
            for (String option : questions[i].options) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();

            if (questions[i].checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. The correct answer was option " + questions[i].correctAnswer + ".");
            }
        }

        System.out.println("\nQuiz Finished!");
        System.out.println("Your score: " + score + " out of " + questions.length);

        if (score == questions.length) {
            System.out.println("Excellent work!");
        } else if (score >= questions.length / 2) {
            System.out.println("Good job! Keep practicing!");
        } else {
            System.out.println("Better luck next time!");
        }
    }
}
