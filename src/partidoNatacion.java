
import java.time.LocalDate;
import java.util.ArrayList;

public class partidoNatacion extends eventoDeportivo {

    private Double longitudPiscina;
    private int cantidadParticipantes;
    private ArrayList<String> nombresParticipantes;
    private ArrayList<Double> velocidadParticipantes; // metros por segundo

    public partidoNatacion(String nombre, LocalDate fecha, String ubicación, Double longitudPiscina,
            int cantidadParticipantes, ArrayList<String> nombresParticipantes,
            ArrayList<Double> velocidadParticipantes) {
                
        super(nombre, fecha, ubicación); // Llamada al constructor de la clase padre
        this.longitudPiscina = longitudPiscina;
        this.cantidadParticipantes = cantidadParticipantes;
        this.nombresParticipantes = nombresParticipantes;
        this.velocidadParticipantes = velocidadParticipantes;
    }

    @Override
    public void calcularResultado() {
        Double wordRecord = 2.136;
        boolean nuevoRecord = false; // Inicializamos a false
        Double masrapido = 0.0;
        int index = -1; // Se inicia en -1 porque las listas empiezan en 0
        Double velocidadNuevoRecord = 0.0;

        for (int i = 0; i < velocidadParticipantes.size(); i++) {
            Double velocidad = velocidadParticipantes.get(i);
            index++;

            if (velocidad > wordRecord) {
                nuevoRecord = true;
                wordRecord = velocidadNuevoRecord;
                break;
            } else {
                if (velocidad > masrapido) {
                    masrapido = velocidad;
                    wordRecord = velocidad;
                }
            }
        }

        if (nuevoRecord) {
            System.out.println("Nuevo récord MUNDIAL, logrado por " + nombresParticipantes.get(index)+" en un tiempo de " +wordRecord);
        } else {
            System.out.println(
                    "La velocidad más rápida es " + masrapido + " alcanzada por " + nombresParticipantes.get(index));
        }
    }

    @Override
    public void calcularDuracion() {
        double sumavelocidades = 0.0;

        for (double velocidad : velocidadParticipantes){
            sumavelocidades += velocidad;
        }

        Double promedio = sumavelocidades / cantidadParticipantes;
        double tiempoEstimado = longitudPiscina/promedio;

        System.out.println("La duración estimada de la carrera de Natación es de "+tiempoEstimado+" segundos.");


    }

    public Double getLongitudPiscina() {
        return longitudPiscina;
    }

    public void setLongitudPiscina(Double longitudPiscina) {
        this.longitudPiscina = longitudPiscina;
    }

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public ArrayList<String> getNombresParticipantes() {
        return nombresParticipantes;
    }

    public void setNombresParticipantes(ArrayList<String> nombresParticipantes) {
        this.nombresParticipantes = nombresParticipantes;
    }

    public ArrayList<Double> getVelocidadParticipantes() {
        return velocidadParticipantes;
    }

    public void setVelocidadParticipantes(ArrayList<Double> velocidadParticipantes) {
        this.velocidadParticipantes = velocidadParticipantes;
    }
}
