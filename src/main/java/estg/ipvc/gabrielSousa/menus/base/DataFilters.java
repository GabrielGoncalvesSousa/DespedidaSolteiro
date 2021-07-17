package estg.ipvc.gabrielSousa.menus.base;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;

public class DataFilters extends SingleOption {
    public DataFilters(MainData data) {
        super(data);
    }

    public void getTiposParaPreRegisto() {

        for (TipoPessoa tp : getData().getTpPessoas()) {
            if (tp.getId_tipoPessoa() == 2 | tp.getId_tipoPessoa() == 3)
                System.out.println(tp.getId_tipoPessoa() + " - " + tp.getNomeTipoPessoa());
        }
    }

    public TipoPessoa getTipoPessoaSelecionadaParaRegisto(int id_tp){
        try {
            for (TipoPessoa tipoPessoa : getData().getTpPessoas()) {
                if (tipoPessoa.getId_tipoPessoa() ==id_tp ) {
                    return tipoPessoa;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
