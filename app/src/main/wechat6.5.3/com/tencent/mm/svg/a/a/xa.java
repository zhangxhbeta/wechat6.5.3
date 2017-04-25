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

public final class xa extends c {
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
                c = c.a(c, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 39.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(3.0570092f, 20.547123f);
                h.lineTo(37.885f, 40.385174f);
                h.cubicTo(39.32787f, 41.20703f, 41.674564f, 41.20285f, 43.11009f, 40.385174f);
                h.lineTo(77.93808f, 20.547123f);
                h.cubicTo(79.38094f, 19.725264f, 79.35191f, 18.46529f, 77.860435f, 17.726551f);
                h.lineTo(43.187733f, 0.5529894f);
                h.cubicTo(41.70198f, -0.18291019f, 39.298836f, -0.18574806f, 37.807354f, 0.5529894f);
                h.lineTo(3.1346543f, 17.726551f);
                h.cubicTo(1.6489038f, 18.462452f, 1.6214863f, 19.729448f, 3.0570092f, 20.547123f);
                h.close();
                h.moveTo(45.611893f, 45.124817f);
                h.cubicTo(44.169384f, 45.93633f, 43.0f, 47.939342f, 43.0f, 49.58943f);
                h.lineTo(43.0f, 86.19463f);
                h.cubicTo(43.0f, 87.84886f, 44.158012f, 88.49412f, 45.56714f, 87.64748f);
                h.lineTo(78.43286f, 67.90081f);
                h.cubicTo(79.850655f, 67.048965f, 81.0f, 65.01293f, 81.0f, 63.366447f);
                h.lineTo(81.0f, 28.208572f);
                h.cubicTo(81.0f, 26.55616f, 79.82107f, 25.879847f, 78.38811f, 26.685984f);
                h.lineTo(45.611893f, 45.124817f);
                h.close();
                h.moveTo(35.388107f, 45.124817f);
                h.cubicTo(36.830616f, 45.93633f, 38.0f, 47.939342f, 38.0f, 49.58943f);
                h.lineTo(38.0f, 86.19463f);
                h.cubicTo(38.0f, 87.84886f, 36.841988f, 88.49412f, 35.43286f, 87.64748f);
                h.lineTo(2.5671375f, 67.90081f);
                h.cubicTo(1.1493466f, 67.048965f, 0.0f, 65.01293f, 0.0f, 63.366447f);
                h.lineTo(0.0f, 28.208572f);
                h.cubicTo(0.0f, 26.55616f, 1.1789339f, 25.879847f, 2.611894f, 26.685984f);
                h.lineTo(35.388107f, 45.124817f);
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
