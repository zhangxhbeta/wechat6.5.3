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

public final class qn extends c {
    private final int height = 92;
    private final int width = 92;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 92;
            case 1:
                return 92;
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
                a.setColor(-3355444);
                c = c.a(c, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(17.932604f, 2.0969148f);
                h.cubicTo(25.994081f, -0.5536036f, 35.3458f, 1.7168405f, 41.396908f, 7.6379986f);
                h.cubicTo(47.988117f, 13.789202f, 50.418564f, 23.60112f, 48.198154f, 32.24281f);
                h.cubicTo(44.57749f, 46.585617f, 34.955727f, 58.447937f, 24.993898f, 69.0f);
                h.cubicTo(17.072445f, 60.688374f, 9.661086f, 51.646606f, 4.860205f, 41.13455f);
                h.cubicTo(2.0196838f, 34.84332f, 0.079327956f, 27.781939f, 1.4495794f, 20.860584f);
                h.cubicTo(2.989862f, 12.228896f, 9.511058f, 4.6574154f, 17.932604f, 2.0969148f);
                h.lineTo(17.932604f, 2.0969148f);
                h.lineTo(17.932604f, 2.0969148f);
                h.close();
                h.moveTo(22.660744f, 14.37389f);
                h.cubicTo(16.35458f, 15.838051f, 12.456952f, 23.040936f, 14.585656f, 29.035152f);
                h.cubicTo(16.224659f, 34.636303f, 22.740694f, 38.291794f, 28.477203f, 36.57214f);
                h.cubicTo(34.683426f, 35.098152f, 38.49111f, 27.983707f, 36.442356f, 22.068104f);
                h.cubicTo(34.853325f, 16.447298f, 28.407246f, 12.781983f, 22.660744f, 14.37389f);
                h.lineTo(22.660744f, 14.37389f);
                h.lineTo(22.660744f, 14.37389f);
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
