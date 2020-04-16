package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.graph.Edge;
import sample.graph.Graph;

public class Controller {

   GraphicsContext graphicsContext;
   Graph<Vertex> graph = new Graph<>();

    public void initialize()
    {
        graphicsContext = canvas.getGraphicsContext2D();
        listViewEdges.setItems(graph.getEdges());
        listViewVertices.setItems(graph.getVertices());
        
    }

    private void draw(GraphicsContext graphicsContext) {
        graphicsContext.clearRect(0,0, 500, 500);
        for (Vertex vertex : graph.getVertices()) {
            vertex.draw(graphicsContext);
        }
        for (Edge edge: graph.getEdges())
        {
            Vertex from = (Vertex) edge.getFromVertex();
            Vertex to = (Vertex) edge.getToVertex();
            graphicsContext.strokeLine(from.getX()+10, from.getY()+10, to.getX()+10, to.getY()+10);
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
        for (Vertex vertexA: graph.getVertices()) {
            for (Vertex vertexB: graph.getVertices()) {
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
        for (int i = 0; i < graph.getVertices().size(); i++) {
            if (graph.getVertices().get(i).isSelected()){
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
            Vertex closestVertex = graph.getVertices().get(0);
            double shortestDistance = Double.MAX_VALUE;
            for (Vertex vertex: graph.getVertices()) {
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
