package com.company.dijkstra;

import com.company.file.utilities.FileHandler;
import com.company.graphs.model.Graph;
import com.company.graphs.builders.GraphBuilder;
import com.company.graphs.model.Node;
import com.company.helpers.TimerHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebek on 2017-03-25.
 */
public class DijkstraExecutor {

    Graph dijsktraGraph;

    public DijkstraExecutor(Graph dijsktraGraph) {
        this.dijsktraGraph = dijsktraGraph;
    }

    public void executeDijkstra(List<Integer> primeNumbers, int[] inputParameters) {

        long startTime = System.currentTimeMillis();
        // Graph dijsktraGraph = GraphBuilder.buildGraph(primeNumbers);
        TimerHelper.printTime(startTime);
        calcDijkstraForInputParams(primeNumbers, inputParameters);
        startTime = System.currentTimeMillis();
        // dijsktraGraph = DijsktraCalculator.calculateShortestPathFromSrc(dijsktraGraph, dijsktraGraph.getNodes().get(1));
        TimerHelper.printTime(startTime);
        dijsktraGraph.getNodes();

    }

    private void calcDijkstraForInputParams(List<Integer> primeNumbers, int[] inputParameters) {

        for (int i = 2; i < inputParameters.length; i += 2) {
            Integer srcNodeNumber = inputParameters[i];
            dijsktraGraph = DijsktraCalculator.calculateShortestPathFromSrc(dijsktraGraph,
                    dijsktraGraph.getNodeByItsNumber(srcNodeNumber));
            int destNodeIndex = i + 1;
            saveResultIntoFile(inputParameters, destNodeIndex);
        }

    }

    private void saveResultIntoFile(int[] inputParameters, int destNodeIndex) {
        Node resultNode = dijsktraGraph.getNodeByItsNumber(inputParameters[destNodeIndex]);
        System.out.println(resultNode.getDistance().toString());
        FileHandler.writeToOutputFile(resultNode.getDistance().toString());
    }

}




