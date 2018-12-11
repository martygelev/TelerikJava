package topologicalSorting;

public class Main
{
    public static void main(String[] args)
    {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(4,5);
        graph.addEdge(7,4);
        graph.addEdge(7,6);
        graph.sort();




    }
}
