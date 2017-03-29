package com.company.prime.numbers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebek on 2017-03-25.
 */
public class EratostenesSieve {

    private static Long ZERO =0l;

    public  List<Long> getPrimeNumbers(int n) {


        long sum = 0;
      //  long n = 2000000;
        List  primeNumbers = new LinkedList<Long>();
        for (long i = 2; i < n; i++) {
            primeNumbers.add(i);

        }
//weed out the non primes by finding mutiples

        for (int j = 2; j < n; j++) {
            if (primeNumbers.get(j) !=ZERO )//is true
            {
                for (int p = 2; (p * j) < n; p++) {
                    primeNumbers.set( p*j, 0);
                    //primeNumbers(p*j);
                    //e[p * j] = false;
                }
            }
        }

        return primeNumbers;
    }

    public  Boolean[] getPrimeNumbers2(int n) {

        long sum = 0;
        //long n = 2000000;
        Boolean[] e = new Boolean[n]; //by default they're all false
        for (int i = 2; i < n; i++)
        {
            e[i] = true;//set all numbers to true
        }
//weed out the non primes by finding mutiples
        for (int j = 2; j < n; j++)
        {
            if (e[j])//is true
            {
                for (int p = 2; (p*j) < n; p++)
                {
                    e[p * j] = false;
                }
            }
        }

        return e;

    }




}
