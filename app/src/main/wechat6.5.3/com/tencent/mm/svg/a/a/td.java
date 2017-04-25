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

public final class td extends c {
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
                a.setColor(-10526881);
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 45.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 7.83f);
                h.cubicTo(0.89f, 2.48f, 7.3f, -0.87f, 12.02f, 2.1f);
                h.cubicTo(17.5f, 4.94f, 17.11f, 13.88f, 11.39f, 16.23f);
                h.cubicTo(6.72f, 18.62f, 1.07f, 15.3f, 0.0f, 10.37f);
                h.lineTo(0.0f, 7.83f);
                h.lineTo(0.0f, 7.83f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(30.31f, 1.49f);
                h.cubicTo(35.95f, -0.88f, 42.51f, 5.02f, 40.75f, 10.88f);
                h.cubicTo(39.68f, 16.46f, 32.09f, 18.97f, 27.89f, 15.13f);
                h.cubicTo(23.15f, 11.55f, 24.63f, 3.24f, 30.31f, 1.49f);
                h.lineTo(30.31f, 1.49f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(50.23f, 10.86f);
                h.cubicTo(48.77f, 5.72f, 53.66f, 0.24f, 58.93f, 1.07f);
                h.cubicTo(62.53f, 1.34f, 65.02f, 4.36f, 66.0f, 7.62f);
                h.lineTo(66.0f, 10.09f);
                h.cubicTo(65.21f, 12.6f, 63.97f, 15.24f, 61.35f, 16.25f);
                h.cubicTo(56.99f, 18.45f, 51.22f, 15.61f, 50.23f, 10.86f);
                h.lineTo(50.23f, 10.86f);
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
