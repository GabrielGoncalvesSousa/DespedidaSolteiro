package estg.ipvc.gabrielSousa.entidades.marcacao;

public class Localidade implements java.io.Serializable {
    private String codigo_postal;
    private Distrito distrito;
    private String nomeLocalidade;

    public Localidade(String codigo_postal, Distrito distrito, String nomeLocalidade){
        this.codigo_postal=codigo_postal;
        this.distrito=distrito;
        this.nomeLocalidade=nomeLocalidade;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }
}
