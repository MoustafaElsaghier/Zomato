package elsaghier.com.zomato.Network;

import java.util.ArrayList;
import java.util.List;

import elsaghier.com.zomato.Model.CategoryModel;
import elsaghier.com.zomato.Model.RestaurantModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("categories")
    Call<List<CategoryModel>> getAllCategories();

    @Headers({"Accept: application/json", "user-key: 55a1d18014dd0c0dac534c02598a3368"})
    @GET("search")
    Call<ArrayList<RestaurantModel>> getAllRestaurantsInCategory(@Query("category") String categoryId);

}
