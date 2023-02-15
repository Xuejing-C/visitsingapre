package com.nus.travel_website.domain;

public class Image {
    private int vgid;
    private int vid;
    private String img;

    public Image() {
    }

    public Image(int vgid, int vid, String img) {
        this.vgid = vgid;
        this.vid = vid;
        this.img = img;
    }

    public int getVgid() {
        return vgid;
    }

    public void setVgid(int vgid) {
        this.vgid = vgid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
