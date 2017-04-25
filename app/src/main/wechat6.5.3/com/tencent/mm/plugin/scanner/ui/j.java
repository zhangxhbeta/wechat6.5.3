package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.mg;
import com.tencent.mm.plugin.scanner.b.b.a;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;

public final class j extends i implements a {
    private HighlightRectSideView iAR;
    boolean iAS = false;
    private OnClickListener iAT = new OnClickListener(this) {
        final /* synthetic */ j iAU;

        {
            this.iAU = r1;
        }

        public final void onClick(View view) {
            View inflate = ((LayoutInflater) this.iAU.iAM.aLx().getSystemService("layout_inflater")).inflate(2130904289, null);
            Context aLx = this.iAU.iAM.aLx();
            g.a(aLx, aLx.getString(2131234739), aLx.getString(2131234738), inflate, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass1 iAV;

                {
                    this.iAV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    };
    private long ixh;

    public j(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(bVar, point);
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = point2.y - ((int) (118.0f * displayMetrics.density));
        Point point3 = new Point((int) (((float) ((int) (((float) i2) * 1.586f))) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        bVar.aLx().setResult(0);
        this.iAK = 0;
        this.iAL = 64;
        cj(point3.x, point3.y);
        if (be.dX(bVar.aLx()) < 100) {
            v.w("MicroMsg.ScanModeBankCard", "memory is not much");
            this.ixh = 280;
            return;
        }
        this.ixh = 80;
    }

    protected final void onResume() {
    }

    protected final void onPause() {
    }

    protected final void aLa() {
    }

    protected final com.tencent.mm.plugin.scanner.b.b aLb() {
        if (this.iAG == null && this.iAM != null) {
            this.iAG = new com.tencent.mm.plugin.scanner.b.g(this, this.iAM.aLt(), this.iAS);
        }
        return this.iAG;
    }

    protected final int aLc() {
        return 2130904288;
    }

    protected final int aLd() {
        return 300;
    }

    protected final void aLe() {
    }

    protected final void g(Rect rect) {
        String str;
        LinearLayout linearLayout = (LinearLayout) this.iAM.findViewById(2131758946);
        TextView textView = (TextView) this.iAM.findViewById(2131758947);
        this.iAR = (HighlightRectSideView) this.iAM.findViewById(2131758949);
        this.iAR.h(rect);
        Intent intent = this.iAM.aLx().getIntent();
        if (intent != null) {
            String ah = be.ah(intent.getStringExtra("bank_card_owner"), "");
            textView.setText(String.format(this.iAM.aLx().getResources().getString(2131234741), new Object[]{ah}));
            str = ah;
        } else {
            str = null;
        }
        if (be.kS(str)) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            ((ImageView) this.iAM.findViewById(2131758948)).setOnClickListener(this.iAT);
        }
        if (this.iAG != null && this.iAM != null) {
            com.tencent.mm.plugin.scanner.b.g gVar = (com.tencent.mm.plugin.scanner.b.g) this.iAG;
            boolean aLt = this.iAM.aLt();
            v.d("MicroMsg.ScanBankCardDecoder", "need rotate:" + aLt);
            gVar.iDt = aLt;
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        v.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d, result:%s", new Object[]{Integer.valueOf(i), str});
        if (3 != i) {
            v.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:" + i);
            return;
        }
        Bitmap bitmap = ((com.tencent.mm.plugin.scanner.b.g) this.iAG).iDA;
        if (this.iAS) {
            this.iAM.aLv();
            ConfirmScanBankCardResultUI.a(bitmap, str);
            return;
        }
        mg mgVar = new mg();
        mgVar.bnr.bns = str;
        mgVar.bnr.bnt = bitmap;
        com.tencent.mm.sdk.c.a.nhr.z(mgVar);
        this.iAM.aLx().finish();
    }

    public final void aLh() {
        v.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
        if (this.iAM == null) {
            v.e("MicroMsg.ScanModeBankCard", "ui callback is null");
            return;
        }
        this.iAR.a(((com.tencent.mm.plugin.scanner.b.g) this.iAG).iDw);
        this.iAM.cz(this.ixh);
    }

    protected final boolean aLf() {
        return false;
    }

    protected final boolean aLg() {
        return false;
    }
}
