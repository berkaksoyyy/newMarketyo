package com.marketyo.platform.model.core.ads

/**
 * CreatedBy mbh on 10/24/18.
 */

/*
public enum AdsPageType
    {
        Homepage = 1,
        Category = 2,
        Product = 3,
        Checkout = 4,
        Welcome = 5,
        Cart = 6
    }

    public enum AdsPlatform
    {
        Web = 1,
        Mobile = 2
    }

    public enum AdsMagicLinkType
    {
        None = 0,
        Category = 1,
        Product = 2,
        Search = 3,
        Link = 4
    }

    public enum AdsTarget
    {
        None = 0,
        Category = 1,
        Product = 2,
    }

 */
object AdsEnum {
    object Platform {
        @JvmField
        val Web = 1
        @JvmField
        val Mobile = 2
    }
    object Target {
        @JvmField
        val None = 0
        @JvmField
        val Category = 1
        @JvmField
        val Product = 2
    }

    object MagicLinkType {
        @JvmField
        val None = 0
        @JvmField
        val Category = 1
        @JvmField
        val Product = 2
        @JvmField
        val Search = 3
        @JvmField
        val Link = 4
        @JvmField
        val HTML = 5
        @JvmField
        val Promo = 6
    }

    object Page {
        @JvmField
        val Homepage: Int = 1
        @JvmField
        val Category: Int = 2
        @JvmField
        val Product: Int = 3
        @JvmField
        val Checkout: Int = 4
        @JvmField
        val Welcome: Int = 5
        @JvmField
        val Cart: Int = 6
        @JvmField
        val Oppurtunity: Int = 7
    }
}