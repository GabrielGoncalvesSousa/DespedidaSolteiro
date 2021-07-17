package estg.ipvc.gabrielSousa.menus.login_preRegisto;


import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.GestorSistema;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.cliente.MultiMenu_ClienteHome;
import estg.ipvc.gabrielSousa.menus.fornecedor.MultiMenu_FornecedorHome;
import estg.ipvc.gabrielSousa.menus.funcionario.MultiMenu_FuncionarioHome;
import estg.ipvc.gabrielSousa.menus.gestorSistema.MultiMenu_GestorSistemaHome;

import java.util.Scanner;

public class MultiMenu_Login extends MultiLeveledMenu {

    public MultiMenu_Login(MainData data) {
        super(new Menu[]{
                new SingleMenu_Login(data),
        });
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o Login");
        String login = scanner.nextLine();
        System.out.println("Introduza a password");
        String password = scanner.nextLine();


        getData().setCurrentPessoa(null);

        try {
            //Return true if user exists exists
            if (!getDataCheckers().checkIfLoginAndPasswordExists(login, password)) {
                throw new Exception("Credencias Inválidas");
            } else if (!getData().getCurrentPessoa().isAprovado()) {
                throw new Exception("A conta ainda não foi aprovada");
            } else {
                welcomeMessage();
                switch (getData().getCurrentPessoa().getId_pessoa()) {
                    case 0 -> {
                        super.addMenu(new MultiMenu_GestorSistemaHome(getData()));
                    }
                    case 1 -> {
                        super.addMenu(new MultiMenu_FuncionarioHome(getData()));
                    }
                    case 2 -> {
                        super.addMenu(new MultiMenu_FornecedorHome(getData()));
                    }
                    case 3 -> {
                        super.addMenu(new MultiMenu_ClienteHome(getData()));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void welcomeMessage() {
        System.out.println("Bem Vindo " + getData().getCurrentPessoa().getTipoPessoa().getNomeTipoPessoa() + " "
                + getData().getCurrentPessoa().getPrimeiroNome() + " " + getData().getCurrentPessoa().getUltimoNome());

    }

    @Override
    public String getName() {
        return "Login";
    }

}

