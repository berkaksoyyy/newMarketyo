package com.marketyo.platform.model.config;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.marketyo.platform.base.constant.Constants;

public class MarketyoConfig {

    @SerializedName(value = "AdetDecreaseAmount", alternate = {"adetDecreaseAmount"})
    private Float mAdetDecreaseAmount;
    @SerializedName(value = "AdetInitialAmount", alternate = {"adetInitialAmount"})
    private Float mAdetInitialAmount;
    @SerializedName(value = "KgDecreaseAmount", alternate = {"kgDecreaseAmount"})
    private Float mKgDecreaseAmount;
    @SerializedName(value = "KgInitialAmount", alternate = {"kgInitialAmount"})
    private Float mKgInitialAmount;
    @SerializedName(value = "MinCartAdetAmount", alternate = {"minCartAdetAmount"})
    private Float mMinCartAdetAmount;
    @SerializedName(value = "MinCartKgAmount", alternate = {"minCartKgAmount"})
    private Float mMinCartKgAmount;
    @SerializedName(value = "MinRegistarAge", alternate = {"minRegistarAge"})
    private Integer mMinRegistarAge;
    @SerializedName(value = "QrSearchEnabled", alternate = {"qrSearchEnabled"})
    private Boolean mQrSearchEnabled;
    @SerializedName(value = "ShowCartProductNote", alternate = {"showCartProductNote"})
    private Boolean mShowCartProductNote;
    @SerializedName(value = "ShowCityLabels", alternate = {"showCityLabels"})
    private Boolean mShowCityLabels;
    @SerializedName(value = "ShowSliderOnCampaign", alternate = {"showSliderOnCampaign"})
    private Boolean mShowSliderOnCampaign;
    @SerializedName(value = "ShowSliderOnCategory", alternate = {"showSliderOnCategory"})
    private Boolean mShowSliderOnCategory;
    @SerializedName(value = "Currency", alternate = {"currency"})
    private String mCurrency;
    @SerializedName(value = "LoginUrl", alternate = {"loginUrl"})
    private String mLoginUrl = "";
    @SerializedName(value = "CmsRegistrationRules", alternate = {"cmsRegistrationRules"})
    private String mCmsRegistrationRules = "";
    @SerializedName(value = "CmsServiceAggreement", alternate = {"cmsServiceAggreement"})
    private String mCmsServiceAggreement = "";
    @SerializedName(value = "CmsContactUs", alternate = {"cmsContactUs"})
    private String mCmsContactUs = "";
    @SerializedName(value = "CmsGeneralRules", alternate = {"cmsGeneralRules"})
    private String mCmsGeneralRules = "";
    @SerializedName(value = "CmsFrequentlyAskedQuestions", alternate = {"cmsFrequentlyAskedQuestions"})
    private String mCmsFrequentlyAskedQuestions = "";

    public MarketyoConfig() {
        mAdetDecreaseAmount = Constants.DEF_ADET_DECREASE_AMOUNT;
        mAdetInitialAmount = Constants.DEF_ADET_INITIAL_AMOUNT;
        mKgDecreaseAmount = Constants.DEF_KG_DECREASE_AMOUNT;
        mKgInitialAmount = Constants.DEF_KG_INITIAL_AMOUNT;
        mMinCartAdetAmount = Constants.DEF_MIN_CART_ADET_AMOUNT;
        mMinCartKgAmount = Constants.DEF_MIN_CART_KG_AMOUNT;
        mMinRegistarAge = Constants.DEF_MIN_MEMBERSHIP_REGISTRATION_AGE;
        mQrSearchEnabled = Constants.DEF_SHOW_QR_SEARCH;
        mShowCartProductNote = Constants.DEF_PRODUCT_NOTE_ACTIVATED;
        mShowCityLabels = Constants.DEF_SHOW_CITY_LABELS_ON_MAIN_PAGE;
        mShowSliderOnCampaign = Constants.DEF_SLIDESHOW_CATEGORY_ACTIVATED;
        mShowSliderOnCategory = Constants.DEF_SLIDESHOW_CATEGORY_ACTIVATED;
        mCurrency = Constants.INSTANCE.getDEF_CURRENCY();
    }

    public Float getAdetDecreaseAmount() {
        return mAdetDecreaseAmount;
    }

