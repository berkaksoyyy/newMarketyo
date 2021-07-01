package com.marketyo.platform.model.infoexpandablelist;


import java.util.ArrayList;
import java.util.List;

/**
 * Createdby MBH on 19/01/2017.
 */

public class InfoGroupItem {
    private String title;
    private List<InfoItem> infoSectionButtons;

    public InfoGroupItem(String title) {
        this.title = title;
        this.infoSectionButtons = new ArrayList<>();
    }

    public InfoGroupItem(String title, List<InfoItem> infoSectionButtons) {
        this.title = title;
        this.infoSectionButtons = infoSectionButtons;
    }

    public void addItem(InfoItem item) {
        infoSectionButtons.add(item);
    }

    public void setInfoSectionItemList(List<InfoItem> infoSectionButtons) {
        this.infoSectionButtons = infoSectionButtons;
    }

    public String getTitle() {
        return title;
    }

    public List<InfoItem> getChildItemList() {
        return infoSectionButtons;
    }

}
