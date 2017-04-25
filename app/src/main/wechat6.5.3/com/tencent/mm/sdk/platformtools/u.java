package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class u {
    public static Locale nik = Locale.getDefault();

    public static boolean Kd(String str) {
        if (be.kS(str)) {
            return false;
        }
        if (str.equalsIgnoreCase("zh_TW") || str.equalsIgnoreCase("zh_HK") || str.equalsIgnoreCase("zh_CN") || str.equalsIgnoreCase("en") || str.equalsIgnoreCase("th") || str.equals("id") || str.equals("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("he") || str.equalsIgnoreCase("pl") || str.equalsIgnoreCase("hi") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            return true;
        }
        return false;
    }

    public static boolean bsU() {
        String bsY = bsY();
        return bsY.equals("zh_CN") || bsY.equals("zh_TW") || bsY.equals("zh_HK");
    }

    public static boolean bsV() {
        if (bsY().equals("zh_CN")) {
            return true;
        }
        return false;
    }

    public static boolean bsW() {
        return bsY().equals("zh_TW") || bsY().equals("zh_HK");
    }

    public static void a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (!configuration.locale.equals(locale)) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
            Resources.getSystem().updateConfiguration(configuration, displayMetrics);
        }
    }

    public static Locale Ke(String str) {
        if (str.equals("zh_TW")) {
            return Locale.TAIWAN;
        }
        if (str.equals("zh_HK")) {
            return new Locale("zh", "HK");
        }
        if (str.equals("en")) {
            return Locale.ENGLISH;
        }
        if (str.equals("zh_CN")) {
            return Locale.CHINA;
        }
        if (str.equalsIgnoreCase("th") || str.equalsIgnoreCase("id") || str.equalsIgnoreCase("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("he") || str.equalsIgnoreCase("pl") || str.equalsIgnoreCase("hi") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            return new Locale(str);
        }
        if (str.equalsIgnoreCase("in_ID")) {
            return new Locale("id");
        }
        v.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = " + str);
        return Locale.ENGLISH;
    }

    public static void b(Configuration configuration) {
        if (VERSION.SDK_INT >= 24 && configuration != null) {
            Locale.setDefault(configuration.locale);
            nik = Locale.getDefault();
            v.i("MicroMsg.LocaleUtil", "current locale:%s", nik);
        }
    }

    public static String bsX() {
        return Locale.getDefault().getCountry().trim();
    }

    private static String Kf(String str) {
        String trim = Locale.getDefault().getLanguage().trim();
        String str2 = trim + "_" + Locale.getDefault().getCountry().trim();
        if (trim.equals("en")) {
            return trim;
        }
        if (str2.equals("zh_TW")) {
            return "zh_TW";
        }
        if (str2.equals("zh_HK")) {
            return "zh_HK";
        }
        if (str2.equals("zh_CN")) {
            return "zh_CN";
        }
        if (trim.equals("th")) {
            return "th";
        }
        if (trim.equals("id")) {
            return "id";
        }
        if (str2.equals("in_ID")) {
            return "id";
        }
        if (trim.equals("vi")) {
            return "vi";
        }
        if (trim.equals("pt")) {
            return "pt";
        }
        if (trim.equals("es")) {
            return "es";
        }
        if (trim.equals("ru")) {
            return "ru";
        }
        if (trim.equals("ar")) {
            return "ar";
        }
        if (trim.equals("he")) {
            return "he";
        }
        if (trim.equals("pl")) {
            return "pl";
        }
        if (trim.equals("hi")) {
            return "hi";
        }
        if (trim.equals("ja")) {
            return "ja";
        }
        if (trim.equals("it")) {
            return "it";
        }
        if (trim.equals("ko")) {
            return "ko";
        }
        if (trim.equals("ms")) {
            return "ms";
        }
        if (trim.equals("tr")) {
            return "tr";
        }
        if (trim.equals("de")) {
            return "de";
        }
        if (trim.equals("fr")) {
            return "fr";
        }
        if (trim.equals("my")) {
            return "my";
        }
        if (trim.equals("lo")) {
            return "lo";
        }
        return str;
    }

    public static String bsY() {
        String ma = be.ma(ba.getProperty("language_key"));
        return (ma.length() <= 0 || ma.equals("language_default")) ? Kf("en") : ma;
    }

    public static String d(SharedPreferences sharedPreferences) {
        String ma = be.ma(sharedPreferences.getString("language_key", null));
        if (ma.length() <= 0 || ma.equals("language_default")) {
            ma = Kf("en");
            ba.setProperty("language_key", ma);
            return ma;
        }
        ba.setProperty("language_key", ma);
        return ma;
    }

    public static String e(SharedPreferences sharedPreferences) {
        String ma = be.ma(sharedPreferences.getString("language_key", null));
        return !be.kS(ma) ? ma : "language_default";
    }

    public static void a(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences.edit().putString("language_key", str).commit()) {
            ba.setProperty("language_key", str);
            v.w("MicroMsg.LocaleUtil", "save application lang as:" + str);
            return;
        }
        v.e("MicroMsg.LocaleUtil", "saving application lang failed");
    }

    public static String dJ(Context context) {
        String e = e(context.getSharedPreferences(aa.bti(), 0));
        return e.equalsIgnoreCase("language_default") ? bsY() : e;
    }

    public static String dK(Context context) {
        int i = 0;
        String[] stringArray = context.getResources().getStringArray(2131296281);
        String e = e(context.getSharedPreferences(aa.bti(), 0));
        if (e == null) {
            return context.getString(2131231082);
        }
        String[] strArr = t.iMe;
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            if (strArr[i].equals(e)) {
                return stringArray[i2];
            }
            i2++;
            i++;
        }
        return context.getString(2131231082);
    }
}
