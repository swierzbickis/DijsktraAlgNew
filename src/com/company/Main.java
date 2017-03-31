package com.company;

import com.company.dijkstra.DijkstraExecutor;
import com.company.file.utilities.FileHandler;
import com.company.file.utilities.InputFileData;
import com.company.graphs.builders.EdgeBuilder;
import com.company.graphs.builders.GraphBuilder;
import com.company.graphs.model.Graph;
import com.company.graphs.model.Node;
import com.company.prime.numbers.PrimeNumberHandler;

import java.math.BigInteger;
import java.util.List;

public class Main {

    private static final String ENTRY_FILE_NAME = "inputFile.txt";

    public static void main(String[] args) {
        InputFileData inputData = new InputFileData();
        inputData = FileHandler.readFile(ENTRY_FILE_NAME,inputData);


        PrimeNumberHandler e = new PrimeNumberHandler();

        BigInteger multiplierBase = new BigInteger("10");
        BigInteger rangeofPrimeNumbers = multiplierBase.pow(inputData.getPrimeNumberRange() );


        List<Integer> primeNumbers =  e.getPrimeNumbers(rangeofPrimeNumbers.intValue());
        System.out.println(primeNumbers.size());

        Graph dijsktraGraph = GraphBuilder.buildGraph(primeNumbers);
        DijkstraExecutor dijkstra =  new DijkstraExecutor(dijsktraGraph);
        dijkstra.executeDijkstra(primeNumbers, inputData.getInputParameters());




        EdgeBuilder.buildEdge(new Node(3), new Node(103));

    }




}
