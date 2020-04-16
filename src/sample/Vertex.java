package sample;

import javafx.scene.canvas.GraphicsContext;

public class Vertex {
    public Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vertex(double x, double y, boolean selected) {
        this(x,y);
        this.selected = selected;
    }

    String name;

    private double x;
    private double y;
    private boolean selected;

    public void draw(GraphicsContext graphicsContext)
    {
        if (selected){
            graphicsContext.fillOval(x,y,20,20);
        }
        else{
            graphicsContext.strokeOval(x-2,y-2, 24,24);
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        if (name == null) {
            return "Vertex{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
        else return name;
    }
}
