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

public final class lw extends c {
    private final int height = 136;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 136;
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
                a.setColor(-13917627);
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(77.408936f, 110.90397f);
                h.cubicTo(88.68352f, 100.24022f, 95.71782f, 85.1395f, 95.71782f, 68.39584f);
                h.cubicTo(95.71782f, 51.44822f, 88.5111f, 36.183815f, 76.99503f, 25.5f);
                h.lineTo(76.99503f, 25.5f);
                h.lineTo(71.68743f, 30.807606f);
                h.cubicTo(81.8482f, 40.13034f, 88.21781f, 53.519238f, 88.21781f, 68.39584f);
                h.cubicTo(88.21781f, 83.06846f, 82.02168f, 96.293884f, 72.10326f, 105.59829f);
                h.lineTo(77.408936f, 110.90397f);
                h.close();
                h.moveTo(60.427143f, 93.92218f);
                h.cubicTo(67.36365f, 87.611595f, 71.71782f, 78.51221f, 71.71782f, 68.39584f);
                h.cubicTo(71.71782f, 58.07535f, 67.18616f, 48.813286f, 60.004112f, 42.490925f);
                h.lineTo(60.004112f, 42.490925f);
                h.lineTo(54.95303f, 47.542007f);
                h.cubicTo(60.85144f, 52.563225f, 64.59281f, 60.04261f, 64.59281f, 68.39584f);
                h.cubicTo(64.59281f, 76.54479f, 61.032192f, 83.86212f, 55.38187f, 88.87691f);
                h.lineTo(60.427143f, 93.92218f);
                h.close();
                h.moveTo(44.465603f, 77.96064f);
                h.cubicTo(47.35308f, 75.76924f, 49.21782f, 72.30031f, 49.21782f, 68.39584f);
                h.cubicTo(49.21782f, 64.28535f, 47.151096f, 60.657566f, 44.0001f, 58.494938f);
                h.lineTo(44.0001f, 58.494938f);
                h.lineTo(34.5f, 67.99503f);
                h.lineTo(44.465603f, 77.96064f);
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
