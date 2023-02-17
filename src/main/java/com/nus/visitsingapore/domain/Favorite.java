package com.nus.visitsingapore.domain;

public class Favorite {
    private User user;
    private Viewpoint viewpoint;
    private String data;

    public Favorite() {
    }

    public Favorite(User user, Viewpoint viewpoint, String data) {
        this.user = user;
        this.viewpoint = viewpoint;
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Viewpoint getViewpoint() {
        return viewpoint;
    }

    public void setViewpoint(Viewpoint viewpoint) {
        this.viewpoint = viewpoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
