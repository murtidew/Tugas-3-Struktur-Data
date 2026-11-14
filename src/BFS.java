
import java.util.*;

public class BFS {

    static Map<String, List<String>> graph = new LinkedHashMap<>();
    static Map<String, Integer> data = new LinkedHashMap<>();

    static void bfs(String start, int target) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String node = queue.poll();

            System.out.println("Mengunjungi " + node +
                    " dengan nilai " + data.get(node));

            if (data.get(node) == target) {
                System.out.println("Angka " + target +
                        " ditemukan pada node " + node);
                return;
            }

            for (String neighbor : graph.get(node)) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Angka " + target +
                " tidak ditemukan dalam graf.");
    }

    public static void main(String[] args) {

        data.put("a1", 10);
        data.put("a2", 20);
        data.put("a3", 30);
        data.put("a4", 44);
        data.put("a5", 50);
        data.put("a6", 60);
        data.put("a7", 70);
        data.put("a8", 80);

        graph.put("a1", Arrays.asList("a2", "a3"));
        graph.put("a2", Arrays.asList("a4", "a5"));
        graph.put("a3", Arrays.asList("a6", "a7"));
        graph.put("a4", new ArrayList<>());
        graph.put("a5", Arrays.asList("a8"));
        graph.put("a6", new ArrayList<>());
        graph.put("a7", new ArrayList<>());
        graph.put("a8", new ArrayList<>());

        int target = 44;

        System.out.println("=== PENCARIAN BFS ===");
        bfs("a1", target);
    }
}
