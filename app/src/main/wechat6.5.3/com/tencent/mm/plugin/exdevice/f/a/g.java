package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.bl;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g extends a<bk, bl> {
    List<String> efQ;
    private final WeakReference<b<g>> fru;
    public ArrayList<qs> fwe;

    protected final /* synthetic */ void a(com.tencent.mm.ba.a aVar) {
        bk bkVar = (bk) aVar;
        for (String add : this.efQ) {
            bkVar.cTe.add(add);
        }
    }

    protected final /* synthetic */ com.tencent.mm.ba.a ain() {
        return new bk();
    }

    protected final /* synthetic */ com.tencent.mm.ba.a aio() {
        return new bl();
    }

    public g(List<String> list, b<g> bVar) {
        this.efQ = list;
        this.fru = new WeakReference(bVar);
    }

    public final int getType() {
        return 1777;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bl blVar = (bl) Ud();
            this.fwe = new ArrayList();
            if (blVar.mbS != null) {
                Iterator it = blVar.mbS.iterator();
                while (it.hasNext()) {
                    v.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[]{Integer.valueOf(r1.index), Integer.valueOf(r1.eWn), ((qs) it.next()).username});
                    this.fwe.add(r1);
                }
                v.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[]{this.fwe.toString(), Integer.valueOf(blVar.mbS.size())});
            }
            ac.ajs().a(this.fwe, "hardcode_rank_id", "hardcode_app_name");
        }
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.fru.get();
        if (bVar != null) {
            bVar.c(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/addfollow";
    }
}
