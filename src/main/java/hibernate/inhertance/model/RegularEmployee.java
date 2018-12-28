package hibernate.inhertance.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
//@DiscriminatorValue("Regular_Employee")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)  
public class RegularEmployee extends Employee {

	private String salary;

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "RegularEmployee [salary=" + salary + ", getE_id()=" + getE_id() + ", getName()=" + getName()
				+ ", toString()=" + super.toString() + "]";
	}

}
