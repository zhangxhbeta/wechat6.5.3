package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.plugin.scanner.b.k;
import com.tencent.mm.plugin.scanner.b.q;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class o extends i implements a, e {
    private int iAZ = 0;
    private int iBa = 2;
    private long iBb;
    private final int iBc = 184;
    private final int iBd = 46;
    private final int iBe = 276;
    private final int iBf = 70;
    private float iBk;
    private final int iBn = 50;
    com.tencent.mm.plugin.scanner.a.e iBs;
    private int iBt = 0;
    private TextView iBu;
    private TextView iBv;
    private final int iBw = 5000;
    private final int iBx = 8000;
    private ac iBy = new ac(this) {
        final /* synthetic */ o iBz;

        {
            this.iBz = r1;
        }

        public final void handleMessage(Message message) {
            if (this.iBz.iAZ >= this.iBz.iBa) {
                if (this.iBz.iBs != null) {
                    ak.vy().c(this.iBz.iBs);
                }
                o.c(this.iBz);
            }
        }
    };
    private int iwf;

    static /* synthetic */ int c(o oVar) {
        int i = oVar.iAZ - 1;
        oVar.iAZ = i;
        return i;
    }

    public o(b bVar, Point point) {
        super(bVar, point, (byte) 0);
        cj(184, 46);
        this.iBk = q.cm(276, this.iAI);
        v.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", new Object[]{Integer.valueOf(this.iAI), Integer.valueOf(this.iAJ), Float.valueOf(this.iBk)});
        this.iwf = (int) (System.currentTimeMillis() & -1);
    }

    protected final void g(Rect rect) {
        this.dMQ = (TextView) this.iAM.findViewById(2131758970);
        this.iBv = (TextView) this.iAM.findViewById(2131758974);
        this.iBu = (TextView) this.iAM.findViewById(2131758973);
        this.dMQ = (TextView) this.iAM.findViewById(2131758970);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.dMQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.iAM.aLx(), 13.0f);
            this.dMQ.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.iBu.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.iAM.aLx(), 13.0f);
            this.iBu.setLayoutParams(layoutParams);
            this.iBu.setVisibility(4);
        }
        if (c.rt()) {
            this.dMQ.setPadding(BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.dMQ.getPaddingTop(), BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.dMQ.getPaddingBottom());
            this.iBu.setPadding(BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.iBu.getPaddingTop(), BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.iBu.getPaddingBottom());
        }
        if (this.iAG != null) {
            ((k) this.iAG).hoe = this.iAM.aLt();
        }
        aLI();
        fj(true);
    }

    protected final void aLe() {
        g(new Rect(0, 0, 0, 0));
        this.iAM.b(4, null);
        this.iAM.h(1800, true);
        onResume();
    }

    protected final int aLc() {
        return 2130904298;
    }

    protected final com.tencent.mm.plugin.scanner.b.b aLb() {
        if (this.iAG == null) {
            int i = 50;
            if (p.ceA.ccU > 0) {
                i = p.ceA.ccU;
                v.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", new Object[]{Integer.valueOf(p.ceA.ccU)});
            }
            if (com.tencent.mm.sdk.platformtools.ak.is2G(this.iAM.aLx())) {
                this.iAG = new k(this, i - 10, this.iBk, true, this.iAM.aLt());
            } else {
                this.iAG = new k(this, i, this.iBk, true, this.iAM.aLt());
            }
        }
        return this.iAG;
    }

    protected final void aLa() {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            aLI();
        }
    }

    private void aLI() {
        if (this.iAM == null) {
            v.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
        } else if (ak.vy().BJ() == 6 || ak.vy().BJ() == 4) {
            this.iAM.h(1800, true);
        } else {
            this.iBu.setText("");
            this.iBv.setText("");
            this.iAM.fh(true);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            String str2 = "MicroMsg.scanner.ScanModeOCR";
            String str3 = "greyData null:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            v.w(str2, str3, objArr);
            if (System.currentTimeMillis() - this.iBb <= 1840 || !iCZ[1]) {
                this.iAM.cz(40);
            } else {
                this.iBb = System.currentTimeMillis();
                this.iAM.h(0, true);
            }
            this.iBt = 0;
        } else if (this.iAZ >= this.iBa) {
            if (System.currentTimeMillis() - this.iBb <= 1840 || !iCZ[1]) {
                this.iAM.cz(40);
            } else {
                this.iBb = System.currentTimeMillis();
                this.iAM.h(0, true);
            }
            v.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", new Object[]{Integer.valueOf(this.iAZ), Integer.valueOf(this.iBa)});
        } else {
            this.iBs = new com.tencent.mm.plugin.scanner.a.e(bArr, "en", "zh_CN", this.iwf);
            ak.vy().a(this.iBs, 0);
            this.iAZ++;
            this.iBy.removeMessages(0);
            if (com.tencent.mm.sdk.platformtools.ak.is2G(this.iAM.aLx())) {
                this.iBy.sendEmptyMessageDelayed(0, 8000);
            } else {
                this.iBy.sendEmptyMessageDelayed(0, 5000);
            }
            this.iAN += bArr.length;
            v.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", new Object[]{Integer.valueOf(this.iAN), Integer.valueOf(this.iBt), Integer.valueOf(this.iBa)});
            if (System.currentTimeMillis() - this.iBb <= 1840 || !iCZ[1]) {
                this.iAM.cz(40);
            } else {
                this.iBb = System.currentTimeMillis();
                this.iAM.h(0, true);
            }
            v.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.iAZ + "," + this.iBt);
        }
    }

    public final void aLh() {
        v.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (System.currentTimeMillis() - this.iBb <= 1840 || !iCZ[1]) {
            this.iAM.cz(40);
        } else {
            this.iBb = System.currentTimeMillis();
            this.iAM.h(0, true);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        this.iBy.removeMessages(0);
        switch (kVar.getType()) {
            case 392:
                this.iAZ--;
                if (i == 0 && i2 == 0) {
                    akl com_tencent_mm_protocal_c_akl;
                    v.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    com.tencent.mm.plugin.scanner.a.e eVar = (com.tencent.mm.plugin.scanner.a.e) kVar;
                    if (eVar.cif == null || eVar.cif.czl.czs == null) {
                        com_tencent_mm_protocal_c_akl = null;
                    } else {
                        com_tencent_mm_protocal_c_akl = (akl) eVar.cif.czl.czs;
                    }
                    if (com_tencent_mm_protocal_c_akl == null) {
                        v.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
                        cs(null, null);
                        return;
                    }
                    v.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_akl.mid), Integer.valueOf(com_tencent_mm_protocal_c_akl.mig), com_tencent_mm_protocal_c_akl.mLs, com_tencent_mm_protocal_c_akl.mLt});
                    if (!be.kS(com_tencent_mm_protocal_c_akl.mLt)) {
                        cs(com_tencent_mm_protocal_c_akl.mLs, com_tencent_mm_protocal_c_akl.mLt);
                        if (this.iBs != null) {
                            ak.vy().c(this.iBs);
                            return;
                        }
                        return;
                    }
                    return;
                }
                v.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.iBb -= 300;
                cs(null, null);
                return;
            default:
                return;
        }
    }

    private void cs(String str, String str2) {
        if (be.kS(str)) {
            this.iBu.setText("");
        } else {
            this.dMQ.setVisibility(8);
            this.iBu.setText(str);
            this.iBu.setVisibility(0);
        }
        if (be.kS(str2)) {
            this.iBv.setText("");
            return;
        }
        this.dMQ.setVisibility(8);
        this.iBv.setText(str2);
        this.iBv.setVisibility(0);
    }

    protected final void onResume() {
        ak.vy().a(392, this);
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            aLI();
        }
    }

    protected final void onPause() {
        fj(false);
        ak.vy().b(392, this);
    }

    protected final int aLd() {
        return 0;
    }

    protected final boolean aLf() {
        return true;
    }

    protected final boolean aLg() {
        return true;
    }
}
