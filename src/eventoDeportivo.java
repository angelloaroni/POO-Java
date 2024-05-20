
import java.time.LocalDate;

public abstract  class eventoDeportivo {
    String nombre;
    LocalDate fecha;
    String ubicación;

    public eventoDeportivo(String nombre, LocalDate fecha, String ubicación){
        
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicación = ubicación;

    }
    
    public abstract void calcularResultado();
    public abstract void calcularDuracion();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicación() {
        return ubicación;
    }

    public void setUbicación(String ubicación) {
        this.ubicación = ubicación;
    }
}
