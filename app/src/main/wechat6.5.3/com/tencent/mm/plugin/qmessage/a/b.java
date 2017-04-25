package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.pa;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b extends k implements j {
    private e cii;
    private Set<String> hZF;

    public b(Set<String> set) {
        Assert.assertTrue(true);
        this.hZF = set;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        List<String> linkedList = new LinkedList();
        for (String add : this.hZF) {
            linkedList.add(add);
        }
        if (linkedList.size() == 0) {
            v.e("MicroMsg.NetSceneBatchGetContactProfile", g.sm() + "doScene reqSize ==0");
            return -1;
        }
        a aVar = new a();
        aVar.czn = new fd();
        aVar.czo = new fe();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        aVar.czm = c.CTRL_INDEX;
        aVar.czp = 28;
        aVar.czq = 1000000028;
        com.tencent.mm.v.b Bv = aVar.Bv();
        LinkedList linkedList2 = new LinkedList();
        for (String add2 : linkedList) {
            linkedList2.add(m.lY(add2));
        }
        ((fd) Bv.czk.czs).mfO = linkedList2;
        ((fd) Bv.czk.czs).mfN = 1;
        ((fd) Bv.czk.czs).eet = linkedList2.size();
        return a(eVar, Bv, this);
    }

    protected final int a(p pVar) {
        return com.tencent.mm.v.k.b.czU;
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    protected final int ul() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            if (f(pVar) && this.hZF.size() > 0) {
                a(this.czE, this.cii);
            }
            v.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.hZF.size());
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    private boolean f(p pVar) {
        fe feVar = (fe) ((com.tencent.mm.v.b) pVar).czl.czs;
        if (feVar == null) {
            v.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            return false;
        } else if (pVar.ze().lWU == 1) {
            v.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            return false;
        } else if (pVar.ze().lWU == -1) {
            v.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            return true;
        } else {
            List list = feVar.mfP;
            if (list == null) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                ll llVar;
                boolean z;
                try {
                    llVar = (ll) new ll().az(m.a((are) list.get(i)));
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneBatchGetContactProfile", e, "", new Object[0]);
                    v.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    llVar = null;
                }
                if (llVar == null || llVar.gln == null) {
                    v.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (this.hZF.contains(llVar.gln)) {
                    this.hZF.remove(llVar.gln);
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(llVar.gln);
                    if (LX == null || ((int) LX.chr) == 0) {
                        v.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        LX.setUsername(llVar.gln);
                        LX.bP(llVar.cHh);
                        LX.setType(llVar.mnV & llVar.mnW);
                        LX.bS(llVar.efy);
                        LX.bT(llVar.mnT);
                        LX.bU(llVar.mnU);
                        LX.cV(llVar.cHc);
                        LX.bQ(llVar.mnX);
                        LX.bW(llVar.moa);
                        LX.bX(llVar.mnZ);
                        LX.cY(llVar.mob);
                        LX.bR(llVar.moe);
                        LX.cZ(llVar.mof);
                        ak.yW();
                        if (com.tencent.mm.model.c.wH().a(LX.field_username, LX) == -1) {
                            v.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (u.LJ(llVar.gln)) {
                            d xU = g.aHl().xU(llVar.gln);
                            if (xU == null || be.ma(xU.getUsername()).length() <= 0) {
                                v.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                xU.extInfo = llVar.gor;
                                xU.hZI = (long) llVar.moh;
                                xU.hZJ = (long) llVar.moi;
                                xU.bkU = 52;
                                if (!g.aHl().a(llVar.gln, xU)) {
                                    v.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (u.LH(llVar.gln)) {
                            pa paVar = new pa();
                            paVar.bqm.opType = 0;
                            paVar.bqm.ble = llVar.gln;
                            paVar.bqm.blf = llVar.moh;
                            paVar.bqm.blg = llVar.mnY;
                            com.tencent.mm.sdk.c.a.nhr.z(paVar);
                        }
                        z = true;
                    }
                } else {
                    v.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
    }
}
