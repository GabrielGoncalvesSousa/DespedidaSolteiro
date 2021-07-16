package estg.ipvc.gabrielSousa.entidades.pessoa;

public class Pessoa implements java.io.Serializable {
    private int id_pessoa;
    private TipoPessoa tipoPessoa;
    private String login;
    private String password;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String contato;
    private static int contadorPessoa;

    public Pessoa( TipoPessoa tipoPessoa, String login, String password,
                  String primeiroNome, String ultimoNome, String email, String contato) {
        this.id_pessoa = contadorPessoa;
        contadorPessoa +=1;
        this.tipoPessoa = tipoPessoa;
        this.login =login;
        this.password = password;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.contato = contato;
    }

/*
    public Pessoa criarPessoa(int id_pessoa, TipoPessoa tipoPessoa, String login, String password,
                              String primeiroNome, String ultimoNome, String email, String contato) {
        Pessoa p = new Pessoa();
        p.setId_pessoa(id_pessoa);
        p.setTipoPessoa(tipoPessoa);
        p.setLogin(login);
        p.setPassword(password);
        p.setPrimeiroNome(primeiroNome);
        p.setUltimoNome(ultimoNome);
        p.setEmail(email);
        p.setContato(contato);
        return p;
    }
*/

    //Getters
    public int getId_pessoa() {
        return id_pessoa;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public String getContato() {
        return contato;
    }

   public TipoPessoa getTipoPessoa(){return tipoPessoa;}

    public static int getContadorPessoa() {
        return contadorPessoa;
    }

    //Setters
    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipoPessoa(TipoPessoa p) {
        this.tipoPessoa = p;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public boolean login(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public static void setContadorPessoa(int contadorPessoa) {
        Pessoa.contadorPessoa = contadorPessoa;
    }
}
