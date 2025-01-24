package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Pet
{
    private int id;
    private String name;
    private String status;

    private ArrayList<HashMap <String,String>> tags;
    private ArrayList<String> photoUrls;
    private HashMap <String,String> category;
    private HashMap <String,String> tag;

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(HashMap<String, String> category) {
        this.category = category;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTag(HashMap<String, String> tag) {
        this.tag = tag;
    }

    public void setTags(ArrayList<HashMap<String, String>> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getCategory() {
        return category;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public HashMap<String, String> getTag() {
        return tag;
    }

    public ArrayList<HashMap<String, String>> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

}