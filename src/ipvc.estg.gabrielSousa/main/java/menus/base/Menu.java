
package menus.base;
import menus.Serialization;

public interface Menu {
    void action();

    /**
     * @return Obtains a String with the name of the Menu
     */
    String getName();

}
