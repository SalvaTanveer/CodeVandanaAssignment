import java.util.Scanner;

public class AnagramChecker {
    public static boolean isAnagram(String str1, String str2) {
        // Removing whitespace and converting the strings into lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are not equal then they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Creating frequency array for character counts
        int[] charCounts = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            charCounts[str1.charAt(i) - 'a']++;
            charCounts[str2.charAt(i) - 'a']--;
        }

        // Checking if all counts are zero
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        System.out.println("Output: " + isAnagram(str1, str2));

        scanner.close();
    }
}
