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

public final class kj extends c {
    private final int height = 36;
    private final int width = 20;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 36;
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
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.21f, 2.83f);
                h.cubicTo(1.15f, 1.89f, 2.09f, 0.94f, 3.03f, 0.0f);
                h.cubicTo(8.69f, 5.66f, 14.34f, 11.31f, 19.99f, 16.97f);
                h.cubicTo(14.34f, 22.63f, 8.69f, 28.29f, 3.03f, 33.94f);
                h.cubicTo(2.09f, 33.0f, 1.15f, 32.06f, 0.21f, 31.12f);
                h.cubicTo(4.91f, 26.39f, 9.64f, 21.7f, 14.33f, 16.97f);
                h.cubicTo(9.64f, 12.25f, 4.91f, 7.55f, 0.21f, 2.83f);
                h.lineTo(0.21f, 2.83f);
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
