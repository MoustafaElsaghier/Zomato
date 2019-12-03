package elsaghier.com.zomato.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RestaurantModel implements Serializable {
    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public class Location {

        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("locality")
        @Expose
        private String locality;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("city_id")
        @Expose
        private Integer cityId;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("country_id")
        @Expose
        private Integer countryId;
        @SerializedName("locality_verbose")
        @Expose
        private String localityVerbose;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public String getLocalityVerbose() {
            return localityVerbose;
        }

        public void setLocalityVerbose(String localityVerbose) {
            this.localityVerbose = localityVerbose;
        }

    }

    public class Photo {

        @SerializedName("photo")
        @Expose
        private Photo_ photo;

        public Photo_ getPhoto() {
            return photo;
        }

        public void setPhoto(Photo_ photo) {
            this.photo = photo;
        }

    }

    public class Photo_ {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("thumb_url")
        @Expose
        private String thumbUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

    }

    public class Restaurant implements Serializable{

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("location")
        @Expose
        private Location location;
        @SerializedName("cuisines")
        @Expose
        private String cuisines;
        @SerializedName("timings")
        @Expose
        private String timings;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("thumb")
        @Expose
        private String thumb;
        @SerializedName("user_rating")
        @Expose
        private UserRating userRating;
        @SerializedName("photos")
        @Expose
        private List<Photo> photos = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getCuisines() {
            return cuisines;
        }

        public void setCuisines(String cuisines) {
            this.cuisines = cuisines;
        }

        public String getTimings() {
            return timings;
        }

        public void setTimings(String timings) {
            this.timings = timings;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public UserRating getUserRating() {
            return userRating;
        }

        public void setUserRating(UserRating userRating) {
            this.userRating = userRating;
        }

        public List<Photo> getPhotos() {
            return photos;
        }

        public void setPhotos(List<Photo> photos) {
            this.photos = photos;
        }

    }

    public class UserRating {

        @SerializedName("aggregate_rating")
        @Expose
        private String aggregateRating;
        @SerializedName("rating_text")
        @Expose
        private String ratingText;
        @SerializedName("rating_color")
        @Expose
        private String ratingColor;
        @SerializedName("votes")
        @Expose
        private String votes;

        public String getAggregateRating() {
            return aggregateRating;
        }

        public void setAggregateRating(String aggregateRating) {
            this.aggregateRating = aggregateRating;
        }

        public String getRatingText() {
            return ratingText;
        }

        public void setRatingText(String ratingText) {
            this.ratingText = ratingText;
        }

        public String getRatingColor() {
            return ratingColor;
        }

        public void setRatingColor(String ratingColor) {
            this.ratingColor = ratingColor;
        }

        public String getVotes() {
            return votes;
        }

        public void setVotes(String votes) {
            this.votes = votes;
        }

    }
}