import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      Scanner leer = new Scanner (System.in);


      double[] consumoTotal = new double[10]; 

      int longitud = consumoTotal.length;
      

      for (int i = 0; i < longitud; i++) {
        System.out.println("Ingrese el consumo del sector " + longitud);
        consumoTotal[i] = leer.nextDouble();

      
      }



    }
}
