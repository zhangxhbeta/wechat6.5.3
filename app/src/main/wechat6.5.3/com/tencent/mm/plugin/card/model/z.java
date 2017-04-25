package com.tencent.mm.plugin.card.model;

import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.protocal.c.ul;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class z extends k implements j {
    private final b cif;
    private e cii;
    public boolean eDD = false;

    public z(double d, double d2, int i) {
        a aVar = new a();
        aVar.czn = new ul();
        aVar.czo = new um();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardslayout";
        aVar.czm = 984;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ul ulVar = (ul) this.cif.czk.czs;
        ulVar.latitude = d;
        ulVar.longitude = d2;
        ulVar.scene = i;
        ak.yW();
        ulVar.mxe = (String) c.vf().get(t.a.npC, null);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardsLayout", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        um umVar = (um) this.cif.czl.czs;
        v.v("MicroMsg.NetSceneGetCardsLayout", "json:" + umVar.eDn);
        if (i2 == 0 && i3 == 0) {
            boolean z;
            ak.yW();
            c.vf().a(t.a.npC, umVar.mxe);
            String str2 = umVar.eDn;
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            String str3 = (String) c.vf().get(t.a.npB, null);
            if (!be.kS(str3)) {
                str2 = str3;
            }
            up qt = h.qt(str2);
            af.aak().cie.dF("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0");
            if (qt == null) {
                v.w("MicroMsg.CardStickyHelper", "[doUpdateStickyInfoLogic] resp null");
                z = false;
            } else {
                int i4;
                if (qt.mxh != null) {
                    jj jjVar = qt.mxh;
                    Map hashMap = new HashMap();
                    hashMap.put("expiring_list", Integer.valueOf(2));
                    hashMap.put("member_card_list", Integer.valueOf(2));
                    hashMap.put("nearby_list", Integer.valueOf(3));
                    if (qt.mxk == 100) {
                        hashMap.put("expiring_list", Integer.valueOf(4));
                    } else if (qt.mxk == 102) {
                        hashMap.put("member_card_list", Integer.valueOf(4));
                    } else if (qt.mxk == 101) {
                        hashMap.put("nearby_list", Integer.valueOf(4));
                    }
                    ak.yW();
                    long er = c.wE().er(Thread.currentThread().getId());
                    if (qt.mxh.mlE == null || qt.mxh.mlE.mlD == null || qt.mxh.mlE.mlD.size() <= 0) {
                        z = false;
                        i4 = 0;
                    } else {
                        h.a(qt.mxh.mlE.mlD, (((Integer) hashMap.get("expiring_list")).intValue() * 100000) + 3);
                        z = true;
                        i4 = qt.mxh.mlE.mlD.size() + 0;
                    }
                    if (!(qt.mxh.mlF == null || qt.mxh.mlF.mlD == null || qt.mxh.mlF.mlD.size() <= 0)) {
                        h.a(qt.mxh.mlF.mlD, (((Integer) hashMap.get("member_card_list")).intValue() * 100000) + 2);
                        i4 += qt.mxh.mlF.mlD.size();
                        z = true;
                    }
                    if (!(qt.mxh.mlG == null || qt.mxh.mlG.mlD == null || qt.mxh.mlG.mlD.size() <= 0)) {
                        h.a(qt.mxh.mlG.mlD, (((Integer) hashMap.get("nearby_list")).intValue() * 100000) + 1);
                        i4 += qt.mxh.mlG.mlD.size();
                        z = true;
                    }
                    ak.yW();
                    c.wE().es(er);
                } else {
                    z = false;
                    i4 = 0;
                }
                af.aap().putValue("key_get_card_layout_resp", qt);
                ak.yW();
                c.vf().a(t.a.npK, str2);
                if (i4 > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(36);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(37);
                    iDKey2.SetValue((int) (currentTimeMillis2 - currentTimeMillis));
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(38);
                    iDKey3.SetValue(i4);
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(40);
                    iDKey4.SetValue(((int) (currentTimeMillis2 - currentTimeMillis)) / i4);
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g gVar = g.iuh;
                    g.d(arrayList, true);
                }
            }
            this.eDD = z;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 984;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
