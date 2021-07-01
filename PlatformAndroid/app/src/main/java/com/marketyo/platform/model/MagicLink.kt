package com.marketyo.platform.model

import com.google.gson.annotations.SerializedName

class MagicLink {

    @SerializedName(value = "image")
    var image: String? = null
    @SerializedName(value = "payload", alternate = ["magicLinkPayload"])
    var data: String? = null
    @SerializedName(value = "type")
    var type: String? = null
    @Transient
    var name: String? = ""

    constructor()

    constructor(image: String, type: String, data: String, name: String? = "") {
        this.image = image
        this.data = data
        this.type = type
        this.name = name
    }
}
