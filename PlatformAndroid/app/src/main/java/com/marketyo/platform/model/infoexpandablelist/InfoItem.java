package com.marketyo.platform.model.infoexpandablelist;

import androidx.annotation.DrawableRes;

/**
 * Createdby MBH on 20/01/2017.
 */

public class InfoItem {

    private int id = 0;
    private String title;
    private
    @DrawableRes
    int imageId;
    private InfoItemClickListener itemClickListener;

    public InfoItem() {
    }

    InfoItem(String title, int imageId, InfoItemClickListener itemClickListener) {
        this.title = title;
        this.imageId = imageId;
        this.itemClickListener = itemClickListener;
    }

    public InfoItem(int id, String title, int imageId, InfoItemClickListener itemClickListener) {
        this.id = id;
        this.title = title;
        this.imageId = imageId;
        this.itemClickListener = itemClickListener;
    }

    public InfoItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(@DrawableRes int imageId) {
        this.imageId = imageId;
    }

    public interface InfoItemClickListener {
        void onInfoItemClicked(InfoItem item);
    }
}
