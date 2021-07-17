package estg.ipvc.gabrielSousa.menus.base;

import estg.ipvc.gabrielSousa.entidades.MainData;

public abstract class SingleLeveledMenu {
    /**
     * Constant static that stores the data to be used by other menus
     */
    private static MainData data;
    private static final Serialization serialization = new Serialization();
    private static final DataCheckers dataCheckers = new DataCheckers(data);
    private static DataFilters dataFilters = new DataFilters(data) ;

    public SingleLeveledMenu(MainData data) {
        SingleLeveledMenu.data = data;
    }

    public MainData getData() {
        return data;
    }

    public Serialization getSerialization(){
        return serialization;
    }

    public static DataCheckers getDataCheckers() {
        return dataCheckers;
    }

    public static DataFilters getDataFilters() {
        return dataFilters;
    }

}
