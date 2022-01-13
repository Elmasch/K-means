package com.company;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.*;

public class Point {

    double x;
    double y;
    Point Barycentre;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point getBarycentre() {
        return Barycentre;
    }

    public void setBarycentre(Point barycentre) {
        Barycentre = barycentre;
    }

    public double distance(Point p1){
        return sqrt(pow((this.x - p1.x),2) + pow((this.y - p1.y),2));
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", Barycentre=" + Barycentre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.getX(), getX()) == 0 && Double.compare(point.getY(), getY()) == 0 && Objects.equals(getBarycentre(), point.getBarycentre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getBarycentre());
    }
}








