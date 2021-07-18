package estg.ipvc.gabrielSousa.menus.fornecedor;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarPreRegisto;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_CriarServicoEmpresa;


public class MultiMenu_FornecedorHome extends MultiLeveledMenu {

    public MultiMenu_FornecedorHome(MainData data) {
        super(new Menu[]{
                new SingleMenu_CriarServicoEmpresa(data)
        });
        super.setData(data);
    }

    @Override
    public String getName() {
        return "Main Menu Fornecedor";
    }

}

