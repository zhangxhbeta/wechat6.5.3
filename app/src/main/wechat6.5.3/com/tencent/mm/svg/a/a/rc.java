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

public final class rc extends c {
    private final int height = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
    private final int width = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
            case 1:
                return MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
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
                c = c.a(c, 1.0f, 0.0f, -27.0f, 0.0f, 1.0f, -137.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 27.0f, 0.0f, 1.0f, 149.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(6.0f, 0.0f);
                h.cubicTo(2.6105952f, 0.0f, 0.0f, 2.7903104f, 0.0f, 6.0f);
                h.lineTo(0.0f, 75.0f);
                h.cubicTo(0.0f, 78.20969f, 2.6105952f, 81.0f, 6.0f, 81.0f);
                h.lineTo(99.0f, 81.0f);
                h.cubicTo(102.38809f, 81.0f, 105.0f, 78.20969f, 105.0f, 75.0f);
                h.lineTo(105.0f, 6.0f);
                h.cubicTo(105.0f, 2.7903104f, 102.38809f, 0.0f, 99.0f, 0.0f);
                h.lineTo(6.0f, 0.0f);
                h.close();
                h.moveTo(29.0f, 7.0f);
                h.lineTo(11.4754095f, 7.0f);
                h.cubicTo(9.262516f, 7.0f, 7.0f, 9.308035f, 7.0f, 13.090909f);
                h.lineTo(7.0f, 28.0f);
                h.lineTo(8.513771E-15f, 28.0f);
                h.lineTo(7.1054274E-15f, 51.0f);
                h.lineTo(7.0f, 51.0f);
                h.lineTo(7.0f, 67.90909f);
                h.cubicTo(7.0f, 71.69196f, 9.262516f, 74.0f, 11.4754095f, 74.0f);
                h.lineTo(29.0f, 74.0f);
                h.lineTo(29.0f, 81.0f);
                h.lineTo(79.0f, 81.0f);
                h.lineTo(79.0f, 74.0f);
                h.lineTo(93.52459f, 74.0f);
                h.cubicTo(95.73634f, 74.0f, 98.0f, 71.69196f, 98.0f, 67.90909f);
                h.lineTo(98.0f, 51.0f);
                h.lineTo(105.0f, 51.0f);
                h.lineTo(105.0f, 28.0f);
                h.lineTo(98.0f, 28.0f);
                h.lineTo(98.0f, 13.090909f);
                h.cubicTo(98.0f, 9.308035f, 95.73634f, 7.0f, 93.52459f, 7.0f);
                h.lineTo(79.0f, 7.0f);
                h.lineTo(79.0f, 0.0f);
                h.lineTo(29.0f, 0.0f);
                h.lineTo(29.0f, 7.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(35.0f, 38.0f);
                h2.lineTo(32.0f, 43.0f);
                h2.lineTo(46.0f, 60.0f);
                h2.lineTo(76.0f, 24.0f);
                h2.lineTo(73.0f, 21.0f);
                h2.lineTo(46.0f, 47.0f);
                h2.lineTo(35.0f, 38.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
