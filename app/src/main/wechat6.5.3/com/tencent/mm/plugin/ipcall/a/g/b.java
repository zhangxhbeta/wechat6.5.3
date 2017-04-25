package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    public static final String eTm = new String(Character.toChars(91));
    private static HashMap<String, c> gIA = new HashMap();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c> auQ() {
        /*
        r4 = 0;
        r15 = 2;
        r14 = 1;
        r13 = 0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = new java.util.ArrayList;
        r6.<init>();
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = "android.permission.READ_CONTACTS";
        r0 = com.tencent.mm.pluginsdk.i.a.aP(r0, r1);
        if (r0 != 0) goto L_0x0025;
    L_0x001a:
        r0 = "MicroMsg.IPCallAddressBookInfoExtracter";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r6;
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = r0.getContentResolver();
        r1 = android.provider.ContactsContract.Data.CONTENT_URI;
        r2 = 3;
        r2 = new java.lang.String[r2];
        r3 = "contact_id";
        r2[r13] = r3;
        r3 = "display_name";
        r2[r14] = r3;
        r3 = "data1";
        r2[r15] = r3;
        r3 = "mimetype='vnd.android.cursor.item/phone_v2'";
        r5 = r4;
        r1 = r0.query(r1, r2, r3, r4, r5);
        r2 = new java.util.HashMap;
        r2.<init>();
        r0 = "MicroMsg.IPCallAddressBookInfoExtracter";
        r3 = new java.lang.StringBuilder;
        r4 = "query FromSystemPhoneBook, time: ";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r8;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.d(r0, r3);
        if (r1 != 0) goto L_0x006d;
    L_0x006b:
        r0 = r6;
        goto L_0x0024;
    L_0x006d:
        r0 = "MicroMsg.IPCallAddressBookInfoExtracter";
        r3 = "getAllAddressItemFromSystemPhoneBook, count: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00f6 }
        r5 = 0;
        r7 = r1.getCount();	 Catch:{ Exception -> 0x00f6 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00f6 }
        r4[r5] = r7;	 Catch:{ Exception -> 0x00f6 }
        com.tencent.mm.sdk.platformtools.v.d(r0, r3, r4);	 Catch:{ Exception -> 0x00f6 }
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00f6 }
        if (r0 == 0) goto L_0x014f;
    L_0x008a:
        r0 = "contact_id";
        r3 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00f6 }
        r0 = "display_name";
        r4 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00f6 }
        r0 = "data1";
        r5 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00f6 }
    L_0x009f:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x00f6 }
        if (r0 != 0) goto L_0x014f;
    L_0x00a5:
        r7 = a(r1, r3, r4, r5);	 Catch:{ Exception -> 0x00f6 }
        if (r7 == 0) goto L_0x00f2;
    L_0x00ab:
        r0 = r7.gIB;	 Catch:{ Exception -> 0x00f6 }
        if (r0 == 0) goto L_0x00f2;
    L_0x00af:
        r0 = r7.gIB;	 Catch:{ Exception -> 0x00f6 }
        r0 = r0.size();	 Catch:{ Exception -> 0x00f6 }
        if (r0 <= 0) goto L_0x00f2;
    L_0x00b7:
        r0 = r7.field_contactId;	 Catch:{ Exception -> 0x00f6 }
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);	 Catch:{ Exception -> 0x00f6 }
        if (r0 != 0) goto L_0x00f2;
    L_0x00bf:
        r0 = r7.field_contactId;	 Catch:{ Exception -> 0x00f6 }
        r0 = r2.containsKey(r0);	 Catch:{ Exception -> 0x00f6 }
        if (r0 == 0) goto L_0x0144;
    L_0x00c7:
        r0 = r7.field_contactId;	 Catch:{ Exception -> 0x00f6 }
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x00f6 }
        r0 = (com.tencent.mm.plugin.ipcall.a.g.c) r0;	 Catch:{ Exception -> 0x00f6 }
        r10 = r7.gIB;	 Catch:{ Exception -> 0x00f6 }
        r10 = r10.size();	 Catch:{ Exception -> 0x00f6 }
        if (r10 <= 0) goto L_0x00f2;
    L_0x00d7:
        r10 = r0.gIB;	 Catch:{ Exception -> 0x00f6 }
        r11 = r7.gIB;	 Catch:{ Exception -> 0x00f6 }
        r12 = 0;
        r11 = r11.get(r12);	 Catch:{ Exception -> 0x00f6 }
        r10 = r10.contains(r11);	 Catch:{ Exception -> 0x00f6 }
        if (r10 != 0) goto L_0x00f2;
    L_0x00e6:
        r0 = r0.gIB;	 Catch:{ Exception -> 0x00f6 }
        r7 = r7.gIB;	 Catch:{ Exception -> 0x00f6 }
        r10 = 0;
        r7 = r7.get(r10);	 Catch:{ Exception -> 0x00f6 }
        r0.add(r7);	 Catch:{ Exception -> 0x00f6 }
    L_0x00f2:
        r1.moveToNext();	 Catch:{ Exception -> 0x00f6 }
        goto L_0x009f;
    L_0x00f6:
        r0 = move-exception;
        r3 = "MicroMsg.IPCallAddressBookInfoExtracter";
        r4 = "getAllAddressItemFromSystemPhoneBook error: %s, class: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x014a }
        r7 = 0;
        r10 = r0.getMessage();	 Catch:{ all -> 0x014a }
        r5[r7] = r10;	 Catch:{ all -> 0x014a }
        r7 = 1;
        r0 = r0.getClass();	 Catch:{ all -> 0x014a }
        r0 = r0.getSimpleName();	 Catch:{ all -> 0x014a }
        r5[r7] = r0;	 Catch:{ all -> 0x014a }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x014a }
        r1.close();
    L_0x0118:
        r0 = r2.values();
        r6.addAll(r0);
        gIA = r2;
        r0 = java.lang.System.currentTimeMillis();
        r2 = "MicroMsg.IPCallAddressBookInfoExtracter";
        r3 = "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms";
        r4 = new java.lang.Object[r15];
        r5 = r6.size();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r13] = r5;
        r0 = r0 - r8;
        r0 = java.lang.Long.valueOf(r0);
        r4[r14] = r0;
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);
        r0 = r6;
        goto L_0x0024;
    L_0x0144:
        r0 = r7.field_contactId;	 Catch:{ Exception -> 0x00f6 }
        r2.put(r0, r7);	 Catch:{ Exception -> 0x00f6 }
        goto L_0x00f2;
    L_0x014a:
        r0 = move-exception;
        r1.close();
        throw r0;
    L_0x014f:
        r1.close();
        goto L_0x0118;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.b.auQ():java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c>");
    }

    public static HashMap<String, c> auR() {
        return gIA;
    }

    public static HashMap<String, c> auS() {
        auQ();
        return gIA;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.String> uJ(java.lang.String r8) {
        /*
        r2 = 0;
        r4 = 1;
        r5 = 0;
        r6 = new java.util.ArrayList;
        r6.<init>();
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = "android.permission.READ_CONTACTS";
        r0 = com.tencent.mm.pluginsdk.i.a.aP(r0, r1);
        if (r0 != 0) goto L_0x0020;
    L_0x0015:
        r0 = "MicroMsg.IPCallAddressBookInfoExtracter";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r6;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = r0.getContentResolver();
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        r3 = "contact_id=?";
        r4 = new java.lang.String[r4];
        r4[r5] = r8;
        r5 = r2;
        r1 = r0.query(r1, r2, r3, r4, r5);
        if (r1 != 0) goto L_0x003a;
    L_0x0038:
        r0 = r6;
        goto L_0x001f;
    L_0x003a:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0058 }
        if (r0 == 0) goto L_0x007c;
    L_0x0040:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x0058 }
        if (r0 != 0) goto L_0x007c;
    L_0x0046:
        r0 = "data1";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x0058 }
        r6.add(r0);	 Catch:{ Exception -> 0x0058 }
        r1.moveToNext();	 Catch:{ Exception -> 0x0058 }
        goto L_0x0040;
    L_0x0058:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallAddressBookInfoExtracter";
        r3 = "extractAddressItemFromCursor, error: %s, class: %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0080 }
        r5 = 0;
        r7 = r0.getMessage();	 Catch:{ all -> 0x0080 }
        r4[r5] = r7;	 Catch:{ all -> 0x0080 }
        r5 = 1;
        r0 = r0.getClass();	 Catch:{ all -> 0x0080 }
        r0 = r0.getSimpleName();	 Catch:{ all -> 0x0080 }
        r4[r5] = r0;	 Catch:{ all -> 0x0080 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0080 }
        r1.close();
    L_0x007a:
        r0 = r6;
        goto L_0x001f;
    L_0x007c:
        r1.close();
        goto L_0x007a;
    L_0x0080:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.b.uJ(java.lang.String):java.util.ArrayList<java.lang.String>");
    }

    private static c a(Cursor cursor, int i, int i2, int i3) {
        String str = null;
        if (a.aP(aa.getContext(), "android.permission.READ_CONTACTS")) {
            c cVar = new c();
            cVar.gIB = new ArrayList();
            String string = cursor.getString(i);
            String string2 = cursor.getString(i2);
            String string3 = cursor.getString(i3);
            cVar.field_contactId = string;
            cVar.field_systemAddressBookUsername = string2;
            if (!(be.kS(string3) || cVar.gIB.contains(string3))) {
                cVar.gIB.add(string3);
            }
            if (be.kS(cVar.field_systemAddressBookUsername) && cVar.gIB.size() > 0) {
                cVar.field_systemAddressBookUsername = (String) cVar.gIB.get(0);
            }
            Iterator it = cVar.gIB.iterator();
            string2 = str;
            while (it.hasNext()) {
                string = com.tencent.mm.plugin.ipcall.b.a.vg((String) it.next());
                if (be.kS(string)) {
                    string = string2;
                } else if (!string.endsWith("@stranger")) {
                    break;
                }
                string2 = string;
            }
            string = string2;
            if (!be.kS(string)) {
                cVar.field_wechatUsername = string;
            }
            if (be.kS(cVar.field_systemAddressBookUsername)) {
                cVar.field_sortKey = "";
            } else {
                try {
                    str = c.lT(cVar.field_systemAddressBookUsername);
                } catch (Exception e) {
                    v.d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
                }
                if (be.kS(str)) {
                    cVar.field_sortKey = "";
                } else if (Character.isLetter(str.charAt(0))) {
                    cVar.field_sortKey = str.toUpperCase();
                } else {
                    cVar.field_sortKey = eTm + str.toUpperCase();
                }
            }
            return cVar;
        }
        v.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        return str;
    }
}
