package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.graph.Edge;
import sample.graph.Graph;

import java.util.LinkedList;
import java.util.zip.CheckedOutputStream;

public class Controller {

   GraphicsContext graphicsContext;
   Graph<Vertex> graph = new Graph<>();

    public void initialize()
    {
        graphicsContext = canvas.getGraphicsContext2D();
        listViewEdges.setItems(graph.edges);
        listViewVertices.setItems(graph.vertices);
        
    }

    private void draw(GraphicsContext graphicsContext) {
        graphicsContext.clearRect(0,0, 500, 500);
        for (Vertex vertex : graph.getVerticesAsLinkedList()) {
            vertex.draw(graphicsContext);
        }
        for (Edge edge: graph.getAllEdgesAsLinkedList())
        {
            Vertex from = (Vertex) edge.getFromVertex();
            Vertex to = (Vertex) edge.getToVertex();
            graphicsContext.moveTo(from.getX()+10, from.getY()+10);
            graphicsContext.lineTo(to.getX()+10, to.getY()+10);
            graphicsContext.stroke();
        }
    }

    @FXML
    private Pane paneCanvas;

    @FXML
    private Canvas canvas;

    @FXML
    private ListView<Vertex> listViewVertices;

    @FXML
    private ListView<Edge> listViewEdges;

    @FXML
    void ConnectVertices(ActionEvent event) {
        for (Vertex vertexA: graph.getVerticesAsLinkedList()) {
            for (Vertex vertexB: graph.getVerticesAsLinkedList()) {
                if (vertexA.isSelected() && vertexB.isSelected() && !vertexA.equals(vertexB) && !graph.isAdjecentVertices(vertexA, vertexB)){
                    double edgeLength = Math.sqrt(Math.pow(vertexA.getX() - vertexB.getX(), 2) + Math.pow(vertexA.getY()- vertexB.getY(), 2));
                    graph.addEdge(vertexA, vertexB, (int)edgeLength);
                }

            }
        }
        draw(graphicsContext);
    }



    @FXML
    void removeVertex(ActionEvent event) {
        for (int i = 0; i < graph.vertices.size(); i++) {
            if (graph.getVerticesAsLinkedList().get(i).isSelected()){
                graph.removeVertexByIndex(i);
            }
        }
        draw(graphicsContext);

    }

    @FXML
    void mouseClickedOnCanvas(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            double x = event.getX();
            double y = event.getY();
            graph.addVertex(new Vertex(x, y));
            draw(graphicsContext);
        }
        else if (event.getButton() == MouseButton.SECONDARY)
        {
            //find closest Vertex and flip selected
            Vertex closestVertex = graph.vertices.get(0);
            double shortestDistance = Double.MAX_VALUE;
            for (Vertex vertex: graph.getVerticesAsLinkedList()) {
                double xDist = Math.abs(vertex.getX() - event.getX());
                double yDist = Math.abs(vertex.getY() - event.getY());
                double dist = xDist + yDist;
                if (dist < shortestDistance){
                    closestVertex = vertex;
                    shortestDistance = dist;
                }
            }
            closestVertex.setSelected(!closestVertex.isSelected());
            draw(graphicsContext);
        }

    }

}
