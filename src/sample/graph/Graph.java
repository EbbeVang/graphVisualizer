package sample.graph;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Create a graph with T vertices
 * @param <T>
 */
public class Graph<T> implements Iterable<T>{
	
	//My vertices
	//LinkedList<T> vertices = new LinkedList<T>();
	private ObservableList<T> vertices = FXCollections.observableArrayList();

	//My Edges
	//LinkedList<Edge> edges = new LinkedList<Edge>();
	private ObservableList<Edge> edges = FXCollections.observableArrayList();


	/**
	 * Add a Vertex to the graph.
	 * @param vertex
	 */
	public void addVertex(T vertex){
		getVertices().add(vertex);
	}

	/**
	 * get a vertex based on a string. you must use the exact same string as the vertex' tostring method returns
	 * You are not advised to use this method. It is obsolete!
	 * @param string
	 * @return
	 */
	public T getVertex(String string){
		for (T vertex: getVertices()){
			if (vertex.toString().equals(string)) return vertex;
		}
		return null;
	}

	/**
	 * Remove a Vertex from the graph based on its index number
	 * @param i
	 */
	public void removeVertexByIndex(int i)
	{
		removeVertex(getVertices().get(i));
	}

	/**
	 * remove a Vertex object from graph
	 * @param vertex
	 */
	public void removeVertex(T vertex){
		LinkedList<Edge<T>> edgesToBeRemoved = new LinkedList<Edge<T>>();
		
		// remove all edges connected to the Vertex
		for (Edge<T> edge: getEdges()){
			if (edge.getFromVertex().equals(vertex)){
				edgesToBeRemoved.add(edge);
			}
			else if (edge.getToVertex().equals(vertex)){
				edgesToBeRemoved.add(edge);
			}
		}
		getEdges().removeAll(edgesToBeRemoved);
		
		// remove vertex
		getVertices().remove(vertex);
		System.out.println("vertices:"+ getVertices().size());
		System.out.println("edges:"+ getEdges().size());
	}

	/**
	 * Remove an Edge from the graph.
	 * @param edge
	 */
	public void removeEdge(Edge<T> edge) {
		getEdges().remove(edge);
	}

	/**
	 * Add an edge to the weighted graph, you muyst provide the two vertices it connects and the weight
	 *
	 *
	 * @param from the vertex the edge goes from
	 * @param to the vertex the edge go to
	 * @param weight the weight of the edge
	 */
	public void addEdge(T from, T to, int weight){
		Edge edge = new Edge();
		edge.setFromVertex(from);
		edge.setToVertex(to);
		edge.setWeight(weight);
		getEdges().add(edge);
	}

	/**
	 * add an edge to the the graph. You mist provide the vertices it goes from and to
	 *
	 * @param from the vertex that the edge goes from
	 * @param to the vertex that the edge goes to
	 */
	public void addEdge(T from, T to)
	{
		addEdge(from, to, 0);
	}


	/**
	 * unimplemented! cannot be used
	 * will always return null
	 * @return
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get all vertices in the graph as a string.
	 * @return
	 */
	public String getAllVertices() {
		// TODO Auto-generated method stub
		return getVertices().toString();
	}



	/**
	 * Get all edges as a string to be printed
	 * @return all edges in a string
	 */
	public String getAllEdges(){
		StringBuilder builder = new StringBuilder();
		for (Edge edge: getEdges()){
			builder.append(edge.toString());
		}
		return builder.toString();
	}

	/**
	 * check if two vertices has an edge between them
	 * @param vertex1 first vertex
	 * @param vertex2 second vertex
	 * @return whether or not the to vertices is adjecent / have an edge between them
	 */
	public boolean isAdjecentVertices(T vertex1, T vertex2){
		for (Edge edge: getEdges()){
			if (edge.getFromVertex().equals(vertex1) && edge.getToVertex().equals(vertex2)){
				return true;
			}
			if (edge.getFromVertex().equals(vertex2) && edge.getToVertex().equals(vertex1)){
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * @return
	 */
	public ObservableList<T> getVertices() {
		return vertices;
	}


	public void setVertices(ObservableList<T> vertices) {
		this.vertices = vertices;
	}

	public ObservableList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ObservableList<Edge> edges) {
		this.edges = edges;
	}

	// an iterator  that uses Depth-First-Search
	private class GraphIterator implements Iterator<T>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}

	