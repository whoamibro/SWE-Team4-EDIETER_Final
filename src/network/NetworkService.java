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
    // ?��?���??�� ?��?��?��?��
    @POST("user/signup")
    Call<SignupResult> getSignupResult(@Body Signup signup);

    // 로그?�� ?��?��?��?��
    @POST("user/signin")
    Call<User_f_n> getUserIdentity(@Body Login login);

    // 로그?��?�� ?��?��?��?�� ?��?��?���? ?���? ?��?��
    @GET("user/getelechistory")
    Call<List<Electricusage_permon>> getElechistory(@Query("token") int token);

    // ?��버에 ???��?��?�� ?��?�� ?��?��?�� 계정?�� ???�� 모델 리스?��?��?�� 받아?��
    @GET("user/product/getproductlist")
    Call<List<ProductList>> getProductList(); // type 0 : ?��?��?���? ?��록했?��?�� 모든 ?��?��?��?�� 리스?���? 받아?��

    @GET("user/product/getuserproductlist")
    Call<List<Product>> getUserPList(@Query("token") int token);
    // ?��버에 ?��?��?���? ?���? ?��록하?�� ?��?��?��?�� 추�?
    @GET("user/product/addproducttolist")
    Call<Void> addProduct(@Header("token") String token, @Body Product product);

    // ?��버에 ?��?��?���? ?��록해?��?�� ?��?��?�� ???�� ?���? ?���?�? ?��?��
    @GET("user/product/editproducttolist")
    Call<Void> editProduct(@Header("token") String token,@Body Product product);

    // for confimation code
//    @GET("topic")
//    Call<Practice> checkoutnetworking(@Query("javascript") String type);
}
