package p1;

import java.util.ArrayList;

public class ProductManager {
	private ArrayList<Products> proal;
	private BDproductosDAO bdal= new BDproductosDAO();


	public ProductManager() {
		proal=new ArrayList<Products>();
	}

	
	public ArrayList<Products> getAl() {
		return proal;
	}


	public void addProductByName(String nombre) {
		Products p=bdal.getProduct(nombre);
		proal.add(p);
	}
}