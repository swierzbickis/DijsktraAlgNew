package com.company;

import com.company.dijkstra.DijkstraExecutor;
import com.company.graphs.builders.EdgeBuilder;
import com.company.graphs.builders.GraphBuilder;
import com.company.graphs.model.Node;
import com.company.prime.numbers.EratostenesSieve;
import com.company.prime.numbers.PrimeNumberHandler;

import java.util.List;

public class Main {

    private static final String ENTRY_FILE_NAME = "sample_entry.txt";

    public static void main(String[] args) {
        //FileHandler.readFile(ENTRY_FILE_NAME);

        EratostenesSieve e = new EratostenesSieve();
        List<Integer> primes =  e.getPrimeNumbers(10000);


        DijkstraExecutor dijkstra =  new DijkstraExecutor();
        dijkstra.executeDijkstra(primes);




        EdgeBuilder.buildEdge(new Node(3), new Node(103));

    }




}
