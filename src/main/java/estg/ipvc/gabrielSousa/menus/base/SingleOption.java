package menus.base;

import entidades.MainData;

public abstract class SingleOption {
    /** Constant static that stores the data to be used by other menus */
    private static MainData data;

    public SingleOption(MainData data){
        SingleOption.data =data;
    }

    /** Getters and setters from data */
    public void setData(MainData data) {
        SingleOption.data = data;
    }

    public MainData getData() {
        return data;
    }
}
