import java.util.*;

public class GrafoLista {

    private HashMap<String, List<String>> grafo;

    public GrafoLista() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String v) {
        if (!grafo.containsKey(v)) {
            grafo.put(v, new ArrayList<>());
        }
    }

    public void agregarArista(String a, String b) {
        if (grafo.containsKey(a) && grafo.containsKey(b)) {
            grafo.get(a).add(b);
            grafo.get(b).add(a);
        }
    }

    public void mostrarGrafo() {
        for (String vertice : grafo.keySet()) {
            System.out.println(vertice + " -> " + grafo.get(vertice));
        }
    }

    public static void main(String[] args) {

        GrafoLista g = new GrafoLista();

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");

        g.agregarArista("A", "B");
        g.agregarArista("A", "C");
        g.agregarArista("B", "D");

        g.mostrarGrafo();
    }
}