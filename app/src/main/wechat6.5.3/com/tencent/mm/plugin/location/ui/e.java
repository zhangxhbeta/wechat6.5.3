package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends ImageView {
    private static int gUl;
    private final String TAG = "MicroMsg.MyPoiPoint";
    private boolean aHp;
    private double aIp;
    public a bYl = new a(this) {
        final /* synthetic */ e gUn;

        {
            this.gUn = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            if (this.gUn.gUm) {
                return false;
            }
            v.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            this.gUn.gUe = true;
            this.gUn.aIp = d2;
            this.gUn.gUf = (double) f2;
            this.gUn.gUg = (double) f;
            if (this.gUn.gUi != null) {
                if (this.gUn.gUj) {
                    this.gUn.gUi.updateViewLayout(this.gUn, this.gUn.gUf, this.gUn.gUg, -2);
                } else {
                    this.gUn.gUj = true;
                    this.gUn.gUi.addView(this.gUn, this.gUn.gUf, this.gUn.gUg, -2);
                }
            }
            if (this.gUn.gUc != null) {
                this.gUn.gUc.a(z, f, f2, i, d, d2);
            }
            this.gUn.invalidate();
            this.gUn.postInvalidate();
            this.gUn.requestLayout();
            this.gUn.gUm = true;
            return true;
        }
    };
    private a gUc;
    private Bitmap gUd;
    private boolean gUe;
    private double gUf;
    private double gUg;
    public c gUh;
    private d gUi;
    private boolean gUj = false;
    private final int gUk = 689208551;
    private boolean gUm = false;
    private Activity pP;

    public e(Activity activity, d dVar) {
        super(activity);
        this.gUi = dVar;
        this.gUc = null;
        this.pP = activity;
        this.gUd = com.tencent.mm.sdk.platformtools.d.uU(2130838900);
        this.aHp = false;
        this.gUe = false;
        this.gUh = c.FY();
        gUl = b.a(activity, 80.0f);
        setImageResource(2130838900);
        setScaleType(ScaleType.FIT_CENTER);
        v.d("MicroMsg.MyPoiPoint", "enableLocation");
        this.aHp = true;
        this.gUh.a(this.bYl);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        v.d("MicroMsg.MyPoiPoint", "onDraw");
    }
}
