package com.tencent.mm.y;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class d extends w {
    public final void transfer(int i) {
        v.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (eH(i)) {
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            if (be.f((Integer) c.vf().get(86017, null)) == 3) {
                v.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
                return;
            }
            ak.yW();
            c.wE().dF("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
            ak.yW();
            Cursor c = c.wH().c("@all.weixin.android", SQLiteDatabase.KeyEmpty, null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                ab uVar = new u();
                uVar.b(c);
                ak.yW();
                aa wH = c.wH();
                String str = uVar.field_username;
                if (str != null) {
                    if (u.ew(str)) {
                        str = u.LM(str);
                    }
                    uVar.cP(uVar.tm());
                    if (m.d(uVar)) {
                        uVar.cP(43);
                        uVar.bT(com.tencent.mm.platformtools.c.lU(uVar.tT()));
                        uVar.bU(com.tencent.mm.platformtools.c.lT(uVar.tT()));
                        uVar.bW(com.tencent.mm.platformtools.c.lT(uVar.tU()));
                        uVar.bX(uVar.tU());
                    } else {
                        if (m.fc(uVar.field_username)) {
                            v.i("MicroMsg.ContactStorage", "update official account helper showhead %d", Integer.valueOf(31));
                            uVar.cP(31);
                        }
                        wH.cBg.bg(uVar);
                        wH.cBg.Ls();
                        v.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", uVar.field_username, Integer.valueOf(uVar.field_showHead), Integer.valueOf(uVar.field_verifyFlag));
                        ContentValues py = uVar.py();
                        if (((int) uVar.chr) > 0) {
                            py.put("rowid", Integer.valueOf((int) uVar.chr));
                        }
                        if (py.size() > 0) {
                            wH.cie.update(aa.LR(str), py, "username=?", new String[]{str});
                        }
                    }
                }
                c.moveToNext();
            }
            c.close();
            v.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            ak.yW();
            c.vf().set(86017, Integer.valueOf(3));
            v.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return;
        }
        v.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
    }

    public final boolean eH(int i) {
        return i != 0 && i < 604176383;
    }

    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
