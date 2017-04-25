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

public final class aj extends c {
    private final int height = 138;
    private final int width = 138;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 138;
            case 1:
                return 138;
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
                c = c.a(c, 1.0f, 0.0f, -79.0f, 0.0f, 1.0f, -245.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 79.0f, 0.0f, 1.0f, 245.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a = c.a(g, looper);
                a.setColor(-13917627);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 6.0f);
                h.cubicTo(0.0f, 2.6862912f, 2.6862912f, 0.0f, 6.0f, 0.0f);
                h.lineTo(132.0f, 0.0f);
                h.cubicTo(135.3137f, 0.0f, 138.0f, 2.6862912f, 138.0f, 6.0f);
                h.lineTo(138.0f, 132.0f);
                h.cubicTo(138.0f, 135.3137f, 135.3137f, 138.0f, 132.0f, 138.0f);
                h.lineTo(6.0f, 138.0f);
                h.cubicTo(2.6862912f, 138.0f, 0.0f, 135.3137f, 0.0f, 132.0f);
                h.lineTo(0.0f, 6.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1);
                h = c.h(looper);
                h.moveTo(79.607574f, 83.319565f);
                h.cubicTo(75.00237f, 87.10074f, 69.10886f, 89.37043f, 62.685215f, 89.37043f);
                h.cubicTo(47.947376f, 89.37043f, 36.0f, 77.42305f, 36.0f, 62.685215f);
                h.cubicTo(36.0f, 47.947376f, 47.947376f, 36.0f, 62.685215f, 36.0f);
                h.cubicTo(77.42305f, 36.0f, 89.37043f, 47.947376f, 89.37043f, 62.685215f);
                h.cubicTo(89.37043f, 69.10886f, 87.10074f, 75.00237f, 83.319565f, 79.607574f);
                h.lineTo(102.0f, 98.28801f);
                h.lineTo(98.28801f, 102.0f);
                h.lineTo(79.607574f, 83.319565f);
                h.close();
                h.moveTo(62.247753f, 83.24596f);
                h.cubicTo(73.84474f, 83.24596f, 83.24596f, 73.84474f, 83.24596f, 62.247753f);
                h.cubicTo(83.24596f, 50.650764f, 73.84474f, 41.24955f, 62.247753f, 41.24955f);
                h.cubicTo(50.650764f, 41.24955f, 41.24955f, 50.650764f, 41.24955f, 62.247753f);
                h.cubicTo(41.24955f, 73.84474f, 50.650764f, 83.24596f, 62.247753f, 83.24596f);
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
