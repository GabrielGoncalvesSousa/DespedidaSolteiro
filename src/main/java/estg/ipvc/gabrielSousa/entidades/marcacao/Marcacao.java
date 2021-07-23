package estg.ipvc.gabrielSousa.entidades.marcacao;

import estg.ipvc.gabrielSousa.entidades.pessoa.Cliente;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;

public class Marcacao implements java.io.Serializable {
    private int id_marcacao;
    private Pessoa cliente;
    private EstadoMarcacao estadoMarcacao;
    private ServicoEmpresa servicoEmpresa;
    private int pontuacao;
    private static int contador=0;
    private String data;

    public Marcacao(Pessoa cliente,EstadoMarcacao estadoMarcacao, ServicoEmpresa servicoEmpresa, int pontuacao,
                    String data) {
        this.id_marcacao=contador;
        contador+=1;
        this.cliente=cliente;
        this.estadoMarcacao = estadoMarcacao;
        this.servicoEmpresa = servicoEmpresa;
        this.pontuacao=pontuacao;
        this.data=data;
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

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString(){
        String marcacao = ("\n\tMarcação nº "+this.id_marcacao
                +"\n\t\t Empresa da Marcação - "+ this.servicoEmpresa.getNomeServico()
                +"\n\t\t Estado da Marcação - "+this.getEstadoMarcacao().getNomeEstadoMarcacao()
                +"\n\t\t Localização da Marcação - "+this.getServicoEmpresa().getLocalidade().getNomeLocalidade()
                +" no Distrito de "+this.getServicoEmpresa().getLocalidade().getDistrito().getNomeDistrito()
                +"\n\t\t Preço do Serviço - "+String.format("%.2f",this.getServicoEmpresa().getPrecoComIva()*1.35)
                +"\n\t\t Duração do Serviço - "+this.getServicoEmpresa().getDuracao()
                +"\n\t\t Data - "+this.getData()
                );
        if (this.pontuacao!=0){
            marcacao+=("\n\t\t Pontuação do Serviço - "+this.getPontuacao());
        }
        return marcacao;
    }

    public Pessoa getCliente() {
        return cliente;
    }
}
