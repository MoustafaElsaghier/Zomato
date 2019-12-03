package elsaghier.com.zomato.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RestaurantResponse {

    @SerializedName("results_found")
    private Long mResultsFound;
    @SerializedName("results_shown")
    private Long mResultsShown;
    @SerializedName("results_start")
    private Long mResultsStart;

    public Long getmResultsFound() {
        return mResultsFound;
    }

    public void setmResultsFound(Long mResultsFound) {
        this.mResultsFound = mResultsFound;
    }

    public Long getmResultsShown() {
        return mResultsShown;
    }

    public void setmResultsShown(Long mResultsShown) {
        this.mResultsShown = mResultsShown;
    }

    public Long getmResultsStart() {
        return mResultsStart;
    }

    public void setmResultsStart(Long mResultsStart) {
        this.mResultsStart = mResultsStart;
    }

    public ArrayList<RestaurantModel> getRestaurantModels() {
        return restaurantModels;
    }

    public void setRestaurantModels(ArrayList<RestaurantModel> restaurantModels) {
        this.restaurantModels = restaurantModels;
    }

    @SerializedName("restaurants")
    private ArrayList<RestaurantModel> restaurantModels;
}
