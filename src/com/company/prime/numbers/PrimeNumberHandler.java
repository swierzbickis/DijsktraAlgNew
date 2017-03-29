package com.company.prime.numbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *Class returns list of prime numbers from min value to max value given by the user.
 * Range of the numbers are <MIN_VALUE,MAX_VALUE> . Max value is also included
 */
public class PrimeNumberHandler {

    private static long MIN_NUMBER = 2; //value given from task description

    /**
     * Method returns list of prime numbers from min value to max value given by the user.
     * @param maxNumber  The maximum value which describes the range of the values included in list.
     * @return list of prime numbers
     */
    public List<Long> getPrimeNumbers(long maxNumber){

        List<Long>  primeNumbersList= initAllNumbers(maxNumber);
        double borderValue = Math.floor(Math.sqrt(maxNumber));
        primeNumbersList= removeAllDivisors(primeNumbersList,borderValue);
        return primeNumbersList;
    }

    private List<Long> initAllNumbers(long maxNumber){
        List<Long>  primeNumbersList= new ArrayList<>();

        for(long i =MIN_NUMBER; i<=maxNumber ; i++){
            primeNumbersList.add(i);
        }
        return primeNumbersList;
    }


    private List<Long>  removeAllDivisors(List<Long>  primeNumbersList, double borderValue){

        Long currentNumber = primeNumbersList.get(0); // gets the first number to be checked ( It will be number =2 )
        while(currentNumber <= borderValue){ // Loops untill the current number is less or equal to border value
            primeNumbersList = removeDivisorsForValue(primeNumbersList,currentNumber);
            currentNumber ++;
        }

        return primeNumbersList;
    }

    /**
     *
     * @param primeNumbersList
     * @param startValue
     */
    private  List<Long> removeDivisorsForValue(List<Long>  primeNumbersList, long startValue){

        for (Iterator<Long> iterator = primeNumbersList.iterator(); iterator.hasNext(); ) {
            Long currNumber = iterator.next();
            if(currNumber % startValue ==0 && currNumber != startValue ){ // It cannot remove currently checked number
                iterator.remove();
            }
        }
        return primeNumbersList;

    }

}
