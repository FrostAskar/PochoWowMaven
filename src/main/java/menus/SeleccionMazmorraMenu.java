package menus;

public class SeleccionMazmorraMenu extends Menu{
    public SeleccionMazmorraMenu(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                new MazmorraMenu("Mazmorra", "Caverna de Brazanegra").start();
            }

            @Override
            public String getOptionName() {
                return "Caverna de Brazanegra";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                new MazmorraMenu("Mazmorra", "Templo Oscuro").start();
            }

            @Override
            public String getOptionName() {
                return "Templo Oscuro";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                new MazmorraMenu("Mazmorra", "Ciudadela Corona de Hielo").start();
            }

            @Override
            public String getOptionName() {
                return "Ciudadela Corona de Hielo";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        System.out.println("¿En qué mazmorra quieres aventurarte?");
    }
}
