import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Contact {
    private List<Phone> danhBa = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    private final int nameSearch = 1;
    private final int phoneSearch = 2;

    public void show(){
        for(Phone p : danhBa){
            System.out.println(p);
            System.out.println("Nhập bất kì để xem tiếp");
            String answer = input.nextLine();
        }
    }
    public void addNew() {
        Phone temp = createContact();
        danhBa.add(temp);
        System.out.println("Đã thêm một liên lạc mới vào danh bạ");
    }

    private Phone createContact() {
        String phone = getPhone("Nhập số điện thoại");
        String group = getGroup();
        String name = getName();
        String gender = getGender();
        String address = getAddress();
        String dateOfBirth = getDateOfBirth();
        String email = getEmail();
        return new Phone(phone, group, name, gender, address, dateOfBirth, email);
    }

    private String getPhone(String s) {
        while (true) {
            System.out.println(s);
            String phone = input.nextLine();
            boolean exist = false;
            if (phone.matches("^\\d{2}-[0]\\d{9}$")) {
                for (Phone p : danhBa) {
                    if (p.getPhoneNumber().equals(phone)) {
                        System.out.println("Số điện thoại đã tồn tại");
                        exist = true;
                    }
                }
                if (!exist) {
                    return phone;
                }
            } else {
                System.out.println("Nhập sai định dạng số điện thoại");
            }
        }
    }

    private String getEmail() {
        while (true) {
            System.out.println("Nhập email");
            String email = input.nextLine();
            boolean exist = false;
            if (email.matches("^[\\S.]+@[\\S.]+$")) {
                for (Phone p : danhBa) {
                    if (p.getEmail().equals(email)) {
                        System.out.println("Email đã tồn tại");
                        exist = true;
                    }
                }
                if (!exist) {
                    return email;
                }
            } else {
                System.out.println("Nhập sai định dạng email");
            }
        }
    }

    private String getDateOfBirth() {
        while (true){
            System.out.println("Nhập ngày sinh");
            String dateOfBirth = input.nextLine();
            if(dateOfBirth.matches("^\\S+$")){
                return dateOfBirth;
            } else {
                System.out.println("Phải nhập ít nhất 1 ký tự");
            }
        }
    }

    private String getAddress() {
        while (true){
            System.out.println("Nhập địa chỉ");
            String address = input.nextLine();
            if(address.matches("^[\\S\\s]+$")){
                return address;
            } else {
                System.out.println("Phải nhập ít nhất 1 ký tự");
            }
        }
    }

    private String getGender() {
        while (true){
            System.out.println("Nhập giới tính");
            String gender = input.nextLine();
            if(gender.matches("^[Nn][Aa][Mm]+|[Nn][Uu]$")){
                return gender;
            } else {
                System.out.println("Giới tính phải là nam hoặc nữ");
            }
        }
    }

    private String getName() {
        while(true){
            System.out.println("Nhập tên");
            String name = input.nextLine();
            if(name.matches("^[\\S\\s]+")){
                return name;
            } else {
                System.out.println("Phải nhập ít nhất một kí tự");
            }
        }
    }

    private String getGroup() {
        while(true){
            System.out.println("Nhập nhóm");
            String group = input.nextLine();
            if(group.matches("^[\\S\\s]+")){
                return group;
            } else {
                System.out.println("Phải nhập ít nhất một kí tự");
            }
        }
    }

    public void edit() {
        int index = -1;
        while (true) {
            System.out.println("Nhập số điện thoại cần sửa");
            String phone = input.nextLine();
            if (phone.equals("")) {
                return;
            }
            for (int i = 0; i < danhBa.size(); i++) {
                if (danhBa.get(i).getPhoneNumber().equals(phone)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("Không tìm thấy số điện thoại trên");
            } else {
                break;
            }
        }
        danhBa.get(index).setGroup(getGroup());
        danhBa.get(index).setName(getName());
        danhBa.get(index).setGender(getGender());
        danhBa.get(index).setAddress(getAddress());
        danhBa.get(index).setDateOfBirth(getDateOfBirth());
        danhBa.get(index).setEmail(getEmail());
    }

    public void deleteContact() {
        while (true) {
            System.out.println("Nhập số điện thoại cần xóa");
            String phone = input.nextLine();
            if (phone.equals("")) {
                return;
            }
            for (Phone p : danhBa) {
                if (p.getPhoneNumber().equals(phone)) {
                    System.out.println("Bạn có chắc chắn là muốn xóa không");
                    System.out.println("Nhập Y để đồng ý");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("Y")) {
                        danhBa.remove(p);
                    }
                    return;
                }
            }
            System.out.println("Không tìm thấy số điện thoại");
        }
    }

    public void searchContact() {
        System.out.println("Bạn muốn tìm kiếm theo");
        System.out.println("1. Tên");
        System.out.println("2. Số điện thoại");
        int answer = Integer.parseInt(input.nextLine());
        switch (answer) {
            case nameSearch -> {
                System.out.println("Nhập tên");
                String name = input.nextLine();
                boolean found = false;
                for (Phone phone : danhBa) {
                    if (phone.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                        System.out.println(phone);
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Không tìm thấy");
                }
            }
            case phoneSearch -> {
                System.out.println("Nhập số điện thoại");
                String phone = input.nextLine();
                boolean found = false;
                for (Phone p : danhBa) {
                    if (p.getPhoneNumber().contains(phone)) {
                        System.out.println(p);
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Không tìm thấy");
                }
            }
        }
    }

    public void saveContact() {
        IOOperator.writeToFile("src/Contact.csv", danhBa);
    }

    public void readContact() {
        danhBa = IOOperator.readDataFromFile("E:\\Module2-CodeExam\\src\\Contact.csv");
    }
}


