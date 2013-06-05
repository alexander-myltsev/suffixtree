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

        // NOTE: There might be many longest common substrings of equal size
        for (String longestCommonSubstring : generalizedSuffixTree.lcs()) {
            System.out.println(longestCommonSubstring);
        }
    }

    public static void main(String... args) {
        List<String> inputStrings = new ArrayList<String>();
        inputStrings.add("abxxxacaba");
        inputStrings.add("mycabarcxxxhive");
        inputStrings.add("acabistruxxxe");

        System.out.println("-----> naive");
        Set<String> lcsNaive = new HashSet<String>(NaiveImplementation.lcs(inputStrings));
        for (String longestCommonSubstring : lcsNaive) {
            System.out.println(longestCommonSubstring);
        }

        System.out.println("-----> suffix tree");
        GeneralizedSuffixTree generalizedSuffixTree = new GeneralizedSuffixTree();
        for (String inputString : inputStrings) {
            generalizedSuffixTree.addSequence(inputString);
        }

        Set<String> lcsSuffixTree = new HashSet<String>(generalizedSuffixTree.lcs());
        for (String longestCommonSubstring : lcsSuffixTree) {
            System.out.println(longestCommonSubstring);
        }

        System.out.println("-----> sets equal: " + lcsNaive.equals(lcsSuffixTree));
    }
}