package estg.ipvc.gabrielSousa;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Serialization;
import estg.ipvc.gabrielSousa.menus.login_preRegisto.MultiMenu_MainMenu;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MultiMenu_MainMenu multiMenuMainMenu = new MultiMenu_MainMenu();
        multiMenuMainMenu.run();


    }
}