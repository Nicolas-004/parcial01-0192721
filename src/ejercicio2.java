
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in);
       final int MAQUINAS = 4;
        final int DIAS = 5;

        int[][] produccion = new int[MAQUINAS][DIAS];
        int[] totalPorMaquina = new int[MAQUINAS];
        int[] totalPorDia = new int[DIAS];
        int registrosMenores20 = 0;

    
        System.out.println("=== REGISTRO DE PRODUCCIÓN (4 MÁQUINAS x 5 DÍAS) ===");
        for (int i = 0; i < MAQUINAS; i++) {
            System.out.println("\n--- Máquina " + (i + 1) + " ---");
            for (int j = 0; j < DIAS; j++) {
                int piezas;
                do {
                    System.out.print("Piezas producidas el Día " + (j + 1) + ": ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Entrada inválida. Ingrese un entero no negativo: ");
                        scanner.next();
                    }
                    piezas = scanner.nextInt();
                    if (piezas < 0) {
                        System.out.println("La producción no puede ser negativa. Intente de nuevo.");
                    }
                } while (piezas < 0);

                produccion[i][j] = piezas;

            
                if (piezas < 20) {
                    registrosMenores20++;
                }

        
                totalPorMaquina[i] += piezas;
                totalPorDia[j] += piezas;
            }
        }

        
        int maquinaMayor = 0;
        for (int i = 1; i < MAQUINAS; i++) {
            if (totalPorMaquina[i] > totalPorMaquina[maquinaMayor]) {
                maquinaMayor = i;
            }
        }

    
        int diaMenor = 0;
        for (int j = 1; j < DIAS; j++) {
            if (totalPorDia[j] < totalPorDia[diaMenor]) {
                diaMenor = j;
            }
        }

    
        System.out.println("===========================================================");
        System.out.println("                     MATRIZ DE PRODUCCIÓN                  ");
        System.out.println("===========================================================");
        System.out.printf("%-12s", "Máquina/Día ");
        for (int j = 0; j < DIAS; j++) {
            System.out.printf("%-10s", "Día " + (j + 1));
        }
        System.out.printf("%-10s%n", "Total M.");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < MAQUINAS; i++) {
            System.out.printf("%-13s", "Máquina " + (i + 1));
            for (int j = 0; j < DIAS; j++) {
                System.out.printf("%-10d", produccion[i][j]);
            }
            System.out.printf("%-10d%n", totalPorMaquina[i]);
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-13s", "Total Día");
        for (int j = 0; j < DIAS; j++) {
            System.out.printf("%-10d", totalPorDia[j]);
        }
        System.out.println();

    
        System.out.println("===========================================================");
        System.out.println("                   RESULTADOS DEL ANÁLISIS                 ");
        System.out.println("===========================================================");
        
        System.out.println("Total producido por máquina:");
        for (int i = 0; i < MAQUINAS; i++) {
            System.out.println("  • Máquina " + (i + 1) + ": " + totalPorMaquina[i] + " piezas");
        }

        System.out.println("\nTotal producido por día:");
        for (int j = 0; j < DIAS; j++) {
            System.out.println("  • Día " + (j + 1) + ": " + totalPorDia[j] + " piezas");
        }

        System.out.println("\nMáquina con mayor producción acumulada: Máquina " 
                + (maquinaMayor + 1) + " (" + totalPorMaquina[maquinaMayor] + " piezas)");
        System.out.println("Día con menor producción total: Día " 
                + (diaMenor + 1) + " (" + totalPorDia[diaMenor] + " piezas)");
        System.out.println("Registros con producción inferior a 20 piezas: " + registrosMenores20);

        scanner.close();

    }
}