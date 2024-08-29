package saveData;

import Module.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteContacts {
    private File file = new File("Data/contacts.csv");
    public void writeData(List<Contacts> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder data = new StringBuilder();
            for (Contacts item : list) {
                data.append(item.getId()).append(",")
                        .append(item.getPhoneNumber()).append(",")
                        .append(item.getGroundName()).append(",")
                        .append(item.getName()).append(",")
                        .append(item.getGender()).append(",")
                        .append(item.getAddress()).append(",")
                        .append(item.getDate()).append(",")
                        .append(item.getGmail()).append("\n");
            }
            bufferedWriter.write(data.toString());
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    public List<Contacts> readData() {
        List<Contacts> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    Contacts c = new Contacts(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2], data[3], data[4],
                            data[5], data[6], data[7]
                    );
                    list.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
        return list;
    }
}
