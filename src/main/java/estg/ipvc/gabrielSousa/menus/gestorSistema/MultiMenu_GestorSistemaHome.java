package estg.ipvc.gabrielSousa.menus.gestorSistema;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarPreRegisto;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_GerirEstadoMarcacao;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_VerInfoCliente;


public class MultiMenu_GestorSistemaHome extends MultiLeveledMenu {

    public MultiMenu_GestorSistemaHome(MainData data) {
        super(new Menu[]{
                new SingleMenu_AprovarPreRegisto(data),
                new SingleMenu_AprovarServicoEmpresa(data),
                new SingleMenu_VerInfoCliente(data),
                new SingleMenu_GerirEstadoMarcacao(data)
        });
        super.setData(data);
    }

    @Override
    public String getName() {
        return "Main Menu Gestor Sistema";
    }

}

