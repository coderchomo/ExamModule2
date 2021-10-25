package menu;

import control.PhoneBookManager;
import model.PhoneBook;
import storage.PhoneBookFile;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    PhoneBookManager phonebookManager = PhoneBookManager.getInstance();
    PhoneBookFile phoneBookFile = PhoneBookFile.getInstance();

    private Menu() {
    }

    public static Menu getInstance() {
        return Menu.MenuPhoneBookManagerHelper.INSTANCE;
    }

    private static class MenuPhoneBookManagerHelper {
        private static final Menu INSTANCE = new Menu();
    }
    public void runMenu(){
        Scanner number = new Scanner(System.in);
        int choice = -1;

        while (choice != 0){
            System.out.println("PhoneBook Manager Program");
            System.out.println("Choose number to enter system");
            System.out.println("1. Show PhoneBook");
            System.out.println("2. Add new PhoneNumber");
            System.out.println("3. Edit ");
            System.out.println("4. Remove ");
            System.out.println("5. Search ");
            System.out.println("6. Read file");
            System.out.println("7. Write file");
            System.out.println("8. Exit");
            System.out.print("Please choose number to enter system : ");

            choice = number.nextInt();
            switch (choice){
                case 1:
                    phonebookManager.showAllPhoneBook();
                    break;
                case 2:
                    phonebookManager.addPhoneBook(inputPhoneBook());
                    break;
                case 3:
                    phonebookManager.editPhoneBook(inputId());
                    break;
                case 4:
                    phonebookManager.removePhoneBook(inputId());
                    break;
                case 5:
                    searchById();
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    writeFile();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Not valid Please choose again ");
            }
        }
    }

    private void writeFile() {
        try {
            phoneBookFile.writeFile(phonebookManager.getLibraryCardArrayList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        try {
            phonebookManager.setLibraryCardArrayList(phoneBookFile.readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void searchById() {
        PhoneBook phonebook = phonebookManager.searchPhoneNumberById(inputId());
        if(phonebook != null){
            System.out.println(phonebook);
        }else {
            System.out.println("Phone Number Not Found");
        }
    }

    private static PhoneBook inputPhoneBook() {
        Scanner scanner = new Scanner(System.in);
        String id, group, name, gender, address, yearOfBirth, email, numberPhone;
        System.out.println("Enter PhoneBook Information");
        System.out.print("Enter Id : ");
        id = scanner.nextLine();
        System.out.print("Enter Group : ");
        group = scanner.nextLine();
        System.out.print("Enter name : ");
        name = scanner.nextLine();
        System.out.print("Enter gender : ");
        gender = scanner.nextLine();
        System.out.print("Enter address : ");
        address = scanner.nextLine();
        System.out.print("Enter DoB : ");
        yearOfBirth = scanner.nextLine();
        System.out.print("Enter email : ");
        email = scanner.nextLine();
        System.out.print("Enter phone number : ");
        numberPhone = scanner.nextLine();

        return new PhoneBook(id,group,name,gender,address,yearOfBirth,email,numberPhone);
    }

    private String inputId() {
        System.out.print("Enter ID: ");
        Scanner string = new Scanner(System.in);
        return string.nextLine();
    }
}
