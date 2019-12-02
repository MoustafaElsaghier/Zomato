
package elsaghier.com.zomato.Model;

import com.google.gson.annotations.SerializedName;

public class CategoryModel {

    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("category_name")
    private String mCategoryName;

    private int imageRes;

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

}
