package Utils;

import domain.Enemigo;
import domain.Personaje;

public class Combate {

    private Personaje personaje;
    private int saludPersonaje = personaje.getPsActual();
    private int ataquePersonaje = personaje.getAtaque();
    private int evasionPesonaje = personaje.getEvasion();
    private int precisionPersonaje = personaje.getPrecision();
    //Si el personaje se ha defendido, se incrementará la evasión, ya que es lo que influye en la reducción de daño.
    //En caso de que se haya defendido, el bufo se cancela al reiniciar la ronda.
    private boolean personajeEstaDefendiendo = false;
    //El personaje es un chamán y ha colocado un tótem
    //El String determina el tipo
    private String tipoTotem = "";
    //Un totem dura 3 turnos o hasta que el rival le ataca, lo cual lo destruye inmediatamente
    private int duracionTotem = 0;
    //El personaje es un guerrero y genera furia con cada ataque que da
    private int furia = 0;
    //El personaje es un guerrero y ha activado su habilidad. Solo dura unos 3 turnos.
    private int furiaUsada = 0;
    private int duracionFuria = 0;
    //El personaje es un mago y ha iniciado una canalización. La canalización tiene una probabilidad de interrumpirse cuando es atacado.
    private boolean canalizando = false;
    //El personaje es un paladín y ha usado su habilidad para protegerse del siguiente ataque.
    private boolean escudoDivino = false;
    //El personaje es un druida y ha asumido la forma bestial. El personaje activo será transformado y los atributos
    //base serán sustituidos.
    private boolean estaTransformado = false;
    //Cada habilidad que se pueda usar más de una vez genera un cooldown hasta que se pueda volver a usar
    private int cooldown = 0;


    private Personaje transformado = null;

    //Entidad pet que genera el personaje cazador
    private Personaje petCazador = null;
    private int saludPet = petCazador.getPsMax();
    private int ataquePet = petCazador.getAtaque();
    private int evasionPet = petCazador.getEvasion();
    private int precisionPet = petCazador.getPrecision();
    //Estado de invocación
    //0 = Aún no invocado/No puede ser invocado.
    //1 = Invocado y vivo.
    //-1 = invocado y derrotado. No se puede volver a invocar.
    private int petEstaActivo = 0;
    //Es el áspid, el cual causa DoT como veneno.
    private boolean venenoso = false;


    private Enemigo enemigo;
    private int saludEnemigo = enemigo.getSalud();
    private int ataqueEnemigo = enemigo.getAtaque();
    private int evasionEnemigo = enemigo.getEvasion();
    private int precisionEnemigo = enemigo.getPrecision();
    private boolean enemigoEstaDefendiendo = false;
    private boolean enemigoEstaAturdido = false;
    private boolean enemigoEstaEnvenenado = false;

    private boolean derrota = false;
    private boolean victoria = true;

    public Combate (Personaje personaje, Enemigo enemigo){
        this.personaje = personaje;
        this.enemigo = enemigo;
    }

    public int getCooldown(){
        return this.cooldown;
    }

    //Maneja los cambios de estado en el Personaje. enemigoIA maneja los cambios del enemigo
    public void nuevaRonda(){
        if (this.cooldown != 0){
            this.cooldown--;
        }
        if (this.personajeEstaDefendiendo){
            this.personajeEstaDefendiendo = false;
            this.evasionPesonaje *= 0.75;
        }
        if (this.duracionFuria != 0){
            if (this.duracionFuria == 1){
                this.ataquePersonaje -= this.furiaUsada/10;
                this.furiaUsada = 0;
            }
            this.duracionFuria--;
        }
        if (this.tipoTotem == "Fuego"){
            System.out.println("El totem de fuego desata su ira");
            System.out.println("El enemigo pierde 10 puntos de vida.");
            this.saludEnemigo -= 10;
        } else if (this.tipoTotem == "Agua"){
            System.out.println("El totem de agua sana tus heridas");
            System.out.println("Recuperas 10 puntos de vida");
            this.saludPersonaje += 10;
            if (this.saludPersonaje > this.personaje.getPsMax()){
                this.saludPersonaje = this.personaje.getPsMax();
            }
        }
        if (this.duracionTotem != 0){
            if (this.duracionTotem == 1){
                this.tipoTotem = "";
            }
            this.duracionTotem--;
        }
        if (this.saludPersonaje <= 0){
            derrota = true;
        }
    }

