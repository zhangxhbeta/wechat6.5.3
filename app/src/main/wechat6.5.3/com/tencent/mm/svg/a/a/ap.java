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

public final class ap extends c {
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
                a.setColor(-11184811);
                Path h = c.h(looper);
                h.moveTo(33.0f, 23.0f);
                h.lineTo(32.0f, 23.0f);
                h.lineTo(32.0f, 23.0f);
                h.lineTo(32.0f, 4.4975147f);
                h.cubicTo(32.0f, 3.1216204f, 30.880713f, 2.0f, 29.5f, 2.0f);
                h.cubicTo(28.109663f, 2.0f, 27.0f, 3.1181755f, 27.0f, 4.4975147f);
                h.lineTo(27.0f, 23.0f);
                h.lineTo(26.0f, 23.0f);
                h.lineTo(26.0f, 2.497515f);
                h.cubicTo(26.0f, 1.1216205f, 24.880713f, -3.5527137E-15f, 23.5f, -3.5527137E-15f);
                h.cubicTo(22.109663f, -3.5527137E-15f, 21.0f, 1.1181755f, 21.0f, 2.497515f);
                h.lineTo(21.0f, 23.0f);
                h.lineTo(21.0f, 23.0f);
                h.lineTo(20.0f, 23.0f);
                h.lineTo(20.0f, 23.0f);
                h.lineTo(20.0f, 4.4976234f);
                h.cubicTo(20.0f, 3.119065f, 18.880713f, 2.0f, 17.5f, 2.0f);
                h.cubicTo(16.109663f, 2.0f, 15.0f, 3.118224f, 15.0f, 4.4976234f);
                h.lineTo(15.0f, 23.0f);
                h.lineTo(14.0f, 23.0f);
                h.lineTo(14.0f, 7.492989f);
                h.cubicTo(14.0f, 6.1171875f, 12.880712f, 5.0f, 11.5f, 5.0f);
                h.cubicTo(10.109662f, 5.0f, 9.0f, 6.1161494f, 9.0f, 7.492989f);
                h.lineTo(9.0f, 25.753506f);
                h.lineTo(9.0f, 25.753506f);
                h.lineTo(9.0f, 33.0f);
                h.lineTo(9.07604f, 33.0f);
                h.cubicTo(9.823915f, 40.30732f, 15.996335f, 46.0f, 23.5f, 46.0f);
                h.cubicTo(31.008278f, 46.0f, 37.17619f, 40.30293f, 37.923923f, 33.0f);
                h.lineTo(37.923923f, 33.0f);
                h.lineTo(38.0f, 33.0f);
                h.lineTo(38.0f, 26.245796f);
                h.lineTo(38.0f, 17.508408f);
                h.cubicTo(38.0f, 16.115417f, 36.88071f, 15.0f, 35.5f, 15.0f);
                h.cubicTo(34.10966f, 15.0f, 33.0f, 16.123053f, 33.0f, 17.508408f);
                h.lineTo(33.0f, 23.0f);
                h.lineTo(33.0f, 23.0f);
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
