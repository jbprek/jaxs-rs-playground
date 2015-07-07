package ejbcrud.service;

import ejbcrud.persistence.CustomerDao;
import ejbcrud.model.Customer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author prekezes.
 */

@Stateless
@Path("/customers")
public class CustomerService {

    @EJB
    private CustomerDao dao;

    @Path("/create/{name}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Customer create(@PathParam("name")String name) {
        Customer c = dao.create(name);
        return c;
    }

    @Path("/read/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer read(@PathParam("id")long id) {
        return dao.read(id);
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer update(Customer updated) {
        return dao.update(updated);
    }

    @Path("/delete/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer delete(@PathParam("id")long id) {
        return dao.delete(id);
    }
}
