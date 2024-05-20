import java.time.LocalDate;
import java.util.Random;



public class partidoFutbol extends eventoDeportivo{

    //definicion de atributos
    private String equipoLocal;
    private String equipoVisitante;
    private Double posibilidadequipoLocal;
    private Double posibilidadequipoVisitante;
    private int jugadoresPorEquipo;


    public partidoFutbol(String nombre, LocalDate fecha, String ubicación, String equipoLocal, String equipoVisitante, Double posibilidadequipoLocal, Double posibilidadequipoVisitante, int jugadoresPorEquipo ){
       
        //herencia mediante super de la clase eventoDeportivo
        super(nombre, fecha, ubicación);
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.posibilidadequipoLocal = posibilidadequipoLocal;
        this.posibilidadequipoVisitante = posibilidadequipoVisitante;
        this.jugadoresPorEquipo = jugadoresPorEquipo;

    }
    //metodos@Override para sobreescribir el de la clase madre

    @Override
    public void calcularResultado(){
        //posiblidad en base a probabilidades
        Random random = new Random();
        double numRandom = random.nextDouble(); //numero entre 0 y 1

        if (posibilidadequipoLocal > numRandom){
            System.out.println("El ganador del encuentro es el " +equipoLocal);
        } else {
            System.out.println("El ganador del encuentro es el " +equipoVisitante);
        }
    }

    @Override
    public void calcularDuracion(){
        //calculadno la duracion en base al numero de jugares
        double tiempoPorJugador = 90/22;
        double tiempodelPartido = (jugadoresPorEquipo*2) * tiempoPorJugador;

        System.out.println("La duración del partido es de " +tiempodelPartido+" minutos.");
    }

    //Seccion dedicada a setters y getters

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Double getPosibilidadequipoLocal() {
        return posibilidadequipoLocal;
    }

    public void setPosibilidadequipoLocal(Double posibilidadequipoLocal) {
        this.posibilidadequipoLocal = posibilidadequipoLocal;
    }

    public Double getPosibilidadequipoVisitante() {
        return posibilidadequipoVisitante;
    }

    public void setPosibilidadequipoVisitante(Double posibilidadequipoVisitante) {
        this.posibilidadequipoVisitante = posibilidadequipoVisitante;
    }

    public int getJugadoresPorEquipo() {
        return jugadoresPorEquipo;
    }

    public void setJugadoresPorEquipo(int jugadoresPorEquipo) {
        this.jugadoresPorEquipo = jugadoresPorEquipo;
    }

}