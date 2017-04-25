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

public final class x extends c {
    private final int height = 57;
    private final int width = 57;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 57;
            case 1:
                return 57;
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
                c = c.a(c, 1.0f, 0.0f, -9.0f, 0.0f, 1.0f, -10.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, 0.70710677f, 0.70710677f, -16.991314f, -0.70710677f, 0.70710677f, 40.313557f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(43.16711f, 52.7369f);
                h.cubicTo(54.452175f, 51.26688f, 63.16711f, 41.61657f, 63.16711f, 29.93078f);
                h.cubicTo(63.16711f, 17.228231f, 52.86966f, 6.930781f, 40.16711f, 6.930781f);
                h.cubicTo(27.46456f, 6.930781f, 17.167109f, 17.228231f, 17.167109f, 29.93078f);
                h.cubicTo(17.167109f, 41.61657f, 25.882044f, 51.26688f, 37.16711f, 52.7369f);
                h.lineTo(37.16711f, 73.40037f);
                h.cubicTo(37.16711f, 73.954346f, 37.618084f, 74.403435f, 38.157887f, 74.403435f);
                h.lineTo(42.17633f, 74.403435f);
                h.cubicTo(42.723522f, 74.403435f, 43.16711f, 73.964516f, 43.16711f, 73.40037f);
                h.lineTo(43.16711f, 52.7369f);
                h.lineTo(43.16711f, 52.7369f);
                h.close();
                h.moveTo(40.16711f, 46.930782f);
                h.cubicTo(49.55595f, 46.930782f, 57.16711f, 39.319622f, 57.16711f, 29.93078f);
                h.cubicTo(57.16711f, 20.54194f, 49.55595f, 12.93078f, 40.16711f, 12.93078f);
                h.cubicTo(30.778269f, 12.93078f, 23.167109f, 20.54194f, 23.167109f, 29.93078f);
                h.cubicTo(23.167109f, 39.319622f, 30.778269f, 46.930782f, 40.16711f, 46.930782f);
                h.lineTo(40.16711f, 46.930782f);
                h.lineTo(40.16711f, 46.930782f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
