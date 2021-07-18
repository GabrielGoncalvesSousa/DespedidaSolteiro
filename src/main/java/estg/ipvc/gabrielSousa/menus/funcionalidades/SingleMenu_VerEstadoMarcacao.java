package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

public class SingleMenu_VerEstadoMarcacao extends SingleLeveledMenu implements Menu {
    public SingleMenu_VerEstadoMarcacao(MainData data) {
        super(data);
    }

    @Override
    public void action() {
        getData().getMarcacoes().forEach(marcacao -> {
            if(marcacao.getCliente().equals(getData().getCurrentPessoa())){
                System.out.println(marcacao.toString());
            }
        });
    }

    @Override
    public String getName() {
        return "Ver estado das Marcações";
    }
}
