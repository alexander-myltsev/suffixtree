package lcs;

import org.apache.commons.lang3.text.suffixtree.Utils;

import java.util.*;

public class NaiveImplementation {
    /**
     * Generates collection of all longest common substrings of a given set of input strings
     *
     * @param inputStrings list of input strings
     * @return collection of all longest common substrings
     */
    public static Collection<String> lcs(List<String> inputStrings) {
        if (inputStrings.size() < 2)
            return inputStrings;

        List<String> commonSubstrings = new ArrayList<String>();
        String firstString = inputStrings.get(0);
        Collection<String> firstStringSubstrings = generateSubstringsSortedByLenghtDesc(firstString);
        for (String substring : firstStringSubstrings) {
            if (!commonSubstrings.isEmpty() && commonSubstrings.get(0).length() > substring.length())
            {
                break;
            }

            boolean isSubstringOfAllInputStrings = true;
            for (int inputStringIndex = 1; inputStringIndex < inputStrings.size(); inputStringIndex++) {
                String inputString = inputStrings.get(inputStringIndex);
                if (!inputString.contains(substring)) {
                    isSubstringOfAllInputStrings = false;
                    break;
                }
            }
            if (isSubstringOfAllInputStrings)
                commonSubstrings.add(substring);
        }

        return commonSubstrings;
    }

    /**
     * Generates collection of all substrings of a given input string
     *
     * @param inputString input string
     * @return collection of all substrings in descending order according to length of each string
     */
    private static Collection<String> generateSubstringsSortedByLenghtDesc(String inputString) {
        List<String> substrings = new ArrayList<String>(Utils.getSubstrings(inputString));

        Collections.sort(substrings, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        return substrings;
    }
}
