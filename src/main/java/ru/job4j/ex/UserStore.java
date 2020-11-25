package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User names = users[0];
        if (!login.equals(names.getUsername())) {
            throw new UserNotFoundException("Not found");
        }
        return names;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid");
        }
        if (!user.isValid()) {
            throw new UserInvalidException("False");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ruslan", true)
        };
        try {
        User user = findUser(users, "Ruslan");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
        } catch (UserNotFoundException | UserInvalidException e) {
            e.printStackTrace();
        }
    }
}