import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOOperator {
    public static void writeToFile(String path, List<Phone> contacts) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            String title = "Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email";
            bw.write(title);
            for (Phone phone : contacts) {
                bw.newLine();
                bw.write(phone.display());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Phone> readDataFromFile(String path) {
        ArrayList<Phone> phones = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String str = br.readLine();
            while ((str = br.readLine()) != null) {
                String[] strings = str.split(",");
                phones.add(new Phone(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]));
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return phones;
    }
}
