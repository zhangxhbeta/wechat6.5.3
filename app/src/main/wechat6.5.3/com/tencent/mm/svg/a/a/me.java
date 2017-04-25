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

public final class me extends c {
    private final int height = 414;
    private final int width = 690;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 690;
            case 1:
                return 414;
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
                a.setColor(-1315861);
                c = c.a(c, 1.0f, 0.0f, 225.0f, 0.0f, 1.0f, 114.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(228.0f, 119.822876f);
                h.lineTo(228.0f, 12.0f);
                h.lineTo(12.0f, 12.0f);
                h.lineTo(12.0f, 119.51874f);
                h.lineTo(80.73831f, 55.335876f);
                h.lineTo(162.56027f, 130.40851f);
                h.lineTo(150.84477f, 106.321465f);
                h.lineTo(184.2155f, 80.51195f);
                h.lineTo(228.0f, 119.822876f);
                h.lineTo(228.0f, 119.822876f);
                h.close();
                h.moveTo(5.9924946f, 0.0f);
                h.cubicTo(2.6829312f, 0.0f, 0.0f, 2.6830428f, 0.0f, 6.004041f);
                h.lineTo(0.0f, 179.99596f);
                h.cubicTo(0.0f, 183.3119f, 2.6953125f, 186.0f, 5.9924946f, 186.0f);
                h.lineTo(234.0075f, 186.0f);
                h.cubicTo(237.31706f, 186.0f, 240.0f, 183.31696f, 240.0f, 179.99596f);
                h.lineTo(240.0f, 6.004041f);
                h.cubicTo(240.0f, 2.6881008f, 237.30469f, 0.0f, 234.0075f, 0.0f);
                h.lineTo(5.9924946f, 0.0f);
                h.lineTo(5.9924946f, 0.0f);
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
