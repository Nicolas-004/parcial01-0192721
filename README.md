# Primer Parcial Práctico – Programación I

## Versión A

**Lenguaje:** Java  
**Modalidad:** Individual  
**Duración total:** 60 minutos  
**Valor:** 100 puntos  
**Temas:** arreglos unidimensionales, arreglos bidimensionales, ciclos, condicionales, contadores y acumuladores.

---

## Indicaciones generales

- Desarrolle los dos ejercicios en Java y desde consola.
- Cada ejercicio debe resolverse en un archivo independiente.
- Toda la solución debe estar dentro del método `main`.
- Puede utilizar `Scanner`, arreglos, matrices, ciclos y condicionales.
- No se permite utilizar `ArrayList`, colecciones, `Stream`, métodos de ordenamiento automático ni métodos creados por el estudiante.
- Los datos deben ser solicitados al usuario; no deben quedar escritos directamente en el código.
- Los resultados deben mostrarse de forma clara e identificable.
- Si se presenta un empate, debe reportarse la primera posición encontrada.

---

# Ejercicio 1 – Consumo de agua por sectores

**Tiempo sugerido:** 30 minutos  
**Valor:** 50 puntos

Una empresa de servicios públicos registró el consumo diario de agua de **10 sectores** de la ciudad. La información se expresa en metros cúbicos enteros y debe almacenarse en un arreglo unidimensional.

Construya un programa que:

1. Cree un arreglo de 10 posiciones.
2. Solicite el consumo de cada sector y valide que no sea negativo. Si el dato es inválido, debe solicitarlo nuevamente.
3. Calcule y muestre:
   - El consumo total de los 10 sectores.
   - El promedio de consumo.
   - El número del sector con el mayor consumo.
   - Cuántos sectores tuvieron un consumo superior al promedio.
   - La racha más larga de sectores consecutivos cuyo consumo fue superior al promedio.
4. Muestre el listado final con el número de cada sector y su consumo registrado.

## Aclaraciones

- Los sectores se numeran del 1 al 10, aunque las posiciones del arreglo comiencen en 0.
- Una racha es una secuencia de posiciones consecutivas. Por ejemplo, si los sectores 3, 4 y 5 superan el promedio, existe una racha de longitud 3.
- Para determinar cuáles consumos superan el promedio será necesario recorrer nuevamente el arreglo después de calcularlo.

## Criterios de evaluación

| Criterio | Puntaje |
|---|---:|
| Lectura, almacenamiento y validación de los 10 consumos | 10 |
| Cálculo correcto del total y del promedio | 10 |
| Identificación del sector con mayor consumo | 10 |
| Conteo de sectores por encima del promedio | 8 |
| Cálculo correcto de la racha más larga | 8 |
| Claridad de la salida y organización del código | 4 |

---

# Ejercicio 2 – Control de producción semanal

**Tiempo sugerido:** 30 minutos  
**Valor:** 50 puntos

Una pequeña fábrica cuenta con **4 máquinas** y registra durante **5 días** la cantidad de piezas producidas por cada una. La información debe almacenarse en una matriz de 4 filas por 5 columnas:

- Cada fila representa una máquina.
- Cada columna representa un día de trabajo.

Construya un programa que:

1. Cree una matriz de `4 x 5`.
2. Solicite la producción de cada máquina durante cada día y valide que ningún valor sea negativo.
3. Calcule y muestre:
   - El total producido por cada máquina.
   - El total producido en cada día, sumando las cuatro máquinas.
   - La máquina con la mayor producción acumulada.
   - El día con la menor producción total.
   - Cuántos registros de la matriz fueron inferiores a 20 piezas.
4. Muestre la matriz completa, organizada por máquinas y días.

## Aclaraciones

- Las máquinas se numeran del 1 al 4 y los días del 1 al 5.
- Si dos máquinas tienen el mismo total máximo, se reporta la primera.
- Si dos días tienen el mismo total mínimo, se reporta el primero.
- No es necesario crear arreglos adicionales para resolver el ejercicio, aunque puede utilizarlos si lo considera conveniente.

## Criterios de evaluación

| Criterio | Puntaje |
|---|---:|
| Lectura, almacenamiento y validación de la matriz | 10 |
| Cálculo del total de cada máquina | 10 |
| Cálculo del total de cada día | 10 |
| Identificación de la máquina mayor y el día menor | 10 |
| Conteo de registros inferiores a 20 | 6 |
| Presentación de la matriz y organización del código | 4 |

---

## Entrega

Entregue los dos archivos `.java`, debidamente nombrados y capaces de compilar y ejecutarse sin errores.

**Antes de escribir código, identifique las entradas, el proceso y las salidas. El compilador detecta errores de sintaxis; la lógica todavía corre por cuenta del programador.**
Ejercicio 1:

