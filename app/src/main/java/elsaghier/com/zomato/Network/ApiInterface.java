package elsaghier.com.zomato.Network;

import java.util.List;

import elsaghier.com.zomato.Model.Category;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ELSaghier on 1/25/2018.
 */

public interface ApiInterface {

    @GET("categories")
    Call<List<Category>> getAllCategories();

}
