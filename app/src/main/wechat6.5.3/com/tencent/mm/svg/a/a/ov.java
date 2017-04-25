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

public final class ov extends c {
    private final int height = 80;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 80;
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
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(28.0f, 38.0f);
                h.cubicTo(33.522846f, 38.0f, 38.0f, 33.522846f, 38.0f, 28.0f);
                h.cubicTo(38.0f, 22.477152f, 33.522846f, 18.0f, 28.0f, 18.0f);
                h.cubicTo(22.477152f, 18.0f, 18.0f, 22.477152f, 18.0f, 28.0f);
                h.cubicTo(18.0f, 33.522846f, 22.477152f, 38.0f, 28.0f, 38.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(26.0f, 0.0f);
                h2.lineTo(30.0f, 0.0f);
                h2.lineTo(30.0f, 9.0f);
                h2.lineTo(26.0f, 9.0f);
                h2.lineTo(26.0f, 0.0f);
                h2.close();
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(26.0f, 47.0f);
                h2.lineTo(30.0f, 47.0f);
                h2.lineTo(30.0f, 56.0f);
                h2.lineTo(26.0f, 56.0f);
                h2.lineTo(26.0f, 47.0f);
                h2.close();
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(47.0f, 25.0f);
                h2.lineTo(56.0f, 25.0f);
                h2.lineTo(56.0f, 29.0f);
                h2.lineTo(47.0f, 29.0f);
                h2.lineTo(47.0f, 25.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(-1.9984014E-16f, 25.0f);
                h2.lineTo(9.0f, 25.0f);
                h2.lineTo(9.0f, 29.0f);
                h2.lineTo(-1.9984014E-16f, 29.0f);
                h2.lineTo(-1.9984014E-16f, 25.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
