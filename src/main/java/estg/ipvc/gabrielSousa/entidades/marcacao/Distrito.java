package estg.ipvc.gabrielSousa.entidades.marcacao;

public class Distrito implements java.io.Serializable {
    private int id_distrito;
    private String nomeDistrito;

    public Distrito(int id_distrito, String nomeDistrito) {
        this.id_distrito = id_distrito;
        this.nomeDistrito = nomeDistrito;
    }

    public String getNomeDistrito() {
        return nomeDistrito;
    }

    public int getId_distrito() {
        return id_distrito;
    }

    public void setNomeDistrito(String nome) {
        this.nomeDistrito = nome;
    }
}
