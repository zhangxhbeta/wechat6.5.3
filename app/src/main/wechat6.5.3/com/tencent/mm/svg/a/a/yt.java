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

public final class yt extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                c = c.a(c, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 8.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(6.0f, 0.0f);
                h.lineTo(6.0f, 13.0f);
                h.lineTo(19.0f, 13.0f);
                h.lineTo(19.0f, 0.0f);
                h.lineTo(25.0f, 0.0f);
                h.lineTo(25.0f, 32.0f);
                h.lineTo(19.0f, 32.0f);
                h.lineTo(19.0f, 18.0f);
                h.cubicTo(14.64f, 17.98f, 10.29f, 18.1f, 5.94f, 18.07f);
                h.cubicTo(5.95f, 22.71f, 6.03f, 27.36f, 6.0f, 32.0f);
                h.lineTo(0.0f, 32.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(31.0f, 0.0f);
                h2.lineTo(37.0f, 0.0f);
                h2.lineTo(37.0f, 5.0f);
                h2.lineTo(31.0f, 5.0f);
                h2.lineTo(31.0f, 0.0f);
                h2.lineTo(31.0f, 0.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(31.0f, 9.0f);
                h2.lineTo(37.0f, 9.0f);
                h2.lineTo(37.0f, 32.0f);
                h2.lineTo(31.0f, 32.0f);
                h2.lineTo(31.0f, 9.0f);
                h2.lineTo(31.0f, 9.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
