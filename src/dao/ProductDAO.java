package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	
	Connection con;

	public ProductDAO(Connection con) {
		this.con = con;
	}

	public int insertProduct(Product newProduct) throws Exception{

		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO Product VALUES (?,?,?,?)";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newProduct.getStudent_no());
			pstmt.setInt(2, newProduct.getProduct_kor());
			pstmt.setInt(3, newProduct.getProduct_eng());
			pstmt.setInt(4, newProduct.getProduct_math());

			insertCount = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}

		return insertCount;
		
	}

	public ArrayList<> selectProductList() throws Exception{

		ArrayList<Product> ProductList = null;
		Product Product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Product.student_no, student_name, Product_kor, Product_eng, Product_math "
				+ "FROM Product, student WHERE Product.student_no = student.student_no";

		try{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				ProductList = new ArrayList<Product>();

				do{
					Product = new Product(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("Product_kor"),
							rs.getInt("Product_eng"),
							rs.getInt("Product_math"));

					ProductList.add(Product);

				}while(rs.next());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return ProductList;
		
	}

	public ArrayList<Product> selectProductListByStudent_name(String student_name) throws Exception {

		ArrayList<Product> searchProductList = null;
		Product searchProduct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Product.student_no, student_name, Product_kor, Product_eng, Product_math "
				+ "FROM Product, student WHERE Product.student_no = student.student_no "
				+ "AND student_name like concat('%', ?, '%')";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_name);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				searchProductList = new ArrayList<Product>();

				do{
					searchProduct = new Product(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("Product_kor"),
							rs.getInt("Product_eng"),
							rs.getInt("Product_math"));

					searchProductList.add(searchProduct);

				}while(rs.next());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return searchProductList;
		
	}

	public ArrayList<Product> selectProductListByStudent_no(int student_no) throws Exception{

		ArrayList<Product> searchProductList = null;
		Product Product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Product.student_no, student_name, Product_kor, Product_eng, Product_math "
				+ "FROM Product, student WHERE Product.student_no = student.student_no "
				+ "AND Product.student_no like concat(?, '%')";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				searchProductList = new ArrayList<Product>();

				do{
					Product = new Product(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("Product_kor"),
							rs.getInt("Product_eng"),
							rs.getInt("Product_math"));
					
					searchProductList.add(Product);

				}while(rs.next());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return searchProductList;
		
	}

	public ArrayList<Product> selectProductListByStudent_year(int student_year) throws Exception{

		ArrayList<Product> searchProductList = null;
		Product searchProduct = null;  
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Product.student_no, student_name, Product_kor, Product_eng, Product_math "
				+ "FROM Product, student WHERE Product.student_no = student.student_no AND student_year = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_year);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				searchProductList = new ArrayList<Product>();
				do{
					searchProduct = new Product(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("Product_kor"),
							rs.getInt("Product_eng"),
							rs.getInt("Product_math"));

					searchProductList.add(searchProduct);

				}while(rs.next());

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return searchProductList;
		
	}
	
	public Product selectProduct(int student_no) throws Exception{

		Product Product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT student.student_no, student_name, Product_kor, Product_eng, Product_math "
				+ "FROM Product, student WHERE Product.student_no = student.student_no "
				+ "AND Product.student_no = ?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				Product = new Product(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("Product_kor"),
						rs.getInt("Product_eng"),
						rs.getInt("Product_math"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return Product;
		
	}
	
	public int updateProduct(Product changeProduct) throws Exception{

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE Product SET Product_kor = ?, Product_eng = ?, Product_math = ? WHERE student_no = ?";

		try{
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, changeProduct.getProduct_kor());
			pstmt.setInt(2, changeProduct.getProduct_eng());
			pstmt.setInt(3, changeProduct.getProduct_math());
			pstmt.setInt(4, changeProduct.getStudent_no());

			updateCount = pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}

		return updateCount;
		
	}

	public int deleteProduct(int student_no) throws Exception {

		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM Product WHERE student_no = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			deleteCount = pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}

		return deleteCount;
		
	}

	public ArrayList<Product> selectProductListAddPercent(int ProductListSize) throws Exception{
		
		float percent = 0;
		int count = 1;
		ArrayList<Product> ProductListAddPercent = null;
		Product Product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Product.student_no, student_name ,Product_kor,Product_eng,Product_math FROM Product, student WHERE Product.student_no = student.student_no ORDER BY (Product_kor + Product_eng + Product_math) DESC";

		try{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				ProductListAddPercent = new ArrayList<Product>();

				do{
					percent = count++ / (float)ProductListSize * 100;
					Product = new Product(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("Product_kor"),
							rs.getInt("Product_eng"),
							rs.getInt("Product_math"),
							percent);
					
					ProductListAddPercent.add(Product);				

				}while(rs.next());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return ProductListAddPercent;
		
	}
	
}
