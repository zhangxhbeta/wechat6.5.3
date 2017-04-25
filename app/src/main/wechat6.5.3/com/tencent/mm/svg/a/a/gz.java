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

public final class gz extends c {
    private final int height = 21;
    private final int width = 28;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 21;
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
                g = c.a(g, looper);
                g.setColor(-15679443);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(9.74392f, 16.81017f);
                h.cubicTo(15.2217455f, 11.2271185f, 20.549356f, 5.4915257f, 26.107296f, 0.0f);
                h.cubicTo(26.587982f, 0.4881356f, 27.529327f, 1.4745762f, 28.0f, 1.9728813f);
                h.cubicTo(22.341917f, 8.60339f, 15.872675f, 14.481356f, 10.084406f, 21.0f);
                h.cubicTo(6.679542f, 18.254238f, 3.304721f, 15.477966f, 0.0f, 12.620339f);
                h.lineTo(0.0f, 10.901695f);
                h.cubicTo(0.41058657f, 10.698305f, 1.241774f, 10.301695f, 1.6623749f, 10.098305f);
                h.cubicTo(4.346209f, 12.345762f, 7.030043f, 14.60339f, 9.74392f, 16.81017f);
                h.lineTo(9.74392f, 16.81017f);
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
