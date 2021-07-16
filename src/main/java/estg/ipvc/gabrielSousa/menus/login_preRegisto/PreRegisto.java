package estg.ipvc.gabrielSousa.menus.login_preRegisto;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleOption;

import java.util.Scanner;

public class PreRegisto extends SingleOption implements Menu {
    private Scanner scanner = new Scanner(System.in);

    public PreRegisto(MainData data) {
        super(data);
    }

    @Override
    public void action() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduza o Login");
            String login = scanner.nextLine();
            checkIfLoginExists(login);

            System.out.println("Introduza a password");
            String password = scanner.nextLine();

            System.out.println("Introduza o tipo de utilizador");
            TipoPessoa pessoaRegista = getTipoPessoa();

            System.out.println("Introduza o Primeiro Nome");
            String primeiroNome = scanner.nextLine();

            System.out.println("Introduza o Ultimo Nome");
            String ultimoNome = scanner.nextLine();

            System.out.println("Introduza o Email");
            String email = scanner.nextLine();
            checkIfMailExists(email);

            System.out.println("Introduza o seu contato");
            String contato =scanner.nextLine();

            Pessoa p = new Pessoa(pessoaRegista,login,password,primeiroNome,ultimoNome,email,contato);
            getData().getPessoas().add(p);

        } catch (Exception e) {

        }

        for (Pessoa pessoa: getData().getPessoas()){
            System.out.println("ID - " + pessoa.getId_pessoa() + " Tp Util - " + pessoa.getTipoPessoa().getNomeTipoPessoa()
            + " Nome Pessoa - " + pessoa.getPrimeiroNome());

        }

    }

    @Override
    public String getName() {
        return "Registar";
    }

    public boolean checkIfLoginExists(String login) {
        try {
            for (Pessoa p : getData().getPessoas()) {
                if (p.getLogin().equals(login)) {
                    throw new Exception();
                }
            }

        } catch (Exception e) {
            System.out.println("Login já utilizado.");
            return false;
        }

        return true;
    }

    public boolean checkIfMailExists(String mail) {
        try {
            for (Pessoa p : getData().getPessoas()) {
                if (p.getEmail().equals(mail)) {
                    throw new Exception();
                }
            }

        } catch (Exception e) {
            System.out.println("Mail já utilizado.");
            return false;
        }

        return true;
    }

    public TipoPessoa getTipoPessoa() {
        TipoPessoa pessoaRegistar = null;

        for (TipoPessoa tp : getData().getTpPessoas()) {
            System.out.println(tp.getId_tipoPessoa() + " - " + tp.getNomeTipoPessoa());
        }

        int idTipoPessoa = scanner.nextInt();

        for (TipoPessoa tp : getData().getTpPessoas()) {
            if (tp.getId_tipoPessoa() == idTipoPessoa) {
                pessoaRegistar = tp;
            }
        }
        return pessoaRegistar;
    }

}
