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

public final class qf extends c {
    private final int height = 342;
    private final int width = 450;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 450;
            case 1:
                return 342;
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
                canvas.saveLayerAlpha(null, 7, 4);
                g = c.a(g, looper);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(70.67984f, 150.63449f);
                h.cubicTo(67.97303f, 110.35668f, 80.40884f, 71.12603f, 108.708755f, 42.23457f);
                h.cubicTo(166.09906f, -16.355326f, 266.9981f, -10.238467f, 334.07306f, 55.896957f);
                h.cubicTo(401.14804f, 122.03238f, 408.999f, 223.14223f, 351.6087f, 281.73212f);
                h.cubicTo(320.71915f, 313.26736f, 277.22516f, 326.05713f, 233.18497f, 320.83246f);
                h.cubicTo(228.70084f, 330.40506f, 222.63911f, 339.28018f, 214.97217f, 347.10776f);
                h.cubicTo(173.24408f, 389.71017f, 99.76736f, 385.15027f, 50.85731f, 336.92297f);
                h.cubicTo(1.947269f, 288.69565f, -3.8748572f, 215.06361f, 37.85323f, 172.46121f);
                h.cubicTo(47.367443f, 162.74765f, 58.53215f, 155.48589f, 70.67984f, 150.63449f);
                h.close();
                h.moveTo(70.67984f, 150.63449f);
                h.cubicTo(73.46225f, 192.0373f, 92.244995f, 234.54659f, 126.2444f, 268.06973f);
                h.cubicTo(157.21716f, 298.60867f, 195.40207f, 316.3501f, 233.18497f, 320.83246f);
                h.cubicTo(253.10619f, 278.3053f, 241.89159f, 222.01225f, 201.96808f, 182.64603f);
                h.cubicTo(164.20978f, 145.41478f, 111.81031f, 134.20828f, 70.67984f, 150.63449f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
