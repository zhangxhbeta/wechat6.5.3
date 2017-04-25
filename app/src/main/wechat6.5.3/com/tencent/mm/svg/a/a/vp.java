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

public final class vp extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(51.362026f, 6.0f);
                h.lineTo(61.99543f, 6.0f);
                h.cubicTo(64.20043f, 6.0f, 66.0f, 7.7952905f, 66.0f, 10.009893f);
                h.lineTo(66.0f, 49.99011f);
                h.cubicTo(66.0f, 52.205948f, 64.20709f, 54.0f, 61.99543f, 54.0f);
                h.lineTo(4.0045705f, 54.0f);
                h.cubicTo(1.7995698f, 54.0f, 0.0f, 52.20471f, 0.0f, 49.99011f);
                h.lineTo(0.0f, 10.009893f);
                h.cubicTo(0.0f, 7.7940526f, 1.7929074f, 6.0f, 4.0045705f, 6.0f);
                h.lineTo(14.637975f, 6.0f);
                h.lineTo(21.0f, 0.0f);
                h.lineTo(45.0f, 0.0f);
                h.lineTo(51.362026f, 6.0f);
                h.lineTo(51.362026f, 6.0f);
                h.close();
                h.moveTo(33.0f, 48.0f);
                h.cubicTo(44.045696f, 48.0f, 53.0f, 39.045696f, 53.0f, 28.0f);
                h.cubicTo(53.0f, 16.954306f, 44.045696f, 8.0f, 33.0f, 8.0f);
                h.cubicTo(21.954306f, 8.0f, 13.0f, 16.954306f, 13.0f, 28.0f);
                h.cubicTo(13.0f, 39.045696f, 21.954306f, 48.0f, 33.0f, 48.0f);
                h.lineTo(33.0f, 48.0f);
                h.close();
                h.moveTo(33.0f, 41.0f);
                h.cubicTo(40.179703f, 41.0f, 46.0f, 35.179703f, 46.0f, 28.0f);
                h.cubicTo(46.0f, 20.8203f, 40.179703f, 15.0f, 33.0f, 15.0f);
                h.cubicTo(25.8203f, 15.0f, 20.0f, 20.8203f, 20.0f, 28.0f);
                h.cubicTo(20.0f, 35.179703f, 25.8203f, 41.0f, 33.0f, 41.0f);
                h.lineTo(33.0f, 41.0f);
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
