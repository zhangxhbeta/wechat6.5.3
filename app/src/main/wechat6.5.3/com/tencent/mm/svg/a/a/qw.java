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

public final class qw extends c {
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
                c = c.a(c, 1.0f, 0.0f, -143.0f, 0.0f, 1.0f, -137.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 143.0f, 0.0f, 1.0f, 137.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(89.0f, 16.0f);
                h.cubicTo(110.125465f, 35.878956f, 110.125465f, 69.11978f, 89.0f, 89.0f);
                h.cubicTo(69.12007f, 110.1255f, 35.87951f, 110.1255f, 16.0f, 89.0f);
                h.cubicTo(-5.125885f, 69.11978f, -5.125885f, 35.878956f, 16.0f, 16.0f);
                h.cubicTo(35.877827f, -5.125084f, 69.12007f, -5.125084f, 89.0f, 16.0f);
                h.close();
                h.moveTo(97.0f, 54.0f);
                h.cubicTo(97.0f, 77.076546f, 77.076546f, 97.0f, 51.0f, 97.0f);
                h.cubicTo(27.923456f, 97.0f, 8.0f, 77.076546f, 8.0f, 54.0f);
                h.cubicTo(8.0f, 27.923456f, 27.922266f, 8.0f, 54.0f, 8.0f);
                h.cubicTo(77.076546f, 8.0f, 97.0f, 27.923456f, 97.0f, 54.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(79.0f, 46.0f);
                h2.lineTo(67.0f, 36.0f);
                h2.lineTo(41.0f, 36.0f);
                h2.lineTo(29.0f, 46.0f);
                h2.lineTo(53.0f, 72.0f);
                h2.lineTo(79.0f, 46.0f);
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
