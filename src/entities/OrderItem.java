package entities;

public class OrderItem {

	private String name;
	private Double value;
	private Integer quantity;
	
	public OrderItem() {
	}
	
	public OrderItem (String name, Double value, Integer quantity) {
		this.name = name;
		this.quantity = quantity;
		this.value = value;
	}

	public void setName (String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	
	public Double totalCost() {
		return this.quantity * this.value;
	}
	
	public String toString() {
		return String.format("%s, %.2f, %d", name, value, quantity);
	}
	
}
