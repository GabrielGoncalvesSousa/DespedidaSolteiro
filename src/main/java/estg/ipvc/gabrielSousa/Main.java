package estg.ipvc.gabrielSousa;


import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Serialization;
import estg.ipvc.gabrielSousa.menus.login_preRegisto.MainMenu;

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
