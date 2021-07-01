package com.marketyo.platform.model.reponses;

import com.google.gson.annotations.SerializedName;
import com.marketyo.platform.model.timeSlot.Timeslot;

import java.util.List;

public class TimeSlotResponse {

    @SerializedName("timeslot_realcount")
    private Long mTimeslotRealcount;
    @SerializedName("timeslots")
    private List<Timeslot> mTimeslots;

    public Long getTimeslotRealcount() {
        return mTimeslotRealcount;
    }

    public void setTimeslotRealcount(Long timeslotRealcount) {
        mTimeslotRealcount = timeslotRealcount;
    }

    public List<Timeslot> getTimeslots() {
        return mTimeslots;
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        mTimeslots = timeslots;
    }

}
