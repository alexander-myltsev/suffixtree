package lcs;

import org.apache.commons.lang3.text.suffixtree.GeneralizedSuffixTree;

import java.util.Collection;
import java.util.Scanner;

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
        Collection<String> stringCollection = NaiveImplementation.generateSubstrings("");
        for (String s : stringCollection) {
            System.out.println(s);
        }
    }
}