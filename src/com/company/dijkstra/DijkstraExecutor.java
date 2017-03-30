package com.company.dijkstra;

import com.company.graphs.model.Graph;
import com.company.graphs.builders.GraphBuilder;
import com.company.graphs.model.Node;
import com.company.helpers.TimerHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebek on 2017-03-25.
 */
public class DijkstraExecutor {

    public  void executeDijkstra(List<Integer> primeNumbers){

        long startTime = System.currentTimeMillis();
        Graph dijsktraGraph = GraphBuilder.buildGraph(primeNumbers);
        TimerHelper.printTime(startTime);

        startTime = System.currentTimeMillis();
        dijsktraGraph = DijsktraCalculator.calculateShortestPathFromSrc(dijsktraGraph, dijsktraGraph.getNodes().get(1));
        TimerHelper.printTime(startTime);
        dijsktraGraph.getNodes();

    }

    private  void setNodeAdjacents(Node n,List<Node> graphNodes){
        Integer i=0;
        for(Node node : graphNodes) {
            n.addDestinationNode(node,i++);
        }
    }

    public  void dijkstraTest(){

        Node nodeA = new Node(1);
        Node nodeB = new Node(2);
        Node nodeC = new Node(3);
        Node nodeD = new Node(4);
        Node nodeE = new Node(5);
        Node nodeF = new Node(6);

        nodeA.addDestinationNode(nodeB, 10);
        nodeA.addDestinationNode(nodeC, 15);

        nodeB.addDestinationNode(nodeD, 12);
        nodeB.addDestinationNode(nodeF, 15);

        nodeC.addDestinationNode(nodeE, 10);

        nodeD.addDestinationNode(nodeE, 2);
        nodeD.addDestinationNode(nodeF, 1);

        nodeF.addDestinationNode(nodeE, 5);

        LinkedList<Node> nodesList = new LinkedList<>();

        nodesList.add(nodeA);
        nodesList.add(nodeB);
        nodesList.add(nodeC);
        nodesList.add(nodeD);
        nodesList.add(nodeE);
        nodesList.add(nodeF);

        Graph graph = new Graph();

        graph.setNodes(nodesList);

        graph = DijsktraCalculator.calculateShortestPathFromSrc(graph,nodeA);
        graph.getNodes().size();

    }

    public  void dijkstraTest2(){

        Node node01 = new Node(01);
        Node node41 = new Node(41);
        Node node43 = new Node(43);
        Node node47 = new Node(47);
        Node node53 = new Node(53);
        Node node61 = new Node(61);
        Node node67 = new Node(67);
        Node node71 = new Node(71);
        Node node73 = new Node(73);
        Node node79 = new Node(79);

        node43.addDestinationNode(node41, 4);
        node43.addDestinationNode(node53,1);

        node41.addDestinationNode(node61, 4);
        node41.addDestinationNode(node47, 36);
        node41.addDestinationNode(node01,16);
        node41.addDestinationNode(node71,9);

        node47.addDestinationNode(node41, 6);
        node47.addDestinationNode(node67,4);

        node53.addDestinationNode(node73, 4);
        node61.addDestinationNode(node71,1);

        node71.addDestinationNode(node73, 4);
        node71.addDestinationNode(node79, 64);


        LinkedList<Node> nodesList = new LinkedList<>();


        nodesList.add(node01);
        nodesList.add(node41);
        nodesList.add(node43);
        nodesList.add(node47);
        nodesList.add(node41);
        nodesList.add(node53);
        nodesList.add(node61);
        nodesList.add(node67);
        nodesList.add(node71);
        nodesList.add(node73);
        nodesList.add(node79);

        Graph graph = new Graph();

        graph.setNodes(nodesList);

        graph = DijsktraCalculator.calculateShortestPathFromSrc(graph,node43);
        graph.getNodes().size();

    }


}
