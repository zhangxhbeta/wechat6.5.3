package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.bbom.l;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b implements com.tencent.mm.sdk.h.g.a {
    Queue<b> cKe = new LinkedList();
    ah cKi = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b cQI;

        {
            this.cQI = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr pusherTry onTimerExpired tryStartNetscene");
            b bVar = this.cQI;
            long Ni = t.Ni();
            if (bVar.cxK && Ni - bVar.cxV > 300000) {
                v.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(Ni - bVar.cxV));
                bVar.cxK = false;
            }
            if (bVar.cxK) {
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene netSceneRunning: " + bVar.cxK + " ret");
            } else {
                a aVar;
                String str = null;
                a aVar2 = null;
                if (!bVar.cQF.isEmpty()) {
                    aVar = (a) bVar.cQF.poll();
                    str = aVar.cQK;
                    aVar2 = aVar;
                }
                if (aVar2 == null) {
                    synchronized (bVar.cQE) {
                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene needGetInfosMap size[%d], content[%s]", Integer.valueOf(bVar.cQE.size()), bVar.cQE);
                        if (bVar.cQG == null || t.kS(bVar.cQG.Hh())) {
                            bVar.cQE.clear();
                            bVar.cQG = null;
                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene currentListener is or its chatroomid is null ret");
                        } else {
                            str = bVar.cQG.Hh();
                            LinkedList linkedList = (LinkedList) bVar.cQE.get(str);
                            if (linkedList == null || linkedList.size() == 0) {
                                String str2 = "MicroMsg.GetChatRoomMsgService";
                                String str3 = "summerbadcr tryStartNetscene current talker[%s] no infos and ret infos size:%d";
                                Object[] objArr = new Object[2];
                                objArr[0] = str;
                                objArr[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                                v.i(str2, str3, objArr);
                            } else {
                                while (!linkedList.isEmpty()) {
                                    a aVar3 = (a) linkedList.poll();
                                    ak.yW();
                                    bx T = com.tencent.mm.model.c.wJ().T(str, (long) aVar3.cQM);
                                    if (T.field_msgId == 0) {
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map not in db:" + aVar3);
                                        aVar = aVar3;
                                        break;
                                    } else if ((T.field_flag & 1) != 0) {
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but fault: " + aVar3 + " flag:" + T.field_flag + " seq:" + T.field_msgSeq);
                                        aVar = aVar3;
                                        break;
                                    } else {
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but not fault: " + aVar3 + " flag:" + T.field_flag + " seq:" + T.field_msgSeq);
                                    }
                                }
                                aVar = aVar2;
                                if (aVar == null && !t.kS(str)) {
                                    ak.yW();
                                    ab Mh = com.tencent.mm.model.c.wK().Mh(str);
                                    if (Mh != null) {
                                        long j = Mh.field_lastSeq;
                                        long j2 = Mh.field_firstUnDeliverSeq;
                                        int i = Mh.field_UnDeliverCount;
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene filterSeq[%d], lastSeq[%d], undeliverCount[%d]", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i));
                                        if (j != 0) {
                                            ak.yW();
                                            if (com.tencent.mm.model.c.wJ().T(str, j).field_msgId == 0) {
                                                aVar = new a(str, (int) j2, (int) j, i, 1);
                                                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db:" + aVar);
                                            } else {
                                                if (i > 0) {
                                                    Mh.df(0);
                                                    ak.yW();
                                                    com.tencent.mm.model.c.wK().a(Mh, str, true);
                                                }
                                                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db but has get msg id:%d, svrId:%d, undeliverCount[%d]", Long.valueOf(r5.field_msgId), Long.valueOf(r5.field_msgSvrId), Integer.valueOf(Mh.field_UnDeliverCount));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar = aVar2;
                }
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene nextInfo:" + aVar);
                if (aVar == null) {
                    bVar.cKi.ea(500);
                } else {
                    bVar.cxK = true;
                    bVar.cxV = Ni;
                    com.tencent.mm.ba.a usVar = new us();
                    usVar.mxp = m.lY(str);
                    usVar.mcc = aVar.cQM;
                    if (aVar.cQM == 0) {
                        usVar.mxq = 0;
                        if (aVar.cQN != 0) {
                            v.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene msgSeq is 0 but needCount[%d], stack[%s]!", Integer.valueOf(aVar.cQN), t.Nm());
                        }
                    } else {
                        usVar.mxq = 18;
                    }
                    usVar.mxr = aVar.cQO;
                    usVar.mxt = aVar.cQL;
                    if ((usVar.mxr != 0 && usVar.mxt > usVar.mcc) || (usVar.mxr == 0 && usVar.mxt < usVar.mcc)) {
                        v.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq msgSeq UpDownFlag not match[%d][%d][%d], stack[%s]!", Integer.valueOf(usVar.mxt), Integer.valueOf(usVar.mcc), Integer.valueOf(usVar.mxr), t.Nm());
                        com.tencent.mm.plugin.report.b.itm.a(403, usVar.mxr == 0 ? 0 : 1, 1, false);
                        if (bVar.cQG != null) {
                            bVar.cQG.fM(1);
                        }
                    }
                    if (usVar.mxr != 0 && usVar.mxt == 0 && aVar.cQN < 18) {
                        if (aVar.cQN > 0) {
                            usVar.mxq = aVar.cQN;
                        } else {
                            usVar.mxq = 1;
                            com.tencent.mm.plugin.report.b.itm.a(403, 3, 1, false);
                        }
                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene UpDownFlag FilterSeq 0 fix need nextInfo: %d req: %d", Integer.valueOf(aVar.cQN), Integer.valueOf(usVar.mxq));
                    }
                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq[%d], MsgSeq[%d], NeedCount[%d], UpDownFlag[%d], ClearFlag[%d]", Integer.valueOf(usVar.mxt), Integer.valueOf(usVar.mcc), Integer.valueOf(usVar.mxq), Integer.valueOf(usVar.mxr), Integer.valueOf(usVar.mxs));
                    com.tencent.mm.v.b.a aVar4 = new com.tencent.mm.v.b.a();
                    aVar4.czn = usVar;
                    aVar4.czo = new ut();
                    aVar4.uri = "/cgi-bin/micromsg-bin/getcrmsg";
                    aVar4.czm = 805;
                    aVar4.czp = 0;
                    aVar4.czq = 0;
                    com.tencent.mm.plugin.report.b.itm.a(403, usVar.mcc == 0 ? 9 : 8, 1, false);
                    u.a(aVar4.Bv(), new com.tencent.mm.v.u.a(bVar) {
                        final /* synthetic */ b cQI;

                        {
                            this.cQI = r1;
                        }

                        public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback [%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (kVar.getType() != 805) {
                                return 0;
                            }
                            com.tencent.mm.plugin.report.b.itm.a(403, 10, 1, false);
                            this.cQI.cxK = false;
                            if (i == 0 && i2 == 0 && bVar != null) {
                                us usVar = (us) bVar.czk.czs;
                                ut utVar = (ut) bVar.czl.czs;
                                String a = m.a(usVar.mxp);
                                if (usVar.mcc == 0) {
                                    String str2 = "MicroMsg.GetChatRoomMsgService";
                                    String str3 = "summerbadcr clear chatroomId[%s], resp size[%d], ContinueFlag[%d]";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = a;
                                    objArr[1] = Integer.valueOf(utVar.mxu == null ? -1 : utVar.mxu.size());
                                    objArr[2] = Integer.valueOf(utVar.miR);
                                    v.i(str2, str3, objArr);
                                    if (this.cQI.cKi.btC()) {
                                        this.cQI.cKi.ea(500);
                                    }
                                    com.tencent.mm.plugin.report.b.itm.a(403, 12, 1, false);
                                    return 0;
                                }
                                int i3;
                                int i4;
                                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback req chatroomId[%s], resp ContinueFlag[%d]", a, Integer.valueOf(utVar.miR));
                                synchronized (this.cQI.cQE) {
                                    if (this.cQI.cQG == null || t.kS(this.cQI.cQG.Hh())) {
                                        this.cQI.cQE.clear();
                                        this.cQI.cQG = null;
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener is or its chatroomid is null so clear map");
                                        com.tencent.mm.plugin.report.b.itm.a(403, 15, 1, false);
                                    } else if (this.cQI.cQG.Hh().equals(a)) {
                                        com.tencent.mm.plugin.report.b.itm.a(403, 13, 1, false);
                                        LinkedList linkedList = utVar.mxu;
                                        String str4 = "MicroMsg.GetChatRoomMsgService";
                                        String str5 = "summerbadcr callback currentListener still in and resp.ContinueFlag[%d], size[%d]";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(utVar.miR);
                                        objArr2[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                                        v.i(str4, str5, objArr2);
                                        if (!(utVar.miR <= 0 || linkedList == null || linkedList.isEmpty())) {
                                            i3 = ((bm) linkedList.getFirst()).mcc;
                                            i4 = ((bm) linkedList.getLast()).mcc;
                                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback ContinueFlag[%d], list size[%d],firstSeq[%d], lastSeq[%d], UpDownFlag[%d]", Integer.valueOf(utVar.miR), Integer.valueOf(linkedList.size()), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(usVar.mxr));
                                        }
                                    } else {
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener changed current[%s], old[%s]", this.cQI.cQG.Hh(), a);
                                        com.tencent.mm.plugin.report.b.itm.a(403, 14, 1, false);
                                    }
                                }
                                if (this.cQI.cKi.btC()) {
                                    this.cQI.cKi.ea(500);
                                }
                                if (utVar.mxu == null || utVar.mxu.isEmpty()) {
                                    com.tencent.mm.plugin.report.b.itm.a(403, 19, 1, false);
                                    if (utVar.miR == 0 && usVar.mxr != 0) {
                                        ak.yW();
                                        at T = com.tencent.mm.model.c.wJ().T(a, (long) usVar.mcc);
                                        if (T.field_msgSeq == ((long) usVar.mcc)) {
                                            int i5 = T.field_flag;
                                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty reset Fault[%d, %d, %d, %d, %d, %d, %d]", Integer.valueOf(T.field_flag), Integer.valueOf(T.field_isSend), Long.valueOf(T.field_msgId), Long.valueOf(T.field_msgSvrId), Long.valueOf(T.field_msgSeq), Long.valueOf(T.field_createTime), Integer.valueOf(T.field_type));
                                            if ((i5 & 1) != 0) {
                                                T.dr(i5 & -2);
                                                ak.yW();
                                                com.tencent.mm.model.c.wJ().a(T.field_msgId, T);
                                                com.tencent.mm.plugin.report.b.itm.a(403, t.ay(T.field_createTime) < 259200000 ? 36 : 37, 1, false);
                                            }
                                        }
                                    }
                                } else {
                                    boolean z;
                                    boolean z2;
                                    b bVar2 = new b(this.cQI);
                                    bVar2.cQK = a;
                                    bVar2.cQO = usVar.mxr;
                                    if (utVar.miR == 0) {
                                        bVar2.cQQ = false;
                                        com.tencent.mm.plugin.report.b.itm.a(403, 21, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.b.itm.a(403, 20, 1, false);
                                    }
                                    ak.yW();
                                    ab Mh = com.tencent.mm.model.c.wK().Mh(a);
                                    int size;
                                    if (usVar.mxr != 0) {
                                        com.tencent.mm.plugin.report.b.itm.a(403, 18, (long) utVar.mxu.size(), false);
                                        size = (Mh == null ? 0 : Mh.field_UnDeliverCount) - utVar.mxu.size();
                                        if (size < 0) {
                                            size = 0;
                                        }
                                        if (Mh != null) {
                                            Mh.dn(size);
                                            ak.yW();
                                            i3 = com.tencent.mm.model.c.wK().a(Mh, Mh.field_username, false);
                                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback up and FilterSeq 0 but NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", Integer.valueOf(usVar.mxq), Integer.valueOf(i4), Integer.valueOf(Mh.field_UnDeliverCount), Integer.valueOf(i3));
                                        }
                                        if (Mh == null && size == 0) {
                                            bVar2.cQQ = false;
                                        }
                                    } else {
                                        if (usVar.mxt <= 0 || usVar.mxt != usVar.mcc) {
                                            com.tencent.mm.plugin.report.b.itm.a(403, 16, (long) utVar.mxu.size(), false);
                                        } else {
                                            com.tencent.mm.plugin.report.b.itm.a(403, 17, (long) utVar.mxu.size(), false);
                                        }
                                        if (Mh != null) {
                                            size = Mh.field_UnDeliverCount;
                                            if (size > 0) {
                                                i4 = size - utVar.mxu.size();
                                                if (i4 < 0) {
                                                    i4 = 0;
                                                }
                                                Mh.dn(i4);
                                                ak.yW();
                                                i4 = com.tencent.mm.model.c.wK().a(Mh, Mh.field_username, false);
                                                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback down NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", Integer.valueOf(usVar.mxq), Integer.valueOf(size), Integer.valueOf(Mh.field_UnDeliverCount), Integer.valueOf(i4));
                                            }
                                        }
                                    }
                                    ak.yW();
                                    i3 = (int) com.tencent.mm.model.c.xw().Mu(a);
                                    if (i3 != 0) {
                                        z = false;
                                        while (!utVar.mxu.isEmpty() && ((bm) utVar.mxu.peek()).mcc <= i3) {
                                            utVar.mxu.poll();
                                            z = true;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        bVar2.cQQ = false;
                                    }
                                    if (usVar.mxr == 0 || utVar.mxu.isEmpty()) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (utVar.mxu.size() > 1 && z2) {
                                        Collections.reverse(utVar.mxu);
                                    }
                                    if (!utVar.mxu.isEmpty()) {
                                        bVar2.cQP = utVar.mxu;
                                        this.cQI.cKe.add(bVar2);
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback add resp to respList size[%d], dealFault[%b], lastDeleteSeq[%d], needReverse[%b], removed[%b]", Integer.valueOf(this.cQI.cKe.size()), Boolean.valueOf(bVar2.cQQ), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z));
                                    }
                                }
                                if (!this.cQI.cKe.isEmpty() && this.cQI.cKj.btC()) {
                                    this.cQI.cKj.ea(50);
                                } else if (this.cQI.cQG != null) {
                                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty[%b] stopped[%b] at last", Boolean.valueOf(this.cQI.cKe.isEmpty()), Boolean.valueOf(this.cQI.cKj.btC()));
                                    this.cQI.cQG.fM(1);
                                }
                                return 0;
                            }
                            v.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback errType:" + i + " errCode:" + i2 + " will retry");
                            if (this.cQI.cQG != null) {
                                v.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback err as ret errType, errcode[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                                this.cQI.cQG.fM(1);
                            }
                            com.tencent.mm.plugin.report.b.itm.a(403, 11, 1, false);
                            this.cQI.cKi.ea(5000);
                            return 0;
                        }
                    }, true);
                }
            }
            return false;
        }
    }, false);
    final ah cKj = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b cQI;
        private com.tencent.mm.plugin.f.a.c cQJ = new com.tencent.mm.plugin.f.a.c();

        {
            this.cQI = r2;
        }

        public final boolean oU() {
            ak.yW();
            com.tencent.mm.model.c.wJ().MC("MicroMsg.GetChatRoomMsgService" + this.cQI.hashCode());
            if (this.cQI.cKe.isEmpty()) {
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and return!");
                ak.yW();
                com.tencent.mm.model.c.wJ().MD("MicroMsg.GetChatRoomMsgService" + this.cQI.hashCode());
                return false;
            }
            boolean z;
            long Ni = t.Ni();
            int i = (this.cQI.cxK ? 9 : 18) + 1;
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler start maxCnt[%d]", Integer.valueOf(i));
            int i2 = 0;
            while (i2 < i) {
                b bVar = (b) this.cQI.cKe.peek();
                if (bVar == null) {
                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and break! currentListener[%s]", this.cQI.cQG);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().MD("MicroMsg.GetChatRoomMsgService" + this.cQI.hashCode());
                    z = false;
                    if (this.cQI.cQG != null) {
                        this.cQI.cQG.fM(0);
                    }
                    this.cQI.cKi.ea(0);
                } else {
                    LinkedList linkedList = bVar.cQP;
                    int size = linkedList.size();
                    int i3 = size - 1;
                    int i4 = bVar.cKq;
                    if (size <= i4) {
                        this.cQI.cKe.poll();
                        if (this.cQI.cKe.isEmpty()) {
                            b.d(new HashMap(this.cQI.cQH), bVar.cQK);
                            ak.yW();
                            com.tencent.mm.model.c.wJ().MD("MicroMsg.GetChatRoomMsgService" + this.cQI.hashCode());
                            String str = "MicroMsg.GetChatRoomMsgService";
                            String str2 = "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break currentListener[%s], needCallBack[%b]";
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(i4);
                            objArr[1] = Integer.valueOf(size);
                            objArr[2] = this.cQI.cQG;
                            objArr[3] = Boolean.valueOf(this.cQI.cQG == null ? false : this.cQI.cQG.Hi());
                            v.i(str, str2, objArr);
                            z = false;
                            if (this.cQI.cQG != null) {
                                this.cQI.cQG.fM(0);
                            }
                            this.cQI.cKi.ea(0);
                        } else {
                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i4), Integer.valueOf(size));
                        }
                    } else {
                        bm bmVar = (bm) linkedList.get(i4);
                        v.d("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process curIdx[%d] last[%d] dealFault[%b] MsgSeq[%d], CreateTime[%d], MsgType[%d]", Integer.valueOf(i4), Integer.valueOf(i3), Boolean.valueOf(bVar.cQQ), Integer.valueOf(bmVar.mcc), Integer.valueOf(bmVar.hNS), Integer.valueOf(bmVar.gll));
                        boolean z2 = false;
                        int i5 = -1;
                        if (bVar.cQQ && i4 == i3) {
                            ak.yW();
                            if (com.tencent.mm.model.c.wJ().T(bVar.cQK, (long) bmVar.mcc).field_msgId == 0) {
                                ak.yW();
                                af Mh = com.tencent.mm.model.c.wK().Mh(bVar.cQK);
                                if (Mh == null) {
                                    z2 = true;
                                } else if (!(bVar.cQO == 0 || Mh.field_firstUnDeliverSeq == ((long) bmVar.mcc)) || (bVar.cQO == 0 && Mh.field_lastSeq != ((long) bmVar.mcc))) {
                                    z2 = true;
                                    i5 = Mh.field_UnDeliverCount;
                                }
                            } else {
                                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed curIdx == last[%d], MsgSeq[%d], flag[%d]", Integer.valueOf(i4), Long.valueOf(com.tencent.mm.model.c.wJ().T(bVar.cQK, (long) bmVar.mcc).field_msgSeq), Integer.valueOf(com.tencent.mm.model.c.wJ().T(bVar.cQK, (long) bmVar.mcc).field_flag));
                            }
                        }
                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.cQO), Integer.valueOf(bmVar.mcc));
                        com.tencent.mm.plugin.f.a.c.a(new com.tencent.mm.v.d.a(bmVar, true, z2, bVar.cQO != 0), new l(false));
                        if (z2 && r4 == 0 && size > 1 && bVar.cQO == 0) {
                            ak.yW();
                            at T = com.tencent.mm.model.c.wJ().T(bVar.cQK, (long) bmVar.mcc);
                            int i6 = T.field_flag;
                            long j = T.field_createTime;
                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", Integer.valueOf(size), Integer.valueOf(bmVar.mcc), Integer.valueOf(i6), Long.valueOf(j));
                            if ((i6 & 4) == 0) {
                                ak.yW();
                                at T2 = com.tencent.mm.model.c.wJ().T(bVar.cQK, (long) (bmVar.mcc + 1));
                                if (T2.field_msgId == 0 || T2.field_msgSeq != ((long) (bmVar.mcc + 1))) {
                                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", Boolean.valueOf(false), Long.valueOf(T2.field_msgId), Long.valueOf(T2.field_msgSeq));
                                } else {
                                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet seq[%d], creatTime[%d], flag[%d]", Long.valueOf(T2.field_msgSeq), Long.valueOf(T2.field_createTime), Integer.valueOf(T2.field_flag));
                                    if ((T2.field_flag & 4) != 0) {
                                        T.dr(T.field_flag & -2);
                                        ak.yW();
                                        com.tencent.mm.model.c.wJ().a(T.field_msgId, T);
                                        T2.dr(T2.field_flag & -2);
                                        ak.yW();
                                        com.tencent.mm.model.c.wJ().a(T2.field_msgId, T2);
                                        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet update succ!");
                                        com.tencent.mm.plugin.report.b.itm.a(403, 34, 1, false);
                                    }
                                }
                            }
                        }
                        bVar.cKq++;
                    }
                    i2++;
                }
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.cQI.cxK + " ret:" + z + " maxCnt:" + i + " take:" + (t.Ni() - Ni) + "ms");
                return z;
            }
            z = true;
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.cQI.cxK + " ret:" + z + " maxCnt:" + i + " take:" + (t.Ni() - Ni) + "ms");
            return z;
        }
    }, true);
    Map<String, LinkedList<a>> cQE = new HashMap();
    LinkedBlockingQueue<a> cQF = new LinkedBlockingQueue();
    c cQG;
    Map<Long, an> cQH = new HashMap();
    boolean cxK = false;
    long cxV = 0;

    public static class a {
        final String cQK;
        final int cQL;
        final int cQM;
        final int cQN;
        final int cQO;

        public a(String str, int i, int i2, int i3, int i4) {
            this.cQK = str;
            this.cQL = i;
            this.cQM = i2;
            this.cQN = i3;
            this.cQO = i4;
        }

        public final String toString() {
            return "GetChatRoomMsgInfo hash[" + hashCode() + "], chatroomId[" + this.cQK + "], filterSeq[" + this.cQL + "], msgSeq[" + this.cQM + "], needCount[" + this.cQN + "], upDownFlag[" + this.cQO + "]";
        }
    }

    class b {
        int cKq = 0;
        final /* synthetic */ b cQI;
        String cQK;
        int cQO = 0;
        LinkedList<bm> cQP = new LinkedList();
        boolean cQQ = true;

        b(b bVar) {
            this.cQI = bVar;
        }
    }

    public interface c {
        String Hh();

        boolean Hi();

        void fM(int i);
    }

    static /* synthetic */ void d(Map map, String str) {
        if (map.size() != 0 && !t.kS(str)) {
            Iterator it = map.values().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    an anVar = (an) it.next();
                    if (anVar != null && str.equals(anVar.field_fromUserName)) {
                        ak.yW();
                        if (com.tencent.mm.model.c.wJ().S(str, anVar.field_originSvrId).field_msgId != 0) {
                            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", Long.valueOf(com.tencent.mm.model.c.wJ().S(str, anVar.field_originSvrId).field_msgId), Long.valueOf(com.tencent.mm.model.c.wJ().S(str, anVar.field_originSvrId).field_msgSvrId));
                            bm bmVar = new bm();
                            bmVar.mcb = anVar.field_newMsgId;
                            bmVar.mbU = m.lY(anVar.field_fromUserName);
                            bmVar.mbV = m.lY(anVar.field_toUserName);
                            bmVar.hNS = (int) anVar.field_createTime;
                            bmVar.mbW = m.lY(anVar.field_content);
                            bmVar.mbZ = anVar.field_msgSource;
                            bmVar.mcc = anVar.field_msgSeq;
                            int i = anVar.field_flag;
                            bmVar.gll = CdnLogic.MediaType_FAVORITE_VIDEO;
                            com.tencent.mm.plugin.report.b.itm.a(403, 35, 1, false);
                            ak.yU().b(new com.tencent.mm.v.d.a(bmVar, (i & 2) != 0, (i & 1) != 0, (i & 4) != 0));
                        }
                    }
                }
            }
        }
    }

    b() {
    }

    public final void a(String str, i iVar) {
        if (!t.kS(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                com.tencent.mm.sdk.h.c anVar = new an();
                anVar.field_originSvrId = longValue;
                if (ak.yW().xx().b(anVar, new String[0])) {
                    this.cQH.put(Long.valueOf(longValue), anVar);
                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange put info systemRowid[%d], svrId[%d]", Long.valueOf(anVar.nmb), Long.valueOf(longValue));
                    return;
                }
                this.cQH.remove(Long.valueOf(longValue));
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange remove info svrId[%d]", Long.valueOf(longValue));
            } catch (Throwable e) {
                v.a("MicroMsg.GetChatRoomMsgService", e, "summerbadcr onNotifyChange:", new Object[0]);
            }
        }
    }

    public final boolean a(a aVar, c cVar) {
        if (!b(aVar, cVar)) {
            return false;
        }
        this.cKi.ea(0);
        return true;
    }

    public final boolean a(a aVar) {
        if (aVar.cQM != 0) {
            return false;
        }
        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr clearChatRoomMsg info:%s, stack[%s]", aVar, t.Nm());
        if (!this.cQF.add(aVar)) {
            return false;
        }
        this.cKi.ea(0);
        return true;
    }

    private boolean b(a aVar, c cVar) {
        if (aVar == null || cVar == null || t.kS(aVar.cQK) || !aVar.cQK.equals(cVar.Hh())) {
            return false;
        }
        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg info:%s", aVar);
        synchronized (this.cQE) {
            LinkedList linkedList = (LinkedList) this.cQE.get(aVar.cQK);
            if (linkedList == null) {
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg new infos and add ret:%b, infos[%d], needGetInfosMap[%s]", Boolean.valueOf(linkedList.add(aVar)), Integer.valueOf(new LinkedList().hashCode()), this.cQE);
                this.cQE.put(aVar.cQK, linkedList);
            } else {
                linkedList.addLast(aVar);
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg to infos first:%b, infos[%d], needGetInfosMap[%s]", Boolean.valueOf(false), Integer.valueOf(linkedList.hashCode()), this.cQE);
            }
            this.cQG = cVar;
        }
        return true;
    }
}
