package view;

import controller.TheZooManager;
import java.util.Scanner;
import model.Animal;

public class MenuView {

    private static void displayAnimals(TheZooManager theZooManager) {
        if (theZooManager.isListEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("===== DANH SACH THONG TIN DONG VAT =====");
        for (Animal a : theZooManager.getAnimalList()) {
            System.out.println(a);
        }
    }

    public static void printMenu() {
        System.out.println("===== QUAN LY SO THU =====");
        System.out.println("1.Them thong tin dong vat");
        System.out.println("2.Xoa thong tin dong vat");
        System.out.println("3.Sua thong tin dong vat");
        System.out.println("4.Tim kiem theo ten dong vat");
        System.out.println("5.Hien thi danh sach dong vat");
        System.out.println("0.Thoat chuong trinh");
        System.out.print("Nhap lua chon: ");
    }

    public static void runView() {
        Scanner scan = new Scanner(System.in);
        TheZooManager theZooManager = new TheZooManager();
        TheZooIOHandler zooIOHandler = new TheZooIOHandler(theZooManager, scan);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scan.nextLine().trim();

            switch (choice) {
                case "1":
                    zooIOHandler.handleAddAnimal();
                    break;
                case "2":
                    zooIOHandler.handleRemoveAnimal();
                    break;
                case "3":
                    zooIOHandler.handleUpdateAnimal();
                    break;
                case "4":
                    zooIOHandler.handleSearchAnimalByName();
                    break;
                case "5":
                    displayAnimals(theZooManager);
                    break;
                case "0":
                    running = false;
                    System.out.print("TAM BIET!");
                    break;
                default:
                    System.out.print("Lua chon chua hop le. Nhap lai!");

            }
        }
    }
}
