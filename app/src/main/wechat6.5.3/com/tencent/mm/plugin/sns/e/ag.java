package com.tencent.mm.plugin.sns.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class ag extends a {
    int alpha = 255;
    long ghc;
    boolean ghd = false;
    private Map<String, Boolean> jmU = new HashMap();

    public ag(String str, n nVar, long j) {
        super(str, nVar);
        if (j != 0) {
            this.ghc = j;
            this.jmU.put(str, Boolean.valueOf(true));
            this.ghd = true;
        } else if (!this.jmU.containsKey(str)) {
            this.ghc = SystemClock.uptimeMillis();
            this.jmU.put(str, Boolean.valueOf(true));
            this.ghd = true;
        }
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap wn = this.cnP.wn();
        if (i.i(wn)) {
            if (this.ghd) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.ghc)) / 150.0f;
                if (this.ghc == 0) {
                    uptimeMillis = 0.0f;
                }
                if (uptimeMillis >= 1.0f) {
                    this.ghd = false;
                } else {
                    cnN.setAlpha((int) (uptimeMillis * ((float) this.alpha)));
                    canvas.drawBitmap(wn, null, bounds, cnN);
                    invalidateSelf();
                    return;
                }
            }
            cnN.setAlpha(this.alpha);
            canvas.drawBitmap(wn, null, bounds, cnN);
            return;
        }
        canvas.drawColor(-1118482);
        this.ghc = 0;
    }
}
