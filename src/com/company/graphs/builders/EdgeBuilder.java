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

        LinkedList<Integer> srcNodeDigits = returnNumberAsDigits(srcNode.getNumber());
        LinkedList<Integer> destNodeDigits = returnNumberAsDigits(destNode.getNumber());


        if(srcNodeDigits.size() != destNodeDigits.size()){
            setNumberPadding(srcNodeDigits,destNodeDigits);
        }



        int notEqDigitsCounter =0;
        int diffDigitIndex = 0;
        for(int i=0;i<srcNodeDigits.size();i++){

            if(destNodeDigits.get(i)!=srcNodeDigits.get(i)){
                notEqDigitsCounter++;
                if(!checkIfNodeIsReachable(notEqDigitsCounter)){
                    return;
                }
                diffDigitIndex = i;
                //System.out.println("NOT EQUAL: " + srcNodeDigits.get(i) + " " +destNodeDigits.get(i) );
            }
        }
        Integer edgeWeight = countEdgeWeight(srcNodeDigits,destNodeDigits,diffDigitIndex);
        srcNode.addDestinationNode(destNode,edgeWeight);
        //System.out.println("EDGE WEIGHT: " + edgeWeight);

    }


    private  static LinkedList<Integer> returnNumberAsDigits(Integer number){

        // = and int
        LinkedList<Integer> digitsList = new LinkedList<Integer>();
        while (number > 0) {
            digitsList.push( number % 10 );
            number = number / 10;
        }

//        if(digitsList.size()<ZERO_PREFIX_DIGIT_NUMBER && number<MULTIPLE_PREFIX_DIGIT_NUMBER){ //Adds 0 in front of number in case of number is less than 10
//            digitsList.push(0l);
//        }
        return digitsList;

    }


    /**
     * If one of the nodes  has less number of digits, it should get new padding value.
     * @param //srcNodeDigits
     * @param //destNodeDigits
     * @return
     */
    private static void  setNumberPadding(LinkedList<Integer> srcNodeDigits,LinkedList<Integer> destNodeDigits) {

        if (srcNodeDigits.size() > destNodeDigits.size()){
            int paddingSize =   (srcNodeDigits.size() - destNodeDigits.size()) ;

            for(int i=0;i<paddingSize;i++){
                destNodeDigits.push(0);
            }

        }else{

            int paddingSize =  (destNodeDigits.size() - srcNodeDigits.size()) ;

            for(int i=0;i<paddingSize;i++){
                srcNodeDigits.push(0);
            }

        }

    }


    private static boolean checkIfNodeIsReachable(int notEqDigitsCounter){
        if(notEqDigitsCounter>1){
            return false;
        }else{
            return true;
        }
    }

    private static  Integer countEdgeWeight( LinkedList<Integer> srcNodeDigits,LinkedList<Integer> destNodeDigits,int diffIndx ){

        Integer srcDigit = srcNodeDigits.get(diffIndx);
        Integer destDigit = destNodeDigits.get(diffIndx);

        Integer digitDiff = Math.abs((srcDigit-destDigit));

        //In case of 9 -> 0 converts
        if(digitDiff >5){
            digitDiff = 10 - digitDiff;
        }

        Integer edgeWeight = digitDiff * digitDiff;

        return edgeWeight;
    }
}