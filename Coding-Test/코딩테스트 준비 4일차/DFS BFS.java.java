import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V, E;
    static int [][] graph;
    static ArrayList<Integer>[] adj;

    static void print(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        String firstLine = br.readLine();
        V = Integer.parseInt(firstLine.split(" ")[0]);
        E = Integer.parseInt(firstLine.split(" ")[1]);

        //graph = new int[V][E];


        // 인접 행렬 2차원 그래프

        /*for(int i=0; i<E; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start-1][end-1] = 1;
            graph[end-1][start-1] = 1;
        }*/

        //print(graph);

        // 인접 리스트 배열 안 ArrayList (i가 어디로 갈수있는지 알 수 있음)

        adj = new ArrayList[V+1];

        for(int i=0; i< V+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i < E; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start].add(end);
            adj[end].add(start);
        }

        System.out.println(Arrays.toString(adj));
    }
}