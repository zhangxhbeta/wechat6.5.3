package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.ml;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.scanner.b.b;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.plugin.scanner.b.l;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class c extends i implements a {
    private long ixh;
    private int ixi;
    private HighlightRectSideView ixj;
    private k ixk;
    private p ixl;
    private h ixm;

    protected abstract b a(a aVar);

    protected abstract float aKX();

    protected abstract String aKY();

    protected abstract int aKZ();

    static /* synthetic */ int a(c cVar) {
        int i = cVar.ixi + 1;
        cVar.ixi = i;
        return i;
    }

    static /* synthetic */ void a(c cVar, final String str) {
        if (cVar.ixm != null) {
            cVar.ixm.dismiss();
        }
        cVar.ixm = g.a(cVar.iAM.aLx(), 2131234762, 2131231164, new OnClickListener(cVar) {
            final /* synthetic */ c ixo;

            public final void onClick(DialogInterface dialogInterface, int i) {
                ak.vy().c(this.ixo.ixk);
                ml mlVar = new ml();
                mlVar.bnF.bnG = str;
                mlVar.bnF.bnH = 2;
                com.tencent.mm.sdk.c.a.nhr.z(mlVar);
                this.ixo.iAM.aLx().finish();
            }
        }, null);
    }

    public c(i.b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point);
        this.ixi = 0;
        this.ixk = null;
        this.ixl = null;
        this.ixm = null;
        this.iAK = 0;
        this.iAL = 0;
        float aKX = aKX();
        Point point2 = i == 1 ? new Point(displayMetrics.widthPixels, displayMetrics.heightPixels) : new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        int i2 = (int) (((float) point2.y) * 0.8f);
        int i3 = (int) (((float) point2.x) * 0.8f);
        if (((float) i2) * aKX > ((float) point2.x)) {
            i2 = (int) (((float) i3) / aKX);
        } else {
            i3 = (int) (((float) i2) * aKX);
        }
        Point point3 = new Point((int) (((float) i3) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        this.iAL = (int) (((((float) point2.y) / displayMetrics.density) - ((float) point3.y)) / 2.0f);
        cj(point3.x, point3.y);
        if (be.dX(bVar.aLx()) < 100) {
            v.w("MicroMsg.BaseScanModeLicence", "memory is not much");
            this.ixh = 280;
            return;
        }
        this.ixh = 80;
    }

    protected final void onResume() {
    }

    protected final void aLa() {
    }

    protected final b aLb() {
        if (this.iAG == null) {
            this.iAG = a((a) this);
        }
        return this.iAG;
    }

    protected final int aLc() {
        return 2130904297;
    }

    protected final int aLd() {
        return 0;
    }

    protected final void aLe() {
    }

    protected final void bX(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(2131758972);
            if (textView != null) {
                textView.setText(view.getContext().getString(2131234761, new Object[]{view.getContext().getString(aKZ())}));
            }
        }
    }

    protected final boolean aLf() {
        return false;
    }

    protected final boolean aLg() {
        return false;
    }

    protected final void g(Rect rect) {
        v.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", new Object[]{rect});
        HighlightRectSideView highlightRectSideView = (HighlightRectSideView) this.iAM.findViewById(2131758971);
        if (highlightRectSideView != null) {
            highlightRectSideView.h(rect);
        }
        this.ixj = highlightRectSideView;
    }

    public void a(int i, String str, byte[] bArr, int i2, int i3) {
        v.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
        Vibrator vibrator = (Vibrator) aa.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 50}, 1);
        }
        Bitmap bitmap = ((l) this.iAG).iDZ;
        final String aKY = aKY();
        if (this.ixl != null) {
            this.ixl.dismiss();
        }
        Context aLx = this.iAM.aLx();
        aLx.getString(2131231164);
        this.ixl = g.a(aLx, aLx.getString(2131234766), false, null);
        this.ixl.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ c ixo;

            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                c.a(this.ixo, aKY);
                return true;
            }
        });
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new hl();
        aVar.czo = new hm();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
        aVar.czm = 1803;
        com.tencent.mm.v.b Bv = aVar.Bv();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream)) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (be.bl(toByteArray)) {
                t(2, aKY, "");
                return;
            }
            hl hlVar = (hl) Bv.czk.czs;
            hlVar.mim = new com.tencent.mm.ba.b(toByteArray);
            if (aKY.equals("driving")) {
                hlVar.mil = 0;
            } else if (aKY.equals("identity")) {
                hlVar.mil = 1;
            }
            this.ixk = u.a(Bv, new u.a(this) {
                final /* synthetic */ c ixo;

                public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                    v.i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    c.a(this.ixo);
                    this.ixo.t(i2, aKY, ((hm) bVar.czl.czs).min);
                    return 0;
                }
            }, false);
            return;
        }
        t(2, aKY, "");
    }

    public final void aLh() {
        v.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
        if (this.iAM == null) {
            v.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
        } else {
            aLi();
        }
    }

    private void aLi() {
        this.ixj.a(((l) this.iAG).iDw);
        this.iAM.cz(this.ixh);
    }

    private void t(int i, String str, String str2) {
        ml mlVar;
        if (i == 0) {
            mlVar = new ml();
            mlVar.bnF.bnG = str;
            mlVar.bnF.bnH = 1;
            mlVar.bnF.bnI = str2;
            if (this.iAG instanceof l) {
                mlVar.bnF.bnJ = ((l) this.iAG).iDZ;
            }
            com.tencent.mm.sdk.c.a.nhr.a(mlVar, Looper.getMainLooper());
            if (this.ixl != null) {
                this.ixl.dismiss();
            }
            this.iAM.aLx().finish();
        } else if ((i & 2) > 0 && (i & 1) > 0) {
            r0 = new ml();
            r0.bnF.bnG = str;
            r0.bnF.bnH = 0;
            r0.bnF.bnI = str2;
            com.tencent.mm.sdk.c.a.nhr.a(r0, Looper.getMainLooper());
            if (this.ixl != null) {
                this.ixl.dismiss();
            }
            this.iAM.aLx().finish();
        } else if (this.ixi >= 3) {
            mlVar = new ml();
            mlVar.bnF.bnG = str;
            mlVar.bnF.bnH = 1;
            mlVar.bnF.bnI = str2;
            if (this.iAG instanceof l) {
                mlVar.bnF.bnJ = ((l) this.iAG).iDZ;
            }
            com.tencent.mm.sdk.c.a.nhr.a(mlVar, Looper.getMainLooper());
            if (this.ixl != null) {
                this.ixl.dismiss();
            }
            this.iAM.aLx().finish();
        } else if ((i & 1) <= 0 || this.ixi >= 3) {
            r0 = new ml();
            r0.bnF.bnG = str;
            r0.bnF.bnH = 0;
            r0.bnF.bnI = str2;
            com.tencent.mm.sdk.c.a.nhr.a(r0, Looper.getMainLooper());
            if (this.ixl != null) {
                this.ixl.dismiss();
            }
            this.iAM.aLx().finish();
        } else {
            if (this.ixl != null) {
                this.ixl.dismiss();
            }
            aLb().aLN();
            int i2 = (i & 32) > 0 ? 2131234764 : (i & 64) > 0 ? 2131234765 : 2131234763;
            Toast.makeText(this.iAM.aLx(), i2, 0).show();
            aLi();
        }
    }
}
