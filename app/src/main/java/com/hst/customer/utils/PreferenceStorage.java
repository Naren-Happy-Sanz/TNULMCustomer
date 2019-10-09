package com.hst.customer.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Admin on 11-10-2017.
 */

public class PreferenceStorage {

    /*To check welcome screen to launch*/
    public static void setFirstTimeLaunch(Context context, boolean isFirstTime) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SkilExConstants.IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.apply();
    }

    public static boolean isFirstTimeLaunch(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(SkilExConstants.IS_FIRST_TIME_LAUNCH, true);
    }
    /*End*/

    /*To save mobile IMEI number */
    public static void saveIMEI(Context context, String imei) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_IMEI, imei);
        editor.apply();
    }

    public static String getIMEI(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sharedPreferences.getString(SkilExConstants.KEY_IMEI, "");
    }
    /*End*/

    // UserId
    public static void saveUserId(Context context, String userId) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_ID, userId);
        editor.apply();
    }

    public static String getUserId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userId;
        userId = sharedPreferences.getString(SkilExConstants.KEY_USER_ID, "");
        return userId;
    }
    /*End*/

    // User Type
    public static void saveUserType(Context context, String userType) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_TYPE, userType);
        editor.apply();
    }

    public static String getUserType(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userType;
        userType = sharedPreferences.getString(SkilExConstants.KEY_USER_TYPE, "");
        return userType;
    }
    /*End*/

    // UserName
    public static void saveName(Context context, String userName) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_NAME, userName);
        editor.apply();
    }

    public static String getName(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userId;
        userId = sharedPreferences.getString(SkilExConstants.KEY_USER_NAME, "");
        return userId;
    }
    /*End*/

    // UserGender
    public static void saveGender(Context context, String userGender) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_GENDER, userGender);
        editor.apply();
    }

    public static String getGender(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userId;
        userId = sharedPreferences.getString(SkilExConstants.KEY_USER_GENDER, "");
        return userId;
    }
    /*End*/

    // UserAddress
    public static void saveAddress(Context context, String userAddress) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_ADDRESS, userAddress);
        editor.apply();
    }

    public static String getAddress(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userId;
        userId = sharedPreferences.getString(SkilExConstants.KEY_USER_ADDRESS, "");
        return userId;
    }
    /*End*/

    // UserEmail
    public static void saveEmail(Context context, String userEmail) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_MAIL, userEmail);
        editor.apply();
    }

    public static String getEmail(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userId;
        userId = sharedPreferences.getString(SkilExConstants.KEY_USER_MAIL, "");
        return userId;
    }
    /*End*/

    // UserPic
    public static void saveProfilePic(Context context, String userPic) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_PROFILE_PIC, userPic);
        editor.apply();
    }

    public static String getProfilePic(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userId;
        userId = sharedPreferences.getString(SkilExConstants.KEY_USER_PROFILE_PIC, "");
        return userId;
    }
    /*End*/

    // UserEmailVerify
    public static void saveEmailVerify(Context context, String userEmailVerify) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_USER_MAIL_STATUS, userEmailVerify);
        editor.apply();
    }

    public static String getEmailVerify(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String userId;
        userId = sharedPreferences.getString(SkilExConstants.KEY_USER_MAIL_STATUS, "");
        return userId;
    }
    /*End*/

    /*To save FCM key locally*/
    public static void saveGCM(Context context, String gcmId) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_FCM_ID, gcmId);
        editor.apply();
    }

    public static String getGCM(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sharedPreferences.getString(SkilExConstants.KEY_FCM_ID, "");
    }
    /*End*/

    /*To store mobile number*/
    public static void saveMobileNo(Context context, String type) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_MOBILE_NUMBER, type);
        editor.apply();
    }

    public static String getMobileNo(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String mobileNo;
        mobileNo = sharedPreferences.getString(SkilExConstants.KEY_MOBILE_NUMBER, "");
        return mobileNo;
    }
    /*End*/

    /*To store language*/
    public static void saveLang(Context context, String lang) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.KEY_LANGUAGE, lang);
        editor.apply();
    }

    public static String getLang(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String lang;
        lang = sharedPreferences.getString(SkilExConstants.KEY_LANGUAGE, "");
        return lang;
    }
    /*End*/

    /*To store category click*/
    public static void saveCatClick(Context context, String cat) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.MAIN_CATEGORY_ID, cat);
        editor.apply();
    }

    public static String getCatClick(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String catClick;
        catClick = sharedPreferences.getString(SkilExConstants.MAIN_CATEGORY_ID, "");
        return catClick;
    }
    /*End*/

    /*To store category click*/
    public static void saveSubCatClick(Context context, String cat) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.SUB_CATEGORY_ID, cat);
        editor.apply();
    }

    public static String getSubCatClick(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String catClick;
        catClick = sharedPreferences.getString(SkilExConstants.SUB_CATEGORY_ID, "");
        return catClick;
    }
    /*End*/

    /*To store category click*/
    public static void saveAdvanceAmt(Context context, String rate) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.ADVANCE_AMOUNT, rate);
        editor.apply();
    }

    public static String getAdvanceAmt(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String catClick;
        catClick = sharedPreferences.getString(SkilExConstants.ADVANCE_AMOUNT, "");
        return catClick;
    }
    /*End*/

    /*To store category click*/
    public static void saveRate(Context context, String rate) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.SERVICE_RATE, rate);
        editor.apply();
    }

    public static String getRate(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String catClick;
        catClick = sharedPreferences.getString(SkilExConstants.SERVICE_RATE, "");
        return catClick;
    }
    /*End*/

    /*To store category click*/
    public static void saveServiceCount(Context context, String cat) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.SERVICE_COUNT, cat);
        editor.apply();
    }

    public static String getServiceCount(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String catClick;
        catClick = sharedPreferences.getString(SkilExConstants.SERVICE_COUNT, "");
        return catClick;
    }
    /*End*/

    /*To store category click*/
    public static void savePurchaseStatus(Context context, boolean cat) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SkilExConstants.SERVICE_STATUS, cat);
        editor.apply();
    }

    public static boolean getPurchaseStatus(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        boolean catClick;
        catClick = sharedPreferences.getBoolean(SkilExConstants.SERVICE_STATUS, false);
        return catClick;
    }
    /*End*/

    /*To store category click*/
    public static void saveCartStatus(Context context, boolean cat) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SkilExConstants.CART_STATUS, cat);
        editor.apply();
    }

    public static boolean getCartStatus(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        boolean catClick;
        catClick = sharedPreferences.getBoolean(SkilExConstants.CART_STATUS, false);
        return catClick;
    }
    /*End*/

    /*To search*/
    public static void setSearchFor(Context context, String ser) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.SEARCH_STATUS, ser);
        editor.apply();
    }

    public static String getSearchFor(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String ser;
        ser = sharedPreferences.getString(SkilExConstants.SEARCH_STATUS, "");
        return ser;
    }
    /*End*/


    /*To store order id*/
    public static void saveOrderId(Context context, String orderId) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.ORDER_ID, orderId);
        editor.apply();
    }

    public static String getOrderId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String orderId;
        orderId = sharedPreferences.getString(SkilExConstants.ORDER_ID, "");
        return orderId;
    }
    /*End*/

    /*To store order id*/
    public static void saveRateOrderId(Context context, String orderId) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.SERVICE_ID, orderId);
        editor.apply();
    }

    public static String getRateOrderId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String orderId;
        orderId = sharedPreferences.getString(SkilExConstants.SERVICE_ID, "");
        return orderId;
    }
    /*End*/

    /*To store coupon cooment*/
    public static void saveCoupon(Context context, String orderId) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.COUPON_TEXT, orderId);
        editor.apply();
    }

    public static String getCoupon(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String orderId;
        orderId = sharedPreferences.getString(SkilExConstants.COUPON_TEXT, "");
        return orderId;
    }
    /*End*/

    /*To store coupon cooment*/
    public static void savePersonId(Context context, String orderId) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SkilExConstants.COUPON_TEXT, orderId);
        editor.apply();
    }

    public static String getPersonId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        String orderId;
        orderId = sharedPreferences.getString(SkilExConstants.COUPON_TEXT, "");
        return orderId;
    }
    /*End*/


}
