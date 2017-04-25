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

public final class xe extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 39.0f, 0.0f, 1.0f, 51.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(84.0f, 42.34183f);
                h.lineTo(84.0f, 6.0f);
                h.lineTo(6.0f, 6.0f);
                h.lineTo(6.0f, 40.335194f);
                h.lineTo(29.0f, 18.0f);
                h.lineTo(60.023453f, 46.799316f);
                h.lineTo(56.0f, 38.0f);
                h.lineTo(68.1287f, 27.99035f);
                h.lineTo(84.0f, 42.34183f);
                h.close();
                h.moveTo(2.994461f, 0.0f);
                h.cubicTo(1.3406659f, 0.0f, 0.0f, 1.3482827f, 0.0f, 3.007385f);
                h.lineTo(0.0f, 62.992615f);
                h.cubicTo(0.0f, 64.65355f, 1.3420956f, 66.0f, 2.994461f, 66.0f);
                h.lineTo(87.00554f, 66.0f);
                h.cubicTo(88.65933f, 66.0f, 90.0f, 64.65172f, 90.0f, 62.992615f);
                h.lineTo(90.0f, 3.007385f);
                h.cubicTo(90.0f, 1.3464521f, 88.657906f, 0.0f, 87.00554f, 0.0f);
                h.lineTo(2.994461f, 0.0f);
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
