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
    // ?šŒ?›ê°??… ?ˆ˜?–‰?•¨?ˆ˜
    @POST("user/signup")
    Call<SignupResult> getSignupResult(@Body Signup signup);

    // ë¡œê·¸?¸ ?ˆ˜?–‰?•¨?ˆ˜
    @POST("user/signin")
    Call<User_f_n> getUserIdentity(@Body Login login);

    // ë¡œê·¸?¸?›„ ? „? ¥?‚¬?š© ?ˆ?Š¤?† ë¦? ?š”ì²? ?•¨?ˆ˜
    @GET("user/getelechistory")
    Call<List<Electricusage_permon>> getElechistory(@Query("token") int token);

    // ?„œë²„ì— ???¥?˜?–´ ?ˆ?Š” ?‚¬?š©? ê³„ì •?— ???•œ ëª¨ë¸ ë¦¬ìŠ¤?Š¸?“¤?„ ë°›ì•„?˜´
    @GET("user/product/getproductlist")
    Call<List<ProductList>> getProductList(); // type 0 : ?‚¬?š©?ê°? ?“±ë¡í–ˆ?—ˆ?˜ ëª¨ë“  ? œ?’ˆ?“¤?˜ ë¦¬ìŠ¤?Š¸ë¥? ë°›ì•„?˜´

    @GET("user/product/getuserproductlist")
    Call<List<Product>> getUserPList(@Query("token") int token);
    // ?„œë²„ì— ?‚¬?š©?ê°? ?ƒˆë¡? ?“±ë¡í•˜?Š” ? œ?’ˆ?“¤?„ ì¶”ê?
    @GET("user/product/addproducttolist")
    Call<Void> addProduct(@Header("token") String token, @Body Product product);

    // ?„œë²„ì— ?‚¬?š©?ê°? ?“±ë¡í•´?†¨?˜ ? œ?’ˆ?— ???•œ ? •ë³? ?¼ë¶?ë¥? ?ˆ˜? •
    @GET("user/product/editproducttolist")
    Call<Void> editProduct(@Header("token") String token,@Body Product product);

    // for confimation code
//    @GET("topic")
//    Call<Practice> checkoutnetworking(@Query("javascript") String type);
}
