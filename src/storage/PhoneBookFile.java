package storage;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;

public class PhoneBookFile {
    private static PhoneBookFile phoneBookFile;

    private PhoneBookFile() {
    }
    //Singleton
    public static PhoneBookFile getInstance(){
        if(phoneBookFile == null){
            phoneBookFile = new PhoneBookFile();
        }
        return phoneBookFile;
    }

    public ArrayList<PhoneBook> readFile() throws IOException, ClassNotFoundException {
        File file = new File("phoneBookList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<PhoneBook> list = (ArrayList<PhoneBook>)object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(ArrayList<PhoneBook> students) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("phoneBookList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
