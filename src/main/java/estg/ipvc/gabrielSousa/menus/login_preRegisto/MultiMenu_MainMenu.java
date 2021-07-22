/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estg.ipvc.gabrielSousa.menus.login_preRegisto;


import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;


/**
 *
 * @author Gabriel Sousa
 */

public class MultiMenu_MainMenu extends MultiLeveledMenu {

    public MultiMenu_MainMenu() {
        super(new Menu[] {
                new MultiMenu_Login(),
                new SingleMenu_PreRegisto()
        });
    }

    @Override
    public String getName() {
        return "Main Menu";
    }

}
