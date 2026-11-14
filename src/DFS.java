
import java.util.*;

public class DFS {

    static Map<String, List<String>> graph = new LinkedHashMap<>();
    static Map<String, Integer> data = new LinkedHashMap<>();
    static Set<String> visited = new LinkedHashSet<>();

    static boolean dfs(String node, int target) {

        visited.add(node);

        System.out.println("Mengunjungi " + node +
                " dengan nilai " + data.get(node));


        if (data.get(node) == target) {
            System.out.println("Angka " + target +
                    " ditemukan pada node " + node);
            return true;
        }

        for (String neighbor : graph.get(node)) {

            if (!visited.contains(neighbor)) {

                if (dfs(neighbor, target)) {
                    return true;
                }
            }
        }

        return false;
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

        System.out.println("=== PENCARIAN DFS ===");
        dfs("a1", target);
    }
}
