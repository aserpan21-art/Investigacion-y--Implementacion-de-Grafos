import java.util.*;

public class GrafoListaDFS {

    private LinkedHashMap<String, List<String>> grafo;

    public GrafoListaDFS() {
        grafo = new LinkedHashMap<>();
    }

    public void agregarVertice(String v) {
        if (!grafo.containsKey(v)) {
            grafo.put(v, new ArrayList<>());
        }
    }

    public void agregarArista(String a, String b) {
        if (!grafo.containsKey(a) || !grafo.containsKey(b)) {
            System.out.println("Error: uno o ambos vértices no existen (" + a + ", " + b + ")");
            return;
        }
        grafo.get(a).add(b);
        grafo.get(b).add(a);
    }

    public void mostrarGrafo() {
        for (String vertice : grafo.keySet()) {
            System.out.println(vertice + " -> " + grafo.get(vertice));
        }
    }

    public void dfs(String inicio) {
        if (!grafo.containsKey(inicio)) {
            System.out.println("Error: el vértice '" + inicio + "' no existe en el grafo.");
            return;
        }
        Set<String> visitados = new HashSet<>();
        System.out.print("Recorrido DFS: ");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(String actual, Set<String> visitados) {
        visitados.add(actual);
        System.out.print(actual + " ");

        for (String vecino : grafo.get(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    public static void main(String[] args) {
        GrafoListaDFS g = new GrafoListaDFS();

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");

        g.agregarArista("A", "B");
        g.agregarArista("A", "C");
        g.agregarArista("B", "D");

        g.mostrarGrafo();
        System.out.println();

        g.dfs("A");
    }
}