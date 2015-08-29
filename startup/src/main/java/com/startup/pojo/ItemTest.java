package com.startup.pojo;

public class ItemTest {
    private Integer itemid;

    private String itemtitle;

    private String description;

    private String itemphoto;

    private Integer activity;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemtitle() {
        return itemtitle;
    }

    public void setItemtitle(String itemtitle) {
        this.itemtitle = itemtitle == null ? null : itemtitle.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getItemphoto() {
        return itemphoto;
    }

    public void setItemphoto(String itemphoto) {
        this.itemphoto = itemphoto == null ? null : itemphoto.trim();
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }
}