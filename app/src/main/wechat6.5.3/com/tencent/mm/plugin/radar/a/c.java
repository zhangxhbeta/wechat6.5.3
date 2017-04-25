package com.tencent.mm.plugin.radar.a;

import android.content.Context;
import com.tencent.mm.e.a.eq;
import com.tencent.mm.e.a.ki;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class c implements com.tencent.mm.sdk.h.j.b {
    Context context = null;
    public com.tencent.mm.model.bo.b fvh = new com.tencent.mm.model.bo.b(this) {
        final /* synthetic */ c ihO;
        final String ihP = ".sysmsg.addcontact.type";
        final String ihQ = ".sysmsg.addcontact.username";
        final String ihR = ".sysmsg.addcontact.encryptusername";

        {
            this.ihO = r2;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            Map q = bf.q(m.a(aVar.czu.mbW), "sysmsg");
            if (((String) q.get(".sysmsg.addcontact.type")).equals("1")) {
                String str = (String) q.get(".sysmsg.addcontact.username");
                String str2 = (String) q.get(".sysmsg.addcontact.encryptusername");
                if (str == null || str.equals("") || str2 == null || str2.equals("")) {
                    v.e("MicroMsg.RadarAddContact", "error! server return incorrect content! : %s", new Object[]{r2});
                    return;
                }
                u uVar = new u();
                uVar.setUsername(str);
                uVar.bY(str2);
                this.ihO.B(uVar);
                v.d("MicroMsg.RadarAddContact", "receive contact added system message useranme %s, encypt %s", new Object[]{uVar.field_username, uVar.field_encryptUsername});
            }
        }
    };
    ac handler = new ac();
    LinkedList<String> ihK = new LinkedList();
    public HashMap<String, String> ihL = new HashMap();
    b ihM = null;
    public com.tencent.mm.sdk.c.c ihN = new com.tencent.mm.sdk.c.c<ki>(this) {
        final /* synthetic */ c ihO;

        {
            this.ihO = r2;
            this.nhz = ki.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            String str = ((ki) bVar).bls.blu;
            u a = c.a(com.tencent.mm.storage.at.d.MB(str));
            this.ihO.A(a);
            c cVar = this.ihO;
            cVar.ihL.put(a.field_username, str);
            cVar.ihL.put(a.field_encryptUsername, str);
            ak.yW();
            aa wH = com.tencent.mm.model.c.wH();
            if (!wH.LZ(a.field_encryptUsername)) {
                wH.M(a);
            }
            v.d("MicroMsg.RadarAddContact", "receive verify mssage %s, encypt %s", new Object[]{a.field_username, a.field_encryptUsername});
            c cVar2 = this.ihO;
            if (cVar2.ihM != null) {
                cVar2.handler.post(new AnonymousClass5(cVar2, a));
            }
            return false;
        }
    };

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ c ihO;
        final /* synthetic */ u ihT;

        AnonymousClass5(c cVar, u uVar) {
            this.ihO = cVar;
            this.ihT = uVar;
        }

        public final void run() {
            this.ihO.ihM.C(this.ihT);
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ String cAn;
        final /* synthetic */ String cxT;
        final /* synthetic */ c ihO;
        final /* synthetic */ long ihS;
        final /* synthetic */ boolean ihU;
        final /* synthetic */ boolean ihV;

        AnonymousClass7(c cVar, boolean z, boolean z2, String str, String str2, long j) {
            this.ihO = cVar;
            this.ihU = z;
            this.ihV = z2;
            this.cAn = str;
            this.cxT = str2;
            this.ihS = j;
        }

        public final void run() {
            this.ihO.ihM.a(this.ihU, this.ihV, this.cAn, this.cxT, this.ihS);
        }
    }

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ String cAn;
        final /* synthetic */ String cxT;
        final /* synthetic */ c ihO;
        final /* synthetic */ long ihS;
        final /* synthetic */ boolean ihU;

        AnonymousClass8(c cVar, boolean z, String str, String str2, long j) {
            this.ihO = cVar;
            this.ihU = z;
            this.cAn = str;
            this.cxT = str2;
            this.ihS = j;
        }

        public final void run() {
            this.ihO.ihM.a(this.ihU, this.cAn, this.cxT, this.ihS);
        }
    }

    class a implements e {
        String dRA;
        final /* synthetic */ c ihO;
        private c ihW;
        LinkedList<String> ihX = new LinkedList();
        LinkedList<Integer> ihY;

        public a(c cVar, c cVar2) {
            this.ihO = cVar;
            this.ihW = cVar2;
        }

        public final void onStart() {
            ak.vy().a(30, this);
        }

        private void b(boolean z, boolean z2, String str, String str2) {
            ak.vy().b(30, this);
            if (this.ihW != null) {
                this.ihW.a(z, z2, str, str2);
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.d("MicroMsg.RadarAddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (kVar.getType() != 30) {
                v.w("MicroMsg.RadarAddContact", "not expected scene,  type = " + kVar.getType());
            } else if (((com.tencent.mm.pluginsdk.model.m) kVar).bdn == 2) {
                if (i == 0 && i2 == 0) {
                    b(false, true, this.dRA, "");
                    return;
                }
                if (i == 4 && i2 == -34) {
                    str = this.ihO.context.getString(2131232851);
                } else if (i == 4 && i2 == -94) {
                    str = this.ihO.context.getString(2131232852);
                } else if (!(i == 4 && i2 == -24 && !be.kS(str))) {
                    str = this.ihO.context.getString(2131234920);
                }
                b(false, false, this.dRA, str);
            } else if (i == 0 && i2 == 0) {
                b(true, false, this.dRA, "");
            } else if (i2 == -44) {
                ak.vy().a(new com.tencent.mm.pluginsdk.model.m(2, this.ihX, this.ihY, "", ""), 0);
            } else if (i2 == -87) {
                b(false, false, this.dRA, this.ihO.context.getString(2131232009));
            } else if (i2 != -24 || be.kS(str)) {
                String string;
                if (i == 4 && i2 == -22) {
                    string = this.ihO.context.getString(2131230827);
                } else {
                    string = this.ihO.context.getString(2131230826);
                }
                b(false, false, this.dRA, string);
            } else {
                b(false, false, this.dRA, str);
            }
        }
    }

    public interface b {
        void B(u uVar);

        void C(u uVar);

        void a(boolean z, String str, String str2, long j);

        void a(boolean z, boolean z2, String str, String str2, long j);
    }

    interface c {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public enum d {
        Stranger,
        Verifying,
        Added,
        NeedVerify
    }

    class AnonymousClass4 implements c {
        final /* synthetic */ String dAY;
        final /* synthetic */ c ihO;
        final /* synthetic */ long ihS;

        public AnonymousClass4(c cVar, String str, long j) {
            this.ihO = cVar;
            this.dAY = str;
            this.ihS = j;
        }

        public final void a(boolean z, boolean z2, String str, String str2) {
            boolean z3;
            if (z) {
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX(str);
                if (LX == null || ((int) LX.chr) == 0) {
                    LX = c.a(com.tencent.mm.storage.at.d.MB(this.dAY));
                    ak.yW();
                    if (!com.tencent.mm.model.c.wH().N(LX)) {
                        v.e("MicroMsg.RadarAddContact", "canAddContact fail, insert fail");
                        z = false;
                    }
                    ak.yW();
                    LX = com.tencent.mm.model.c.wH().LX(LX.field_username);
                }
                v.d("MicroMsg.RadarAddContact", "verifyContact return ok");
                com.tencent.mm.model.m.n(LX);
                c.aL(str, 1);
                z3 = z;
            } else {
                v.d("MicroMsg.RadarAddContact", "verifyContact return not ok");
                z3 = z;
            }
            c cVar = this.ihO;
            long j = this.ihS;
            if (cVar.ihM != null) {
                cVar.handler.post(new AnonymousClass8(cVar, z3, str2, str, j));
            }
        }
    }

    static /* synthetic */ u a(com.tencent.mm.storage.at.d dVar) {
        u uVar = new u();
        if (dVar != null) {
            uVar.setUsername(dVar.lct);
            uVar.bY(dVar.nvR);
            uVar.bP(dVar.bLc);
            uVar.bS(dVar.cID);
            uVar.bT(dVar.cIE);
            uVar.bU(dVar.cIF);
            uVar.cV(dVar.bBZ);
            uVar.cf(dVar.bCj);
            uVar.cg(dVar.getProvince());
            uVar.ch(dVar.getCity());
        } else {
            v.e("MicroMsg.RadarAddContact", "verify is null! must be parsed error before!");
        }
        return uVar;
    }

    static /* synthetic */ void aL(String str, int i) {
        eq eqVar = new eq();
        eqVar.bdl.bdn = 0;
        eqVar.bdl.bdo = str;
        eqVar.bdl.state = i;
        com.tencent.mm.sdk.c.a.nhr.z(eqVar);
    }

    public c(b bVar, Context context) {
        this.context = context;
        this.ihM = bVar;
    }

    public final long yp(final String str) {
        boolean z;
        final long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(this, new c(this) {
            final /* synthetic */ c ihO;

            public final void a(boolean z, boolean z2, String str, String str2) {
                if (z) {
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(str);
                    if (((int) LX.chr) > 0) {
                        com.tencent.mm.model.m.n(LX);
                    }
                    c.aL(str, 1);
                    if (this.ihO.ihK.contains(str)) {
                        this.ihO.ihK.remove(str);
                    }
                    v.d("MicroMsg.RadarAddContact", "addContact %s return ok", new Object[]{str});
                } else if (z2) {
                    if (!this.ihO.ihK.contains(str)) {
                        this.ihO.ihK.add(str);
                    }
                    c.aL(str, 2);
                    v.d("MicroMsg.RadarAddContact", "addContact has sent verify to %s", new Object[]{str});
                } else {
                    v.d("MicroMsg.RadarAddContact", "addContact return not ok, user canceled or error");
                }
                c cVar = this.ihO;
                long j = currentTimeMillis;
                if (cVar.ihM != null) {
                    cVar.handler.post(new AnonymousClass7(cVar, z, z2, str2, str, j));
                }
            }
        });
        List linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(48));
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        aVar.onStart();
        aVar.ihY = linkedList;
        aVar.dRA = str;
        aVar.ihX.add(str);
        ak.vy().a(new com.tencent.mm.pluginsdk.model.m(2, aVar.ihX, linkedList, "", ""), 0);
        return currentTimeMillis;
    }

    public final d yq(String str) {
        d dVar = d.Stranger;
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || ((int) LX.chr) == 0) {
            if (this.ihK.contains(str)) {
                dVar = d.Verifying;
            } else {
                dVar = d.Stranger;
            }
        } else if (com.tencent.mm.i.a.ei(LX.field_type)) {
            dVar = d.Added;
        } else if (this.ihL.containsKey(str)) {
            dVar = d.NeedVerify;
        } else if (this.ihK.contains(str)) {
            dVar = d.Verifying;
        } else {
            dVar = d.Stranger;
        }
        v.d("MicroMsg.RadarAddContact", "query username(%s) status %s", new Object[]{str, dVar});
        return dVar;
    }

    final void A(u uVar) {
        if (this.ihK.contains(uVar.field_username)) {
            this.ihK.remove(uVar.field_username);
        }
        if (this.ihK.contains(uVar.field_encryptUsername)) {
            this.ihK.remove(uVar.field_encryptUsername);
        }
    }

    public final void a(int i, j jVar, Object obj) {
        v.d("MicroMsg.RadarAddContact", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
        if (obj == null || !(obj instanceof String)) {
            v.e("MicroMsg.RadarAddContact", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
            return;
        }
        String str = (String) obj;
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX != null && com.tencent.mm.i.a.ei(LX.field_type)) {
            v.d("MicroMsg.RadarAddContact", "ContactStg onNotifyChange %s", new Object[]{str});
            B(LX);
        }
    }

    final void B(final u uVar) {
        A(uVar);
        this.ihL.remove(uVar.field_username);
        this.ihL.remove(uVar.field_encryptUsername);
        if (this.ihM != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ c ihO;

                public final void run() {
                    this.ihO.ihM.B(uVar);
                }
            });
        }
    }
}
