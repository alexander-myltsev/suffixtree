package lcs;

import junit.framework.TestCase;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.suffixtree.GeneralizedSuffixTree;
import org.junit.Test;

import java.util.*;

public class StressTest extends TestCase {
    public void testStressWithFixedWords() {
        int attemptsCount = 1000;
        Random random = new Random(); //new Random(System.currentTimeMillis());

        String[] words = new String[]{"libertypike",
                "franklintn",
                "carothersjohnhenryhouse",
                "carothersezealhouse",
                "acrossthetauntonriverfromdightonindightonrockstatepark",
                "dightonma",
                "dightonrock",
                "6mineoflowgaponlowgapfork",
                "lowgapky",
                "lemasterjohnjandellenhouse",
                "lemasterhouse",
                "70wilburblvd",
                "poughkeepsieny",
                "freerhouse",
                "701laurelst",
                "conwaysc",
                "hollidayjwjrhouse",
                "mainandappletonsts",
                "menomoneefallswi",
                "mainstreethistoricdistrict",
                "addressrestricted",
                "brownsmillsnj",
                "hanoverfurnace",
                "hanoverbogironfurnace",
                "sofsavannahatfergusonaveandbethesdard",
                "savannahga",
                "bethesdahomeforboys",
                "bethesda"};
        for (int attemptNumber = 0; attemptNumber < attemptsCount; attemptNumber++) {
            // Initialize
            GeneralizedSuffixTree generalizedSuffixTree = new GeneralizedSuffixTree();

            int wordsSampleSize = random.nextInt(words.length + 1);
            List<String> wordsSample = new ArrayList<String>();
            for (int index = 0; index < wordsSampleSize; index++) {
                String anotherSampleWord = words[random.nextInt(words.length)];
                generalizedSuffixTree.addSequence(anotherSampleWord);
                wordsSample.add(anotherSampleWord);
            }

            // Process
            Collection<String> lcsSuffixTree = generalizedSuffixTree.lcs();
            Collection<String> lcsNaive = NaiveImplementation.lcs(wordsSample);

            // Assert
            assertEquals(new HashSet<String>(lcsSuffixTree), new HashSet<String>(lcsNaive));
        }
    }

    public void testStressWithRandomWords() {
        int totalAttemptsCount = 10;
        int wordPermutationsAttemptsCount = 10;
        int wordsCount = 7;

        for (int attemptIndex = 0; attemptIndex < totalAttemptsCount; attemptIndex++) {
            System.out.println("attemptIndex: " + attemptIndex);

            List<String> words = new ArrayList<String>();
            for (int i = 0; i < wordsCount; i++) {
                words.add(RandomStringUtils.randomAlphanumeric(100));
            }

            Random random = new Random(); //new Random(System.currentTimeMillis());
            for (int wordAttemptIndex = 0; wordAttemptIndex < wordPermutationsAttemptsCount; wordAttemptIndex++) {
                System.out.println("  wordAttemptIndex: " + wordAttemptIndex);

                // Initialize
                GeneralizedSuffixTree generalizedSuffixTree = new GeneralizedSuffixTree();

                int wordsSampleSize = random.nextInt(words.size() + 1);
                List<String> wordsSample = new ArrayList<String>();
                for (int index = 0; index < wordsSampleSize; index++) {
                    String anotherSampleWord = words.get(random.nextInt(words.size()));
                    generalizedSuffixTree.addSequence(anotherSampleWord);
                    wordsSample.add(anotherSampleWord);
                }

                // Process
                Collection<String> lcsSuffixTree = generalizedSuffixTree.lcs();
                Collection<String> lcsNaive = NaiveImplementation.lcs(wordsSample);

                // Assert
                assertEquals(new HashSet<String>(lcsSuffixTree), new HashSet<String>(lcsNaive));
            }
        }
    }
}
