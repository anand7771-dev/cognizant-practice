package mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository repo;

    @InjectMocks
    UserService service;

    @Test
    void testGetUser() {

        User user = new User(1, "Anand");

        when(repo.getUser(1)).thenReturn(user);

        User result = service.getUserDetails(1);

        assertEquals("Anand", result.name);

        verify(repo).getUser(1);
    }

    @Test
    void testUserNotNull() {

        User user = new User(2, "Rahul");

        when(repo.getUser(2)).thenReturn(user);

        assertNotNull(service.getUserDetails(2));
    }
}