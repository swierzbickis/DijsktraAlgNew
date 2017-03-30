package com.company.prime.numbers;

import java.util.*;

/**
 * Created by Sebek on 2017-03-25.
 */
public class EratostenesSieve {

    private static final int MIN_PRIME_NUMBER =2;
    private static final int NON_PRIME_NUMBER = 0;


    public  List<Integer> getPrimeNumbers(int maxNumber) {

        Integer[] allRangeNumbers = new Integer[maxNumber];

        allRangeNumbers = getAllValuesFromRange(allRangeNumbers,maxNumber);

        for (int j = MIN_PRIME_NUMBER; j < maxNumber; j++)
        {
            if (allRangeNumbers[j]!=0)//is true
            {
                for (int p = MIN_PRIME_NUMBER; (p*j) < maxNumber; p++)
                {
                    allRangeNumbers[p * j] = NON_PRIME_NUMBER;
                }
            }
        }

        List<Integer> primesList = removeDivisors(allRangeNumbers,maxNumber);

        return primesList;

    }

    private Integer[] getAllValuesFromRange(Integer[] allRangeNumbers,int maxNumber){

        for (int i = MIN_PRIME_NUMBER; i < maxNumber; i++)
        {
            allRangeNumbers[i] = i;
        }

        return allRangeNumbers;
    }

    /**
     *
     * @param allRangeNumbers
     * @param maxNumber
     * @return
     */
    private  List<Integer> removeDivisors(Integer[] allRangeNumbers,int maxNumber){

        List<Integer> primesList = new LinkedList<>();

        for(int j = MIN_PRIME_NUMBER; j < maxNumber; j++){
            if(allRangeNumbers[j]!= NON_PRIME_NUMBER){
                primesList.add(allRangeNumbers[j]);

            }
        }

        return primesList;

    }




}
