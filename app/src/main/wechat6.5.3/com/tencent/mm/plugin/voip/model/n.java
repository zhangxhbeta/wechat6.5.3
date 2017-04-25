package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.plugin.voip.model.a.f;
import com.tencent.mm.plugin.voip.model.a.i;
import com.tencent.mm.plugin.voip.model.a.l;
import com.tencent.mm.plugin.voip.model.e.a;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.List;

public final class n implements a {
    public e kqI = f.bbN();
    private Object kvd = new Object();
    public h kve;
    private ah kvf = new ah(Looper.getMainLooper(), new ah.a(this) {
        final /* synthetic */ n kvj;

        {
            this.kvj = r1;
        }

        public final boolean oU() {
            if (this.kvj.kqI.ksc.kvH == 1) {
                e eVar = this.kvj.kqI;
                boolean z = eVar.mStatus == 2 || eVar.mStatus == 4;
                if (z) {
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "call timeout!");
                    this.kvj.kqI.ksc.kxf.ksP = 101;
                    g.iuh.h(11521, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())});
                    this.kvj.bcN();
                    this.kvj.kqI.ksd.bch();
                }
            }
            return false;
        }
    }, false);
    byte[] kvg = new byte[500];
    ah kvh = new ah(Looper.getMainLooper(), new ah.a(this) {
        final /* synthetic */ n kvj;

        {
            this.kvj = r1;
        }

        public final boolean oU() {
            e eVar = this.kvj.kqI;
            eVar.ksk++;
            if (this.kvj.kqI.ksc.gFG == 0) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sm() + "double link switch roomId == 0 ");
                this.kvj.kvh.QI();
            } else {
                this.kvj.kqI.ksc.app2EngineDataEx(this.kvj.kqI.ksc.kwD, this.kvj.kqI.ksc.kwE, this.kvj.kqI.ksc.kwF, 0, 0);
                if (!this.kvj.kqI.ksj && 1 == this.kvj.kqI.ksc.field_mGetValidSample) {
                    this.kvj.kqI.ksj = true;
                    this.kvj.kqI.ksl = this.kvj.kqI.ksk;
                }
                if (1 == this.kvj.kqI.krP) {
                    this.kvj.kqI.krP = 15;
                }
                if (true == this.kvj.kqI.ksj && this.kvj.kqI.ksk - this.kvj.kqI.ksl == this.kvj.kqI.krP && (this.kvj.kqI.ksc.kww & 1) == 0) {
                    this.kvj.kqI.ksl = this.kvj.kqI.ksk;
                    int isDCSameLan = this.kvj.kqI.ksc.isDCSameLan();
                    int currentConnType = this.kvj.kqI.ksc.getCurrentConnType();
                    if (1 == isDCSameLan && 1 == currentConnType) {
                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = " + isDCSameLan);
                        eVar = this.kvj.kqI;
                        eVar.ksk++;
                    } else {
                        int i = this.kvj.kqI.ksc.getcurstrategy();
                        int isRelayConnReady = this.kvj.kqI.ksc.isRelayConnReady();
                        int isDCReady = this.kvj.kqI.ksc.isDCReady();
                        isDCSameLan = this.kvj.kqI.krP - 3;
                        if (isDCSameLan > 15) {
                            isDCSameLan = 15;
                        }
                        this.kvj.kqI.ksc.app2EngineLinkQualityEx(isDCSameLan, this.kvj.kvg);
                        new d(this.kvj.kqI.ksc.gFG, this.kvj.kqI.ksc.gFH, this.kvj.kqI.ksc.gFO, currentConnType, isRelayConnReady, isDCReady, i, this.kvj.kvg, this.kvj.kqI.ksc.field_realLinkQualityInfoBuffLen).bcW();
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.kvj.kqI.ksc;
                        com_tencent_mm_plugin_voip_model_v2protocal.kwy++;
                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + this.kvj.kqI.krP + " isFirstValidSampleSet " + this.kvj.kqI.ksj + " mGetValidSample " + this.kvj.kqI.ksc.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + this.kvj.kqI.ksc.kwy + "mTimerCounter " + this.kvj.kqI.ksk + "mLastSwitchTimer " + this.kvj.kqI.ksl);
                    }
                }
            }
            return true;
        }
    }, true);
    ah kvi = new ah(Looper.getMainLooper(), new ah.a(this) {
        final /* synthetic */ n kvj;

        {
            this.kvj = r1;
        }

        public final boolean oU() {
            if (this.kvj.kqI.ksc.gFG == 0) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sm() + " roomId == 0 ");
                this.kvj.kvi.QI();
            } else {
                if (this.kvj.kqI.mStatus >= 5) {
                    new f(this.kvj.kqI.ksc.gFG, this.kvj.kqI.ksc.gFH, this.kvj.kqI.ksn).bcW();
                }
            }
            return true;
        }
    }, true);

    public n() {
        this.kqI.a(this);
        this.kve = new h(aa.getContext());
    }

    public final void stop() {
        v.i("MicroMsg.Voip.VoipServiceEx", "stop");
        reset();
        this.kqI.a(null);
    }

    protected final void finalize() {
        stop();
        super.finalize();
    }

    public final void reset() {
        v.d("MicroMsg.Voip.VoipServiceEx", "reset");
        e eVar = this.kqI;
        v.i("MicroMsg.Voip.VoipContext", "reset");
        eVar.ksd.bck();
        if (eVar.ksc.hqt) {
            eVar.ksc.gU(false);
        }
        eVar.ksc.reset();
        eVar.krQ = -1;
        eVar.krR = -1;
        eVar.krS = -1;
        eVar.krT = -1;
        eVar.krU = -1;
        eVar.kse.bbP();
        eVar.ksc.kvY = 0;
        eVar.ksr.QI();
        eVar.ksf.bcS();
        eVar.kso.QI();
        eVar.kry = false;
        eVar.krz = false;
        eVar.krA = false;
        eVar.krB = false;
        eVar.blA = false;
        eVar.krC = false;
        eVar.ksg = null;
        eVar.ksh = null;
        eVar.krM = false;
        eVar.krN = false;
        eVar.krO = false;
        eVar.krV = false;
        eVar.krW = false;
        eVar.krY = false;
        eVar.krX = 1;
        eVar.krZ = 1;
        eVar.ksi = false;
        eVar.ksa = -1;
        eVar.ksb = -1;
        eVar.krD = false;
        eVar.krE = false;
        eVar.krC = false;
        eVar.kry = false;
        eVar.krF = false;
        eVar.krP = 10;
        eVar.mStatus = 1;
        eVar.ksm = 0;
        eVar.ksn = 0;
        this.kvi.QI();
        this.kvf.QI();
        this.kvh.QI();
    }

    public final boolean bcL() {
        return this.kqI.ksc.gFG != 0;
    }

    public final boolean bbD() {
        if (this.kqI.bbD()) {
            return true;
        }
        return false;
    }

    public final void bcM() {
        if (this.kqI.bbD()) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.kqI.mStatus);
        }
        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + az.bxj());
        this.kqI.bbz();
        reset();
        ak.yW();
        p.dr(c.vg().bxh());
    }

    public final void m(int i, int i2, String str) {
        v.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: " + i);
        switch (i) {
            case 1:
                bcP();
                this.kqI.ksd.onError(i2, str);
                return;
            case 4:
                bcP();
                this.kqI.ksd.onReject();
                return;
            case 5:
                bcP();
                this.kqI.ksd.bch();
                return;
            case 6:
                bcP();
                this.kqI.ksd.bcj();
                return;
            default:
                return;
        }
    }

    public final int be(String str, int i) {
        v.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
        if (be.kS(str)) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
            return -1;
        } else if (this.kqI.bbD()) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
            return -1;
        } else {
            this.kqI.ksc.kvH = 1;
            this.kqI.ksc.gUE = str;
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sm() + "call username:" + str);
            if (this.kqI.ksc.hqt) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sm() + "v2protocal already init.");
                this.kqI.ksc.gU(false);
                this.kqI.ksc.reset();
            }
            if (this.kqI.ksc.aZP() < 0) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                return -1;
            }
            this.kvi.ea(50000);
            this.kvh.ea(1000);
            this.kqI.ksc.gFJ = (int) System.currentTimeMillis();
            List arrayList = new ArrayList();
            arrayList.add(str);
            new com.tencent.mm.plugin.voip.model.a.g(arrayList, this.kqI.ksc.field_peerId, this.kqI.ksc.field_capInfo, this.kqI.ksc.netType, 0, i, this.kqI.ksc.gFJ).bcW();
            this.kqI.dh(2);
            this.kqI.kse.ksy = 1;
            this.kvf.ea(60000);
            this.kqI.ksc.kxf.ktt = System.currentTimeMillis();
            this.kqI.ksc.kxf.beginTime = System.currentTimeMillis();
            this.kqI.ksc.kxf.kta = i;
            v.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.kqI.ksc.kxf.kta);
            return 0;
        }
    }

    public final int bcN() {
        if (this.kqI.bbD()) {
            v.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", new Object[]{Integer.valueOf(this.kqI.ksc.gFG), Integer.valueOf(this.kqI.ksc.kvE), Integer.valueOf(this.kqI.ksc.gFJ)});
            synchronized (this.kvd) {
                if (this.kqI.ksc.gFG == 0 && this.kqI.ksc.gFJ == 0) {
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
                    return -1;
                }
                String gU = this.kqI.ksc.gU(true);
                if (gU.length() > 0) {
                    int i = this.kqI.ksc.gFG;
                    long j = this.kqI.ksc.gFH;
                    int i2 = this.kqI.ksc.kvE;
                    new com.tencent.mm.plugin.voip.model.a.c(i, j, this.kqI.ksc.gUE, gU, this.kqI.ksc.gFJ).bcW();
                }
                h hVar = this.kqI.ksc.kxf;
                hVar.ktk = (int) (System.currentTimeMillis() - hVar.ktt);
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.VoipDailReport", "devin:cancelInvite:" + hVar.ktk);
                if (this.kqI.ksc.kvU == 0 && this.kqI.ksc.kvV == 0) {
                    this.kqI.bbA();
                }
                this.kqI.rB(this.kve.bdR());
                String bdf = v2protocal.bdf();
                String bdg = this.kqI.ksc.bdg();
                String bdi = this.kqI.ksc.bdi();
                String bdh = this.kqI.ksc.bdh();
                gU = this.kqI.ksc.bdj();
                if (bdg.length() > 0) {
                    int i3 = this.kqI.ksc.gFG;
                    long j2 = this.kqI.ksc.gFH;
                    i3 = this.kqI.ksc.kvE;
                    String str = this.kqI.ksc.gUE;
                    new l(bdf, bdg, bdh, bdi, gU).bcW();
                }
                this.kqI.bby();
                reset();
                this.kqI.ksc.gFG = 0;
                this.kqI.ksc.gFJ = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
        return -1;
    }

    public final int bcO() {
        v.i("MicroMsg.Voip.VoipServiceEx", "reject");
        if (this.kqI.bbC()) {
            synchronized (this.kvd) {
                if (this.kqI.ksc.gFG == 0) {
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                this.kqI.ksc.kxf.bbQ();
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.kqI.mStatus + " roomid:" + this.kqI.ksc.gFG);
                new b(2, this.kqI.ksc.netType, this.kqI.ksc.gFG, new byte[0], new byte[0], this.kqI.ksc.gFH, false, false).bcW();
                if (this.kqI.ksc.kvU == 0 && this.kqI.ksc.kvV == 0) {
                    this.kqI.bbA();
                }
                this.kqI.rB(this.kve.bdR());
                this.kqI.ksc.gU(true);
                String bdf = v2protocal.bdf();
                String bdg = this.kqI.ksc.bdg();
                String bdi = this.kqI.ksc.bdi();
                String bdh = this.kqI.ksc.bdh();
                String bdj = this.kqI.ksc.bdj();
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
                if (bdg.length() > 0) {
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
                    int i = this.kqI.ksc.gFG;
                    long j = this.kqI.ksc.gFH;
                    i = this.kqI.ksc.kvE;
                    String str = this.kqI.ksc.gUE;
                    new l(bdf, bdg, bdh, bdi, bdj).bcW();
                } else {
                    com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
                }
                this.kqI.bby();
                reset();
                this.kqI.ksc.gFG = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.kqI.mStatus);
        return -1;
    }

    public final int bcP() {
        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.kqI.mStatus + " roomid:" + this.kqI.ksc.gFG + ",threadid = " + Thread.currentThread().getId());
        this.kqI.kse.bbP();
        if (this.kqI.ksc.kxf.ksZ == (byte) 1) {
            h hVar = this.kqI.ksc.kxf;
            if (hVar.ktq == 0) {
                hVar.ktj = 0;
            } else {
                hVar.ktj = (int) ((System.currentTimeMillis() - hVar.ktq) / 1000);
            }
            if (hVar.ktj < 0) {
                hVar.ktj = 0;
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
            }
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipDailReport", "devin:endTalk:" + hVar.ktj);
        }
        synchronized (this.kvd) {
            int i = this.kqI.ksc.kxf.ktb;
            if (this.kqI.ksc.gFG != 0 || 8 == i || 9 == i || 10 == i || 11 == i || 12 == i || 99 == i) {
                this.kqI.ksd.bck();
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
                String gU = this.kqI.ksc.gU(true);
                if (gU.length() > 0) {
                    new i(this.kqI.ksc.gFG, this.kqI.ksc.gFH, gU).bcW();
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
                }
                this.kqI.rB(this.kve.bdR());
                String bdf = v2protocal.bdf();
                String bdg = this.kqI.ksc.bdg();
                String bdi = this.kqI.ksc.bdi();
                String bdh = this.kqI.ksc.bdh();
                String bdj = this.kqI.ksc.bdj();
                if (bdg.length() > 0) {
                    int i2 = this.kqI.ksc.gFG;
                    long j = this.kqI.ksc.gFH;
                    i2 = this.kqI.ksc.kvE;
                    String str = this.kqI.ksc.gUE;
                    new l(bdf, bdg, bdh, bdi, bdj).bcW();
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
                }
            } else {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
            }
            this.kqI.bby();
            reset();
            this.kqI.ksc.gFG = 0;
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "hangUp over");
        }
        return 0;
    }

    public final int bcQ() {
        v.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
        if (this.kqI.bbC()) {
            synchronized (this.kvd) {
                if (this.kqI.ksc.gFG == 0) {
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                new b(3, this.kqI.ksc.netType, this.kqI.ksc.gFG, new byte[0], new byte[0], this.kqI.ksc.gFH, false, false).bcW();
                reset();
                this.kqI.ksc.gFG = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.kqI.mStatus);
        return -1;
    }

    public static void a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + i + "  roomKey " + j + " status " + i2);
        if (i != 0 && j != 0) {
            new com.tencent.mm.plugin.voip.model.a.a(i, j, i2, bArr, bArr2, str).bcW();
        }
    }

    public final void bcR() {
        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
        this.kvf.QI();
        this.kvf.ea(60000);
    }
}
