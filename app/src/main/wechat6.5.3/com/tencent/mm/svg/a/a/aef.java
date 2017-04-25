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

public final class aef extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-12961222);
                c = c.a(c, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, 204, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.3605053f, 0.25534344f);
                h.cubicTo(3.921085f, -0.54583037f, 5.3216047f, 0.73604774f, 6.652099f, 1.3870015f);
                h.cubicTo(17.566153f, 7.8664947f, 28.590246f, 14.165724f, 39.47429f, 20.685276f);
                h.cubicTo(41.535053f, 21.50648f, 41.495037f, 24.560955f, 39.434273f, 25.352114f);
                h.cubicTo(28.110067f, 32.091988f, 16.705833f, 38.71169f, 5.331609f, 45.351414f);
                h.cubicTo(3.6209733f, 46.893677f, 0.579844f, 45.501637f, 1.0600222f, 43.108128f);
                h.cubicTo(0.94998145f, 30.379478f, 1.1000371f, 17.65083f, 1.0f, 4.922181f);
                h.cubicTo(1.140052f, 3.3398626f, 0.63986623f, 1.156664f, 2.3605053f, 0.25534344f);
                h.lineTo(2.3605053f, 0.25534344f);
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
