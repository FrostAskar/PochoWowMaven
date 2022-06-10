package Utils;

import dao.JugadorDao;
import dao.Mysql.JugadorDaoMysql;
import dao.Mysql.PersonajeDaoMysql;
import dao.PersonajeDao;
import domain.Jugador;
import domain.Personaje;

import java.sql.Connection;

public class Sesion {


    private Connection con;
    JugadorDao jugador;
    Jugador jugadorActivo;
    PersonajeDao personaje;
    Personaje personajeActivo;

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

    public void setPersonajeActivo(Personaje personaje) {
        this.personajeActivo = personaje;
    }

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }

    private Sesion(){
        con = DBUtil.createConnectionFromProperties("res/db.properties");
        jugador = new JugadorDaoMysql(this.con);
        personaje = new PersonajeDaoMysql(this.con);
    }

    private static Sesion instance = null;

    public static Sesion getInstance(){
        if (instance == null) {
            instance = new Sesion();
        }
        return instance;
    }
}
