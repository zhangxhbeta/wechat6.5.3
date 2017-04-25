package com.tencent.mm.plugin.chatroom.c;

import android.util.Pair;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class i extends k implements j {
    private final String biB;
    private final b cif;
    private e cii = null;

    public i(String str, int i) {
        int i2;
        a aVar = new a();
        aVar.czn = new uw();
        aVar.czo = new ux();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        aVar.czm = 551;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.biB = str;
        int bvc = ak.yW().wO().LD(str).bvc();
        ((uw) this.cif.czk.czs).mxB = str;
        uw uwVar = (uw) this.cif.czk.czs;
        if (bvc < i) {
            i2 = i;
        } else {
            i2 = bvc;
        }
        uwVar.mfB = i2;
        v.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(bvc), be.bur()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 551;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
            ux uxVar = (ux) this.cif.czl.czs;
            o LD = ak.yW().wO().LD(this.biB);
            long bvc = (long) LD.bvc();
            long j = 4294967295L & ((long) uxVar.eeq);
            String str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str3 = "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(uxVar.eeq);
            objArr[1] = Integer.valueOf(uxVar.mxC == null ? 0 : uxVar.mxC.eOX);
            objArr[2] = Long.valueOf(bvc);
            v.i(str2, str3, objArr);
            if (bvc >= j) {
                v.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[]{Long.valueOf(bvc), Long.valueOf(j)});
                this.cii.a(i2, i3, str, this);
                return;
            }
            int i4 = uxVar.eeq;
            if (LD.b(LD.nnW)) {
                LD.bvb();
            }
            LD.nnW.biE = i4;
            try {
                LD.field_roomdata = LD.nnW.toByteArray();
            } catch (Throwable e) {
                v.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[]{be.e(e)});
            }
            o.bve();
            String xF = com.tencent.mm.model.k.xF();
            List<jp> list = uxVar.mxC.mlV;
            if (LD.b(LD.nnW)) {
                LD.bvb();
            }
            for (jp jpVar : list) {
                if (LD.cDH.containsKey(jpVar.gln)) {
                    com.tencent.mm.g.a.a.b bVar = (com.tencent.mm.g.a.a.b) LD.cDH.get(jpVar.gln);
                    bVar.caJ = jpVar.mlX;
                    bVar.caK = jpVar.mma;
                    bVar.caL = jpVar.mmb;
                }
            }
            LD.nnW.caF.clear();
            for (String str4 : LD.cDH.keySet()) {
                LD.nnW.caF.add(LD.cDH.get(str4));
            }
            LD.a(xF, LD.nnW, false);
            ak.yW().wO().b(LD);
            ak.yW();
            final aa wH = c.wH();
            final com.tencent.mm.u.i Bo = n.Bo();
            final LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            list = uxVar.mxC.mlV;
            str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str5 = "summerChatRoom memInfoList size[%d]";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(list == null ? -1 : list.size());
            v.i(str2, str5, objArr2);
            for (jp jpVar2 : list) {
                if (!(be.kS(jpVar2.mlZ) || be.kS(jpVar2.gln))) {
                    h gQ = Bo.gQ(jpVar2.gln);
                    if (gQ == null) {
                        gQ = new h();
                        gQ.username = jpVar2.gln;
                    } else {
                        gQ.Bf().equals(jpVar2.mlZ);
                    }
                    gQ.cyD = jpVar2.mlY;
                    gQ.cyC = jpVar2.mlZ;
                    gQ.bBY = 3;
                    gQ.aP(!be.kS(jpVar2.mlY));
                    linkedList2.add(gQ);
                }
                u LX = wH.LX(jpVar2.gln);
                if (LX == null) {
                    v.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (LX.tJ()) {
                    LX.bS(jpVar2.efy);
                    linkedList.add(new Pair(jpVar2.gln, LX));
                }
            }
            v.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList.size())});
            if (!linkedList2.isEmpty()) {
                new ah(ak.vA().htb.getLooper(), new ah.a(this) {
                    final /* synthetic */ i eOU;

                    public final boolean oU() {
                        int size = linkedList2.size() < 25 ? linkedList2.size() : 25;
                        v.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            v.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
                            return false;
                        } else if (linkedList2.isEmpty()) {
                            v.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ak.yW();
                            long er = c.wE().er(Thread.currentThread().getId());
                            for (int i = 0; i < size; i++) {
                                Bo.a((h) linkedList2.poll());
                            }
                            ak.yW();
                            c.wE().es(er);
                            v.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (!linkedList2.isEmpty()) {
                                return true;
                            }
                            v.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        }
                    }
                }, true).ea(100);
            }
            if (!linkedList.isEmpty()) {
                new ah(ak.vA().htb.getLooper(), new ah.a(this) {
                    final /* synthetic */ i eOU;

                    public final boolean oU() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        v.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            v.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        ak.yW();
                        long er = c.wE().er(Thread.currentThread().getId());
                        for (int i = 0; i < size; i++) {
                            Pair pair = (Pair) linkedList.poll();
                            wH.a((String) pair.first, (u) pair.second);
                        }
                        ak.yW();
                        c.wE().es(er);
                        v.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (!linkedList.isEmpty()) {
                            return true;
                        }
                        v.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
                        return false;
                    }
                }, true).ea(100);
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }
}
