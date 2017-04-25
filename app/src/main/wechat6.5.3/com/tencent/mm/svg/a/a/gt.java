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

public final class gt extends c {
    private final int height = 56;
    private final int width = 10;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 10;
            case 1:
                return 56;
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
                a.setColor(-3684404);
                c = c.a(c, 1.0f, 0.0f, -273.0f, 0.0f, 1.0f, -165.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(278.0f, 175.0f);
                h.cubicTo(280.7614f, 175.0f, 283.0f, 172.76143f, 283.0f, 170.0f);
                h.cubicTo(283.0f, 167.23857f, 280.7614f, 165.0f, 278.0f, 165.0f);
                h.cubicTo(275.2386f, 165.0f, 273.0f, 167.23857f, 273.0f, 170.0f);
                h.cubicTo(273.0f, 172.76143f, 275.2386f, 175.0f, 278.0f, 175.0f);
                h.close();
                h.moveTo(278.0f, 198.0f);
                h.cubicTo(280.7614f, 198.0f, 283.0f, 195.76143f, 283.0f, 193.0f);
                h.cubicTo(283.0f, 190.23857f, 280.7614f, 188.0f, 278.0f, 188.0f);
                h.cubicTo(275.2386f, 188.0f, 273.0f, 190.23857f, 273.0f, 193.0f);
                h.cubicTo(273.0f, 195.76143f, 275.2386f, 198.0f, 278.0f, 198.0f);
                h.close();
                h.moveTo(278.0f, 221.0f);
                h.cubicTo(280.7614f, 221.0f, 283.0f, 218.76143f, 283.0f, 216.0f);
                h.cubicTo(283.0f, 213.23857f, 280.7614f, 211.0f, 278.0f, 211.0f);
                h.cubicTo(275.2386f, 211.0f, 273.0f, 213.23857f, 273.0f, 216.0f);
                h.cubicTo(273.0f, 218.76143f, 275.2386f, 221.0f, 278.0f, 221.0f);
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
