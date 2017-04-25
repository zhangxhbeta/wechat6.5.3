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

public final class adh extends c {
    private final int height = 144;
    private final int width = 144;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                c = c.a(c, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(96.0f, 48.0f);
                h.cubicTo(96.0f, 21.490332f, 74.50967f, 0.0f, 48.0f, 0.0f);
                h.cubicTo(21.490332f, 0.0f, 0.0f, 21.490332f, 0.0f, 48.0f);
                h.cubicTo(0.0f, 74.50967f, 21.490332f, 96.0f, 48.0f, 96.0f);
                h.cubicTo(74.50967f, 96.0f, 96.0f, 74.50967f, 96.0f, 48.0f);
                h.close();
                h.moveTo(2.2325583f, 48.0f);
                h.cubicTo(2.2325583f, 22.72334f, 22.72334f, 2.2325583f, 48.0f, 2.2325583f);
                h.cubicTo(73.27666f, 2.2325583f, 93.76744f, 22.72334f, 93.76744f, 48.0f);
                h.cubicTo(93.76744f, 73.27666f, 73.27666f, 93.76744f, 48.0f, 93.76744f);
                h.cubicTo(22.72334f, 93.76744f, 2.2325583f, 73.27666f, 2.2325583f, 48.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(52.426956f, 73.07245f);
                h.cubicTo(58.93997f, 66.8784f, 63.0f, 58.12903f, 63.0f, 48.431385f);
                h.cubicTo(63.0f, 38.842663f, 59.030663f, 30.181034f, 52.645496f, 24.0f);
                h.lineTo(48.40217f, 28.243324f);
                h.cubicTo(53.701862f, 33.337967f, 57.0f, 40.499516f, 57.0f, 48.431385f);
                h.cubicTo(57.0f, 56.472187f, 53.61065f, 63.721367f, 48.182682f, 68.82818f);
                h.lineTo(52.426956f, 73.07245f);
                h.close();
                h.moveTo(42.522125f, 63.16762f);
                h.cubicTo(46.504047f, 59.511826f, 49.0f, 54.263084f, 49.0f, 48.431385f);
                h.cubicTo(49.0f, 42.708645f, 46.596447f, 37.547287f, 42.743767f, 33.90173f);
                h.lineTo(38.4988f, 38.146698f);
                h.cubicTo(41.266747f, 40.704395f, 43.0f, 44.36548f, 43.0f, 48.431385f);
                h.cubicTo(43.0f, 52.60631f, 41.17255f, 56.354416f, 38.273926f, 58.91942f);
                h.lineTo(42.522125f, 63.16762f);
                h.close();
                h.moveTo(33.30555f, 53.951042f);
                h.cubicTo(34.945602f, 52.669918f, 36.0f, 50.673786f, 36.0f, 48.431385f);
                h.cubicTo(36.0f, 46.298347f, 35.045944f, 44.38814f, 33.541275f, 43.104218f);
                h.lineTo(28.0f, 48.645496f);
                h.lineTo(33.30555f, 53.951042f);
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
