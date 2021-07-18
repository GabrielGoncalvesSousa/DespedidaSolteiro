package estg.ipvc.gabrielSousa.menus.gestorSistema;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleMenu_AprovarPreRegisto extends SingleLeveledMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);

    public SingleMenu_AprovarPreRegisto(MainData data) {
        super(data);
    }

    @Override
    public void action() {
        try {
            ArrayList<Pessoa> pessoasNaoProvadas = getDataFilters().getContasParaAprovar();

            if (pessoasNaoProvadas.isEmpty()) {
                throw new Exception("Não existem contas aguardado aprovação.");
            }

            while (!optionChecker(pessoasNaoProvadas)) {
                optionChecker(pessoasNaoProvadas);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getName() {
        return "Aprovar Pré-Registos.";
    }

    public boolean optionChecker(ArrayList<Pessoa> pessoasNaoProvadas) {
        try {
            System.out.print("Escolha um utilizador a aprovar: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Pessoa p : pessoasNaoProvadas) {
                if (p.getId_pessoa() == id) {
                    p.setAprovado(true);
                    System.out.println("\nUtilizador Aprovado com sucesso.");
                    return true;
                }
            }

            throw new Exception("\nOpção Inválida.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
