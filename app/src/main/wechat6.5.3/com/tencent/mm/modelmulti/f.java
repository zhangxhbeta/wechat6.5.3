package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.ajy;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f extends k implements j {
    final Queue<a> cKe = new LinkedList();
    com.tencent.mm.v.f cMP = null;
    com.tencent.mm.compatible.util.g.a cQT;
    private StringBuilder cQU = new StringBuilder();
    final ajy cRd = new ajy();
    int cRe = 0;
    boolean cRf = false;
    int cRg = 0;
    int cRh = 0;
    boolean cRi = false;
    e cii;
    private final ah cxS = new ah(g.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ f cRj;

        {
            this.cRj = r1;
        }

        public final boolean oU() {
            if (!g.uz() || com.tencent.mm.kernel.a.uG()) {
                v.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
                return false;
            } else if (this.cRj.cRi) {
                if (((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxl != null) {
                    ((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxl.WY();
                }
                v.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", Integer.valueOf(this.cRj.hashCode()));
                return false;
            } else if (this.cRj.cKe.isEmpty()) {
                v.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
                return false;
            } else {
                boolean z;
                v.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", Integer.valueOf(this.cRj.hashCode()), Long.valueOf(this.cRj.cQT.sn()), Integer.valueOf(this.cRj.cKe.size()), Integer.valueOf(this.cRj.cRe), Boolean.valueOf(this.cRj.cRf), Integer.valueOf(this.cRj.cRh), Integer.valueOf(this.cRj.cRg));
                g.vx();
                long er = g.vw().ckb.er(Thread.currentThread().getId());
                c cVar = new c();
                cVar.aK("NetSceneInit");
                int i = this.cRj.cRf ? 40 : 10;
                int i2 = 0;
                while (i2 < i) {
                    final a aVar = (a) this.cRj.cKe.peek();
                    if (aVar.cRn == Integer.MAX_VALUE) {
                        Assert.assertTrue("in Queue tail , resp should be null", aVar.cRm == null);
                        if (((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxl != null) {
                            ((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxl.WX();
                        }
                        g.vx();
                        String str = (String) g.vw().vf().get(8198, null);
                        g.vx();
                        g.vw().vf().set(8195, str);
                        aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", str).commit();
                        g.vx();
                        g.vw().vf().set(8197, SQLiteDatabase.KeyEmpty);
                        g.vx();
                        g.vw().vf().set(8198, SQLiteDatabase.KeyEmpty);
                        g.vx();
                        g.vw().vf().set(15, Integer.valueOf(1));
                        g.vx();
                        g.vw().vf().iB(true);
                        v.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", Integer.valueOf(this.cRj.hashCode()), Long.valueOf(this.cRj.cQT.sn()), Integer.valueOf(this.cRj.cRe), Integer.valueOf(this.cRj.cRg), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                        g.vA().x(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 cRl;

                            public final void run() {
                                this.cRl.cRj.cii.a(aVar.errType, aVar.errCode, aVar.biS, this.cRl.cRj);
                            }
                        });
                        z = false;
                    } else {
                        LinkedList linkedList = aVar.cRm.mKG;
                        if (linkedList == null || linkedList.size() <= aVar.cKq || !cVar.a("NetSceneInit", aVar.cKq, linkedList.size(), (kz) linkedList.get(aVar.cKq), true)) {
                            this.cRj.cKe.poll();
                            g.vx();
                            g.vw().vf().set(8197, be.bn(m.a(aVar.cRm.mKC)));
                            g.vx();
                            g.vw().vf().set(8198, be.bn(m.a(aVar.cRm.mKD)));
                            g.vx();
                            g.vw().vf().set(16, Integer.valueOf(0));
                            g.vx();
                            g.vw().vf().set(8196, Long.valueOf((long) aVar.cRm.mKE));
                            g.vx();
                            g.vw().vf().iB(true);
                            z = true;
                            break;
                        }
                        aVar.cKq++;
                        f fVar = this.cRj;
                        fVar.cRh++;
                        i2++;
                    }
                }
                z = true;
                cVar.aL("NetSceneInit");
                g.vx();
                g.vw().ckb.es(er);
                k kVar = this.cRj;
                if (kVar.cMP == null) {
                    v.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
                    return z;
                }
                float f;
                int i3;
                int i4 = kVar.cRe > 50 ? 50 : kVar.cRe;
                if (kVar.cRf) {
                    float f2 = ((float) kVar.cRh) / ((float) kVar.cRg);
                    if (f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                    f = f2;
                    i3 = (int) ((((float) (100 - i4)) * f2) + ((float) i4));
                } else {
                    f = 1.0f;
                    i3 = i4;
                }
                v.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", Integer.valueOf(kVar.cRh), Integer.valueOf(kVar.cRg), Float.valueOf(f), Integer.valueOf(i4));
                kVar.cMP.a(i3, 100, kVar);
                return z;
            }
        }
    }, true);
    private int retryCount = 3;

    class a {
        String biS;
        int cKq = 0;
        final /* synthetic */ f cRj;
        ajz cRm;
        int cRn = 0;
        int errCode;
        int errType;

        a(f fVar) {
            this.cRj = fVar;
        }
    }

    public static class b extends i {
        private final com.tencent.mm.protocal.w.a cRo = new com.tencent.mm.protocal.w.a();
        private final com.tencent.mm.protocal.w.b cRp = new com.tencent.mm.protocal.w.b();

        protected final l.c zd() {
            return this.cRo;
        }

        public final d ze() {
            return this.cRp;
        }

        public final int getType() {
            return 139;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newinit";
        }
    }

    public f(com.tencent.mm.v.f fVar) {
        v.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", Integer.valueOf(hashCode()), be.bur());
        this.cQU.append("stack:" + be.bur() + " time:" + be.Nh());
        this.cMP = fVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cQT = new com.tencent.mm.compatible.util.g.a();
        this.cii = eVar2;
        if (((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxl != null) {
            ((com.tencent.mm.plugin.zero.b) g.g(com.tencent.mm.plugin.zero.b.class)).lxl.WW();
        }
        ajy com_tencent_mm_protocal_c_ajy = this.cRd;
        g.vx();
        com_tencent_mm_protocal_c_ajy.gln = (String) g.vw().vf().get(2, null);
        Assert.assertTrue("by DK: req.UserName is null", !be.kS(this.cRd.gln));
        this.cRd.fvz = u.bsY();
        return a(eVar, null, null);
    }

    private int a(com.tencent.mm.network.e eVar, are com_tencent_mm_protocal_c_are, are com_tencent_mm_protocal_c_are2) {
        this.cQU.append(" lastd:" + this.czF + " dotime:" + be.Nh() + " net:" + ak.getNetType(aa.getContext()));
        p bVar = new b();
        if (com_tencent_mm_protocal_c_are == null) {
            g.vx();
            com_tencent_mm_protocal_c_are = m.H(be.KG(be.ma((String) g.vw().vf().get(8197, null))));
        }
        if (com_tencent_mm_protocal_c_are2 == null) {
            g.vx();
            com_tencent_mm_protocal_c_are2 = m.H(be.KG(be.ma((String) g.vw().vf().get(8198, null))));
        }
        g.vx();
        if (be.f((Integer) g.vw().vf().get(16, null)) == 0 || (com_tencent_mm_protocal_c_are != null && com_tencent_mm_protocal_c_are.mQu > 0)) {
            g.vx();
            if (be.ma((String) g.vw().vf().get(8195, null)).length() <= 0) {
                bVar.Bx().lWQ = 3;
            } else {
                bVar.Bx().lWQ = 4;
            }
        } else {
            bVar.Bx().lWQ = 7;
        }
        this.cRd.mKC = com_tencent_mm_protocal_c_are;
        this.cRd.mKD = com_tencent_mm_protocal_c_are2;
        ((com.tencent.mm.protocal.w.a) bVar.Bx()).lXq = this.cRd;
        v.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", Integer.valueOf(hashCode()), Long.valueOf(this.cQT.sn()), Integer.valueOf(this.cRe), this.cRd.gln, this.cRd.fvz, Integer.valueOf(bVar.Bx().lWQ), be.bn(m.a(com_tencent_mm_protocal_c_are)), be.bn(m.a(com_tencent_mm_protocal_c_are2)));
        this.cRe++;
        return a(eVar, bVar, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cQU.append(" endtime:" + be.Nh());
        v.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i));
        if (i2 == 4 && i3 == -100) {
            v.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.cRi = true;
            this.cii.a(i2, i3, str, this);
        } else if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -17)) {
            ajz com_tencent_mm_protocal_c_ajz = ((com.tencent.mm.protocal.w.b) pVar.ze()).lXr;
            this.cRg += com_tencent_mm_protocal_c_ajz.mKF;
            v.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.cQT.sn()), Integer.valueOf(this.cRg), Integer.valueOf(this.cRe), Integer.valueOf(com_tencent_mm_protocal_c_ajz.miR));
            a(this.cRe - 1, i2, i3, str, com_tencent_mm_protocal_c_ajz);
            if ((com_tencent_mm_protocal_c_ajz.miR & 7) == 0 || super.BA()) {
                v.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", Integer.valueOf(hashCode()), Long.valueOf(this.cQT.sn()), Integer.valueOf(this.cRe));
                this.cRf = true;
                a(Integer.MAX_VALUE, 0, 0, SQLiteDatabase.KeyEmpty, null);
            } else if (a(this.czE, com_tencent_mm_protocal_c_ajz.mKC, com_tencent_mm_protocal_c_ajz.mKD) == -1) {
                v.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
                a(Integer.MAX_VALUE, 3, -1, SQLiteDatabase.KeyEmpty, null);
            }
        } else {
            v.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (this.retryCount > 0) {
                this.retryCount--;
                if (a(this.czE, null, null) != -1) {
                    return;
                }
            }
            this.cRi = true;
            this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
        }
    }

    public final boolean Bz() {
        return true;
    }

    protected final void cancel() {
        v.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", be.bur());
        super.cancel();
        this.cRi = true;
    }

    private void a(int i, int i2, int i3, String str, ajz com_tencent_mm_protocal_c_ajz) {
        a aVar = new a(this);
        aVar.cRn = i;
        aVar.errCode = i3;
        aVar.errType = i2;
        aVar.biS = str;
        aVar.cRm = com_tencent_mm_protocal_c_ajz;
        this.cKe.add(aVar);
        if (this.cxS.btC()) {
            this.cxS.ea(50);
        }
    }

    public final String getInfo() {
        return this.cQU.toString();
    }

    protected final int ul() {
        return 500;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final boolean BA() {
        return super.BA();
    }

    public final int getType() {
        return 139;
    }
}
