package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class h extends BitmapDrawable implements com.tencent.mm.pluginsdk.ui.d.a {
    protected static final Paint cnN;
    protected static final ac cnO = new ac(Looper.getMainLooper());
    private Runnable cnQ;
    private Paint evR = new Paint();
    private Path fIP;
    protected final a hXG;
    protected boolean lGK = false;
    protected boolean lGL = false;
    private int lGM = 0;
    private int lGN = 0;
    protected boolean lGO;
    protected boolean lGP;
    protected float lGQ = 1.0f;
    private PaintFlagsDrawFilter lGR = new PaintFlagsDrawFilter(0, 3);
    private Rect rect = new Rect();
    protected String tag;

    public interface a {
        Bitmap a(String str, int i, int i2, int i3);

        void a(h hVar);

        Bitmap bg(String str);

        Bitmap bh(String str);

        Bitmap od();
    }

    static {
        Paint paint = new Paint();
        cnN = paint;
        paint.setAntiAlias(true);
        cnN.setFilterBitmap(true);
    }

    public h(a aVar, String str) {
        super(aVar.od());
        this.evR.setStyle(Style.STROKE);
        this.evR.setFlags(1);
        this.evR.setAntiAlias(true);
        this.fIP = new Path();
        this.cnQ = new Runnable(this) {
            final /* synthetic */ h lGS;

            {
                this.lGS = r1;
            }

            public final void run() {
                this.lGS.invalidateSelf();
            }
        };
        this.hXG = aVar;
        this.tag = str;
        this.hXG.a(this);
    }

    public h(a aVar, String str, boolean z) {
        super(aVar.od());
        this.evR.setStyle(Style.STROKE);
        this.evR.setFlags(1);
        this.evR.setAntiAlias(true);
        this.fIP = new Path();
        this.cnQ = /* anonymous class already generated */;
        this.lGK = false;
        this.hXG = aVar;
        this.tag = str;
        this.hXG.a(this);
    }

    public final void Ho(String str) {
        if (str != null && str.length() > 0 && !str.equals(this.tag)) {
            this.tag = str;
            cnO.post(this.cnQ);
        }
    }

    public final void hS(boolean z) {
        this.lGL = z;
    }

    public void draw(Canvas canvas) {
        Bitmap a;
        if (this.lGL) {
            a = this.hXG.a(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.lGO) {
            a = this.hXG.bh(this.tag);
        } else {
            a = this.hXG.bg(this.tag);
        }
        if (a == null || a.isRecycled()) {
            a = this.hXG.od();
            if (this.lGO) {
                this.lGP = true;
            } else {
                this.lGP = false;
            }
        } else {
            this.lGP = false;
        }
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.lGQ > 1.0f || this.lGK) {
            int height = (a.getHeight() / 15) / 2;
            int width = (a.getWidth() / 15) / 2;
            rect = new Rect(width, height, a.getWidth() - width, a.getHeight() - height);
        }
        canvas.drawBitmap(a, rect, bounds, cnN);
    }

    public void gM(String str) {
        if (str != null && str.equals(this.tag)) {
            v.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
            cnO.post(this.cnQ);
        }
    }

    public final void boA() {
        this.lGO = true;
    }

    public final void boB() {
        if (this.lGO) {
            this.lGO = false;
            if (this.lGP) {
                this.lGP = false;
                invalidateSelf();
            }
        }
    }

    public void onScrollStateChanged(boolean z) {
        if (z) {
            this.lGO = true;
        } else {
            boB();
        }
    }
}
