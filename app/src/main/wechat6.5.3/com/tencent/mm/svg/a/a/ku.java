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

public final class ku extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                g2 = c.a(g, looper);
                g2.setColor(-2565928);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(36.0f, 66.0f);
                h.cubicTo(52.568542f, 66.0f, 66.0f, 52.568542f, 66.0f, 36.0f);
                h.cubicTo(66.0f, 19.431458f, 52.568542f, 6.0f, 36.0f, 6.0f);
                h.cubicTo(19.431458f, 6.0f, 6.0f, 19.431458f, 6.0f, 36.0f);
                h.cubicTo(6.0f, 52.568542f, 19.431458f, 66.0f, 36.0f, 66.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(36.0f, 66.0f);
                h.cubicTo(52.568542f, 66.0f, 66.0f, 52.568542f, 66.0f, 36.0f);
                h.cubicTo(66.0f, 19.431458f, 52.568542f, 6.0f, 36.0f, 6.0f);
                h.cubicTo(19.431458f, 6.0f, 6.0f, 19.431458f, 6.0f, 36.0f);
                h.cubicTo(6.0f, 52.568542f, 19.431458f, 66.0f, 36.0f, 66.0f);
                h.close();
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.FILL);
                Paint g4 = c.g(looper);
                g4.setFlags(385);
                g4.setStyle(Style.STROKE);
                g3.setColor(WebView.NIGHT_MODE_COLOR);
                g4.setStrokeWidth(1.0f);
                g4.setStrokeCap(Cap.BUTT);
                g4.setStrokeJoin(Join.MITER);
                g4.setStrokeMiter(4.0f);
                g4.setPathEffect(null);
                float[] a3 = c.a(c, 66.0f, 0.0f, 6.0f, 0.0f, 66.0f, 6.0f);
                d.reset();
                d.setValues(a3);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9619, -15075}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-4819456);
                h = c.h(looper);
                h.moveTo(18.0f, 42.09661f);
                h.cubicTo(30.07f, 41.94661f, 42.14f, 41.996613f, 54.21f, 42.07661f);
                h.cubicTo(52.74f, 46.70661f, 50.15f, 51.266613f, 45.72f, 53.62661f);
                h.cubicTo(38.47f, 57.52661f, 28.39f, 56.726612f, 22.61f, 50.55661f);
                h.cubicTo(20.32f, 48.21661f, 19.13f, 45.10661f, 18.0f, 42.09661f);
                h.lineTo(18.0f, 42.09661f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-8301568);
                h = c.h(looper);
                h.moveTo(24.0f, 25.0f);
                h.cubicTo(26.209139f, 25.0f, 28.0f, 27.014719f, 28.0f, 29.5f);
                h.cubicTo(28.0f, 31.985281f, 26.209139f, 34.0f, 24.0f, 34.0f);
                h.cubicTo(21.790861f, 34.0f, 20.0f, 31.985281f, 20.0f, 29.5f);
                h.cubicTo(20.0f, 27.014719f, 21.790861f, 25.0f, 24.0f, 25.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-8301568);
                h = c.h(looper);
                h.moveTo(48.0f, 25.0f);
                h.cubicTo(50.20914f, 25.0f, 52.0f, 27.014719f, 52.0f, 29.5f);
                h.cubicTo(52.0f, 31.985281f, 50.20914f, 34.0f, 48.0f, 34.0f);
                h.cubicTo(45.79086f, 34.0f, 44.0f, 31.985281f, 44.0f, 29.5f);
                h.cubicTo(44.0f, 27.014719f, 45.79086f, 25.0f, 48.0f, 25.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
