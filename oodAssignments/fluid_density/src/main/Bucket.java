package main;

public class Bucket {
    private double width;
    private double length;
    private double height;
    private double depth;

    public void setWidth(double width){
        this.width=width;
    }
    public void setLength(double length){
        this.length=length;
    }
    public void setHeight(double height){
        this.height=height;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth(){
        return width;
    }

    public double getDepth() {
        return depth;
    }
    public void setDepth(double depth){
        this.depth=depth;
    }
}//• Each bucket has a width, length and a height measured in meters
