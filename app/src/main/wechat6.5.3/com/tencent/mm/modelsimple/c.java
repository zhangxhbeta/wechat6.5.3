package com.tencent.mm.modelsimple;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Profile;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public final class c {
    @TargetApi(14)
    public static String x(Context context, String str) {
        String networkCountryIso;
        Throwable th;
        Throwable th2;
        String str2;
        String str3;
        Cursor query;
        int columnIndex;
        int i;
        Cursor cursor;
        Throwable e;
        Cursor cursor2;
        v.i("MicroMsg.ContactsUtil", "Get phone number. country code : %s", str);
        if (context == null) {
            v.e("MicroMsg.ContactsUtil", "The context is null.");
            return null;
        }
        ContentResolver contentResolver;
        Cursor query2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str4 = null;
        String str5 = null;
        try {
            str4 = telephonyManager.getLine1Number();
            str5 = telephonyManager.getSimCountryIso();
            try {
                if (be.kS(str5)) {
                    networkCountryIso = telephonyManager.getNetworkCountryIso();
                } else {
                    networkCountryIso = str5;
                }
            } catch (Throwable e2) {
                th = e2;
                networkCountryIso = str5;
                th2 = th;
                v.a("MicroMsg.ContactsUtil", th2, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.ContactsUtil", "get line number got exception");
                str2 = networkCountryIso;
                networkCountryIso = str4;
                if (be.kS(networkCountryIso)) {
                    str4 = networkCountryIso.trim();
                    networkCountryIso = al.dA(str4, str2);
                    v.i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str4, networkCountryIso, str2);
                    if (be.kS(networkCountryIso)) {
                        networkCountryIso = str4;
                    } else {
                        networkCountryIso = str4.substring((str4.startsWith("+") ? 0 : 1) + networkCountryIso.length());
                        v.i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
                    }
                    v.i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
                    return networkCountryIso;
                } else if (a.aP(context, "android.permission.READ_CONTACTS")) {
                    contentResolver = context.getContentResolver();
                    str3 = null;
                    if (!f.dX(14)) {
                        v.i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                        try {
                            query = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                            if (query != null) {
                                try {
                                    if (query.moveToFirst()) {
                                        columnIndex = query.getColumnIndex("has_phone_number");
                                        if (columnIndex != -1) {
                                            i = query.getInt(columnIndex);
                                            v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                                            cursor = query;
                                            cursor.close();
                                            if (i > 0) {
                                                try {
                                                    query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                                    if (query != null) {
                                                        try {
                                                            if (query.moveToFirst()) {
                                                                columnIndex = query.getColumnIndex("data1");
                                                                if (columnIndex != -1) {
                                                                    v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                                                    str4 = query.getString(columnIndex);
                                                                    query.close();
                                                                }
                                                            }
                                                            str4 = null;
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            cursor2 = query;
                                                            v.a("MicroMsg.ContactsUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                                            v.d("MicroMsg.ContactsUtil", "query crashed");
                                                            query = cursor2;
                                                            query.close();
                                                            if (be.kS(str3)) {
                                                                if (!be.kS(y(context, d.be(context)))) {
                                                                    cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                                                                    if (cursor2 == null) {
                                                                        columnIndex = 0;
                                                                    } else {
                                                                        if (cursor2.moveToFirst()) {
                                                                            columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                                                        } else {
                                                                            columnIndex = 0;
                                                                        }
                                                                        cursor2.close();
                                                                    }
                                                                    v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                    if (columnIndex > 0) {
                                                                        query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                                                        if (query2 != null) {
                                                                            if (query2.moveToFirst()) {
                                                                                do {
                                                                                    str3 = query2.getString(query2.getColumnIndex("data1"));
                                                                                    if (!be.kS(str3)) {
                                                                                        v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                        break;
                                                                                    }
                                                                                } while (query2.moveToNext());
                                                                            }
                                                                            query2.close();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!be.kS(str3)) {
                                                                networkCountryIso = al.dA(str3, str2);
                                                                v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                                                if (!be.kS(networkCountryIso)) {
                                                                    if (str3.startsWith("+")) {
                                                                        networkCountryIso = "+" + networkCountryIso;
                                                                    } else if (!str3.startsWith(networkCountryIso)) {
                                                                        networkCountryIso = null;
                                                                    }
                                                                    if (networkCountryIso != null) {
                                                                        str3 = str3.substring(networkCountryIso.length());
                                                                    }
                                                                }
                                                                v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                                            }
                                                            return str3;
                                                        }
                                                        try {
                                                            query.close();
                                                        } catch (Throwable th22) {
                                                            str3 = str4;
                                                            e = th22;
                                                            cursor2 = query;
                                                            v.a("MicroMsg.ContactsUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                                            v.d("MicroMsg.ContactsUtil", "query crashed");
                                                            query = cursor2;
                                                            query.close();
                                                            if (be.kS(str3)) {
                                                                if (be.kS(y(context, d.be(context)))) {
                                                                    cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                                                                    if (cursor2 == null) {
                                                                        columnIndex = 0;
                                                                    } else {
                                                                        if (cursor2.moveToFirst()) {
                                                                            columnIndex = 0;
                                                                        } else {
                                                                            columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                                                        }
                                                                        cursor2.close();
                                                                    }
                                                                    v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                    if (columnIndex > 0) {
                                                                        query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                                                        if (query2 != null) {
                                                                            if (query2.moveToFirst()) {
                                                                                do {
                                                                                    str3 = query2.getString(query2.getColumnIndex("data1"));
                                                                                    if (!be.kS(str3)) {
                                                                                        v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                        break;
                                                                                    }
                                                                                } while (query2.moveToNext());
                                                                            }
                                                                            query2.close();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (be.kS(str3)) {
                                                                networkCountryIso = al.dA(str3, str2);
                                                                v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                                                if (be.kS(networkCountryIso)) {
                                                                    if (str3.startsWith("+")) {
                                                                        networkCountryIso = "+" + networkCountryIso;
                                                                    } else if (str3.startsWith(networkCountryIso)) {
                                                                        networkCountryIso = null;
                                                                    }
                                                                    if (networkCountryIso != null) {
                                                                        str3 = str3.substring(networkCountryIso.length());
                                                                    }
                                                                }
                                                                v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                                            }
                                                            return str3;
                                                        }
                                                    }
                                                    str4 = null;
                                                    str3 = str4;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    cursor2 = cursor;
                                                    v.a("MicroMsg.ContactsUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                                    v.d("MicroMsg.ContactsUtil", "query crashed");
                                                    query = cursor2;
                                                    query.close();
                                                    if (be.kS(str3)) {
                                                        if (be.kS(y(context, d.be(context)))) {
                                                            cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                                                            if (cursor2 == null) {
                                                                if (cursor2.moveToFirst()) {
                                                                    columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                                                } else {
                                                                    columnIndex = 0;
                                                                }
                                                                cursor2.close();
                                                            } else {
                                                                columnIndex = 0;
                                                            }
                                                            v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                            if (columnIndex > 0) {
                                                                query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                                                if (query2 != null) {
                                                                    if (query2.moveToFirst()) {
                                                                        do {
                                                                            str3 = query2.getString(query2.getColumnIndex("data1"));
                                                                            if (!be.kS(str3)) {
                                                                                v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                break;
                                                                            }
                                                                        } while (query2.moveToNext());
                                                                    }
                                                                    query2.close();
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (be.kS(str3)) {
                                                        networkCountryIso = al.dA(str3, str2);
                                                        v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                                        if (be.kS(networkCountryIso)) {
                                                            if (str3.startsWith("+")) {
                                                                networkCountryIso = "+" + networkCountryIso;
                                                            } else if (str3.startsWith(networkCountryIso)) {
                                                                networkCountryIso = null;
                                                            }
                                                            if (networkCountryIso != null) {
                                                                str3 = str3.substring(networkCountryIso.length());
                                                            }
                                                        }
                                                        v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                                    }
                                                    return str3;
                                                }
                                                query.close();
                                            }
                                        }
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    i = 0;
                                    v.a("MicroMsg.ContactsUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    v.d("MicroMsg.ContactsUtil", "query crashed");
                                    cursor = query;
                                    cursor.close();
                                    if (i > 0) {
                                        query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                        if (query != null) {
                                            if (query.moveToFirst()) {
                                                columnIndex = query.getColumnIndex("data1");
                                                if (columnIndex != -1) {
                                                    v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                                    str4 = query.getString(columnIndex);
                                                    query.close();
                                                }
                                            }
                                            str4 = null;
                                            query.close();
                                        } else {
                                            str4 = null;
                                        }
                                        str3 = str4;
                                        query.close();
                                    }
                                    if (be.kS(str3)) {
                                        if (be.kS(y(context, d.be(context)))) {
                                            cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                                            if (cursor2 == null) {
                                                columnIndex = 0;
                                            } else {
                                                if (cursor2.moveToFirst()) {
                                                    columnIndex = 0;
                                                } else {
                                                    columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                                }
                                                cursor2.close();
                                            }
                                            v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                            if (columnIndex > 0) {
                                                query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                                if (query2 != null) {
                                                    if (query2.moveToFirst()) {
                                                        do {
                                                            str3 = query2.getString(query2.getColumnIndex("data1"));
                                                            if (!be.kS(str3)) {
                                                                v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                break;
                                                            }
                                                        } while (query2.moveToNext());
                                                    }
                                                    query2.close();
                                                }
                                            }
                                        }
                                    }
                                    if (be.kS(str3)) {
                                        networkCountryIso = al.dA(str3, str2);
                                        v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                        if (be.kS(networkCountryIso)) {
                                            if (str3.startsWith("+")) {
                                                networkCountryIso = "+" + networkCountryIso;
                                            } else if (str3.startsWith(networkCountryIso)) {
                                                networkCountryIso = null;
                                            }
                                            if (networkCountryIso != null) {
                                                str3 = str3.substring(networkCountryIso.length());
                                            }
                                        }
                                        v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                    }
                                    return str3;
                                }
                            }
                            i = 0;
                            try {
                                v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                                cursor = query;
                            } catch (Exception e6) {
                                e = e6;
                                v.a("MicroMsg.ContactsUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.d("MicroMsg.ContactsUtil", "query crashed");
                                cursor = query;
                                cursor.close();
                                if (i > 0) {
                                    query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                    if (query != null) {
                                        str4 = null;
                                    } else {
                                        if (query.moveToFirst()) {
                                            columnIndex = query.getColumnIndex("data1");
                                            if (columnIndex != -1) {
                                                v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                                str4 = query.getString(columnIndex);
                                                query.close();
                                            }
                                        }
                                        str4 = null;
                                        query.close();
                                    }
                                    str3 = str4;
                                    query.close();
                                }
                                if (be.kS(str3)) {
                                    if (be.kS(y(context, d.be(context)))) {
                                        cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                                        if (cursor2 == null) {
                                            columnIndex = 0;
                                        } else {
                                            if (cursor2.moveToFirst()) {
                                                columnIndex = 0;
                                            } else {
                                                columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                            }
                                            cursor2.close();
                                        }
                                        v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                        if (columnIndex > 0) {
                                            query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                            if (query2 != null) {
                                                if (query2.moveToFirst()) {
                                                    do {
                                                        str3 = query2.getString(query2.getColumnIndex("data1"));
                                                        if (!be.kS(str3)) {
                                                            v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                            break;
                                                        }
                                                    } while (query2.moveToNext());
                                                }
                                                query2.close();
                                            }
                                        }
                                    }
                                }
                                if (be.kS(str3)) {
                                    networkCountryIso = al.dA(str3, str2);
                                    v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                    if (be.kS(networkCountryIso)) {
                                        if (str3.startsWith("+")) {
                                            networkCountryIso = "+" + networkCountryIso;
                                        } else if (str3.startsWith(networkCountryIso)) {
                                            networkCountryIso = null;
                                        }
                                        if (networkCountryIso != null) {
                                            str3 = str3.substring(networkCountryIso.length());
                                        }
                                    }
                                    v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                }
                                return str3;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            i = 0;
                            query = null;
                            v.a("MicroMsg.ContactsUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.d("MicroMsg.ContactsUtil", "query crashed");
                            cursor = query;
                            cursor.close();
                            if (i > 0) {
                                query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                if (query != null) {
                                    if (query.moveToFirst()) {
                                        columnIndex = query.getColumnIndex("data1");
                                        if (columnIndex != -1) {
                                            v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                            str4 = query.getString(columnIndex);
                                            query.close();
                                        }
                                    }
                                    str4 = null;
                                    query.close();
                                } else {
                                    str4 = null;
                                }
                                str3 = str4;
                                query.close();
                            }
                            if (be.kS(str3)) {
                                if (be.kS(y(context, d.be(context)))) {
                                    cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                                    if (cursor2 == null) {
                                        if (cursor2.moveToFirst()) {
                                            columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                        } else {
                                            columnIndex = 0;
                                        }
                                        cursor2.close();
                                    } else {
                                        columnIndex = 0;
                                    }
                                    v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                    if (columnIndex > 0) {
                                        query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                        if (query2 != null) {
                                            if (query2.moveToFirst()) {
                                                do {
                                                    str3 = query2.getString(query2.getColumnIndex("data1"));
                                                    if (!be.kS(str3)) {
                                                        v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                        break;
                                                    }
                                                } while (query2.moveToNext());
                                            }
                                            query2.close();
                                        }
                                    }
                                }
                            }
                            if (be.kS(str3)) {
                                networkCountryIso = al.dA(str3, str2);
                                v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                if (be.kS(networkCountryIso)) {
                                    if (str3.startsWith("+")) {
                                        networkCountryIso = "+" + networkCountryIso;
                                    } else if (str3.startsWith(networkCountryIso)) {
                                        networkCountryIso = null;
                                    }
                                    if (networkCountryIso != null) {
                                        str3 = str3.substring(networkCountryIso.length());
                                    }
                                }
                                v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                            }
                            return str3;
                        }
                        cursor.close();
                        if (i > 0) {
                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                            if (query != null) {
                                str4 = null;
                            } else {
                                if (query.moveToFirst()) {
                                    columnIndex = query.getColumnIndex("data1");
                                    if (columnIndex != -1) {
                                        v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                        str4 = query.getString(columnIndex);
                                        query.close();
                                    }
                                }
                                str4 = null;
                                query.close();
                            }
                            str3 = str4;
                            query.close();
                        }
                    }
                    if (be.kS(str3)) {
                        if (be.kS(y(context, d.be(context)))) {
                            cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                            if (cursor2 == null) {
                                columnIndex = 0;
                            } else {
                                if (cursor2.moveToFirst()) {
                                    columnIndex = 0;
                                } else {
                                    columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                }
                                cursor2.close();
                            }
                            v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                            if (columnIndex > 0) {
                                query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                if (query2 != null) {
                                    if (query2.moveToFirst()) {
                                        do {
                                            str3 = query2.getString(query2.getColumnIndex("data1"));
                                            if (!be.kS(str3)) {
                                                v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                break;
                                            }
                                        } while (query2.moveToNext());
                                    }
                                    query2.close();
                                }
                            }
                        }
                    }
                    if (be.kS(str3)) {
                        networkCountryIso = al.dA(str3, str2);
                        v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                        if (be.kS(networkCountryIso)) {
                            if (str3.startsWith("+")) {
                                networkCountryIso = "+" + networkCountryIso;
                            } else if (str3.startsWith(networkCountryIso)) {
                                networkCountryIso = null;
                            }
                            if (networkCountryIso != null) {
                                str3 = str3.substring(networkCountryIso.length());
                            }
                        }
                        v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                    }
                    return str3;
                } else {
                    v.e("MicroMsg.ContactsUtil", "no contact permission");
                    return null;
                }
            }
            try {
                if (be.kS(networkCountryIso)) {
                    networkCountryIso = Locale.getDefault().getCountry();
                }
                str2 = networkCountryIso;
                networkCountryIso = str4;
            } catch (Exception e8) {
                th22 = e8;
                v.a("MicroMsg.ContactsUtil", th22, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.ContactsUtil", "get line number got exception");
                str2 = networkCountryIso;
                networkCountryIso = str4;
                if (be.kS(networkCountryIso)) {
                    str4 = networkCountryIso.trim();
                    networkCountryIso = al.dA(str4, str2);
                    v.i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str4, networkCountryIso, str2);
                    if (be.kS(networkCountryIso)) {
                        networkCountryIso = str4;
                    } else {
                        if (str4.startsWith("+")) {
                        }
                        networkCountryIso = str4.substring((str4.startsWith("+") ? 0 : 1) + networkCountryIso.length());
                        v.i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
                    }
                    v.i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
                    return networkCountryIso;
                } else if (a.aP(context, "android.permission.READ_CONTACTS")) {
                    contentResolver = context.getContentResolver();
                    str3 = null;
                    if (f.dX(14)) {
                        v.i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                        query = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                        if (query != null) {
                            if (query.moveToFirst()) {
                                columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex != -1) {
                                    i = query.getInt(columnIndex);
                                    v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                                    cursor = query;
                                    cursor.close();
                                    if (i > 0) {
                                        query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                        if (query != null) {
                                            str4 = null;
                                        } else {
                                            if (query.moveToFirst()) {
                                                columnIndex = query.getColumnIndex("data1");
                                                if (columnIndex != -1) {
                                                    v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                                    str4 = query.getString(columnIndex);
                                                    query.close();
                                                }
                                            }
                                            str4 = null;
                                            query.close();
                                        }
                                        str3 = str4;
                                        query.close();
                                    }
                                }
                            }
                        }
                        i = 0;
                        v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                        cursor = query;
                        cursor.close();
                        if (i > 0) {
                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                            if (query != null) {
                                if (query.moveToFirst()) {
                                    columnIndex = query.getColumnIndex("data1");
                                    if (columnIndex != -1) {
                                        v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                        str4 = query.getString(columnIndex);
                                        query.close();
                                    }
                                }
                                str4 = null;
                                query.close();
                            } else {
                                str4 = null;
                            }
                            str3 = str4;
                            query.close();
                        }
                    }
                    if (be.kS(str3)) {
                        if (be.kS(y(context, d.be(context)))) {
                            cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                            if (cursor2 == null) {
                                if (cursor2.moveToFirst()) {
                                    columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                                } else {
                                    columnIndex = 0;
                                }
                                cursor2.close();
                            } else {
                                columnIndex = 0;
                            }
                            v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                            if (columnIndex > 0) {
                                query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                                if (query2 != null) {
                                    if (query2.moveToFirst()) {
                                        do {
                                            str3 = query2.getString(query2.getColumnIndex("data1"));
                                            if (!be.kS(str3)) {
                                                v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                break;
                                            }
                                        } while (query2.moveToNext());
                                    }
                                    query2.close();
                                }
                            }
                        }
                    }
                    if (be.kS(str3)) {
                        networkCountryIso = al.dA(str3, str2);
                        v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                        if (be.kS(networkCountryIso)) {
                            if (str3.startsWith("+")) {
                                networkCountryIso = "+" + networkCountryIso;
                            } else if (str3.startsWith(networkCountryIso)) {
                                networkCountryIso = null;
                            }
                            if (networkCountryIso != null) {
                                str3 = str3.substring(networkCountryIso.length());
                            }
                        }
                        v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                    }
                    return str3;
                } else {
                    v.e("MicroMsg.ContactsUtil", "no contact permission");
                    return null;
                }
            }
        } catch (Throwable e22) {
            th = e22;
            networkCountryIso = str5;
            th22 = th;
            v.a("MicroMsg.ContactsUtil", th22, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.ContactsUtil", "get line number got exception");
            str2 = networkCountryIso;
            networkCountryIso = str4;
            if (be.kS(networkCountryIso)) {
                str4 = networkCountryIso.trim();
                networkCountryIso = al.dA(str4, str2);
                v.i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str4, networkCountryIso, str2);
                if (be.kS(networkCountryIso)) {
                    if (str4.startsWith("+")) {
                    }
                    networkCountryIso = str4.substring((str4.startsWith("+") ? 0 : 1) + networkCountryIso.length());
                    v.i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
                } else {
                    networkCountryIso = str4;
                }
                v.i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
                return networkCountryIso;
            } else if (a.aP(context, "android.permission.READ_CONTACTS")) {
                v.e("MicroMsg.ContactsUtil", "no contact permission");
                return null;
            } else {
                contentResolver = context.getContentResolver();
                str3 = null;
                if (f.dX(14)) {
                    v.i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                    query = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            columnIndex = query.getColumnIndex("has_phone_number");
                            if (columnIndex != -1) {
                                i = query.getInt(columnIndex);
                                v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                                cursor = query;
                                cursor.close();
                                if (i > 0) {
                                    query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                    if (query != null) {
                                        if (query.moveToFirst()) {
                                            columnIndex = query.getColumnIndex("data1");
                                            if (columnIndex != -1) {
                                                v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                                str4 = query.getString(columnIndex);
                                                query.close();
                                            }
                                        }
                                        str4 = null;
                                        query.close();
                                    } else {
                                        str4 = null;
                                    }
                                    str3 = str4;
                                    query.close();
                                }
                            }
                        }
                    }
                    i = 0;
                    v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                    cursor = query;
                    cursor.close();
                    if (i > 0) {
                        query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                        if (query != null) {
                            str4 = null;
                        } else {
                            if (query.moveToFirst()) {
                                columnIndex = query.getColumnIndex("data1");
                                if (columnIndex != -1) {
                                    v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                    str4 = query.getString(columnIndex);
                                    query.close();
                                }
                            }
                            str4 = null;
                            query.close();
                        }
                        str3 = str4;
                        query.close();
                    }
                }
                if (be.kS(str3)) {
                    if (be.kS(y(context, d.be(context)))) {
                        cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                        if (cursor2 == null) {
                            if (cursor2.moveToFirst()) {
                                columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                            } else {
                                columnIndex = 0;
                            }
                            cursor2.close();
                        } else {
                            columnIndex = 0;
                        }
                        v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                        if (columnIndex > 0) {
                            query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                            if (query2 != null) {
                                if (query2.moveToFirst()) {
                                    do {
                                        str3 = query2.getString(query2.getColumnIndex("data1"));
                                        if (!be.kS(str3)) {
                                            v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                            break;
                                        }
                                    } while (query2.moveToNext());
                                }
                                query2.close();
                            }
                        }
                    }
                }
                if (be.kS(str3)) {
                    networkCountryIso = al.dA(str3, str2);
                    v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                    if (be.kS(networkCountryIso)) {
                        if (str3.startsWith("+")) {
                            networkCountryIso = "+" + networkCountryIso;
                        } else if (str3.startsWith(networkCountryIso)) {
                            networkCountryIso = null;
                        }
                        if (networkCountryIso != null) {
                            str3 = str3.substring(networkCountryIso.length());
                        }
                    }
                    v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                }
                return str3;
            }
        }
        if (be.kS(networkCountryIso)) {
            str4 = networkCountryIso.trim();
            networkCountryIso = al.dA(str4, str2);
            v.i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str4, networkCountryIso, str2);
            if (be.kS(networkCountryIso)) {
                if (str4.startsWith("+")) {
                }
                networkCountryIso = str4.substring((str4.startsWith("+") ? 0 : 1) + networkCountryIso.length());
                v.i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
            } else {
                networkCountryIso = str4;
            }
            v.i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
            return networkCountryIso;
        } else if (a.aP(context, "android.permission.READ_CONTACTS")) {
            v.e("MicroMsg.ContactsUtil", "no contact permission");
            return null;
        } else {
            contentResolver = context.getContentResolver();
            str3 = null;
            if (f.dX(14)) {
                v.i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                query = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        columnIndex = query.getColumnIndex("has_phone_number");
                        if (columnIndex != -1) {
                            i = query.getInt(columnIndex);
                            v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                            cursor = query;
                            if (!(cursor == null || cursor.isClosed())) {
                                cursor.close();
                            }
                            if (i > 0) {
                                query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                if (query != null) {
                                    if (query.moveToFirst()) {
                                        columnIndex = query.getColumnIndex("data1");
                                        if (columnIndex != -1) {
                                            v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                            str4 = query.getString(columnIndex);
                                            query.close();
                                        }
                                    }
                                    str4 = null;
                                    query.close();
                                } else {
                                    str4 = null;
                                }
                                str3 = str4;
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                            }
                        }
                    }
                }
                i = 0;
                v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                cursor = query;
                cursor.close();
                if (i > 0) {
                    query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                    if (query != null) {
                        str4 = null;
                    } else {
                        if (query.moveToFirst()) {
                            columnIndex = query.getColumnIndex("data1");
                            if (columnIndex != -1) {
                                v.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", query.getString(columnIndex));
                                str4 = query.getString(columnIndex);
                                query.close();
                            }
                        }
                        str4 = null;
                        query.close();
                    }
                    str3 = str4;
                    query.close();
                }
            }
            if (be.kS(str3)) {
                if (be.kS(y(context, d.be(context)))) {
                    cursor2 = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{y(context, d.be(context))}, null);
                    if (cursor2 == null) {
                        if (cursor2.moveToFirst()) {
                            columnIndex = cursor2.getInt(cursor2.getColumnIndex("has_phone_number"));
                        } else {
                            columnIndex = 0;
                        }
                        cursor2.close();
                    } else {
                        columnIndex = 0;
                    }
                    v.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                    if (columnIndex > 0) {
                        query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r9}, null);
                        if (query2 != null) {
                            if (query2.moveToFirst()) {
                                do {
                                    str3 = query2.getString(query2.getColumnIndex("data1"));
                                    if (!be.kS(str3)) {
                                        v.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                        break;
                                    }
                                } while (query2.moveToNext());
                            }
                            query2.close();
                        }
                    }
                }
            }
            if (be.kS(str3)) {
                networkCountryIso = al.dA(str3, str2);
                v.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                if (be.kS(networkCountryIso)) {
                    if (str3.startsWith("+")) {
                        networkCountryIso = "+" + networkCountryIso;
                    } else if (str3.startsWith(networkCountryIso)) {
                        networkCountryIso = null;
                    }
                    if (networkCountryIso != null) {
                        str3 = str3.substring(networkCountryIso.length());
                    }
                }
                v.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
            }
            return str3;
        }
    }

    private static String y(Context context, String str) {
        String str2;
        Throwable th;
        String str3 = null;
        v.i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", str);
        if (context == null) {
            v.e("MicroMsg.ContactsUtil", "context is null.");
            return null;
        } else if (be.kS(str)) {
            v.i("MicroMsg.ContactsUtil", "email is null.");
            return null;
        } else {
            try {
                Cursor query = context.getContentResolver().query(Email.CONTENT_URI, new String[]{"contact_id", "data1"}, "data1=?", new String[]{str}, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        do {
                            try {
                                str3 = query.getString(query.getColumnIndex("contact_id"));
                                if (!be.kS(str3)) {
                                    v.i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", str3);
                                    str2 = str3;
                                    break;
                                }
                            } catch (Throwable e) {
                                th = e;
                                str2 = str3;
                            }
                        } while (query.moveToNext());
                        str2 = str3;
                    } else {
                        str2 = null;
                    }
                    try {
                        query.close();
                    } catch (Exception e2) {
                        th = e2;
                        v.a("MicroMsg.ContactsUtil", th, "getContactIdByEmail error", new Object[0]);
                        return str2;
                    }
                }
                str2 = null;
            } catch (Throwable e3) {
                th = e3;
                str2 = null;
                v.a("MicroMsg.ContactsUtil", th, "getContactIdByEmail error", new Object[0]);
                return str2;
            }
            return str2;
        }
    }

    @TargetApi(14)
    public static String aV(Context context) {
        v.i("MicroMsg.ContactsUtil", "Get name of a contacts record or profile.");
        if (context == null) {
            v.e("MicroMsg.ContactsUtil", "context is null.");
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (a.aP(context, "android.permission.READ_CONTACTS")) {
            String str;
            Cursor query;
            if (f.dW(14)) {
                Cursor query2;
                v.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
                try {
                    query2 = contentResolver.query(Profile.CONTENT_URI, new String[]{"display_name"}, null, null, null);
                } catch (Throwable e) {
                    v.a("MicroMsg.ContactsUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.d("MicroMsg.ContactsUtil", "query crashed");
                    query2 = null;
                }
                if (query2 != null) {
                    String string;
                    if (query2.moveToFirst()) {
                        string = query2.getString(query2.getColumnIndex("display_name"));
                        v.i("MicroMsg.ContactsUtil", "Have got name from profile, name is %s", string);
                    } else {
                        string = null;
                    }
                    query2.close();
                    str = string;
                    if (be.kS(str)) {
                        if (be.kS(y(context, d.be(context)))) {
                            query = contentResolver.query(Data.CONTENT_URI, new String[]{"display_name"}, "contact_id=?", new String[]{r5}, null);
                            if (query != null) {
                                if (query.moveToFirst()) {
                                    str = query.getString(query.getColumnIndex("display_name"));
                                    v.i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", str);
                                }
                                query.close();
                            }
                        } else {
                            v.i("MicroMsg.ContactsUtil", "contactId is null.");
                            return null;
                        }
                    }
                    return str;
                }
            }
            str = null;
            if (be.kS(str)) {
                if (be.kS(y(context, d.be(context)))) {
                    query = contentResolver.query(Data.CONTENT_URI, new String[]{"display_name"}, "contact_id=?", new String[]{r5}, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndex("display_name"));
                            v.i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", str);
                        }
                        query.close();
                    }
                } else {
                    v.i("MicroMsg.ContactsUtil", "contactId is null.");
                    return null;
                }
            }
            return str;
        }
        v.e("MicroMsg.ContactsUtil", "no contact permission");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(14)
    public static android.graphics.Bitmap aW(android.content.Context r13) {
        /*
        r0 = "MicroMsg.ContactsUtil";
        r1 = "Get bitmap of a contacts record or profile.";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        if (r13 != 0) goto L_0x0016;
    L_0x000b:
        r0 = "MicroMsg.ContactsUtil";
        r1 = "context is null.";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r1 = 0;
    L_0x0015:
        return r1;
    L_0x0016:
        r0 = r13.getContentResolver();
        r6 = 0;
        r1 = "android.permission.READ_CONTACTS";
        r1 = com.tencent.mm.pluginsdk.i.a.aP(r13, r1);
        if (r1 != 0) goto L_0x002f;
    L_0x0024:
        r0 = "MicroMsg.ContactsUtil";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r1 = 0;
        goto L_0x0015;
    L_0x002f:
        r7 = 0;
        r1 = 14;
        r1 = com.tencent.mm.compatible.util.f.dW(r1);
        if (r1 == 0) goto L_0x017b;
    L_0x0038:
        r1 = "MicroMsg.ContactsUtil";
        r2 = "The Android API version is higher than 14.";
        com.tencent.mm.sdk.platformtools.v.i(r1, r2);
        r1 = android.provider.ContactsContract.Profile.CONTENT_URI;	 Catch:{ Exception -> 0x010b }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x010b }
        r3 = 0;
        r4 = "_id";
        r2[r3] = r4;	 Catch:{ Exception -> 0x010b }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x010b }
    L_0x0053:
        if (r7 == 0) goto L_0x017b;
    L_0x0055:
        r1 = r7.getCount();
        if (r1 <= 0) goto L_0x019d;
    L_0x005b:
        r7.close();
        r1 = android.provider.ContactsContract.Profile.CONTENT_URI;	 Catch:{ Exception -> 0x0123 }
        r2 = "data";
        r1 = android.net.Uri.withAppendedPath(r1, r2);	 Catch:{ Exception -> 0x0123 }
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0123 }
        r3 = 0;
        r4 = "data15";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0123 }
        r3 = 1;
        r4 = "data_sync1";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0123 }
        r3 = "mimetype=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0123 }
        r5 = 0;
        r8 = "vnd.android.cursor.item/photo";
        r4[r5] = r8;	 Catch:{ Exception -> 0x0123 }
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0123 }
        r2 = r1;
    L_0x0088:
        if (r2 == 0) goto L_0x017b;
    L_0x008a:
        r1 = r2.moveToFirst();
        if (r1 == 0) goto L_0x02cd;
    L_0x0090:
        r1 = com.tencent.mm.sdk.platformtools.ak.isWifi(r13);
        if (r1 != 0) goto L_0x00a2;
    L_0x0096:
        r1 = com.tencent.mm.sdk.platformtools.ak.is3G(r13);
        if (r1 != 0) goto L_0x00a2;
    L_0x009c:
        r1 = com.tencent.mm.sdk.platformtools.ak.is4G(r13);
        if (r1 == 0) goto L_0x013c;
    L_0x00a2:
        r1 = "MicroMsg.ContactsUtil";
        r3 = "The network status is wifi or 3G or 4G.";
        com.tencent.mm.sdk.platformtools.v.i(r1, r3);
        r1 = "data_sync1";
        r1 = r2.getColumnIndex(r1);
        r1 = r2.getString(r1);
        r3 = "MicroMsg.ContactsUtil";
        r4 = "get sync avatar url : [%s]";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r7 = 0;
        r5[r7] = r1;
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r3 != 0) goto L_0x013c;
    L_0x00cb:
        r3 = "https:";
        r3 = r1.lastIndexOf(r3);
        r4 = "MicroMsg.ContactsUtil";
        r5 = "check is exist https download url :[%d]";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r3);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r7);
        if (r3 < 0) goto L_0x013c;
    L_0x00e7:
        r3 = r1.substring(r3);
        r1 = kf(r3);
        r4 = "MicroMsg.ContactsUtil";
        r5 = "Get image from google sync account in profile,url:[%s]";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        if (r1 == 0) goto L_0x013d;
    L_0x0100:
        r3 = r1.isRecycled();
        if (r3 != 0) goto L_0x013d;
    L_0x0106:
        r2.close();
        goto L_0x0015;
    L_0x010b:
        r1 = move-exception;
        r2 = "MicroMsg.ContactsUtil";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        r1 = "MicroMsg.ContactsUtil";
        r2 = "query crashed";
        com.tencent.mm.sdk.platformtools.v.d(r1, r2);
        goto L_0x0053;
    L_0x0123:
        r1 = move-exception;
        r2 = "MicroMsg.ContactsUtil";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        r1 = "MicroMsg.ContactsUtil";
        r2 = "query crashed";
        com.tencent.mm.sdk.platformtools.v.d(r1, r2);
        r2 = r7;
        goto L_0x0088;
    L_0x013c:
        r1 = r6;
    L_0x013d:
        r3 = "data15";
        r3 = r2.getColumnIndex(r3);
        r4 = -1;
        if (r3 == r4) goto L_0x0177;
    L_0x0147:
        r3 = r2.getBlob(r3);
        r4 = "MicroMsg.ContactsUtil";
        r5 = "get bitmap data is null : [%b]";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = com.tencent.mm.sdk.platformtools.be.bl(r3);
        r8 = java.lang.Boolean.valueOf(r8);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        r4 = com.tencent.mm.sdk.platformtools.be.bl(r3);
        if (r4 != 0) goto L_0x0177;
    L_0x0168:
        r1 = "MicroMsg.ContactsUtil";
        r4 = "Get image from profile personal icon.";
        com.tencent.mm.sdk.platformtools.v.i(r1, r4);
        r1 = 0;
        r4 = r3.length;
        r1 = android.graphics.BitmapFactory.decodeByteArray(r3, r1, r4);
    L_0x0177:
        r2.close();
        r6 = r1;
    L_0x017b:
        if (r6 == 0) goto L_0x0183;
    L_0x017d:
        r1 = r6.isRecycled();
        if (r1 == 0) goto L_0x025f;
    L_0x0183:
        r1 = com.tencent.mm.modelsimple.d.be(r13);
        r7 = y(r13, r1);
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r1 == 0) goto L_0x01a1;
    L_0x0191:
        r0 = "MicroMsg.ContactsUtil";
        r1 = "contactId is null.";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r1 = 0;
        goto L_0x0015;
    L_0x019d:
        r7.close();
        goto L_0x017b;
    L_0x01a1:
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        r2 = 2;
        r2 = new java.lang.String[r2];
        r3 = 0;
        r4 = "photo_id";
        r2[r3] = r4;
        r3 = 1;
        r4 = "raw_contact_id";
        r2[r3] = r4;
        r3 = "contact_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r4[r5] = r7;
        r5 = 0;
        r10 = r0.query(r1, r2, r3, r4, r5);
        if (r10 == 0) goto L_0x025f;
    L_0x01c2:
        r1 = r10.moveToFirst();
        if (r1 == 0) goto L_0x025c;
    L_0x01c8:
        r8 = 0;
        r1 = com.tencent.mm.sdk.platformtools.ak.isWifi(r13);
        if (r1 != 0) goto L_0x01dc;
    L_0x01d0:
        r1 = com.tencent.mm.sdk.platformtools.ak.is3G(r13);
        if (r1 != 0) goto L_0x01dc;
    L_0x01d6:
        r1 = com.tencent.mm.sdk.platformtools.ak.is4G(r13);
        if (r1 == 0) goto L_0x0265;
    L_0x01dc:
        r1 = "MicroMsg.ContactsUtil";
        r2 = "The network status is wifi or 3G or 4G.";
        com.tencent.mm.sdk.platformtools.v.i(r1, r2);
        r1 = "raw_contact_id";
        r1 = r10.getColumnIndex(r1);
        r5 = r10.getString(r1);
        r1 = android.provider.ContactsContract.Data.CONTENT_URI;
        r2 = 2;
        r2 = new java.lang.String[r2];
        r3 = 0;
        r4 = "data15";
        r2[r3] = r4;
        r3 = 1;
        r4 = "data_sync1";
        r2[r3] = r4;
        r3 = "mimetype=? AND raw_contact_id=?";
        r4 = 2;
        r4 = new java.lang.String[r4];
        r11 = 0;
        r12 = "vnd.android.cursor.item/photo";
        r4[r11] = r12;
        r11 = 1;
        r4[r11] = r5;
        r5 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5);
        if (r1 == 0) goto L_0x0265;
    L_0x0217:
        r2 = r1.moveToFirst();
        if (r2 == 0) goto L_0x0262;
    L_0x021d:
        r2 = "data_sync1";
        r2 = r1.getColumnIndex(r2);
        r3 = -1;
        if (r2 == r3) goto L_0x0262;
    L_0x0227:
        r2 = r1.getString(r2);
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r3 != 0) goto L_0x0262;
    L_0x0231:
        r3 = "https:";
        r3 = r2.lastIndexOf(r3);
        if (r3 < 0) goto L_0x0262;
    L_0x023a:
        r2 = r2.substring(r3);
        r6 = kf(r2);
        if (r6 == 0) goto L_0x0262;
    L_0x0244:
        r3 = r6.isRecycled();
        if (r3 != 0) goto L_0x0262;
    L_0x024a:
        r0 = "MicroMsg.ContactsUtil";
        r3 = "Get image from google sync account in contacts,url:[%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r2;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        r1.close();
    L_0x025c:
        r10.close();
    L_0x025f:
        r1 = r6;
        goto L_0x0015;
    L_0x0262:
        r1.close();
    L_0x0265:
        r1 = "MicroMsg.ContactsUtil";
        r2 = "Get bitmap from contacts icon.";
        com.tencent.mm.sdk.platformtools.v.i(r1, r2);
        r1 = "photo_id";
        r1 = r10.getColumnIndex(r1);
        r2 = -1;
        if (r1 == r2) goto L_0x02cb;
    L_0x0278:
        r2 = r10.getLong(r1);
        r1 = "MicroMsg.ContactsUtil";
        r4 = new java.lang.StringBuilder;
        r5 = "Have got photoId,photoId is ";
        r4.<init>(r5);
        r4 = r4.append(r2);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.i(r1, r4);
    L_0x0292:
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x02bf;
    L_0x0298:
        r1 = android.provider.ContactsContract.Contacts.CONTENT_URI;
        r2 = 0;
        r2 = com.tencent.mm.sdk.platformtools.be.getLong(r7, r2);
        r1 = android.content.ContentUris.withAppendedId(r1, r2);
        r1 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r0, r1);
        r1 = android.graphics.BitmapFactory.decodeStream(r1);
        if (r1 == 0) goto L_0x02c0;
    L_0x02ae:
        r2 = r1.isRecycled();
        if (r2 != 0) goto L_0x02c0;
    L_0x02b4:
        r0 = "MicroMsg.ContactsUtil";
        r2 = "Get image from contacts through google account.";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        r6 = r1;
        goto L_0x025c;
    L_0x02bf:
        r1 = r6;
    L_0x02c0:
        r2 = r10.moveToNext();
        if (r2 != 0) goto L_0x02c8;
    L_0x02c6:
        r6 = r1;
        goto L_0x025c;
    L_0x02c8:
        r6 = r1;
        goto L_0x01c8;
    L_0x02cb:
        r2 = r8;
        goto L_0x0292;
    L_0x02cd:
        r1 = r6;
        goto L_0x0177;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsimple.c.aW(android.content.Context):android.graphics.Bitmap");
    }

    private static Bitmap kf(String str) {
        InputStream inputStream;
        Throwable e;
        Throwable th;
        Bitmap bitmap = null;
        v.i("MicroMsg.ContactsUtil", "Get bitmap by HTTPS request. url = %s", str);
        if (be.kS(str)) {
            v.e("MicroMsg.ContactsUtil", "url is null or nil.");
        } else {
            String trim = str.trim();
            if (trim.startsWith("https:")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                u lL;
                try {
                    lL = b.lL(trim);
                    try {
                        inputStream = lL.dme.getInputStream();
                        if (inputStream == null) {
                            try {
                                v.e("MicroMsg.ContactsUtil", "getInputStream failed. url:%s", trim);
                                try {
                                    lL.dme.disconnect();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                } catch (Throwable e2) {
                                    v.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e2.getMessage());
                                    v.a("MicroMsg.ContactsUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            } catch (IOException e3) {
                                e2 = e3;
                                try {
                                    v.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, IOException : %s", e2.getMessage());
                                    v.a("MicroMsg.ContactsUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    if (lL != null) {
                                        try {
                                            lL.dme.disconnect();
                                        } catch (Throwable e22) {
                                            v.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e22.getMessage());
                                            v.a("MicroMsg.ContactsUtil", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                    return bitmap;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (lL != null) {
                                        try {
                                            lL.dme.disconnect();
                                        } catch (Throwable e222) {
                                            v.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e222.getMessage());
                                            v.a("MicroMsg.ContactsUtil", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                            throw th;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e222 = e4;
                                v.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e222.getMessage());
                                v.a("MicroMsg.ContactsUtil", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                if (lL != null) {
                                    try {
                                        lL.dme.disconnect();
                                    } catch (Throwable e2222) {
                                        v.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e2222.getMessage());
                                        v.a("MicroMsg.ContactsUtil", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                byteArrayOutputStream.close();
                                return bitmap;
                            }
                        }
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        bitmap = d.bc(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.close();
                        try {
                            lL.dme.disconnect();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable e22222) {
                            v.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e22222.getMessage());
                            v.a("MicroMsg.ContactsUtil", e22222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    } catch (IOException e5) {
                        e22222 = e5;
                        inputStream = null;
                        v.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, IOException : %s", e22222.getMessage());
                        v.a("MicroMsg.ContactsUtil", e22222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        if (lL != null) {
                            lL.dme.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return bitmap;
                    } catch (Exception e6) {
                        e22222 = e6;
                        inputStream = null;
                        v.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e22222.getMessage());
                        v.a("MicroMsg.ContactsUtil", e22222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        if (lL != null) {
                            lL.dme.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return bitmap;
                    } catch (Throwable e222222) {
                        inputStream = null;
                        th = e222222;
                        if (lL != null) {
                            lL.dme.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e7) {
                    e222222 = e7;
                    lL = null;
                    inputStream = null;
                    v.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, IOException : %s", e222222.getMessage());
                    v.a("MicroMsg.ContactsUtil", e222222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (lL != null) {
                        lL.dme.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return bitmap;
                } catch (Exception e8) {
                    e222222 = e8;
                    lL = null;
                    inputStream = null;
                    v.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e222222.getMessage());
                    v.a("MicroMsg.ContactsUtil", e222222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (lL != null) {
                        lL.dme.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return bitmap;
                } catch (Throwable e2222222) {
                    lL = null;
                    inputStream = null;
                    th = e2222222;
                    if (lL != null) {
                        lL.dme.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
            v.e("MicroMsg.ContactsUtil", "this is not the correct https url.");
        }
        return bitmap;
    }
}