[ Lectura del consumo ] ───► [ Suma, Promedio, Racha, Máximo ] ───► [ Tabla y Resultados ]
     (ENTRADAS)                     (PROCESO)                         (SALIDAS)

// ENTRADAS: Captura de consumos con validación do-while
for (int i = 0; i < consumos.length; i++) {
    int consumo;
    do {
        System.out.print("Ingrese el consumo del Sector " + (i + 1) + " (m³): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un entero no negativo: ");
            scanner.next();
        }
        consumo = scanner.nextInt();
    } while (consumo < 0); // Validación estricta contra negativos

    consumos[i] = consumo; // Guardado en el arreglo unidimensional
}
// PROCESO 1: Consumo total y Promedio
int consumoTotal = 0;
for (int c : consumos) {
    consumoTotal += c;
}
double promedio = (double) consumoTotal / consumos.length;

// PROCESO 2: Máximo sector, conteo > promedio y Racha más larga
int sectorMayorConsumo = 1;
int maxConsumo = consumos[0];
int sectoresSobrePromedio = 0;
int rachaActual = 0;
int rachaMax = 0;

for (int i = 0; i < consumos.length; i++) {
    // Mayor consumo
    if (consumos[i] > maxConsumo) {
        maxConsumo = consumos[i];
        sectorMayorConsumo = i + 1;
    }

    // Evaluación de racha y superiores al promedio
    if (consumos[i] > promedio) {
        sectoresSobrePromedio++;
        rachaActual++;
        if (rachaActual > rachaMax) {
            rachaMax = rachaActual;
        }
    } else {
        rachaActual = 0; // Reinicia la racha si se interrumpe
    }
}
// SALIDA 1: Listado formateado sector por sector
for (int i = 0; i < consumos.length; i++) {
    System.out.printf("Sector %-8d %-15d%n", (i + 1), consumos[i]);
}

// SALIDA 2: Reporte consolidado
System.out.println("Consumo total: " + consumoTotal + " m³");
System.out.printf("Promedio de consumo: %.2f m³%n", promedio);
System.out.println("Sector con mayor consumo: Sector " + sectorMayorConsumo);
System.out.println("Sectores sobre el promedio: " + sectoresSobrePromedio);
System.out.println("Racha más larga sobre el promedio: " + rachaMax);


ejercicio 2:

[ Piezas x Máquina/Día ] ───► [ Sumas filas/col, Mín/Máx, Filtro < 20 ] ───► [ Matriz y Reporte ]
       (ENTRADAS)                           (PROCESO)                           (SALIDAS)

// ENTRADAS2: Carga de la matriz bidimensional
for (int i = 0; i < MAQUINAS; i++) {
    for (int j = 0; j < DIAS; j++) {
        int piezas;
        do {
            System.out.print("Piezas de Máquina " + (i + 1) + " el Día " + (j + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Ingrese un entero: ");
                scanner.next();
            }
            piezas = scanner.nextInt();
        } while (piezas < 0); // Validación

        produccion[i][j] = piezas; // Guardado en la matriz
    }
}
// PROCESO 2.1: Sumatorias simultáneas por Fila/Columna y conteo < 20
for (int i = 0; i < MAQUINAS; i++) {
    for (int j = 0; j < DIAS; j++) {
        totalPorMaquina[i] += produccion[i][j]; // Suma horizontal (Fila)
        totalPorDia[j] += produccion[i][j];     // Suma vertical (Columna)

        if (produccion[i][j] < 20) {
            registrosMenores20++;
        }
    }
}

// PROCESO 2.2: Máquina con mayor producción acumulada (comparación estricta >)
int maquinaMayor = 0;
for (int i = 1; i < MAQUINAS; i++) {
    if (totalPorMaquina[i] > totalPorMaquina[maquinaMayor]) {
        maquinaMayor = i;
    }
}

// PROCESO 2.3: Día con menor producción total (comparación estricta <)
int diaMenor = 0;
for (int j = 1; j < DIAS; j++) {
    if (totalPorDia[j] < totalPorDia[diaMenor]) {
        diaMenor = j;
    }
}

// SALIDA 2.1: Visualización en tabla/matriz
for (int i = 0; i < MAQUINAS; i++) {
    System.out.printf("%-13s", "Máquina " + (i + 1));
    for (int j = 0; j < DIAS; j++) {
        System.out.printf("%-10d", produccion[i][j]);
    }
    System.out.printf("%-10d%n", totalPorMaquina[i]);
}

// SALIDA 2.2: Muestreo de totales e indicadores finales
System.out.println("Máquina con mayor producción: Máquina " + (maquinaMayor + 1));
System.out.println("Día con menor producción: Día " + (diaMenor + 1));
System.out.println("Registros con producción inferior a 20 piezas: " + registrosMenores20);

