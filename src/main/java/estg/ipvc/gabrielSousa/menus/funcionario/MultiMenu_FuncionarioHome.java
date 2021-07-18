package estg.ipvc.gabrielSousa.menus.funcionario;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.gestorSistema.SingleMenu_AprovarPreRegisto;


public class MultiMenu_FuncionarioHome extends MultiLeveledMenu {

    public MultiMenu_FuncionarioHome(MainData data) {
        super(new Menu[]{
                new SingleMenu_AprovarPreRegisto(data)
        });
        super.setData(data);
    }

    @Override
    public String getName() {
        return "Main Menu Funcionario";
    }

}

