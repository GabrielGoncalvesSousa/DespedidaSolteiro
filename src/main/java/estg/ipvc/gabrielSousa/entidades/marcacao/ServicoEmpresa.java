package estg.ipvc.gabrielSousa.entidades.marcacao;

import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;

import java.time.Duration;

public class ServicoEmpresa implements java.io.Serializable {
    private int id_servicoEmpresa;
    private Pessoa pessoa;
    private String nomeServico;
    private String contato;
    private Duration duracao;
    private Localidade localidade;
    private int precoComIva;
    private int iva;
    private String descricao;
    private static int contador = 0;
    private boolean isAprovado;

    public ServicoEmpresa(Pessoa pessoa, String nomeServico, String contato,
                          Duration duracao, Localidade localidade, int precoComIva,
                          int iva, String descricao) {
        this.id_servicoEmpresa = contador;
        contador += 1;
        this.pessoa = pessoa;
        this.nomeServico = nomeServico;
        this.contato = contato;
        this.duracao = duracao;
        this.localidade = localidade;
        this.precoComIva = precoComIva;
        this.iva = iva;
        this.descricao = descricao;
        this.isAprovado = false;
    }


    public boolean isAprovado() {
        return isAprovado;
    }

    @Override
    public String toString() {
        String s = (
                "Servico nº " + this.id_servicoEmpresa
                        + "\n\tRequesitado por - " + this.pessoa.getPrimeiroNome().concat(" " + this.pessoa.getUltimoNome())
                        + "\n\tNome de Serviço - " + this.nomeServico
                        + "\n\tDuração de - " + this.duracao.toHoursPart() + " horas e " + this.duracao.toMinutesPart() + " minutos"
                        + "\n\tContato do Prestador de Serviço - " + this.contato
                        + "\n\tLocalidade -  "
                            + "\n\t\tCodigo-Postal: " + this.localidade.getCodigo_postal()
                            + "\n\t\tRua: " + this.localidade.getNomeLocalidade()
                            + "\n\t\tDistrito:" + this.localidade.getDistrito().getNomeDistrito()
                        + "\n\tPreço com Iva - " + this.precoComIva + "€"
                        + "\n\tIva do Serviço - " + this.iva + "%"
                        + "\n\tDescrição do Serviço - " + this.descricao
        );

        return s;
    }

    public String toStringCliente() {
        String s = (
                "Servico nº " + this.id_servicoEmpresa
                        + "\n\tNome de Serviço - " + this.nomeServico
                        + "\n\tDuração de - " + this.duracao.toHoursPart() + " horas e " + this.duracao.toMinutesPart() + " minutos"
                        + "\n\tContato do Prestador de Serviço - " + this.contato
                        + "\n\tLocalidade -  \n\t\tCodigo-Postal: " + this.localidade.getCodigo_postal() + "\n\t\tRua: " + this.localidade.getNomeLocalidade() + "\n\t\tDistrito:" + this.localidade.getDistrito().getNomeDistrito()
                        + "\n\tPreço com Iva - " + String.format("%.2f", this.precoComIva * 1.35) + "€"
                        + "\n\tIva do Serviço - " + this.iva + "%"
                        + "\n\tDescrição do Serviço - " + this.descricao
        );
        return s;
    }

    public int getId_servicoEmpresa() {
        return id_servicoEmpresa;
    }

    public void setAprovado(boolean aprovado) {
        isAprovado = aprovado;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public int getPrecoComIva() {
        return precoComIva;
    }

    public Pessoa getPessoa(){
        return pessoa;
    }
}
