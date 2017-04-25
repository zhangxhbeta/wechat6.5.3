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

public final class aco extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                a.setColor(-12206054);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(21.72f, 0.0f);
                h.lineTo(24.06f, 0.0f);
                h.cubicTo(35.45f, 0.38f, 45.34f, 10.09f, 46.0f, 21.46f);
                h.lineTo(46.0f, 24.3f);
                h.cubicTo(45.5f, 35.7f, 35.65f, 45.5f, 24.26f, 46.0f);
                h.lineTo(21.93f, 46.0f);
                h.cubicTo(10.47f, 45.63f, 0.54f, 35.78f, 0.0f, 24.34f);
                h.lineTo(0.0f, 21.82f);
                h.cubicTo(0.44f, 10.39f, 10.3f, 0.51f, 21.72f, 0.0f);
                h.lineTo(21.72f, 0.0f);
                h.close();
                h.moveTo(17.58f, 13.59f);
                h.cubicTo(15.96f, 15.34f, 16.17f, 17.82f, 15.82f, 20.0f);
                h.lineTo(12.99f, 20.0f);
                h.cubicTo(13.0f, 24.34f, 13.0f, 28.67f, 13.0f, 33.0f);
                h.lineTo(33.0f, 33.0f);
                h.cubicTo(33.0f, 28.67f, 33.0f, 24.34f, 33.01f, 20.0f);
                h.lineTo(30.18f, 20.0f);
                h.cubicTo(29.83f, 17.83f, 30.07f, 15.34f, 28.43f, 13.6f);
                h.cubicTo(25.84f, 10.18f, 20.17f, 10.17f, 17.58f, 13.59f);
                h.lineTo(17.58f, 13.59f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(18.82f, 20.0f);
                h.cubicTo(18.8f, 17.38f, 19.71f, 13.9f, 22.99f, 14.0f);
                h.cubicTo(26.26f, 13.87f, 27.22f, 17.37f, 27.18f, 20.0f);
                h.lineTo(18.82f, 20.0f);
                h.lineTo(18.82f, 20.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                float[] a3 = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(5.58f, 2.59f);
                h.cubicTo(8.17f, -0.83f, 13.84f, -0.82f, 16.43f, 2.6f);
                h.cubicTo(18.07f, 4.34f, 17.83f, 6.83f, 18.18f, 9.0f);
                h.lineTo(21.01f, 9.0f);
                h.cubicTo(21.0f, 13.34f, 21.0f, 17.67f, 21.0f, 22.0f);
                h.lineTo(1.0f, 22.0f);
                h.cubicTo(1.0f, 17.67f, 1.0f, 13.34f, 0.99f, 9.0f);
                h.lineTo(3.82f, 9.0f);
                h.cubicTo(4.17f, 6.82f, 3.96f, 4.34f, 5.58f, 2.59f);
                h.lineTo(5.58f, 2.59f);
                h.close();
                h.moveTo(6.82f, 9.0f);
                h.lineTo(15.18f, 9.0f);
                h.cubicTo(15.22f, 6.37f, 14.26f, 2.87f, 10.99f, 3.0f);
                h.cubicTo(7.71f, 2.9f, 6.8f, 6.38f, 6.82f, 9.0f);
                h.lineTo(6.82f, 9.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
