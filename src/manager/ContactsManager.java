package manager;

import Module.Contacts;
import saveData.ReadAndWriteContacts;

import java.util.ArrayList;
import java.util.List;

public class ContactsManager implements IManager<Contacts> {
    private List<Contacts> list;
    private ReadAndWriteContacts readAndWriteContacts = new ReadAndWriteContacts();

    public ContactsManager() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(Contacts contact) {
        this.list.add(contact);
    }

    @Override
    public void update(int id, Contacts contact) {
        int index = findIndexById(id);
        if (index != -1) {
            this.list.set(index, contact);
        } else {
            System.out.println("Danh bạ không tìm thấy với ID: " + id);
        }
    }

    @Override
    public void delete(String phone) {
        int index = findIndexByPhone(phone);
        if (index != -1) {
            this.list.remove(index);
        } else {
            System.out.println("Không tìm thấy số điện thoại : " + phone);
        }
    }

    @Override
    public List<Contacts> getAll() {
        return new ArrayList<>(this.list);
    }

    @Override
    public int findIndexByPhone(String phone) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phone)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void clearAllContacts() {
        this.list.clear();
    }

    public void addAllContacts(List<Contacts> contacts) {
        this.list.addAll(contacts);
    }
}
