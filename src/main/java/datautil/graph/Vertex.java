package datautil.graph;

import java.util.List;
import java.util.Objects;

public class Vertex {
    public int val;
    public int weight;
    public List<Vertex> siblings;

    public Vertex(int val) {
        this.val = val;
    }

    public Vertex(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return val == vertex.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
