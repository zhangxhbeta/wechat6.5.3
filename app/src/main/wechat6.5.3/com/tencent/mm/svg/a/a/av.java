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

public final class av extends c {
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
                h2.moveTo(121.2f, 114.02628f);
                h2.cubicTo(114.79987f, 113.84735f, 109.2f, 117.62628f, 109.2f, 123.62628f);
                h2.cubicTo(109.2f, 129.62628f, 114.79987f, 132.0105f, 121.2f, 132.02628f);
                h2.cubicTo(120.070335f, 132.0105f, 124.8f, 132.02628f, 124.8f, 132.02628f);
                h2.cubicTo(131.00111f, 132.0105f, 136.40923f, 127.2425f, 136.8f, 121.22628f);
                h2.lineTo(136.8f, 49.22628f);
                h2.lineTo(136.8f, 42.026283f);
                h2.cubicTo(136.8f, 39.42614f, 135.34097f, 38.200985f, 133.2f, 38.42628f);
                h2.lineTo(60.0f, 49.22628f);
                h2.cubicTo(57.178402f, 49.530968f, 55.72174f, 51.176342f, 56.4f, 52.826283f);
                h2.lineTo(56.4f, 60.026283f);
                h2.lineTo(56.4f, 117.62628f);
                h2.cubicTo(55.72174f, 118.12103f, 55.651085f, 123.463135f, 49.2f, 123.62628f);
                h2.cubicTo(47.17411f, 123.46318f, 45.35031f, 123.46317f, 45.6f, 123.62628f);
                h2.cubicTo(40.16959f, 123.463135f, 36.0f, 127.52909f, 36.0f, 132.02628f);
                h2.cubicTo(36.0f, 137.56032f, 40.16959f, 141.62628f, 45.6f, 141.62628f);
                h2.lineTo(49.2f, 141.62628f);
                h2.cubicTo(56.2364f, 141.62628f, 61.769886f, 136.85829f, 63.6f, 130.82628f);
                h2.lineTo(63.6f, 63.62628f);
                h2.lineTo(129.6f, 54.026283f);
                h2.lineTo(129.6f, 109.22628f);
                h2.cubicTo(130.35202f, 108.50525f, 130.28137f, 113.84735f, 124.8f, 114.02628f);
                h2.lineTo(121.2f, 114.02628f);
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
