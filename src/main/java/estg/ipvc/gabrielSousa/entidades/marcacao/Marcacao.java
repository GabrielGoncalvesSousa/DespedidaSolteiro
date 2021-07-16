package ipvc.gabrielSousa.entidades;

public class Marcacao implements java.io.Serializable {
    private int id_marcacao;
    private EstadoMarcacao estadoMarcacao;
    private ServicoEmpresa servicoEmpresa;

    public EstadoMarcacao getEstadoMarcacao() {
        return estadoMarcacao;
    }

    public int getId_marcacao() {
        return id_marcacao;
    }

    public ServicoEmpresa getServicoEmpresa() {
        return servicoEmpresa;
    }

    public void setEstadoMarcacao(EstadoMarcacao estadoMarcacao) {
        this.estadoMarcacao = estadoMarcacao;
    }

    public void setId_marcacao(int id_marcacao) {
        this.id_marcacao = id_marcacao;
    }

    public void setServicoEmpresa(ServicoEmpresa servicoEmpresa) {
        this.servicoEmpresa = servicoEmpresa;
    }
}
