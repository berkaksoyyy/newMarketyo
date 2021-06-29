package com.marketyo.platform.utils

import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Createdby MBH on 03/03/2017.
 */
object DateUtils {
    private const val ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss"
    private const val ISO_8601_NO_T = "yyyy-MM-dd HH:mm:ss"
    private const val SERVER_DATETIMEZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
    private const val SERVER_DATE_FORMAT = "yyyy-MM-dd"
    private const val SERVER_DATE_FORMAT_MY_ORDERS = "dd MMMM yyyy"
    private const val SERVER_DATE_FORMAT_PROFILE = "dd.MM.yyyy"
    private const val DATE_COMMENCIS_FORMAT = "dd-MM-yy"
    private const val DATE_FULL_DAY_MONTH_NAME = "dd MMMM yyyy '('EEEE')'"
    private const val DATE_DAY_MONTH_NAME = "dd MMM yyyy '('EEE')'"
    private const val HOUR_MINUTE_FORMATE = "HH:mm"
    private const val CHECKOUT_TIMESLOT_FORMAT = "dd/MM/yyyy"
    private const val WEEKDAY = "EEEE"
    private const val DAY = "dd"

    //    public final static Locale locale = Locale.getDefault();d
    //    public final static Locale userLocale = new Locale("tr");
    var userLocale = Locale("tr")
    fun getWeekday(date: Date?): String {
        if (date == null) return ""
        val sdf = SimpleDateFormat(WEEKDAY, userLocale)
        return sdf.format(date)
    }

    fun getDayNumber(date: Date?): String {
        if (date == null) return ""
        val sdf = SimpleDateFormat(DAY, userLocale)
        return sdf.format(date)
    }

    fun timeslotFormattedDate(date: Date?): String {
        if (date == null) return ""
        val sdf = SimpleDateFormat(CHECKOUT_TIMESLOT_FORMAT, userLocale)
        return sdf.format(date)
    }

    fun serverFormattedDate(date: Date?): String {
        if (date == null) return ""
        val sdf = SimpleDateFormat(SERVER_DATE_FORMAT, userLocale)
        return sdf.format(date)
    }

    fun serverFormattedDateMyOrders(date: Date?): String {
        if (date == null) return ""
        val sdf = SimpleDateFormat(SERVER_DATE_FORMAT_MY_ORDERS, userLocale)
        return sdf.format(date)
    }

    fun serverFormattedDate4Profile(date: Date?): String {
        if (date == null) return ""
        val sdf = SimpleDateFormat(SERVER_DATE_FORMAT_PROFILE, userLocale)
        return sdf.format(date)
    }

    fun serverFullFormattedDate(date: Date?): String {
        if (date == null) return ""
        val sdf = SimpleDateFormat(DATE_FULL_DAY_MONTH_NAME, userLocale)
        return sdf.format(date)
    }

    fun fromServerFormattedDate(dateStr: String?): Date {
        return try {
            SimpleDateFormat(SERVER_DATE_FORMAT, userLocale)
                .parse(dateStr)
        } catch (e: ParseException) {
            Timber.e(e)
            Date()
        }
    }

    fun fromServerFormattedDateProfile(dateStr: String?): Date {
        return try {
            SimpleDateFormat(SERVER_DATE_FORMAT_PROFILE, userLocale)
                .parse(dateStr)
        } catch (e: ParseException) {
            Timber.e(e)
            Date()
        }
    }

    fun fromServerFormattedDateCommencis(dateStr: String?): Date {
        return try {
            SimpleDateFormat(DATE_COMMENCIS_FORMAT, userLocale)
                .parse(dateStr)
        } catch (e: ParseException) {
            Timber.e(e)
            Date()
        }
    }

    fun fromServerFormattedDateTime(dateStr: String?): Date {
        return try {
            SimpleDateFormat(ISO_8601, userLocale)
                .parse(dateStr)
        } catch (e: ParseException) {
            Timber.e(e)
            Date()
        }
    }

    fun fromServerFormattedDateTimeZone(dateStr: String?): Date {
        return try {
            SimpleDateFormat(SERVER_DATETIMEZONE_FORMAT, userLocale)
                .parse(dateStr)
        } catch (e: ParseException) {
            Timber.e(e)
            Date()
        }
    }

    fun fromServerFormattedDateTimeslot(dateStr: String?): Date {
        return try {
            SimpleDateFormat(CHECKOUT_TIMESLOT_FORMAT, userLocale)
                .parse(dateStr)
        } catch (e: ParseException) {
            Timber.e(e)
            Date()
        }
    }

    fun serverFormattedDateTimeZone(date: Date?): String {
        return SimpleDateFormat(SERVER_DATETIMEZONE_FORMAT, userLocale)
            .format(date)
    }

    fun serverFormattedDateNow(): String {
        return serverFormattedDate(Date())
    }

    fun serverFormattedDateTomorrow(): String {
        return serverFormattedDate(addDays(Date(), 1))
    }

    fun serverFormattedDateAfterTomorrow(): String {
        return serverFormattedDate(addDays(Date(), 2))
    }

    fun getHourMin(date: Date?): String {
        return SimpleDateFormat(HOUR_MINUTE_FORMATE, userLocale)
            .format(date)
    }

    fun serverFullFormattedDateNow(): String {
        return serverFullFormattedDate(Date())
    }

    fun serverFullFormattedDateTomorrow(): String {
        return serverFullFormattedDate(addDays(Date(), 1))
    }

    fun serverFullFormattedDateAfterTomorrow(): String {
        return serverFullFormattedDate(addDays(Date(), 2))
    }

    fun get17YearsBeforeNow(): Int {
        return getNYearsBeforeNow(17)
    }

    fun getNYearsBeforeNow(yearsFromNow: Int): Int {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.YEAR, -yearsFromNow)
        return calendar[Calendar.YEAR]
    }

    fun calculateAge(years: Int, month: Int, day: Int): Int {
        val now = Calendar.getInstance()
        var age = now[Calendar.YEAR] - years
        val thisMonth = now[Calendar.MONTH]
        if (thisMonth < month) {
            age--
        } else if (thisMonth == month) {
            val thisDay = now[Calendar.DAY_OF_MONTH]
            if (thisDay < day) {
                age--
            }
        }
        return age
    }

    fun addDays(date: Date?, daysToAdd: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DATE, daysToAdd)
        return calendar.time
    }

    fun fullMonthNameFormatted(date: Date?): String {
        return SimpleDateFormat(DATE_FULL_DAY_MONTH_NAME, userLocale).format(date)
    }

    /**
     * Transform Calendar to ISO 8601 string.
     */
    fun toISO8601(date: Date?): String {
        return SimpleDateFormat(ISO_8601, userLocale)
            .format(date)
    }

    fun fromISO8601(iso8601Str: String?): Date? {
        return try {
            SimpleDateFormat(ISO_8601, userLocale)
                .parse(iso8601Str)
        } catch (e: ParseException) {
            Timber.e(e)
            null
        }
    }

    fun fromISO8601NoT(iso8601Str: String?): Date? {
        return try {
            SimpleDateFormat(ISO_8601_NO_T, userLocale)
                .parse(iso8601Str)
        } catch (e: ParseException) {
            Timber.e(e)
            null
        }
    }
}