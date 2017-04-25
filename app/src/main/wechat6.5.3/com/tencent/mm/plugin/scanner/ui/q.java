package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.Map;

public final class q extends i implements com.tencent.mm.plugin.scanner.b.b.a, e {
    private static int iAW = 300;
    private float bYf;
    private float bYg;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ q iBX;

        {
            this.iBX = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return true;
            }
            this.iBX.bYf = f2;
            this.iBX.bYg = f;
            this.iBX.iBM = (int) d2;
            this.iBX.iBN = "";
            this.iBX.iBO = "";
            this.iBX.iBL = i;
            this.iBX.iBP = true;
            q.b(this.iBX);
            if (!this.iBX.cCU) {
                this.iBX.cCU = true;
                n.a(2012, f, f2, (int) d2);
            }
            return false;
        }
    };
    private c cCR;
    private boolean cCU = false;
    private int iBL;
    private int iBM;
    private String iBN;
    private String iBO;
    private boolean iBP = false;
    private float iBQ = -10000.0f;
    private float iBR = -10000.0f;
    private boolean iBS = false;
    private boolean iBT = false;
    private boolean iBU = false;
    private a iBV;
    protected ac iBW = new ac(this) {
        final /* synthetic */ q iBX;

        {
            this.iBX = r1;
        }

        public final void handleMessage(Message message) {
            if (this.iBX.ixM != null) {
                this.iBX.iAM.fh(true);
                this.iBX.ixM.setText(2131234793);
                this.iBX.ixM.setVisibility(0);
            }
        }
    };
    private final int iBc = 260;
    private final int iBd = 300;
    private final int iBg = 220;
    private final int iBh = 240;
    private TextView ixM;

    private final class a implements Runnable {
        final /* synthetic */ q iBX;
        String url;

        private a(q qVar) {
            this.iBX = qVar;
        }

        public final void run() {
            if (this.iBX.iAM != null && !this.iBX.iBS) {
                r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", this.url);
                intent.putExtra("show_bottom", false);
                intent.putExtra("title", 2131234753);
                intent.putExtra("webview_bg_color_rsID", 2131689547);
                intent.putExtra("geta8key_scene", 13);
                intent.setFlags(65536);
                com.tencent.mm.plugin.scanner.a.drp.j(intent, this.iBX.iAM.aLx());
                this.iBX.iAM.aLx().finish();
                this.iBX.iAM.aLx().overridePendingTransition(0, 0);
            }
        }
    }

    static /* synthetic */ void b(q qVar) {
        if (qVar.iBP && !qVar.iBS && !qVar.iBU) {
            qVar.iBU = true;
            amz com_tencent_mm_protocal_c_amz = new amz();
            com_tencent_mm_protocal_c_amz.mrC = qVar.iBO;
            com_tencent_mm_protocal_c_amz.mrD = qVar.iBL;
            com_tencent_mm_protocal_c_amz.mjN = qVar.bYf;
            com_tencent_mm_protocal_c_amz.mjM = qVar.bYg;
            com_tencent_mm_protocal_c_amz.mrB = qVar.iBN;
            com_tencent_mm_protocal_c_amz.mrA = qVar.iBM;
            if (ak.uz()) {
                ak.vy().a(new x(com_tencent_mm_protocal_c_amz, qVar.iBQ, qVar.iBR), 0);
            }
        }
    }

    public q(b bVar, Point point) {
        super(bVar, point);
        if (com.tencent.mm.compatible.d.c.rt()) {
            cj(220, 240);
        } else {
            cj(260, 300);
        }
    }

    protected final void g(Rect rect) {
        this.ixM = (TextView) this.iAM.findViewById(2131758954);
        this.ixM.setText(2131234772);
        this.dMQ = (TextView) this.iAM.findViewById(2131758970);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.dMQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.iAM.aLx(), 13.0f);
            this.dMQ.setLayoutParams(layoutParams);
        }
        if (com.tencent.mm.compatible.d.c.rt()) {
            this.dMQ.setPadding(BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.dMQ.getPaddingTop(), BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.dMQ.getPaddingBottom());
        }
        aLI();
        fj(true);
    }

    protected final void aLe() {
        g(new Rect(0, 0, 0, 0));
        this.iAM.b(4, null);
        onResume();
    }

    protected final int aLc() {
        return 2130904301;
    }

    protected final com.tencent.mm.plugin.scanner.b.b aLb() {
        return null;
    }

    protected final void aLa() {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
        } else {
            aLI();
        }
    }

    private void aLI() {
        if (this.iAM == null) {
            v.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
        } else if (this.iBT) {
            this.iAM.fh(true);
        } else if (!ak.uz()) {
        } else {
            if (ak.vy().BJ() == 6 || ak.vy().BJ() == 4) {
                this.iAM.h(0, false);
                if (this.cCR != null) {
                    return;
                }
                if (this.iAM == null) {
                    v.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
                    return;
                }
                if (this.cCR == null) {
                    this.cCR = c.FY();
                }
                this.bYf = -1000.0f;
                this.bYg = -1000.0f;
                this.iBM = -1000;
                this.iBL = 1;
                this.iBN = "";
                this.iBO = "";
                this.cCR.a(this.bYl, true);
            }
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
    }

    public final void aLh() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
            return;
        }
        this.iBU = false;
        switch (kVar.getType()) {
            case 424:
                if (i == 0 && i2 == 0) {
                    arm Jw = ((x) kVar).Jw();
                    if (Jw == null || Jw.mii == null) {
                        v.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
                        return;
                    }
                    v.d("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Jw.efm)});
                    String ki;
                    if (Jw.efm == 0) {
                        ki = x.ki(Jw.mii);
                        if (be.kS(ki)) {
                            v.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
                            return;
                        }
                        if (this.iBV == null) {
                            this.iBV = new a();
                        }
                        this.iBV.url = ki;
                        ad.B(this.iBV);
                        ad.g(this.iBV, 800);
                        return;
                    } else if (Jw.efm == 2) {
                        if (this.iBW != null && !this.iBS) {
                            this.iBW.removeMessages(0);
                            this.iBW.sendEmptyMessageDelayed(0, 1000);
                            return;
                        }
                        return;
                    } else if (Jw.efm == 1) {
                        try {
                            ki = Jw.mii;
                            if (ki != null) {
                                Map q = bf.q(ki, "recommend");
                                if (q != null) {
                                    LinkedList e = x.b.e(q, ".recommend");
                                    x.b bVar = new x.b();
                                    bVar.title = be.ma((String) q.get(".recommend.title"));
                                    bVar.desc = be.ma((String) q.get(".recommend.desc"));
                                    bVar.cZq = e;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable e2) {
                            v.a("MicroMsg.scanner.ScanModeStreetView", e2, "", new Object[0]);
                            v.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", new Object[]{e2.getMessage()});
                            return;
                        }
                    } else {
                        return;
                    }
                }
                v.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            default:
                return;
        }
    }

    protected final void onResume() {
        if (ak.uz()) {
            ak.vy().a(424, this);
        }
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
        } else {
            aLI();
        }
    }

    protected final void onPause() {
        this.iBS = true;
        fj(false);
        if (ak.uz()) {
            ak.vy().b(424, this);
        }
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
        if (this.iBW != null) {
            this.iBW.removeMessages(0);
        }
    }

    protected final int aLd() {
        return iAW;
    }

    protected final boolean aLf() {
        return true;
    }

    protected final boolean aLg() {
        return true;
    }
}
