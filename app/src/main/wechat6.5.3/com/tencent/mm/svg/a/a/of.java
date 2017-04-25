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

public final class of extends c {
    private final int height = 48;
    private final int width = 54;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 48;
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
                g.setColor(-7503);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(21.993774f, 38.0f);
                h.lineTo(51.00044f, 38.0f);
                h.cubicTo(52.66516f, 38.0f, 54.0f, 36.6579f, 54.0f, 35.00234f);
                h.lineTo(54.0f, 2.99766f);
                h.cubicTo(54.0f, 1.3524401f, 52.65705f, 0.0f, 51.00044f, 0.0f);
                h.lineTo(2.9995608f, 0.0f);
                h.cubicTo(1.3348389f, 0.0f, 0.0f, 1.342098f, 0.0f, 2.99766f);
                h.lineTo(0.0f, 35.00234f);
                h.cubicTo(0.0f, 36.64756f, 1.3429492f, 38.0f, 2.9995608f, 38.0f);
                h.lineTo(9.0f, 38.0f);
                h.lineTo(9.0f, 47.950085f);
                h.lineTo(21.993774f, 38.0f);
                h.close();
                h.moveTo(19.0f, 32.0f);
                h.lineTo(48.0f, 32.0f);
                h.lineTo(48.0f, 6.0f);
                h.lineTo(6.0f, 6.0f);
                h.lineTo(6.0f, 32.0f);
                h.lineTo(15.0f, 32.0f);
                h.lineTo(15.0f, 36.0f);
                h.lineTo(19.0f, 32.0f);
                h.lineTo(19.0f, 32.0f);
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