    public String getTipoTotem(){
        return this.tipoTotem;
    }

    public domain.Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(domain.Personaje personaje) {
        this.personaje = personaje;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public void personajeAtacaEnemigo(){
        int exito = (int)(Math.random() * 100) + personaje.getPrecision() - evasionEnemigo;
        double mod = modificadorGolpe(exito);
        int daño = (int)(ataquePersonaje * mod);
        saludEnemigo -= daño;
        System.out.println("El ataque de " + personaje.getNombre() + " quita " + daño + " puntos de vida.");
        if (saludEnemigo <= 0){
            victoria();
        }
    }

    private void enemigoAtacaPersonaje(){
        int exito = (int)(Math.random() * 100) + precisionEnemigo - evasionPesonaje;
        double mod = modificadorGolpe(exito);
        int daño = (int)(ataqueEnemigo * mod);
        if (this.tipoTotem=="Tierra"){
            System.out.println("El totem de Tierra te inunda con la resistencia de las montañas");
            daño -= 10;
            if (daño < 0){
                daño = 0;
            }
        }
        saludPersonaje -= daño;
        System.out.println(personaje.getNombre() + " pierde " + daño + " puntos de vida.");
        if (saludPersonaje <= 0){
            derrota();
        }
    }

    private void enemigoAtacaPet(){
        int exito = (int)(Math.random() * 100) + precisionEnemigo - evasionPet;
        double mod = modificadorGolpe(exito);
        int daño = (int)(ataqueEnemigo * mod);
        saludPet -= daño;
        if (saludPet <= 0){
            petEstaActivo = -1;
        }
    }

    public void enemigoIA(){
        if (enemigoEstaEnvenenado){
            this.saludEnemigo -= this.saludEnemigo%10;
        }
        if (enemigoEstaDefendiendo){
            this.evasionEnemigo *= 0.75;
            this.enemigoEstaDefendiendo = false;
        }
        if (!enemigoEstaAturdido){
            if(saludEnemigo > 0){
                if (petEstaActivo == 1){
                    double chance = Math.random();
                    if (petCazador.getNombre() == "Ursha" && chance < 0.7){
                        if (saludEnemigo >= enemigo.getSalud() * 0.75){
                            enemigoAtacaPet();
                        } else if (saludEnemigo >= enemigo.getSalud() * 0.4){
                            chance = Math.random();
                            if (chance <= 0.4){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPet();
                            }
                        } else {
                            chance = Math.random();
                            if (chance <= 0.6){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPet();
                            }
                        }
                    } else if (petCazador.getNombre() == "Fang" && chance < 0.5){
                        if (saludEnemigo >= enemigo.getSalud() * 0.75){
                            enemigoAtacaPet();
                        } else if (saludEnemigo >= enemigo.getSalud() * 0.4){
                            chance = Math.random();
                            if (chance <= 0.4){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPet();
                            }
                        } else {
                            chance = Math.random();
                            if (chance <= 0.6){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPet();
                            }
                        }
                    } else if (petCazador.getNombre() == "Rattle" && chance < 0.3){
                        if (saludEnemigo >= enemigo.getSalud() * 0.75){
                            enemigoAtacaPet();
                        } else if (saludEnemigo >= enemigo.getSalud() * 0.4){
                            chance = Math.random();
                            if (chance <= 0.4){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPet();
                            }
                        } else {
                            chance = Math.random();
                            if (chance <= 0.6){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPet();
                            }
                        }
                    } else {
                        if (saludEnemigo >= saludEnemigo * 0.75) {
                            enemigoAtacaPersonaje();
                        } else if (saludEnemigo >= enemigo.getSalud() * 0.4){
                            chance = Math.random();
                            if (chance <= 0.4){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPersonaje();
                            }
                        } else {
                            chance = Math.random();
                            if (chance <= 0.6){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPersonaje();
                            }
                        }
                    }
                } else if (this.duracionTotem != 0){
                    double chance = Math.random();
                    if (chance <= 0.5){
                        this.tipoTotem = "";
                        this.duracionTotem = 0;
                        System.out.println("¡"+ enemigo.getNombre() + " ha aprovechado para destruir el tótem!");
                    } else {
                        if (saludEnemigo >= saludEnemigo * 0.75) {
                            enemigoAtacaPersonaje();
                        } else if (saludEnemigo >= enemigo.getSalud() * 0.4){
                            chance = Math.random();
                            if (chance <= 0.4){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPersonaje();
                            }
                        } else {
                            chance = Math.random();
                            if (chance <= 0.6){
                                enemigoDefiende();
                            } else{
                                enemigoAtacaPersonaje();
                            }
                        }
                    }
                }

        }

        } else {
            System.out.println("¡El enemigo aún se está recuperando!");
        }
    }

    public void personajeDefiende(){
        evasionPesonaje *= 1.25;
        personajeEstaDefendiendo = true;
    }

    private void enemigoDefiende(){
        evasionEnemigo *= 1.25;
        enemigoEstaDefendiendo = true;
    }

    public void personajeUsaHabilidadEspecial(){
        switch (personaje.getClase()){
            case "Brujo":
                drenarEnergia();
                break;
            case "Cazador":
                invocarPet();
                break;
            case "Chaman":
                plantarTotem();
                break;
            case "Druida":
                transformacion();
                break;
            case "Guerrero":
                incrementarDaño();
                break;
            case "Maestro de Juego":
                sacarsela();
                break;
            case "Mago":
                hechizo();
                break;
            case "Paladín":
                escudoDivino();
                break;
            case "Picaro":
                emboscar();
                break;
            case "Sacerdote":
                sanacion();
                break;
        }
    }

    private void sanacion() {
        System.out.println("El poder de la luz sana tus heridas.");
        int ajuste = personaje.getNivel();
        saludPersonaje += 10 + (5 * ajuste);
    }

    private void emboscar() {
        System.out.println("Con un rápido movimiento, atacas el punto débil del enemigo");
        personajeAtacaEnemigo();
        enemigoEstaAturdido = true;
    }

    private void escudoDivino() {
        System.out.println("La luz te rodea y te protege.");
        escudoDivino = true;
    }

    private void hechizo() {
        if (!canalizando){
            System.out.println("¡Empiezas a concentrarte para lanzar un poderoso hechizo!");
            canalizando = true;
        } else {
            System.out.println("¡Liberas tu devastador hechizo!");
            canalizando = false;
            ataquePersonaje *= 3;
            personajeAtacaEnemigo();
            ataquePersonaje /=3;
        }
    }

    //Sonido "YOU HAVE NO POWER HERE"
    private void sacarsela() {
        System.out.println("\"A tu casa\"");
        enemigoEstaAturdido = true;
        victoria = true;
    }

    private void incrementarDaño() {
        System.out.println("Dejas que la furia guíe tus armas.");
        this.ataquePersonaje += furia/10;
        this.furiaUsada = furia;
        this.furia = 0;
        this.duracionFuria = 3;
    }

    private void plantarTotem() {
        System.out.println("Los elementos se manifiestan...");
        double chance = Math.random();
        if (chance <= 0.25){
            System.out.println("Invocas la ayuda de un tótem de viento");
            tipoTotem = "Viento";
            duracionTotem = 2;
        } else if (chance <= 0.5){
            System.out.println("Invocas la ayuda de un tótem de fuego");
            tipoTotem = "Fuego";
            duracionTotem = 3;
        } else if (chance <= 0.75){
            System.out.println("Invocas la ayuda de un tótem de agua");
            tipoTotem = "Agua";
            duracionTotem = 3;
        } else {
            System.out.println("Invocas la ayuda de un tótem de tierra");
            tipoTotem = "Tierra";
            duracionTotem = 3;
        }
    }

    private void transformacion() {
        double chance = Math.random();
        int diferenciaSalud = personaje.getPsMax() - personaje.getPsActual();
        int ajuste = personaje.getNivel() + 1;
        estaTransformado = true;
        if (chance <= 0.25){
            System.out.println("Canalizas la fuerza del oso");
            transformado = new Personaje(
                    personaje.getNombre(),
                    "oso",
                    9 + (2* ajuste),
                    35 + (10*ajuste),
                    10 + (2*ajuste),
                    19 + (2*ajuste),
                    Sesion.getInstance().getJugadorActivo()
            );
        } else if (chance <= 0.5){
            System.out.println("Canalizas la astucia de la pantera");
            transformado = new Personaje(
                    personaje.getNombre(),
                    "gato",
                    11 + (2* ajuste),
                    17 + (10*ajuste),
                    20 + (2*ajuste),
                    25 + (2*ajuste),
                    Sesion.getInstance().getJugadorActivo()
            );
        } else if (chance <= 0.75){
            System.out.println("Canalizas la astucia del búho");
            transformado = new Personaje(
                    personaje.getNombre(),
                    "búho",
                    19 + (2* ajuste),
                    17 + (10*ajuste),
                    17 + (2*ajuste),
                    15 + (2*ajuste),
                    Sesion.getInstance().getJugadorActivo()
            );
        } else {
            System.out.println("Canalizas la durabilidad del bosque");
            transformado = new Personaje(
                    personaje.getNombre(),
                    "trent",
                    7 + (2* ajuste),
                    15 + (10*ajuste),
                    22 + (2*ajuste),
                    18 + (2*ajuste),
                    Sesion.getInstance().getJugadorActivo()
            );
        }
        saludPersonaje = transformado.getPsMax() - diferenciaSalud;
        ataquePersonaje = transformado.getAtaque();
        precisionPersonaje = transformado.getPrecision();
        evasionPesonaje = transformado.getEvasion();
    }

    private void invocarPet() {
        double chance = Math.random();
        int ajuste = personaje.getNivel();
        if (chance <= 0.33){
            System.out.println("Llamas a Ursha, tu fiel Oso.");
            petCazador = new Personaje(
                    "Ursha",
                    "pet",
                    9 + (2* ajuste),
                    35 + (10*ajuste),
                    10 + (2*ajuste),
                    19 + (2*ajuste),
                    Sesion.getInstance().getJugadorActivo()
            );
        } else if (chance <= 0.66){
            System.out.println("Llamas a Fang, tu leal Dientes de sable.");
            petCazador = new Personaje(
                    "Fang",
                    "pet",
                    11 + (2*ajuste),
                    17 + (2*ajuste),
                    20 + (2*ajuste),
                    25 + (2*ajuste),
                    Sesion.getInstance().getJugadorActivo()
            );
        } else {
            System.out.println("Llamas a Rattle, tu confiable aspid.");
            petCazador = new Personaje(
                    "Rattle",
                    "pet",
                    5 + (2*ajuste),
                    12 + (2*ajuste),
                    19 + (2*ajuste),
                    17 + (2*ajuste),
                    Sesion.getInstance().getJugadorActivo()
            );
            venenoso = true;
        }
        petEstaActivo = 1;
    }

    private void drenarEnergia() {
        System.out.println("Tus artes oscuras beben el alma de tu enemigo.");
        int exito = (int)(Math.random() * 100) + personaje.getPrecision() - evasionEnemigo;
        double mod = modificadorGolpe(exito) - 15;
        int daño = (int)(personaje.getAtaque() * mod);
        saludEnemigo -= daño;
        saludPersonaje += daño;
        if (saludPersonaje > personaje.getPsMax()){
            saludPersonaje = personaje.getPsMax();
        }
    }

    public void victoria(){
        victoria = true;
        personaje.setOro(personaje.getOro() + enemigo.getOro());
        personaje.setExperiencia(personaje.getExperiencia() + enemigo.getExperiencia());
        Sesion.getInstance().getPersonaje().actualizarPersonaje(personaje);
    }

    public void derrota(){
        derrota = true;
        personaje.setOro((int)(personaje.getOro()*0.75));
        Sesion.getInstance().getPersonaje().actualizarPersonaje(personaje);
    }

    private double modificadorGolpe(int exito){
        if (exito <= 15){
            return 0;
        }else if (exito <= 50){
            return 0.5;
        }else if (exito <= 75){
            return 1;
        }else if (exito > 76){
            return 1.25;
        }
        return 0;
    }
}
