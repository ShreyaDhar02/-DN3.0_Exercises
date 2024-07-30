package Excercise11;

public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a concrete CustomerRepository implementation
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the repository into the CustomerService via constructor injection
        CustomerService service = new CustomerService(repository);

        // Use the service to find a customer
        Customer customer = service.findCustomerById(1);
        if (customer != null) {
            System.out.println("Customer found: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}

// Customer class (Model)
class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Repository Interface
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    // In a real application, this would interact with a database
    @Override
    public Customer findCustomerById(int id) {
        // Simulate a database lookup
        if (id == 1) {
            return new Customer(id, "Alice");
        }
        return null;
    }
}

// Service Class
class CustomerService {
    private final CustomerRepository repository;

    // Constructor injection for dependency injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer findCustomerById(int id) {
        return repository.findCustomerById(id);
    }
}

