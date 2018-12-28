package hibernate.inhertance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Contract_Employee")
public class Contract_Employee extends Employee {

	private String contract_period;

	public String getContract_period() {
		return contract_period;
	}

	public void setContract_period(String contract_period) {
		this.contract_period = contract_period;
	}

	@Override
	public String toString() {
		return "Contract_Employee [contract_period=" + contract_period + "]";
	}

}
