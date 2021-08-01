/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estg.ipvc.gabrielSousa.menus.base;
import java.util.Arrays;
import java.util.Stack;

public abstract class MultiLeveledMenu extends MenuData implements Menu {
    /**
     * Constant static definitions for the Options Menu classe
     */
    private static final String MENU_FORMAT = "%2d - %s";
    private static final String LABEL_SELECT_OPTION = "Please select an option: ";
    private static final String LABEL_BAD_INPUT = "[error] The provided input is not a valid option";


    public MultiLeveledMenu() {

    }
    /**
     * An helper function to read an option from the command line
     */
    int readOption() {
        return Integer.parseUnsignedInt(getScanner().nextLine());
    }

    /**
     * The last selected submenu
     */
    private Menu lastSelectedSubMenu;

    /**
     * The options for this menu
     **/
    private Menu[] menus;

    /**
     * Constructor takes the array of options for this menu@param options
     */
    public MultiLeveledMenu(Menu[] options) {
        if (options == null || options.length == 0) {
            throw new IllegalArgumentException("Empty or null options is not supported");
        }
        this.menus = options;
    }


    /**
     * Prints the title of the Menu
     */
    private void printTitle() {
        String name = this.getName();
        System.out.println();
        System.out.println(String.format("*****%s*****", name.replaceAll(".", "*")));
        System.out.println(String.format("*    %s    *", name));
        System.out.println(String.format("*****%s*****", name.replaceAll(".", "*")));
    }

    @Override
    public void action() {
        Menu[] selectedOptions = Arrays
                .stream(this.menus)
                .toArray(Menu[]::new);

        while (true) {
            // Print the options
            this.printTitle();

            for (int i = 0; i < selectedOptions.length; ++i) {
                System.out.println(String.format(MENU_FORMAT, i + 1, selectedOptions[i].getName()));
            }
            System.out.println(String.format(MENU_FORMAT, 0, "Sair"));

            // Try to read an option from the console
            try {
                System.out.print(LABEL_SELECT_OPTION);
                int selection = readOption();
                System.out.println();

                if (selection == 0) {
                    this.lastSelectedSubMenu = null;
                    return;
                } else if (selection <= selectedOptions.length) {
                    this.lastSelectedSubMenu = selectedOptions[selection - 1];
                    return;
                }

            } catch (Exception exception) {
            }

            System.out.println(LABEL_BAD_INPUT);
        }
    }

    private Stack<Menu> menusStack = new Stack<>();

    public String getName() {
        return null;
    }

    public void stackManipulation() {
        while (!menusStack.empty()) {
            Menu currentMenu = menusStack.peek();
            currentMenu.action();
            if (currentMenu instanceof MultiLeveledMenu) {
                Menu nextMenu = ((MultiLeveledMenu) currentMenu).lastSelectedSubMenu;
                if (nextMenu == null) {
                    menusStack.pop();
                } else {
                    menusStack.push(nextMenu);
                }
            } else {
                menusStack.pop();
            }
        }
    }

    public final void addMenu(Menu menu) {
        menusStack.push(menu);
        stackManipulation();
    }

    public final void run() {
        menusStack.push(this);
        stackManipulation();
    }
}
