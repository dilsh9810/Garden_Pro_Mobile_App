package BackendServices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    //Define API calls

    @POST("authenticate/")

    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("users/")

    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);



}
