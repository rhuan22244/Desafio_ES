import cargoFast.Graph;

import java.util.List;
import java.util.Scanner;

public class CargoFast {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu CargoFast ===");
            System.out.println("1. Adicionar Cidade");
            System.out.println("2. Adicionar Estrada");
            System.out.println("3. Bloquear Estrada");
            System.out.println("4. Encontrar Rota");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Digite o nome da cidade: ");
                    String city = scanner.nextLine();
                    graph.addCity(city);
                    System.out.println("Cidade adicionada!");
                }
                case 2 -> {
                    System.out.print("Cidade de origem: ");
                    String from = scanner.nextLine();
                    System.out.print("Cidade de destino: ");
                    String to = scanner.nextLine();
                    System.out.print("Distância (km): ");
                    int distance = scanner.nextInt();
                    System.out.print("Custo: ");
                    int cost = scanner.nextInt();
                    graph.addEdge(from, to, distance, cost);
                    System.out.println("Estrada adicionada!");
                }
                case 3 -> {
                    System.out.print("Cidade de origem: ");
                    String from = scanner.nextLine();
                    System.out.print("Cidade de destino: ");
                    String to = scanner.nextLine();
                    graph.removeEdge(from, to);
                    System.out.println("Estrada bloqueada!");
                }
                case 4 -> {
                    System.out.print("Cidade de partida: ");
                    String start = scanner.nextLine();
                    System.out.print("Cidade de destino: ");
                    String end = scanner.nextLine();
                    System.out.print("Custo máximo (ou -1 para ignorar): ");
                    int maxCost = scanner.nextInt();
                    maxCost = (maxCost == -1) ? Integer.MAX_VALUE : maxCost;

                    System.out.print("Priorizar distância? (true/false): ");
                    boolean prioritizeDistance = scanner.nextBoolean();

                    List<String> route = graph.findShortestPath(start, end, maxCost, prioritizeDistance);
                    if (route == null) {
                        System.out.println("Nenhuma rota viável encontrada.");
                    } else {
                        System.out.println("Rota encontrada: " + String.join(" -> ", route));
                    }
                }
                case 5 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
