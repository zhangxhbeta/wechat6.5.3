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

public final class te extends c {
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
                a.setColor(-12632257);
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 45.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(4.01f, 2.09f);
                h.cubicTo(8.12f, -0.49f, 14.14f, 1.78f, 15.55f, 6.41f);
                h.cubicTo(17.46f, 11.32f, 13.29f, 17.17f, 8.03f, 16.99f);
                h.cubicTo(4.07f, 17.15f, 1.01f, 13.98f, 0.0f, 10.38f);
                h.lineTo(0.0f, 7.82f);
                h.cubicTo(0.82f, 5.62f, 1.75f, 3.18f, 4.01f, 2.09f);
                h.lineTo(4.01f, 2.09f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(30.32f, 1.48f);
                h.cubicTo(35.94f, -0.86f, 42.46f, 4.98f, 40.77f, 10.82f);
                h.cubicTo(39.73f, 16.46f, 32.05f, 19.0f, 27.84f, 15.09f);
                h.cubicTo(23.14f, 11.47f, 24.67f, 3.21f, 30.32f, 1.48f);
                h.lineTo(30.32f, 1.48f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(50.0f, 9.01f);
                h.cubicTo(49.85f, 4.09f, 54.96f, -0.04f, 59.74f, 1.21f);
                h.cubicTo(63.02f, 1.76f, 65.01f, 4.65f, 66.0f, 7.6f);
                h.lineTo(66.0f, 10.11f);
                h.cubicTo(65.19f, 12.9f, 63.56f, 15.73f, 60.57f, 16.56f);
                h.cubicTo(55.65f, 18.47f, 49.83f, 14.26f, 50.0f, 9.01f);
                h.lineTo(50.0f, 9.01f);
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
