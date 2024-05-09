import java.util.*;

class Graph {
    private Map<Character, List<Pair<Character, Integer>>> adjacList;

    public Graph(Map<Character, List<Pair<Character, Integer>>> adjacList) {
        this.adjacList = adjacList;
    }

    public List<Pair<Character, Integer>> getNeighbors(Character v) {
        return adjacList.get(v);
    }

    public int h(Character n) {
        Map<Character, Integer> H = new HashMap<>();
        H.put('S', 5);
        H.put('A', 3);
        H.put('B', 4);
        H.put('C', 2);
        H.put('D', 6);
        H.put('G', 0);
        return H.get(n);
    }

    public List<Character> aStarAlgorithm(Character start, Character stop) {
        Set<Character> openList = new HashSet<>(Arrays.asList(start));
        Set<Character> closedList = new HashSet<>();
        Map<Character, Integer> fScore = new HashMap<>();
        fScore.put(start, 0);
        Map<Character, Character> parent = new HashMap<>();
        parent.put(start, start);

        while (!openList.isEmpty()) {
            Character current = null;
            for (Character v : openList) {
                if (current == null || fScore.getOrDefault(v, Integer.MAX_VALUE) + h(v) < fScore.getOrDefault(current, Integer.MAX_VALUE) + h(current)) {
                    current = v;
                }
            }
            if (current == null) {
                System.out.println("Path does not exist!");
                return null;
            }
            if (current.equals(stop)) {
                List<Character> reconstructedPath = new ArrayList<>();
                while (!parent.get(current).equals(current)) {
                    reconstructedPath.add(current);
                    current = parent.get(current);
                }
                reconstructedPath.add(start);
                Collections.reverse(reconstructedPath);
                System.out.println("Path found: " + reconstructedPath);
                return reconstructedPath;
            }
            for (Pair<Character, Integer> neighbor : getNeighbors(current)) {
                Character m = neighbor.getKey();
                Integer weight = neighbor.getValue();
                int tentativeFScore = fScore.getOrDefault(current, Integer.MAX_VALUE) + weight;
                if (!openList.contains(m) && !closedList.contains(m)) {
                    openList.add(m);
                    parent.put(m, current);
                    fScore.put(m, tentativeFScore);
                } else {
                    if (tentativeFScore < fScore.getOrDefault(m, Integer.MAX_VALUE)) {
                        parent.put(m, current);
                        fScore.put(m, tentativeFScore);
                        if (closedList.contains(m)) {
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }
            openList.remove(current);
            closedList.add(current);
        }
        System.out.println("Path does not exist!");
        return null;
    }

    public static void main(String[] args) {
        Map<Character, List<Pair<Character, Integer>>> adjacList = new HashMap<>();
        adjacList.put('S', Arrays.asList(new Pair('A', 1), new Pair('G', 10)));
        adjacList.put('A', Arrays.asList(new Pair('B', 2), new Pair('C', 1)));
        adjacList.put('B', Arrays.asList(new Pair('D', 5)));
        adjacList.put('C', Arrays.asList(new Pair('D', 4), new Pair('G', 4)));
        adjacList.put('D', Arrays.asList(new Pair('G', 2)));
        Graph graph = new Graph(adjacList);
        System.out.println("\nGraph is\n");
        for (Character vertex : adjacList.keySet()) {
            System.out.print(vertex + " : ");
            for (Pair<Character, Integer> pair : adjacList.get(vertex)) {
                System.out.print("(" + pair.getKey() + ", " + pair.getValue() + ") ");
            }
            System.out.println();
        }
        System.out.println("\nA Star Search : \n");
        graph.aStarAlgorithm('S', 'G');
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
