package com.tencent.mm.plugin.bottle.a;

import android.database.Cursor;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.f;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import java.util.HashMap;

public final class i implements ag {
    private static HashMap<Integer, c> bXq;
    private b csL = new b(this) {
        final /* synthetic */ i ets;

        {
            this.ets = r1;
        }

        public final void a(ab abVar, ac acVar) {
            if (abVar != null) {
                if ("_USER_FOR_THROWBOTTLE_".equals(abVar.field_username)) {
                    abVar.setUsername("");
                } else if (1 != abVar.field_isSend && u.ew(abVar.field_username) && !acVar.Mo(abVar.field_username)) {
                    c.px(abVar.field_username);
                }
            }
        }
    };
    private b etr;

    private static i XF() {
        i iVar = (i) ak.yP().fY("plugin.bottle");
        if (iVar != null) {
            return iVar;
        }
        iVar = new i();
        ak.yP().a("plugin.bottle", iVar);
        return iVar;
    }

    public static b XG() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (XF().etr == null) {
            i XF = XF();
            ak.yW();
            XF.etr = new b(com.tencent.mm.model.c.wE());
        }
        return XF().etr;
    }

    public final void th() {
        ak.yW();
        com.tencent.mm.model.c.wK().b(this.csL);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return b.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
        if ((i & 64) != 0) {
            XH();
        }
    }

    public static void XH() {
        ak.yW();
        Cursor bvL = com.tencent.mm.model.c.wK().bvL();
        for (int i = 0; i < bvL.getCount(); i++) {
            bvL.moveToPosition(i);
            ab abVar = new ab();
            abVar.b(bvL);
            ak.yW();
            at MH = com.tencent.mm.model.c.wJ().MH(abVar.field_username);
            ak.yW();
            com.tencent.mm.model.c.wG().b(new d(abVar.field_username, MH.field_msgSvrId));
            ak.yW();
            com.tencent.mm.model.c.wG().b(new f(abVar.field_username, 0));
            ak.yW();
            com.tencent.mm.model.c.wH().Mc(abVar.field_username);
        }
        bvL.close();
        ak.yW();
        com.tencent.mm.model.c.wJ().Mg("@bottle");
        ak.yW();
        ac wK = com.tencent.mm.model.c.wK();
        v.w("MicroMsg.ConversationStorage", "deleteBottleConversation stack:%s", new Object[]{af.btA()});
        if (wK.cie.dF("rconversation", "delete from rbottleconversation")) {
            wK.b(5, wK, "");
        }
        ak.yW();
        com.tencent.mm.model.c.wK().Mg("floatbottle");
        aw.zl();
        XG().cuX.delete("bottleinfo1", null, null);
    }

    public final void aG(boolean z) {
        c.XB();
        ak.yW();
        com.tencent.mm.model.c.wK().a(this.csL);
    }

    public final void aH(boolean z) {
    }
}
