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

public final class s extends c {
    private final int height = 100;
    private final int width = 100;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                c = c.a(c, 1.0f, 0.0f, -127.0f, 0.0f, 1.0f, -283.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 283.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(2113929216);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(100.0f, 0.0f);
                h.lineTo(100.0f, 100.0f);
                h.lineTo(0.0f, 100.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(50.0f, 32.0f);
                h2.cubicTo(52.761425f, 32.0f, 55.0f, 29.761423f, 55.0f, 27.0f);
                h2.cubicTo(55.0f, 24.238577f, 52.761425f, 22.0f, 50.0f, 22.0f);
                h2.cubicTo(47.238575f, 22.0f, 45.0f, 24.238577f, 45.0f, 27.0f);
                h2.cubicTo(45.0f, 29.761423f, 47.238575f, 32.0f, 50.0f, 32.0f);
                h2.close();
                h2.moveTo(50.0f, 55.0f);
                h2.cubicTo(52.761425f, 55.0f, 55.0f, 52.761425f, 55.0f, 50.0f);
                h2.cubicTo(55.0f, 47.238575f, 52.761425f, 45.0f, 50.0f, 45.0f);
                h2.cubicTo(47.238575f, 45.0f, 45.0f, 47.238575f, 45.0f, 50.0f);
                h2.cubicTo(45.0f, 52.761425f, 47.238575f, 55.0f, 50.0f, 55.0f);
                h2.close();
                h2.moveTo(50.0f, 78.0f);
                h2.cubicTo(52.761425f, 78.0f, 55.0f, 75.76142f, 55.0f, 73.0f);
                h2.cubicTo(55.0f, 70.23858f, 52.761425f, 68.0f, 50.0f, 68.0f);
                h2.cubicTo(47.238575f, 68.0f, 45.0f, 70.23858f, 45.0f, 73.0f);
                h2.cubicTo(45.0f, 75.76142f, 47.238575f, 78.0f, 50.0f, 78.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
