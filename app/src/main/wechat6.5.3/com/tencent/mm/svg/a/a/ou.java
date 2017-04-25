package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ou extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                a.setColor(-8744017);
                Path h = c.h(looper);
                h.moveTo(30.430653f, 34.178318f);
                h.cubicTo(27.249908f, 36.57749f, 23.291077f, 38.0f, 19.0f, 38.0f);
                h.cubicTo(8.50659f, 38.0f, 0.0f, 29.49341f, 0.0f, 19.0f);
                h.cubicTo(0.0f, 8.50659f, 8.50659f, 0.0f, 19.0f, 0.0f);
                h.cubicTo(29.49341f, 0.0f, 38.0f, 8.50659f, 38.0f, 19.0f);
                h.cubicTo(38.0f, 23.291077f, 36.57749f, 27.249908f, 34.178318f, 30.430653f);
                h.lineTo(45.619164f, 41.8715f);
                h.lineTo(41.8715f, 45.619164f);
                h.lineTo(30.430653f, 34.178318f);
                h.close();
                h.moveTo(27.062714f, 30.44662f);
                h.cubicTo(24.783264f, 32.055153f, 22.001972f, 33.0f, 19.0f, 33.0f);
                h.cubicTo(11.268014f, 33.0f, 5.0f, 26.731987f, 5.0f, 19.0f);
                h.cubicTo(5.0f, 11.268014f, 11.268014f, 5.0f, 19.0f, 5.0f);
                h.cubicTo(26.731987f, 5.0f, 33.0f, 11.268014f, 33.0f, 19.0f);
                h.cubicTo(33.0f, 22.001972f, 32.055153f, 24.783264f, 30.44662f, 27.062714f);
                h.lineTo(27.062714f, 30.44662f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
