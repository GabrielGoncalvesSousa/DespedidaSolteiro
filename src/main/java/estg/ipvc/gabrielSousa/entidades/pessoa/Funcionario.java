package estg.ipvc.gabrielSousa.entidades.pessoa;

public class Funcionario extends Pessoa {

    public Funcionario(TipoPessoa tipoPessoa, String login, String password,
                       String primeiroNome, String ultimoNome, String email, String contato) {

        super(tipoPessoa, login, password, primeiroNome, ultimoNome, email, contato, true);
    }

    public void gerirEstadoMarcacao() {

    }

    public void verInfoCliente() {

    }
}
