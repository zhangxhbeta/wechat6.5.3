package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aq extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                g2.setColor(-12206054);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(180.0f, 0.0f);
                h.lineTo(180.0f, 180.0f);
                h.lineTo(0.0f, 180.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(120.74788f, 68.80034f);
                h2.lineTo(98.46802f, 46.520485f);
                h2.cubicTo(93.788185f, 41.840652f, 86.1861f, 41.841553f, 81.49671f, 46.530937f);
                h2.lineTo(46.530937f, 81.49671f);
                h2.cubicTo(41.838837f, 86.18881f, 41.836876f, 93.78441f, 46.520485f, 98.46802f);
                h2.lineTo(81.53198f, 133.47952f);
                h2.cubicTo(86.211815f, 138.15935f, 93.8139f, 138.15845f, 98.50329f, 133.46907f);
                h2.lineTo(133.46907f, 98.50329f);
                h2.cubicTo(138.16116f, 93.81119f, 138.16313f, 86.21559f, 133.47952f, 81.53198f);
                h2.lineTo(132.41515f, 80.467606f);
                h2.lineTo(90.010124f, 122.87262f);
                h2.lineTo(84.1765f, 117.03899f);
                h2.lineTo(62.963295f, 95.82578f);
                h2.lineTo(57.12966f, 89.99215f);
                h2.lineTo(89.99443f, 57.127384f);
                h2.lineTo(101.66169f, 68.79465f);
                h2.lineTo(80.45862f, 89.99772f);
                h2.lineTo(90.004555f, 99.54366f);
                h2.lineTo(120.74788f, 68.80034f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
