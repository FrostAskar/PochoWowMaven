package menus;

import Utils.Sesion;

public class CrearPersonajeMenu extends Menu{

    Sesion sesion = Sesion.getInstance();

    public CrearPersonajeMenu(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                String nombre = Input.readString("Introduce un nombre para tu Paladín: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Paladín", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Paladín";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Pícaro: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Pícaro", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Pícaro";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Sacerdote: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Sacerdote", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Sacerdote";
            }
        });

        addOption("4", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Brujo: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Brujo", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Brujo";
            }
        });

        addOption("5", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Mago: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Mago", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Mago";
            }
        });

        addOption("6", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Chamán: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Chamán", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Chamán";
            }
        });

        addOption("7", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Druida: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Druida", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Druida";
            }
        });

        addOption("8", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Cazador: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Cazador", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Cazador";
            }
        });

        addOption("9", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Guerrero: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Guerrero", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Guerrero";
            }
        });

        addOption("10", new MenuAction() {
            @Override
            public void execute() {

                String nombre = Input.readString("Introduce un nombre para tu Maestro de Juego: ");
                if (Sesion.getInstance().getPersonaje().crearPersonaje("Maestro de Juego", nombre, sesion.getJugadorActivo())){
                    System.out.println("Personaje creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Maestro de Juego";
            }
        });

    }

    @Override
    protected void onPreOptions() {
        System.out.println("Selecciona tu clase");

    }
}
