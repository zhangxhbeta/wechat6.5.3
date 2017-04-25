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

public final class sa extends c {
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
                a.setColor(-6710887);
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(31.405348f, 0.65705854f);
                h.cubicTo(37.56689f, -1.2034899f, 44.896828f, 0.94714403f, 48.581768f, 6.3487363f);
                h.cubicTo(51.937164f, 11.160154f, 51.617603f, 17.371986f, 51.178207f, 22.95363f);
                h.cubicTo(50.618973f, 28.435247f, 46.86413f, 32.65649f, 44.437458f, 37.357876f);
                h.cubicTo(42.91954f, 40.128693f, 44.397514f, 43.42967f, 46.874115f, 45.050144f);
                h.cubicTo(53.93442f, 49.75153f, 62.003345f, 52.94247f, 68.53438f, 58.454098f);
                h.cubicTo(71.05093f, 60.494698f, 71.190735f, 64.01574f, 70.88116f, 66.98661f);
                h.cubicTo(70.69142f, 68.817154f, 68.87392f, 70.11753f, 67.09635f, 69.97749f);
                h.cubicTo(46.364815f, 70.0075f, 25.63327f, 70.0075f, 4.9017286f, 69.97749f);
                h.cubicTo(3.1241686f, 70.12754f, 1.3166499f, 68.80715f, 1.1269103f, 66.99661f);
                h.cubicTo(0.7973627f, 64.00573f, 0.95714337f, 60.484695f, 3.4836752f, 58.43409f);
                h.cubicTo(9.82497f, 53.092514f, 17.574333f, 49.841557f, 24.55475f, 45.460266f);
                h.cubicTo(26.681831f, 44.069855f, 28.67909f, 41.70916f, 28.0899f, 38.978355f);
                h.cubicTo(27.071297f, 35.09721f, 24.04545f, 32.17635f, 22.477602f, 28.535276f);
                h.cubicTo(20.200727f, 23.713856f, 20.370495f, 18.20223f, 20.849836f, 13.020703f);
                h.cubicTo(21.468987f, 7.249002f, 25.74312f, 2.0674744f, 31.405348f, 0.65705854f);
                h.lineTo(31.405348f, 0.65705854f);
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
