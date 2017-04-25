package com.tencent.mm.plugin.sns.k;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.k.c.b;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.v.e;

public final class a extends com.tencent.mm.vending.app.a implements e {
    String dRA;
    boolean jGc;
    String jUP;
    boolean jUQ;
    int jUR;
    public volatile at jWl;
    protected volatile com.tencent.mm.plugin.sns.e.ak.a jYz;
    private com.tencent.mm.pluginsdk.j.q.e.a kcm;

    public final void a(com.tencent.mm.pluginsdk.j.q.e.a aVar) {
        this.jYz = ad.aSu();
        com.tencent.mm.plugin.sns.k.c.a aVar2 = (com.tencent.mm.plugin.sns.k.c.a) t(com.tencent.mm.plugin.sns.k.c.a.class);
        this.kcm = aVar;
        this.jYz.a(1, aVar2.dRA, this.kcm);
    }

    public final com.tencent.mm.plugin.sns.e.ak.a aSu() {
        return this.jYz;
    }

    protected final void onCreate() {
        super.onCreate();
        a(b.class, new com.tencent.mm.vending.app.a.a<b>(this) {
            final /* synthetic */ a kcn;

            {
                this.kcn = r1;
            }

            protected final /* synthetic */ Object NB() {
                v.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", new Object[]{b.class});
                return a.aYw();
            }
        });
        a(com.tencent.mm.plugin.sns.k.c.a.class, new com.tencent.mm.vending.app.a.a<com.tencent.mm.plugin.sns.k.c.a>(this) {
            final /* synthetic */ a kcn;

            {
                this.kcn = r1;
            }

            protected final /* synthetic */ Object NB() {
                v.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", new Object[]{com.tencent.mm.plugin.sns.k.c.a.class});
                com.tencent.mm.vending.app.a aVar = this.kcn;
                com.tencent.mm.plugin.sns.k.c.a aVar2 = new com.tencent.mm.plugin.sns.k.c.a();
                aVar.jUR = aVar.pgh.getIntExtra("sns_source", 0);
                aVar.dRA = aVar.pgh.getStringExtra("sns_userName");
                if (aVar.dRA == null) {
                    aVar.dRA = "";
                }
                ak.yW();
                aVar.jUQ = c.wH().LT(aVar.dRA);
                aVar.jUP = k.xF();
                aVar.jGc = aVar.jUP.equals(aVar.dRA);
                aa aSs = ad.aSs();
                String ah = be.ah(aVar.pgh.getStringExtra("sns_signature"), "");
                String ah2 = be.ah(aVar.pgh.getStringExtra("sns_nickName"), "");
                com.tencent.mm.i.a LX = (aVar.dRA == null || aVar.dRA.equals("")) ? aSs.LX(aVar.jUP) : aSs.LX(aVar.dRA);
                if (LX != null && ((int) LX.chr) > 0) {
                    ah = LX.bCj;
                    ah2 = LX.tT();
                    v.i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", new Object[]{LX.field_username, Integer.valueOf((int) LX.chr), ah2});
                }
                aVar2.dRA = aVar.dRA;
                aVar2.jUP = aVar.jUP;
                aVar2.jUQ = aVar.jUQ;
                aVar2.jGc = aVar.jGc;
                aVar2.jUR = aVar.jUR;
                aVar2.gpi = ah2;
                aVar2.jXL = ah;
                return aVar2;
            }
        });
        v.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", new Object[]{this});
        ad.aSz().jiK.clear();
        ad.aSz();
        com.tencent.mm.plugin.sns.e.b.aRH();
    }

    protected final void onDestroy() {
        v.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", new Object[]{this});
        if (!(!ak.uz() || this.jYz == null || this.kcm == null)) {
            this.jYz.a(this.kcm, 1);
        }
        super.onDestroy();
    }

    static b aYw() {
        String str;
        b bVar = new b();
        Cursor aUu = ad.aSH().aUu();
        int count = aUu.getCount();
        String str2 = "";
        if (count > 0) {
            aUu.moveToFirst();
            g gVar = new g();
            gVar.b(aUu);
            try {
                str = ((avm) new avm().az(gVar.field_curActionBuf)).mOk;
            } catch (Throwable e) {
                v.a("MicroMsg.SnsTimelineInteractor", e, "", new Object[0]);
            }
            aUu.close();
            bVar.kct = count;
            bVar.kcs = str;
            return bVar;
        }
        str = str2;
        aUu.close();
        bVar.kct = count;
        bVar.kcs = str;
        return bVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar.toString()});
    }

    public final void e(String str, boolean z, int i) {
        this.jYz.b(1, str, z, i);
    }

    public final void f(String str, boolean z, int i) {
        this.jYz.a(1, str, z, i);
    }
}
