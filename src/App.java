import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner (System.in);


      int[] consumos = new int[10]; 
      int consumoTotal = 0 ;
      
        System.out.println("=== REGISTRO DE CONSUMO DIARIO DE AGUA ===");
        for (int i = 0; i < consumos.length; i++) {
            int consumo;
            do {
                System.out.print("Ingrese el consumo del Sector " + (i + 1) + " (m³): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Entrada inválida. Ingrese un número entero no negativo: ");
                    scanner.next();
                }
                consumo = scanner.nextInt();
                if (consumo < 0) {
                    System.out.println("El consumo no puede ser negativo. Intente de nuevo.");
                }
            } while (consumo < 0);

            consumos[i] = consumo;
            consumoTotal += consumo;
        }

        double promedio = (double) consumoTotal / consumos.length;

        int sectorMayorConsumo = 1;
        int maxConsumo = consumos[0];
        int sectoresSobrePromedio = 0;

        int rachaActual = 0;
        int rachaMax = 0;

        for (int i = 0; i < consumos.length; i++) {
            if (consumos[i] > maxConsumo) {
                maxConsumo = consumos[i];
                sectorMayorConsumo = i + 1; 
            }

            if (consumos[i] > promedio) {
                sectoresSobrePromedio++;
                rachaActual++;
                if (rachaActual > rachaMax) {
                    rachaMax = rachaActual;
                }
            } else {
                rachaActual = 0; 
            }
        }

        System.out.println("\n==========================================");
        System.out.println("            LISTADO DE CONSUMOS           ");
        System.out.println("==========================================");
        System.out.printf("%-15s %-15s%n", "Sector", "Consumo (m³)");
        System.out.println("------------------------------------------");
        for (int i = 0; i < consumos.length; i++) {
            System.out.printf("Sector %-8d %-15d%n", (i + 1), consumos[i]);
        }

        System.out.println("\n==========================================");
        System.out.println("            RESULTADOS Y ANÁLISIS         ");
        System.out.println("==========================================");
        System.out.println("Consumo total: " + consumoTotal + " m³");
        System.out.printf("Promedio de consumo: %.2f m³%n", promedio);
        System.out.println("Sector con mayor consumo: Sector " + sectorMayorConsumo + " (" + maxConsumo + " m³)");
        System.out.println("Sectores con consumo superior al promedio: " + sectoresSobrePromedio);
        System.out.println("Racha más larga superior al promedio: " + rachaMax + " sector(es) consecutivo(s)");

        scanner.close();
    }
}
