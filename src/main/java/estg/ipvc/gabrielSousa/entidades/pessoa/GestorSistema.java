package estg.ipvc.gabrielSousa.entidades.pessoa;


public class GestorSistema extends Pessoa {

    public GestorSistema(TipoPessoa tipoPessoa, String login, String password,
                         String primeiroNome, String ultimoNome, String email, String contato) {
        super( tipoPessoa, login, password, primeiroNome, ultimoNome, email, contato,true);
    }

    public void aprovarPreRegisto(){

    }

    public void aprovarServicoEmpresa(){

    }

    public void verInfoCliente(){

    }

    public void verInfoServicoPrestado(){

    }

}
