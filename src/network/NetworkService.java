package network;

import network.request.Login;
import network.request.Signup;
import network.request.Token;
import network.response.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.*;

import java.util.List;

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
    Call<Void> addProduct(@Header("token") String token, @Body Product_n product);

    // callback method for edit product to user's account on server
    @GET("user/product/editproducttolist")
    Call<Void> editProduct(@Header("token") String token,@Body Product_n product);
}
