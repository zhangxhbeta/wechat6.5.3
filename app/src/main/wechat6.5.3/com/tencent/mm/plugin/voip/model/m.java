package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.telephony.TelephonyManager;
import com.tencent.mm.a.f;
import com.tencent.mm.ba.b;
import com.tencent.mm.e.a.hc;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static final f<Integer, com.tencent.mm.plugin.voip.model.i.a> cqx = new f(5);
    public boolean aTf;
    public String bdo;
    private com.tencent.mm.network.m ixZ;
    public n kuO;
    public j kuP;
    public boolean kuQ;
    public boolean kuR;
    private long kuS;
    public Map<Integer, Long> kuT;
    public int kuU;
    public Point kuV;
    public boolean kuW;
    public boolean kuX;
    public boolean kuY;
    List<a> kuZ;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ long kjA;
        final /* synthetic */ int kjz;
        final /* synthetic */ m kva;

        AnonymousClass2(m mVar, int i, long j) {
            this.kva = mVar;
            this.kjz = i;
            this.kjA = j;
        }

        public final void run() {
            v.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[]{Integer.valueOf(this.kjz), Long.valueOf(this.kjA)});
            if (this.kva.kuO.bcL()) {
                v.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg");
            } else {
                new e(this.kjz, this.kjA, "").bcW();
            }
        }
    }

    public class a {
        bfj kvb;
        boolean kvc;
    }

    public m() {
        this.aTf = false;
        this.kuQ = false;
        this.kuR = false;
        this.bdo = null;
        this.kuS = 0;
        this.kuT = new HashMap();
        this.kuU = -1;
        this.kuW = false;
        this.kuX = false;
        this.kuY = false;
        this.ixZ = new com.tencent.mm.network.m.a(this) {
            final /* synthetic */ m kva;

            {
                this.kva = r1;
            }

            public final void cI(int i) {
                v.d("MicroMsg.Voip.VoipService", "network status change from " + i);
                if (this.kva.aTf && i == 4) {
                    e eVar = this.kva.kuO.kqI;
                    if (eVar.ksm == 0) {
                        eVar.ksm = eVar.ksc.kvG;
                    }
                    int netType = com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext());
                    if (netType != eVar.ksm) {
                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + eVar.ksm + " to " + netType);
                        try {
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) netType;
                            int appCmd = eVar.ksc.setAppCmd(301, bArr, 4);
                            if (appCmd < 0) {
                                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + eVar.ksc.gFO + ", roomkey=" + eVar.ksc.gFH + "]");
                            }
                            bdc com_tencent_mm_protocal_c_bdc = new bdc();
                            com_tencent_mm_protocal_c_bdc.mZd = 3;
                            com_tencent_mm_protocal_c_bdc.mZe = new b(bArr, 0, 1);
                            eVar.ksc.SendRUDP(com_tencent_mm_protocal_c_bdc.toByteArray(), com_tencent_mm_protocal_c_bdc.toByteArray().length);
                        } catch (Exception e) {
                            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                        }
                        eVar.ksm = netType;
                    }
                    n nVar = this.kva.kuO;
                    new h(nVar.kqI.ksc.gFG, nVar.kqI.ksc.gFH, nVar.kqI.ksc.gFO).bcW();
                }
            }
        };
        this.kuZ = null;
        this.kuO = new n();
        this.aTf = false;
        this.kuQ = false;
        this.kuR = false;
        this.bdo = null;
        ak.a(this.ixZ);
    }

    protected final void finalize() {
        this.kuO.stop();
        this.kuO = null;
        ak.b(this.ixZ);
        super.finalize();
    }

    public final void a(boolean z, boolean z2, String str) {
        v.d("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2);
        this.aTf = z;
        if (z2) {
            this.kuQ = z;
            this.kuO.kqI.ksc.kvR = 0;
        } else {
            this.kuO.kqI.ksc.kvR = 1;
            this.kuR = z;
        }
        this.bdo = str;
    }

    public final void t(boolean z, boolean z2) {
        this.kuX = z;
        this.kuY = z2;
        v.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final void aA(Context context, String str) {
        v.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:" + str);
        if (!be.kS(str) && System.currentTimeMillis() - this.kuS >= 2000) {
            this.kuS = System.currentTimeMillis();
            ak.yW();
            if (c.wH().LX(str) != null) {
                a(context, str, true, false, false);
                bcz();
            }
        }
    }

    public final void aB(Context context, String str) {
        v.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:" + str);
        if (!be.kS(str) && System.currentTimeMillis() - this.kuS >= 2000) {
            this.kuS = System.currentTimeMillis();
            ak.yW();
            if (c.wH().LX(str) != null) {
                a(context, str, true, true, false);
                bcz();
            }
        }
    }

    private static void bcz() {
        qi qiVar = new qi();
        qiVar.brC.bdn = 7;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
    }

    public final void a(bfj com_tencent_mm_protocal_c_bfj) {
        String str = com_tencent_mm_protocal_c_bfj.naR;
        String xF = k.xF();
        int i = com_tencent_mm_protocal_c_bfj.naJ;
        v.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", new Object[]{xF, str, Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS)});
        if (this.kuO.bbD()) {
            n.a(com_tencent_mm_protocal_c_bfj.mqS, com_tencent_mm_protocal_c_bfj.mqT, 2, null, null, str);
            v.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + com_tencent_mm_protocal_c_bfj.mqS);
            g.iuh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj.naJ), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext())), Long.valueOf(System.currentTimeMillis())});
            g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(7)});
            return;
        }
        if ((((TelephonyManager) aa.getContext().getSystemService("phone")).getCallState() != 0 ? 1 : null) != null) {
            n.a(com_tencent_mm_protocal_c_bfj.mqS, com_tencent_mm_protocal_c_bfj.mqT, 3, null, null, str);
            v.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + com_tencent_mm_protocal_c_bfj.mqS);
            g.iuh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj.naJ), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext())), Long.valueOf(System.currentTimeMillis())});
            g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(7)});
            return;
        }
        Object obj;
        this.kuO.bcM();
        n nVar = this.kuO;
        if (nVar.kqI.bbD()) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + nVar.kqI.mStatus);
            obj = null;
        } else if (com_tencent_mm_protocal_c_bfj == null) {
            obj = null;
        } else {
            nVar.kqI.ksc.kxf.kta = com_tencent_mm_protocal_c_bfj.naJ;
            v.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + nVar.kqI.ksc.kxf.kta);
            if (nVar.kqI.ksc.hqt) {
                com.tencent.mm.plugin.voip.b.a.cU("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sm() + "v2protocal already init.");
                nVar.kqI.ksc.gU(false);
                nVar.kqI.ksc.reset();
            }
            e eVar = nVar.kqI;
            eVar.ksh = com_tencent_mm_protocal_c_bfj;
            eVar.ksc.gUE = eVar.ksh.naR;
            eVar.ksc.gFG = eVar.ksh.mqS;
            eVar.ksc.gFH = eVar.ksh.mqT;
            eVar.ksc.gFO = 1;
            eVar.ksc.kvH = 0;
            eVar.mStatus = 3;
            if (d.bdy() || com.tencent.mm.ah.a.Hv() || d.bdB()) {
                v.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                if (d.bdy()) {
                    n.a(com_tencent_mm_protocal_c_bfj.mqS, com_tencent_mm_protocal_c_bfj.mqT, 2, null, null, com_tencent_mm_protocal_c_bfj.naR);
                } else {
                    nVar.bcO();
                    l.a(com_tencent_mm_protocal_c_bfj.naR, (com_tencent_mm_protocal_c_bfj.naJ == 0 ? 1 : null) != null ? at.nvC : at.nvB, 0, 6, aa.getContext().getString(2131235868));
                }
                obj = null;
            } else if (nVar.kqI.ksc.aZP() < 0) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                obj = null;
            } else {
                g.iuh.a(11524, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj.naJ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                nVar.kqI.ksd.bcf();
                obj = 1;
            }
        }
        if (obj == null) {
            v.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
            g.iuh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj.naJ), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext())), Long.valueOf(System.currentTimeMillis())});
            g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(7)});
            return;
        }
        Context context = aa.getContext();
        ak.yW();
        if (c.wH().LX(str) == null) {
            n.a(com_tencent_mm_protocal_c_bfj.mqS, com_tencent_mm_protocal_c_bfj.mqT, 4, null, null, str);
            v.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + com_tencent_mm_protocal_c_bfj.mqS);
            g.iuh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj.naJ), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext())), Long.valueOf(System.currentTimeMillis())});
            g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(7)});
            return;
        }
        if (1 == i || i == 0) {
            a(context, str, false, i == 0, true);
            v.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
        }
        n.a(com_tencent_mm_protocal_c_bfj.mqS, com_tencent_mm_protocal_c_bfj.mqT, 1, this.kuO.kqI.ksc.field_peerId, this.kuO.kqI.ksc.field_capInfo, str);
        g.iuh.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj.naJ), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext())), Long.valueOf(System.currentTimeMillis())});
    }

    public final void rM(int i) {
        if (this.kuZ != null && !this.kuZ.isEmpty()) {
            for (a aVar : this.kuZ) {
                if (aVar != null && aVar.kvb != null && aVar.kvb.mqS == i) {
                    aVar.kvc = true;
                    return;
                }
            }
        }
    }

    public static com.tencent.mm.plugin.voip.model.i.a CN(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int hashCode = str.hashCode();
        com.tencent.mm.plugin.voip.model.i.a aVar = (com.tencent.mm.plugin.voip.model.i.a) cqx.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            return aVar;
        }
        aVar = new com.tencent.mm.plugin.voip.model.i.a();
        if (!aVar.parse(str)) {
            return null;
        }
        cqx.k(Integer.valueOf(hashCode), aVar);
        return aVar;
    }

    private static Map<Integer, Long> aJ(byte[] bArr) {
        if (be.bl(bArr)) {
            return null;
        }
        try {
            ayz com_tencent_mm_protocal_c_ayz = (ayz) new ayz().az(bArr);
            if (com_tencent_mm_protocal_c_ayz == null) {
                return null;
            }
            v.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + com_tencent_mm_protocal_c_ayz.mSs);
            LinkedList linkedList = com_tencent_mm_protocal_c_ayz.mSt;
            if (linkedList.size() != com_tencent_mm_protocal_c_ayz.mSs) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            for (int i = 0; i < com_tencent_mm_protocal_c_ayz.mSs; i++) {
                hashMap.put(Integer.valueOf(((afm) linkedList.get(i)).itH), Long.valueOf(4294967295L & ((long) ((afm) linkedList.get(i)).mFo)));
            }
            if (hashMap.size() != com_tencent_mm_protocal_c_ayz.mSs) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] A(Map<Integer, Long> map) {
        ayz com_tencent_mm_protocal_c_ayz = new ayz();
        LinkedList linkedList = new LinkedList();
        for (Integer num : map.keySet()) {
            afm com_tencent_mm_protocal_c_afm = new afm();
            com_tencent_mm_protocal_c_afm.itH = num.intValue();
            com_tencent_mm_protocal_c_afm.mFo = ((Long) map.get(num)).intValue();
            linkedList.push(com_tencent_mm_protocal_c_afm);
        }
        com_tencent_mm_protocal_c_ayz.mSt = linkedList;
        com_tencent_mm_protocal_c_ayz.mSs = linkedList.size();
        try {
            return com_tencent_mm_protocal_c_ayz.toByteArray();
        } catch (Throwable e) {
            v.a("MicroMsg.Voip.VoipService", e, "", new Object[0]);
            return null;
        }
    }

    private static String aK(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString.toUpperCase();
        }
        return str;
    }

    public final int a(byte[] bArr, int i, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        Map aJ = aJ(this.kuO.kqI.ksg);
        if (aJ == null) {
            v.d("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            j2 = 0;
            j4 = 0;
            j5 = 0;
            for (Integer num : aJ.keySet()) {
                Long l = (Long) aJ.get(num);
                switch (num.intValue()) {
                    case 1:
                        j2 = l.longValue();
                        break;
                    case 2:
                        j4 = l.longValue();
                        break;
                    case 3:
                        j5 = l.longValue();
                        break;
                    default:
                        String str = "MicroMsg.Voip.VoipService";
                        v.d(str, "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j3 = j2;
            j2 = j4;
            j4 = j5;
        }
        v.d("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j3 + " relayData key:" + j2 + " connectingStatusKey:" + j4);
        try {
            bff com_tencent_mm_protocal_c_bff = (bff) new bff().az(bArr);
            for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bff.naK.size(); i2++) {
                bfe com_tencent_mm_protocal_c_bfe = (bfe) com_tencent_mm_protocal_c_bff.naK.get(i2);
                if (com_tencent_mm_protocal_c_bfe.bkM == 1) {
                    bgc com_tencent_mm_protocal_c_bgc;
                    try {
                        com_tencent_mm_protocal_c_bgc = (bgc) new bgc().az(com_tencent_mm_protocal_c_bfe.meT.mQw.lVU);
                    } catch (Throwable e) {
                        v.d("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                        v.a("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                        com_tencent_mm_protocal_c_bgc = null;
                    }
                    if (com_tencent_mm_protocal_c_bgc != null) {
                        v.d("MicroMsg.Voip.VoipService", "voip notify status:" + com_tencent_mm_protocal_c_bgc.eeO);
                        if (j6 < ((long) com_tencent_mm_protocal_c_bfe.itH)) {
                            j5 = (long) com_tencent_mm_protocal_c_bfe.itH;
                        } else {
                            j5 = j6;
                        }
                        if (((long) com_tencent_mm_protocal_c_bfe.itH) > j3) {
                            v.d("MicroMsg.Voip.VoipService", "voiop notify status key[" + com_tencent_mm_protocal_c_bfe.itH + "] > local status key[" + j3 + "] status[" + com_tencent_mm_protocal_c_bgc.eeO + "]");
                            this.kuO.kqI.ksf.a(com_tencent_mm_protocal_c_bgc);
                            j6 = j5;
                        }
                    } else {
                        v.d("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                        j5 = j6;
                    }
                    j6 = j5;
                } else if (com_tencent_mm_protocal_c_bfe.bkM == 2) {
                    bfs com_tencent_mm_protocal_c_bfs;
                    try {
                        com_tencent_mm_protocal_c_bfs = (bfs) new bfs().az(com_tencent_mm_protocal_c_bfe.meT.mQw.lVU);
                    } catch (Throwable e2) {
                        v.d("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        v.a("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                        com_tencent_mm_protocal_c_bfs = null;
                    }
                    if (com_tencent_mm_protocal_c_bfs != null) {
                        v.d("MicroMsg.Voip.VoipService", "notify relay data type:" + com_tencent_mm_protocal_c_bfs.efm);
                        if (j7 < ((long) com_tencent_mm_protocal_c_bfe.itH)) {
                            j5 = (long) com_tencent_mm_protocal_c_bfe.itH;
                        } else {
                            j5 = j7;
                        }
                        if (((long) com_tencent_mm_protocal_c_bfe.itH) > j2) {
                            r0 = new StringBuilder("notify relaydata key:[");
                            v.d("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bfe.itH).append("] > local relaydata key[").append(j2).append("]").toString());
                            if (com_tencent_mm_protocal_c_bfs.efm == 5) {
                                this.kuO.kqI.ksf.a(com_tencent_mm_protocal_c_bfs);
                                j7 = j5;
                            } else if (com_tencent_mm_protocal_c_bfs.efm == 1) {
                                this.kuO.kqI.ksf.b(com_tencent_mm_protocal_c_bfs);
                                j7 = j5;
                            } else {
                                v.d("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + com_tencent_mm_protocal_c_bfs.efm);
                                j7 = j5;
                            }
                        } else {
                            r0 = new StringBuilder("notify relaydata item key[");
                            v.d("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bfe.itH).append("] <=local relaydatakey[").append(j2).append("]").toString());
                            j7 = j5;
                        }
                    } else {
                        v.d("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                    }
                } else if (com_tencent_mm_protocal_c_bfe.bkM == 3) {
                    are bb;
                    try {
                        bb = new are().bb(com_tencent_mm_protocal_c_bfe.meT.mQw.lVU);
                    } catch (Throwable e22) {
                        v.a("MicroMsg.Voip.VoipService", e22, "", new Object[0]);
                        bb = null;
                    }
                    if (bb != null) {
                        if (j8 < ((long) com_tencent_mm_protocal_c_bfe.itH)) {
                            j5 = (long) com_tencent_mm_protocal_c_bfe.itH;
                        } else {
                            j5 = j8;
                        }
                        if (((long) com_tencent_mm_protocal_c_bfe.itH) > j4) {
                            r0 = new StringBuilder("notify connectingStatkey[");
                            v.d("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bfe.itH).append("]> local connectingstatus key[").append(j4).append("]").toString());
                            this.kuO.kqI.ksf.c(bb);
                        }
                        j8 = j5;
                    }
                }
            }
            if (j6 <= j3) {
                j6 = j3;
            }
            if (j7 <= j2) {
                j7 = j2;
            }
            if (j8 <= j4) {
                j8 = j4;
            }
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), Long.valueOf(j6));
            hashMap.put(Integer.valueOf(2), Long.valueOf(j7));
            hashMap.put(Integer.valueOf(3), Long.valueOf(j8));
            byte[] A = A(hashMap);
            if (i == this.kuO.kqI.ksc.gFG && j == this.kuO.kqI.ksc.gFH) {
                this.kuO.kqI.ksg = A;
                v.d("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j6 + ", " + j7 + ", " + j8);
            }
            return 0;
        } catch (Throwable e3) {
            v.a("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
            v.d("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + aK(bArr));
            return 0;
        }
    }

    public static byte[] y(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 12; i2 < i + 12; i2++) {
            bArr2[i2 - 12] = bArr[i2];
        }
        return bArr2;
    }

    public final int u(boolean z, boolean z2) {
        n nVar = this.kuO;
        nVar.bcR();
        h hVar = nVar.kqI.ksc.kxf;
        hVar.ktv = System.currentTimeMillis();
        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + hVar.ktv);
        v.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:" + z);
        if (!nVar.kqI.bbC()) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + nVar.kqI.mStatus);
            return -1;
        } else if (nVar.kqI.ksc.gFG == 0) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            return -1;
        } else {
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sm() + "accept invite, roomid:" + nVar.kqI.ksc.gFG);
            nVar.kvi.ea(50000);
            nVar.kvh.ea(1000);
            nVar.kqI.ksc.kxf.bbQ();
            new com.tencent.mm.plugin.voip.model.a.b(1, nVar.kqI.ksc.netType, nVar.kqI.ksc.gFG, nVar.kqI.ksc.field_peerId, nVar.kqI.ksc.field_capInfo, nVar.kqI.ksc.gFH, z, z2).bcW();
            nVar.kqI.dh(4);
            nVar.kqI.kse.ksy = 1;
            nVar.kqI.blA = true;
            return 0;
        }
    }

    public final int bcA() {
        n nVar = this.kuO;
        v.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (nVar.kqI.ksc.gFG == 0) {
            nVar.kqI.kse.bbP();
            nVar.reset();
            return 0;
        }
        nVar.kqI.ksc.kxf.ksP = nVar.kqI.bbB();
        return nVar.bcP();
    }

    public final void rC(int i) {
        this.kuO.kqI.rC(i);
    }

    public final int bcB() {
        return this.kuO.kqI.ksc.gFG;
    }

    public final long bcC() {
        return this.kuO.kqI.ksc.gFH;
    }

    public final long bcD() {
        return (long) this.kuO.kqI.ksc.kvR;
    }

    public final boolean bcE() {
        return this.kuO.kqI.bbI();
    }

    public final boolean bcF() {
        return this.kuO.kqI.bbJ();
    }

    public final int bbu() {
        g gVar = this.kuO.kqI.kse;
        return gVar.ksw != null ? gVar.ksw.bbu() : 0;
    }

    public final void rN(int i) {
        v.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[]{Integer.valueOf(i)});
        this.kuO.kqI.ksc.kvS = Math.abs(i);
    }

    public final void bcG() {
        v.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[]{Integer.valueOf(1)});
        this.kuO.kqI.ksc.kxf.ktb = 1;
    }

    public final int a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        g gVar = this.kuO.kqI.kse;
        return (gVar.ksy != g.ksx && gVar.kqI.ksc.hqt) ? gVar.kqI.ksc.videoEncodeToLocal(bArr, i, i3, i4, i2, 75, iArr) : -1;
    }

    public final boolean gL(boolean z) {
        g gVar = this.kuO.kqI.kse;
        return gVar.ksw != null ? gVar.ksw.gL(z) : false;
    }

    public final int gR(boolean z) {
        e eVar = this.kuO.kqI;
        int nl = z ? eVar.ksc.nl(412) : eVar.ksc.nl(413);
        if (nl < 0) {
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:" + nl);
        }
        return nl;
    }

    public final int gS(boolean z) {
        e eVar = this.kuO.kqI;
        int nl = z ? eVar.ksc.nl(401) : eVar.ksc.nl(402);
        if (nl < 0) {
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:" + nl);
        }
        return nl;
    }

    public final void rO(int i) {
        n nVar = this.kuO;
        if (nVar.kve != null) {
            nVar.kve.d(2131165831, false, i);
        }
    }

    public final void bcH() {
        n nVar = this.kuO;
        if (nVar.kve != null) {
            nVar.kve.b(2131166006, false, 0, false);
        }
    }

    public final void aCp() {
        n nVar = this.kuO;
        if (nVar.kve != null) {
            nVar.kve.stop();
        }
    }

    public final boolean bcI() {
        n nVar = this.kuO;
        return nVar.kve != null ? nVar.kve.bdP() : true;
    }

    public static void bcJ() {
    }

    public static void bcK() {
    }

    public static void a(Context context, String str, boolean z, boolean z2, boolean z3) {
        if (context == null) {
            context = aa.getContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        hc hcVar = new hc();
        hcVar.bgP.bgS = false;
        hcVar.bgP.bgR = currentTimeMillis;
        hcVar.bgP.bgQ = context;
        com.tencent.mm.sdk.c.a.nhr.z(hcVar);
        v.i("MicroMsg.Voip.VoipService", "start VideoActivity");
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("Voip_User", str);
        intent.putExtra("Voip_Outcall", z);
        intent.putExtra("Voip_VideoCall", z2);
        intent.putExtra("Voip_LastPage_Hash", currentTimeMillis);
        if (z3) {
            intent.setFlags(603979776);
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static float gT(boolean z) {
        float f = 0.74766356f;
        try {
            byte[] bArr;
            m bbw = d.bbw();
            if (z) {
                bArr = bbw.kuO.kqI.ksc.field_capInfo;
            } else {
                bArr = bbw.kuO.kqI.ksc.kvK;
            }
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() > 65535) {
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                }
                wrap.getShort();
                wrap.getShort();
                float f2 = ((float) wrap.getInt()) / 100.0f;
                if (f2 != 0.0f) {
                    f = f2;
                }
                v.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
            }
        } catch (Exception e) {
            v.e("MicroMsg.Voip.VoipService", "update failed: " + e.getMessage());
        }
        return f;
    }

    public final void rP(int i) {
        e eVar = this.kuO.kqI;
        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i;
            eVar.ksc.setJNIAppCmd(2, bArr, 4);
            bek com_tencent_mm_protocal_c_bek = new bek();
            com_tencent_mm_protocal_c_bek.nar = i;
            com_tencent_mm_protocal_c_bek.nas = 1;
            bdc com_tencent_mm_protocal_c_bdc = new bdc();
            com_tencent_mm_protocal_c_bdc.mZd = 4;
            com_tencent_mm_protocal_c_bdc.mZe = new b(com_tencent_mm_protocal_c_bek.toByteArray(), 0, 1);
            eVar.ksc.SendRUDP(com_tencent_mm_protocal_c_bdc.toByteArray(), com_tencent_mm_protocal_c_bdc.toByteArray().length);
        } catch (Exception e) {
            com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
        }
    }
}
