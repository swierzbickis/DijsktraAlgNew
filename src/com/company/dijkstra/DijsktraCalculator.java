package com.company.dijkstra;

import com.company.graphs.model.Graph;
import com.company.graphs.model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sebek on 2017-03-25.
 */
public class DijsktraCalculator {

    public static Graph calculateShortestPathFromSrc(Graph graph, Node source){

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unSettledNodes = new HashSet<>();

        unSettledNodes.add(source);

        while(unSettledNodes.size()!=0){
            Node currentNode = getLowestDistanceNode(unSettledNodes);
            unSettledNodes.remove(currentNode);

            for (Map.Entry< Node, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if(!settledNodes.contains(adjacentNode)){
                    CalculateMinimumDistance(adjacentNode,edgeWeight,currentNode);
                    unSettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        Integer lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            Integer nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void CalculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);

            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }




}
