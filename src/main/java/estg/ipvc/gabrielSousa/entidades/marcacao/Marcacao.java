package estg.ipvc.gabrielSousa.entidades.marcacao;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Marcacao implements java.io.Serializable {
    private int id_marcacao;
    private final Pessoa cliente;
    private EstadoMarcacao estadoMarcacao;
    private ServicoEmpresa servicoEmpresa;
    private int pontuacao;
    private static int contador=0;
    private final LocalDateTime data;

    public Marcacao(Pessoa cliente,EstadoMarcacao estadoMarcacao, ServicoEmpresa servicoEmpresa, int pontuacao,
                    LocalDateTime data) {
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

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString(){
        String marcacao = ("\n\tMarcação nº "+this.id_marcacao
                +"\n\t\t Empresa da Marcação - "+ this.servicoEmpresa.getNomeServico()
                +"\n\t\t Estado da Marcação - "+this.getEstadoMarcacao().getNomeEstadoMarcacao()
                +"\n\t\t Localidade -" +
                    "\n\t\t\tCodigo-Postal: "+this.servicoEmpresa.getLocalidade().getCodigo_postal()+
                    "\n\t\t\tRua: " + this.servicoEmpresa.getLocalidade().getNomeLocalidade() +
                    "\n\t\t\tDistrito:" + this.servicoEmpresa.getLocalidade().getDistrito().getNomeDistrito()
                +"\n\t\t Preço do Serviço - "+String.format("%.2f",this.getServicoEmpresa().getPrecoComIva()*1.35)+"€"
                +"\n\t\t Duração do Serviço - "+this.getServicoEmpresa().getDuracao().toHoursPart()+" horas e "+this.getServicoEmpresa().getDuracao().toMinutesPart()+ " minutos"
                +"\n\t\t Data - "+this.getData().format(DateTimeFormatter.ofPattern("d/M/y H:mm"))
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
