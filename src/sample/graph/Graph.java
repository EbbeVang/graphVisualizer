package sample.graph;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph<T> implements Iterable<T>{
	
	//My vertices
	//LinkedList<T> vertices = new LinkedList<T>();
	public ObservableList<T> vertices = FXCollections.observableArrayList();

	//My Edges
	//LinkedList<Edge> edges = new LinkedList<Edge>();
	public ObservableList<Edge> edges = FXCollections.observableArrayList();


	public void addVertex(T vertex){
		vertices.add(vertex);
	}
	
	public T getVertex(String string){
		for (T vertex: vertices){
			if (vertex.toString().equals(string)) return vertex;
		}
		return null;
	}

	public void removeVertexByIndex(int i)
	{
		removeVertex(vertices.get(i));
	}

	public void removeVertex(T vertex){
		LinkedList<Edge<T>> edgesToBeRemoved = new LinkedList<Edge<T>>();
		
		// remove all edges connected to the Vertex
		for (Edge<T> edge: edges){
			if (edge.getFromVertex().equals(vertex)){
				edgesToBeRemoved.add(edge);
			}
			else if (edge.getToVertex().equals(vertex)){
				edgesToBeRemoved.add(edge);
			}
		}
		edges.removeAll(edgesToBeRemoved);
		
		// remove vertex
		vertices.remove(vertex);
		System.out.println("vertices:"+vertices.size());
		System.out.println("edges:"+edges.size());
	}
	
	public void removeEdge(Edge<T> edge) {
		edges.remove(edge);		
	}

	public void addEdge(T from, T to, int weight){
		Edge edge = new Edge();
		edge.setFromVertex(from);
		edge.setToVertex(to);
		edge.setWeight(weight);
		edges.add(edge);
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getAllVertices() {
		// TODO Auto-generated method stub
		return vertices.toString();
	}
		
	public ObservableList<T> getVerticesAsLinkedList(){
		return vertices;
	}
	
	public ObservableList<Edge> getAllEdgesAsLinkedList() {
		return edges;
	}
	
	public String getAllEdges(){
		StringBuilder builder = new StringBuilder();
		for (Edge edge: edges){
			builder.append(edge.toString());
		}
		return builder.toString();
	}
	
	public boolean isAdjecentVertices(T vertex1, T vertex2){
		for (Edge edge: edges){
			if (edge.getFromVertex().equals(vertex1) && edge.getToVertex().equals(vertex2)){
				return true;
			}
			if (edge.getFromVertex().equals(vertex2) && edge.getToVertex().equals(vertex1)){
				return true;
			}
		}
		return false;
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

	