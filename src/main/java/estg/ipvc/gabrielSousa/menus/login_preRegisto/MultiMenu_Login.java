package estg.ipvc.gabrielSousa.menus.login_preRegisto;

import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.cliente.MultiMenu_ClienteHome;
import estg.ipvc.gabrielSousa.menus.fornecedor.MultiMenu_FornecedorHome;
import estg.ipvc.gabrielSousa.menus.funcionario.MultiMenu_FuncionarioHome;
import estg.ipvc.gabrielSousa.menus.gestorSistema.MultiMenu_GestorSistemaHome;

import java.util.Scanner;

public class MultiMenu_Login extends MultiLeveledMenu {
    public MultiMenu_Login() {
        super();
    }


    @Override
    public void action() {
        System.out.print("Introduza o Login: ");
        String login = getScanner().nextLine();
        System.out.print("Introduza a password: ");
        String password = getScanner().nextLine();

        getMainData().setCurrentPessoa(null);

        try {
            //Return true if user exists
            if (!checkIfLoginAndPasswordExists(login, password)) {
                throw new Exception("Credencias Inválidas");
            } else if (!getMainData().getCurrentPessoa().isAprovado()) {
                throw new Exception("A conta ainda não foi aprovada");
            } else {
                welcomeMessage();
                switch (getMainData().getCurrentPessoa().getTipoPessoa().getId_tipoPessoa()) {
                    case 0 -> {
                        addMenu(new MultiMenu_GestorSistemaHome());
                    }
                    case 1 -> {
                        addMenu(new MultiMenu_FuncionarioHome());
                    }
                    case 2 -> {
                        addMenu(new MultiMenu_FornecedorHome());
                    }
                    case 3 -> {
                        addMenu(new MultiMenu_ClienteHome());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void welcomeMessage() {
        System.out.println("Bem Vindo " + getMainData().getCurrentPessoa().getTipoPessoa().getNomeTipoPessoa() + " "
                + getMainData().getCurrentPessoa().getPrimeiroNome() + " " + getMainData().getCurrentPessoa().getUltimoNome());

    }

    @Override
    public String getName() {
        return "Login";
    }
}

