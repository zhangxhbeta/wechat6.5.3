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

public final class mh extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, -1.0f, 0.0f, 60.0f, 0.0f, -1.0f, 60.5f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-13917627);
                a.setStrokeWidth(4.0f);
                float[] a2 = c.a(c, -1.0f, 0.0f, 60.000015f, 0.0f, -1.0f, 60.935425f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(35.35716f, 0.43542495f);
                h.lineTo(56.785732f, 0.43542495f);
                h.cubicTo(58.3789f, 0.5452927f, 59.969482f, 2.058537f, 60.000015f, 3.6497107f);
                h.lineTo(60.000015f, 25.078281f);
                h.cubicTo(59.947674f, 25.86603f, 59.630722f, 26.629244f, 58.92859f, 27.22114f);
                h.lineTo(26.78573f, 59.363995f);
                h.cubicTo(25.454927f, 60.875736f, 23.409266f, 60.881596f, 22.500015f, 59.363995f);
                h.lineTo(1.0714447f, 37.935425f);
                h.cubicTo(0.37597904f, 37.257122f, -0.0028519735f, 36.97156f, 1.616716E-5f, 35.79257f);
                h.cubicTo(0.0015097802f, 35.182915f, 0.31846386f, 34.4197f, 1.0714447f, 33.64971f);
                h.lineTo(33.214302f, 1.5068536f);
                h.cubicTo(33.83854f, 0.82948375f, 34.657097f, 0.5086701f, 35.35716f, 0.43542495f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-13917627);
                c = c.a(a2, -1.0f, 0.0f, 31.0f, 0.0f, -1.0f, 90.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                h = c.h(looper);
                h.moveTo(19.0f, 45.0f);
                h.cubicTo(19.0f, 46.932777f, 17.432777f, 48.5f, 15.5f, 48.5f);
                h.cubicTo(13.567223f, 48.5f, 12.0f, 46.932777f, 12.0f, 45.0f);
                h.cubicTo(12.0f, 43.067223f, 13.567223f, 41.5f, 15.5f, 41.5f);
                h.cubicTo(17.432777f, 41.5f, 19.0f, 43.067223f, 19.0f, 45.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
