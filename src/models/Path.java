package models;

import java.util.List;

public class Path {
    public String city;
    public int distance;
    public int cost;
    public List<String> route;

    public Path(String city, int distance, int cost, List<String> route) {
        this.city = city;
        this.distance = distance;
        this.cost = cost;
        this.route = route;
    }
}
