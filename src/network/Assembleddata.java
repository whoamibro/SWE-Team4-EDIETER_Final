package network;

import java.util.List;

import network.request.Token;
import network.response.Electricusage_permon;
import network.response.ProductList;
import network.response.Product_n;
import network.response.SignupResult;
import network.response.User_f_n;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 * LOC 71
 * part for networking create static variables (for escape nullpointError)
 */
public class Assembleddata {
    private static Token token = new Token();
    private static User_f_n user_f_n = new User_f_n();
    private static List<Electricusage_permon> electricusage_permons;
    private static List<ProductList> productLists;
    private static List<Product_n> products;
    private static SignupResult signupresult = new SignupResult();

    public static SignupResult getSignupresult() {
		return signupresult;
	}

	public static void setSignupresult(SignupResult signupresult) {
		Assembleddata.signupresult = signupresult;
	}

	public static Token getToken() {
        return token;
    }

    public static int tokensetting(){return token.getToken();}

    public static void setToken(int token) {
        Assembleddata.token.setToken(token);
    }

    public static User_f_n getUser_f_n() {
        return user_f_n;
    }

    public static void setUser_f_n(User_f_n user_f_n) {
        Assembleddata.user_f_n.setName(user_f_n.getName());
        Assembleddata.user_f_n.setEmail(user_f_n.getEmail());
        Assembleddata.user_f_n.setAreaSize(user_f_n.getAreaSize());
        Assembleddata.user_f_n.setUsedElec(user_f_n.getUsedElec());
        Assembleddata.user_f_n.setResult(user_f_n.isResult());
    }
    
    public static void setpw(String pw){
    	Assembleddata.user_f_n.setPw(pw);
    }
    
    public static String getpw(){
    	return user_f_n.getPw();
    }
    
    public static List<Electricusage_permon> getElectricusage_permons() {
        return electricusage_permons;
    }

    public static void setElectricusage_permons(List<Electricusage_permon> electricusage_permons) {
        Assembleddata.electricusage_permons = electricusage_permons;
    }

    public static List<ProductList> getProductLists() {
        return productLists;
    }

    public static void setProductLists(List<ProductList> productLists) {
        Assembleddata.productLists = productLists;
    }


    public static List<Product_n> getProducts() {
        return products;
    }

    public static void setProducts(List<Product_n> products) {
        Assembleddata.products = products;
    }
}
/**
 * 
 */
