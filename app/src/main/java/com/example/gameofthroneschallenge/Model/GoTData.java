package com.example.gameofthroneschallenge.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GoTData implements Serializable {

    /**
     * description : In A Game of Thrones (1996), Tyrion is introduced as the third and youngest child of wealthy and powerful Tywin Lannister, the former Hand of the King. Tyrion's elder sister Cersei is the Queen of Westeros by virtue of her marriage to King Robert Baratheon, and Cersei's male twin Jaime is one of the Kingsguard, the royal security detail. Described as an ugly ('for all the world like a gargoyle'), malformed dwarf with mismatched green and black eyes, Tyrion possesses the pale blond hair of a Lannister but has a complicated relationship with the rest of them.
     * houseId : 50fab25b
     * houseImageUrl : https://firebasestorage.googleapis.com/v0/b/android-challenge-3472e.appspot.com/o/lannister.jpg?alt=media&token=bba81f7a-3a8d-4fa7-bb33-c280ffdded77
     * houseName : House Lannister
     * imageUrl : https://firebasestorage.googleapis.com/v0/b/android-challenge-3472e.appspot.com/o/tyrion.jpg?alt=media&token=41fd7be8-b3f4-4d6c-b383-3f6276109fc8
     * name : Tyrion Lannister
     */

    @SerializedName("description")
    private String description;
    @SerializedName("houseId")
    private String houseId;
    @SerializedName("houseImageUrl")
    private String houseImageUrl;
    @SerializedName("houseName")
    private String houseName;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("name")
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseImageUrl() {
        return houseImageUrl;
    }

    public void setHouseImageUrl(String houseImageUrl) {
        this.houseImageUrl = houseImageUrl;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
