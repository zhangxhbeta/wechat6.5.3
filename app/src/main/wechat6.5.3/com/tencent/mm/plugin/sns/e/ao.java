package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.a.e;
import com.tencent.mm.as.j;
import com.tencent.mm.as.n;
import com.tencent.mm.e.a.jj;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class ao {
    av jnr;
    LinkedList<av> jns;
    Map<String, av> jnt;
    private c jnu;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Object[] cFH;
        final /* synthetic */ String jnv;
        final /* synthetic */ ao jnw;

        public AnonymousClass1(ao aoVar, String str, Object[] objArr) {
            this.jnw = aoVar;
            this.jnv = str;
            this.cFH = objArr;
        }

        public final void run() {
            g.DY().b(this.jnv, this.cFH);
            if (this.jnw.jnr != null && be.dC(this.jnw.jnr.jop, this.jnv)) {
                ak.vA().x(new Runnable(this.jnw) {
                    final /* synthetic */ ao jnw;

                    {
                        this.jnw = r1;
                    }

                    public final void run() {
                        if (this.jnw.jnr != null) {
                            v.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", new Object[]{this.jnw.jnr.jop});
                            this.jnw.jnt.remove(this.jnw.jnr);
                        }
                        this.jnw.jnr = null;
                        this.jnw.aTd();
                    }
                });
            }
            this.jnw.jns.remove((av) this.jnw.jnt.get(this.jnv));
        }
    }

    public ao() {
        this.jns = null;
        this.jnt = null;
        this.jnu = new c<jj>(this) {
            final /* synthetic */ ao jnw;

            {
                this.jnw = r2;
                this.nhz = jj.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                jj jjVar = (jj) bVar;
                if (this.jnw.jnr != null && be.dC(this.jnw.jnr.jop, jjVar.bjO.mediaId)) {
                    if (jjVar.bjO.aYJ != 0) {
                        this.jnw.aTd();
                    } else if (jjVar.bjO.bdn == 4 || jjVar.bjO.bdn == 6) {
                        ak.vA().x(/* anonymous class already generated */);
                    }
                }
                return false;
            }
        };
        this.jnr = null;
        this.jns = new LinkedList();
        this.jnt = new HashMap();
        a.nhr.e(this.jnu);
    }

    public final boolean a(aib com_tencent_mm_protocal_c_aib, int i, String str, boolean z, final boolean z2, int i2) {
        if (com_tencent_mm_protocal_c_aib.mHO == 2) {
            v.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            return false;
        }
        final av avVar = new av();
        avVar.jop = an.ad(i, com_tencent_mm_protocal_c_aib.glb);
        avVar.boL = com_tencent_mm_protocal_c_aib;
        avVar.cLB = i;
        avVar.bap = str;
        avVar.cFV = z;
        avVar.cFX = i2;
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ ao jnw;

            public final void run() {
                k Bq = ad.aSE().Bq(avVar.bap);
                avVar.joo = Bq != null ? Bq.field_userName : "";
                v.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[]{Boolean.valueOf(z2), avVar});
                if (z2) {
                    this.jnw.jns.offerFirst(avVar);
                } else {
                    this.jnw.jns.offerLast(avVar);
                }
                this.jnw.jnt.put(avVar.jop, avVar);
            }
        });
        if (z2) {
            aTd();
        }
        return true;
    }

    final void aTd() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ ao jnw;

            {
                this.jnw = r1;
            }

            public final void run() {
                if (this.jnw.jns.isEmpty()) {
                    v.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
                    return;
                }
                av avVar = (av) this.jnw.jns.poll();
                if (avVar == null) {
                    v.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[]{Integer.valueOf(this.jnw.jns.size())});
                    return;
                }
                boolean z;
                if (this.jnw.jnr == null || !avVar.jop.equals(this.jnw.jnr.jop)) {
                    z = false;
                } else {
                    z = true;
                }
                ao aoVar = this.jnw;
                if (be.kS(an.a(avVar.bap, avVar.boL))) {
                    String str;
                    String str2 = avVar.boL.gID;
                    if (be.kS(str2)) {
                        str = null;
                    } else {
                        str = al.cA(ad.xh(), str2);
                        v.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[]{str, str2});
                    }
                    boolean aU = e.aU(str);
                    str2 = an.D(avVar.boL);
                    n AB = an.AB(avVar.bap);
                    int i;
                    boolean a;
                    if (AB == null) {
                        String str3 = avVar.bap;
                        i = avVar.cFX;
                        if (be.kS(str3)) {
                            v.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
                        } else {
                            str3 = an.lb(str3);
                            n nVar = new n();
                            nVar.aST = str3;
                            nVar.dhH = be.Nh();
                            nVar.status = 130;
                            nVar.cFX = i;
                            a = com.tencent.mm.as.k.KV().a(nVar);
                            v.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[]{str3, Boolean.valueOf(a)});
                        }
                    } else {
                        i = avVar.cFX;
                        AB.status = 130;
                        AB.cFX = i;
                        AB.bkU = 268435712;
                        a = com.tencent.mm.as.k.KV().b(AB);
                        v.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[]{AB.getFileName(), Boolean.valueOf(a)});
                    }
                    v.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[]{str2, Boolean.valueOf(aU)});
                    com.tencent.mm.plugin.sns.e.a.a aVar = new com.tencent.mm.plugin.sns.e.a.a(avVar.boL.gID);
                    aVar.jfX = avVar.boL;
                    com.tencent.mm.storage.ak bvV = com.tencent.mm.storage.ak.bvV();
                    bvV.hrm = avVar.cLB;
                    aVar.jot = bvV;
                    aVar.jor = true;
                    aVar.url = avVar.boL.glb;
                    int i2 = avVar.boL.efm;
                    aVar.joq = false;
                    j.KT();
                    g.DY();
                    i a2 = f.a(aVar.jot, aVar.url, str2, an.lb(avVar.bap), avVar.cFV);
                    if (a2 != null) {
                        a2.cFW = avVar.joo;
                        aoVar.jnr = avVar;
                        aoVar.jnr.jop = a2.field_mediaId;
                        v.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[]{aoVar.jnr.jop, Boolean.valueOf(z)});
                        g.DY().a(a2, z);
                        return;
                    }
                    return;
                }
                v.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", new Object[]{avVar.jop, avVar.bap, an.a(avVar.bap, avVar.boL)});
            }
        });
    }
}
