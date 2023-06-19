package p1;
	import java.io.Serializable;

	public class Products implements Serializable {
		private String name="";
		private double price=0;
		private double pTotal=0;
		private int quantity=0;
		private int stock=0;
		
		public Products(String nombre, double precio, int stock) {
			super();
			this.name = nombre;
			this.price = precio;
			this.stock = stock;
		}

		public String getNombre() {
			return name;
		}
		public void setNombre(String nombre) {
			this.name = nombre;
		}
		public double getPrecio() {
			return price;
		}
		public void setPrecio(double precio) {
			this.price = precio;
		}
		public double getpTotal() {
			return pTotal;
		}
		public void setpTotal(double pTotal) {
			this.pTotal = pTotal;
		}
		public int getCantidad() {
			return quantity;
		}
		public void setCantidad(int cantidad) {
			this.quantity = cantidad;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		@Override
		public String toString() {
			return "Productos [nombre=" + name + ", precio=" + price + ", pTotal=" + pTotal + ", cantidad="
					+ quantity + ", stock=" + stock + "]";
		}
		
		
}
