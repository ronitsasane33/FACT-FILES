package com.example.shubh.factfiles;

public class DataModel {


    String name;
    //String version;
    int id_;
   // int image;

    public DataModel(String name, int id_) {
        this.name = name;
       // this.version = version;
        this.id_ = id_;

        //this.image=image;
    }


    public String getName() {
        return name;
    }

    public int getId_() {
        return id_;
    }

}

