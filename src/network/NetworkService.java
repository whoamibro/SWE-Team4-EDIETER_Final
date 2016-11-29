package network;

import network.request.Login;
import network.request.Signup;
import network.response.Product;
import network.response.SignupResult;
import network.response.User_f_n;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public interface NetworkService {
    // 회원가입 수행함수
    @POST("user/signup")
    Call<SignupResult> getSignupResult(@Body Signup signup);

    // 로그인 수행함수
    @POST("user/signin")
    Call<User_f_n> getUserIdentity(@Body Login login);

    // 서버에 저장되어 있는 사용자 계정에 대한 모델 리스트들을 받아옴
    @GET("user/product/getproductlist")
    Call<List<Product>> getProductList(@Header("token") String token, @Query("getlist") int type ); // type 0 : 사용자가 등록했었던 모든 제품들의 리스트를 받아옴

    // 서버에 사용자가 새로 등록하는 제품들을 추가
    @GET("user/product/addproducttolist")
    Call<Void> addProduct(@Header("token") String token, @Body Product product);

    // 서버에 사용자가 등록해놨던 제품에 대한 정보 일부를 수정
    @GET("user/product/editproducttolist")
    Call<Void> editProduct(@Header("token") String token,@Body Product product);

    // for confimation code
//    @GET("topic")
//    Call<Practice> checkoutnetworking(@Query("javascript") String type);
}