    public void setAdetDecreaseAmount(Float AdetDecreaseAmount) {
        mAdetDecreaseAmount = AdetDecreaseAmount;
    }

    public Float getAdetInitialAmount() {
        return mAdetInitialAmount;
    }

    public void setAdetInitialAmount(Float AdetInitialAmount) {
        mAdetInitialAmount = AdetInitialAmount;
    }

    public Float getKgDecreaseAmount() {
        return mKgDecreaseAmount;
    }

    public void setKgDecreaseAmount(Float KgDecreaseAmount) {
        mKgDecreaseAmount = KgDecreaseAmount;
    }

    public Float getKgInitialAmount() {
        return mKgInitialAmount;
    }

    public void setKgInitialAmount(Float KgInitialAmount) {
        mKgInitialAmount = KgInitialAmount;
    }

    public Float getMinCartAdetAmount() {
        return mMinCartAdetAmount;
    }

    public void setMinCartAdetAmount(Float MinCartAdetAmount) {
        mMinCartAdetAmount = MinCartAdetAmount;
    }

    public Float getMinCartKgAmount() {
        return mMinCartKgAmount;
    }

    public void setMinCartKgAmount(Float MinCartKgAmount) {
        mMinCartKgAmount = MinCartKgAmount;
    }

    public Integer getMinRegistarAge() {
        return mMinRegistarAge;
    }

    public void setMinRegistarAge(Integer MinRegistarAge) {
        mMinRegistarAge = MinRegistarAge;
    }

    public Boolean getQrSearchEnabled() {
        return mQrSearchEnabled;
    }

    public void setQrSearchEnabled(Boolean QrSearchEnabled) {
        mQrSearchEnabled = QrSearchEnabled;
    }

    public Boolean getShowCartProductNote() {
//        return true;
        return mShowCartProductNote;
    }

    public void setShowCartProductNote(Boolean ShowCartProductNote) {
        mShowCartProductNote = ShowCartProductNote;
    }

    public Boolean getShowCityLabels() {
        return mShowCityLabels;
    }

    public void setShowCityLabels(Boolean ShowCityLabels) {
        mShowCityLabels = ShowCityLabels;
    }

    public Boolean getShowSliderOnCampaign() {
        return mShowSliderOnCampaign;
    }

    public void setShowSliderOnCampaign(Boolean ShowSliderOnCampaign) {
        mShowSliderOnCampaign = ShowSliderOnCampaign;
    }

    public Boolean getShowSliderOnCategory() {
        return mShowSliderOnCategory;
    }

    public void setShowSliderOnCategory(Boolean ShowSliderOnCategory) {
        mShowSliderOnCategory = ShowSliderOnCategory;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getLoginUrl() {
        return mLoginUrl == null ? "" : mLoginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        mLoginUrl = loginUrl;
    }

    public String getCmsRegistrationRules() {
        return mCmsRegistrationRules == null ? "" : mCmsRegistrationRules;
    }

    public void setCmsRegistrationRules(String cmsRegistrationRules) {
        mCmsRegistrationRules = cmsRegistrationRules;
    }

    public String getCmsServiceAggreement() {
        return mCmsServiceAggreement == null ? "" : mCmsServiceAggreement;
    }

    public void setCmsServiceAggreement(String cmsServiceAggreement) {
        mCmsServiceAggreement = cmsServiceAggreement;
    }

    public String getCmsContactUs() {
        return mCmsContactUs == null ? "" : mCmsContactUs;
    }

    public void setCmsContactUs(String cmsContactUs) {
        mCmsContactUs = cmsContactUs;
    }

    public String getCmsGeneralRules() {
        return mCmsGeneralRules == null ? "" : mCmsGeneralRules;
    }

    public void setCmsGeneralRules(String cmsGeneralRules) {
        mCmsGeneralRules = cmsGeneralRules;
    }

    public String getCmsFrequentlyAskedQuestions() {
        return mCmsFrequentlyAskedQuestions == null ? "" : mCmsFrequentlyAskedQuestions;
    }

    public void setCmsFrequentlyAskedQuestions(String cmsFrequentlyAskedQuestions) {
        mCmsFrequentlyAskedQuestions = cmsFrequentlyAskedQuestions;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static MarketyoConfig fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, MarketyoConfig.class);
    }
}
