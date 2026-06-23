package designpatterns;

// Dependency Injection Pattern
// Instead of creating dependencies inside a class, we pass them from outside
// This makes the code easier to test and change

// Step 1: Repository interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Step 2: Concrete implementation of repository
class CustomerRepositoryImpl implements CustomerRepository {

    public String findCustomerById(int id) {
        // In real app this would query a database
        if (id == 1) return "Anand";
        if (id == 2) return "Rahul";
        return "Not Found";
    }
}

// Step 3: Service class - depends on repository
class CustomerService {

    CustomerRepository repository;

    // Constructor Injection - repository is passed from outside
    CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    String getCustomer(int id) {
        return repository.findCustomerById(id);
    }
}

// Step 4: Main test class
public class DependencyInjection {

    public static void main(String[] args) {

        CustomerRepository repo = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService service = new CustomerService(repo);

        System.out.println("Customer 1: " + service.getCustomer(1));
        System.out.println("Customer 2: " + service.getCustomer(2));
        System.out.println("Customer 3: " + service.getCustomer(3));
    }
}
