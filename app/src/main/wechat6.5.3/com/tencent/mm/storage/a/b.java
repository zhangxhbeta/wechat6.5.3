package com.tencent.mm.storage.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ah;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class b extends f<a> implements a {
    public static final String[] cic = new String[]{f.a(a.chq, "EmojiGroupInfo")};
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return c((a) cVar);
    }

    public b(d dVar) {
        super(dVar, a.chq, "EmojiGroupInfo", null);
        this.cie = dVar;
    }

    public final String getTableName() {
        return "EmojiGroupInfo";
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final boolean ee(Context context) {
        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
        ef(context);
        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
        return true;
    }

    private ArrayList<a> ef(Context context) {
        InputStream inputStream = null;
        Object arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            NodeList elementsByTagName = newInstance.newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                a aVar = new a();
                Element element = (Element) elementsByTagName.item(i);
                int intValue = Integer.decode(element.getAttribute("id")).intValue();
                if (!TextUtils.isEmpty(element.getAttribute("sort"))) {
                    v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", Integer.valueOf(intValue), Integer.decode(element.getAttribute("sort")));
                    int i2 = a.nwK;
                    if ((intValue & i2) == i2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0 || (bxl() <= 0 && !bxt())) {
                        aVar.field_sort = i + 1;
                    } else {
                        aVar.field_sort = -1;
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(208912, Boolean.valueOf(true));
                        v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
                    }
                }
                aVar.field_productID = String.valueOf(intValue);
                aVar.field_packName = element.getAttribute("name");
                if (!TextUtils.isEmpty(element.getAttribute("type"))) {
                    aVar.field_type = Integer.decode(element.getAttribute("type")).intValue();
                }
                if (!TextUtils.isEmpty(element.getAttribute("free"))) {
                    aVar.field_packType = Integer.decode(element.getAttribute("type")).intValue();
                }
                if (aVar.field_type == a.TYPE_SYSTEM || aVar.field_type == a.TYPE_CUSTOM) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() > 0) {
                ch(arrayList);
            }
            v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    v.a("MicroMsg.emoji.EmojiGroupInfoStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        } catch (Throwable e2) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", be.e(e2));
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + e2.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    v.a("MicroMsg.emoji.EmojiGroupInfoStorage", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        } catch (Throwable e222) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", be.e(e222));
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + e222.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2222) {
                    v.a("MicroMsg.emoji.EmojiGroupInfoStorage", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    v.a("MicroMsg.emoji.EmojiGroupInfoStorage", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.a.a aI(java.lang.String r9, boolean r10) {
        /*
        r8 = this;
        r1 = 0;
        r0 = "select * from EmojiGroupInfo where productID= ?";
        r2 = r8.cie;	 Catch:{ Exception -> 0x0032, all -> 0x0061 }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0032, all -> 0x0061 }
        r4 = 0;
        r3[r4] = r9;	 Catch:{ Exception -> 0x0032, all -> 0x0061 }
        r3 = r2.rawQuery(r0, r3);	 Catch:{ Exception -> 0x0032, all -> 0x0061 }
        if (r3 == 0) goto L_0x0026;
    L_0x0012:
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0074, all -> 0x006f }
        if (r0 == 0) goto L_0x0026;
    L_0x0018:
        r0 = new com.tencent.mm.storage.a.a;	 Catch:{ Exception -> 0x0074, all -> 0x006f }
        r0.<init>();	 Catch:{ Exception -> 0x0074, all -> 0x006f }
        r0.b(r3);	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        if (r3 == 0) goto L_0x0025;
    L_0x0022:
        r3.close();
    L_0x0025:
        return r0;
    L_0x0026:
        if (r3 == 0) goto L_0x0080;
    L_0x0028:
        r3.close();
        r0 = r1;
    L_0x002c:
        if (r0 != 0) goto L_0x0025;
    L_0x002e:
        if (r10 == 0) goto L_0x0069;
    L_0x0030:
        r0 = r1;
        goto L_0x0025;
    L_0x0032:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x0035:
        r4 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0072 }
        r6 = "get getEmojiGroupInof fail. product id is";
        r5.<init>(r6);	 Catch:{ all -> 0x0072 }
        r5 = r5.append(r9);	 Catch:{ all -> 0x0072 }
        r6 = " ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0072 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0072 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x0072 }
        r0 = r0.toString();	 Catch:{ all -> 0x0072 }
        com.tencent.mm.sdk.platformtools.v.e(r4, r0);	 Catch:{ all -> 0x0072 }
        if (r2 == 0) goto L_0x007e;
    L_0x005c:
        r2.close();
        r0 = r3;
        goto L_0x002c;
    L_0x0061:
        r0 = move-exception;
        r2 = r1;
    L_0x0063:
        if (r2 == 0) goto L_0x0068;
    L_0x0065:
        r2.close();
    L_0x0068:
        throw r0;
    L_0x0069:
        r0 = new com.tencent.mm.storage.a.a;
        r0.<init>();
        goto L_0x0025;
    L_0x006f:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0063;
    L_0x0072:
        r0 = move-exception;
        goto L_0x0063;
    L_0x0074:
        r0 = move-exception;
        r2 = r3;
        r3 = r1;
        goto L_0x0035;
    L_0x0078:
        r2 = move-exception;
        r7 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x0035;
    L_0x007e:
        r0 = r3;
        goto L_0x002c;
    L_0x0080:
        r0 = r1;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.aI(java.lang.String, boolean):com.tencent.mm.storage.a.a");
    }

    private int bxl() {
        int i = 0;
        Cursor cursor = null;
        String str = "select  count(*) from EmojiInfo where catalog=?";
        try {
            cursor = this.cie.rawQuery(str, new String[]{a.nwL});
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
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

    public final boolean bxm() {
        boolean z = true;
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("select * from EmojiGroupInfo where type=?", new String[]{a.TYPE_SYSTEM});
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            a aVar = new a();
            aVar.b(cursor);
            if ((aVar.field_flag & FileUtils.S_IRUSR) > 0) {
                z = false;
            }
            if (cursor == null) {
                return z;
            }
            cursor.close();
            return z;
        } catch (Exception e) {
            v.d("MicroMsg.emoji.EmojiGroupInfoStorage", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<a> bxn() {
        Cursor cursor = null;
        List<a> arrayList = new ArrayList();
        try {
            cursor = this.cie.rawQuery("select * from EmojiGroupInfo where " + vj(a.TYPE_SYSTEM) + " or " + vj(a.TYPE_CUSTOM) + " order by sort ASC", null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get system group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<a> bxo() {
        Cursor cursor = null;
        List<a> arrayList = new ArrayList();
        try {
            cursor = this.cie.rawQuery("select * from EmojiGroupInfo where " + bxw() + " order by sort ASC,lastUseTime DESC", null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final HashMap<String, a> bxp() {
        Cursor cursor = null;
        HashMap<String, a> hashMap = new HashMap();
        try {
            cursor = this.cie.rawQuery("select * from EmojiGroupInfo where " + bxw() + " order by sort ASC,lastUseTime DESC", null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                hashMap.put(aVar.field_productID, aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final ArrayList<a> bxq() {
        Cursor cursor = null;
        ArrayList<a> arrayList = new ArrayList();
        try {
            cursor = this.cie.rawQuery("select * from EmojiGroupInfo where " + bxx() + " order by sort ASC,lastUseTime DESC", null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int bxr() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.cie.rawQuery("select count(*) from EmojiGroupInfo where " + bxx() + " order by sort ASC,lastUseTime DESC", null);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + e.getMessage());
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

    public final HashMap<String, ah> bxs() {
        Cursor cursor = null;
        HashMap<String, ah> hashMap = new HashMap();
        try {
            cursor = this.cie.rawQuery("select * from EmojiGroupInfo where " + bxx() + " order by sort ASC,lastUseTime DESC", null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            ah ahVar = new ah();
            do {
                String string = cursor.getString(cursor.getColumnIndex("productID"));
                ahVar.aZD = string;
                ahVar.fkg = cursor.getString(cursor.getColumnIndex("packName"));
                ahVar.ve(7);
                hashMap.put(string, ahVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean Nz(String str) {
        Cursor cursor = null;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
        }
        try {
            cursor = this.cie.rawQuery("select count(*) from EmojiGroupInfo where productID = '" + str + "' AND " + bxy() + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ", null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            }
            if (cursor.getInt(0) > 0) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
            return z;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static boolean bxt() {
        ak.yW();
        return ((Boolean) com.tencent.mm.model.c.vf().get(208912, Boolean.valueOf(false))).booleanValue();
    }

    public final boolean c(a aVar) {
        if (aVar == null) {
            v.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
            return false;
        }
        aVar.field_lastUseTime = System.currentTimeMillis();
        aVar.field_sort = 1;
        v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", aVar.field_packName, Long.valueOf(aVar.field_lastUseTime));
        aVar.field_lastUseTime = System.currentTimeMillis();
        if (aVar != null) {
            aVar.field_flag &= -257;
        }
        boolean a = a((c) aVar);
        if (a) {
            a("event_update_group", 0, be.bur().toString());
        }
        return a;
    }

    public final boolean ch(List<a> list) {
        if (list == null || list.size() <= 0) {
            v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
            return false;
        }
        long er;
        g gVar;
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", Long.valueOf(er));
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", r0.field_productID, Long.valueOf(r0.field_lastUseTime), Integer.valueOf(((a) list.get(i)).field_sort));
            a((c) r0);
        }
        if (gVar != null) {
            gVar.es(er);
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        a("event_update_group", 0, be.bur().toString());
        return true;
    }

    public final boolean NA(String str) {
        boolean z;
        if (!be.kS(str)) {
            try {
                if (str.equals("com.tencent.xin.emoticon.tusiji")) {
                    str = a.nwJ;
                }
                c aI = aI(str, true);
                if (aI == null) {
                    z = false;
                } else {
                    if (aI != null) {
                        if (aI.field_type == a.TYPE_CUSTOM) {
                            v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
                        } else {
                            aI.field_flag |= FileUtils.S_IRUSR;
                            aI.field_status = -1;
                            aI.field_sort = 1;
                            aI.field_recommand = 0;
                            aI.field_sync = 0;
                        }
                    }
                    aI.field_lastUseTime = System.currentTimeMillis();
                    aI.field_recommand = 0;
                    aI.field_sync = 0;
                    z = a(aI);
                }
            } catch (Exception e) {
                v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + e.getMessage());
            }
            if (z) {
                a("event_update_group", 0, be.bur().toString());
                Lf("delete_group");
            }
            return z;
        }
        z = false;
        if (z) {
            a("event_update_group", 0, be.bur().toString());
            Lf("delete_group");
        }
        return z;
    }

    public final void Z(ArrayList<String> arrayList) {
        long er;
        g gVar;
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", Long.valueOf(er));
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                NA((String) it.next());
            }
        }
        if (gVar != null) {
            gVar.es(er);
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
        }
    }

    public final void bxu() {
        if (this.cie.dF("EmojiGroupInfo", "UPDATE EmojiGroupInfo SET sort=-1,lastUseTime=" + System.currentTimeMillis() + " WHERE type=" + (a.TYPE_CUSTOM))) {
            a("event_update_group", 0, be.bur().toString());
        }
        ak.yW();
        com.tencent.mm.model.c.vf().set(208912, Boolean.valueOf(true));
    }

    public final ArrayList<a> bxv() {
        Cursor cursor = null;
        ArrayList<a> arrayList = new ArrayList();
        try {
            cursor = this.cie.rawQuery("select * from EmojiGroupInfo where " + bxx() + " or " + vj(a.TYPE_SYSTEM) + " or " + vj(a.TYPE_CUSTOM) + " or " + (" ( recommand = '1" + "' ) ") + " order by sort ASC,idx ASC,lastUseTime DESC", null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String bxw() {
        return vi(a.TYPE_SYSTEM) + " or " + vi(a.TYPE_CUSTOM) + " or " + vi(a.nwG) + " or " + vi(a.nwI);
    }

    private static String bxx() {
        return " ( " + vi(a.nwG) + " and " + bxy() + " ) ";
    }

    private static String vi(int i) {
        return " ( type = '" + i + "' ) ";
    }

    private static String bxy() {
        return " ( status = '7" + "' ) ";
    }

    private static String vj(int i) {
        return " ( " + vi(i) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean bxz() {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r3 = "select sync from EmojiGroupInfo where (type= ? or type= ? ) and sync=? and status=?";
        r2 = 4;
        r4 = new java.lang.String[r2];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4[r1] = r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = com.tencent.mm.storage.a.a.nwG;
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4[r0] = r2;
        r2 = 2;
        r5 = "0";
        r4[r2] = r5;
        r2 = 3;
        r5 = "7";
        r4[r2] = r5;
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r5 = "checkStoreEmojiSync:%s";
        r6 = new java.lang.Object[r0];
        r6[r1] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r2, r5, r6);
        r2 = 0;
        r5 = r7.cie;	 Catch:{ Exception -> 0x005f, all -> 0x0070 }
        r2 = r5.rawQuery(r3, r4);	 Catch:{ Exception -> 0x005f, all -> 0x0070 }
        if (r2 == 0) goto L_0x0058;
    L_0x004c:
        r3 = r2.moveToFirst();	 Catch:{ Exception -> 0x007b, all -> 0x0070 }
        if (r3 == 0) goto L_0x0058;
    L_0x0052:
        if (r2 == 0) goto L_0x0057;
    L_0x0054:
        r2.close();
    L_0x0057:
        return r0;
    L_0x0058:
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        r2.close();
    L_0x005d:
        r0 = r1;
        goto L_0x0057;
    L_0x005f:
        r0 = move-exception;
        r0 = r2;
    L_0x0061:
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r3 = "checkStoreEmojiSync fail.";
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x005d;
    L_0x006c:
        r0.close();
        goto L_0x005d;
    L_0x0070:
        r0 = move-exception;
    L_0x0071:
        if (r2 == 0) goto L_0x0076;
    L_0x0073:
        r2.close();
    L_0x0076:
        throw r0;
    L_0x0077:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x0071;
    L_0x007b:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.bxz():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> bxA() {
        /*
        r8 = this;
        r6 = 1;
        r5 = 0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "select productID from EmojiGroupInfo where type=? and sync=?";
        r0 = 2;
        r3 = new java.lang.String[r0];
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = com.tencent.mm.storage.a.a.nwG;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3[r5] = r0;
        r0 = "1";
        r3[r6] = r0;
        r0 = 0;
        r4 = r8.cie;	 Catch:{ Exception -> 0x0046, all -> 0x0060 }
        r0 = r4.rawQuery(r2, r3);	 Catch:{ Exception -> 0x0046, all -> 0x0060 }
        if (r0 == 0) goto L_0x0040;
    L_0x002c:
        r2 = r0.moveToFirst();	 Catch:{ Exception -> 0x0046 }
        if (r2 == 0) goto L_0x0040;
    L_0x0032:
        r2 = 0;
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x0046 }
        r1.add(r2);	 Catch:{ Exception -> 0x0046 }
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x0046 }
        if (r2 != 0) goto L_0x0032;
    L_0x0040:
        if (r0 == 0) goto L_0x0045;
    L_0x0042:
        r0.close();
    L_0x0045:
        return r1;
    L_0x0046:
        r2 = move-exception;
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r3 = "getNeedToSyncStoreEmojiProductList. exception.%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x006a }
        r5 = 0;
        r6 = com.tencent.mm.sdk.platformtools.be.bur();	 Catch:{ all -> 0x006a }
        r4[r5] = r6;	 Catch:{ all -> 0x006a }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0045;
    L_0x005c:
        r0.close();
        goto L_0x0045;
    L_0x0060:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0064:
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r1.close();
    L_0x0069:
        throw r0;
    L_0x006a:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.bxA():java.util.List<java.lang.String>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> bxB() {
        /*
        r8 = this;
        r5 = 1;
        r4 = 0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)";
        r0 = 5;
        r3 = new java.lang.String[r0];
        r0 = "0";
        r3[r4] = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = com.tencent.mm.storage.a.a.nwG;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3[r5] = r0;
        r0 = 2;
        r4 = "7";
        r3[r0] = r4;
        r0 = 3;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3[r0] = r4;
        r0 = 4;
        r4 = "0";
        r3[r0] = r4;
        r0 = 0;
        r4 = r8.cie;	 Catch:{ Exception -> 0x0064, all -> 0x007e }
        r0 = r4.rawQuery(r2, r3);	 Catch:{ Exception -> 0x0064, all -> 0x007e }
        if (r0 == 0) goto L_0x005e;
    L_0x004a:
        r2 = r0.moveToFirst();	 Catch:{ Exception -> 0x0064 }
        if (r2 == 0) goto L_0x005e;
    L_0x0050:
        r2 = 0;
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x0064 }
        r1.add(r2);	 Catch:{ Exception -> 0x0064 }
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x0064 }
        if (r2 != 0) goto L_0x0050;
    L_0x005e:
        if (r0 == 0) goto L_0x0063;
    L_0x0060:
        r0.close();
    L_0x0063:
        return r1;
    L_0x0064:
        r2 = move-exception;
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r3 = "getNeedToUploadStoreEmojiProductList. exception.%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0088 }
        r5 = 0;
        r6 = com.tencent.mm.sdk.platformtools.be.bur();	 Catch:{ all -> 0x0088 }
        r4[r5] = r6;	 Catch:{ all -> 0x0088 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0088 }
        if (r0 == 0) goto L_0x0063;
    L_0x007a:
        r0.close();
        goto L_0x0063;
    L_0x007e:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0082:
        if (r1 == 0) goto L_0x0087;
    L_0x0084:
        r1.close();
    L_0x0087:
        throw r0;
    L_0x0088:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.bxB():java.util.List<java.lang.String>");
    }

    public final ArrayList<a> bxC() {
        ArrayList<a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery(new StringBuilder("select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC").toString(), new String[]{a.nwG, "7", a.TYPE_SYSTEM, "0"});
            v.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void bxD() {
        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
        c aI = aI(String.valueOf(a.nwK), false);
        if (aI == null) {
            aI = new a();
        } else {
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", aI.toString());
        }
        aI.field_productID = String.valueOf(a.nwK);
        aI.field_packName = "emoji_custom_group";
        aI.field_type = a.TYPE_CUSTOM;
        aI.field_status = 0;
        aI.field_packStatus = 1;
        aI.field_flag = 0;
        a(aI);
        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
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
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", be.e(e));
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
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
        v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return i;
    }
}
