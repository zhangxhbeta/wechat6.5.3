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

public final class o extends c {
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
                c = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 25.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(13.0f, 0.0f);
                h.lineTo(66.0f, 0.0f);
                h.lineTo(66.0f, 46.0f);
                h.lineTo(13.0f, 46.0f);
                h.lineTo(13.0f, 31.01f);
                h.cubicTo(8.67f, 28.09f, 4.34f, 25.18f, 0.0f, 22.26f);
                h.cubicTo(4.33f, 19.84f, 8.67f, 17.42f, 13.0f, 15.0f);
                h.lineTo(13.0f, 0.0f);
                h.lineTo(13.0f, 0.0f);
                h.close();
                h.moveTo(25.161922f, 17.534609f);
                h.cubicTo(21.36844f, 19.05981f, 20.87799f, 24.801746f, 24.291122f, 26.984877f);
                h.cubicTo(27.38396f, 29.397287f, 32.42859f, 27.234093f, 32.88901f, 23.396168f);
                h.cubicTo(33.799847f, 19.269152f, 28.915365f, 15.590726f, 25.161922f, 17.534609f);
                h.lineTo(25.161922f, 17.534609f);
                h.close();
                h.moveTo(48.078495f, 17.571182f);
                h.cubicTo(44.464924f, 19.145073f, 43.869072f, 24.668177f, 47.165493f, 26.89866f);
                h.cubicTo(50.279316f, 29.467098f, 55.536293f, 27.255924f, 55.930325f, 23.229467f);
                h.cubicTo(56.641506f, 19.067827f, 51.759342f, 15.591748f, 48.078495f, 17.571182f);
                h.lineTo(48.078495f, 17.571182f);
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
