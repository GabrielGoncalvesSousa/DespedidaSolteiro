package estg.ipvc.gabrielSousa;

import estg.ipvc.gabrielSousa.menus.login_preRegisto.MultiMenu_MainMenu;

public class Main {
    public static void main(String[] args) {
      /*  MainData data = serialization.loadData();*/
        MultiMenu_MainMenu multiMenuMainMenu = new MultiMenu_MainMenu();
        multiMenuMainMenu.run();
    }
}