package com.tencent.mm.modelvoice;

import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import com.tencent.mmdb.FileUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class r implements d {
    private static Set<c> djH = new HashSet();

    public static void c(c cVar) {
        if (!djH.contains(cVar)) {
            djH.add(cVar);
        }
    }

    public static void b(c cVar) {
        djH.remove(cVar);
    }

    public final b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String a;
        p av;
        v.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + bmVar.mcb);
        String a2 = m.a(bmVar.mbU);
        if (a2.equals(k.xF())) {
            a = m.a(bmVar.mbV);
        } else {
            a = a2;
        }
        ak.yW();
        bx S = c.wJ().S(a, bmVar.mcb);
        if (S.field_msgId != 0 && S.field_createTime + 604800000 < aw.h(a, (long) bmVar.hNS)) {
            v.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", Long.valueOf(bmVar.mcb));
            aw.i(a, bmVar.mcb);
            av = m.Lz().av(bmVar.mcb);
            if (!(av == null || be.kS(av.aST))) {
                q.lH(av.aST);
            }
        }
        av = new p();
        av.ble = a;
        av.dhH = (long) bmVar.hNS;
        av.bmL = bmVar.mcb;
        av.bNo = bmVar.mbZ;
        v.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", bmVar.mbZ);
        a = m.a(bmVar.mbW);
        if (com.tencent.mm.model.m.dE(a2)) {
            a = aw.fM(a);
            v.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=" + a);
        }
        Map q = bf.q(a, "msg");
        if (q == null) {
            g.iuh.a(111, 227, 1, false);
            return null;
        }
        try {
            av.dgC = Integer.valueOf((String) q.get(".msg.voicemsg.$length")).intValue();
            av.clientId = (String) q.get(".msg.voicemsg.$clientmsgid");
            int intValue = Integer.valueOf((String) q.get(".msg.voicemsg.$endflag")).intValue();
            int intValue2 = Integer.valueOf((String) q.get(".msg.voicemsg.$cancelflag")).intValue();
            av.djF = Integer.valueOf((String) q.get(".msg.voicemsg.$voicelength")).intValue();
            av.dhC = (String) q.get(".msg.voicemsg.$fromusername");
            String str = (String) q.get(".msg.commenturl");
            av.diF = Integer.valueOf(be.ah((String) q.get(".msg.voicemsg.$forwardflag"), "0")).intValue();
            av.diy = (String) q.get(".msg.voicemsg.$voiceformat");
            av.djG = be.getLong((String) q.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                v.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + bmVar.mcb);
                av = m.Lz().av(av.bmL);
                if (av != null) {
                    q.lF(av.aST);
                }
                return null;
            }
            boolean z;
            if (intValue == 1) {
                v.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + bmVar.mcb);
                av.cyu = av.dgC;
            }
            av.bkU = 284334;
            byte[] a3 = m.a(bmVar.mbY);
            if (a3 != null) {
                v.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a3.length + " srvId:" + bmVar.mcb);
            }
            int i = bmVar.eeO;
            String str2 = bmVar.mbZ;
            com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
            p av2 = m.Lz().av(av.bmL);
            if (av2 == null || av2.status != 99) {
                ak.yW();
                if (c.wJ().S(av.ble, av.bmL).field_msgSvrId == av.bmL && av2 == null) {
                    i = 0;
                } else {
                    if (av2 != null) {
                        av.aST = av2.aST;
                    } else {
                        av.aST = u.lI(av.dhC);
                    }
                    av.bkU |= 1;
                    v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sm() + "checktime :" + aVar2.sn());
                    z = false;
                    if (a3 != null && a3.length > 1) {
                        if (av2 != null) {
                            v.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But  VoiceInfo is not new !");
                        }
                        a = av.diy;
                        String str3 = av.aST;
                        int write = q.af(a, str3).write(a3, a3.length, 0);
                        if (write < 0) {
                            v.e("MicroMsg.VoiceLogic", "Write Failed File:" + str3 + " newOffset:" + write + " voiceFormat:" + a);
                            z = false;
                        } else if (a3.length != write) {
                            v.e("MicroMsg.VoiceLogic", "Write File:" + str3 + " fileOff:" + write + " bufLen:" + a3.length + " voiceFormat:" + a);
                            z = false;
                        } else {
                            v.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str3 + "] + buf:" + a3.length + " voiceFormat:" + a);
                            q.lD(str3);
                            z = true;
                        }
                    }
                    v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sm() + "checktime :" + aVar2.sn());
                    av.dhI = System.currentTimeMillis() / 1000;
                    av.bkU |= FileUtils.S_IRUSR;
                    if (z) {
                        av.status = 99;
                    } else if (av.cyu == 0) {
                        av.status = 5;
                    } else {
                        av.status = 6;
                    }
                    av.bkU |= 64;
                    if (av2 == null) {
                        if (z) {
                            av.dhL = (int) q.a(av, z, i, str, str2, aVar);
                        }
                        if (aVar != null) {
                            av.bNn = aw.c(aVar);
                            if (aVar.czu != null) {
                                av.cQM = aVar.czu.mcc;
                            }
                        }
                        v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sm() + "checktime :" + aVar2.sn());
                        av.bkU = -1;
                        v.d("MicroMsg.VoiceLogic", "Insert fileName:" + av.aST + " stat:" + av.status + " net:" + av.dgC + " total:" + av.cyu);
                        if (m.Lz().b(av)) {
                            v.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.sm() + "checktime :" + aVar2.sn());
                            if (z) {
                                i = 1;
                            }
                        } else {
                            v.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + av.aST + " stat:" + av.status + " net:" + av.dgC + " total:" + av.cyu);
                            i = -2;
                        }
                    } else {
                        v.d("MicroMsg.VoiceLogic", "Sync Update file:" + av.aST + " stat:" + av.status);
                        if (!q.a(av)) {
                            i = -44;
                        } else if (z) {
                            q.a(av, aVar);
                            i = 1;
                        }
                    }
                    if (av2 != null && av2.dhE == av.cyu) {
                        q.a(av2.aST, av2.dhE, aVar);
                        v.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + av2.aST);
                    }
                    v.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", aVar, Boolean.valueOf(z), be.bur());
                    m.LB().run();
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (i > 0) {
                v.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", Integer.valueOf(i), Long.valueOf(bmVar.mcb), Integer.valueOf(bmVar.mcc));
                g.iuh.a(111, 228, 1, false);
                ak.yW();
                bx S2 = c.wJ().S(av.ble, av.bmL);
                S2.vg(0);
                for (final c cVar : djH) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ r djJ;

                        public final void run() {
                            c cVar = cVar;
                            ak.yW();
                            cVar.x(c.wJ().S(av.ble, av.bmL));
                        }
                    });
                }
                S = S2;
            } else {
                v.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", Integer.valueOf(i), Long.valueOf(bmVar.mcb), Integer.valueOf(bmVar.mcc), be.bur());
                S = null;
            }
            z = S != null && S.field_msgId > 0;
            return new b(S, z);
        } catch (Throwable e) {
            g.iuh.a(111, 227, 1, false);
            v.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            v.e("MicroMsg.VoiceMsgExtension", "exception:%s", be.e(e));
            return null;
        }
    }

    public final void d(at atVar) {
        v.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + atVar.field_imgPath + " " + atVar.field_talker);
        if (!com.tencent.mm.model.m.eY(atVar.field_talker)) {
            q.lH(atVar.field_imgPath);
        }
    }
}
