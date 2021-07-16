/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus.mainMenu;

import entidades.MainData;
import menus.base.Menu;
import menus.base.OptionsMenu;


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
