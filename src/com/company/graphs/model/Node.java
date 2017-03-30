package com.company.graphs.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private Integer number;

    private Integer distance = Integer.MAX_VALUE; // distance from source value

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    private List<Node> shortestPath = new LinkedList<>();


    public Node(Integer number){
        this.number = number;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void addDestinationNode(Node destination, Integer distance) {
        adjacentNodes.put(destination, distance);
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
}