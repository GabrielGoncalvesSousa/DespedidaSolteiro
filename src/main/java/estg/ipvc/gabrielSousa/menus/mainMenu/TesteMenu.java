package estg.ipvc.gabrielSousa.menus.mainMenu;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.Funcionario;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleOption;

public class TesteMenu extends SingleOption implements Menu {

    public TesteMenu(MainData data) {
        super(data);
    }

    @Override
    public void action() {

        getData().getPessoas().add(new Funcionario(1, getData().getTpPessoas().get(1), "funcionario1", "123", "Nuno1", "Oliveira1"
                , "nunoOliveira@ipvc.pt1", "934506842"));
    }

    @Override
    public String getName() {
        return "Adding Nuno1";
    }
}
