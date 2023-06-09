import java.util.Arrays;
public class playingWithString {
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
                System.out.println("FeatureOpinions = " + featureOpinions[q] + " q = " +q);
            }
        }
        return featureOpinions;
    }
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        int opinion = 0;
        review = review.toLowerCase();
        int val = checkForWasPhrasePattern(review , feature , posOpinionWords , negOpinionWords);
        opinion = val;

        if(opinion == 0 )
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
    public static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
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
                int posOpinionLength = posOpinionWords[k].length();
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
                    int negOpinionLength = negOpinionWords[k].length();
                    String comStringNeg = negOpinionWords[k] + pattern;

                    if (sentences[i].contains(comStringNeg))
                    {
                        opinion = -1;
                        break;
                    }
                }
            } else if (opinion != 1 && opinion != -1) {
                break;
            }
        }
        return opinion;
    }
    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! " +
                "Definetly will be a frequent flyer! Francisco was very attentive";

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


































        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!
        // System.out.println(reviewLowerCaps );

     /*   String reviewLowerCaps = review.toLowerCase();
        String[] sentences = reviewLowerCaps.split("\\.");
        String pattern = " service";
        int patternLength = pattern.length();


        for (int i = 0; i < sentences.length; i++) {

            for (int k = 0; k < posOpinionWords.length; k++) {
                int posOpinionLength = posOpinionWords[k].length();
                String comStringPos = posOpinionWords[k] + pattern;

                if (sentences[i].contains(comStringPos)) {
                    opinion = +1;
                    break;
                }
            }
            if (opinion !=1 )
            {
                for (int k = 0; k < negOpinionWords.length; k++)
                {
                    int negOpinionLength = negOpinionWords[k].length();
                    String comStringNeg = negOpinionWords[k] + pattern;

                    if (sentences[i].contains(comStringNeg)) {
                        opinion = -1;
                        break;
                    }
                }
            } else if (opinion != 1 && opinion != -1) {
                break;
            }
        } System.out.println("opinion " + opinion);

        // your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)


        //This is for '{opinion}{feature}'

        int indexPattern = sentences[i].indexOf(pattern);
        int indexOpinion = sentences[i].indexOf(negOpinionWords[k]);

        // System.out.println(indexOpinion);
//                    String comNegOpinion = sentences[i].substring(indexOpinion , indexOpinion + negOpinionLength
//                            + patternLength);
//                    System.out.println(comNegOpinion);


//        int indexOpinion = sentences[i].indexOf(posOpinionWords[k]);
//        String comPosOpinion = sentences[i].substring(indexOpinion, indexOpinion + posOpinionLength + patternLength);
//        System.out.println(comPosOpinion);


        //This is for 'Was'


        int indexPattern = review.indexOf(pattern);
        int patternLength = pattern.length();

        if (review.contains(pattern))
        {
                for (int i = 0; i < posOpinionWords.length; i++)
                {
                    //Setting things for posOPinionWords
                    int posOpinionLength = posOpinionWords[i].length();
                    String comStringPos = pattern + posOpinionWords[i];

                    if (review.contains(comStringPos))
                    {
                       // System.out.println("posOpinion = true" );
                        String comPosOpinion = review.substring(indexPattern, (indexPattern + pattern.length() + posOpinionLength));
                        //System.out.println(comPosOpinion);
                        opinion = 1 ;
                    }
                }

                if(opinion != 1)
                {
                    for (int k = 0; k < negOpinionWords.length; k++) {
                        String comStringNeg = pattern + negOpinionWords[k];

                        if (review.contains(comStringNeg)) {
                            //Setting things for negOpinionWords
                            int negOpinionLength = negOpinionWords[k].length();
                          //  System.out.println("negOpinion = true");
                            String comNegOpinion = review.substring(indexPattern, (indexPattern + pattern.length() + negOpinionLength));
                           // System.out.println(comNegOpinion);
                            opinion = -1;
                        }

                    }
                }
        }*/
    }
}

