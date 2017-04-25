package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.e.a.lb;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.a.e;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.storage.a.h;
import com.tencent.mm.storage.a.l;
import com.tencent.mm.storage.a.n;
import com.tencent.mm.storage.a.p;
import com.tencent.mm.storage.a.r;
import com.tencent.mm.storage.a.t;
import java.util.ArrayList;
import java.util.HashMap;

public final class m {
    public static int dLy = -1;
    public static boolean fcs = false;
    public static boolean fct = false;
    public static boolean fcu = false;
    public static boolean fcv = false;
    public static ArrayList<a> fcw = new ArrayList();
    public static HashMap<String, ArrayList<c>> fcx = new HashMap();
    public final g.a fcA = new g.a(this) {
        final /* synthetic */ m fcC;

        {
            this.fcC = r1;
        }

        public final void a(String str, i iVar) {
            if (str != null) {
                if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                    m.fct = true;
                    return;
                }
                c rg = j.a.bmr().rg(str);
                if (rg != null && rg.field_catalog == c.nwR) {
                    m.fct = true;
                }
            }
        }
    };
    public final com.tencent.mm.sdk.c.c fcB = new com.tencent.mm.sdk.c.c<lb>(this) {
        final /* synthetic */ m fcC;

        {
            this.fcC = r2;
            this.nhz = lb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            v.i("MicroMsg.emoji.EmojiStorageMgr", "REFRESH_PANEL_EVENT");
            m.fct = true;
            return false;
        }
    };
    public f fch;
    public com.tencent.mm.storage.a.b fci;
    public e fcj;
    public r fck;
    public l fcl;
    public n fcm;
    public com.tencent.mm.storage.a.j fcn;
    public p fco;
    t fcp;
    com.tencent.mm.storage.a.v fcq;
    h fcr;
    public final g.a fcy = new g.a(this) {
        final /* synthetic */ m fcC;

        {
            this.fcC = r1;
        }

        public final void a(String str, i iVar) {
            if (!be.kS(str) && str.equals("event_update_group")) {
                v.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[]{(String) iVar.obj});
                ak.yW();
                if (com.tencent.mm.model.c.ww() != 0) {
                    com.tencent.mm.plugin.emoji.model.g.afs().aeR();
                } else {
                    return;
                }
            }
            if (!be.kS(str)) {
                if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                    v.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
                    m.fcs = true;
                    m.fcv = true;
                }
            }
        }
    };
    public final g.a fcz = new g.a(this) {
        final /* synthetic */ m fcC;

        {
            this.fcC = r1;
        }

        public final void a(String str, i iVar) {
            com.tencent.mm.plugin.emoji.model.g.afs().aeR();
        }
    };

    public m() {
        ak.yW();
        this.fch = new f(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fci = new com.tencent.mm.storage.a.b(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fcj = new e(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fcl = new l(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fcm = new n(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fcn = new com.tencent.mm.storage.a.j(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fck = new r(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fco = new p(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fcp = new t(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fcq = new com.tencent.mm.storage.a.v(com.tencent.mm.model.c.wE());
        ak.yW();
        this.fcr = new h(com.tencent.mm.model.c.wE());
    }

    public final ArrayList<c> afi() {
        if (fcx == null) {
            fcx = new HashMap();
        }
        if (!fcx.containsKey("custom") || fct) {
            fcx.put("custom", (ArrayList) this.fch.bxM());
        }
        fct = false;
        return (ArrayList) fcx.get("custom");
    }
}
