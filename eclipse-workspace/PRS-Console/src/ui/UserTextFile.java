package ui;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import business.User;



public final class UserTextFile implements DAO<User> {
    private List<User> users = null;
    private Path usersPath = null;
    private File usersFile = null;
    private final String FIELD_SEP = "\t";

    public UserTextFile() {
        usersPath = Paths.get("users.txt");
        usersFile = usersPath.toFile();
        users = this.getAll();
    }

    @Override
    public List<User> getAll() {
        // if the users file has already been read, don't read it again
        if (users != null) {
            return users;
        }

        users = new ArrayList<>();
        if (Files.exists(usersPath)) {
            try (BufferedReader in = new BufferedReader(
                                     new FileReader(usersFile))) {

                // read users from file into array list
                String line = in.readLine();
                while (line != null) {
                    String[] fields = line.split(FIELD_SEP);
                    String id = fields[0];
                    String userName = fields[1];
                    String password = fields[2];
                    String firstName = fields[3];
                    String lastName = fields[4];
                    String phoneNumber = fields[5];
                    String email = fields[6];
                    String isReviewer = fields[7];
                    String isAdmin = fields[8];

                    User u = new User(Integer.parseInt(id), userName, password, firstName, lastName,
                    		phoneNumber, email, Boolean.parseBoolean(isReviewer), Boolean.parseBoolean(isAdmin));
                    users.add(u);

                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        } else {
            System.out.println(
                    usersPath.toAbsolutePath() + " doesn't exist.");
            return null;            
        }
        return users;
    }

    
    public User get(int id) {
        for (User u : users) {
            if (u.getId()==(id)) {
                return u;
            }
        }
        return null;
    }

    private boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(usersFile)))) {

            // write all users in the array list
            // to the file
            for (User u : users) {
                out.print(u.getId() + FIELD_SEP);
                out.print(u.getUserName() + FIELD_SEP);
                out.print(u.getPassword() + FIELD_SEP);
                out.print(u.getFirstName() + FIELD_SEP);
                out.print(u.getLastName() + FIELD_SEP);
                out.print(u.getPhoneNumber() + FIELD_SEP);
                out.print(u.getEmail() + FIELD_SEP);
                out.print(u.getIsReviewer() + FIELD_SEP);
                out.print(u.getIsAdmin() + FIELD_SEP);
                out.println();
            }
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }
    
    @Override
    public boolean add(User u) {
        users.add(u);
        return this.saveAll();
    }

    @Override
    public boolean delete(User u) {
        users.remove(u);
        return this.saveAll();
    }

    @Override
    public boolean update(User newUser) {
        // get the old user and remove it
        User oldUser = this.get(newUser.getId());
        int i = users.indexOf(oldUser);
        users.remove(i);

        // add the updated user
        users.add(i, newUser);

        return this.saveAll();
    }

}	