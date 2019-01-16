package user;

public class User {

    private final int id;
    private String userName;
    private String firstName;
    private String lastName;

    public User(int id, String userName, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the screen name of the user.
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the first name of the user.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the user.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the id/number of the user.
     * @return the id
     */
    public int getId() {
        return id;
    }
}
