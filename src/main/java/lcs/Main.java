package lcs;

import org.apache.commons.lang3.text.suffixtree.GeneralizedSuffixTree;

import java.util.*;

public class Main {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int stringsCount = scanner.nextInt();
        GeneralizedSuffixTree generalizedSuffixTree = new GeneralizedSuffixTree();
        for (int stringIndex = 0; stringIndex < stringsCount; stringIndex++) {
            String inputString = scanner.next();
            generalizedSuffixTree.addSequence(inputString);
        }

        // NOTE: There might be many longest common substrings of equal size
        for (String longestCommonSubstring : generalizedSuffixTree.lcs()) {
            System.out.println(longestCommonSubstring);
        }
    }
}