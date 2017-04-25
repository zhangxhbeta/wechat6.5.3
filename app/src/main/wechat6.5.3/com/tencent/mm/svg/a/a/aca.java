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

public final class aca extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-3487030);
                float[] a2 = c.a(c, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(8.017665f, 0.03940962f);
                h.cubicTo(20.378649f, 0.07937061f, 32.73963f, -0.030522123f, 45.09063f, 0.08936086f);
                h.cubicTo(48.675114f, 0.07937061f, 51.930107f, 3.306221f, 51.900154f, 6.9027104f);
                h.cubicTo(52.079876f, 18.591301f, 51.85023f, 30.289883f, 52.0f, 41.988464f);
                h.cubicTo(45.999233f, 41.998455f, 39.98848f, 42.008446f, 33.987713f, 41.988464f);
                h.lineTo(33.987713f, 36.004307f);
                h.cubicTo(36.643623f, 36.014294f, 39.309525f, 35.994316f, 41.97542f, 36.004307f);
                h.lineTo(41.97542f, 26.014057f);
                h.cubicTo(39.309525f, 26.024046f, 36.63364f, 26.004066f, 33.967743f, 26.014057f);
                h.cubicTo(33.967743f, 23.996027f, 33.89785f, 21.958015f, 34.15745f, 19.949976f);
                h.cubicTo(35.725037f, 17.262598f, 39.40937f, 18.301584f, 41.97542f, 17.961916f);
                h.lineTo(41.97542f, 8.041599f);
                h.cubicTo(36.883255f, 8.301346f, 30.832565f, 6.8527594f, 26.698925f, 10.659044f);
                h.cubicTo(22.53533f, 14.655144f, 24.402458f, 20.909039f, 24.013058f, 26.014057f);
                h.lineTo(18.01229f, 26.014057f);
                h.lineTo(18.01229f, 36.004307f);
                h.lineTo(24.003073f, 36.004307f);
                h.cubicTo(24.003073f, 38.002354f, 23.993088f, 39.990414f, 24.003073f, 41.988464f);
                h.cubicTo(16.005377f, 41.998455f, 7.997696f, 41.998455f, 0.0f, 41.988464f);
                h.cubicTo(0.1298003f, 30.319853f, -0.059907835f, 18.641253f, 0.07987711f, 6.9726424f);
                h.cubicTo(0.03993856f, 2.8966208f, 4.033794f, -0.40016133f, 8.017665f, 0.03940962f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                c = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 42.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(24.0f, 0.0f);
                h.lineTo(24.0f, 9.9562645f);
                h.cubicTo(17.728153f, 9.787177f, 11.426486f, 10.294439f, 5.184457f, 9.707606f);
                h.cubicTo(0.9899726f, 8.543887f, -0.42144164f, 3.908903f, 0.1053538f, 0.0f);
                h.cubicTo(8.066923f, 0.00994632f, 16.038431f, 0.00994632f, 24.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(34.0f, 0.0f);
                h.cubicTo(39.962635f, 0.01989363f, 45.93519f, 0.00994682f, 51.897823f, 0.0f);
                h.cubicTo(52.403805f, 3.879258f, 51.074368f, 8.474687f, 46.92731f, 9.678251f);
                h.cubicTo(42.651276f, 10.294953f, 38.305798f, 9.80756f, 34.0f, 9.956762f);
                h.lineTo(34.0f, 0.0f);
                h.lineTo(34.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
