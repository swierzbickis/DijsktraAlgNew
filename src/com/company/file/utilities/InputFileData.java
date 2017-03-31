package com.company.file.utilities;

/**
 * Created by Sebek on 2017-03-31.
 */
public class InputFileData {

    private int primeNumberRange;

    int [] inputParameters ;

    public InputFileData(){
    }

    public int getPrimeNumberRange() {
        return primeNumberRange;
    }

    public void setPrimeNumberRange(int primeNumberRange) {
        this.primeNumberRange = primeNumberRange;
    }

    public int[] getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(int[] inputParameters) {
        this.inputParameters = inputParameters;
    }
}
