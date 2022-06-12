package menus;

import Utils.Sesion;

public class SeleccionarPersonajeMenu extends Menu{

    public SeleccionarPersonajeMenu(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                Sesion.getInstance().setPersonajeActivo(
                Sesion.getInstance().getPersonaje().listaPersonajes(Sesion.getInstance().getJugadorActivo())
                );

                new AntesDeAventuraMenu("Antes de salir").start();
            }

            @Override
            public String getOptionName() {
                return "Seleccionar Personaje";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                new CrearPersonajeMenu("Crear personaje").start();
            }

            @Override
            public String getOptionName() {
                return "Crear Personaje";
            }
        });
    }

    @Override
    protected void onPreOptions() {

    }
}
