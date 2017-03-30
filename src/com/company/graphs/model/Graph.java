package com.company.graphs.model;

import java.util.List;
import java.util.stream.Collectors;

public class Graph {
	
	private List<Node> nodes;

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Method look up for concrete node in nodes set by its number.
	 * @param number Number of the node
	 * @return Concrete Node
	 */
	public Node getNodeByItsNumber(Integer number){
		List<Node> result = nodes.stream()
				.filter(item -> item.getNumber().equals(number))
				.collect(Collectors.toList());
		return  result.get(0);
	}


}
