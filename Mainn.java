import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Link Shortener CLI!");
        System.out.println("Type 'shorten' to shorten a URL, 'expand' to retrieve a long URL, or 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter command: ");
            input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "shorten":
                    System.out.print("Enter long URL: ");
                    String longURL = scanner.nextLine().trim();
                    String shortURL = linkShortener.shortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;

                case "expand":
                    System.out.print("Enter short URL: ");
                    String shortURLInput = scanner.nextLine().trim();
                    String expandedURL = linkShortener.expandURL(shortURLInput);
                    System.out.println("Expanded URL: " + expandedURL);
                    break;

                case "exit":
                    System.out.println("Exiting Link Shortener CLI. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Please use 'shorten', 'expand', or 'exit'.");
            }
        }
    }
}
