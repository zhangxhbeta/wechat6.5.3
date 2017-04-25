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

public final class is extends c {
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
                g2 = c.a(g, looper);
                g2.setColor(-12206054);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(28.32f, 0.0f);
                h.lineTo(31.73f, 0.0f);
                h.cubicTo(46.52f, 0.66f, 59.35f, 13.49f, 60.0f, 28.28f);
                h.lineTo(60.0f, 31.52f);
                h.cubicTo(59.48f, 46.57f, 46.27f, 59.66f, 31.21f, 60.0f);
                h.lineTo(28.74f, 60.0f);
                h.cubicTo(13.88f, 59.63f, 0.87f, 46.88f, 0.0f, 32.07f);
                h.lineTo(0.0f, 28.48f);
                h.cubicTo(0.53f, 13.59f, 13.45f, 0.64f, 28.32f, 0.0f);
                h.lineTo(28.32f, 0.0f);
                h.close();
                h.moveTo(28.0f, 12.0f);
                h.lineTo(28.0f, 28.0f);
                h.lineTo(12.0f, 28.0f);
                h.lineTo(12.0f, 32.0f);
                h.lineTo(28.0f, 32.0f);
                h.lineTo(28.0f, 48.0f);
                h.lineTo(32.0f, 48.0f);
                h.lineTo(32.0f, 32.0f);
                h.lineTo(48.0f, 32.0f);
                h.lineTo(48.0f, 28.0f);
                h.lineTo(32.0f, 28.0f);
                h.lineTo(32.0f, 12.0f);
                h.lineTo(28.0f, 12.0f);
                h.lineTo(28.0f, 12.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                float[] a2 = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                g2 = c.a(g, looper);
                Path h2 = c.h(looper);
                h2.moveTo(16.0f, 0.0f);
                h2.lineTo(20.0f, 0.0f);
                h2.lineTo(20.0f, 16.0f);
                h2.lineTo(36.0f, 16.0f);
                h2.lineTo(36.0f, 20.0f);
                h2.lineTo(20.0f, 20.0f);
                h2.lineTo(20.0f, 36.0f);
                h2.lineTo(16.0f, 36.0f);
                h2.lineTo(16.0f, 20.0f);
                h2.lineTo(0.0f, 20.0f);
                h2.lineTo(0.0f, 16.0f);
                h2.lineTo(16.0f, 16.0f);
                h2.lineTo(16.0f, 0.0f);
                h2.lineTo(16.0f, 0.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
