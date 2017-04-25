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

public final class qy extends c {
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
                c = c.a(c, 1.0f, 0.0f, -257.0f, 0.0f, 1.0f, -137.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 259.0f, 0.0f, 1.0f, 151.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(4.0f, 0.0f);
                h.cubicTo(2.511144f, 0.0f, 0.0f, 2.6525173f, 0.0f, 6.0f);
                h.lineTo(0.0f, 71.0f);
                h.cubicTo(0.0f, 74.34748f, 2.511144f, 77.0f, 4.0f, 77.0f);
                h.lineTo(97.0f, 77.0f);
                h.cubicTo(98.487595f, 77.0f, 101.0f, 74.34748f, 101.0f, 71.0f);
                h.lineTo(101.0f, 6.0f);
                h.cubicTo(101.0f, 2.6525173f, 98.487595f, 0.0f, 97.0f, 0.0f);
                h.lineTo(4.0f, 0.0f);
                h.close();
                h.moveTo(11.046512f, 7.0f);
                h.cubicTo(9.163065f, 7.0f, 7.0f, 9.170241f, 7.0f, 11.064516f);
                h.lineTo(7.0f, 65.935486f);
                h.cubicTo(7.0f, 67.82976f, 9.163065f, 70.0f, 11.046512f, 70.0f);
                h.lineTo(89.95349f, 70.0f);
                h.cubicTo(91.835846f, 70.0f, 94.0f, 67.82976f, 94.0f, 65.935486f);
                h.lineTo(94.0f, 11.064516f);
                h.cubicTo(94.0f, 9.170241f, 91.835846f, 7.0f, 89.95349f, 7.0f);
                h.lineTo(11.046512f, 7.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(15.0f, 21.0f);
                h2.lineTo(86.0f, 21.0f);
                h2.lineTo(86.0f, 30.0f);
                h2.lineTo(15.0f, 30.0f);
                h2.lineTo(15.0f, 21.0f);
                h2.close();
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
