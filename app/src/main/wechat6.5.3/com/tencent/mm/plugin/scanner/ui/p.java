package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.g.a.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.b.b;
import com.tencent.mm.plugin.scanner.b.d;
import com.tencent.mm.plugin.scanner.b.n;
import com.tencent.mm.plugin.scanner.b.q;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.c.hi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.w;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class p extends i implements a, b.a, i.a, e {
    private int aZl = 0;
    private boolean beg = false;
    private b iAG;
    private long iAX = 80;
    private boolean iBA = false;
    private boolean iBB = false;
    boolean iBC = false;
    private int iBD;
    private int iBE;
    private Rect iBF = null;
    private OnClickListener iBG = new OnClickListener(this) {
        final /* synthetic */ p iBH;

        {
            this.iBH = r1;
        }

        public final void onClick(View view) {
            if (this.iBH.iAM == null) {
                v.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
                return;
            }
            g.iuh.h(11264, new Object[]{Integer.valueOf(3)});
            com.tencent.mm.plugin.scanner.a.drp.al(this.iBH.iAM.aLx());
        }
    };
    private com.tencent.mm.plugin.scanner.b.e.a iBo = new com.tencent.mm.plugin.scanner.b.e.a(this) {
        final /* synthetic */ p iBH;

        {
            this.iBH = r1;
        }

        public final void f(int i, Bundle bundle) {
            v.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", new Object[]{Integer.valueOf(i)});
            switch (i) {
                case 0:
                    this.iBH.iBA = false;
                    return;
                case 1:
                    this.iBH.eW(true);
                    return;
                case 2:
                    this.iBH.eW(true);
                    return;
                case 3:
                    this.iBH.iAM.aLu();
                    return;
                case 4:
                    if (bundle != null) {
                        String string = bundle.getString("geta8key_fullurl");
                        if (string == null) {
                            return;
                        }
                        if (string.startsWith("http://login.weixin.qq.com") || string.startsWith("https://login.weixin.qq.com")) {
                            this.iBH.aZl = 2;
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int mMode = 0;

    static /* synthetic */ void c(p pVar) {
        pVar.iBB = true;
        pVar.iBA = true;
        pVar.iAM.aLs();
    }

    public p(i.b bVar, Point point, int i, int i2) {
        super(bVar, point);
        cj(244, 244);
        aLK();
        this.aZl = i;
        this.mMode = i2;
        if (be.dX(bVar.aLx()) < 100) {
            v.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.iAX = 280;
        }
    }

    protected final void c(Point point) {
        this.iAF = null;
        this.iBF = null;
        super.c(point);
        aLK();
    }

    private void h(int i, float f) {
        this.iBD = Math.round(((float) i) * f);
        this.iBE = Math.round(((float) i) * f);
        if (this.iBD % 2 == 1) {
            this.iBD++;
        }
        if (this.iBE % 2 == 1) {
            this.iBE++;
        }
        v.i("MicroMsg.scanner.ScanModeQRCode", "calcQrCodeFrameRectSizePx, qrCodeframeRectWidthInPx: %s, qrCodeframeRectHeightInPx: %s, base: %s, ratio: %s", new Object[]{Integer.valueOf(this.iBD), Integer.valueOf(this.iBE), Integer.valueOf(i), Float.valueOf(f)});
    }

    private void aLK() {
        float f = 0.7f;
        Point ep = w.ep(aa.getContext());
        v.i("MicroMsg.scanner.ScanModeQRCode", "initQRModeFrameRect, baseSize: %s, cameraResolution: %s, widthRatio: %s, heightRatio: %s", new Object[]{ep, this.iAO, Float.valueOf(0.7f), Float.valueOf(0.7f)});
        int min = Math.min(ep.x, ep.y);
        if (min >= 720) {
            if (this.iAO != null) {
                while (true) {
                    h(min, f);
                    int i = this.iBD;
                    int i2 = this.iAO.y;
                    Rect rect = new Rect();
                    this.iAM.aLx().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    v.i("MicroMsg.scanner.ScanModeQRCode", "getScanFrameWidth, frameRect.width: %s", new Object[]{Integer.valueOf(rect.width())});
                    i = (i * i2) / rect.width();
                    i2 = this.iBE;
                    int i3 = this.iAO.x;
                    Rect rect2 = new Rect();
                    this.iAM.aLx().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
                    v.i("MicroMsg.scanner.ScanModeQRCode", "getScanFrameHeight, frameRect.height: %s", new Object[]{Integer.valueOf(rect2.width())});
                    v.i("MicroMsg.scanner.ScanModeQRCode", "scanWidth: %s, scanHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf((i2 * i3) / rect2.height())});
                    if (Math.max(i, (i2 * i3) / rect2.height()) <= 750) {
                        break;
                    }
                    v.i("MicroMsg.scanner.ScanModeQRCode", "scan size exceed upper bound, decrease ratio");
                    f -= 0.05f;
                }
            } else {
                h(min, 0.7f);
            }
            v.d("MicroMsg.scanner.ScanModeQRCode", "initQRModeFrameRect, qrCodeframeRectWidthInPx = [%s] [%sdp], qrCodeframeRectHeightInPx = [%s] [%sdp], oldTARGET_WIDTH_Dp = [%s][%sdp]", new Object[]{Integer.valueOf(this.iBD), Integer.valueOf(com.tencent.mm.bd.a.P(aa.getContext(), this.iBD)), Integer.valueOf(this.iBE), Integer.valueOf(com.tencent.mm.bd.a.P(aa.getContext(), this.iBD)), Integer.valueOf(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 244)), Integer.valueOf(244)});
            v.i("MicroMsg.scanner.ScanModeQRCode", "initQRModeFrameRect, frameRectHeightInPx: %s, frameRectWidthInPx: %s", new Object[]{Integer.valueOf(this.iAJ), Integer.valueOf(this.iAI)});
            if (this.iAJ > this.iBE || this.iAI > this.iBE) {
                this.iAJ = this.iBE;
                this.iAI = this.iBD;
            }
        } else {
            this.iBE = this.iAJ;
            this.iBD = this.iAI;
        }
        v.i("MicroMsg.scanner.ScanModeQRCode", "final frameRectWidthInPx: %s[%sdp], frameRectHeightInPx: %s[%sdp]", new Object[]{Integer.valueOf(this.iAI), Integer.valueOf(com.tencent.mm.bd.a.P(aa.getContext(), this.iAI)), Integer.valueOf(this.iAJ), Integer.valueOf(com.tencent.mm.bd.a.P(aa.getContext(), this.iAJ))});
    }

    protected final Rect fk(boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = this.iAH.x;
        int i5 = this.iAH.y;
        int a = BackwardSupportUtil.b.a(this.iAM.aLx(), (float) this.iAK);
        if (this.iAM.aLt()) {
            i = a;
        } else {
            i = 0;
        }
        if (z) {
            if (i4 < i5) {
                i2 = (i5 / 2) - (this.iBD / 2);
                i3 = (this.iBD / 2) + (i5 / 2);
                a = BackwardSupportUtil.b.a(this.iAM.aLx(), (float) this.iAL);
                i = this.iBE + a;
            } else {
                i2 = (i4 / 2) - (this.iBD / 2);
                i3 = (this.iBD / 2) + (i4 / 2);
                a = BackwardSupportUtil.b.a(this.iAM.aLx(), (float) this.iAL);
                i = this.iBE + a;
            }
        } else if (i4 < i5) {
            i2 = (i4 / 2) - (this.iBD / 2);
            i3 = (this.iBD / 2) + (i4 / 2);
            a = (i5 / 2) - (this.iBE / 2);
            if (a - i > 0) {
                a -= i;
            }
            i = this.iBE + a;
        } else {
            i2 = (i5 / 2) - (this.iBD / 2);
            i3 = (this.iBD / 2) + (i5 / 2);
            a = (i4 / 2) - (this.iBE / 2);
            if (a - i > 0) {
                a -= i;
            }
            i = this.iBE + a;
        }
        v.d("MicroMsg.scanner.ScanModeQRCode", "qrCodeScanFrameRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(a), Integer.valueOf(i)});
        this.iBF = new Rect(i2, a, i3, i);
        return this.iBF;
    }

    protected final void g(Rect rect) {
        this.dMQ = (TextView) this.iAM.findViewById(2131758970);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.dMQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.a(this.iAM.aLx(), 13.0f);
            this.dMQ.setLayoutParams(layoutParams);
        }
        if (this.iAG != null) {
            ((d) this.iAG).hoe = this.iAM.aLt();
        }
        aLI();
        if (this.mMode == 2) {
            this.dMQ.setText(2131234258);
        } else if (this.mMode == 1) {
            this.dMQ.setText(2131234257);
        } else if (this.aZl == 1) {
            this.dMQ.setText(2131234283);
        } else if (this.aZl == 2) {
            this.dMQ.setText(2131236632);
        } else {
            this.dMQ.setText(2131234284);
        }
        fj(true);
    }

    protected final void aLe() {
        g(new Rect(0, 0, 0, 0));
        if (this.mMode == 2) {
            this.iAM.b(4, null);
        } else {
            this.iAM.b(0, new OnClickListener(this) {
                final /* synthetic */ p iBH;

                {
                    this.iBH = r1;
                }

                public final void onClick(View view) {
                    p.c(this.iBH);
                }
            });
        }
        this.iAM.a(this);
        onResume();
    }

    protected final int aLc() {
        return 2130904300;
    }

    protected final b aLb() {
        if (this.iAG == null && this.iAM != null) {
            this.iAG = new d(this, this.mMode, this.iAM.aLt());
        }
        return this.iAG;
    }

    protected final void aLa() {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
        } else {
            aLI();
        }
    }

    private void aLI() {
        if (this.iAM == null) {
            v.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
        } else if (ak.vy().BJ() == 6 || ak.vy().BJ() == 4) {
            this.iAM.h(0, false);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
        } else if (this.iBA) {
            v.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
        } else {
            this.iBA = true;
            v.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", new Object[]{str});
            if (be.kS(str)) {
                this.iBA = false;
            } else if (ak.vy().BJ() == 0) {
                Toast.makeText(this.iAM.aLx(), this.iAM.aLx().getString(2131232875), 0).show();
                this.iBA = false;
            } else {
                b(i, str, i2, i3);
            }
        }
    }

    private void b(int i, String str, int i2, int i3) {
        int i4 = 1;
        Activity aLx = this.iAM.aLx();
        kd kdVar = new kd();
        if (i == 1) {
            kdVar.bkW.bkY = 0;
        } else {
            kdVar.bkW.bkY = 1;
        }
        kdVar.bkW.bkZ = str;
        if (this.iBC) {
            v.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
            kdVar.bkW.bkU = 1;
            com.tencent.mm.sdk.c.a.nhr.z(kdVar);
            Intent intent = new Intent();
            intent.putExtra("key_scan_result", str);
            intent.putExtra("key_scan_result_type", i);
            aLx.setResult(-1, intent);
            aLx.finish();
            aLx.overridePendingTransition(0, 0);
            return;
        }
        kdVar.bkW.bkU = 0;
        com.tencent.mm.sdk.c.a.nhr.z(kdVar);
        if (kdVar.bkX.ret == 1 || kdVar.bkX.ret == 2) {
            aLx.finish();
            aLx.overridePendingTransition(0, 0);
        }
        this.iAM.fh(true);
        if (i == 1) {
            this.iAM.aLl();
            this.iBA = false;
            if (kdVar.bkX.ret != 2) {
                if (!this.iBB) {
                    i4 = 0;
                }
                this.iAM.a(str, i4, i2, i3, this.iBo);
            }
        } else if (i != 2) {
        } else {
            if (str == null || str.length() <= 0) {
                v.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
                this.iBA = false;
                this.iAM.fh(false);
                return;
            }
            String[] split = str.split(",", 2);
            if (split == null || split.length < 2) {
                v.e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
                this.iBA = false;
                this.iAM.fh(false);
                return;
            }
            final f fVar = new f(q.zb(split[0]), split[1], i2, i3);
            ak.vy().a(fVar, 0);
            this.iAM.aLl();
            this.iAM.fh(true);
            Context aLx2 = this.iAM.aLx();
            this.iAM.aLx().getString(2131231164);
            this.dwR = com.tencent.mm.ui.base.g.a(aLx2, this.iAM.aLx().getString(2131234280), true, new OnCancelListener(this) {
                final /* synthetic */ p iBH;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(fVar);
                    this.iBH.iAM.fh(false);
                    this.iBH.iBA = false;
                }
            });
        }
    }

    public final void aLh() {
        v.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail");
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
        } else if (!this.beg) {
            this.iAM.cz(this.iAX);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (this.iAM == null || kVar == null) {
            String str2 = "MicroMsg.scanner.ScanModeQRCode";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(kVar == null);
            v.e(str2, str3, objArr);
            this.iBA = false;
        } else if (i == 4 && i2 == -4) {
            com.tencent.mm.ui.base.g.a(this.iAM.aLx(), 2131234276, 2131231164, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ p iBH;

                {
                    this.iBH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iBH.eW(true);
                }
            });
        } else {
            boolean z;
            switch (i) {
                case 1:
                    if (ak.vy().BK()) {
                        i.u(this.iAM.aLx(), ak.vy().getNetworkServerIp(), String.valueOf(i2));
                    } else if (com.tencent.mm.network.aa.bk(this.iAM.aLx())) {
                        i.dl(this.iAM.aLx());
                    } else {
                        Toast.makeText(this.iAM.aLx(), this.iAM.aLx().getString(2131232874, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    z = true;
                    break;
                case 2:
                    Toast.makeText(this.iAM.aLx(), this.iAM.aLx().getString(2131232875, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                eW(true);
            } else if (i == 4 && i2 == -2004) {
                com.tencent.mm.ui.base.g.f(this.iAM.aLx(), 2131234269, 2131231164);
                eW(true);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.iAM.aLx(), this.iAM.aLx().getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                eW(true);
            } else if (kVar.getType() == 1061) {
                hi aKS = ((f) kVar).aKS();
                if (aKS == null) {
                    v.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
                    eW(true);
                    return;
                }
                v.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(aKS.efm)});
                if (be.kS(aKS.mib)) {
                    eW(true);
                    return;
                }
                int i3 = aKS.efm;
                switch (n.a(aKS.mib, this, 4, this.iBo, ((f) kVar).aYV, ((f) kVar).aYW)) {
                    case 0:
                        this.iAM.aLx().finish();
                        this.iAM.aLx().overridePendingTransition(0, 0);
                        return;
                    case 1:
                        v.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        break;
                    case 2:
                        v.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        this.iAM.h(0, false);
                        break;
                }
                this.iAM.fh(false);
            } else if (kVar.getType() == 666) {
                if (kVar instanceof com.tencent.mm.modelsimple.w) {
                    this.iAM.fh(true);
                    this.iAM.aLx().finish();
                    this.iAM.aLx().overridePendingTransition(0, 0);
                }
            } else if (kVar.getType() == 971) {
                this.iAM.fh(true);
                this.iAM.aLx().finish();
                this.iAM.aLx().overridePendingTransition(0, 0);
            }
        }
    }

    protected final void onResume() {
        ak.vy().a(1061, this);
        ak.vy().a(666, this);
        ak.vy().a(971, this);
        if (this.iAM == null) {
            v.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            return;
        }
        if (!this.iBB) {
            this.iBA = false;
        }
        aLI();
    }

    protected final void onPause() {
        super.onPause();
        fj(false);
        ak.vy().b(1061, this);
        ak.vy().b(666, this);
        ak.vy().b(971, this);
    }

    protected final int aLd() {
        return 244;
    }

    public final void b(final Activity activity, int i, int i2, Intent intent) {
        if (activity != null) {
            this.iBA = true;
            if (i2 != -1) {
                this.iBA = false;
                this.iBB = false;
                return;
            }
            switch (i) {
                case 4660:
                    if (intent == null) {
                        v.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
                        this.iBA = false;
                        this.iBB = false;
                        return;
                    }
                    ak.yW();
                    v.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", new Object[]{com.tencent.mm.ui.tools.a.b(activity, intent, c.wP())});
                    new ac().post(new Runnable(this) {
                        final /* synthetic */ p iBH;

                        public final void run() {
                            p pVar = this.iBH;
                            Context context = activity;
                            activity.getString(2131231164);
                            pVar.dwR = com.tencent.mm.ui.base.g.a(context, activity.getString(2131234278), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass6 iBJ;

                                {
                                    this.iBJ = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.iBJ.iBH.iBA = false;
                                    this.iBJ.iBH.iBB = false;
                                    this.iBJ.iBH.beg = false;
                                }
                            });
                        }
                    });
                    if (this.iAG != null) {
                        this.iAG.aLM();
                    }
                    this.beg = true;
                    if (this.iAM != null) {
                        this.iAM.fh(true);
                    }
                    l.iwj.reset();
                    com.tencent.mm.plugin.scanner.b.aKP().ivv.a(r0, new com.tencent.mm.plugin.g.a.b.a(this) {
                        final /* synthetic */ p iBH;

                        public final void g(String str, String str2, int i, int i2) {
                            int i3 = 1;
                            l.iwj.oW(l.iwh);
                            if (this.iBH.iAG != null) {
                                this.iBH.iAG.aLN();
                            }
                            if (this.iBH.dwR == null || !this.iBH.dwR.isShowing()) {
                                this.iBH.iBA = false;
                                this.iBH.iBB = false;
                                return;
                            }
                            this.iBH.beg = true;
                            if (this.iBH.iAM != null) {
                                this.iBH.iAM.fh(true);
                            }
                            this.iBH.dwR.dismiss();
                            if (be.kS(str2)) {
                                l.iwj.auO();
                                com.tencent.mm.ui.base.g.a(activity, 2131234277, 2131231164, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass7 iBK;

                                    {
                                        this.iBK = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.iBK.iBH.iBA = false;
                                        this.iBK.iBH.iBB = false;
                                        this.iBK.iBH.beg = false;
                                        l.iwj.reset();
                                        l.iwj.oW(l.iwg);
                                        if (this.iBK.iBH.iAM != null) {
                                            this.iBK.iBH.iAM.fh(false);
                                            this.iBK.iBH.iAM.cz(this.iBK.iBH.iAX);
                                        }
                                    }
                                });
                                return;
                            }
                            bl.zQ().b(10237, new Object[]{Integer.valueOf(1)});
                            this.iBH.iAM.aLl();
                            if (i != 19) {
                                i3 = 2;
                            }
                            this.iBH.b(i3, str2, i, i2);
                            this.iBH.iBB = false;
                        }

                        public final void yo(String str) {
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    public final Context getContext() {
        if (this.iAM != null) {
            return this.iAM.aLx();
        }
        v.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
        return null;
    }

    public final void eW(boolean z) {
        if (this.iAM == null) {
            v.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
        } else if (z) {
            this.iBA = false;
            this.iAM.fh(false);
        } else {
            this.iAM.aLx().finish();
            this.iAM.aLx().overridePendingTransition(0, 0);
        }
    }

    protected final boolean aLf() {
        return true;
    }

    protected final boolean aLg() {
        return true;
    }

    public final boolean oZ() {
        return this.beg;
    }
}
