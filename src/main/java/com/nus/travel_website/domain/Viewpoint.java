package com.nus.travel_website.domain;

import java.util.List;

public class Viewpoint{
    private int vid;
    private String vname;
    private String location;
    private String introduce;
    private String detail;
    private int cid;
    private int favCount;

    private List<Image> imgList;

    public Viewpoint() {
    }
    public Viewpoint(int vid, String vname, String introduce, String detail, String location, int cid, int favCount, List<Image> imgList) {
        this.vid = vid;
        this.vname = vname;
        this.introduce = introduce;
        this.detail = detail;
        this.location = location;
        this.cid = cid;
        this.favCount = favCount;
        this.imgList = imgList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getFavCount() {
        return favCount;
    }

    public void setFavCount(int favCount) {
        this.favCount = favCount;
    }

    public List<Image> getImgList() {
        return imgList;
    }

    public void setImgList(List<Image> imgList) {
        this.imgList = imgList;
    }
}
