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

public final class em extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g.setColor(-8683387);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(79.0f, 66.0f);
                h.cubicTo(79.0f, 69.816f, 77.14933f, 73.0f, 73.0f, 73.0f);
                h.lineTo(71.0f, 73.0f);
                h.cubicTo(68.790665f, 73.0f, 67.0f, 71.209335f, 67.0f, 69.0f);
                h.cubicTo(67.0f, 66.790665f, 68.790665f, 65.0f, 71.0f, 65.0f);
                h.lineTo(79.0f, 65.0f);
                h.lineTo(79.0f, 66.0f);
                h.close();
                h.moveTo(88.0f, 63.0f);
                h.lineTo(88.0f, 56.0f);
                h.lineTo(88.0f, 56.0f);
                h.lineTo(88.0f, 56.0f);
                h.lineTo(88.0f, 53.0f);
                h.cubicTo(87.62795f, 46.030872f, 82.82739f, 40.0f, 74.0f, 40.0f);
                h.cubicTo(65.76251f, 40.0f, 60.369316f, 44.77833f, 60.0f, 52.0f);
                h.lineTo(60.0f, 52.0f);
                h.lineTo(69.0f, 52.0f);
                h.cubicTo(69.03787f, 49.75115f, 70.876205f, 48.206196f, 74.0f, 48.0f);
                h.cubicTo(77.81914f, 48.206196f, 79.44887f, 50.382885f, 79.0f, 53.0f);
                h.lineTo(79.0f, 56.0f);
                h.lineTo(79.0f, 56.0f);
                h.lineTo(79.0f, 56.0f);
                h.lineTo(71.0f, 56.0f);
                h.cubicTo(64.02007f, 56.401913f, 59.0f, 61.49816f, 59.0f, 69.0f);
                h.lineTo(59.0f, 69.0f);
                h.cubicTo(59.0f, 75.9452f, 64.09324f, 80.99727f, 71.0f, 81.0f);
                h.lineTo(72.0f, 81.0f);
                h.cubicTo(75.0855f, 80.99727f, 77.94593f, 80.10591f, 80.0f, 79.0f);
                h.cubicTo(80.66957f, 80.370995f, 80.938614f, 81.0f, 81.0f, 81.0f);
                h.lineTo(89.0f, 81.0f);
                h.cubicTo(89.0f, 81.0f, 87.63159f, 77.32937f, 88.0f, 63.0f);
                h.lineTo(88.0f, 63.0f);
                h.close();
                h.moveTo(22.0f, 56.0f);
                h.lineTo(28.0f, 32.0f);
                h.lineTo(34.0f, 56.0f);
                h.lineTo(22.0f, 56.0f);
                h.close();
                h.moveTo(36.0f, 16.0f);
                h.lineTo(32.0f, 16.0f);
                h.lineTo(24.0f, 16.0f);
                h.lineTo(24.0f, 16.0f);
                h.lineTo(10.0f, 73.0f);
                h.lineTo(6.0f, 73.0f);
                h.lineTo(6.0f, 81.0f);
                h.lineTo(22.0f, 81.0f);
                h.lineTo(22.0f, 73.0f);
                h.lineTo(18.0f, 73.0f);
                h.lineTo(20.0f, 65.0f);
                h.lineTo(37.0f, 65.0f);
                h.lineTo(39.0f, 73.0f);
                h.lineTo(35.0f, 73.0f);
                h.lineTo(35.0f, 81.0f);
                h.lineTo(55.0f, 81.0f);
                h.lineTo(55.0f, 73.0f);
                h.lineTo(51.0f, 73.0f);
                h.lineTo(36.0f, 16.0f);
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
