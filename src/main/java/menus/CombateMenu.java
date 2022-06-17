package menus;

import Utils.Combate;
import Utils.Sesion;
import domain.Enemigo;
import domain.Personaje;

public class CombateMenu extends Menu{

    Enemigo enemigo;
    Personaje personaje = Sesion.getInstance().getPersonajeActivo();

    public CombateMenu(String title) {
        super(title);
    }

    Combate combate = new Combate(personaje, enemigo);

    @Override
    protected void initActions() {

        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                combate.personajeAtacaEnemigo();
                if (combate.getTipoTotem()=="Viento"){
                    System.out.println("¡El totem de viento te acelera y vuelves a atacar!");
                    combate.personajeAtacaEnemigo();
                }
                combate.enemigoIA();
                sleep(5000);
            }

            @Override
            public String getOptionName() {
                return "Atacar";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                combate.personajeDefiende();
                combate.enemigoIA();
                sleep(5000);
            }

            @Override
            public String getOptionName() {
                return "Defensa";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                if(combate.getCooldown() != 0) {
                    System.out.println("¡¡La habilidad aún está en cooldown!!");
                    sleep(5000);
                } else {
                    combate.personajeUsaHabilidadEspecial();
                    combate.enemigoIA();
                }
            }

            @Override
            public String getOptionName() {
                return "Habilidad de Clase";
            }
        });

        addOption("4", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Salir por piernas");
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "huir";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        combate.nuevaRonda();
    }

}
