package com.tencent.mm.storage.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class f extends com.tencent.mm.sdk.h.f<c> implements a {
    public static final String[] cic = new String[]{com.tencent.mm.sdk.h.f.a(c.chq, "EmojiInfo")};
    private static int[] nxj = new int[]{2, 4, 8};
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return q((c) cVar);
    }

    public f(d dVar) {
        super(dVar, c.chq, "EmojiInfo", null);
        this.cie = dVar;
    }

    public final String getTableName() {
        return "EmojiInfo";
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final boolean ee(Context context) {
        v.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        c NF = NF("86cb157e9c44b2c9934e4e430790776d");
        c NF2 = NF("68f9864ca5c0a5d823ed7184e113a4aa");
        v.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", Integer.valueOf(vl(c.nwO)));
        if (NF != null || ((NF2 != null && NF2.pO().length() == 0) || r2 <= 2)) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            vn(c.nwN);
            vn(c.nwQ);
            vn(c.nwP);
        }
        NF = NF("9bd1281af3a31710a45b84d736363691");
        if (NF != null && NF.field_catalog == c.nwN) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            vn(c.nwN);
            vn(c.nwQ);
            vn(c.nwP);
        }
        InputStream ba = c.ba(context, "icon_002_cover.png");
        if (ba != null) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            vn(c.nwN);
            vn(c.nwQ);
            vn(c.nwP);
        }
        if (ba != null) {
            try {
                ba.close();
            } catch (Exception e) {
            }
        }
        if (vl(c.nwN) != 0) {
            return true;
        }
        InputStream inputStream = null;
        try {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            List<c> a = a(new InputStream[]{inputStream});
            v.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a.size() > 0 && a.size() > 0) {
                g gVar;
                currentTimeMillis = -1;
                if (this.cie instanceof g) {
                    g gVar2 = (g) this.cie;
                    currentTimeMillis = gVar2.er(Thread.currentThread().getId());
                    gVar = gVar2;
                } else {
                    gVar = null;
                }
                for (c NF3 : a) {
                    if (this.cie.replace("EmojiInfo", "md5", NF3.py()) < 0) {
                        if (gVar != null) {
                            gVar.es(currentTimeMillis);
                        }
                    }
                }
                if (gVar != null) {
                    gVar.es(currentTimeMillis);
                }
            }
            v.i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            v.d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2) {
                    v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e2));
                }
            }
        } catch (IOException e3) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e22));
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e4) {
                    v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e4));
                }
            }
        }
        return true;
    }

    public final boolean ri(String str) {
        if (str == null || str.trim().equals(SQLiteDatabase.KeyEmpty)) {
            return false;
        }
        String str2 = "select reserved2 from EmojiInfo where catalog != ? and reserved2 = ?";
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery(str2, new String[]{c.nwM, g.dM(str)});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } else if (cursor == null) {
                return true;
            } else {
                cursor.close();
                return true;
            }
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final c p(c cVar) {
        if (be.kS(cVar.EB()) || cVar.EB().length() <= 0) {
            v.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        } else if (!q(cVar)) {
            return null;
        } else {
            Lf("create_emoji_info_notify");
            return cVar;
        }
    }

    public final c a(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, null, str3, 1);
    }

    public final c b(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, null, str3, 1);
    }

    public final c a(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        return a(str, str2, i, i2, i3, null, null, str3, str4, 1);
    }

    public final c a(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, String str6, int i4) {
        if (str == null || str.length() <= 0) {
            v.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        }
        c cVar;
        if (str == null || str.length() <= 0) {
            v.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            cVar = null;
        } else {
            cVar = NF(str);
            if (cVar == null) {
                ak.yW();
                cVar = new c(com.tencent.mm.model.c.wY());
                cVar.field_catalog = i;
            }
            cVar.field_md5 = str;
            cVar.field_svrid = str2;
            cVar.field_type = i2;
            cVar.field_size = i3;
            cVar.field_state = c.nwY;
            cVar.field_reserved1 = null;
            cVar.field_reserved2 = str4;
            cVar.field_app_id = str5;
            cVar.field_temp = 1;
            cVar.field_reserved4 = 0;
            if (!TextUtils.isEmpty(str6)) {
                cVar.field_groupId = str6;
            }
        }
        cVar.field_state = c.nxa;
        if (!q(cVar)) {
            return null;
        }
        Lf("create_emoji_info_notify");
        return cVar;
    }

    public final boolean q(c cVar) {
        if (cVar == null || !cVar.bxJ()) {
            v.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        long replace = this.cie.replace("EmojiInfo", "md5", cVar.py());
        if (replace != -1) {
            Lf(cVar.EB());
        }
        if (replace >= 0) {
            return true;
        }
        return false;
    }

    public final boolean r(c cVar) {
        if (cVar == null || !cVar.bxJ()) {
            v.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        int update = this.cie.update("EmojiInfo", cVar.py(), "md5=?", new String[]{cVar.EB()});
        if (update > 0) {
            Lf(cVar.EB());
            Lf("event_update_emoji");
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean s(c cVar) {
        if (cVar == null || !cVar.bxJ()) {
            v.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        if (this.cie.update("EmojiInfo", cVar.py(), "md5=?", new String[]{cVar.EB()}) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.a.c NF(java.lang.String r11) {
        /*
        r10 = this;
        r2 = 1;
        r3 = 0;
        r8 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r11);
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r0 = r11.length();
        r1 = 32;
        if (r0 == r1) goto L_0x0020;
    L_0x0011:
        r0 = "MicroMsg.emoji.EmojiInfoStorage";
        r1 = "md5 is null or invalue. md5:%s";
        r2 = new java.lang.Object[r2];
        r2[r3] = r11;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r8;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = r10.cie;	 Catch:{ Exception -> 0x0054 }
        r1 = "EmojiInfo";
        r2 = 0;
        r3 = "md5=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0054 }
        r5 = 0;
        r4[r5] = r11;	 Catch:{ Exception -> 0x0054 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0054 }
        if (r1 == 0) goto L_0x0085;
    L_0x0038:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x007a, all -> 0x0077 }
        if (r0 == 0) goto L_0x0085;
    L_0x003e:
        r2 = new com.tencent.mm.storage.a.c;	 Catch:{ Exception -> 0x007a, all -> 0x0077 }
        com.tencent.mm.model.ak.yW();	 Catch:{ Exception -> 0x007a, all -> 0x0077 }
        r0 = com.tencent.mm.model.c.wY();	 Catch:{ Exception -> 0x007a, all -> 0x0077 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x007a, all -> 0x0077 }
        r2.b(r1);	 Catch:{ Exception -> 0x0080, all -> 0x0077 }
        r0 = r2;
    L_0x004e:
        if (r1 == 0) goto L_0x001f;
    L_0x0050:
        r1.close();
        goto L_0x001f;
    L_0x0054:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
    L_0x0057:
        r2 = "MicroMsg.emoji.EmojiInfoStorage";
        r3 = "[getByMd5]Exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0070 }
        r5 = 0;
        r1 = r1.toString();	 Catch:{ all -> 0x0070 }
        r4[r5] = r1;	 Catch:{ all -> 0x0070 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0070 }
        if (r8 == 0) goto L_0x001f;
    L_0x006c:
        r8.close();
        goto L_0x001f;
    L_0x0070:
        r0 = move-exception;
    L_0x0071:
        if (r8 == 0) goto L_0x0076;
    L_0x0073:
        r8.close();
    L_0x0076:
        throw r0;
    L_0x0077:
        r0 = move-exception;
        r8 = r1;
        goto L_0x0071;
    L_0x007a:
        r0 = move-exception;
        r9 = r0;
        r0 = r8;
        r8 = r1;
        r1 = r9;
        goto L_0x0057;
    L_0x0080:
        r0 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x0057;
    L_0x0085:
        r0 = r8;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.f.NF(java.lang.String):com.tencent.mm.storage.a.c");
    }

    private int vl(int i) {
        int i2 = 0;
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i), "0"});
            if (cursor != null && cursor.moveToFirst()) {
                i2 = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e));
            v.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i2;
    }

    public final int NB(String str) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, "0"});
            if (cursor == null || !cursor.moveToFirst()) {
                i = 0;
            } else {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e));
            v.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        v.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return i;
    }

    public final int iC(boolean z) {
        int i = 0;
        Cursor cursor = null;
        String str = "select count(*)  from EmojiInfo where catalog=? ";
        String[] strArr = new String[]{a.nwL};
        if (z) {
            str = "select  count(*) from EmojiInfo where catalog=?  or catalog=?";
            strArr = new String[]{String.valueOf(a.nwK), String.valueOf(a.nwL)};
        }
        try {
            cursor = this.cie.rawQuery(str, strArr);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e));
            v.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final List<c> bxM() {
        List<c> arrayList = new ArrayList();
        String[] strArr = new String[]{String.valueOf(a.nwK), String.valueOf(a.nwL), String.valueOf(c.nxb)};
        Cursor rawQuery = this.cie.rawQuery("select  * from EmojiInfo where catalog=?  or catalog=? and state!=? order by reserved3 asc", strArr);
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToFirst();
            do {
                ak.yW();
                c cVar = new c(com.tencent.mm.model.c.wY());
                cVar.b(rawQuery);
                arrayList.add(cVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return arrayList;
    }

    public final List<String> bxN() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select md5 from EmojiInfo where catalog=?  order by reserved3 asc", new String[]{a.nwL});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", be.e(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<String> bxO() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select md5 from EmojiInfo where catalog=? and source=?", new String[]{a.nwL, c.nxe});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", be.e(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor vm(int i) {
        return this.cie.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i), "0"}, null, null, null);
    }

    private boolean vn(int i) {
        if (this.cie.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i)}) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(Context context, c cVar) {
        int available;
        if (cVar.field_catalog == c.nwN || cVar.field_catalog == c.nwQ || cVar.field_catalog == c.nwP) {
            InputStream inputStream = null;
            try {
                inputStream = c.ba(context, cVar.getName());
                if (inputStream != null) {
                    available = inputStream.available();
                } else {
                    available = 0;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e));
                    }
                }
            } catch (Throwable e2) {
                v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        available = 0;
                    } catch (Throwable e22) {
                        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e22));
                        available = 0;
                    }
                } else {
                    available = 0;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", be.e(e3));
                    }
                }
            }
        } else {
            available = e.aQ(cVar.iay + cVar.EB());
        }
        if (available != 0 && available != cVar.field_size) {
            cVar.field_size = available;
            r(cVar);
        }
    }

    private static List<c> a(InputStream[] inputStreamArr) {
        List<c> arrayList = new ArrayList();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            for (int i = 0; i <= 0; i++) {
                InputStream inputStream = inputStreamArr[i];
                if (inputStream != null) {
                    NodeList elementsByTagName = newDocumentBuilder.parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
                    for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                        Element element = (Element) elementsByTagName.item(i2);
                        int intValue = Integer.decode(element.getAttribute("id")).intValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("emoji");
                        for (int i3 = 0; i3 < elementsByTagName2.getLength(); i3++) {
                            ak.yW();
                            c cVar = new c(com.tencent.mm.model.c.wY());
                            element = (Element) elementsByTagName2.item(i3);
                            cVar.field_md5 = element.getAttribute("md5");
                            if (cVar.bxJ()) {
                                String str;
                                cVar.field_catalog = intValue;
                                cVar.field_groupId = String.valueOf(intValue);
                                cVar.field_name = element.getAttribute("name");
                                cVar.field_type = Integer.decode(element.getAttribute("type")).intValue();
                                Node firstChild = element.getFirstChild();
                                String data = firstChild instanceof CharacterData ? ((CharacterData) firstChild).getData() : SQLiteDatabase.KeyEmpty;
                                if (cVar.field_type == c.nwV) {
                                    str = new String(Base64.decode(data, 0));
                                } else {
                                    str = data;
                                }
                                cVar.field_content = str;
                                arrayList.add(cVar);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e.getMessage());
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.a.c NG(java.lang.String r8) {
        /*
        r7 = this;
        r2 = 0;
        r0 = "select * from EmojiInfo where +groupId = ? and temp=? limit 1 ";
        r1 = 2;
        r1 = new java.lang.String[r1];
        r3 = 0;
        r1[r3] = r8;
        r3 = 1;
        r4 = "0";
        r1[r3] = r4;
        r3 = r7.cie;	 Catch:{ Exception -> 0x0035 }
        r1 = r3.rawQuery(r0, r1);	 Catch:{ Exception -> 0x0035 }
        r0 = r1.getCount();	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        if (r0 <= 0) goto L_0x006d;
    L_0x001c:
        r1.moveToFirst();	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r3 = new com.tencent.mm.storage.a.c;	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        com.tencent.mm.model.ak.yW();	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r0 = com.tencent.mm.model.c.wY();	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r3.b(r1);	 Catch:{ Exception -> 0x0068, all -> 0x005f }
        r0 = r3;
    L_0x002f:
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();
    L_0x0034:
        return r0;
    L_0x0035:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0038:
        r3 = "MicroMsg.emoji.EmojiInfoStorage";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0058 }
        r5 = "getFirstEmojiByGroupId fail.";
        r4.<init>(r5);	 Catch:{ all -> 0x0058 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0058 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x0058 }
        r1 = r1.toString();	 Catch:{ all -> 0x0058 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r1);	 Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x0034;
    L_0x0054:
        r2.close();
        goto L_0x0034;
    L_0x0058:
        r0 = move-exception;
    L_0x0059:
        if (r2 == 0) goto L_0x005e;
    L_0x005b:
        r2.close();
    L_0x005e:
        throw r0;
    L_0x005f:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0059;
    L_0x0062:
        r0 = move-exception;
        r6 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x0038;
    L_0x0068:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0038;
    L_0x006d:
        r0 = r2;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.f.NG(java.lang.String):com.tencent.mm.storage.a.c");
    }

    public final List<c> rj(String str) {
        List<c> arrayList = new ArrayList();
        String str2 = "select * from EmojiInfo where groupId=? and temp=? order by idx asc";
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery(str2, new String[]{str, "0"});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                ak.yW();
                c cVar = new c(com.tencent.mm.model.c.wY());
                cVar.b(cursor);
                arrayList.add(cVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            v.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean ci(List<String> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("catalog");
        stringBuilder.append("=");
        stringBuilder.append(c.nwM);
        stringBuilder.append(",");
        stringBuilder.append("source");
        stringBuilder.append("=");
        stringBuilder.append(c.nxd);
        stringBuilder.append(",");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(c.nxf);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append("'" + ((String) list.get(i)) + "'");
            if (i < list.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        v.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.cie.dF("EmojiInfo", stringBuilder.toString())) {
            Lf("delete_emoji_info_notify");
        }
        return true;
    }

    public final boolean cj(List<String> list) {
        v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            return false;
        }
        long er;
        g gVar;
        List<String> bxN = bxN();
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        int i = 1;
        for (String str : list) {
            c NF = NF(str);
            if (!(NF == null || be.kS(NF.EB()))) {
                NF.field_reserved3 = i;
                if (!bxN.isEmpty()) {
                    bxN.remove(str);
                }
                i++;
                if (this.cie.replace("EmojiInfo", "md5", NF.py()) < 0) {
                    if (gVar != null) {
                        gVar.es(er);
                    }
                    v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            }
            i = i;
        }
        if (!bxN.isEmpty()) {
            for (String str2 : bxN) {
                c NF2 = NF(str2);
                if (!(NF2 == null || be.kS(NF2.EB()))) {
                    NF2.field_reserved3 = i;
                    i++;
                    if (this.cie.replace("EmojiInfo", "md5", NF2.py()) < 0) {
                        if (gVar != null) {
                            gVar.es(er);
                        }
                        v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return false;
                    }
                }
            }
        }
        if (gVar != null) {
            gVar.es(er);
        }
        String str3 = "MicroMsg.emoji.EmojiInfoStorage";
        String str4 = "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
        v.i(str3, str4, objArr);
        return true;
    }

    public final boolean h(List<c> list, String str) {
        if (list.size() <= 0) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            return false;
        }
        long er;
        g gVar;
        v.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", str, Integer.valueOf(list.size()));
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        List<c> rj = rj(str);
        Map hashMap = new HashMap();
        for (c cVar : rj) {
            c cVar2;
            hashMap.put(cVar2.EB(), cVar2);
        }
        for (int i = 0; i < list.size(); i++) {
            cVar2 = (c) list.get(i);
            cVar2.field_temp = 0;
            this.cie.replace("EmojiInfo", "md5", cVar2.py());
            hashMap.remove(cVar2.EB());
        }
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            cVar2 = (c) entry.getValue();
            cVar2.field_temp = 1;
            this.cie.update("EmojiInfo", cVar2.py(), "md5=?", new String[]{str2});
            v.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", cVar2.field_groupId);
        }
        if (gVar != null) {
            gVar.es(er);
        }
        return true;
    }

    public final boolean NH(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.cie.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e.getMessage());
            return false;
        }
    }

    public final List<String> bxP() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", be.e(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int bxQ() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"});
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getCount();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", be.e(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final boolean aj(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            return false;
        }
        v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", Integer.valueOf(linkedList.size()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(c.nxg);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append("'" + ((String) linkedList.get(i)) + "'");
            if (i < linkedList.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        v.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        return this.cie.dF("EmojiInfo", stringBuilder.toString());
    }

    public final ArrayList<String> bxR() {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select md5 from EmojiInfo where needupload=? and catalog=?", new String[]{String.valueOf(c.nxg), String.valueOf(a.nwL)});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", be.e(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int bxS() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(a.nwL)});
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            v.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", be.e(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final ArrayList<c> bxT() {
        Throwable e;
        Cursor rawQuery;
        try {
            rawQuery = this.cie.rawQuery("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[]{String.valueOf(a.nwL), String.valueOf(a.nwM)});
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        ArrayList<c> arrayList = new ArrayList();
                        do {
                            c cVar = new c();
                            cVar.b(rawQuery);
                            if ((cVar.field_reserved4 & c.nxh) != c.nxh) {
                                arrayList.add(cVar);
                            }
                        } while (rawQuery.moveToNext());
                        if (rawQuery == null) {
                            return arrayList;
                        }
                        rawQuery.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", be.e(e));
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw e;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", be.e(e));
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw e;
        }
        return null;
    }

    public final String getKey() {
        Throwable e;
        Cursor rawQuery;
        try {
            String string;
            rawQuery = this.cie.rawQuery("SELECT md5 FROM EmojiInfo WHERE catalog =?", new String[]{"153"});
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        string = rawQuery.getString(0);
                        v.i("MicroMsg.emoji.EmojiInfoStorage", "had key :%s" + be.KW(string));
                        if (rawQuery == null) {
                            return string;
                        }
                        rawQuery.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", be.e(e));
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw e;
                    }
                }
            }
            string = be.dW(aa.getContext());
            if (be.kS(string)) {
                string = com.tencent.mm.a.g.m("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
            } else {
                string = com.tencent.mm.a.g.m(string.getBytes());
            }
            v.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + be.KW(string));
            c cVar = new c();
            cVar.field_md5 = string;
            cVar.field_catalog = 153;
            if (!q(cVar)) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } else if (rawQuery == null) {
                return string;
            } else {
                rawQuery.close();
                return string;
            }
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            v.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", be.e(e));
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw e;
        }
    }

    public final boolean ck(List<nu> list) {
        int i = 0;
        if (list == null || list.isEmpty()) {
            v.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            return false;
        }
        long er;
        g gVar;
        v.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", Integer.valueOf(list.size()));
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            v.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", Long.valueOf(er));
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        while (i < list.size()) {
            nu nuVar = (nu) list.get(i);
            c NF = NF(nuVar.mpC);
            if (NF == null) {
                NF = new c();
                NF.field_md5 = nuVar.mpC;
                NF.field_catalog = c.nwM;
                v.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            NF.field_cdnUrl = nuVar.glb;
            NF.field_encrypturl = nuVar.mpE;
            NF.field_aeskey = nuVar.mpF;
            NF.field_designerID = nuVar.mpD;
            NF.field_thumbUrl = nuVar.hOx;
            NF.field_groupId = nuVar.mdM;
            r(NF);
            i++;
        }
        if (gVar != null) {
            gVar.es(er);
            v.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        return true;
    }
}
