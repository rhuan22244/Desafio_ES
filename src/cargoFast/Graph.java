package cargoFast;

import models.Edge;
import models.Path;

import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addCity(String city) {
        adjacencyList.putIfAbsent(city, new ArrayList<>());
    }

    public void addEdge(String from, String to, int distance, int cost) {
        adjacencyList.get(from).add(new Edge(to, distance, cost));
        adjacencyList.get(to).add(new Edge(from, distance, cost));
    }

    public void removeEdge(String from, String to) {
        adjacencyList.get(from).removeIf(edge -> edge.city.equals(to));
        adjacencyList.get(to).removeIf(edge -> edge.city.equals(from));
    }

    public List<String> findShortestPath(String start, String end, int maxCost, boolean prioritizeDistance) {
        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(p -> prioritizeDistance ? p.distance : p.cost));
        pq.add(new Path(start, 0, 0, new ArrayList<>()));
        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Path currentPath = pq.poll();
            String currentCity = currentPath.city;

            if (visited.contains(currentCity)) continue;
            visited.add(currentCity);

            if (currentCity.equals(end)) {
                if (currentPath.cost <= maxCost || maxCost == Integer.MAX_VALUE) {
                    currentPath.route.add(currentCity);
                    return currentPath.route;
                }
            }

            for (Edge edge : adjacencyList.getOrDefault(currentCity, new ArrayList<>())) {
                if (!visited.contains(edge.city)) {
                    List<String> newRoute = new ArrayList<>(currentPath.route);
                    newRoute.add(currentCity);
                    pq.add(new Path(edge.city, currentPath.distance + edge.distance, currentPath.cost + edge.cost, newRoute));
                }
            }
        }

        return null;
    }
}

