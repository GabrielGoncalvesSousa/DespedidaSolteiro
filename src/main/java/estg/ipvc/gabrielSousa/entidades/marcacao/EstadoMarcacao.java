package estg.ipvc.gabrielSousa.entidades.marcacao;

public class EstadoMarcacao implements java.io.Serializable{
    private int id_estadoMarcacao;
    private String nomeEstadoMarcacao;

    public int getId_estadoMarcacao() {
        return id_estadoMarcacao;
    }

    public String getNomeEstadoMarcacao() {
        return nomeEstadoMarcacao;
    }

    public void setId_estadoMarcacao(int id_estadoMarcacao) {
        this.id_estadoMarcacao = id_estadoMarcacao;
    }

    public void setNomeEstadoMarcacao(String nomeEstadoMarcacao) {
        this.nomeEstadoMarcacao = nomeEstadoMarcacao;
    }

    public EstadoMarcacao(int id_estadoMarcacao, String nomeEstadoMarcacao) {
        this.id_estadoMarcacao = id_estadoMarcacao;
        this.nomeEstadoMarcacao = nomeEstadoMarcacao;
    }
}
