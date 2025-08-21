import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class TransactionProcessor {
    public static void main(String[] args) {
        Path path = Paths.get("tmp.txt");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                try {
                    int amount = Integer.parseInt(line.trim());
                    System.out.println("Valid transaction: " + amount);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(new InvalidTransactionException("Invalid transaction data: " + line));
                }
            });
        } catch (RuntimeException e) {
            if (e.getCause() instanceof InvalidTransactionException) {
                System.out.println(e.getCause().getMessage());
            } else {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}