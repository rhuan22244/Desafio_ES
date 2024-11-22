package models;

public class Edge {
        public String city;
        public int distance;
        public int cost;

        public Edge(String city, int distance, int cost) {
            this.city = city;
            this.distance = distance;
            this.cost = cost;
        }
}
