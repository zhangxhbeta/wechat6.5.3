package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.ed;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class a extends c<ed> {
    public a() {
        this.nhz = ed.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ed edVar = (ed) bVar;
        if (!(edVar instanceof ed)) {
            v.f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            return false;
        } else if (edVar.bci.bck == null) {
            return false;
        } else {
            k kVar = new k();
            kVar.b(edVar.bci.bck);
            if (kVar.jBI <= 0) {
                v.e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                return false;
            }
            azr aUp = kVar.aUp();
            edVar.bcj.bcp = 0;
            edVar.bcj.bct = 0;
            edVar.bcj.bcu = 0;
            edVar.bcj.bcr = new LinkedList();
            edVar.bcj.bcs = new LinkedList();
            if (aUp.mWq != null) {
                edVar.bcj.bcp = aUp.mWq.mol;
                if (aUp.mWq.mol != 1 && aUp.mWq.mol != 7 && aUp.mWq.mol != 8) {
                    edVar.bcj.bcr.add(aUp.mWq.glb);
                } else if (aUp.mWq.mom != null) {
                    int i = 0;
                    while (i < aUp.mWq.mom.size()) {
                        List list = edVar.bcj.bcr;
                        ad.aSB();
                        list.add(g.t((aib) aUp.mWq.mom.get(i)));
                        list = edVar.bcj.bcs;
                        ad.aSB();
                        list.add(g.u((aib) aUp.mWq.mom.get(i)));
                        if (i == 0 && aUp.mWq.mom.get(i) != null) {
                            edVar.bcj.bct = (int) ((aib) aUp.mWq.mom.get(i)).mHS.mID;
                            edVar.bcj.bcu = (int) ((aib) aUp.mWq.mom.get(i)).mHS.lHK;
                        }
                        i++;
                    }
                }
            }
            edVar.bcj.bcq = edVar.bcj.bcr.size();
            edVar.bcj.bcm = kVar.jBI;
            edVar.bcj.bcl = kVar.field_userName;
            edVar.bcj.bcn = aUp.mWn;
            edVar.bcj.bco = (long) aUp.hNS;
            return true;
        }
    }
}
