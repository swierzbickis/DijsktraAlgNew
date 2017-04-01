package com.company;

import com.company.dijkstra.DijkstraExecutor;
import com.company.file.utilities.FileHandler;
import com.company.file.utilities.InputFileData;
import com.company.graphs.builders.EdgeBuilder;
import com.company.graphs.builders.GraphBuilder;
import com.company.graphs.model.Graph;
import com.company.graphs.model.Node;
import com.company.helpers.TimerHelper;
import com.company.prime.numbers.PrimeNumberHandler;

import java.math.BigInteger;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        InputFileData inputData = new InputFileData();
        inputData = FileHandler.readFile(inputData);

        PrimeNumberHandler e = new PrimeNumberHandler();

        BigInteger multiplierBase = new BigInteger("10");
        BigInteger rangeofPrimeNumbers = multiplierBase.pow(inputData.getPrimeNumberRange() );


        List<Integer> primeNumbers =  e.getPrimeNumbers(rangeofPrimeNumbers.intValue());

        long startTime = System.currentTimeMillis();
        Graph dijsktraGraph = GraphBuilder.buildGraph(primeNumbers);
        TimerHelper.printTime("Graph builded in time: ",startTime);

        DijkstraExecutor dijkstra =  new DijkstraExecutor(dijsktraGraph);
        dijkstra.executeDijkstra(primeNumbers, inputData.getInputParameters());


    }




}
