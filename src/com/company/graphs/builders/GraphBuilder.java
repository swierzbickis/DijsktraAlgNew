package com.company.graphs.builders;

import com.company.graphs.model.Graph;
import com.company.graphs.model.Node;

import java.util.LinkedList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by Sebek on 2017-03-26.
 */
public class GraphBuilder {

    public  static Graph buildGraph(List<Integer> primeNumbers){


        List<Node> graphNodes = new LinkedList<>();

        for(Integer p : primeNumbers){
            graphNodes.add(new Node(p));
        }

        Graph dijsktraGraph = new Graph();

        for(Node n : graphNodes){
            setNodeAdjacents(n,graphNodes);

        }
        dijsktraGraph.setNodes(graphNodes);

        return dijsktraGraph;

    }

    private static void setNodeAdjacents(Node srcNode,List<Node> graphNodes){
        Integer i=0;
        for(Node destNode : graphNodes) {
            EdgeBuilder.buildEdge(srcNode,destNode);
        }
    }

//    private static void setNodeAdjacents(Node n,List<Node> graphNodes){
//        Integer i=0;
//        for(Node node : graphNodes) {
//            n.addDestinationNode(node,i++);
//        }
//    }




}