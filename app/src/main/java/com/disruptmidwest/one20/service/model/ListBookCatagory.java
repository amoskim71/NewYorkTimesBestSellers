package com.disruptmidwest.one20.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 11/12/17.
 */

public class ListBookCatagory {

    @SerializedName("list_id")
    @Expose
    private int listId;

    @SerializedName("list_name")
    @Expose
    private String listName;
/*        @SerializedName("list_name")
        @Expose
        private String listName;
        @SerializedName("list_name_encoded")
        @Expose
        private String listNameEncoded;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("updated")
        @Expose
        private String updated;
        @SerializedName("list_image")
        @Expose
        private String listImage;
        @SerializedName("list_image_width")
        @Expose
        private int listImageWidth;


        @SerializedName("list_image_height")
        @Expose
        private int listImageHeight;*/

    @SerializedName("books")
    @Expose
    public List<Books> booksInCatagory;


    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

      /*  public String getListName() {
            return listName;
        }

        public void setListName(String listName) {
            this.listName = listName;
        }

        public String getListNameEncoded() {
            return listNameEncoded;
        }

        public void setListNameEncoded(String listNameEncoded) {
            this.listNameEncoded = listNameEncoded;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getListImage() {
            return listImage;
        }

        public void setListImage(String listImage) {
            this.listImage = listImage;
        }

        public int getListImageWidth() {
            return listImageWidth;
        }

        public void setListImageWidth(int listImageWidth) {
            this.listImageWidth = listImageWidth;
        }

        public int getListImageHeight() {
            return listImageHeight;
        }

        public void setListImageHeight(int listImageHeight) {
            this.listImageHeight = listImageHeight;
        }
*/
}

