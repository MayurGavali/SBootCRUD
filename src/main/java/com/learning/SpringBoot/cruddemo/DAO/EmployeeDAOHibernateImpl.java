package com.learning.SpringBoot.cruddemo.DAO;
import com.learning.SpringBoot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define the feild for entity Manager
    private EntityManager entityManager;

    //Setting up the constructor Injection
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //get the current hibernate session
        Session currentSession=entityManager.unwrap(Session.class);
        //create a query
        Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
        //execute the query and get the results
        List<Employee> employees=theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findbyId(int theId) {
        //get the hibernate session
        Session currentSession= entityManager.unwrap(Session.class);

        //get the employee
        Employee theemployee=currentSession.get(Employee.class, theId);

        //retrurn the employee
        return theemployee;
    }

    @Override
    public void save(Employee theEmployee) {
        //get the hibernate session
        Session currentSession=entityManager.unwrap(Session.class);

        //get the employee
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {

        //get the current hibernate session
        Session currentsession=entityManager.unwrap(Session.class);

        //delete the object with the priomary key
        Query thequery=currentsession.createQuery("delete from Employee where id=:employeeId");
        thequery.setParameter("employeeId", theId);
        thequery.executeUpdate();

    }
}
