package control;

import model.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookManager {
    ArrayList<PhoneBook> phoneBookArrayList = new ArrayList<>();


    private PhoneBookManager() {
    }

    public static PhoneBookManager getInstance() {
        return PhoneBookManager.PhonebookManagerHelper.INSTANCE;
    }

    private static class PhonebookManagerHelper{
        private static final PhoneBookManager INSTANCE = new PhoneBookManager();
    }

    public PhoneBookManager(ArrayList<PhoneBook> libraryCardArrayList) {
        this.phoneBookArrayList = libraryCardArrayList;
    }

    public ArrayList<PhoneBook> getLibraryCardArrayList() {
        return phoneBookArrayList;
    }

    public void setLibraryCardArrayList(ArrayList<PhoneBook> libraryCardArrayList) {
        this.phoneBookArrayList = libraryCardArrayList;
    }

    public void addPhoneBook(PhoneBook phonebook){
        phoneBookArrayList.add(phonebook);
    }

    public void editPhoneBook(String id){
        PhoneBook phonebook = searchPhoneNumberById(id);
        if(phonebook != null){
            inputPhoneBook(phonebook);
        } else {
            System.out.println("Phone Number not found");
        }
    }

    public void removePhoneBook(String id) {
        PhoneBook phonebook = searchPhoneNumberById(id);
        if (phonebook != null) {
            for (int i = 0; i < phoneBookArrayList.size(); i++) {
                if (phoneBookArrayList.get(i).equals(phonebook)) {
                    phoneBookArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Phone Number not found");
        }
    }

    public void showAllPhoneBook(){
        for (PhoneBook phonebook: phoneBookArrayList) {
            System.out.println(phonebook);
        }
    }

    private void inputPhoneBook(PhoneBook phonebook) {
        Scanner scanner = new Scanner(System.in);
        String group, name, gender, address, yearOfBirth, email, numberPhone;
        System.out.println("NHẬP LẠI THÔNG TIN DANH BẠ");
        System.out.print("Enter Group: ");
        group = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter gender: ");
        gender = scanner.nextLine();
        System.out.print("Enter address: ");
        address = scanner.nextLine();
        System.out.print("Enter DoB: ");
        yearOfBirth = scanner.nextLine();
        System.out.print("Enter email: ");
        email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        numberPhone = scanner.nextLine();
        phonebook.setGroup(group);
        phonebook.setName(name);
        phonebook.setGender(gender);
        phonebook.setAddress(address);
        phonebook.setYearOfBirth(yearOfBirth);
        phonebook.setEmail(email);
        phonebook.setNumberPhone(numberPhone);
    }


    public PhoneBook searchPhoneNumberById(String code){
        PhoneBook phonebook = null;
        for (PhoneBook value : phoneBookArrayList) {
            if (value.getId().equalsIgnoreCase(code)) {
                phonebook = value;
                break;
            }
        }
        return phonebook;
    }


}
