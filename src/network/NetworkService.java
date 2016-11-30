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
 */
public interface NetworkService {
    // ??κ°?? ???¨?
    @POST("user/signup")
    Call<SignupResult> getSignupResult(@Body Signup signup);

    // λ‘κ·Έ?Έ ???¨?
    @POST("user/signin")
    Call<User_f_n> getUserIdentity(@Body Login login);

    // λ‘κ·Έ?Έ? ? ? ₯?¬?© ??€? λ¦? ?μ²? ?¨?
    @GET("user/getelechistory")
    Call<List<Electricusage_permon>> getElechistory(@Query("token") int token);

    // ?λ²μ ???₯??΄ ?? ?¬?©? κ³μ ? ??? λͺ¨λΈ λ¦¬μ€?Έ?€? λ°μ?΄
    @GET("user/product/getproductlist")
    Call<List<ProductList>> getProductList(); // type 0 : ?¬?©?κ°? ?±λ‘ν?? λͺ¨λ  ? ??€? λ¦¬μ€?Έλ₯? λ°μ?΄

    @GET("user/product/getuserproductlist")
    Call<List<Product>> getUserPList(@Query("token") int token);
    // ?λ²μ ?¬?©?κ°? ?λ‘? ?±λ‘ν? ? ??€? μΆκ?
    @GET("user/product/addproducttolist")
    Call<Void> addProduct(@Header("token") String token, @Body Product product);

    // ?λ²μ ?¬?©?κ°? ?±λ‘ν΄?¨? ? ?? ??? ? λ³? ?ΌλΆ?λ₯? ?? 
    @GET("user/product/editproducttolist")
    Call<Void> editProduct(@Header("token") String token,@Body Product product);

    // for confimation code
//    @GET("topic")
//    Call<Practice> checkoutnetworking(@Query("javascript") String type);
}
