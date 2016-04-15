package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orderline {

	@Id @GeneratedValue
	private long id;
	
	private int quantity;
	
	private double subTotal;
	
	@ManyToOne()
	@JoinColumn(name = "orderId")
	private Order order;
	
}
