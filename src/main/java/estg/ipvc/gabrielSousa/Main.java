package estg.ipvc.gabrielSousa;


import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Serialization;
import estg.ipvc.gabrielSousa.menus.login_preRegisto.MultiMenu_MainMenu;

public class Main {
    public static void main(String[] args) {
        Serialization serialization = new Serialization();

        //Save fabricated data
        MainData data = new MainData();
        serialization.saveData(data);

      /*  MainData data = serialization.loadData();*/
        MultiMenu_MainMenu multiMenuMainMenu = new MultiMenu_MainMenu(data);
        multiMenuMainMenu.run();
    }
}
