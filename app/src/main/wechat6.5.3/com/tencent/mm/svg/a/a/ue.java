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

public final class ue extends c {
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
                a.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(30.0f, 0.0f);
                h.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                h.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                h.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                h.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1686720);
                c = c.a(c, 6.123234E-17f, 1.0f, -1.3117828f, -1.0f, 6.123234E-17f, 61.688217f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                h = c.h(looper);
                h.moveTo(36.14667f, 51.0f);
                h.cubicTo(40.93666f, 45.963642f, 43.87644f, 39.151093f, 43.87644f, 31.651924f);
                h.cubicTo(43.87644f, 24.000854f, 40.81636f, 17.064505f, 35.85333f, 12.0f);
                h.lineTo(32.543938f, 15.309392f);
                h.cubicTo(36.660168f, 19.526825f, 39.196537f, 25.293175f, 39.196537f, 31.651924f);
                h.cubicTo(39.196537f, 37.858765f, 36.779907f, 43.50117f, 32.836227f, 47.689556f);
                h.lineTo(36.14667f, 51.0f);
                h.close();
                h.moveTo(28.464663f, 43.31799f);
                h.cubicTo(31.478422f, 40.347473f, 33.34667f, 36.217873f, 33.34667f, 31.651924f);
                h.cubicTo(33.34667f, 26.934067f, 31.352043f, 22.682077f, 28.160082f, 19.693247f);
                h.lineTo(24.848375f, 23.004953f);
                h.cubicTo(27.194576f, 25.144638f, 28.666769f, 28.226358f, 28.666769f, 31.651924f);
                h.cubicTo(28.666769f, 34.925556f, 27.322275f, 37.885162f, 25.155354f, 40.008682f);
                h.lineTo(28.464663f, 43.31799f);
                h.close();
                h.moveTo(21.018442f, 35.871773f);
                h.cubicTo(22.12694f, 34.807247f, 22.816896f, 33.31016f, 22.816896f, 31.651924f);
                h.cubicTo(22.816896f, 29.841587f, 21.994562f, 28.223316f, 20.703054f, 27.150274f);
                h.lineTo(16.5f, 31.353329f);
                h.lineTo(21.018442f, 35.871773f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                float[] a2 = c.a(c, 0.70710677f, 0.70710677f, -8.70495f, -0.70710677f, 0.70710677f, 31.622213f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                Path h2 = c.h(looper);
                h2.moveTo(31.568913f, 8.3189125f);
                h2.lineTo(36.068913f, 8.3189125f);
                h2.lineTo(36.068913f, 44.318913f);
                h2.lineTo(31.568913f, 44.318913f);
                h2.lineTo(31.568913f, 8.3189125f);
                h2.close();
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(g, looper);
                a3.setColor(-1686720);
                a2 = c.a(a2, 0.70710677f, 0.70710677f, -11.485281f, -0.70710677f, 0.70710677f, 30.909903f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                h = c.h(looper);
                h.moveTo(29.568913f, 11.3189125f);
                h.lineTo(33.568913f, 11.3189125f);
                h.lineTo(33.568913f, 47.318913f);
                h.lineTo(29.568913f, 47.318913f);
                h.lineTo(29.568913f, 11.3189125f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
