package com.tencent.mm.plugin.emoji.d;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class b {
    Comparator faA = new Comparator<a>(this) {
        final /* synthetic */ b faB;

        {
            this.faB = r1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    return 1;
                }
                if (aVar.index == aVar2.index) {
                    return 0;
                }
                if (aVar.index > aVar2.index) {
                    return 1;
                }
            }
            return -1;
        }
    };
    String fat;
    int fau = 2;
    int fav = 32;
    HashMap<String, String> faw = new HashMap();
    HashMap<String, ArrayList<String>> fax = new HashMap();
    HashMap<String, String> fay = new HashMap();
    HashMap<String, ArrayList<a>> faz = new HashMap();

    class a {
        String aZy;
        final /* synthetic */ b faB;
        int index;

        a(b bVar, String str, int i) {
            this.faB = bVar;
            this.aZy = str;
            this.index = i;
        }
    }

    public final void clear() {
        if (this.faw != null) {
            this.faw.clear();
        }
        if (this.fax != null) {
            this.fax.clear();
        }
        if (this.fay != null) {
            this.fay.clear();
        }
        if (this.faz != null) {
            this.faz.clear();
        }
    }

    public final void aeR() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ b faB;

            {
                this.faB = r1;
            }

            public final void run() {
                int i;
                String str;
                ArrayList arrayList;
                long currentTimeMillis = System.currentTimeMillis();
                b bVar = this.faB;
                bVar.clear();
                Cursor cursor = null;
                try {
                    cursor = g.afx().fcr.Kp();
                    if (cursor != null && cursor.moveToFirst()) {
                        int count = cursor.getCount();
                        for (i = 0; i < count; i++) {
                            com.tencent.mm.storage.a.g gVar = new com.tencent.mm.storage.a.g();
                            gVar.b(cursor);
                            str = gVar.field_desc;
                            if (!be.kS(str)) {
                                bVar.fay.put(str.toLowerCase(), gVar.field_groupID);
                                arrayList = (ArrayList) bVar.fax.get(gVar.field_groupID);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(gVar.field_desc);
                                bVar.fax.put(gVar.field_groupID, arrayList);
                            }
                            cursor.moveToNext();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.EmojiDescNewMgr", be.e(e));
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                String toLowerCase = u.bsY().toLowerCase();
                String str2 = "default";
                bVar.fat = toLowerCase;
                cursor = null;
                str = "select EmojiInfoDesc.desc,EmojiInfoDesc.md5,EmojiInfoDesc.lang,EmojiGroupInfo.lastUseTime,EmojiInfoDesc.groupId,EmojiGroupInfo.productID,EmojiGroupInfo.idx from EmojiInfoDesc,EmojiGroupInfo where EmojiInfoDesc.groupId=EmojiGroupInfo.productID and EmojiGroupInfo.status='7' order by EmojiGroupInfo.sort desc,EmojiGroupInfo.lastUseTime desc";
                try {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    cursor = g.afx().fcj.rawQuery(str, new String[0]);
                    v.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[tryInit]  rawQuery use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis2)});
                    if (cursor != null && cursor.moveToFirst()) {
                        cursor.moveToFirst();
                        int count2 = cursor.getCount();
                        for (i = 0; i < count2; i++) {
                            str = cursor.getString(cursor.getColumnIndex("desc"));
                            String string = cursor.getString(cursor.getColumnIndex("md5"));
                            String string2 = cursor.getString(cursor.getColumnIndex("lang"));
                            int i2 = cursor.getInt(cursor.getColumnIndex("idx"));
                            if (!(be.kS(str) || be.kS(string2) || (!string2.equals(toLowerCase) && !string2.equals(str2)))) {
                                string2 = str.toLowerCase();
                                if (bVar.faz.containsKey(string2)) {
                                    arrayList = (ArrayList) bVar.faz.get(string2);
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(new a(bVar, string, i2));
                                } else {
                                    arrayList = new ArrayList();
                                    arrayList.add(new a(bVar, string, i2));
                                    bVar.faz.put(string2, arrayList);
                                }
                                bVar.faw.put(string, string2);
                            }
                            cursor.moveToNext();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable e2) {
                    v.w("MicroMsg.emoji.EmojiDescNewMgr", be.e(e2));
                    v.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                v.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
            }

            public final String toString() {
                return super.toString() + "|newinit";
            }
        });
    }
}
