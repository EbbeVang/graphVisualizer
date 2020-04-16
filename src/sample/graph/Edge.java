package sample.graph;
public class Edge<T>{
	
	T fromVertex;
	T toVertex;
	int weight;

	/**
	 * get the edge represented as a string. suitable for printing in the console or in a GUI
	 * @return edge as string
	 */
	public String toString(){
		return "<"+ toVertex + "-" + weight + "-" + fromVertex + ">";
	}

	/**
	 * get the vertex at the beginning of the edge
	 * @return vertex where the edge begins
	 */
	public T getFromVertex() {
		return fromVertex;
	}

	/**
	 * Set the edge at the end of the edge
	 * @param fromVertex
	 */
	public void setFromVertex(T fromVertex) {
		this.fromVertex = fromVertex;
	}

	/**
	 * Get the vertex at the end of the edge
	 * @return the vertex at the end
	 */
	public T getToVertex() {
		return toVertex;
	}

	/**
	 * Set the vertex at the end of the edge
	 * @param toVertex
	 */
	public void setToVertex(T toVertex) {
		this.toVertex = toVertex;
	}

	/**
	 * get the weight of the edge
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Set the weight of the edge
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
