package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class tc extends c {
    private final int height = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
            case 1:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
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
                a.setColor(-5460820);
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 45.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(4.65f, 1.76f);
                h.cubicTo(9.01f, -0.47f, 14.83f, 2.41f, 15.78f, 7.19f);
                h.cubicTo(17.06f, 11.98f, 12.97f, 17.14f, 8.02f, 16.99f);
                h.cubicTo(4.06f, 17.14f, 0.96f, 13.96f, 0.0f, 10.33f);
                h.lineTo(0.0f, 7.82f);
                h.cubicTo(0.8f, 5.35f, 2.09f, 2.76f, 4.65f, 1.76f);
                h.lineTo(4.65f, 1.76f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(30.29f, 1.49f);
                h.cubicTo(34.28f, -0.09f, 39.2f, 2.27f, 40.52f, 6.32f);
                h.cubicTo(42.18f, 10.54f, 39.41f, 15.74f, 35.0f, 16.73f);
                h.cubicTo(31.13f, 17.86f, 26.72f, 15.45f, 25.47f, 11.65f);
                h.cubicTo(23.92f, 7.68f, 26.28f, 2.83f, 30.29f, 1.49f);
                h.lineTo(30.29f, 1.49f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(50.23f, 10.85f);
                h.cubicTo(48.89f, 6.03f, 53.07f, 0.83f, 58.04f, 1.01f);
                h.cubicTo(61.98f, 0.89f, 65.03f, 4.05f, 66.0f, 7.66f);
                h.lineTo(66.0f, 10.07f);
                h.cubicTo(65.25f, 12.58f, 63.98f, 15.22f, 61.39f, 16.23f);
                h.cubicTo(57.03f, 18.47f, 51.21f, 15.62f, 50.23f, 10.85f);
                h.lineTo(50.23f, 10.85f);
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
