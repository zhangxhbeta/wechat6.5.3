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

public final class aax extends c {
    private final int height = 20;
    private final int width = 40;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 20;
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
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(18.736526f, 15.312118f);
                h.cubicTo(18.68855f, 15.287715f, 18.641708f, 15.259116f, 18.596445f, 15.226229f);
                h.lineTo(0.76661897f, 2.2721026f);
                h.cubicTo(0.31868246f, 1.9466575f, 0.21645539f, 1.3237382f, 0.5433434f, 0.87381536f);
                h.cubicTo(0.86796826f, 0.42700762f, 1.4962001f, 0.33003822f, 1.9398534f, 0.6523712f);
                h.lineTo(19.354612f, 13.3049345f);
                h.lineTo(19.457281f, 13.379528f);
                h.lineTo(19.457281f, 13.379528f);
                h.lineTo(19.559952f, 13.3049345f);
                h.lineTo(36.97471f, 0.6523712f);
                h.cubicTo(37.41836f, 0.33003822f, 38.046597f, 0.42700762f, 38.37122f, 0.87381536f);
                h.cubicTo(38.69811f, 1.3237382f, 38.595882f, 1.9466575f, 38.147945f, 2.2721026f);
                h.lineTo(20.623741f, 15.004182f);
                h.lineTo(19.49353f, 15.865662f);
                h.lineTo(18.736526f, 15.312118f);
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
