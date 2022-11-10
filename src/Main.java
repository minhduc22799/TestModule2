import _IOFIle.ReadWriteFIle;
import _Manager.StudentManager;

import java.util.Scanner;

public class Main {
    public static StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice = -1;
            Scanner input = new Scanner(System.in);
            while (choice != 0) {
                System.out.println("--------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--------");
                System.out.println("Chọn chức năng theo số để tiếp tục");
                System.out.println("1.Xem danh sách sinh viên");
                System.out.println("2.Thêm mới");
                System.out.println("3.Cập nhật");
                System.out.println("4.Xóa");
                System.out.println("5.Sắp xếp");
                System.out.println("6.Ghi vào file");
                System.out.println("7.Đọc từ File");
                System.out.println("0. Thoát");
                System.out.println("Chọn chức năng ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        studentManager.display();
                        break;
                    case 2:
                        studentManager.addStudent(scanner);
                        break;
                    case 3:
                        studentManager.updateStudent(scanner);
                        break;
                    case 4:
                        studentManager.deleteStudent(scanner);
                        break;
                    case 5:
                        menuSort(scanner);
                        break;
                    case 6:
                        ReadWriteFIle.write(studentManager.students);
                        break;
                    case 7 :
                        ReadWriteFIle.read();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("No choice!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuSort(Scanner scanner) {
        int choice2;
        do {
            try {
                System.out.println("--------Sap xep sinh vien theo diem trung binh--------");
                System.out.println("Chọn chức năng theo số để tiếp tục");
                System.out.printf( "1.Sap xep diem tang dan");
                System.out.printf( "\n2.Sap xep diem giam dan");
                System.out.printf( "\n3.Thoat.");
                System.out.println("\nNhap lua chon:");
                choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2 == 0) {
                    break;
                } else if (choice2 >= 4 || choice2 < 0 ) {
                    System.err.println("Over selection!");
                }
                switch (choice2) {
                    case 1:
                        studentManager.sortAscStudent();
                        break;
                    case 2:
                        studentManager.sortDecStudent();
                        break;
                }
            } catch (Exception e) {
                System.err.println("Nhap lai lua chon");
            }
        } while (true) ;
    }


}