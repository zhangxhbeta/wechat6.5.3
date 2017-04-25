package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.scanner.a.g;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.plugin.scanner.b.n;
import com.tencent.mm.plugin.scanner.b.q;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.protocal.c.hk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class k extends i implements a, e {
    private static int iAW = 300;
    private long iAX = 130;
    g iAY;
    private int iAZ = 0;
    private int iBa = 1;
    private long iBb;
    private final int iBc = 260;
    private final int iBd = 300;
    private final int iBe = 390;
    private final int iBf = 450;
    private final int iBg = 220;
    private final int iBh = 240;
    private final int iBi = 330;
    private final int iBj = 360;
    private float iBk;
    private final long iBl = 30000;
    private long iBm;
    private final int iBn = 50;
    private com.tencent.mm.plugin.scanner.b.e.a iBo = new com.tencent.mm.plugin.scanner.b.e.a(this) {
        final /* synthetic */ k iBq;

        {
            this.iBq = r1;
        }

        public final void f(int i, Bundle bundle) {
            switch (i) {
                case 3:
                    this.iBq.iAM.aLu();
                    return;
                default:
                    return;
            }
        }
    };
    private OnTouchListener iBp;
    private int iwf;
    private TextView ixM;
    private View ixN;

    public k(b bVar, Point point) {
        super(bVar, point);
        if (c.rt()) {
            cj(220, 240);
            this.iBk = q.cm(330, this.iAI);
        } else {
            cj(260, 300);
            this.iBk = q.cm(390, this.iAI);
        }
        v.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", new Object[]{Integer.valueOf(this.iAI), Integer.valueOf(this.iAJ), Float.valueOf(this.iBk)});
        if (be.dX(bVar.aLx()) < 100) {
            v.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
            this.iAX = 300;
        }
        this.iwf = (int) (System.currentTimeMillis() & -1);
        this.iBm = System.currentTimeMillis();
    }

    protected final void g(Rect rect) {
        this.ixN = this.iAM.findViewById(2131758953);
        this.ixM = (TextView) this.iAM.findViewById(2131758954);
        this.dMQ = (TextView) this.iAM.findViewById(2131758970);
        this.dMQ.setText(q.cu(q.iEi, this.iAM.aLx().getString(2131234759)));
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.dMQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.iAM.aLx(), 13.0f);
            this.dMQ.setLayoutParams(layoutParams);
        }
        if (c.rt()) {
            this.dMQ.setPadding(BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.dMQ.getPaddingTop(), BackwardSupportUtil.b.a(this.iAM.aLx(), 54.0f), this.dMQ.getPaddingBottom());
        }
        if (this.iAG != null) {
            ((com.tencent.mm.plugin.scanner.b.k) this.iAG).hoe = this.iAM.aLt();
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
        return 2130904296;
    }

    protected final com.tencent.mm.plugin.scanner.b.b aLb() {
        if (this.iAG == null) {
            int i = 50;
            if (p.ceA.ccU > 0) {
                i = p.ceA.ccU;
                v.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", new Object[]{Integer.valueOf(p.ceA.ccU)});
            }
            if (ak.is2G(this.iAM.aLx())) {
                this.iAG = new com.tencent.mm.plugin.scanner.b.k(this, i - 10, this.iBk, false, this.iAM.aLt());
            } else {
                this.iAG = new com.tencent.mm.plugin.scanner.b.k(this, i, this.iBk, false, this.iAM.aLt());
            }
        }
        return this.iAG;
    }

    protected final void aLa() {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else {
            aLI();
        }
    }

    private void aLI() {
        if (this.iAM == null) {
            v.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
        } else if (com.tencent.mm.model.ak.vy().BJ() == 6 || com.tencent.mm.model.ak.vy().BJ() == 4) {
            this.iAM.h(0, false);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            v.w("MicroMsg.scanner.ScanModeImage", "greyData null");
            if (System.currentTimeMillis() - this.iBb <= this.iAX + 1800 || !iCZ[1]) {
                this.iAM.cz(this.iAX);
                return;
            }
            this.iBb = System.currentTimeMillis();
            this.iAM.h(0, true);
        } else {
            aLJ();
            if (this.iAZ >= this.iBa) {
                v.d("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
                this.iAM.cz(this.iAX);
                if (System.currentTimeMillis() - this.iBb <= this.iAX + 1800 || !iCZ[1]) {
                    this.iAM.cz(this.iAX);
                    return;
                }
                this.iBb = System.currentTimeMillis();
                this.iAM.h(0, true);
                return;
            }
            this.iAY = new g(bArr, bArr.length, this.iwf);
            com.tencent.mm.model.ak.vy().a(this.iAY, 0);
            this.iAZ++;
            this.iAN += bArr.length;
            v.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", new Object[]{Integer.valueOf(this.iAN)});
            if (System.currentTimeMillis() - this.iBb <= this.iAX + 1800 || !iCZ[1]) {
                this.iAM.cz(this.iAX);
                return;
            }
            this.iBb = System.currentTimeMillis();
            this.iAM.h(0, true);
        }
    }

    public final void aLh() {
        v.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        aLJ();
        if (System.currentTimeMillis() - this.iBb <= 1800 + this.iAX || !iCZ[1]) {
            this.iAM.cz(this.iAX);
            return;
        }
        this.iBb = System.currentTimeMillis();
        this.iAM.h(0, true);
    }

    private void aLJ() {
        ad.o(new Runnable(this) {
            final /* synthetic */ k iBq;

            {
                this.iBq = r1;
            }

            public final void run() {
                if (System.currentTimeMillis() - this.iBq.iBm > 30000) {
                    v.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
                    this.iBq.iAM.fh(true);
                    this.iBq.dMQ.setVisibility(8);
                    this.iBq.ixM.setText(2131234757);
                    this.iBq.ixM.setVisibility(0);
                    if (this.iBq.iBp == null) {
                        this.iBq.iBp = new OnTouchListener(this) {
                            final /* synthetic */ AnonymousClass2 iBr;

                            {
                                this.iBr = r1;
                            }

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                this.iBr.iBq.iAM.fh(false);
                                this.iBr.iBq.dMQ.setVisibility(0);
                                this.iBr.iBq.dMQ.setText(q.cu(q.iEi, this.iBr.iBq.iAM.aLx().getString(2131234759)));
                                this.iBr.iBq.ixM.setVisibility(8);
                                this.iBr.iBq.iBm = System.currentTimeMillis();
                                return false;
                            }
                        };
                    }
                    this.iBq.ixN.setOnTouchListener(this.iBq.iBp);
                }
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        this.iAZ = 0;
        if (this.iAM == null || kVar == null) {
            boolean z;
            String str2 = "MicroMsg.scanner.ScanModeImage";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            if (kVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.e(str2, str3, objArr);
        } else if (kVar.getType() == 1062) {
            if (i == 0 && i2 == 0) {
                g gVar = (g) kVar;
                hk hkVar = (gVar.cif == null || gVar.cif.czl.czs == null) ? null : (hk) gVar.cif.czl.czs;
                if (hkVar != null) {
                    v.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", new Object[]{Integer.valueOf(hkVar.mid), Integer.valueOf(hkVar.mig)});
                    int i3 = hkVar.efm;
                    switch (n.a(hkVar.mii, this, 3, this.iBo, 0, 0)) {
                        case 0:
                            this.iAM.aLl();
                            ad.g(new Runnable(this) {
                                final /* synthetic */ k iBq;

                                {
                                    this.iBq = r1;
                                }

                                public final void run() {
                                    if (this.iBq.iAM != null && this.iBq.iAM.aLx() != null) {
                                        this.iBq.iAM.aLx().finish();
                                        this.iBq.iAM.aLx().overridePendingTransition(0, 0);
                                    }
                                }
                            }, 700);
                            break;
                        case 1:
                            v.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                            break;
                        case 2:
                            v.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                            break;
                        default:
                            break;
                    }
                }
                v.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
                return;
            }
            v.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.dMQ.setText(q.cu(q.iEi, this.iAM.aLx().getString(2131234759)));
            if (this.iAY != null) {
                com.tencent.mm.model.ak.vy().c(this.iAY);
            }
        }
    }

    protected final void onResume() {
        com.tencent.mm.model.ak.vy().a(1062, this);
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        this.iAZ = 0;
        aLI();
    }

    protected final void onPause() {
        super.onPause();
        fj(false);
        com.tencent.mm.model.ak.vy().b(1062, this);
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
