package estg.ipvc.gabrielSousa.entidades.marcacao;

import estg.ipvc.gabrielSousa.entidades.pessoa.Cliente;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;

public class Marcacao implements java.io.Serializable {
    private int id_marcacao;
    private Pessoa cliente;
    private EstadoMarcacao estadoMarcacao;
    private ServicoEmpresa servicoEmpresa;
    private static int contador;

    public Marcacao(Pessoa cliente,EstadoMarcacao estadoMarcacao, ServicoEmpresa servicoEmpresa) {
        this.id_marcacao=contador;
        contador+=1;
        this.cliente=cliente;
        this.estadoMarcacao = estadoMarcacao;
        this.servicoEmpresa = servicoEmpresa;
    }

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
