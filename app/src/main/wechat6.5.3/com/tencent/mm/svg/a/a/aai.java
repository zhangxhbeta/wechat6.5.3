package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aai extends c {
    private final int height = 9;
    private final int width = 39;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 9;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
                Paint g = c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-2565928);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(9.0f, 0.0f);
                h.lineTo(9.0f, 9.0f);
                h.lineTo(0.0f, 9.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-2565928);
                h = c.h(looper);
                h.moveTo(15.0f, 0.0f);
                h.lineTo(24.0f, 0.0f);
                h.lineTo(24.0f, 9.0f);
                h.lineTo(15.0f, 9.0f);
                h.lineTo(15.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-2565928);
                Path h2 = c.h(looper);
                h2.moveTo(30.0f, 0.0f);
                h2.lineTo(39.0f, 0.0f);
                h2.lineTo(39.0f, 9.0f);
                h2.lineTo(30.0f, 9.0f);
                h2.lineTo(30.0f, 0.0f);
                h2.close();
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
