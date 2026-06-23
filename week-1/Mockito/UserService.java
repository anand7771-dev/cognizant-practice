package mockito;

// UserService - business logic layer
// Depends on UserRepository to get data
// User and UserRepository are now in separate files

public class UserService {

    UserRepository repo;

    UserService(UserRepository repo) {
        this.repo = repo;
    }

    User getUserDetails(int id) {
        return repo.getUser(id);
    }

    void saveUser(User user) {
        repo.saveUser(user);
    }
}
