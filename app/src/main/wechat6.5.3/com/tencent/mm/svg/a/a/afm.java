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

public final class afm extends c {
    private final int height = 67;
    private final int width = 84;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 67;
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
                a.setColor(-9473160);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(33.0f, 66.0f);
                h.cubicTo(51.225395f, 66.0f, 66.0f, 51.225395f, 66.0f, 33.0f);
                h.cubicTo(66.0f, 14.774603f, 51.225395f, 0.0f, 33.0f, 0.0f);
                h.cubicTo(14.774603f, 0.0f, 0.0f, 14.774603f, 0.0f, 33.0f);
                h.cubicTo(0.0f, 51.225395f, 14.774603f, 66.0f, 33.0f, 66.0f);
                h.close();
                h.moveTo(33.0f, 63.0f);
                h.cubicTo(49.568542f, 63.0f, 63.0f, 49.568542f, 63.0f, 33.0f);
                h.cubicTo(63.0f, 16.431458f, 49.568542f, 3.0f, 33.0f, 3.0f);
                h.cubicTo(16.431458f, 3.0f, 3.0f, 16.431458f, 3.0f, 33.0f);
                h.cubicTo(3.0f, 49.568542f, 16.431458f, 63.0f, 33.0f, 63.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(25.401f, 47.627f);
                h.cubicTo(20.217f, 47.627f, 16.0f, 44.08f, 16.0f, 39.72f);
                h.cubicTo(16.0f, 35.36f, 20.217f, 31.814f, 25.401f, 31.814f);
                h.cubicTo(26.23f, 31.814f, 26.901f, 32.485f, 26.901f, 33.314f);
                h.cubicTo(26.901f, 34.142f, 26.23f, 34.814f, 25.401f, 34.814f);
                h.cubicTo(21.871f, 34.814f, 19.0f, 37.015f, 19.0f, 39.72f);
                h.cubicTo(19.0f, 42.426f, 21.871f, 44.627f, 25.401f, 44.627f);
                h.cubicTo(28.931f, 44.627f, 31.802f, 42.426f, 31.802f, 39.72f);
                h.lineTo(31.802f, 26.907f);
                h.cubicTo(31.802f, 22.547f, 36.02f, 19.0f, 41.204f, 19.0f);
                h.cubicTo(46.388f, 19.0f, 50.605f, 22.547f, 50.605f, 26.907f);
                h.cubicTo(50.605f, 31.267f, 46.388f, 34.814f, 41.204f, 34.814f);
                h.cubicTo(40.375f, 34.814f, 39.704f, 34.142f, 39.704f, 33.314f);
                h.cubicTo(39.704f, 32.485f, 40.375f, 31.814f, 41.204f, 31.814f);
                h.cubicTo(44.734f, 31.814f, 47.605f, 29.612f, 47.605f, 26.907f);
                h.cubicTo(47.605f, 24.201f, 44.734f, 22.0f, 41.204f, 22.0f);
                h.cubicTo(37.674f, 22.0f, 34.802f, 24.201f, 34.802f, 26.907f);
                h.lineTo(34.802f, 39.72f);
                h.cubicTo(34.802f, 44.08f, 30.585f, 47.627f, 25.401f, 47.627f);
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
