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

public final class gw extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                g2 = c.a(g, looper);
                g2.setColor(-921103);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(136.0f, 0.0f);
                h.lineTo(136.0f, 136.0f);
                h.lineTo(0.0f, 136.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3552823);
                c = c.a(c, 1.0f, 0.0f, 29.0f, 0.0f, 1.0f, 39.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 3.004289f);
                h2.cubicTo(0.0f, 1.345066f, 1.3380457f, 0.0f, 3.0004263f, 0.0f);
                h2.lineTo(75.99957f, 0.0f);
                h2.cubicTo(77.65666f, 0.0f, 79.0f, 1.3527762f, 79.0f, 3.004289f);
                h2.lineTo(79.0f, 53.995712f);
                h2.cubicTo(79.0f, 55.654934f, 77.66196f, 57.0f, 75.99957f, 57.0f);
                h2.lineTo(3.0004263f, 57.0f);
                h2.cubicTo(1.3433366f, 57.0f, 0.0f, 55.647224f, 0.0f, 53.995712f);
                h2.lineTo(0.0f, 3.004289f);
                h2.close();
                h2.moveTo(4.0f, 4.0f);
                h2.lineTo(75.0f, 4.0f);
                h2.lineTo(75.0f, 53.0f);
                h2.lineTo(4.0f, 53.0f);
                h2.lineTo(4.0f, 4.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h3 = c.h(looper);
                h3.moveTo(60.92106f, 30.279995f);
                h3.lineTo(50.039062f, 38.768322f);
                h3.lineTo(53.85942f, 46.690155f);
                h3.lineTo(27.17777f, 22.0f);
                h3.lineTo(2.0f, 45.710293f);
                h3.lineTo(2.0f, 56.5f);
                h3.lineTo(77.96154f, 56.5f);
                h3.lineTo(77.96154f, 45.710293f);
                h3.close();
                WeChatSVGRenderC2Java.setFillType(h3, 1);
                WeChatSVGRenderC2Java.setFillType(h3, 2);
                canvas.drawPath(h3, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
