package com.Validator;

public class CardValidator {
    public boolean check(long CardNumber){
        CardValidator obj = new CardValidator();
        int OddSum = OddValPatch1(CardNumber);
        int EvenSum = EvenValPatch1(obj , CardNumber);
        return validator(OddSum, EvenSum);
    }

    private int OddValPatch1(long num) {
        long currentOddVal,totalOddVal = 0;
        long placeMod = 10;
        long divideVal = 1;
        for (int i = 0 ; i < 8 ; i++ ){
            if (i == 0){
                currentOddVal = num%placeMod ;
            }
            else {
                currentOddVal = (num%placeMod) / divideVal;
            }
            placeMod = placeMod * 100;
            divideVal = divideVal * 100;
//            System.out.println("oddVal: " + oddVal + " placeMod: " + placeMod + " divideVal: " + divideVal);
            totalOddVal = currentOddVal + totalOddVal;
        }
//        System.out.println(totalOddVal);

        return (int) totalOddVal;
    }

    private int EvenValPatch1( CardValidator obj, long num){
        long[] array;
        array = obj.EvenValPatch2(num);

        int currentValue, twiceCurrentValue;
        int totalValue = 0;

        for (int i = 0; i < 8; i++){
            currentValue = (int)array[i];
            twiceCurrentValue = currentValue * 2;
            if (twiceCurrentValue <= 9 && twiceCurrentValue >= 0){
                totalValue = twiceCurrentValue + totalValue;
//                System.out.println("twiceCurrentValue: " + twiceCurrentValue);
            }
            else if (twiceCurrentValue > 9){
                int val1, val2;
                val1 = twiceCurrentValue%10;
                val2 = twiceCurrentValue/10;
//                System.out.println("val1: "+ val1 + " val2: " + val2);
                totalValue = totalValue + val1 + val2;
            }
        }
//        System.out.println(totalValue);
        return totalValue;
    }

    private long[] EvenValPatch2(long num){
        long currentEvenVal = 0;
        long placeMod = 100;
        long divideVal = 10;
        long[] array = new long[8];
        for (int i = 0; i < 8; i++) {

            currentEvenVal = (num%placeMod)/divideVal;
            placeMod = placeMod * 100;
            divideVal = divideVal * 100;
//            System.out.println("placeMod: " + placeMod + " divideVal: " + divideVal + " currentEvenVal: " + currentEvenVal);
            array[i] = currentEvenVal;
        }
        return array;
    }

    private boolean validator(int OddSum, int EvenSum){
        int total = OddSum + EvenSum;
        return total % 10 == 0;
    }
}