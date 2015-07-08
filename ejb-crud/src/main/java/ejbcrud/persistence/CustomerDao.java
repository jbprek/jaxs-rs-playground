package ejbcrud.persistence;

import ejbcrud.model.Customer;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author prekezes.
 */
@Singleton
public class CustomerDao {

    private AtomicLong keySequence = new AtomicLong(0);

    private Map<Long, Customer> repository = new HashMap<>();

    public Customer create(String name) {
        Customer customer = new Customer();
        customer.setId(keySequence.incrementAndGet());
        customer.setName(name);
        repository.put(customer.getId(), customer);
        return null;
    }

    @Lock(LockType.READ)
    public Customer read (long id) {
        return repository.get(id);
    }

    public Customer update(Customer customer) {
        Customer old = repository.get(customer.getId());
        repository.put(customer.getId(), customer);
        return old;
    }

    public Customer delete(long id) {
        Customer old = repository.get(id);
        Objects.requireNonNull(old);
        repository.remove(id);
        return old;
    }

}
