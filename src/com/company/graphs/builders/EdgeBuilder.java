package com.company.graphs.builders;

import com.company.graphs.model.Node;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * Class used to build edge between every node and it adjacent
 */
public class EdgeBuilder {

    private static final int ZERO_PREFIX_DIGIT_NUMBER =2;
    private static final int MULTIPLE_PREFIX_DIGIT_NUMBER =10;

    /**
     * Method sets Edge in the srcNode. This edge is build between src node and dest node.
     * @param srcNode
     * @param destNode
     */
    public  static void buildEdge(Node srcNode, Node destNode){

        LinkedList<Long> srcNodeDigits = returnNumberAsDigits(srcNode.getNumber());
        LinkedList<Long> destNodeDigits = returnNumberAsDigits(destNode.getNumber());


//        for(int i=0;i<srcNodeDigits.size();i++){
//            System.out.println(srcNodeDigits.get(i));
//        }
//
//        System.out.println("");
//
//        for(int i=0;i<destNodeDigits.size();i++){
//            System.out.println(destNodeDigits.get(i));
//        }
        int notEqDigitsCounter =0;
        int diffDigitIndex = 0;
        for(int i=0;i<srcNodeDigits.size();i++){

            if(destNodeDigits.get(i)!=srcNodeDigits.get(i)){
                notEqDigitsCounter++;
                if(!checkIfNodeIsReachable(notEqDigitsCounter)){
                    return;
                }
                diffDigitIndex = i;
                System.out.println("NOT EQUAL: " + srcNodeDigits.get(i) + " " +destNodeDigits.get(i) );
            }
        }
        Long edgeWeight = countEdgeWeight(srcNodeDigits,destNodeDigits,diffDigitIndex);
        srcNode.addDestinationNode(destNode,edgeWeight);
        System.out.println("EDGE WEIGHT: " + edgeWeight);

    }


    private  static LinkedList<Long> returnNumberAsDigits(Long number){

        // = and int
        LinkedList<Long> digitsList = new LinkedList<Long>();

        while (number > 0) {
            digitsList.push( number % 10 );
            number = number / 10;
        }

        if(digitsList.size()<ZERO_PREFIX_DIGIT_NUMBER && number<MULTIPLE_PREFIX_DIGIT_NUMBER){ //Adds 0 in front of number in case of number is less than 10
            digitsList.push(0l);
        }
        return digitsList;

    }


    /**
     * If one of the nodes  has less number of digits, it should get new padding value.
     * @param srcNodeDigits
     * @param destNodeDigits
     * @return
     */
    private LinkedList<Long>  setNumberPadding(LinkedList<Long> srcNodeDigits,LinkedList<Long> destNodeDigits){

        Long destMostSigDigit = destNodeDigits.get(0);
        Long srcMostSigDigit = srcNodeDigits.get(0);

        if( Math.abs( ( destMostSigDigit - srcMostSigDigit ) ) % 10 == 0 ){

            if(destMostSigDigit > srcMostSigDigit) {
                srcNodeDigits.push(0l);
            }else{
                destNodeDigits.push(0l);
            }

        }
        return  destNodeDigits; //to be fixed . It should be sometimes dest or src node Digits
    }


    private static boolean checkIfNodeIsReachable(int notEqDigitsCounter){
        if(notEqDigitsCounter>1){
            return false;
        }else{
            return true;
        }
    }

    private static  Long countEdgeWeight( LinkedList<Long> srcNodeDigits,LinkedList<Long> destNodeDigits,int diffIndx ){

        Long srcDigit = srcNodeDigits.get(diffIndx);
        Long destDigit = destNodeDigits.get(diffIndx);

        Long digitDiff = Math.abs((srcDigit-destDigit));

        BigInteger bi = BigInteger.valueOf(digitDiff);
        bi = bi.pow(2);
        Long edgeWeight = bi.longValue();

        return edgeWeight;
    }
}
