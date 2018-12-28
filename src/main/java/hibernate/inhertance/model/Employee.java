package hibernate.inhertance.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
//@DiscriminatorColumn(name="Type",discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@GenericGenerator(
//	        name = "assigned-sequence",
//	        strategy = "com.vladmihalcea.book.hpjp.hibernate.identifier.StringSequenceIdentifier",
//	        parameters = {
//	            @org.hibernate.annotations.Parameter(
//	                name = "sequence_name", value = "hibernate_sequence"),
//	            @org.hibernate.annotations.Parameter(
//	                name = "sequence_prefix", value = "CTC_"),
//	        }
//	    )
//	    @GeneratedValue(
//	        generator = "assigned-sequence",
//	        strategy = GenerationType.SEQUENCE)
	private int e_id;
	private String name;
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", name=" + name + "]";
	}
	
	
}
