package estg.ipvc.gabrielSousa.entidades.pessoa;

public class TipoPessoa implements java.io.Serializable {
    private int id_tipoPessoa;
    private String nomeTipoPessoa;

    public TipoPessoa(){

    }

    public TipoPessoa(int id_tipoPessoa, String nomeTipoPessoa){
        this.id_tipoPessoa=id_tipoPessoa;
        this.nomeTipoPessoa=nomeTipoPessoa;
    }

    public void setNomeTipoPessoa(String nomeTipoPessoa) {
        this.nomeTipoPessoa = nomeTipoPessoa;
    }

    public void setId_tipoPessoa(int id_tipoPessoa) {
        this.id_tipoPessoa = id_tipoPessoa;
    }

    public int getId_tipoPessoa() {
        return id_tipoPessoa;
    }

    public String getNomeTipoPessoa() {
        return nomeTipoPessoa;
    }
}
