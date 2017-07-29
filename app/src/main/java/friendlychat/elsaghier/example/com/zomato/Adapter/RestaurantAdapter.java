package friendlychat.elsaghier.example.com.zomato.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import friendlychat.elsaghier.example.com.zomato.MapsActivity;
import friendlychat.elsaghier.example.com.zomato.Model.Restaurant;
import friendlychat.elsaghier.example.com.zomato.R;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantHolder> {

    private ArrayList<Restaurant> mData;
    private Context mContext;

    public RestaurantAdapter(ArrayList<Restaurant> data, Context mContext) {
        this.mData = data;
        this.mContext = mContext;
    }

    @Override
    public RestaurantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantHolder holder, int position) {
        final Restaurant restaurant = mData.get(position);

        holder.setName(restaurant.getName());
        holder.setAddress(restaurant.getAddress());
        holder.setCost("Average cost for 2:  " + restaurant.getCost() + restaurant.getCurrency());
        holder.setRating(restaurant.getRating());
        if (restaurant.getImageUrl().isEmpty())
            holder.restaurantImg.setImageResource(R.mipmap.ic_launcher);
        else
            Picasso.with(mContext)
                    .load(restaurant.getImageUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.restaurantImg);
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
