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
        PrimeNumberHandler pr = new PrimeNumberHandler();
        List<Long> primeNumbers = pr.getPrimeNumbers(1000);
        System.out.println(primeNumbers.size());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        EratostenesSieve e = new EratostenesSieve();
        // e.getPrimeNumbers(100);

        DijkstraExecutor dijkstra =  new DijkstraExecutor();
        // dijkstra.buildGraph(primeNumbers);
        // DijkstraExecutor.buildGraph(primeNumbers);
        dijkstra.dijkstraTest2();


        testStack();

        EdgeBuilder.buildEdge(new Node(3l), new Node(103l));


    }


    /**
     * Method used to indicate if node is reachable from another node.
     */
    private static void testStack(){

//        int number=90; // = and int
//        LinkedList<Integer> stack = new LinkedList<Integer>();
//
//
//
//
//        while (number > 0) {
//            stack.push( number % 10 );
//            number = number / 10;
//        }
//
//
//        if(stack.size()<2 && number<10){
//            stack.push(0);
//        }
//
//
//        for(int i=0;i<stack.size();i++){
//            System.out.println(stack.get(i));
//        }

//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        //   System.out.println(stack.size());


    }



}
