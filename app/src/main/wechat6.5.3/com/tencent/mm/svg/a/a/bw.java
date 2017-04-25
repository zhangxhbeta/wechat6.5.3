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

public final class bw extends c {
    private final int height = 58;
    private final int width = 58;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -58.0f, 0.0f, 1.0f, -148.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 148.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(29.0f, 58.0f);
                h.cubicTo(45.01626f, 58.0f, 58.0f, 45.01626f, 58.0f, 29.0f);
                h.cubicTo(58.0f, 12.983743f, 45.01626f, 0.0f, 29.0f, 0.0f);
                h.cubicTo(12.983743f, 0.0f, 0.0f, 12.983743f, 0.0f, 29.0f);
                h.cubicTo(0.0f, 45.01626f, 12.983743f, 58.0f, 29.0f, 58.0f);
                h.close();
                h.moveTo(29.0f, 52.0f);
                h.cubicTo(41.70255f, 52.0f, 52.0f, 41.70255f, 52.0f, 29.0f);
                h.cubicTo(52.0f, 16.297451f, 41.70255f, 6.0f, 29.0f, 6.0f);
                h.cubicTo(16.297451f, 6.0f, 6.0f, 16.297451f, 6.0f, 29.0f);
                h.cubicTo(6.0f, 41.70255f, 16.297451f, 52.0f, 29.0f, 52.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(29.974895f, 27.246653f);
                h.lineTo(29.217737f, 14.251846f);
                h.cubicTo(29.19401f, 13.844625f, 28.835377f, 13.5f, 28.417751f, 13.5f);
                h.lineTo(27.1628f, 13.5f);
                h.cubicTo(26.745947f, 13.5f, 26.387007f, 13.836613f, 26.362814f, 14.251846f);
                h.lineTo(25.53224f, 28.506634f);
                h.cubicTo(25.501184f, 29.039612f, 25.755342f, 29.50647f, 26.163542f, 29.770678f);
                h.cubicTo(26.252584f, 30.036236f, 26.42348f, 30.280165f, 26.672367f, 30.466492f);
                h.lineTo(39.0047f, 39.69901f);
                h.cubicTo(39.340405f, 39.950333f, 39.827724f, 39.897633f, 40.089073f, 39.58617f);
                h.lineTo(40.949707f, 38.56051f);
                h.cubicTo(41.212883f, 38.24687f, 41.180317f, 37.76185f, 40.872528f, 37.47302f);
                h.lineTo(29.974895f, 27.246653f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
