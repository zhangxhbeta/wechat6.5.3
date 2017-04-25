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

public final class afn extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                c = c.a(c, 1.0f, 0.0f, -134.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 134.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-789517);
                Path h = c.h(looper);
                h.moveTo(0.0f, 60.0f);
                h.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                h.lineTo(60.0f, 0.0f);
                h.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                h.lineTo(120.0f, 60.0f);
                h.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                h.lineTo(60.0f, 120.0f);
                h.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                h.lineTo(0.0f, 60.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-3552823);
                h = c.h(looper);
                h.moveTo(51.0f, 61.0f);
                h.cubicTo(54.70148f, 67.45833f, 48.275417f, 70.24223f, 45.0f, 72.0f);
                h.cubicTo(34.045288f, 78.35749f, 29.0f, 80.81769f, 29.0f, 84.0f);
                h.lineTo(29.0f, 88.0f);
                h.cubicTo(29.0f, 89.78397f, 30.049908f, 91.0f, 32.0f, 91.0f);
                h.lineTo(88.0f, 91.0f);
                h.cubicTo(89.950096f, 91.0f, 91.0f, 89.78397f, 91.0f, 88.0f);
                h.lineTo(91.0f, 84.0f);
                h.cubicTo(91.0f, 80.81769f, 85.95471f, 78.35749f, 75.0f, 72.0f);
                h.cubicTo(71.72459f, 70.24223f, 65.29852f, 67.45833f, 69.0f, 61.0f);
                h.cubicTo(72.606285f, 56.20543f, 75.28835f, 54.126183f, 76.0f, 45.0f);
                h.cubicTo(75.28835f, 37.48938f, 69.29668f, 29.0f, 60.0f, 29.0f);
                h.cubicTo(50.703327f, 29.0f, 44.711647f, 37.48938f, 45.0f, 45.0f);
                h.cubicTo(44.711647f, 54.126183f, 47.393715f, 56.20543f, 51.0f, 61.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
