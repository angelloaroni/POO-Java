import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArrayList<String> eventos = new ArrayList<>();
        ArrayList<String> participantesAtletismo = new ArrayList<>();
        ArrayList<String> participantesNatacion = new ArrayList<>();
        ArrayList<Double> velocidadParticipantes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int cantidadmax = 3; // Inicialmente se pueden ingresar hasta 3 eventos

        partidoFutbol partido = null;
        partidoAtletismo carrera = null;
        partidoNatacion natacion = null;


        int cantidad;
        // Uso de un do-while para verificar la cantidad de eventos que se pueden ingresar
        do {
            System.out.print("Introduce la cantidad de eventos que planeas registrar en el sistema: ");
            cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el carácter de nueva línea
            if (cantidad > cantidadmax) {
                System.out.println("No se pueden ingresar más de 3 eventos como máximo.");
            } else if (cantidad <= 0) {
                System.out.println("No se pueden ingresar valores menores o iguales a 0.");
            }
        } while (cantidad > cantidadmax || cantidad <= 0);

        // Actualizar cantidadmax después de cada iteración para reflejar la cantidad restante de eventos que se pueden ingresar
        cantidadmax -= cantidad;

        for (int i = 0; i < cantidad; i++) {
            String evento;
            do {
                System.out.print("Ingrese el evento a registrar ('Futbol', 'Atletismo', 'Natacion'), asegúrese de escribirlo correctamente: ");
                evento = scanner.nextLine();
                if (!evento.equals("Futbol") && !evento.equals("Atletismo") && !evento.equals("Natacion")) {
                    System.out.println("Evento inválido. Inténtelo de nuevo.");
                } else {
                    eventos.add(evento);
                }
            } while (!evento.equals("Futbol") && !evento.equals("Atletismo") && !evento.equals("Natacion"));
        }

        for (String deporte : eventos) {
            if (deporte.equals("Futbol")) {
                System.out.println("COMENZANDO CON LA RECOPILACIÓN DE DATOS DEL PARTIDO DE FUTBOL");

                String tipoEvento = "Partido de futbol";

                System.out.println("Ingrese la fecha del encuentro, por favor, use esta estructura (YYYY-MM-DD): ");
                String inputFutbol = scanner.nextLine();
                LocalDate fechaFutbol = LocalDate.parse(inputFutbol);

                System.out.println("Ingrese la ubicación del encuentro: ");
                String ubicación = scanner.nextLine();

                System.out.println("Ingrese el nombre del equipo local");
                String equipoLocal = scanner.nextLine();
                Double posibilidadEquipoLocal;

                // bucle dowhile para asegurar valores validos en las posibilidades
                do {
                    System.out.println("Ingrese las posibilidades que tiene de ganar el equipo local (entre 0 y 1): ");
                    posibilidadEquipoLocal = scanner.nextDouble();

                    if (posibilidadEquipoLocal < 0 || posibilidadEquipoLocal > 1) {
                        System.out.println("Error: Las posibilidades deben estar entre 0 y 1. Por favor, inténtelo de nuevo.");
                    }
                } while (posibilidadEquipoLocal > 1 || posibilidadEquipoLocal < 0);

                System.out.println("Ingrese quien sera el equipo visitante: ");
                scanner.nextLine(); // Consumir el carácter de nueva línea antes de leer el nombre del equipo visitante
                String equipoVisitante = scanner.nextLine();
                Double posibilidadEquipoVisitante = 1 - posibilidadEquipoLocal;

                System.out.println("Ingrese la cantidad de jugadores que habrá por cada equipo: ");
                int jugadoresPorEquipo = scanner.nextInt();
                scanner.nextLine();

                // Crear instancia de partidoFutbol
                partido = new partidoFutbol(tipoEvento, fechaFutbol, ubicación, equipoLocal, equipoVisitante, posibilidadEquipoLocal, posibilidadEquipoVisitante, jugadoresPorEquipo);
                
                partido.calcularDuracion();
                partido.calcularResultado();

            } else if (deporte.equals("Atletismo")) {
                System.out.println("COMENZANDO CON LA RECOPILACIÓN DE DATOS DE LA CARRERA DE ATLETISMO");

                String nombre = "Carrera de Atletismo";

                System.out.println("Ingrese la fecha del encuentro, por favor, use esta estructura (YYYY-MM-DD): ");
                String inputAtletismo = scanner.nextLine();
                LocalDate fechaAtletismo = LocalDate.parse(inputAtletismo);

                System.out.println("Ingrese la ubicacion de la carrera de Atletismo: ");
                String ubicación = scanner.nextLine();

                int cantidadParticipantes;
                do {
                    System.out.println("Ingrese la cantidad de participantes que tendrá la carrera");
                    cantidadParticipantes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el carácter de nueva línea pendiente

                    if (cantidadParticipantes > 20 || cantidadParticipantes < 2) {
                        System.out.println("ERROR: La cantidad de participantes debe estar entre 2 y 20.");
                    }
                } while (cantidadParticipantes > 20 || cantidadParticipantes < 2);

                for (int j = 0; j < cantidadParticipantes; j++) {
                    System.out.println("Ingrese y apellido del participante " + j + ".");
                    String participante = scanner.nextLine();

                    System.out.println("");
                    participantesAtletismo.add(participante);
                }

                System.out.println("Ingrese (en metros) la longitud que tendrá la pista de carreras");
                Double longitudPista = scanner.nextDouble();

                // Crear instancia de partidoAtletismo
                carrera = new partidoAtletismo(nombre, fechaAtletismo, ubicación, participantesAtletismo, longitudPista);

            } else {
                System.out.println("COMENZANDO CON LA RECOPILACIÓN DE DATOS DEL PARTIDO DE NATACIÓN");

                String nombre = "Carrera en una piscina olímpica";

                System.out.println("Ingrese la fecha del encuentro, por favor, use esta estructura (YYYY-MM-DD): ");
                String inputNatacion = scanner.nextLine();
                LocalDate fechaNatacion = LocalDate.parse(inputNatacion);

                System.out.println("Ingrese la ubicación en la que se realizará el encuentro");
                String ubicacion = scanner.nextLine();

                System.out.println("Ingrese la longitud de la piscina olímpica (en metros): ");
                Double longitud = scanner.nextDouble();

                int cantidadParticipantes;
                do {
                    System.out.println("Ingrese la cantidad de participantes que tendrá la carrera de Natación");
                    cantidadParticipantes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el carácter de nueva línea pendiente

                    if (cantidadParticipantes > 10 || cantidadParticipantes < 2) {
                        System.out.println("ERROR: La cantidad de participantes debe estar entre 2 y 10.");
                    }
                } while (cantidadParticipantes > 10 || cantidadParticipantes < 2);

                for (int j = 0; j < cantidadParticipantes; j++) {
                    System.out.println("Ingrese y apellido del participante " + j + ".");
                    String participante = scanner.nextLine();

                    System.out.println("");
                    participantesNatacion.add(participante);
                }

                for (int c = 0; c < participantesAtletismo.size(); c++) {
                    System.out.println("Ingrese la velocidad promedio de " + participantesAtletismo.get(c) + " en m/s.");
                    Double velocidad = scanner.nextDouble();

                    velocidadParticipantes.add(velocidad);
                }

                natacion = new partidoNatacion(nombre, fechaNatacion, ubicacion, longitud, cantidadParticipantes, participantesNatacion, velocidadParticipantes);
            }
        }
        int accion;

        do {
            System.out.println("Ingrese el nombre del deporte del cual desea revisar los datos registrados: ");
            String eventoParaRevisar = scanner.nextLine();

            boolean encontrado = false;
            for (String deporte : eventos) {
                if (eventoParaRevisar.toUpperCase().equals("FUTBOL")) {
                    encontrado = true;

                    System.out.println("-Posibles Acciones a tomar:\n");
                    System.out.println("1.- Obtener una descripción general del encuentro");
                    System.out.println("2.- Calcular el resultado del partido");
                    System.out.println("3.-btener una estimación de lo largo que será el partido");
                    System.out.println("DIGITE 0 SI DESEA SALIR");
                    
                    accion = scanner.nextInt();

                    switch (accion) {
                        case 1:          
                            break;
                        
                        case 2:
                            partido.calcularResultado();
                            break;

                        case 3:
                            partido.calcularDuracion();
                            break;
                        case 0:
                            break;

                        default :
                            break;
                    }

                } else if (eventoParaRevisar.equals("ATLETISMO")){
                    encontrado = true;

                    System.out.println("-Posibles Acciones a tomar:\n");
                    System.out.println("1.- Obtener una descripción general de la carrera");
                    System.out.println("2.- Calcular el resultado de la carrera");
                    System.out.println("3.-btener una estimación de la duración que tendrá la carrera");
                    System.out.println("DIGITE 0 SI DESEA SALIR");

                    accion = scanner.nextInt();

                    switch (accion) {
                        case 1:
                            break;
                        
                        case 2:
                            carrera.calcularResultado();
                            break;

                        case 3:
                            carrera.calcularDuracion();
                            break;
                        case 0:
                            break;

                        default:
                            break;
                    }
                } else{

                    encontrado = true;

                    System.out.println("-Posibles Acciones a tomar:\n");
                    System.out.println("1.- Obtener una descripción general de la carrera de natación");
                    System.out.println("2.- Calcular el resultado de la carrera de natación");
                    System.out.println("3.-btener una estimación de la duración que tendrá la carrera de natación");
                    System.out.println("DIGITE 0 SI DESEA SALIR");

                    accion = scanner.nextInt();

                    switch (accion) {
                        case 1:   
                            break;
                        
                        case 2:
                            natacion.calcularResultado();
                            break;

                        case 3:
                            natacion.calcularDuracion();
                            break;

                        case 0:
                            break; 

                        default:
                            break;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("Deporte no encontrado. Inténtelo de nuevo.");
            }

        } while (1 != 0);

        //scanner.close();
    }
}
