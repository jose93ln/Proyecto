package p1;
	import java.io.Serializable;

	public class Products implements Serializable {
		private String name="";
		private double price=0;
		private double pTotal=0;
		private int quantity=1;
		private int stock=0;
		
		public Products(String _name, double _price, int _stock) {
			super();
			this.name = _name;
			this.price = _price;
			this.pTotal= _price;
			this.stock = _stock;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getpTotal() {
			return pTotal;
		}

		public void setpTotal(double pTotal) {
			this.pTotal = pTotal;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		@Override
		public String toString() {
			return "Products [name=" + name + ", price=" + price + ", pTotal=" + pTotal + ", quantity=" + quantity
					+ ", stock=" + stock + "]";
		}

		
		
		
}
