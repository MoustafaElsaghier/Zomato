package elsaghier.com.zomato.Network;

import java.util.List;

import elsaghier.com.zomato.Model.Category;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("categories")
    Call<List<Category>> getAllCategories();

    @GET("search")
    Call<List<Category>> getAllRestaurantsInCategory(@Query("category") String categoryId);

}
