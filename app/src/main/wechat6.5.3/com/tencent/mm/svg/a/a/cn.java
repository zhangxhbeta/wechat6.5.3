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

public final class cn extends c {
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
                c = c.a(c, 1.0f, 0.0f, -211.0f, 0.0f, 1.0f, -317.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 211.0f, 0.0f, 1.0f, 317.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(67.0f, 69.0f);
                h.lineTo(21.0f, 69.0f);
                h.lineTo(21.0f, 35.0f);
                h.lineTo(30.521f, 35.0f);
                h.cubicTo(31.823f, 32.063f, 33.368f, 29.769f, 35.079f, 28.0f);
                h.lineTo(17.0f, 28.0f);
                h.cubicTo(15.343f, 28.0f, 14.0f, 29.343f, 14.0f, 31.0f);
                h.lineTo(14.0f, 73.0f);
                h.cubicTo(14.0f, 74.657f, 15.343f, 76.0f, 17.0f, 76.0f);
                h.lineTo(71.0f, 76.0f);
                h.cubicTo(72.656f, 76.0f, 74.0f, 74.657f, 74.0f, 73.0f);
                h.lineTo(74.0f, 51.22f);
                h.lineTo(67.0f, 57.13f);
                h.lineTo(67.0f, 69.0f);
                h.lineTo(67.0f, 69.0f);
                h.close();
                h.moveTo(59.0f, 17.0f);
                h.lineTo(59.0f, 28.019f);
                h.cubicTo(57.325f, 28.008f, 55.583f, 28.0f, 54.0f, 28.0f);
                h.cubicTo(40.334f, 28.0f, 31.055f, 41.333f, 31.055f, 59.0f);
                h.cubicTo(35.721f, 48.16f, 40.284f, 43.0f, 59.0f, 43.0f);
                h.lineTo(59.0f, 54.0f);
                h.lineTo(73.452f, 41.848f);
                h.lineTo(74.0f, 42.357f);
                h.lineTo(74.0f, 41.386f);
                h.lineTo(81.0f, 35.5f);
                h.lineTo(59.0f, 17.0f);
                h.lineTo(59.0f, 17.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
