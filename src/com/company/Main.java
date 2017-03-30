package com.company;

import com.company.dijkstra.DijkstraExecutor;
import com.company.file.utilities.FileHandler;
import com.company.graphs.builders.EdgeBuilder;
import com.company.graphs.builders.GraphBuilder;
import com.company.graphs.model.Graph;
import com.company.graphs.model.Node;
import com.company.prime.numbers.EratostenesSieve;
import com.company.prime.numbers.PrimeNumberHandler;

import java.util.List;

public class Main {

    private static final String ENTRY_FILE_NAME = "sredni2_in.txt";

    public static void main(String[] args) {
        int [] inputParameters = FileHandler.readFile(ENTRY_FILE_NAME);

        EratostenesSieve e = new EratostenesSieve();
        List<Integer> primeNumbers =  e.getPrimeNumbers(10000);

        Graph dijsktraGraph = GraphBuilder.buildGraph(primeNumbers);
        DijkstraExecutor dijkstra =  new DijkstraExecutor(dijsktraGraph);
        dijkstra.executeDijkstra(primeNumbers, inputParameters);




        EdgeBuilder.buildEdge(new Node(3), new Node(103));

    }




}
