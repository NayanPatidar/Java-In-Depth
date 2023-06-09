import java.util.Arrays;
public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output
        String feature = null;

        // your code ~ you will be invoking getOpinionOnFeature
        for (int q = 0 ; q < featureSet.length ; q++ )
        {
            for (int r = 0 ; r < featureSet[q].length ; r++)
            {
                feature = featureSet[q][r];
                int valOpinion = getOpinionOnFeature(review , feature , posOpinionWords , negOpinionWords);

                if (valOpinion == 1 || valOpinion == -1)
                {
                    featureOpinions[q] = valOpinion;
                }
               // System.out.println("FeatureOpinions = " + featureOpinions[q] + " q = " +q);
            }
        }
        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        int opinion = 0;
        review = review.toLowerCase();
        int val = checkForWasPhrasePattern(review , feature , posOpinionWords , negOpinionWords);
        opinion = val;

        if(opinion == 0)
        {
            int val1 = checkForOpinionFirstPattern(review,feature ,posOpinionWords , negOpinionWords);
            opinion = val1;
        }
        return opinion;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords)
    {
        int opinion = 0;
        String pattern = feature + " was ";
        int indexPattern = review.indexOf(pattern);

        if (review.contains(pattern))
        {
            for (int i = 0; i < posOpinionWords.length; i++)
            {
                String comStringPos = pattern + posOpinionWords[i];

                if (review.contains(comStringPos))
                {
                    opinion = 1 ;
                }
            }

            if(opinion != 1)
            {
                for (int k = 0; k < negOpinionWords.length; k++)
                {
                    String comStringNeg = pattern + negOpinionWords[k];

                    if (review.contains(comStringNeg))
                    {
                        int negOpinionLength = negOpinionWords[k].length();
                        String comNegOpinion = review.substring(indexPattern, (indexPattern + pattern.length() + negOpinionLength));
                        opinion = -1;
                    }
                }
            }
        }
        return opinion;
    }

    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords)
    {
        String[] sentences = review.split("\\.");
        int opinion = 0;
        String reviewLowerCaps = review.toLowerCase();
        String pattern = " " + feature ;
        int patternLength = pattern.length();

        for (int i = 0; i < sentences.length; i++)
        {
            for (int k = 0; k < posOpinionWords.length; k++)
            {
                String comStringPos = posOpinionWords[k] + pattern;

                if (sentences[i].contains(comStringPos))
                {
                    opinion = +1;
                    break;
                }
            }

            if (opinion !=1 )
            {
                for (int k = 0; k < negOpinionWords.length; k++)
                {
                    String comStringNeg = negOpinionWords[k] + pattern;
                    if (sentences[i].contains(comStringNeg))
                    {
                        opinion = -1;
                        break;
                    }
                }
            }
            else if (opinion != 1 && opinion != -1)
            {
                break;
            }
        }
        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a " +
                "frequent flyer! Francisco was very attentive.";

        String[] posOpinionWords = {"good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious"};
        String[] negOpinionWords = {"slow", "bad", "horrible", "awful", "unprofessional", "poor"};

        String[][] featureSet = {

                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };

        int[] val = detectProsAndCons(review,featureSet,posOpinionWords , negOpinionWords );
        System.out.print("[");
        for (int i = 0 ; i < val.length ; i++)
        {
            System.out.print(val[i]);
            if (i < val.length-1)
            {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}










