import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInputValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            System.out.print("Enter your age: ");
            String ageInput = scanner.nextLine();
            try {
                age = Integer.parseInt(ageInput);
            } catch (NumberFormatException e) {
                System.out.println("Age must be a number.");
                continue;
            }
            if (name.length() <= 3) {
                System.out.println("Name must be longer than 3 characters.");
            } else if (age <= 18) {
                System.out.println("Age must be greater than 18.");
            } else {
                break;
            }
        }
        try (FileWriter writer = new FileWriter("user_data.txt", true)) {
            writer.write("Name: " + name + ", Age: " + age + "\n");
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        scanner.close();
    }
}
