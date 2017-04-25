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

public final class od extends c {
    private final int height = 54;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                c = c.a(c, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(6.1010113f, 2.057324f);
                h.cubicTo(12.419818f, -2.0276875f, 21.226343f, 0.35939744f, 26.002764f, 5.80275f);
                h.cubicTo(29.913458f, 1.4081168f, 36.07305f, -0.88907796f, 41.88436f, 0.33942184f);
                h.cubicTo(46.15329f, 1.198373f, 49.516685f, 4.71408f, 50.899857f, 8.769128f);
                h.cubicTo(52.929836f, 14.562054f, 52.034256f, 21.104065f, 49.168404f, 26.457527f);
                h.cubicTo(44.093456f, 36.205624f, 35.60536f, 43.86627f, 26.002764f, 49.0f);
                h.cubicTo(15.315523f, 43.22705f, 5.722878f, 34.327915f, 1.2648852f, 22.801992f);
                h.cubicTo(-1.1929812f, 15.840492f, -0.31730413f, 6.591787f, 6.1010113f, 2.057324f);
                h.lineTo(6.1010113f, 2.057324f);
                h.lineTo(6.1010113f, 2.057324f);
                h.close();
                h.moveTo(6.614176f, 11.27121f);
                h.cubicTo(5.3116097f, 15.999485f, 6.10707f, 21.24757f, 8.751974f, 25.366068f);
                h.cubicTo(13.007686f, 32.263554f, 19.450912f, 37.44166f, 26.003513f, 42.0f);
                h.cubicTo(31.064629f, 38.52127f, 35.90699f, 34.642685f, 39.924065f, 29.96439f);
                h.cubicTo(43.255054f, 26.065813f, 46.138596f, 21.297552f, 45.979504f, 15.979492f);
                h.cubicTo(46.198254f, 12.1209f, 44.686882f, 7.2526755f, 40.441113f, 6.3430076f);
                h.cubicTo(34.624313f, 4.603642f, 30.24928f, 9.891713f, 26.003513f, 12.950597f);
                h.cubicTo(21.837292f, 9.991676f, 17.651184f, 4.8135653f, 11.963644f, 6.2630367f);
                h.cubicTo(9.358513f, 6.6728873f, 7.3300896f, 8.782118f, 6.614176f, 11.27121f);
                h.lineTo(6.614176f, 11.27121f);
                h.lineTo(6.614176f, 11.27121f);
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
