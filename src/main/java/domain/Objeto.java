package domain;

public class Objeto {
    private PlantillaObjeto objeto;
    private CalidadObjeto calidad;
    private Jugador propietario;
    private int ataque, salud, precision, evasion;
    private String nombre;

    public Objeto(PlantillaObjeto objeto, CalidadObjeto calidad, Jugador propietario){
        this.objeto = objeto;
        this.calidad = calidad;
        this.propietario = propietario;
        this.nombre = objeto.getNombre() + " " + calidad.getNivel();
        this.ataque = (int)(objeto.getAtaque() * calidad.getAtaque());
        this.salud = (int)(objeto.getSalud() * calidad.getSalud());
        this.precision = (int)(objeto.getPrecision() * calidad.getPrecision());
        this.evasion = (int)(objeto.getEvasion() * calidad.getEvasion());
    }
}
