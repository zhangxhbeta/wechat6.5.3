package com.tencent.mm.o;

import android.os.Looper;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    private b cif;
    private wc cig;
    wd cih;
    e cii = null;
    d cij;
    private String cik = null;
    private ac handler = new ac(Looper.getMainLooper());
    private int retryCount = 0;

    public g(d dVar) {
        if (dVar != null) {
            this.cij = dVar;
            v.d("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", dVar.field_cgi, Integer.valueOf(dVar.field_cmdid), dVar.field_functionmsgid);
            a aVar = new a();
            aVar.czn = new wc();
            aVar.czo = new wd();
            aVar.czm = 825;
            aVar.uri = dVar.field_cgi;
            aVar.czp = dVar.field_cmdid;
            aVar.czq = 0;
            this.cif = aVar.Bv();
            this.cig = (wc) this.cif.czk.czs;
            this.cig.myD = dVar.field_functionmsgid;
            if (dVar.field_custombuff != null) {
                this.cig.myE = dVar.field_custombuff;
            }
        }
    }

    public final int getType() {
        return 825;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.cij != null) {
            v.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", this.cij.field_functionmsgid);
            this.cij.field_status = 1;
        }
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    protected final int ul() {
        return 6;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cih = (wd) ((b) pVar).czl.czs;
        this.cik = this.cih.myE;
        v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.cih.lZm), Boolean.valueOf(be.kS(this.cik)), Long.valueOf(this.cih.myF));
        if (!be.kS(this.cik)) {
            this.cig = (wc) this.cif.czk.czs;
            this.cig.myE = this.cik;
        }
        if (i2 == 0 || i3 == 0) {
            com.tencent.mm.plugin.report.service.g.iuh.a((long) this.cij.field_reportid, (long) this.cij.field_successkey, 1, false);
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 4) {
            v.i("MicroMsg.NetSceneGetFuncMsg", "server error");
            if (this.cih.lZm != 1) {
                um();
                return;
            }
            v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, stop retry, directly return");
            this.cii.a(i2, i3, str, this);
        } else {
            v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
            com.tencent.mm.plugin.report.service.g.iuh.a((long) this.cij.field_reportid, (long) this.cij.field_failkey, 1, false);
            if (this.retryCount < 2) {
                v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, retry, retryCount: %s", Integer.valueOf(this.retryCount));
                this.retryCount++;
                um();
                return;
            }
            v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, reach retry limit, directly return");
            com.tencent.mm.plugin.report.service.g.iuh.a((long) this.cij.field_reportid, (long) this.cij.field_finalfailkey, 1, false);
            this.cii.a(i2, i3, str, this);
        }
    }

    private void um() {
        this.handler.postDelayed(new Runnable(this) {
            final /* synthetic */ g cil;

            {
                this.cil = r1;
            }

            public final void run() {
                v.i("MicroMsg.NetSceneGetFuncMsg", "do retry");
                if (this.cil.a(this.cil.czE, this.cil.cii) == -1) {
                    this.cil.cii.a(3, -1, "doScene failed", this.cil);
                }
            }
        }, (long) (this.cij.field_retryinterval * 1000));
    }
}
