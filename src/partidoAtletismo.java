
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class partidoAtletismo extends eventoDeportivo {
    ArrayList<String> nombresCompetidores;
    Double longitudPista;

    public partidoAtletismo(String nombre, LocalDate fecha, String ubicación, ArrayList<String> nombresCompetidores, Double longitudPista){
        super(nombre, fecha, ubicación);
        this.nombresCompetidores = nombresCompetidores;
        this.longitudPista = longitudPista;
    }

    @Override
    public void calcularResultado(){
        //resultado en base a la elecicion aleatoria de un competir, a menos de que uno se llame Usain Bolt
        boolean BoltPresente = nombresCompetidores.contains("Usain Bolt");

        if (BoltPresente){
            System.out.println("El ganador de esta carrera es Usain Bolt");
        } else{
            Random random = new Random();
            int indexGanador = random.nextInt(nombresCompetidores.size()); 

            System.out.println("El ganador es "+nombresCompetidores.get(indexGanador));
        }
        
    }

    @Override
    public void calcularDuracion(){
        //calculando duracion en base a la longitud de la pista 
        //usando un for nada mas para "practicar" el concetp

        Double tiempo = 0.0;

        for(int i = 0; i<=longitudPista; i++){
        tiempo += 10.43;
        }

        System.out.println("El tiempo estimado que tomara la carrera es " +tiempo+ " segundos.");
        
    }

    //setters y fgetters

    public ArrayList<String> getNombresCompetidores() {
        return nombresCompetidores;
    }

    public void setNombresCompetidores(ArrayList<String> nombresCompetidores) {
        this.nombresCompetidores = nombresCompetidores;
    }

    public Double getLongitudPista() {
        return longitudPista;
    }

    public void setLongitudPista(Double longitudPista) {
        this.longitudPista = longitudPista;
    }

}
