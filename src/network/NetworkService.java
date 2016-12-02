package network;

import java.util.List;

import components.Product;
import network.request.Login;
import network.request.Signup;
import network.response.Electricusage_permon;
import network.response.ProductList;
import network.response.Product_n;
import network.response.SignupResult;
import network.response.User_f_n;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 * LOC 36
 */
public interface NetworkService {
    // callback method for signup
    @POST("user/signup")
    Call<SignupResult> getSignupResult(@Body Signup signup);

    // callback method for signin
    @POST("user/signin")
    Call<User_f_n> getUserIdentity(@Body Login login);

    // callback method for request get electric usage history
    @GET("user/getelechistory")
    Call<List<Electricusage_permon>> getElechistory(@Query("token") int token);

    // callback method for request crawled product info list
    @GET("user/product/getproductlist")
    Call<List<ProductList>> getProductList(); 

    // callback method for request user's product info list
    @GET("user/product/getuserproductlist")
    Call<List<Product_n>> getUserPList(@Query("token") int token);
    
    // callback method for add product to user's account on server
    @GET("user/product/addproducttolist")
    Call<Void> addProduct(@Query("token") int token, @Body Product product);

    // callback method for edit product to user's account on server
    @GET("user/product/editproducttolist")
    Call<Void> editProduct(@Query("token") int token,@Body Product product);
}
