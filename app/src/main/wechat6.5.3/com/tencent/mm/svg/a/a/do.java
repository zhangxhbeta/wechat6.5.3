package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class do extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                Paint a = c.a(g, looper);
                a.setColor(-5592406);
                c = c.a(c, 1.0f, 0.0f, -154.0f, 0.0f, 1.0f, -132.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -3.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 160.0f, 0.0f, 1.0f, 141.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 6.0063868f);
                h.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0063868f, 0.0f);
                h.lineTo(41.993614f, 0.0f);
                h.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0063868f);
                h.lineTo(48.0f, 41.993614f);
                h.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 41.993614f, 48.0f);
                h.lineTo(6.0063868f, 48.0f);
                h.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 41.993614f);
                h.lineTo(0.0f, 6.0063868f);
                h.lineTo(0.0f, 6.0063868f);
                h.close();
                h.moveTo(4.0f, 5.9972916f);
                h.cubicTo(4.0f, 4.894218f, 4.89154f, 4.0f, 5.9972916f, 4.0f);
                h.lineTo(42.00271f, 4.0f);
                h.cubicTo(43.10578f, 4.0f, 44.0f, 4.89154f, 44.0f, 5.9972916f);
                h.lineTo(44.0f, 42.00271f);
                h.cubicTo(44.0f, 43.10578f, 43.10846f, 44.0f, 42.00271f, 44.0f);
                h.lineTo(5.9972916f, 44.0f);
                h.cubicTo(4.894218f, 44.0f, 4.0f, 43.10846f, 4.0f, 42.00271f);
                h.lineTo(4.0f, 5.9972916f);
                h.lineTo(4.0f, 5.9972916f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
