import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkipInvalidTransaction {
    public static void main(String[] args) {
        Path path = Paths.get("tmp.txt");

        try (Stream<String> lines = Files.lines(path)) {
            List<Integer> transactions = lines
                    .map(String::trim)
                    .filter(line -> {
                        try {
                            Integer.parseInt(line);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int sum = transactions.stream().mapToInt(Integer::intValue).sum();
            int max = transactions.stream().mapToInt(Integer::intValue).max().orElse(0);

            System.out.println("Sum of Transactions: " + sum);
            System.out.println("Max Transaction: " + max);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
}