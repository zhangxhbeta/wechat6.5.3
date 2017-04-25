package com.tencent.mm.memory.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class a extends Drawable implements i {
    public static final Paint cnN;
    private static final ac cnO = new ac(Looper.getMainLooper());
    boolean DEBUG = false;
    public n cnP;
    private Runnable cnQ = new Runnable(this) {
        final /* synthetic */ a cnR;

        {
            this.cnR = r1;
        }

        public final void run() {
            v.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", this.cnR.tag);
            this.cnR.invalidateSelf();
        }
    };
    protected String tag;

    static {
        Paint paint = new Paint();
        cnN = paint;
        paint.setAntiAlias(true);
        cnN.setFilterBitmap(false);
        cnN.setColor(-1118482);
    }

    public a(String str, n nVar) {
        this.tag = str;
        this.cnP = nVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        n nVar = this.cnP;
        if (nVar == null || nVar.isRecycled()) {
            canvas.drawColor(-1118482);
            return;
        }
        canvas.drawBitmap(nVar.bitmap, null, bounds, cnN);
    }

    public final void wi() {
        if (this.cnP != null) {
            this.cnP.wi();
        }
    }

    public final void wj() {
        if (this.cnP != null) {
            this.cnP.wj();
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        if (this.cnP == null) {
            return 0;
        }
        n nVar = this.cnP;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getWidth();
    }

    public int getIntrinsicHeight() {
        if (this.cnP == null) {
            return 0;
        }
        n nVar = this.cnP;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getHeight();
    }

    public final n wr() {
        if (this.cnP != null) {
            return this.cnP;
        }
        return null;
    }

    public String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode();
        if (this.cnP != null) {
            return str + this.cnP;
        }
        return str;
    }
}
