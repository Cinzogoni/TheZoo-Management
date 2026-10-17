package view;

import controller.TheZooManager;
import java.time.LocalDate;
import java.util.Scanner;
import model.Animal;
import model.FlySwimAnimals;
import model.FlyingAnimals;
import model.SwimmingAnimals;
import model.TriathlonAnimals;
import model.WalkFlyAnimals;
import model.WalkSwimAnimals;
import model.WalkingAnimals;
import utils.Utils;

public class TheZooIOHandler {

    private TheZooManager theZooManager;
    private Scanner scan;

    public TheZooIOHandler() {
    }

    public TheZooIOHandler(TheZooManager theZooManager, Scanner scan) {
        this.theZooManager = theZooManager;
        this.scan = scan;
    }

    public Animal createAnimalByType(String id) {
        System.out.println("1. Dong vat tren can");
        System.out.println("2. Dong vat tren khong");
        System.out.println("3. Dong vat duoi nuoc");
        System.out.println("4. Dong vat tren can va tren khong");
        System.out.println("5. Dong vat tren can va duoi nuoc");
        System.out.println("6. Dong vat tren khong va duoi nuoc");
        System.out.println("7. Dong vat tren can, tren khong va duoi nuoc");
        System.out.print("Chon kieu dong vat muon tao (1-7): ");

        String choice = scan.nextLine();

        String name = Utils.checkInputString("Nhap ten: ", scan, "modaA", null);
        LocalDate receivedDate = Utils.checkInputDate("Nhap ngay tiep nhan: ", scan, "modaAa", null);
        String healthStatus = Utils.checkInputString("Tinh trang suc khoe: ", scan, "modaA", null);

        switch (choice) {
            case "1":
                return new WalkingAnimals(id, name, receivedDate, healthStatus);
            case "2":
                return new FlyingAnimals(id, name, receivedDate, healthStatus);
            case "3":
                return new SwimmingAnimals(id, name, receivedDate, healthStatus);
            case "4":
                return new WalkFlyAnimals(id, name, receivedDate, healthStatus);
            case "5":
                return new WalkSwimAnimals(id, name, receivedDate, healthStatus);
            case "6":
                return new FlySwimAnimals(id, name, receivedDate, healthStatus);
            case "7":
                return new TriathlonAnimals(id, name, receivedDate, healthStatus);
            default:
                System.out.println("Mac dinh - Dong vat tren can!");
                return new WalkingAnimals(id, name, receivedDate, healthStatus);
        }
    }

    public void handleAddAnimal() {
        System.out.println("-------- THEM THONG TIN DONG VAT --------");

        try {
            String id;
            while (true) {
                id = Utils.checkInputString("Nhap id: ", scan, "modeA", null);

                if (theZooManager.findById(id) == null) {
                    break;
                }
                System.out.println("Id da ton tai!");
            }

            Animal animal = createAnimalByType(id);

            boolean success = theZooManager.addAnimal(animal);
            if (success) {
                System.out.println("Da them thanh cong!");
            } else {
                System.out.println("Da them that bai!");
            }

        } catch (Exception e) {
            System.out.println("LOI: " + e.getMessage());
        }
    }

    public void handleRemoveAnimal() {
        System.out.println("-------- XOA DONG VAT --------");

        try {
            Animal animal;
            while (true) {
                String id = Utils.checkInputString("Nhap id (Enter bo qua): ", scan, "modeB", null);

                if (id == null) {
                    return;
                }

                animal = theZooManager.findById(id);
                if (animal != null) {
                    break;
                }
                System.out.println("Khong tim thay id nay");
            }

            System.out.print("Co muon xoa dong vat nay (Y/N): ");
            String confirm = scan.nextLine().trim();
            if (confirm.equalsIgnoreCase("Y")) {
                if (theZooManager.removeAnimal(animal.getId())) {
                    System.out.println("Xoa thanh cong!!");
                } else {
                    System.out.println("Xoa that bai!");
                }
            } else {
                System.out.println("Da huy xoa!");
            }

        } catch (Exception e) {
            System.out.println("LOI: " + e.getMessage());
        }
    }

    public void handleUpdateAnimal() {
        System.out.println("-------- CAP NHAT THONG TIN DONG VAT --------");

        try {
            Animal oldAnimal;
            String id;
            while (true) {
                id = Utils.checkInputString("Nhap id (Enter bo qua): ", scan, "modeB", null);

                if (id == null) {
                    return;
                }

                oldAnimal = theZooManager.findById(id);
                if (oldAnimal != null) {
                    break;
                }
                System.out.println("Khong tim thay id nay");

                String retry;
                while (true) {
                    System.out.print("Co muon nhap lai (Y/N): ");
                    retry = scan.nextLine().trim();

                    if (retry.equalsIgnoreCase("Y") || retry.equalsIgnoreCase("Y")) {
                        break;
                    }
                    System.out.println("Bui long nhap lai Y hoac N");
                }

                if (retry.equalsIgnoreCase("N")) {
                    System.out.print("Da huy cap nhat!");
                    return;
                }
            }

            String newName = Utils.checkInputString("Nhap ten moi (Enter bo qua): ",
                    scan, "modeB", oldAnimal.getName());

            LocalDate newReceivedDate = Utils.checkInputDate("Nhap ngay tiep nhan moi (Enter bo qua): ",
                    scan, "modeB", oldAnimal.getReceivedDate());

            String newHealthStatus = Utils.checkInputString("Nhap tinh trang suc khoe moi (Enter bo qua): ",
                    scan, "modeB", oldAnimal.getHealthStatus());

            oldAnimal.setName(newName);
            oldAnimal.setReceivedDate(newReceivedDate);
            oldAnimal.setHealthStatus(newHealthStatus);

            if (theZooManager.updateAnimal(oldAnimal.getId(), oldAnimal)) {
                System.out.println("Cap nhat thanh cong!");
            } else {
                System.out.println("Cap nhat that bai!");
            }
        } catch (Exception e) {
            System.out.println("LOI: " + e.getMessage());
        }
    }

    public void handleSearchAnimalByName() {
        System.out.println("-------- TIM KIEM DONG VAT THEO TEN --------");

        try {
            if (theZooManager.isListEmpty()) {
                System.out.println("Danh sach rong");
            }

            String keyword = Utils.checkInputString("Nhap ten (hoac 1 phan ten): ", scan, "modeA", null);
            var resultList = theZooManager.searchAnimalByName(keyword);

            if (resultList.isEmpty()) {
                System.out.println("Khong tim thay dong vat chua " + keyword);
            } else {
                System.out.println("----- KET QUA TIM KIEM -----");
                for (Animal a : resultList) {
                    System.out.println(a);
                }
            }
        } catch (Exception e) {
            System.out.println("LOI: " + e.getMessage());
        }
    }
}
