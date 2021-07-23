package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

public class SingleMenu_GerirEstadoMarcacao extends MenuData implements Menu {
    @Override
    public void action() {

        //Print das marcacoes
        getMainData().getMarcacoes().forEach(marcacao -> System.out.println(marcacao.toString()));

        //Obter a instancia da marcacao após as verificacoes.
        System.out.print("Selecione uma marcação: ");
        int idMarcacao = getMarcacao();
        Marcacao marcacaoEscolhida = getMainData().getMarcacoes().get(idMarcacao);

        //Print dos estados disponiveis a alterar na marcacao
        System.out.println("Estados Disponiveis");
        getMainData().getEstadoMarcacaos().forEach(estadoMarcacao ->
                System.out.println(estadoMarcacao.getId_estadoMarcacao() + " - "
                        + estadoMarcacao.getNomeEstadoMarcacao()));

        //Obter o estado após as verificacoes.
        System.out.print("Selecione um estado: ");
        int idEstado = getEstadoMarcacao();

        //Atribuir o estado a marcacao
        marcacaoEscolhida.setEstadoMarcacao(getMainData().getEstadoMarcacaos().get(idEstado));
        System.out.println("Marcação alterada com sucesso.");

        //Guardar os dados no ficheiro
        getSerialization().saveData(getMainData());
    }

    @Override
    public String getName() {
        return "Gerir Estado das Marcações";
    }
}
