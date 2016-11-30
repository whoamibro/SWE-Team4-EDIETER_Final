package network;

import javafx.collections.ObservableList;
import network.request.Token;
import network.response.Electricusage_permon;
import network.response.Product;
import network.response.ProductList;
import network.response.User_f_n;

import java.util.List;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Assembleddata {
    private static Token token = new Token();
    private static User_f_n user_f_n = new User_f_n();
    private static List<Electricusage_permon> electricusage_permons;
    private static List<ProductList> productLists;
    private static List<Product> products;

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


    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        Assembleddata.products = products;
    }
}
