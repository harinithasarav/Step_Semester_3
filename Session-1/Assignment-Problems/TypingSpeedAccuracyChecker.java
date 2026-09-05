public class TypingSpeedAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;

        if (firstMismatch == -1 && original.length() == typed.length()) {

            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                matched, original.length(), accuracy
            );

        } else {

            if (firstMismatch == -1) {
                firstMismatch = length;
            }

            char originalChar =
                firstMismatch < original.length()
                ? original.charAt(firstMismatch)
                : '-';

            char typedChar =
                firstMismatch < typed.length()
                ? typed.charAt(firstMismatch)
                : '-';

            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | " +
                "First Mismatch at position %d ('%c' vs '%c')%n",
                matched,
                original.length(),
                accuracy,
                firstMismatch + 1,
                originalChar,
                typedChar
            );
        }
    }

    public static void main(String[] args) {

        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}