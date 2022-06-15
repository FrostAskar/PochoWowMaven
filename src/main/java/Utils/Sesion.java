package Utils;

import dao.JugadorDao;
import dao.Mysql.JugadorDaoMysql;
import dao.Mysql.PersonajeDaoMysql;
import dao.Mysql.MercadoDaoMysql;
import dao.PersonajeDao;
import dao.MercadoDao;
import domain.Jugador;
import domain.Personaje;

import java.sql.Connection;

public class Sesion {


    private Connection con;
    JugadorDao jugador;
    Jugador jugadorActivo;
    PersonajeDao personaje;
    Personaje personajeActivo;
    String maz;
    String mazmorraActiva;

    MercadoDao mercado;

    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }

    public void setJugadorActivo(Jugador jugadorActivo) {
        this.jugadorActivo = jugadorActivo;
    }

    public void setJugador(JugadorDao jugador) {
        this.jugador = jugador;
    }
    public JugadorDao getJugador() {
        return jugador;
    }

    public PersonajeDao getPersonaje() {
        return personaje;
    }
    public MercadoDao getMercado() {return mercado;};
    public void setPersonajeActivo(Personaje personaje) {
        this.personajeActivo = personaje;
    }

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }
    public void setMazmorra (String mazmorra){
        this.maz=mazmorra;
    }
    public String getMazmorra(){
        return this.maz;
    }

    public void setMazmorraActiva(String mazActiva){
        this.mazmorraActiva=mazActiva;
    }
    public String getMazmorraActiva(){
        return this.mazmorraActiva;
    }

    private Sesion(){
        con = DBUtil.createConnectionFromProperties("res/db.properties");
        jugador = new JugadorDaoMysql(this.con);
        personaje = new PersonajeDaoMysql(this.con);
        mercado = new MercadoDaoMysql (this.con);
    }

    private static Sesion instance = null;

    public static Sesion getInstance(){
        if (instance == null) {
            instance = new Sesion();
        }
        return instance;
    }
}
