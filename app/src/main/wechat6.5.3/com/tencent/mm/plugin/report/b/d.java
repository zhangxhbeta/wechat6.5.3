package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.smtt.utils.TbsLog;

public final class d extends k implements j {
    int bkh = 0;
    private b cif;
    private e cii;
    private boolean itx = false;
    private ku ity = null;

    public d(byte[] bArr, int i) {
        boolean z = false;
        if (bArr == null) {
            throw new NullPointerException("data must not be null");
        }
        this.bkh = i;
        if (ak.uz() && !be.bl(ak.uT())) {
            z = true;
        }
        this.itx = z;
        if (i == 1) {
            try {
                i iVar = new i();
                iVar.az(bArr);
                this.ity = SmcProtoBufUtil.toMMReportKvReq(iVar);
            } catch (Exception e) {
                v.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ d itz;

                    {
                        this.itz = r1;
                    }

                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, this.itz.bkh);
                    }
                });
            }
        } else if (i == 2) {
            try {
                g gVar = new g();
                gVar.az(bArr);
                this.ity = SmcProtoBufUtil.toMMReportIdkeyReq(gVar);
            } catch (Exception e2) {
                v.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ d itz;

                    {
                        this.itz = r1;
                    }

                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, this.itz.bkh);
                    }
                });
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (ak.vy() == null || ak.vy().cAa == null) {
            v.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.cii.a(i2, i3, str, this);
        } else if (i2 != 0) {
            v.e("MicroMsg.NetSceneCliReportKV", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnReportResp(i2, i3, null, this.bkh);
            this.cii.a(i2, i3, str, this);
        } else {
            v.d("MicroMsg.NetSceneCliReportKV", "get report strategy ok");
            kv kvVar = (kv) this.cif.czl.czs;
            try {
                if (this.bkh == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(kvVar).toByteArray(), this.bkh);
                } else if (this.bkh == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(kvVar).toByteArray(), this.bkh);
                }
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), be.e(e));
            }
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return !this.itx ? 1 == this.bkh ? TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR : 987 : 1 == this.bkh ? TbsLog.TBSLOG_CODE_SDK_SELF_MODE : 986;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (!this.itx) {
            this.ity.mnp = com.tencent.mm.ba.b.aT(be.buh());
        }
        a aVar = new a();
        aVar.czr = false;
        aVar.czn = this.ity;
        aVar.czo = new kv();
        String str = 1 == this.bkh ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.bkh ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.itx) {
            str = str2;
        }
        aVar.uri = str;
        aVar.czm = getType();
        this.cif = aVar.Bv();
        if (!this.itx) {
            this.cif.a(ad.brH());
            this.cif.brn = 1;
        }
        int a = a(eVar, this.cif, this);
        if (a < 0) {
            v.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnReportResp(3, -1, null, this.bkh);
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), be.e(e));
            }
        }
        return a;
    }
}
