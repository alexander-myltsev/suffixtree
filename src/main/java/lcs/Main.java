package lcs;

import org.apache.commons.lang3.text.suffixtree.GeneralizedSuffixTree;

import java.util.*;

public class Main {
    public static void main1(String... args) {
        Scanner scanner = new Scanner(System.in);
        int stringsCount = scanner.nextInt();
        GeneralizedSuffixTree generalizedSuffixTree = new GeneralizedSuffixTree();
        for (int stringIndex = 0; stringIndex < stringsCount; stringIndex++) {
            String inputString = scanner.next();
            generalizedSuffixTree.addSequence(inputString);
        }

        // Самых длинных подстрок одинаковой длины может быть несколько
        for (String longestCommonSubstring : generalizedSuffixTree.lcs()) {
            System.out.println(longestCommonSubstring);
        }
    }

    public static void main(String... args) {
        List<String> inputStrings = new ArrayList<String>();
        inputStrings.add("abxxxacaba");
        inputStrings.add("mycabarcxxxhive");
        inputStrings.add("acabistruxxxe");

        for (String s : new TreeSet<String>(NaiveImplementation.lcs(inputStrings))) {
            System.out.println(s);
        }

        GeneralizedSuffixTree generalizedSuffixTree = new GeneralizedSuffixTree();
        for (String inputString : inputStrings) {
            generalizedSuffixTree.addSequence(inputString);
        }
        for (String longestCommonSubstring : new TreeSet<String>(generalizedSuffixTree.lcs())) {
            System.out.println(longestCommonSubstring);
        }
    }
}