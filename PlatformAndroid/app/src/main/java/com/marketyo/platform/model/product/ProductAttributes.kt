/**
 * Marketyo Mobile Api
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.marketyo.platform.model.product

import com.google.gson.annotations.SerializedName

class ProductAttributes {

    @SerializedName("name")
    var name: String? = null
    @SerializedName("value")
    var value: String? = null

    constructor(name: String?, value: String?) {
        this.name = name
        this.value = value
    }
    constructor()
}
