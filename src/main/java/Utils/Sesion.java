package Utils;

import dao.EnemigoDao;
import dao.JugadorDao;
import dao.Mysql.EnemigoDaoMysql;
import dao.Mysql.JugadorDaoMysql;
import dao.Mysql.PersonajeDaoMysql;
import dao.PersonajeDao;
import domain.Enemigo;
import domain.Jugador;
import domain.Personaje;

import java.sql.Connection;

public class Sesion {


    private Connection con;
    JugadorDao jugador;
    Jugador jugadorActivo;
    PersonajeDao personaje;
    Personaje personajeActivo;
    EnemigoDao enemigo;
    Enemigo enemigoActivo;
    String maz;
    String mazmorraActiva;

    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }

    public void setJugadorActivo(Jugador jugadorActivo) {
        this.jugadorActivo = jugadorActivo;
    }

    public JugadorDao getJugador() {
        return jugador;
    }
    public void setJugador(JugadorDao jugador) {
        this.jugador = jugador;
    }

    public PersonajeDao getPersonaje() {
        return personaje;
    }

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }
    public void setPersonajeActivo(Personaje personaje) {
        this.personajeActivo = personaje;
    }

    public EnemigoDao getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(EnemigoDao enemigo) {
        this.enemigo = enemigo;
    }

    public Enemigo getEnemigoActivo() {
        return enemigoActivo;
    }

    public void setEnemigoActivo(Enemigo enemigoActivo) {
        this.enemigoActivo = enemigoActivo;
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
        enemigo = new EnemigoDaoMysql(this.con);
    }

    private static Sesion instance = null;

    public static Sesion getInstance(){
        if (instance == null) {
            instance = new Sesion();
        }
        return instance;
    }
}
