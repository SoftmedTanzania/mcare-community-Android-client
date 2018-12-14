package com.softmed.tanzania.referral;

public class MyBasket {
    String server_id;
    String name;

    public MyBasket(String server_id, String name) {
        this.server_id = server_id;
        this.name = name;

    }

    public String getByServerId() {
        return server_id;
    }

    public String getByName() {
        return name;
    }


}