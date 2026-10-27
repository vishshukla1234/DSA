
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class MakeArrayIdentical {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int M = scanner.nextInt();
            int[] arrayOne = new int[M];
            int[] arrayTwo = new int[M];

            for (int i = 0; i < M; i++) {
                arrayOne[i] = scanner.nextInt();
            }
            for (int i = 0; i < M; i++) {
                arrayTwo[i] = scanner.nextInt();
            }

            // Find the contiguous subsegment where arrayOne differs from arrayTwo
            int startIndex = -1;
            int endIndex = -1;
            int requiredDiff = -1;
            boolean possible = true;

            for (int i = 0; i < M; i++) {
                if (arrayOne[i] != arrayTwo[i]) {
                    if (arrayTwo[i] < arrayOne[i]) {
                        possible = false; // Cannot add a non-negative value to make it smaller
                        break;
                    }
                    int diff = arrayTwo[i] - arrayOne[i];
                    if (requiredDiff == -1) {
                        requiredDiff = diff;
                        startIndex = i;
                    } else if (requiredDiff != diff) {
                        possible = false; // The added value must be uniform across the range
                        break;
                    }
                    endIndex = i;
                }
            }

            // If already identical, adding 0 works (value = 0)
            if (requiredDiff == -1) {
                System.out.println("YES 0");
            } else if (possible) {
                // Verify if all elements within [startIndex, endIndex] differ by requiredDiff
                for (int i = startIndex; i <= endIndex; i++) {
                    if (arrayTwo[i] - arrayOne[i] != requiredDiff) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    System.out.println("YES " + requiredDiff);
                }
            }

            if (!possible) {
                // Calculate intersection count without duplicates
                Set<Integer> setOne = new HashSet<>();
                Set<Integer> setTwo = new HashSet<>();
                for (int val : arrayOne) {
                    setOne.add(val);
                }
                for (int val : arrayTwo) {
                    setTwo.add(val);
                }

                setOne.retainAll(setTwo); // Keeps only common elements
                System.out.println("NO " + setOne.size());

            }
            for (int en : setOne) {
                System.out.print(en + " ");
            }
        }
        scanner.close();
    }
}
