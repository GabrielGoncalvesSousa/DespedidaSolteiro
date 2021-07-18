package estg.ipvc.gabrielSousa.menus.base;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;

public class DataCheckers extends SingleLeveledMenu {

    public DataCheckers(MainData data) {
        super(data);
    }

    public boolean checkIfMailExists(String mail) {
        try {
            for (Pessoa p : getData().getPessoas()) {
                if (p.getEmail().equals(mail)) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public boolean checkIfLoginExists(String login) {
        try {
            for (Pessoa p : getData().getPessoas()) {
                if (p.getLogin().equals(login)) {
                    throw new Exception();
                }
            }

        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public boolean checkIfLoginAndPasswordExists(String login, String password) {
        try {
            for (Pessoa p : getData().getPessoas()) {
                if (p.login(login, password)) {
                   getData().setCurrentPessoa(p);
                   return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
