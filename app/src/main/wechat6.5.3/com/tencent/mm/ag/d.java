package com.tencent.mm.ag;

import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agg;
import com.tencent.mm.protocal.c.agj;
import com.tencent.mm.protocal.c.agk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements j {
    private final b cQA;
    private int cQp = 0;
    private e cii;

    public d(int i, int i2) {
        v.d("MicroMsg.NetSceneListLinkedInFriend", "newInstance, scene:%d, nextPos:%d", Integer.valueOf(i), Integer.valueOf(i2));
        a aVar = new a();
        aVar.czn = new agj();
        aVar.czo = new agk();
        aVar.uri = "/cgi-bin/micromsg-bin/listlinkedinfriend";
        aVar.czm = 676;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        agj com_tencent_mm_protocal_c_agj = (agj) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_agj.scene = i;
        com_tencent_mm_protocal_c_agj.mFX = i2;
        this.cQp = i2;
    }

    public final int getType() {
        return 676;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneListLinkedInFriend", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneListLinkedInFriend", "[oneliang][NetSceneListLinkedInFriend][onGYNetEnd]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            List<agg> list = ((agk) this.cQA.czl.czs).mGa;
            String str2 = "MicroMsg.NetSceneListLinkedInFriend";
            String str3 = "[oneliang][NetSceneListLinkedInFriend][onGYNetEnd]:net end ok,friend list size:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            v.d(str2, str3, objArr);
            if (list != null) {
                if (this.cQp == 0) {
                    ah.FU().clear();
                }
                String xF = com.tencent.mm.model.k.xF();
                List linkedList = new LinkedList();
                for (agg com_tencent_mm_protocal_c_agg : list) {
                    s sVar = new s();
                    sVar.field_wechatId = xF;
                    sVar.field_linkedInId = com_tencent_mm_protocal_c_agg.mEm;
                    sVar.field_name = com_tencent_mm_protocal_c_agg.name;
                    sVar.field_position = com_tencent_mm_protocal_c_agg.dCJ;
                    sVar.field_picUrl = com_tencent_mm_protocal_c_agg.mFR;
                    sVar.field_wechatUsername = com_tencent_mm_protocal_c_agg.mFS;
                    sVar.field_wechatSmallHead = com_tencent_mm_protocal_c_agg.mFT;
                    sVar.field_wechatBigHead = com_tencent_mm_protocal_c_agg.mFU;
                    sVar.field_linkedInProfileUrl = com_tencent_mm_protocal_c_agg.mFV;
                    sVar.field_nickname = com_tencent_mm_protocal_c_agg.cID;
                    if (be.kS(sVar.field_wechatUsername)) {
                        sVar.field_status = 2;
                    } else if (sVar.field_wechatUsername.endsWith("@stranger")) {
                        sVar.field_status = 1;
                    } else {
                        sVar.field_status = 3;
                    }
                    linkedList.add(sVar);
                }
                Collections.sort(linkedList, new Comparator<s>(this) {
                    final /* synthetic */ d cQB;

                    {
                        this.cQB = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((s) obj).field_status - ((s) obj2).field_status;
                    }
                });
                ah.FU().G(linkedList);
            }
            v.d("MicroMsg.NetSceneListLinkedInFriend", "onSceneEnd, done!!");
        }
        this.cii.a(i2, i3, str, this);
    }

    public final boolean hasNext() {
        return ((agk) this.cQA.czl.czs).mFY == 1;
    }

    public final int Hg() {
        return ((agk) this.cQA.czl.czs).mFZ;
    }
}
