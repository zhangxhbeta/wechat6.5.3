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

public final class gk extends c {
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-6118750);
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(1.0777197f, 0.738578f);
                h.cubicTo(2.1650724f, -0.2380024f, 4.146697f, -0.2770656f, 5.1730766f, 0.8069386f);
                h.cubicTo(9.786705f, 5.7386694f, 10.426922f, 13.834521f, 6.0063753f, 19.068993f);
                h.cubicTo(4.268643f, 21.139343f, 0.3358808f, 19.46939f, 0.6813948f, 16.871687f);
                h.cubicTo(1.3012875f, 14.48883f, 3.912967f, 12.809112f, 3.4455068f, 10.133282f);
                h.cubicTo(3.6284258f, 6.7250156f, -2.3875825f, 3.9612932f, 1.0777197f, 0.738578f);
                h.lineTo(1.0777197f, 0.738578f);
                h.lineTo(1.0777197f, 0.738578f);
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
