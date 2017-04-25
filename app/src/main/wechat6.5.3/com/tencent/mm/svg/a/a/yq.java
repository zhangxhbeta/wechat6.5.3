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

public final class yq extends c {
    private final int height = 210;
    private final int width = 210;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                a.setColor(-15724528);
                c = c.a(c, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(86.26f, 1.24f);
                h.cubicTo(108.45f, -1.53f, 131.55f, 3.55f, 150.45f, 15.53f);
                h.cubicTo(169.74f, 27.58f, 184.6f, 46.55f, 191.61f, 68.2f);
                h.cubicTo(198.68f, 89.68f, 198.0f, 113.61f, 189.69f, 134.65f);
                h.cubicTo(181.53f, 155.58f, 165.93f, 173.48f, 146.33f, 184.43f);
                h.cubicTo(126.15f, 195.89f, 101.83f, 199.69f, 79.1f, 195.13f);
                h.cubicTo(56.88f, 190.83f, 36.38f, 178.43f, 22.13f, 160.87f);
                h.cubicTo(8.8f, 144.64f, 0.92f, 124.01f, 0.11f, 103.02f);
                h.cubicTo(-1.0f, 79.99f, 6.41f, 56.69f, 20.62f, 38.53f);
                h.cubicTo(36.39f, 18.04f, 60.56f, 4.25f, 86.26f, 1.24f);
                h.lineTo(86.26f, 1.24f);
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
