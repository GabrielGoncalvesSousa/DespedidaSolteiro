package estg.ipvc.gabrielSousa.menus.login_preRegisto;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.GestorSistema;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;
import estg.ipvc.gabrielSousa.menus.gestorSistema.MultiMenu_GestorSistemaHome;

import java.util.Scanner;
import java.util.Stack;

public class SingleMenu_Login extends SingleLeveledMenu implements Menu {
    private Menu currentUserMenu;
    private Stack stack;

    public SingleMenu_Login(MainData data) {
        super(data);
    }

    @Override
    public void action() {

    }


    @Override
    public String getName() {
        return null;
    }


}
