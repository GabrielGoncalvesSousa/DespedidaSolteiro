import entidades.Distrito;
import entidades.MainData;
import menus.mainMenu.MainMenu;
import menus.Serialization;

public class Main {
    public static void main(String[] args) {
        Serialization serialization = new Serialization();

        //Save fabricated data
        MainData data = new MainData();
        serialization.saveData(data);

      /*  MainData data = serialization.loadData();*/
        MainMenu mainMenu = new MainMenu(data);
        mainMenu.run();

    }
}
