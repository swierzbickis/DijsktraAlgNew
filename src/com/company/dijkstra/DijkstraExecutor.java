package com.company.dijkstra;

import com.company.file.utilities.FileHandler;
import com.company.graphs.model.Graph;
import com.company.graphs.builders.GraphBuilder;
import com.company.graphs.model.Node;
import com.company.helpers.TimerHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebek on 2017-03-25.
 */
public class DijkstraExecutor {

    Graph dijsktraGraph;
    List <String> resultNumbers = new ArrayList<>();


    public DijkstraExecutor(Graph dijsktraGraph) {
        this.dijsktraGraph = dijsktraGraph;
    }

    public void executeDijkstra(List<Integer> primeNumbers, int[] inputParameters) {


        long startTime = System.currentTimeMillis();
        calcDijkstraForInputParams(primeNumbers, inputParameters);

        TimerHelper.printTime("Dijkstra executed in : " , startTime);
        saveResultIntoFile();
        dijsktraGraph.getNodes();

    }

    private void calcDijkstraForInputParams(List<Integer> primeNumbers, int[] inputParameters) {


        for (int i = 0; i < inputParameters.length; i += 2) {
            Integer srcNodeNumber = inputParameters[i];
            dijsktraGraph = DijsktraCalculator.calculateShortestPathFromSrc(dijsktraGraph,
                    dijsktraGraph.getNodeByItsNumber(srcNodeNumber));
            int destNodeIndex = i + 1;
            addResultToList(inputParameters, destNodeIndex);
            setDistancesToInfinity(dijsktraGraph);
        }

    }

    private void addResultToList(int[] inputParameters, int destNodeIndex){
        Node destNode = dijsktraGraph.getNodeByItsNumber(inputParameters[destNodeIndex]);
      //  printShortestPathInfo(destNode);
        resultNumbers.add( ( destNode.getDistance().toString() ) );
    }

    private void setDistancesToInfinity(Graph dijsktraGraph){
        List<Node> nodes = dijsktraGraph.getNodes();
        for(Node n : nodes){
            n.setDistance(Integer.MAX_VALUE);
        }

    }

    private void printShortestPathInfo(Node destNode){
       List<Node> shortestPath =  destNode.getShortestPath();
        System.out.println("Shortest path to node: " + destNode.getNumber());
        System.out.println("Path cost: " + destNode.getDistance());
       for(Node n : shortestPath){
           System.out.println(n.getNumber());
       }

    }

    private void saveResultIntoFile() {
        FileHandler.writeToOutputFile(resultNumbers);
    }

}




