package com.marketyo.platform.model.reponses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Createdby MBH on 06/03/2017.
 */

public class RestResultArr<T> {
    @SerializedName(value = "Success", alternate = {"success"})
    private Boolean success;
    @SerializedName(value = "Errors", alternate = {"errors"})
    private List<String> errors;
    @SerializedName(value = "Warnings", alternate = {"warnings"})
    private List<String> warnings;
    @SerializedName(value = "Messages", alternate = {"messages"})
    private List<String> messages;
    @SerializedName(value = "Data", alternate = {"data"})
    private List<T> data;

    public Boolean isSuccess() {
        return success != null && success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getWarnings() {
        if (warnings == null) {
            warnings = new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<String> getMessages() {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static <B> RestResultArr<B> fromRestResult(RestResultArr restResult) {
        final RestResultArr<B> result = new RestResultArr<>();
        result.setMessages(restResult.getMessages());
        result.setErrors(restResult.getErrors());
        result.setWarnings(restResult.getWarnings());
        result.setSuccess(restResult.isSuccess());
        return result;
    }

    public static <B> RestResultArr<B> restResultFail(List<B> data) {
        final RestResultArr<B> result = new RestResultArr<>();
        result.setSuccess(false);
        result.data = data;
        return result;
    }
}
