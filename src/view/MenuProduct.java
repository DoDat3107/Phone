package view;

import Module.Contacts;
import input.Input;
import manager.ContactsManager;
import saveData.ReadAndWriteContacts;

import java.util.List;

public class MenuProduct {
    private ContactsManager contactsManager = new ContactsManager();

    public void showMenu() {
        int choice;
        do {
            System.out.println("----- Menu Quản Lý Danh Bạ -----");
            System.out.println("1. Xem tất cả số điện thoại");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Vui lòng nhập lựa chọn: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    viewAllContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContactsByPhone();
                    break;
                case 6:
                    readFromFile();
                    break;
                case 7:
                    writeToFile();
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }

    private void viewAllContacts() {
        List<Contacts> contacts = contactsManager.getAll();
        int pageSize = 5;
        int totalPages = (int) Math.ceil((double) contacts.size() / pageSize);
        int currentPage = 0;

        while (currentPage < totalPages) {
            int start = currentPage * pageSize;
            int end = Math.min(start + pageSize, contacts.size());
            System.out.println("Danh sách số điện thoại (Trang " + (currentPage + 1) + " / " + totalPages + "):");
            for (int i = start; i < end; i++) {
                System.out.println(contacts.get(i));
            }
            currentPage++;
            if (currentPage < totalPages) {
                System.out.println("Nhấn Enter để xem trang tiếp theo hoặc nhập '0' để quay lại menu.");
                String input = Input.inputString();
                if ("0".equals(input)) {
                    break;
                }
            }
        }
    }

    private void addNewContact() {
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = Input.ValidatePhone();
        System.out.print("Nhập tên nhóm: ");
        String groundName = Input.inputString();
        System.out.print("Nhập tên người: ");
        String name = Input.inputString();
        System.out.print("Nhập giới tính: ");
        String gender = Input.inputString();
        System.out.print("Nhập địa chỉ: ");
        String address = Input.inputString();
        System.out.print("Nhập ngày lưu (DD/MM/YYYY): ");
        String date = Input.ValidateDate();
        System.out.print("Nhập email (ví dụ: Dat2@a-zA-Z.com): ");
        String email = Input.ValidateGmail();

        Contacts contact = new Contacts(phoneNumber, groundName, name, gender, address, date, email);
        contactsManager.add(contact);
        System.out.println("Danh bạ đã được thêm thành công.");
    }

    private void updateContact() {
        System.out.print("Nhập ID số điện thoại cần cập nhật: ");
        int idEdit = Input.inputNumber();
        System.out.print("Nhập số điện thoại mới: ");
        String phoneNumber = Input.ValidatePhone();
        System.out.print("Nhập tên nhóm mới: ");
        String groundName = Input.inputString();
        System.out.print("Nhập tên người mới: ");
        String name = Input.inputString();
        System.out.print("Nhập giới tính mới: ");
        String gender = Input.inputString();
        System.out.print("Nhập địa chỉ mới: ");
        String address = Input.inputString();
        System.out.print("Nhập ngày lưu mới (DD/MM/YYYY): ");
        String date = Input.ValidateDate();
        System.out.print("Nhập email mới (ví dụ: Dat2@a-zA-Z.com): ");
        String email = Input.inputString();

        Contacts contact = new Contacts(idEdit, phoneNumber, groundName, name, gender, address, date, email);
        contactsManager.update(idEdit, contact);
        System.out.println("Danh bạ đã được cập nhật thành công.");
    }

    private void deleteContact() {
        System.out.print("Nhập số điện thoại cần xóa: ");  // Assuming delete by phone number
        String phoneNumber = Input.inputString();
        int index = contactsManager.findIndexByPhone(phoneNumber);
        if (index != -1) {
            contactsManager.delete(phoneNumber);  // Update to match `ContactsManager` implementation
            System.out.println("Danh bạ đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy số điện thoại = " + phoneNumber);
        }
    }


    private void searchContactsByPhone() {
        System.out.println("======= Tìm bằng số điện thoại =======");
        System.out.print("Nhập số điện thoại cần tìm kiếm: ");
        String phoneNumber = Input.inputString();

        int index = contactsManager.findIndexByPhone(phoneNumber);
        if (index == -1) {
            System.out.println("Không tìm thấy số điện thoại = " + phoneNumber);
        } else {
            Contacts foundContact = contactsManager.getAll().get(index);

            System.out.println("Thông tin số điện thoại:");
            System.out.println("ID: " + foundContact.getId());
            System.out.println("Số điện thoại: " + foundContact.getPhoneNumber());
            System.out.println("Nhóm: " + foundContact.getGroundName());
            System.out.println("Tên: " + foundContact.getName());
            System.out.println("Giới tính: " + foundContact.getGender());
            System.out.println("Địa chỉ: " + foundContact.getAddress());
            System.out.println("Ngày sinh: " + foundContact.getDate());
            System.out.println("Gmail: " + foundContact.getGmail());
        }
    }

    public void readFromFile() {
        ReadAndWriteContacts readAndWrite = new ReadAndWriteContacts();
        System.out.println("Bạn có chắc chắn muốn tải dữ liệu từ file? (Y/N): ");
        String confirm = Input.inputString();
        if (confirm.equalsIgnoreCase("Y")) {
            List<Contacts> contacts = readAndWrite.readData();
            contactsManager.clearAllContacts();
            contactsManager.addAllContacts(contacts);
            System.out.println("Dữ liệu đã được tải từ file thành công.");
        } else {
            System.out.println("Hủy bỏ thao tác.");
        }
    }

    public void writeToFile() {
        ReadAndWriteContacts readAndWrite = new ReadAndWriteContacts();
        System.out.println("Bạn có chắc chắn muốn lưu dữ liệu vào file? (Y/N): ");
        String confirm = Input.inputString();
        if (confirm.equalsIgnoreCase("Y")) {
            List<Contacts> contacts = contactsManager.getAll();
            readAndWrite.writeData(contacts);
            System.out.println("Dữ liệu đã được lưu vào file thành công.");
        } else {
            System.out.println("Hủy bỏ thao tác.");
        }
    }
}
