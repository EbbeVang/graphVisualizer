package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import sample.graph.Edge;

public class Controller {

    @FXML
    private Canvas canvas;

    @FXML
    private ListView<Vertex> listViewVertices;

    @FXML
    private ListView<Edge> listViewEdges;

}