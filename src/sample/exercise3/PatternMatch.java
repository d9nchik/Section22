package sample.exercise3;

import java.util.Scanner;

public class PatternMatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string  s1: ");
        String s1 = input.nextLine();
        System.out.print("Enter a string  s2: ");
        String s2 = input.nextLine();

        System.out.println("matched at index " + indexOf(s1, s2));
    }

    private static int indexOf(String whereToSearch, String searchingLine) {
        char[] charWhereToSearch = whereToSearch.toCharArray();
        char[] searchingLineChars = searchingLine.toCharArray();
        for (int i = 0, j = 0; i < charWhereToSearch.length; i++) {
            if (charWhereToSearch[i] != searchingLineChars[j])
                j = charWhereToSearch[i] == searchingLineChars[0] ? 1 : 0;
            else {
                j++;
                if (j == searchingLineChars.length - 1)
                    return i - j + 1;
            }
        }
        return -1;
    }
}
