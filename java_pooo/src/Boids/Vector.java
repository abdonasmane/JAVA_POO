package boids;
public class Vector {
    int x;
    int y;

    protected Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected Vector(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    protected Vector() {
        this.x = 0;
        this.y = 0;
    }

    protected Vector add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }

    protected Vector sub(Vector vector) {
        this.x -= vector.x;
        this.y -= vector.y;
        return this;
    }
    
    protected Vector div(int N) {
        this.x /= N;
        this.y /= N;
        return this;
    }

    protected Vector mult(double f) {
        this.x *= f;
        this.y *= f;
        return this;
    }

    protected int distance(Vector vector) {
        return (int)Math.sqrt(Math.pow(this.x - vector.x, 2) + Math.pow(this.y - vector.y, 2));
    }

    @Override
    public String toString() {
        return "("+this.x+", "+this.y+")";
    }
}
