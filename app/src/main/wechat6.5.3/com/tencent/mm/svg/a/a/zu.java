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

public final class zu extends c {
    private final int height = 138;
    private final int width = 138;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 138;
            case 1:
                return 138;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -283.0f, 0.0f, 1.0f, -245.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 283.0f, 0.0f, 1.0f, 245.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                Paint a3 = c.a(g, looper);
                a3.setColor(-13917627);
                canvas.save();
                Paint a4 = c.a(a3, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 6.0f);
                h.cubicTo(0.0f, 2.6862912f, 2.6862912f, 0.0f, 6.0f, 0.0f);
                h.lineTo(132.0f, 0.0f);
                h.cubicTo(135.3137f, 0.0f, 138.0f, 2.6862912f, 138.0f, 6.0f);
                h.lineTo(138.0f, 132.0f);
                h.cubicTo(138.0f, 135.3137f, 135.3137f, 138.0f, 132.0f, 138.0f);
                h.lineTo(6.0f, 138.0f);
                h.cubicTo(2.6862912f, 138.0f, 0.0f, 135.3137f, 0.0f, 132.0f);
                h.lineTo(0.0f, 6.0f);
                h.close();
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                c = c.a(a2, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 36.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a5 = c.a(a, looper);
                a5.setColor(-1);
                a5.setStrokeWidth(6.0f);
                h = c.h(looper);
                h.moveTo(23.239437f, 34.394367f);
                h.cubicTo(27.35964f, 40.93951f, 20.518991f, 43.903023f, 17.661972f, 45.549297f);
                h.cubicTo(5.370789f, 52.541847f, 0.0f, 55.160763f, 0.0f, 58.56338f);
                h.lineTo(0.0f, 63.21127f);
                h.cubicTo(0.0f, 64.70552f, 1.1176436f, 66.0f, 2.7887323f, 66.0f);
                h.lineTo(63.21127f, 66.0f);
                h.cubicTo(64.882355f, 66.0f, 66.0f, 64.70552f, 66.0f, 63.21127f);
                h.lineTo(66.0f, 58.56338f);
                h.cubicTo(66.0f, 55.160763f, 60.62921f, 52.541847f, 48.338028f, 45.549297f);
                h.cubicTo(45.481007f, 43.903023f, 38.64036f, 40.93951f, 42.760563f, 34.394367f);
                h.cubicTo(46.419594f, 28.960619f, 49.2747f, 26.747225f, 49.267605f, 17.661972f);
                h.cubicTo(49.2747f, 9.037081f, 42.896458f, 0.0f, 33.46479f, 0.0f);
                h.cubicTo(23.103542f, 0.0f, 16.7253f, 9.037081f, 16.732395f, 17.661972f);
                h.cubicTo(16.7253f, 26.747225f, 19.580408f, 28.960619f, 23.239437f, 34.394367f);
                h.close();
                canvas.drawPath(h, a5);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(69.0f, 30.0f);
                h2.lineTo(61.5f, 30.0f);
                h2.lineTo(61.5f, 34.5f);
                h2.lineTo(69.0f, 34.5f);
                h2.lineTo(69.0f, 42.0f);
                h2.lineTo(73.5f, 42.0f);
                h2.lineTo(73.5f, 34.5f);
                h2.lineTo(81.0f, 34.5f);
                h2.lineTo(81.0f, 30.0f);
                h2.lineTo(73.5f, 30.0f);
                h2.lineTo(73.5f, 22.5f);
                h2.lineTo(69.0f, 22.5f);
                h2.lineTo(69.0f, 30.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
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
