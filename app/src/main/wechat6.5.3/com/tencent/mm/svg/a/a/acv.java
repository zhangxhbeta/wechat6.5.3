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

public final class acv extends c {
    private final int height = 52;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 52;
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
                a.setColor(-4534078);
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(31.0f, 6.0f);
                h.cubicTo(32.539345f, 3.7781641f, 34.441322f, 1.8890821f, 36.0f, 0.0f);
                h.cubicTo(43.293613f, 6.9936233f, 47.35049f, 16.770628f, 47.0f, 27.0f);
                h.cubicTo(46.814297f, 36.18396f, 42.433674f, 45.40831f, 36.0f, 52.0f);
                h.cubicTo(33.69267f, 50.060677f, 31.821043f, 48.1314f, 30.0f, 46.0f);
                h.cubicTo(35.007866f, 41.29855f, 38.376797f, 34.676716f, 39.0f, 28.0f);
                h.cubicTo(39.520008f, 19.584154f, 36.30283f, 11.455072f, 31.0f, 6.0f);
                h.lineTo(31.0f, 6.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(23.0f, 13.0f);
                h.cubicTo(24.986967f, 11.330923f, 26.594074f, 9.670524f, 28.0f, 8.0f);
                h.cubicTo(33.15886f, 13.376049f, 35.837368f, 21.009834f, 35.0f, 28.0f);
                h.cubicTo(34.181564f, 34.009544f, 31.386173f, 39.031242f, 28.0f, 43.0f);
                h.cubicTo(26.116812f, 41.299103f, 24.538925f, 39.598206f, 23.0f, 38.0f);
                h.cubicTo(29.632965f, 31.40758f, 29.837507f, 19.693665f, 23.0f, 13.0f);
                h.lineTo(23.0f, 13.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(7.0f, 15.0f);
                h.cubicTo(13.824487f, 12.176701f, 21.437187f, 17.153526f, 22.0f, 24.0f);
                h.cubicTo(22.804081f, 30.548067f, 16.49841f, 36.811485f, 10.0f, 36.0f);
                h.cubicTo(3.6775446f, 35.425156f, -1.1115723f, 29.012133f, 0.0f, 23.0f);
                h.cubicTo(0.96371174f, 19.158218f, 3.7872953f, 15.866932f, 7.0f, 15.0f);
                h.lineTo(7.0f, 15.0f);
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
