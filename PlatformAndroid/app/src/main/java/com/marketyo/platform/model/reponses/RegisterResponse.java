package com.marketyo.platform.model.reponses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResponse {

    @SerializedName("errors")
    private List<Object> mErrors;
    @SerializedName("hasError")
    private Boolean mHasError;
    @SerializedName("id_customer")
    private Long mIdCustomer;
    @SerializedName("isSaved")
    private Boolean mIsSaved;

    public List<Object> getErrors() {
        return mErrors;
    }

    public void setErrors(List<Object> errors) {
        mErrors = errors;
    }

    public Boolean getHasError() {
        return mHasError;
    }

    public void setHasError(Boolean hasError) {
        mHasError = hasError;
    }

    public Long getIdCustomer() {
        return mIdCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        mIdCustomer = idCustomer;
    }

    public Boolean getIsSaved() {
        return mIsSaved;
    }

    public void setIsSaved(Boolean isSaved) {
        mIsSaved = isSaved;
    }

}
