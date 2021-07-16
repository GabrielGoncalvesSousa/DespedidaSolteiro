package estg.ipvc.gabrielSousa.menus;
import estg.ipvc.gabrielSousa.entidades.MainData;

import java.io.*;

public class Serialization  {

    public void saveData(MainData data) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            System.out.print("Dados guardados em data.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public MainData loadData(){
        try {
            FileInputStream fileIn = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MainData dataLoaded = (MainData) in.readObject();
            in.close();
            fileIn.close();
            return dataLoaded;
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        return null;
    }
}
