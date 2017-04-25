package com.tencent.mm.booter;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class l {
    public static void run() {
        ak.yW();
        boolean a = t.a((Boolean) c.vf().get(67841, null), true);
        if (!(m.EY() == a.SUCC || m.EY() == a.SUCC_UNLOAD)) {
            a = false;
        }
        if (a) {
            v.d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List iC = ah.FL().iC("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + be.lZ(SQLiteDatabase.KeyEmpty) + "\" )");
            v.d("MicroMsg.PostTaskUpdateCtRemark", "list " + iC.size());
            for (int i = 0; i < iC.size(); i++) {
                String username = ((b) iC.get(i)).getUsername();
                String trim = ((b) iC.get(i)).ED().trim();
                if (!(username == null || username.equals(SQLiteDatabase.KeyEmpty) || trim == null || trim.equals(SQLiteDatabase.KeyEmpty))) {
                    ak.yW();
                    ab LX = c.wH().LX(username);
                    if (com.tencent.mm.i.a.ei(LX.field_type) && (LX.field_conRemark == null || LX.field_conRemark.equals(SQLiteDatabase.KeyEmpty))) {
                        v.d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        com.tencent.mm.model.m.b(LX, trim);
                    }
                }
            }
            ak.yW();
            c.vf().set(67841, Boolean.valueOf(false));
        }
        v.d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
    }
}
