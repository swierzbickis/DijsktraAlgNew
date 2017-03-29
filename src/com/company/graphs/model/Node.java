package com.company.graphs.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private Long number;

    private Long distance = Long.MAX_VALUE; // distance from source value

    Map<Node, Long> adjacentNodes = new HashMap<>();

    private List<Node> shortestPath = new LinkedList<>();


    public Node(Long number){
        this.number = number;
    }


    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Map<Node, Long> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void addDestinationNode(Node destination, long distance) {
        adjacentNodes.put(destination, distance);
    }

    public void setAdjacentNodes(Map<Node, Long> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
}