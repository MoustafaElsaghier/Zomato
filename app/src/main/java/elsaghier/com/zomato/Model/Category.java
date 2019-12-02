
package elsaghier.com.zomato.Model;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("category_name")
    private String mCategoryName;

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

}
