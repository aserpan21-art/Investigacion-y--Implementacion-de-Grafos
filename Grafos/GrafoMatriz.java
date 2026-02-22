import java.util.*;

public class GrafoMatriz {

    private int[][] matriz;
    private Map<String, Integer> vertices;
    private int contador;

    public GrafoMatriz(int tamaño) {
        matriz = new int[tamaño][tamaño];
        vertices = new HashMap<>();
        contador = 0;
    }

    public void agregarVertice(String v) {
        if (!vertices.containsKey(v)) {
            vertices.put(v, contador++);
        }
    }

    public void agregarArista(String a, String b) {
        int i = vertices.get(a);
        int j = vertices.get(b);
        matriz[i][j] = 1;
        matriz[j][i] = 1;
    }

    public void mostrarMatriz() {
        for (int i = 0; i < contador; i++) {
            for (int j = 0; j < contador; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GrafoMatriz g = new GrafoMatriz(4);

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");

        g.agregarArista("A", "B");
        g.agregarArista("B", "C");
        g.agregarArista("C", "D");
        g.agregarArista("D", "A");

        g.mostrarMatriz();
    }
}