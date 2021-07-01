package com.marketyo.platform.model.request;

import com.google.gson.annotations.SerializedName;

public class SearchRequest {

    /*
    {
        "keyword":"User written words",
        "queryParams":"c=3" // Category number
    }
     */
    @SerializedName("queryParams")
    private String mQueryParams;
    @SerializedName("query")
    private String mQuery;

    private SearchRequest(String query, String queryParams) {
        this.mQueryParams = queryParams;
        this.mQuery = query;
    }

    public static SearchRequest categorySearchRequest(String query, String categoryId) {
        return new SearchRequest(query, "c=" + categoryId);
    }

    public static SearchRequest qrcodeSearchRequest(String query) {
        return new SearchRequest(query, "qr=true");
    }

    public String getQueryParams() {
        return mQueryParams;
    }

    public void setQueryParams(String queryParams) {
        mQueryParams = queryParams;
    }

    public String getQuery() {
        return mQuery;
    }

    public void setQuery(String query) {
        mQuery = query;
    }
}
