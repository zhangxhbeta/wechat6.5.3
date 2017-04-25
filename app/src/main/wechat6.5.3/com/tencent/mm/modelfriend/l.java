package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class l extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) "};
    private com.tencent.mm.bg.g cuX;

    public l(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.modelfriend.k r9) {
        /*
        r8 = this;
        r6 = -1;
        r1 = 1;
        r2 = 0;
        r0 = r9.getUsername();
        r3 = new java.lang.StringBuilder;
        r4 = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"";
        r3.<init>(r4);
        r0 = com.tencent.mm.sdk.platformtools.be.lZ(r0);
        r0 = r3.append(r0);
        r3 = "\"";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r3 = r8.cuX;
        r4 = 0;
        r3 = r3.rawQuery(r0, r4);
        r0 = r3.getCount();
        if (r0 <= 0) goto L_0x005a;
    L_0x002f:
        r0 = r1;
    L_0x0030:
        r3.close();
        if (r0 == 0) goto L_0x005e;
    L_0x0035:
        if (r9 == 0) goto L_0x005c;
    L_0x0037:
        r0 = r9.py();
        r3 = r0.size();
        if (r3 <= 0) goto L_0x0077;
    L_0x0041:
        r3 = r8.cuX;
        r4 = "friend_ext";
        r5 = "username=?";
        r6 = new java.lang.String[r1];
        r7 = "username";
        r6[r2] = r7;
        r0 = r3.update(r4, r0, r5, r6);
    L_0x0054:
        if (r0 <= 0) goto L_0x005c;
    L_0x0056:
        r8.Ls();
        return r1;
    L_0x005a:
        r0 = r2;
        goto L_0x0030;
    L_0x005c:
        r1 = r2;
        goto L_0x0056;
    L_0x005e:
        if (r9 == 0) goto L_0x0075;
    L_0x0060:
        r9.bkU = r6;
        r0 = r9.py();
        r3 = r8.cuX;
        r4 = "friend_ext";
        r5 = "username";
        r4 = r3.insert(r4, r5, r0);
        r0 = (int) r4;
        if (r0 != r6) goto L_0x0056;
    L_0x0075:
        r1 = r2;
        goto L_0x0056;
    L_0x0077:
        r0 = r2;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelfriend.l.a(com.tencent.mm.modelfriend.k):boolean");
    }

    public final boolean z(List<k> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        bc bcVar = new bc("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
        bcVar.addSplit("transation begin");
        long er = this.cuX.er(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                k kVar = (k) list.get(i);
                if (kVar != null) {
                    a(kVar);
                }
                i++;
            } catch (Exception e) {
                v.e("MicroMsg.FriendExtStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.cuX.es(er);
        bcVar.addSplit("transation end");
        bcVar.dumpToLog();
        Ls();
        return z;
    }

    public final k iH(String str) {
        k kVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + be.lZ(str) + "\"", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                kVar = new k();
                kVar.username = rawQuery.getString(0);
                kVar.bBZ = rawQuery.getInt(1);
                kVar.bCi = rawQuery.getInt(2);
                kVar.bCk = rawQuery.getString(3);
                kVar.bCl = rawQuery.getString(4);
                kVar.bCj = rawQuery.getString(5);
            }
            rawQuery.close();
        }
        return kVar;
    }
}
