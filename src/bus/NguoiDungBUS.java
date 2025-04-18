package bus;

import model.NguoiDungDTO;
import java.util.ArrayList;

public class NguoiDungBUS {
    private final ArrayList<NguoiDungDTO> users;

    public NguoiDungBUS() {
        users = new ArrayList<>();
    }

    public ArrayList<NguoiDungDTO> getAllNguoiDung() {
        return users;
    }

    public NguoiDungDTO getNguoiDungById(int id) {
        for (NguoiDungDTO x : users) {
            if (x.getID() == id) { 
                return x;
            }
        }
        return null;
    }

    public void addNguoiDung(NguoiDungDTO x) {
        users.add(x);
    }

    public void updateNguoiDung(NguoiDungDTO x) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == x.getID()) {
                users.set(i, x);
                return;
            }
        }
    }

    // Sửa tham số `id` từ String sang int để khớp với DTO
    public void deleteNguoiDung(int id) {
        users.removeIf(user -> user.getID() == id); // So sánh int
    }
}