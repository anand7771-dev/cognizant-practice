package mockito;

public interface UserRepository {

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);
}