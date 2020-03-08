package Nutritio;

import java.util.ArrayList;

class Recipe {

    private String id;
    private String name;
    private String url;
    private String imageURL;

    public Recipe(String id, String name, String url, String imageURL) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public String toString() {
        return "";
    }

}
