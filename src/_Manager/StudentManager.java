package _Manager;

import _Model.Student;

import java.util.*;


public class StudentManager {
   public  ArrayList<Student> students = new ArrayList<>();


    public StudentManager() {
        Student student1 = new Student("Sv1", "Nguyen Van A", 21, "Nam", "Ha Noi", 7.0);
        Student student2 = new Student("Sv2", "Tran Thi B", 20, "Nu", "Ha Noi", 9.0);
        Student student3 = new Student("Sv3", "Hoang Van C", 22, "Nam", "HCM", 8.0);
        Student student4 = new Student("Sv4", "Le Thi D", 23, "Nam", "HCM", 5.2);
        Student student5 = new Student("Sv5", "Bui Van E", 22, "Nam", "Ha Noi", 6.4);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    public void display() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    private boolean check(String id){
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    public void addStudent(Scanner scanner) {
        try {
            System.out.println("Nhap id sinh vien");
            String id = scanner.nextLine();
            if (check(id)){
                System.out.println("Id da ton tai");
            }else {
                System.out.println("Nhap ten sinh vien");
                String name = scanner.nextLine();
                System.out.println("Nhap tuoi sinh vien");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap gioi tinh");
                String gender = scanner.nextLine();
                System.out.println("Nhap dia chi sinh vien");
                String address = scanner.nextLine();
                System.out.println("Nhap diem trung binh sinh vien");
                double avg = Double.parseDouble(scanner.nextLine());

                Student student = new Student(id, name, age, gender, address, avg);
                students.add(student);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent(Scanner scanner) {
        try {
            System.out.println("Nhap id sinh vien muon sua: ");
            String id = scanner.nextLine();
            Student studentUpdate;

                if ((studentUpdate = checkExist(id)) != null) {
                    System.out.println("Nhap ten moi ");
                    String name = scanner.nextLine();
                    if (!name.equals("")) {
                        studentUpdate.setName(name);
                    }
                    System.out.println("Nhap tuoi moi: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    if (String.valueOf(age).equals("")) {
                        studentUpdate.setAge(age);
                    }
                    System.out.println("Nhap goi tinh moi: ");
                    String gender = scanner.nextLine();
                    if (!gender.equals("")) {
                        studentUpdate.setGender(gender);
                    }
                    System.out.println("Nhap dia chi moi: ");
                    String address = scanner.nextLine();
                    if (!address.equals("")) {
                        studentUpdate.setAddress(address);
                    }
                    System.out.println("Nhap diem trung binh moi: ");
                    double avg = Double.parseDouble(scanner.nextLine());
                    if (!address.equals("")) {
                        studentUpdate.setAvg(avg);
                    }

                } else {
                    System.err.println("Not exist product have id!");
                }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
        display();
    }

    public void deleteStudent(Scanner scanner) {
        try {
            System.out.println("Nhap id sinh vien muon xoa:  ");
            String id = scanner.nextLine();
            Student studentDelete;
            if ((studentDelete = checkExist(id)) != null) {
                System.out.println("Ban co chac muon xoa snh vien nay khong? Yes/ No ");
                String check = scanner.nextLine();
                if (check.equalsIgnoreCase("yes")){
                    students.remove(studentDelete);
                }
            } else {
                System.err.println("Khong ton tai sinh vien da nhap!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
        display();
    }

    private Student checkExist(String id) {
        for (Student p : students) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }


    public void sortAscStudent(){
        students.sort((o1, o2) -> (int) Math.round(o1.getAvg() - o2.getAvg()));
        display();
    }

    public void sortDecStudent(){
        students.sort((o1, o2) -> (int) Math.round(o2.getAvg() - o1.getAvg()));
        display();
    }


}
