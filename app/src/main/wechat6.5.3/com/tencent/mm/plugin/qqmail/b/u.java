package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.qqmail.b.w.e;
import com.tencent.mm.plugin.qqmail.b.w.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class u {
    ArrayList<v> ibE = new ArrayList();
    w ibF = x.aHH();
    t ibG = null;
    boolean ibH = false;
    f ibI = new f(this) {
        final /* synthetic */ u ibK;

        {
            this.ibK = r1;
        }

        public final void C(String str, int i, int i2) {
            if (i == i2) {
                v.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[]{Integer.valueOf(this.ibK.ibE.size())});
                if (this.ibK.ibG != null) {
                    this.ibK.ibG.yd(str);
                }
                if (this.ibK.ibE.size() > 0) {
                    v.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                    this.ibK.b((v) this.ibK.ibE.remove(0));
                    this.ibK.ibF.a((f) this, this.ibK.ibJ);
                    return;
                }
                v.i("MicroMsg.ShareMailQueue", "finished sent all mails");
                this.ibK.ibH = false;
            }
        }
    };
    e ibJ = new e(this) {
        final /* synthetic */ u ibK;

        {
            this.ibK = r1;
        }

        public final void yf(String str) {
            if (this.ibK.ibG != null) {
                t tVar = this.ibK.ibG;
                if (be.kS(str)) {
                    v.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
                } else {
                    t.ye(str);
                    tVar.yd(str);
                }
            }
            if (this.ibK.ibE.size() > 0) {
                v.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                this.ibK.b((v) this.ibK.ibE.remove(0));
                this.ibK.ibF.a(this.ibK.ibI, (e) this);
                return;
            }
            v.i("MicroMsg.ShareMailQueue", "final job fail");
            this.ibK.ibH = false;
        }
    };

    public final void a(v vVar) {
        if (ak.uz()) {
            if (this.ibG == null) {
                this.ibG = new t();
            }
            t tVar = this.ibG;
            String str = vVar.iav;
            if (be.kS(str)) {
                v.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
            } else {
                r rVar = new r();
                rVar.iav = str;
                tVar.ibD.hjx.add(rVar);
                tVar.save();
            }
            this.ibE.add(vVar);
            v.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[]{Integer.valueOf(this.ibE.size())});
            if (!this.ibH) {
                v.d("MicroMsg.ShareMailQueue", "start execute");
                if (this.ibE.size() > 0) {
                    this.ibH = true;
                    b((v) this.ibE.remove(0));
                    this.ibF.a(this.ibI, this.ibJ);
                }
            }
        }
    }

    final void b(v vVar) {
        w wVar = this.ibF;
        wVar.ibU.clear();
        wVar.iba = null;
        wVar.ibW = 0;
        wVar.ibY = null;
        wVar.ibZ = null;
        wVar.ica.clear();
        wVar.ibX.clear();
        wVar.bhM = null;
        wVar.ibT.clear();
        wVar.ibM.clear();
        wVar.ibL = null;
        wVar.iav = null;
        wVar.icd = 0;
        wVar.iaY = null;
        wVar.ibN.clear();
        wVar.ibR.clear();
        wVar.ibV.clear();
        wVar.ibS = null;
        wVar.ibJ = null;
        this.ibF.bhM = vVar.bhM;
        this.ibF.iav = vVar.iav;
        this.ibF.iaY = vVar.iaY;
        this.ibF.iaZ = vVar.iaZ;
        this.ibF.ibL = vVar.ibL;
        wVar = this.ibF;
        Map map = vVar.ibM;
        wVar.ibM = new HashMap();
        wVar.ibM.putAll(map);
        wVar = this.ibF;
        map = vVar.ibN;
        wVar.ibN = new LinkedHashMap();
        wVar.ibN.putAll(map);
        wVar = this.ibF;
        map = vVar.ibO;
        wVar.ibO = new LinkedHashMap();
        wVar.ibO.putAll(map);
    }
}
