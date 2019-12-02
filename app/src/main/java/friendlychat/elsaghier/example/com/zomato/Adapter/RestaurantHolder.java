package friendlychat.elsaghier.example.com.zomato.Adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import friendlychat.elsaghier.example.com.zomato.R;


class RestaurantHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView restaurantImg;
    private TextView restaurantName;
    private TextView restaurantAddress;
    private TextView restaurantRating;
    private TextView cost;
    private RecyclerItemClick itemClick;

    void setItemClick(RecyclerItemClick itemClick) {
        this.itemClick = itemClick;
    }


    RestaurantHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        restaurantImg = itemView.findViewById(R.id.resturant_img);
        restaurantName = itemView.findViewById(R.id.resturant_name);
        restaurantAddress = itemView.findViewById(R.id.resturant_address);
        restaurantRating = itemView.findViewById(R.id.rating);
        cost = itemView.findViewById(R.id.resturant_cost);
    }

    public void setName(String name) {
        restaurantName.setText(name);
    }

    public void setAddress(String address) {
        restaurantAddress.setText(address);
    }

    public void setRating(String rating) {
        restaurantRating.setText(rating);
    }

    public void setCost(String cost) {
        this.cost.setText(cost);
    }

    @Override
    public void onClick(View view) {
        this.itemClick.onItemClicked(this.getLayoutPosition());
    }
}