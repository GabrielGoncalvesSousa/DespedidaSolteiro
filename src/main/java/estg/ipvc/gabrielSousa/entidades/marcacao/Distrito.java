package estg.ipvc.gabrielSousa.entidades.marcacao;

public class Distrito implements java.io.Serializable {
    private int id_distrito;
    private String nomeDistrito;
    private static int contador;

    public Distrito(String nomeDistrito) {
        this.id_distrito = contador;
        contador += 1;
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
