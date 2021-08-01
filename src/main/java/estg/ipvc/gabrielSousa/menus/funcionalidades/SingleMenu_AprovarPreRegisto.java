package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;
import java.util.ArrayList;

public class SingleMenu_AprovarPreRegisto extends MenuData {
    @Override
    public void action() {
        try {
            //ArrayList que ira guardar as contas em espera para aprovar
            ArrayList<Pessoa> pessoasNaoProvadas = getContasParaAprovar();

            if (pessoasNaoProvadas.isEmpty()) {
                throw new Exception("Não existem contas aguardado aprovação.");
            }

            boolean verifier;
            do{
                verifier =optionChecker(pessoasNaoProvadas);
            } while (!verifier);



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
            int id = Integer.parseInt(getScanner().nextLine());

            for (Pessoa p : pessoasNaoProvadas) {
                if (p.getId_pessoa() == id) {
                    p.setAprovado(true);
                    System.out.println("\nUtilizador Aprovado com sucesso.");

                    //Guardar os dados no ficheiro
                    getSerialization().saveData(getMainData());
                    return true;
                }
            }

            throw new Exception();

        } catch (Exception e) {
            System.out.print("Opção Inválida. ");
            return false;
        }
    }
}
