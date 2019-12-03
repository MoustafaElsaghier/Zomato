package elsaghier.com.zomato.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import elsaghier.com.zomato.Activities.MapsActivity;
import elsaghier.com.zomato.Model.RestaurantModel;
import elsaghier.com.zomato.R;


public class RestaurantAdapter extends RecyclerView.Adapter<elsaghier.com.zomato.Adapter.RestaurantHolder> {

    private ArrayList<RestaurantModel> mData;
    private Context mContext;

    public RestaurantAdapter(ArrayList<RestaurantModel> data, Context mContext) {
        this.mData = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public elsaghier.com.zomato.Adapter.RestaurantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new elsaghier.com.zomato.Adapter.RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(elsaghier.com.zomato.Adapter.RestaurantHolder holder, int position) {
        final RestaurantModel.Restaurant restaurant = mData.get(position).getRestaurant();

        holder.setName(restaurant.getName());
        holder.setAddress(restaurant.getLocation().getAddress());
        holder.setCost("Cuisines :  " + restaurant.getCuisines() + restaurant.getCurrency());
        holder.setRating(restaurant.getUserRating().getAggregateRating());
        if (restaurant.getPhotos().get(0).getPhoto().getUrl().isEmpty())
            holder.restaurantImg.setImageResource(R.mipmap.ic_launcher);
        else
            Glide.with(mContext).load(restaurant.getPhotos().get(0).getPhoto().getUrl()).into(holder.restaurantImg);


        holder.setItemClick(new RecyclerItemClick() {
            @Override
            public void onItemClicked(int pos) {
                Intent i = new Intent(mContext, MapsActivity.class);
                i.putExtra("rest_item", restaurant);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

}
