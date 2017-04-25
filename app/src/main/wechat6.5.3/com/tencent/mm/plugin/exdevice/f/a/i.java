package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.protocal.c.aaa;
import com.tencent.mm.protocal.c.aab;
import com.tencent.mm.protocal.c.ayh;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends a<aaa, aab> {
    public String aHM;
    public String appName;
    private final WeakReference<b<i>> fru;
    public String fwf;
    public String fwg;
    public String fwh;
    public String fwi;
    public List<ayh> fwj;
    public List<bjq> fwk;
    public bjp fwl;
    public ArrayList<String> fwm;
    public List<qs> fwn;
    public List<ig> fwo;
    public boolean fwp;
    public String username;

    protected final /* bridge */ /* synthetic */ void a(com.tencent.mm.ba.a aVar) {
        aaa com_tencent_mm_protocal_c_aaa = (aaa) aVar;
        com_tencent_mm_protocal_c_aaa.fDn = this.appName;
        com_tencent_mm_protocal_c_aaa.username = this.username;
    }

    protected final /* synthetic */ com.tencent.mm.ba.a ain() {
        return new aaa();
    }

    protected final /* synthetic */ com.tencent.mm.ba.a aio() {
        return new aab();
    }

    public i(String str, String str2, b<i> bVar) {
        v.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[]{str2, str});
        this.username = str;
        this.appName = str2;
        this.fru = new WeakReference(bVar);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
        v.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            aab com_tencent_mm_protocal_c_aab = (aab) Ud();
            this.fwf = com_tencent_mm_protocal_c_aab.mBv;
            this.fwg = com_tencent_mm_protocal_c_aab.fwg;
            this.fwk = com_tencent_mm_protocal_c_aab.mBy;
            this.fwl = com_tencent_mm_protocal_c_aab.mBw;
            this.fwh = com_tencent_mm_protocal_c_aab.mBA;
            this.aHM = com_tencent_mm_protocal_c_aab.aHM;
            this.fwi = com_tencent_mm_protocal_c_aab.mBB;
            this.fwj = com_tencent_mm_protocal_c_aab.mcq;
            this.fwp = com_tencent_mm_protocal_c_aab.fwp;
            this.fwn = com_tencent_mm_protocal_c_aab.mbS;
            this.fwo = com_tencent_mm_protocal_c_aab.mBC;
            this.fwm = new ArrayList();
            if (com_tencent_mm_protocal_c_aab.mBz != null) {
                this.fwm.addAll(com_tencent_mm_protocal_c_aab.mBz);
            }
            this.fwj = new LinkedList();
            if (com_tencent_mm_protocal_c_aab.mcq != null) {
                this.fwj.addAll(com_tencent_mm_protocal_c_aab.mcq);
            }
            if (!(this.username == null || this.username.equalsIgnoreCase(k.xF()))) {
                if (this.fwp) {
                    com.tencent.mm.plugin.exdevice.f.b.b.a ajs = ac.ajs();
                    String str2 = this.username;
                    if (ajs.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        c cVar = new c();
                        cVar.field_rankID = "hardcode_rank_id";
                        cVar.field_appusername = "hardcode_app_name";
                        cVar.field_username = str2;
                        cVar.field_step = 0;
                        ajs.b(cVar);
                    }
                } else {
                    ac.ajs().sl(this.username);
                }
            }
            if (com_tencent_mm_protocal_c_aab.mbS != null) {
                List arrayList = new ArrayList();
                Iterator it = com_tencent_mm_protocal_c_aab.mbS.iterator();
                while (it.hasNext()) {
                    qs qsVar = (qs) it.next();
                    ak.yW();
                    if (com.tencent.mm.model.c.wH().LT(qsVar.username)) {
                        c cVar2 = new c();
                        cVar2.field_username = qsVar.username;
                        cVar2.field_step = qsVar.eWn;
                        arrayList.add(cVar2);
                    } else {
                        ak.vy().a(new h(qsVar.username, null), 0);
                    }
                }
                v.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[]{Integer.valueOf(arrayList.size()), arrayList.toString()});
                if (k.xF().equalsIgnoreCase(this.username)) {
                    ac.ajs().ao(arrayList);
                }
            }
            this.fwo = new ArrayList();
            if (com_tencent_mm_protocal_c_aab.mBC != null) {
                this.fwo.addAll(com_tencent_mm_protocal_c_aab.mBC);
            }
            this.fwp = com_tencent_mm_protocal_c_aab.fwp;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championMotto = this.fwg;
            aVar.field_championUrl = this.fwf;
            aVar.field_username = this.username;
            LinkedList linkedList = com_tencent_mm_protocal_c_aab.mcq;
            ac.aju().a(aVar, true);
        }
        b bVar = (b) this.fru.get();
        if (bVar != null) {
            bVar.c(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    public final int getType() {
        return 1043;
    }
}
