package estg.ipvc.gabrielSousa.entidades.pessoa;

public class Cliente extends Pessoa {


    public Cliente(TipoPessoa tipoPessoa, String login, String password, String primeiroNome, String ultimoNome, String email, String contato) {
        super(tipoPessoa, login, password, primeiroNome, ultimoNome, email, contato,false);
    }

    public void criarPreRegisto() {

    }

    public void criarMarcacao() {

    }

    public void verEstadoMarcacao() {

    }

    public void avaliarServico() {

    }
}
