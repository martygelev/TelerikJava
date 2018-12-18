package minimalSpanningTree;

public class Edge implements Comparable<Edge> {
    private int start;
    private int end;
    private int weight;

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.getWeight());
    }


    public Edge(int start, int end, int weight) {
        setStart(start);
        setEnd(end);
        setWeight(weight);
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("(%s %s) -> %s", getStart(),getEnd(), getWeight());
    }
}
