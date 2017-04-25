package com.tencent.mm.pluginsdk;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    public static boolean FY(String str) {
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String yt(String str) {
        CharSequence trim = str.trim();
        boolean startsWith = trim.startsWith("+");
        if (startsWith && trim.length() > 1) {
            trim = trim.substring(1, trim.length());
        }
        Matcher matcher = Pattern.compile("[^0-9]").matcher(trim);
        if (startsWith) {
            return "+" + matcher.replaceAll(SQLiteDatabase.KeyEmpty).trim();
        }
        return matcher.replaceAll(SQLiteDatabase.KeyEmpty).trim();
    }

    public static String[] a(Context context, Uri uri) {
        if (uri == null) {
            v.d("MicroMsg.AddressBookUtil", "uri == null");
            return null;
        } else if (com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            CharSequence charSequence;
            CharSequence charSequence2;
            try {
                query = context.getContentResolver().query(uri, null, null, null, null);
            } catch (Throwable e) {
                v.a("MicroMsg.AddressBookUtil", e, "getContactsInfo1:", new Object[0]);
                query = null;
            }
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("has_phone_number");
                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                    Cursor query2;
                    try {
                        query2 = context.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + query.getString(query.getColumnIndex("_id")), null, null);
                    } catch (Throwable e2) {
                        v.a("MicroMsg.AddressBookUtil", e2, "getContactsInfo2:", new Object[0]);
                        query2 = null;
                    }
                    if (query2 == null || !query2.moveToFirst()) {
                        charSequence = null;
                        charSequence2 = null;
                    } else {
                        charSequence = null;
                        charSequence2 = null;
                        while (!query2.isAfterLast()) {
                            columnIndex = query2.getColumnIndex("data1");
                            int columnIndex2 = query2.getColumnIndex("display_name");
                            String string = query2.getString(columnIndex);
                            String string2 = query2.getString(columnIndex2);
                            v.d("MicroMsg.AddressBookUtil", "username : " + string2);
                            if (string != null) {
                                v.d("MicroMsg.AddressBookUtil", "phoneNumber : " + string);
                                if (string == null) {
                                    string = null;
                                } else {
                                    string = string.replaceAll("\\D", SQLiteDatabase.KeyEmpty);
                                    if (string.startsWith("86")) {
                                        string = string.substring(2);
                                    }
                                }
                                v.d("MicroMsg.AddressBookUtil", "phoneNumber : " + string);
                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                    charSequence = charSequence2;
                                }
                                v.d("MicroMsg.AddressBookUtil", "phoneResult : " + string);
                            } else {
                                charSequence = charSequence2;
                            }
                            query2.moveToNext();
                            Object obj = string;
                            Object obj2 = string2;
                        }
                    }
                    if (!(query2 == null || query2.isClosed())) {
                        query2.close();
                    }
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    if (!TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(charSequence2)) {
                        return null;
                    }
                    return new String[]{charSequence, charSequence2};
                }
            }
            charSequence = null;
            charSequence2 = null;
            query.close();
            if (!TextUtils.isEmpty(charSequence)) {
            }
            return new String[]{charSequence, charSequence2};
        } else {
            v.e("MicroMsg.AddressBookUtil", "no contact permission");
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String[]> cV(android.content.Context r10) {
        /*
        r9 = 1;
        r7 = 0;
        r8 = 0;
        r6 = new java.util.LinkedList;
        r6.<init>();
        r0 = r10.getContentResolver();
        r1 = "android.permission.READ_CONTACTS";
        r1 = com.tencent.mm.pluginsdk.i.a.aP(r10, r1);
        if (r1 != 0) goto L_0x0020;
    L_0x0015:
        r0 = "MicroMsg.AddressBookUtil";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r6;
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;	 Catch:{ Exception -> 0x0038 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0038 }
        r1 = r0;
    L_0x002b:
        if (r1 != 0) goto L_0x0057;
    L_0x002d:
        r0 = "MicroMsg.AddressBookUtil";
        r1 = "getMobileInfo: mobile is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r6;
        goto L_0x001f;
    L_0x0038:
        r0 = move-exception;
        r1 = "MicroMsg.AddressBookUtil";
        r2 = "getMobileInfo: exception occured [%s]";
        r3 = new java.lang.Object[r9];
        r4 = r0.getMessage();
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
        r1 = "MicroMsg.AddressBookUtil";
        r2 = "";
        r3 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        r1 = r7;
        goto L_0x002b;
    L_0x0057:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x00c3 }
        if (r0 <= 0) goto L_0x00bd;
    L_0x005d:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00c3 }
        if (r0 == 0) goto L_0x00bd;
    L_0x0063:
        r0 = "display_name";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00c3 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00c3 }
        r2 = "contact_id";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00c3 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00c3 }
        r3 = "data1";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x00c3 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x00c3 }
        r4 = "raw_contact_id";
        r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x00c3 }
        r4 = r1.getString(r4);	 Catch:{ Exception -> 0x00c3 }
        r5 = "photo_id";
        r5 = r1.getColumnIndex(r5);	 Catch:{ Exception -> 0x00c3 }
        r8 = r1.getLong(r5);	 Catch:{ Exception -> 0x00c3 }
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x00c3 }
        r7 = 5;
        r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x00c3 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ Exception -> 0x00c3 }
        r2 = 1;
        r7[r2] = r0;	 Catch:{ Exception -> 0x00c3 }
        r0 = 2;
        r7[r0] = r3;	 Catch:{ Exception -> 0x00c3 }
        r0 = 3;
        r7[r0] = r4;	 Catch:{ Exception -> 0x00c3 }
        r0 = 4;
        r2 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x00c3 }
        r7[r0] = r2;	 Catch:{ Exception -> 0x00c3 }
        r6.add(r7);	 Catch:{ Exception -> 0x00c3 }
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00c3 }
        if (r0 != 0) goto L_0x0063;
    L_0x00bd:
        r1.close();
    L_0x00c0:
        r0 = r6;
        goto L_0x001f;
    L_0x00c3:
        r0 = move-exception;
        r2 = "MicroMsg.AddressBookUtil";
        r3 = "getMobileInfo: exception2 occured [%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e7 }
        r5 = 0;
        r7 = r0.getMessage();	 Catch:{ all -> 0x00e7 }
        r4[r5] = r7;	 Catch:{ all -> 0x00e7 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x00e7 }
        r2 = "MicroMsg.AddressBookUtil";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e7 }
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);	 Catch:{ all -> 0x00e7 }
        r1.close();
        goto L_0x00c0;
    L_0x00e7:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.a.cV(android.content.Context):java.util.List<java.lang.String[]>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String[]> cW(android.content.Context r10) {
        /*
        r9 = 1;
        r8 = 0;
        r7 = 0;
        r6 = new java.util.LinkedList;
        r6.<init>();
        r0 = r10.getContentResolver();
        r1 = "android.permission.READ_CONTACTS";
        r1 = com.tencent.mm.pluginsdk.i.a.aP(r10, r1);
        if (r1 != 0) goto L_0x0020;
    L_0x0015:
        r0 = "MicroMsg.AddressBookUtil";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r6;
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;	 Catch:{ Exception -> 0x003a }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "sort_key_alt";
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x003a }
        r1 = r0;
    L_0x002d:
        if (r1 != 0) goto L_0x0063;
    L_0x002f:
        r0 = "MicroMsg.AddressBookUtil";
        r1 = "getMobileInfo: mobile is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r6;
        goto L_0x001f;
    L_0x003a:
        r1 = move-exception;
        r2 = "MicroMsg.AddressBookUtil";
        r3 = "";
        r4 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        r2 = "MicroMsg.AddressBookUtil";
        r3 = "exception in getMoblieOrderInfo(), [%s]";
        r4 = new java.lang.Object[r9];
        r1 = r1.getMessage();
        r4[r8] = r1;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        r2 = r7;
        r3 = r7;
        r4 = r7;
        r5 = r7;
        r0 = r0.query(r1, r2, r3, r4, r5);
        r1 = r0;
        goto L_0x002d;
    L_0x0063:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x00b9 }
        if (r0 <= 0) goto L_0x00b3;
    L_0x0069:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00b9 }
        if (r0 == 0) goto L_0x00b3;
    L_0x006f:
        r0 = "display_name";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00b9 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00b9 }
        r2 = "contact_id";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00b9 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00b9 }
        r3 = "data1";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x00b9 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x00b9 }
        r4 = "raw_contact_id";
        r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x00b9 }
        r4 = r1.getString(r4);	 Catch:{ Exception -> 0x00b9 }
        r5 = 4;
        r5 = new java.lang.String[r5];	 Catch:{ Exception -> 0x00b9 }
        r7 = 0;
        r5[r7] = r2;	 Catch:{ Exception -> 0x00b9 }
        r2 = 1;
        r5[r2] = r0;	 Catch:{ Exception -> 0x00b9 }
        r0 = 2;
        r5[r0] = r3;	 Catch:{ Exception -> 0x00b9 }
        r0 = 3;
        r5[r0] = r4;	 Catch:{ Exception -> 0x00b9 }
        r6.add(r5);	 Catch:{ Exception -> 0x00b9 }
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00b9 }
        if (r0 != 0) goto L_0x006f;
    L_0x00b3:
        r1.close();
    L_0x00b6:
        r0 = r6;
        goto L_0x001f;
    L_0x00b9:
        r0 = move-exception;
        r2 = "MicroMsg.AddressBookUtil";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00dd }
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);	 Catch:{ all -> 0x00dd }
        r2 = "MicroMsg.AddressBookUtil";
        r3 = "exception in getMoblieOrderInfo()2, [%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00dd }
        r5 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x00dd }
        r4[r5] = r0;	 Catch:{ all -> 0x00dd }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x00dd }
        r1.close();
        goto L_0x00b6;
    L_0x00dd:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.a.cW(android.content.Context):java.util.List<java.lang.String[]>");
    }

    public static List<String[]> cX(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            try {
                Cursor query = contentResolver.query(Email.CONTENT_URI, null, null, null, null);
                if (query == null) {
                    return linkedList;
                }
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("data1"));
                        String string2 = query.getString(query.getColumnIndex("contact_id"));
                        String string3 = query.getString(query.getColumnIndex("data4"));
                        String string4 = query.getString(query.getColumnIndex("raw_contact_id"));
                        String string5 = query.getString(query.getColumnIndex("photo_id"));
                        linkedList.add(new String[]{string2, string3, string, string4, string5});
                    } while (query.moveToNext());
                }
                query.close();
                return linkedList;
            } catch (Throwable e) {
                v.a("MicroMsg.AddressBookUtil", e, "getEmailInfo", new Object[0]);
            }
        } else {
            v.e("MicroMsg.AddressBookUtil", "no contact permission");
            return linkedList;
        }
    }

    public static List<String> cY(Context context) {
        Cursor query;
        Throwable e;
        List<String> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
                if (query == null) {
                    try {
                        v.e("MicroMsg.AddressBookUtil", "getPhonesCursor: cursor is null.");
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            v.e("MicroMsg.AddressBookUtil", "exception in getMobileList, [%s]", e.getMessage());
                            v.a("MicroMsg.AddressBookUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            if (query != null) {
                                query.close();
                            }
                            return linkedList;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            throw e;
                        }
                    }
                }
                if (query.moveToFirst()) {
                    do {
                        linkedList.add(query.getString(query.getColumnIndex("data1")));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Exception e3) {
                e = e3;
                query = null;
                v.e("MicroMsg.AddressBookUtil", "exception in getMobileList, [%s]", e.getMessage());
                v.a("MicroMsg.AddressBookUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th2) {
                e = th2;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw e;
            }
        }
        v.e("MicroMsg.AddressBookUtil", "no contact permission");
        return linkedList;
    }

    public static String g(String str, Context context) {
        String str2 = SQLiteDatabase.KeyEmpty;
        if (com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = context.getContentResolver().query(Contacts.CONTENT_URI, new String[]{"display_name"}, "_id = ?", new String[]{str}, null);
            } catch (Throwable e) {
                v.a("MicroMsg.AddressBookUtil", e, "getContactNameById:", new Object[0]);
                query = null;
            }
            if (query == null) {
                return str2;
            }
            String string;
            if (query.moveToFirst()) {
                string = query.getString(0);
            } else {
                string = str2;
            }
            query.close();
            return string;
        }
        v.e("MicroMsg.AddressBookUtil", "no contact permission");
        return str2;
    }

    public static Uri bmp() {
        try {
            return Contacts.CONTENT_URI;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap b(String str, Context context, boolean z) {
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            InputStream openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(Contacts.CONTENT_URI, Long.parseLong(str)), z);
            if (openContactPhotoInputStream == null) {
                return null;
            }
            Bitmap decodeStream = d.decodeStream(openContactPhotoInputStream);
            if (decodeStream != null) {
                return d.a(decodeStream, true, 4.0f);
            }
            return decodeStream;
        } catch (Throwable e) {
            v.a("MicroMsg.AddressBookUtil", e, "getAvatar, contactId:%s", str);
            return null;
        }
    }

    public static boolean b(String str, Context context, byte[] bArr) {
        Cursor query;
        Throwable e;
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            return false;
        }
        if (com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                long parseLong = Long.parseLong(str);
                ContentValues contentValues = new ContentValues();
                v.d("MicroMsg.AddressBookUtil", "where is %s", String.format("%s=%d and %s='%s'", new Object[]{"raw_contact_id", Long.valueOf(parseLong), "mimetype", "vnd.android.cursor.item/photo"}));
                query = contentResolver.query(Data.CONTENT_URI, null, r3, null, null);
                try {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                    if (query.moveToFirst()) {
                        columnIndexOrThrow = query.getInt(columnIndexOrThrow);
                    } else {
                        columnIndexOrThrow = -1;
                    }
                    query.close();
                    contentValues.put("raw_contact_id", Long.valueOf(parseLong));
                    contentValues.put("is_super_primary", Integer.valueOf(1));
                    contentValues.put("data15", bArr);
                    contentValues.put("mimetype", "vnd.android.cursor.item/photo");
                    if (columnIndexOrThrow >= 0) {
                        return contentResolver.update(Data.CONTENT_URI, contentValues, new StringBuilder("_id = ").append(columnIndexOrThrow).toString(), null) > 0;
                    } else {
                        contentResolver.insert(Data.CONTENT_URI, contentValues);
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    v.a("MicroMsg.AddressBookUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    query.close();
                    return false;
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                v.a("MicroMsg.AddressBookUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                return false;
            }
        }
        v.e("MicroMsg.AddressBookUtil", "no contact permission");
        return false;
    }
}
