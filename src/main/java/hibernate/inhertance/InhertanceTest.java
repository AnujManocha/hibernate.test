package hibernate.inhertance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import hibernate.inhertance.model.Contract_Employee;
import hibernate.inhertance.model.Employee;
import hibernate.inhertance.model.RegularEmployee;
import hibernate.test.HibernateUtil;

public class InhertanceTest {

	public static void main(String[] args) {
/*		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee emp = new Employee();
		emp.setName("anuj");

		RegularEmployee reg = new RegularEmployee();
		reg.setName("aakash");
		reg.setSalary("90000");

		Contract_Employee con = new Contract_Employee();
		con.setName("harry");
		con.setContract_period("6 months");

		RegularEmployee reg2 = new RegularEmployee();
		reg2.setName("Aman");
		reg2.setSalary("30000");

		RegularEmployee reg3 = new RegularEmployee();
		reg3.setName("Rohit");
		reg3.setSalary("15000");

		session.persist(emp);
		session.persist(reg);
		session.persist(reg2);
		session.persist(reg3);
		session.persist(con);

		session.getTransaction().commit();
		session.close();

		// HQL TEST
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		Employee emp1 = (Employee) session2.get(Employee.class, 1);
		System.out.println(emp1);

		Query query = session2.createQuery("from RegularEmployee");// here persistent class name is Emp
		query.setFirstResult(2);
		query.setMaxResults(3);
		List<RegularEmployee> list = query.list();
		System.out.println("list" + list);
		for (RegularEmployee reg1 : list) {
			System.out.println(reg1);
		}

		Query q = session2.createQuery("select count(id) from RegularEmployee");
		Long count = (Long) q.uniqueResult();
		System.out.println("result = " + count);

		Query q1 = session2.createQuery("select min(salary) from RegularEmployee");
		String min_salary = (String) q1.uniqueResult();
		System.out.println("Min salary : " + min_salary);

		// update
		Session session3 = HibernateUtil.getSessionFactory().openSession();
		session3.beginTransaction();
		Query updateQuery = session3.createQuery("update RegularEmployee set name=:name where id=:i");
		updateQuery.setParameter("name", "Udit Kumar");
		updateQuery.setParameter("i", 9);

		int status = updateQuery.executeUpdate();
		session3.beginTransaction().commit();
		System.out.println("updated : " + status);

		// HCQL Criteria

		Criteria c = session3.createCriteria(RegularEmployee.class);
		c.addOrder(Order.desc("salary"));
		List list1 = c.list();
		System.out.println(list1);

		// named query

		Query namedQuery = session3.getNamedQuery("find.employee.by.id");
		namedQuery.setParameter("id", 3);
		System.out.println(namedQuery.getQueryString());
		List<RegularEmployee> List2 = namedQuery.list();
		System.out.println("List 2= "+ List2);
		*/
		
		
//		Query updateNamedQuery = session3.getNamedQuery("update.employee");
		Session session3 = HibernateUtil.getSessionFactory().openSession();
		Query updateNamedQuery = session3.createQuery("update RegularEmployee set salary=:amount where id=:id");
		session3.beginTransaction();
		updateNamedQuery.setParameter("id",3);
		updateNamedQuery.setParameter("amount","123456");
		System.out.println(updateNamedQuery.getQueryString());
		int status_update = updateNamedQuery.executeUpdate();
		System.out.println("status_update : " + status_update);
		session3.getTransaction().commit();
		
		
		Query namedQuery = session3.getNamedQuery("find.employee.by.id");
		namedQuery.setParameter("id", 3);
		System.out.println(namedQuery.getQueryString());
		List<RegularEmployee> List2 = namedQuery.list();
		System.out.println("List 2= "+ List2);
		
		List<RegularEmployee> List3 = namedQuery.list();
		System.out.println("List 3= "+ List3);
		
	}
}
