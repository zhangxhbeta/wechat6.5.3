package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k extends a<aav, aaw> {
    private final WeakReference<b<k>> fru;
    public List<String> fwC;
    public List<String> fwD;
    public List<String> fwE;

    protected final /* bridge */ /* synthetic */ void a(com.tencent.mm.ba.a aVar) {
    }

    protected final /* synthetic */ com.tencent.mm.ba.a ain() {
        return new aav();
    }

    protected final /* synthetic */ com.tencent.mm.ba.a aio() {
        return new aaw();
    }

    public k(b<k> bVar) {
        this.fru = new WeakReference(bVar);
    }

    public final int getType() {
        return 1758;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            aaw com_tencent_mm_protocal_c_aaw = (aaw) Ud();
            this.fwE = new ArrayList();
            Iterator it = com_tencent_mm_protocal_c_aaw.mCn.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                ak.yW();
                if (c.wH().LT(str2)) {
                    this.fwE.add(str2);
                }
            }
            this.fwC = new ArrayList();
            this.fwD = new ArrayList();
            if (com_tencent_mm_protocal_c_aaw.mCo != null) {
                Iterator it2 = com_tencent_mm_protocal_c_aaw.mCo.iterator();
                while (it2.hasNext()) {
                    qu quVar = (qu) it2.next();
                    if (quVar.muF) {
                        this.fwD.add(quVar.username);
                    }
                    ak.yW();
                    if (c.wH().LT(quVar.username)) {
                        this.fwC.add(quVar.username);
                    }
                }
            }
            v.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[]{Integer.valueOf(this.fwD.size()), this.fwD.toString()});
            v.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[]{Integer.valueOf(this.fwC.size()), this.fwC});
        }
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.fru.get();
        if (bVar != null) {
            v.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
            bVar.c(i2, i3, str, this);
            return;
        }
        v.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }
}
