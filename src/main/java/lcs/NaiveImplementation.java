package lcs;

import java.util.*;

public class NaiveImplementation {


    public static Collection<String> generateSubstrings(String inputString) {
        List<String> substrings = new ArrayList<String>();

        if (inputString.isEmpty())
            return substrings;

        for (int inputStringIndex = 0; inputStringIndex < inputString.length(); inputStringIndex++) {
            for (int restOfStringIndex = inputStringIndex + 1; restOfStringIndex <= inputString.length(); restOfStringIndex++) {
                substrings.add(inputString.substring(inputStringIndex, restOfStringIndex));
            }
        }

        Collections.sort(substrings, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return substrings;
    }
}
