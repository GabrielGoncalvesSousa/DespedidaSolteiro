/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estg.ipvc.gabrielSousa.menus.mainMenu;


import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.OptionsMenu;

/**
 *
 * @author Gabriel Sousa
 */

public class MainMenu extends OptionsMenu {

    public MainMenu(MainData data) {
        super(new Menu[] {
                new LoginMenu(data),
                new TesteMenu(data)
        });
        super.setData(data);
    }

    @Override
    public String getName() {
        return "Main Menu";
    }

}
