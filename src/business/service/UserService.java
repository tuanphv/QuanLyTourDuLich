/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;
/**
 *
 * @author pc
 */
import business.model.User;
import java.util.ArrayList;

public class UserService {
    private ArrayList<User> users;
    
    public UserService() {
        users = new ArrayList<>();
    }
    
    public ArrayList<User> getAllUsers() {
        return users;
    }
    
    public User getUserById(String id) {
        for (User x:users)
            if (x.getId().equals(id))
                return x;
        return null;
    }
    
    public void addUser(User x){
        users.add(x);
    }
    
    public void updateUser(User x) {
        for (int i=0; i<users.size(); i++)
            if (users.get(i).getId().equals(x.getId())){
                users.set(i, x);
                return;
            }
    }
    
    public void deleteUser(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
