package SelfLearning.HasPathGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private static HashMap<Integer, Node> nodeLookup = new HashMap<>();

    private static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    private void addEdge(int sourceId, int destinationId) {
        Node source = getNode(sourceId);
        Node destination = getNode(destinationId);
        source.adjacent.add(destination);
    }

    // Depth-First Search
    public boolean hasPathInDFS(int sourceId, int destinationId) {
        Node source = getNode(sourceId);
        Node destination = getNode(destinationId);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathInDFS(source, destination, visited);
    }

    public boolean hasPathInDFS(Node source, Node destination, HashSet<Integer> visited) {
        // ถ้าเกิดว่า source เคยถูกเก็บใน visited แล้ว
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);
        // ถ้าเจอแล้วก็ return true ออกไป
        if (source == destination) {
            return true;
        }
        // แต่ถ้ายังให้มาวนไล่หาจาก Node ใกล้เคียง (adjacent)
        for (Node node : source.adjacent) {
            if (hasPathInDFS(node, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathInBFS(int sourceId, int destinationId) {
        Node source = getNode(sourceId);
        Node destination = getNode(destinationId);

        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == destination) {
                return true;
            }
            if (visited.contains(source.id)) {
                continue;
            }

            visited.add(source.id);
            
            for (Node nearbyNode : node.adjacent) {
                queue.add(nearbyNode);
            }
        }
        return false;
    }

}