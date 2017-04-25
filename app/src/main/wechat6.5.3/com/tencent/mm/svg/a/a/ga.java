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

public final class ga extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(g, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(5.0f, 10.0f);
                h.cubicTo(7.7614236f, 10.0f, 10.0f, 7.7614236f, 10.0f, 5.0f);
                h.cubicTo(10.0f, 2.2385762f, 7.7614236f, 0.0f, 5.0f, 0.0f);
                h.cubicTo(2.2385762f, 0.0f, 0.0f, 2.2385762f, 0.0f, 5.0f);
                h.cubicTo(0.0f, 7.7614236f, 2.2385762f, 10.0f, 5.0f, 10.0f);
                h.close();
                h.moveTo(5.0f, 33.0f);
                h.cubicTo(7.7614236f, 33.0f, 10.0f, 30.761423f, 10.0f, 28.0f);
                h.cubicTo(10.0f, 25.238577f, 7.7614236f, 23.0f, 5.0f, 23.0f);
                h.cubicTo(2.2385762f, 23.0f, 0.0f, 25.238577f, 0.0f, 28.0f);
                h.cubicTo(0.0f, 30.761423f, 2.2385762f, 33.0f, 5.0f, 33.0f);
                h.close();
                h.moveTo(5.0f, 56.0f);
                h.cubicTo(7.7614236f, 56.0f, 10.0f, 53.761425f, 10.0f, 51.0f);
                h.cubicTo(10.0f, 48.238575f, 7.7614236f, 46.0f, 5.0f, 46.0f);
                h.cubicTo(2.2385762f, 46.0f, 0.0f, 48.238575f, 0.0f, 51.0f);
                h.cubicTo(0.0f, 53.761425f, 2.2385762f, 56.0f, 5.0f, 56.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
