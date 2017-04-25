package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.ob;
import com.tencent.mm.h.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ae;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class p {
    private static Boolean cSn = null;
    private WakerLock bXU = null;
    public Queue<c> cSo = new LinkedList();
    public Queue<c> cSp = new LinkedList();
    private HashMap<c, Long> cSq = new HashMap();
    public c cSr = null;
    private long cSs = 0;

    class a {
        int cRh;
        ah cSA;
        final /* synthetic */ p cSt;
        boolean cSw;
        akf cSx;
        b cSy;
        c cSz;

        private a(p pVar, c cVar, boolean z, akf com_tencent_mm_protocal_c_akf, b bVar) {
            this.cSt = pVar;
            this.cRh = 0;
            this.cSw = false;
            this.cSx = null;
            this.cSy = null;
            this.cSA = new ah(g.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ a cSB;

                {
                    this.cSB = r1;
                }

                public final boolean oU() {
                    if (g.uz() && !com.tencent.mm.kernel.a.uG()) {
                        g.vx();
                        if (g.vw() != null) {
                            g.vx();
                            if (g.vw().vf() != null) {
                                LinkedList linkedList = this.cSB.cSx.mkI.eeu;
                                com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                                cVar.aK(this.cSB.cSz);
                                long Ni = be.Ni();
                                while (this.cSB.cRh < linkedList.size()) {
                                    if (!cVar.a(this.cSB.cSz, this.cSB.cRh, linkedList.size(), (kz) linkedList.get(this.cSB.cRh), false)) {
                                        com.tencent.mm.plugin.report.b.itm.a(99, 46, 1, false);
                                    }
                                    a aVar = this.cSB;
                                    aVar.cRh++;
                                    v.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", this.cSB.cSz, Long.valueOf(be.ay(Ni)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.cSB.cRh - 1));
                                    if (be.ay(Ni) >= 500) {
                                        break;
                                    }
                                }
                                cVar.aL(this.cSB.cSz);
                                if (this.cSB.cRh < linkedList.size()) {
                                    v.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", this.cSB.cSz, Long.valueOf(be.ay(Ni)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.cSB.cRh - 1));
                                    return true;
                                }
                                p.a(this.cSB.cSw, this.cSB.cSx, this.cSB.cSz);
                                this.cSB.cSy.fQ(linkedList.size());
                                return false;
                            }
                        }
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = this.cSB.cSz;
                    objArr[1] = Boolean.valueOf(g.uz());
                    objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.uG());
                    g.vx();
                    objArr[3] = g.vw();
                    v.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", objArr);
                    this.cSB.cSy.fQ(0);
                    return false;
                }
            }, true);
            this.cSy = bVar;
            this.cSz = cVar;
            this.cSw = z;
            this.cSx = com_tencent_mm_protocal_c_akf;
            this.cRh = 0;
            String str = SQLiteDatabase.KeyEmpty;
            boolean z2 = (this.cSy == null || this.cSz == null) ? false : true;
            p.assertTrue(str, z2);
            if (this.cSx == null) {
                p.assertTrue("resp Not null", false);
                v.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", this.cSz);
                this.cSy.fQ(0);
                return;
            }
            if (g.uz() && !com.tencent.mm.kernel.a.uG()) {
                g.vx();
                if (g.vw() != null) {
                    g.vx();
                    if (g.vw().vf() != null) {
                        p.a(pVar, com_tencent_mm_protocal_c_akf);
                        g.vx();
                        g.vu().aA(this.cSx.eeO, this.cSx.mLh);
                        g.vx();
                        g.vu();
                        com.tencent.mm.kernel.a.eA(this.cSx.eeO);
                        if (this.cSx.mkI == null || this.cSx.mkI.eeu == null || this.cSx.mkI.eeu.size() <= 0) {
                            v.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", this.cSz);
                            p.a(z, this.cSx, this.cSz);
                            this.cSy.fQ(0);
                            return;
                        }
                        v.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", this.cSz, Integer.valueOf(this.cSx.mkI.eeu.size()), Integer.valueOf(this.cSx.eeO), Integer.valueOf(this.cSx.mLh));
                        this.cSA.ea(50);
                        return;
                    }
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = this.cSz;
            objArr[1] = Boolean.valueOf(g.uz());
            objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.uG());
            g.vx();
            objArr[3] = g.vw();
            v.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", objArr);
            this.cSy.fQ(0);
        }
    }

    interface b {
        boolean fQ(int i);
    }

    public interface c {
        boolean a(Queue<c> queue);
    }

    class d implements c {
        final /* synthetic */ p cSt;

        d(p pVar) {
            this.cSt = pVar;
        }

        public final boolean a(Queue<c> queue) {
            PInt pInt = new PInt();
            g.vx();
            byte[] a = com.tencent.mm.booter.f.a(pInt, g.vu().uin);
            String str = "MicroMsg.SyncService";
            String str2 = "%s index:%d, buf.len:%d ";
            Object[] objArr = new Object[3];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(pInt.value);
            objArr[2] = Integer.valueOf(a != null ? a.length : -1);
            v.i(str, str2, objArr);
            if (pInt.value == 0 || be.bl(a)) {
                return false;
            }
            akf com_tencent_mm_protocal_c_akf;
            final int i = pInt.value;
            akf com_tencent_mm_protocal_c_akf2 = null;
            try {
                com.tencent.mm.protocal.x.b bVar = new com.tencent.mm.protocal.x.b();
                bVar.y(a);
                com_tencent_mm_protocal_c_akf = bVar.lXt;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(99, 38, 1, false);
                v.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed ", this, Integer.valueOf(i));
                g.vx();
                com.tencent.mm.booter.f.at(i, g.vu().uin);
                com_tencent_mm_protocal_c_akf = com_tencent_mm_protocal_c_akf2;
            } catch (Error e2) {
                com.tencent.mm.plugin.report.b.itm.a(99, 39, 1, false);
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                v.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", this, Integer.valueOf(i), Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
                p.assertTrue("LightPush memory error", false);
                com_tencent_mm_protocal_c_akf = com_tencent_mm_protocal_c_akf2;
            }
            if (com_tencent_mm_protocal_c_akf == null) {
                return false;
            }
            com.tencent.mm.plugin.report.b.itm.a(99, 20, 1, false);
            a aVar = new a(this, true, com_tencent_mm_protocal_c_akf, new b(this) {
                final /* synthetic */ d cSD;

                public final boolean fQ(int i) {
                    v.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", this.cSD, Integer.valueOf(i));
                    int i2 = i;
                    g.vx();
                    com.tencent.mm.booter.f.at(i2, g.vu().uin);
                    g.vA().x(new Runnable(this.cSD.cSt, this.cSD) {
                        final /* synthetic */ p cSt;

                        public final void run() {
                            boolean z = true;
                            if (com.tencent.mm.kernel.a.uG() || !g.uz()) {
                                v.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
                                return;
                            }
                            c dVar;
                            if (r3 != null) {
                                v.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", r3, this.cSt.cSr, Long.valueOf(be.ay(this.cSt.cSs)));
                                if (r3 != this.cSt.cSr) {
                                    for (c dVar2 : this.cSt.cSq.keySet()) {
                                        v.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", dVar2, Long.valueOf(be.ay(((Long) this.cSt.cSq.get(dVar2)).longValue())));
                                    }
                                    p.assertTrue("oldproc timeout, should in timeoutMap:" + r3, be.a((Long) this.cSt.cSq.remove(r3), -1) != -1);
                                    return;
                                }
                                p.a(r3, this.cSt.cSs);
                                this.cSt.cSr = null;
                                this.cSt.cSs = 0;
                                this.cSt.Hr();
                            }
                            if (this.cSt.cSr != null) {
                                if (be.ay(this.cSt.cSs) > 90000) {
                                    v.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", this.cSt.cSr, Long.valueOf(be.ay(this.cSt.cSs)));
                                    p.d(this.cSt, this.cSt.cSr);
                                    this.cSt.cSq.put(this.cSt.cSr, Long.valueOf(this.cSt.cSs));
                                    this.cSt.cSr = null;
                                    this.cSt.cSs = 0;
                                    this.cSt.Hr();
                                } else {
                                    v.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", this.cSt.cSr, Long.valueOf(be.ay(this.cSt.cSs)));
                                    return;
                                }
                            }
                            com.tencent.mm.plugin.zero.a.d dVar3 = (com.tencent.mm.plugin.zero.a.d) g.f(com.tencent.mm.plugin.zero.a.d.class);
                            if (dVar3.bmm().Ab()) {
                                v.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
                                dVar3.bmm().zZ();
                            } else if (dVar3.bmm().Ac()) {
                                v.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
                            } else {
                                dVar2 = new d(this.cSt);
                                if (dVar2.a(null)) {
                                    this.cSt.jq("LightPush");
                                    this.cSt.cSr = dVar2;
                                    this.cSt.cSs = be.Ni();
                                    return;
                                }
                                while (!this.cSt.cSp.isEmpty()) {
                                    dVar2 = (c) this.cSt.cSp.poll();
                                    v.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", Integer.valueOf(this.cSt.cSp.size()), dVar2);
                                    if (dVar2 != null && dVar2.a(null)) {
                                        this.cSt.jq("NotifyData");
                                        this.cSt.cSr = dVar2;
                                        this.cSt.cSs = be.Ni();
                                        return;
                                    }
                                }
                                if (!this.cSt.cSo.isEmpty()) {
                                    dVar2 = (c) this.cSt.cSo.poll();
                                    v.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", Integer.valueOf(this.cSt.cSo.size()), dVar2);
                                    if (dVar2 != null && dVar2.a(this.cSt.cSo)) {
                                        this.cSt.jq("NetSync");
                                        this.cSt.cSr = dVar2;
                                        this.cSt.cSs = be.Ni();
                                        return;
                                    }
                                }
                                v.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", this.cSt.cSr, Integer.valueOf(this.cSt.cSo.size()), Integer.valueOf(this.cSt.cSp.size()));
                                String str = SQLiteDatabase.KeyEmpty;
                                if (!(this.cSt.cSr == null && this.cSt.cSo.isEmpty() && this.cSt.cSp.isEmpty())) {
                                    z = false;
                                }
                                p.assertTrue(str, z);
                            }
                        }
                    });
                    return true;
                }
            });
            return true;
        }

        public final String toString() {
            return "LightPush[" + hashCode() + "]";
        }
    }

    class e extends k implements c, j {
        private com.tencent.mm.network.p cAt;
        int cQR;
        com.tencent.mm.v.e cSE;
        boolean cSF;
        private boolean cSG = false;
        final /* synthetic */ p cSt;
        int scene;

        public final boolean a(Queue<c> queue) {
            String str;
            String str2 = "MicroMsg.SyncService";
            String str3 = "%s begin run scene:%s selector:%s isContinue:%s List:%s";
            Object[] objArr = new Object[5];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(this.scene);
            objArr[2] = Integer.valueOf(this.cQR);
            objArr[3] = Boolean.valueOf(this.cSF);
            if (queue == null) {
                str = "null";
            } else {
                str = Integer.valueOf(queue.size());
            }
            objArr[4] = str;
            v.i(str2, str3, objArr);
            if (queue != null) {
                p.a(this.cSt, (Queue) queue);
                boolean z = false;
                boolean z2 = false;
                while (!queue.isEmpty()) {
                    e eVar = (e) queue.poll();
                    this.cQR |= eVar.cQR;
                    if (eVar.scene == 3) {
                        z = true;
                    } else if (eVar.cSF) {
                        z2 = true;
                    }
                    v.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", this, Integer.valueOf(queue.size()), eVar, Integer.valueOf(eVar.scene), Integer.valueOf(eVar.cQR), Boolean.valueOf(eVar.cSF), Boolean.valueOf(z2), Boolean.valueOf(z));
                }
                if (z) {
                    this.scene = 3;
                } else if (z2) {
                    this.scene = 6;
                }
            }
            if (g.uz() && !com.tencent.mm.kernel.a.uG()) {
                g.vx();
                if (g.vw() != null) {
                    g.vx();
                    if (g.vw().vf() != null) {
                        g.vx();
                        long a = be.a((Long) g.vw().vf().get(8196, null), 0);
                        if (a != 0) {
                            g.vx();
                            g.vw().vf().set(8196, Long.valueOf(0));
                            this.cQR = (int) (((long) this.cQR) | a);
                            this.cQR &= 95;
                        }
                        int i = this.scene == 3 ? 1 : 0;
                        if (this.scene == 1010) {
                            this.cQR |= 16;
                            this.scene = 7;
                        } else if (this.scene == 1011) {
                            this.cQR |= 64;
                            this.scene = 7;
                        } else if (this.scene == 3) {
                            this.cQR |= 262144;
                            this.scene = 3;
                        }
                        if (this.cSF) {
                            this.scene = 6;
                        }
                        this.cAt = new com.tencent.mm.modelmulti.k.a();
                        ake com_tencent_mm_protocal_c_ake = ((com.tencent.mm.protocal.x.a) this.cAt.Bx()).lXs;
                        com_tencent_mm_protocal_c_ake.mLg = i;
                        com_tencent_mm_protocal_c_ake.mkE = this.cQR;
                        com_tencent_mm_protocal_c_ake.maG = this.scene;
                        g.vx();
                        com_tencent_mm_protocal_c_ake.mkF = m.H(be.KG(be.ma((String) g.vw().vf().get(8195, new byte[0]))));
                        com_tencent_mm_protocal_c_ake.mLf = new la();
                        com_tencent_mm_protocal_c_ake.meq = com.tencent.mm.protocal.d.cmW;
                        v.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", this, Long.valueOf(a), Integer.valueOf(com_tencent_mm_protocal_c_ake.mLg), Integer.valueOf(com_tencent_mm_protocal_c_ake.mkE), Integer.valueOf(this.scene), com_tencent_mm_protocal_c_ake.meq);
                        v.i("MicroMsg.SyncService", "%s Req synckey %s", this, ae.aZ(be.KG(str)));
                        p.a(this);
                        g.vx();
                        if (g.vv().cjC.a((k) this, 0)) {
                            return true;
                        }
                        com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.b.b.foreground + ";" + p.Hl());
                        v.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", this);
                        com.tencent.mm.plugin.report.b.itm.a(99, 41, 1, false);
                        return false;
                    }
                }
            }
            Object[] objArr2 = new Object[4];
            objArr2[0] = this;
            objArr2[1] = Boolean.valueOf(g.uz());
            objArr2[2] = Boolean.valueOf(com.tencent.mm.kernel.a.uG());
            g.vx();
            objArr2[3] = g.vw();
            v.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", objArr2);
            return false;
        }

        public final String toString() {
            return "NetSync[" + hashCode() + "]";
        }

        public e(p pVar, int i, int i2, boolean z) {
            this.cSt = pVar;
            this.scene = i;
            this.cQR = i2;
            this.cSF = z;
        }

        public final int getType() {
            return 138;
        }

        public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
            this.cSE = eVar2;
            return a(eVar, this.cAt, this);
        }

        public final boolean BC() {
            return false;
        }

        public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
            if (pVar == null || pVar.getType() != 138) {
                int i4;
                com.tencent.mm.plugin.report.b.itm.a(99, 44, 1, false);
                String str2 = "MicroMsg.SyncService";
                String str3 = "%s onGYNetEnd error type:%d";
                Object[] objArr = new Object[2];
                objArr[0] = this;
                if (pVar == null) {
                    i4 = -2;
                } else {
                    i4 = pVar.getType();
                }
                objArr[1] = Integer.valueOf(i4);
                v.e(str2, str3, objArr);
            } else if (this.cSG) {
                v.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", this);
            } else {
                this.cSG = true;
                p.assertTrue("Check rr failed.", pVar == this.cAt);
                boolean z = true;
                if (!(i2 == 0 && i3 == 0)) {
                    v.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", this, Integer.valueOf(i2), Integer.valueOf(i3), str, pVar);
                    if (i2 == 4 && i3 == -2006) {
                        v.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", this);
                        com.tencent.mm.plugin.report.b.itm.a(99, 42, 1, false);
                        z = false;
                    } else {
                        com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3501), this.scene + ";" + i2 + ";" + i3 + ";" + com.tencent.mm.sdk.b.b.foreground + ";" + p.Hl());
                        com.tencent.mm.plugin.report.b.itm.a(99, 43, 1, false);
                        this.cSE.a(i2, i3, str, this);
                        g.vA().x(/* anonymous class already generated */);
                        return;
                    }
                }
                final akf com_tencent_mm_protocal_c_akf = ((com.tencent.mm.protocal.x.b) pVar.ze()).lXt;
                a aVar = new a(this, z, com_tencent_mm_protocal_c_akf, new b(this) {
                    final /* synthetic */ e cSI;

                    public final boolean fQ(int i) {
                        g.vx();
                        g.vw().vf().set(8196, Long.valueOf((long) com_tencent_mm_protocal_c_akf.miR));
                        boolean z = (com_tencent_mm_protocal_c_akf.miR & this.cSI.cQR) != 0;
                        v.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s", this.cSI, Integer.valueOf(com_tencent_mm_protocal_c_akf.miR), Boolean.valueOf(z), Integer.valueOf(com_tencent_mm_protocal_c_akf.miR & FileUtils.S_IRUSR));
                        if (!(z || (com_tencent_mm_protocal_c_akf.miR & FileUtils.S_IRUSR) == 0)) {
                            com.tencent.mm.sdk.c.a.nhr.z(new ob());
                        }
                        if (z) {
                            if (i == 0 && this.cSI.cSF) {
                                v.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", this.cSI);
                            } else {
                                this.cSI.cSt.e(this.cSI.scene, this.cSI.cQR, true);
                            }
                        }
                        this.cSI.cSE.a(0, 0, SQLiteDatabase.KeyEmpty, this.cSI);
                        g.vA().x(/* anonymous class already generated */);
                        return true;
                    }
                });
            }
        }
    }

    class f implements c {
        int cQS;
        long cSJ;
        final /* synthetic */ p cSt;
        akf cSx;

        public f(p pVar, com.tencent.mm.protocal.x.b bVar, int i, long j) {
            this.cSt = pVar;
            this.cSx = bVar == null ? null : bVar.lXt;
            this.cSJ = j;
            this.cQS = i;
        }

        public final boolean a(Queue<c> queue) {
            if (this.cSx == null) {
                com.tencent.mm.plugin.report.b.itm.a(99, 40, 1, false);
                v.e("MicroMsg.SyncService", "%s run resp == null", this);
                return false;
            } else if (10018 == q.dqj) {
                v.e("MicroMsg.SyncService", "%s Give up for test", this);
                return false;
            } else {
                a aVar = new a(this, true, this.cSx, new b(this) {
                    final /* synthetic */ f cSK;

                    {
                        this.cSK = r1;
                    }

                    public final boolean fQ(int i) {
                        v.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", this.cSK, this.cSK.cSx, Integer.valueOf(this.cSK.cQS), Long.valueOf(this.cSK.cSJ));
                        if ((this.cSK.cQS & 1) > 0) {
                            g.vx();
                            g.vy().a(new g(this.cSK.cSJ, be.KG(be.ma((String) g.vw().vf().get(8195, null)))), 0);
                        }
                        g.vA().x(/* anonymous class already generated */);
                        return true;
                    }
                });
                com.tencent.mm.plugin.report.b.itm.a(99, 21, 1, false);
                return true;
            }
        }

        public final String toString() {
            return "NotifyData[" + hashCode() + "]";
        }
    }

    static /* synthetic */ void a(c cVar, long j) {
        if (cVar != null) {
            com.tencent.mm.plugin.report.b.itm.a(99, (long) be.f((Integer) com.tencent.mm.plugin.report.b.a((int) be.ay(j), new int[]{200, 500, 800, 1500, 3000, 5000, 10000, 30000, 60000, 90000}, new Integer[]{Integer.valueOf(70), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(75), Integer.valueOf(76), Integer.valueOf(77), Integer.valueOf(78), Integer.valueOf(79), Integer.valueOf(80)})), 1, false);
        }
    }

    static /* synthetic */ void a(e eVar) {
        com.tencent.mm.plugin.report.b.itm.a(99, (long) eVar.scene, 1, false);
        com.tencent.mm.plugin.report.b.itm.a(99, 0, 1, false);
        com.tencent.mm.plugin.report.b.itm.a(99, com.tencent.mm.sdk.b.b.foreground ? 241 : 242, 1, false);
    }

    static /* synthetic */ void a(p pVar, c cVar) {
        if (cVar == null) {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3550), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, 48, 1, false);
        } else if (cVar instanceof e) {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3551), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, 49, 1, false);
        } else if (cVar instanceof f) {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3552), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, 50, 1, false);
        } else if (cVar instanceof d) {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3553), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, 51, 1, false);
        } else {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3554), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, 52, 1, false);
        }
    }

    static /* synthetic */ void a(p pVar, akf com_tencent_mm_protocal_c_akf) {
        int size = (com_tencent_mm_protocal_c_akf.mkI == null || com_tencent_mm_protocal_c_akf.mkI.eeu == null || com_tencent_mm_protocal_c_akf.mkI.eeu.size() <= 0) ? 0 : com_tencent_mm_protocal_c_akf.mkI.eeu.size();
        com.tencent.mm.plugin.report.b.itm.a(99, (long) be.f((Integer) com.tencent.mm.plugin.report.b.a(size, new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243)})), 1, false);
        if (!Hl()) {
            com.tencent.mm.plugin.report.b.itm.a(99, size > 0 ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.b.b.foreground) {
            com.tencent.mm.plugin.report.b.itm.a(99, size > 0 ? 219 : 216, 1, false);
        } else {
            com.tencent.mm.plugin.report.b.itm.a(99, size > 0 ? 220 : 217, 1, false);
        }
    }

    static /* synthetic */ void a(p pVar, Queue queue) {
        if (queue != null && !queue.isEmpty()) {
            if (queue.size() >= 5) {
                com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3590), queue.size() + ";" + com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            }
            com.tencent.mm.plugin.report.b.itm.a(99, (long) be.f((Integer) com.tencent.mm.plugin.report.b.a(queue.size(), new int[]{1, 2, 3, 4, 5, 10}, new Integer[]{Integer.valueOf(60), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(64), Integer.valueOf(65), Integer.valueOf(66)})), 1, false);
        }
    }

    static /* synthetic */ void a(boolean z, akf com_tencent_mm_protocal_c_akf, c cVar) {
        g.vx();
        byte[] KG = be.KG(be.ma((String) g.vw().vf().get(8195, new byte[0])));
        byte[] a = m.a(com_tencent_mm_protocal_c_akf.mkF);
        v.i("MicroMsg.SyncService", "processResp %s synckey req:%s  shouldMerge:%s", cVar, ae.aZ(KG), Boolean.valueOf(z));
        v.i("MicroMsg.SyncService", "processResp %s synckey resp:%s", cVar, ae.aZ(a));
        if (com_tencent_mm_protocal_c_akf.mkF == null || com_tencent_mm_protocal_c_akf.mkF.mQu <= 0) {
            com.tencent.mm.plugin.report.b.itm.a(99, 47, 1, false);
            return;
        }
        if (z) {
            byte[] i = ae.i(KG, a);
            v.i("MicroMsg.SyncService", "processResp %s synckey merge:%s", cVar, ae.aZ(i));
            if (i == null || i.length <= 0) {
                i = a;
            }
            com_tencent_mm_protocal_c_akf.mkF = m.H(i);
        }
        if (Arrays.equals(KG, m.a(com_tencent_mm_protocal_c_akf.mkF))) {
            v.i("MicroMsg.SyncService", "processResp %s  Sync Key Not change, not save", cVar);
            return;
        }
        g.vx();
        g.vw().vf().set(8195, be.bn(m.a(com_tencent_mm_protocal_c_akf.mkF)));
        aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", be.bn(m.a(com_tencent_mm_protocal_c_akf.mkF))).commit();
    }

    static /* synthetic */ void d(p pVar, c cVar) {
        if (cVar instanceof e) {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3571), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, com.tencent.mm.sdk.b.b.foreground ? 30 : 34, 1, false);
        } else if (cVar instanceof f) {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3572), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, com.tencent.mm.sdk.b.b.foreground ? 31 : 35, 1, false);
        } else if (cVar instanceof d) {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3573), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, com.tencent.mm.sdk.b.b.foreground ? 32 : 36, 1, false);
        } else {
            com.tencent.mm.plugin.report.b.itm.h(11098, Integer.valueOf(3574), com.tencent.mm.sdk.b.b.foreground + ";" + Hl());
            com.tencent.mm.plugin.report.b.itm.a(99, com.tencent.mm.sdk.b.b.foreground ? 33 : 37, 1, false);
        }
    }

    private static boolean wu() {
        if (com.tencent.mm.kernel.a.uG() || !g.uz()) {
            return false;
        }
        if (cSn != null) {
            return cSn.booleanValue();
        }
        int i = be.getInt(((h) g.f(h.class)).sU().getValue("AndroidNewSyncService3"), 0);
        g.vx();
        int aq = com.tencent.mm.a.h.aq(g.vu().uin, 100);
        boolean bsI = com.tencent.mm.sdk.b.b.bsI();
        r7 = new Object[4];
        g.vx();
        r7[2] = Integer.valueOf(g.vu().uin);
        r7[3] = Integer.valueOf(aq);
        v.i("MicroMsg.SyncService", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d", r7);
        if (bsI || i > aq) {
            cSn = Boolean.valueOf(true);
            return true;
        }
        cSn = Boolean.valueOf(false);
        return false;
    }

    private static void assertTrue(String str, boolean z) {
        if (!z) {
            v.e("MicroMsg.SyncService", "ASSERT now msg:%s", str);
            Assert.assertTrue(str, z);
        }
    }

    public final int a(long j, int i, String str) {
        v.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s [%s] ", Boolean.valueOf(wu()), Long.valueOf(j), Integer.valueOf(i), str, be.bur());
        int i2 = 0;
        if ((256 & j) != 0) {
            com.tencent.mm.sdk.c.a.nhr.z(new ob());
        }
        long j2 = (-257 & j) & 95;
        if (j2 != 0 && g.uz()) {
            g.vx();
            if (g.vw().vf() != null) {
                g.vx();
                g.vw().vf().set(8196, Long.valueOf(j2));
                if (r1) {
                    i2 = e(i, 7, false);
                } else {
                    k kVar = new k(i);
                    i2 = kVar.hashCode();
                    v.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", Integer.valueOf(i2));
                    g.vx();
                    if (!g.vv().cjC.a(kVar, 0)) {
                        v.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", Integer.valueOf(i2));
                        i2 = 0;
                    }
                }
            }
        }
        if (!be.kS(str)) {
            com.tencent.mm.sdk.c.b abVar = new ab();
            abVar.aXt.type = 3;
            abVar.aXt.aXv = str;
            com.tencent.mm.sdk.c.a.nhr.z(abVar);
        }
        return i2;
    }

    public final void a(com.tencent.mm.protocal.x.b bVar, int i, long j) {
        v.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s [%s]", Boolean.valueOf(wu()), bVar, Integer.valueOf(i), Long.valueOf(j), be.bur());
        if (wu()) {
            a(new f(this, bVar, i, j));
            return;
        }
        g.vx();
        g.vv().cjC.a(new k(bVar, i, j), 0);
    }

    public final int fP(int i) {
        v.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", Boolean.valueOf(wu()), Integer.valueOf(i), be.bur());
        if (wu()) {
            return e(i, 7, false);
        }
        k kVar = new k(i);
        g.vx();
        g.vv().cjC.a(kVar, 0);
        return kVar.hashCode();
    }

    private int e(int i, int i2, boolean z) {
        c eVar = new e(this, i, i2, z);
        a(eVar);
        return eVar.hashCode();
    }

    private synchronized void jq(String str) {
        boolean z = true;
        synchronized (this) {
            v.i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", str, this.bXU, be.bur());
            if (this.bXU == null) {
                this.bXU = new WakerLock(aa.getContext(), new IAutoUnlockCallback(this) {
                    final /* synthetic */ p cSt;

                    {
                        this.cSt = r1;
                    }

                    public final void autoUnlockCallback() {
                        v.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", this.cSt.cSr);
                        p.a(this.cSt, this.cSt.cSr);
                    }
                });
            }
            String str2 = "lock";
            if (this.bXU.isLocking()) {
                z = false;
            }
            assertTrue(str2, z);
            if (!com.tencent.mm.sdk.b.b.foreground) {
                this.bXU.lock(30000, str);
            }
        }
    }

    private synchronized void Hr() {
        if (this.bXU == null || !this.bXU.isLocking()) {
            String str = "MicroMsg.SyncService";
            String str2 = "wakeUnlock syncWakerLock locking?:%s foreground:%s";
            Object[] objArr = new Object[2];
            objArr[0] = this.bXU == null ? "null" : Boolean.valueOf(this.bXU.isLocking());
            objArr[1] = Boolean.valueOf(com.tencent.mm.sdk.b.b.foreground);
            v.w(str, str2, objArr);
        } else {
            this.bXU.unLock();
        }
    }

    private void a(final c cVar) {
        if (l.Hm()) {
            v.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", cVar);
            return;
        }
        g.vA().x(new Runnable(this) {
            final /* synthetic */ p cSt;

            public final void run() {
                if (cVar != null) {
                    if (cVar instanceof f) {
                        this.cSt.cSp.add(cVar);
                    } else {
                        this.cSt.cSo.add(cVar);
                    }
                }
                g.vA().x(/* anonymous class already generated */);
            }
        });
    }

    private static boolean Hl() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) aa.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            com.tencent.mm.plugin.report.b.itm.a(99, 45, 1, false);
            v.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.valueOf(true), be.e(e));
            return true;
        }
    }
}
