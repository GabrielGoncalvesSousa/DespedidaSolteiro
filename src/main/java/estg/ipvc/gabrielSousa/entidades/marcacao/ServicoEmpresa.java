package estg.ipvc.gabrielSousa.entidades.marcacao;

import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;

public class ServicoEmpresa implements java.io.Serializable {
    private int id_servicoEmpresa;
    private Pessoa pessoa;
    private String nomeServico;
    private String contato;
    private String duracao;
    private Localidade localidade;
    private int precoComIva;
    private int iva;
    private String descricao;
    private static int contador;
    private boolean isAprovado;

    public ServicoEmpresa(Pessoa pessoa, String nomeServico, String contato,
                          String duracao, Localidade localidade, int precoComIva,
                          int iva, String descricao) {
        this.id_servicoEmpresa=contador;
        contador+=1;
        this.pessoa=pessoa;
        this.nomeServico = nomeServico;
        this.contato = contato;
        this.duracao = duracao;
        this.localidade = localidade;
        this.precoComIva = precoComIva;
        this.iva = iva;
        this.descricao = descricao;
        this.isAprovado=false;
    }
}
