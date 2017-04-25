package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.e.a.qi.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

public final class a extends c<qi> {
    public a() {
        this.nhz = qi.class.getName().hashCode();
    }

    private static boolean a(qi qiVar) {
        boolean z = true;
        if ((qiVar instanceof qi) && ak.uz()) {
            m bbw;
            Object obj;
            Object obj2;
            bfj com_tencent_mm_protocal_c_bfj;
            n nVar;
            switch (qiVar.brC.bdn) {
                case 1:
                    d.bbw();
                    com.tencent.mm.plugin.voip.model.i.a CN = m.CN(qiVar.brC.content);
                    if (CN != null) {
                        if (!CN.bbT()) {
                            if (CN.ktA != com.tencent.mm.plugin.voip.model.i.a.ktG) {
                                z = false;
                            }
                            if (z) {
                                qiVar.brD.type = 3;
                                break;
                            }
                        }
                        qiVar.brD.type = 2;
                        break;
                    }
                    break;
                case 2:
                    qiVar.brD.brE = d.bbw().aTf;
                    break;
                case 3:
                    bbw = d.bbw();
                    obj = qiVar.brC.brw;
                    if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                        obj2 = new byte[(obj.length - 1)];
                        System.arraycopy(obj, 1, obj2, 0, obj2.length);
                        h hVar = bbw.kuO.kqI.ksc.kxf;
                        hVar.ktu = System.currentTimeMillis();
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.VoipDailReport", "devin:recvInvite:" + hVar.ktu);
                        try {
                            bfj com_tencent_mm_protocal_c_bfj2 = (bfj) new bfj().az(obj2);
                            v.d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
                            if (!bbw.kuO.bcL()) {
                                g.iuh.a(11523, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj2.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj2.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj2.naJ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                                bbw.a(com_tencent_mm_protocal_c_bfj2);
                                break;
                            }
                            g.iuh.a(11523, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj2.mqS), Long.valueOf(com_tencent_mm_protocal_c_bfj2.mqT), Integer.valueOf(com_tencent_mm_protocal_c_bfj2.naJ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                            break;
                        } catch (Throwable e) {
                            v.a("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            break;
                        }
                    }
                case 4:
                    b bVar = qiVar.brD;
                    m bbw2 = d.bbw();
                    Context context = aa.getContext();
                    if (bbw2.aTf && bbw2.kuX && !bbw2.kuY) {
                        v.d("MicroMsg.Voip.VoipService", "isVideoCalling " + bbw2.kuQ + " isAudioCalling " + bbw2.kuR);
                        if (!be.kS(bbw2.bdo)) {
                            ak.yW();
                            if (com.tencent.mm.model.c.wH().LX(bbw2.bdo) != null) {
                                m.a(context, bbw2.bdo, true, bbw2.kuQ, true);
                                bVar.brF = z;
                                break;
                            }
                        }
                    }
                    z = false;
                    bVar.brF = z;
                case 5:
                    if (!com.tencent.mm.ah.a.Hv()) {
                        if (qiVar.brC.brx != 2) {
                            if (qiVar.brC.brx != 3) {
                                if (qiVar.brC.brx == 4) {
                                    l.ay(qiVar.brC.context, qiVar.brC.bdo);
                                    break;
                                }
                            }
                            l.ax(qiVar.brC.context, qiVar.brC.bdo);
                            break;
                        }
                        l.aw(qiVar.brC.context, qiVar.brC.bdo);
                        break;
                    }
                    com.tencent.mm.ui.base.g.f(qiVar.brC.context, 2131233933, 2131231164);
                    break;
                    break;
                case 6:
                    bbw = d.bbw();
                    byte[] bArr = qiVar.brC.brw;
                    if (bArr != null) {
                        v.d("MicroMsg.Voip.VoipService", "voipNotify with data size:" + bArr.length);
                        int i = ByteBuffer.wrap(bArr, 0, 4).getInt();
                        long j = ByteBuffer.wrap(bArr, 4, 8).getLong();
                        v.d("MicroMsg.Voip.VoipService", "voipNotify roomid:" + i + " roomkey:" + j);
                        v.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[]{Integer.valueOf(bbw.kuO.kqI.ksc.gFG), Integer.valueOf(i)});
                        if (i == 0 || r5.kqI.ksc.gFG != i) {
                            z = false;
                        }
                        if (!z) {
                            v.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                            break;
                        }
                        if (bArr.length > 12) {
                            bbw.a(m.y(bArr, bArr.length - 12), i, j);
                        }
                        n nVar2 = bbw.kuO;
                        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.sm() + " need doSync by notify, status:" + nVar2.kqI.mStatus);
                        nVar2.kqI.ksf.a(null, false, 7);
                        break;
                    }
                    v.d("MicroMsg.Voip.VoipService", "sidney:notify content null");
                    break;
                case 9:
                    bbw = d.bbw();
                    obj = qiVar.brC.brw;
                    if (!be.bl(obj) && obj[0] == (byte) 3) {
                        try {
                            v.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            com_tencent_mm_protocal_c_bfj = new bfj();
                            com_tencent_mm_protocal_c_bfj.az(obj2);
                            bbw.rM(com_tencent_mm_protocal_c_bfj.mqS);
                            nVar = bbw.kuO;
                            v.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS)});
                            if (com_tencent_mm_protocal_c_bfj.mqS == nVar.kqI.ksh.mqS) {
                                nVar.bcP();
                                nVar.kqI.shutdown();
                                break;
                            }
                        } catch (Exception e2) {
                            v.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[]{e2.getMessage()});
                            break;
                        }
                    }
                    break;
                case 10:
                    bbw = d.bbw();
                    obj = qiVar.brC.brw;
                    if (!be.bl(obj) && obj[0] == (byte) 2) {
                        try {
                            v.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            com_tencent_mm_protocal_c_bfj = new bfj();
                            com_tencent_mm_protocal_c_bfj.az(obj2);
                            nVar = bbw.kuO;
                            v.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfj.mqS)});
                            if (com_tencent_mm_protocal_c_bfj.mqS == nVar.kqI.ksh.mqS) {
                                if (!nVar.kqI.blA) {
                                    v.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                                    nVar.bcP();
                                    nVar.kqI.shutdown();
                                    break;
                                }
                                v.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                                break;
                            }
                        } catch (Exception e22) {
                            v.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[]{e22.getMessage()});
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
