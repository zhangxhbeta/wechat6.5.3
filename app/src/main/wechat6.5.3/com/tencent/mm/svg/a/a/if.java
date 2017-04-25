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

public final class if extends c {
    private final int height = 204;
    private final int width = 264;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 264;
            case 1:
                return 204;
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
                a.setColor(-13158344);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(245.998f, 169.0001f);
                h.lineTo(152.0f, 169.0001f);
                h.lineTo(152.0f, 169.0001f);
                h.lineTo(108.0f, 169.0001f);
                h.lineTo(108.0f, 169.0001f);
                h.lineTo(14.002f, 169.0001f);
                h.cubicTo(7.936f, 169.0001f, 3.0f, 164.0641f, 3.0f, 157.9971f);
                h.lineTo(3.0f, 138.0001f);
                h.lineTo(257.0f, 138.0001f);
                h.lineTo(257.0f, 157.9971f);
                h.cubicTo(257.0f, 164.0641f, 252.064f, 169.0001f, 245.998f, 169.0001f);
                h.lineTo(245.998f, 169.0001f);
                h.close();
                h.moveTo(14.002f, 3.0001f);
                h.lineTo(245.998f, 3.0001f);
                h.cubicTo(252.064f, 3.0001f, 257.0f, 7.9361f, 257.0f, 14.0021f);
                h.lineTo(257.0f, 136.0001f);
                h.lineTo(3.0f, 136.0001f);
                h.lineTo(3.0f, 14.0021f);
                h.cubicTo(3.0f, 7.9361f, 7.936f, 3.0001f, 14.002f, 3.0001f);
                h.lineTo(14.002f, 3.0001f);
                h.close();
                h.moveTo(164.703f, 197.0001f);
                h.lineTo(95.297f, 197.0001f);
                h.lineTo(107.697f, 194.5201f);
                h.lineTo(110.634f, 172.0001f);
                h.lineTo(149.366f, 172.0001f);
                h.lineTo(152.303f, 194.5201f);
                h.lineTo(164.703f, 197.0001f);
                h.close();
                h.moveTo(245.998f, 1.0E-4f);
                h.lineTo(14.002f, 1.0E-4f);
                h.cubicTo(6.266f, 1.0E-4f, 0.0f, 6.2691f, 0.0f, 14.0021f);
                h.lineTo(0.0f, 157.9971f);
                h.cubicTo(0.0f, 165.7261f, 6.269f, 172.0001f, 14.002f, 172.0001f);
                h.lineTo(107.609f, 172.0001f);
                h.lineTo(105.0f, 192.0001f);
                h.lineTo(90.0f, 195.0001f);
                h.lineTo(90.0f, 200.0001f);
                h.lineTo(170.0f, 200.0001f);
                h.lineTo(170.0f, 195.0001f);
                h.lineTo(155.0f, 192.0001f);
                h.lineTo(152.391f, 172.0001f);
                h.lineTo(245.998f, 172.0001f);
                h.cubicTo(253.734f, 172.0001f, 260.0f, 165.7311f, 260.0f, 157.9971f);
                h.lineTo(260.0f, 14.0021f);
                h.cubicTo(260.0f, 6.2741f, 253.731f, 1.0E-4f, 245.998f, 1.0E-4f);
                h.lineTo(245.998f, 1.0E-4f);
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
