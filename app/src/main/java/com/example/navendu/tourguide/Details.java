package com.example.navendu.tourguide;

/**
 * Created by navendu on 7/3/2016.
 */
public class Details {
    public static final int no_file_provided = -1;
    private int title;
    private int category;
    private int miscInfo;
    private int url;
    private int imageResourceId;

    public Details(int title, int category, int miscInfo, int url) {
        this.title = title;
        this.category = category;
        this.miscInfo = miscInfo;
        this.url = url;
        this.imageResourceId = no_file_provided;
    }

    public Details(int title, int category, int miscInfo, int url, int imageResourceId) {
        this.title = title;
        this.category = category;
        this.miscInfo = miscInfo;
        this.url = url;
        this.imageResourceId = imageResourceId;
    }

    public int getTitle() {
        return title;
    }

    public int getCategory() {
        return category;
    }

    public int getMiscInfo() {
        return miscInfo;
    }

    public int getUrl() {
        return url;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage() {
        return imageResourceId != no_file_provided;
    }
}
