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
    private static int contadorPessoa=0;
    private boolean isAprovado;

    public Pessoa(TipoPessoa tipoPessoa, String login, String password,
                  String primeiroNome, String ultimoNome, String email, String contato, boolean isAprovado) {
        this.id_pessoa = contadorPessoa;
        contadorPessoa += 1;
        this.tipoPessoa = tipoPessoa;
        this.login = login;
        this.password = password;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.contato = contato;
        this.isAprovado = isAprovado;
    }

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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public static int getContadorPessoa() {
        return contadorPessoa;
    }

    public boolean isAprovado() {
        return isAprovado;
    }

    public void setAprovado(boolean aprovado) {
        isAprovado = aprovado;
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

    @Override
    public String toString() {
        String s = ("Utilizador nº " + this.id_pessoa
                + "\n\tTipo de Utilizador - " + this.getTipoPessoa().getNomeTipoPessoa()
                + "\n\tNome - " + this.primeiroNome.concat(" " + this.ultimoNome)
                + "\n\tEmail - " + this.email
                + "\n\tContato - " + this.contato );
        return s;
    }

}
