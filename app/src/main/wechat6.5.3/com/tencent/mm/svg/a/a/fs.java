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

public final class fs extends c {
    private final int height = MMGIFException.D_GIF_ERR_READ_FAILED;
    private final int width = MMGIFException.D_GIF_ERR_READ_FAILED;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
            case 1:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(51.0f, 102.0f);
                h.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                h.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                h.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                h.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                h.close();
                h.moveTo(51.0f, 98.0f);
                h.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                h.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                h.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                h.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(c, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                a3 = c.a(a3, 1.0f, 0.0f, 12.65625f, 0.0f, 1.0f, 21.515625f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.8785756f, 23.757034f);
                h.cubicTo(1.2973921f, 23.163979f, 1.223493f, 22.150276f, 1.7250522f, 21.477392f);
                h.lineTo(3.0639734f, 19.681114f);
                h.cubicTo(3.5603683f, 19.015158f, 4.4945054f, 18.877115f, 5.1620426f, 19.381565f);
                h.lineTo(18.21077f, 29.242313f);
                h.cubicTo(18.873106f, 29.742832f, 19.922352f, 29.727772f, 20.574799f, 29.191858f);
                h.lineTo(54.486485f, 1.3371443f);
                h.cubicTo(55.12977f, 0.8087597f, 56.12762f, 0.8442794f, 56.730663f, 1.4314854f);
                h.lineTo(57.70836f, 2.3835058f);
                h.cubicTo(58.304504f, 2.9639935f, 58.30409f, 3.9039125f, 57.71406f, 4.4764366f);
                h.lineTo(20.482594f, 40.603558f);
                h.cubicTo(19.889599f, 41.178963f, 18.940239f, 41.167206f, 18.356556f, 40.5716f);
                h.lineTo(1.8785756f, 23.757034f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
