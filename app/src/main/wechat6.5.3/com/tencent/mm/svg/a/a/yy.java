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

public final class yy extends c {
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
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(48.5f, 80.0f);
                h.cubicTo(65.89697f, 80.0f, 80.0f, 65.89697f, 80.0f, 48.5f);
                h.cubicTo(80.0f, 31.103031f, 65.89697f, 17.0f, 48.5f, 17.0f);
                h.cubicTo(31.103031f, 17.0f, 17.0f, 31.103031f, 17.0f, 48.5f);
                h.cubicTo(17.0f, 65.89697f, 31.103031f, 80.0f, 48.5f, 80.0f);
                h.close();
                h.moveTo(44.98583f, 65.07895f);
                h.lineTo(51.87814f, 65.07895f);
                h.lineTo(51.87814f, 58.99071f);
                h.lineTo(59.04251f, 58.99071f);
                h.lineTo(59.04251f, 54.799534f);
                h.lineTo(51.87814f, 54.799534f);
                h.lineTo(51.87814f, 52.770123f);
                h.lineTo(52.5583f, 51.49071f);
                h.lineTo(59.04251f, 51.49071f);
                h.lineTo(59.04251f, 47.299534f);
                h.lineTo(54.734818f, 47.299534f);
                h.lineTo(61.763157f, 33.57895f);
                h.lineTo(54.417408f, 33.57895f);
                h.lineTo(48.568016f, 47.299534f);
                h.lineTo(42.582592f, 33.57895f);
                h.lineTo(35.236843f, 33.57895f);
                h.lineTo(42.174496f, 47.299534f);
                h.lineTo(37.866802f, 47.299534f);
                h.lineTo(37.866802f, 51.49071f);
                h.lineTo(44.351013f, 51.49071f);
                h.lineTo(44.98583f, 52.770123f);
                h.lineTo(44.98583f, 54.799534f);
                h.lineTo(37.866802f, 54.799534f);
                h.lineTo(37.866802f, 58.99071f);
                h.lineTo(44.98583f, 58.99071f);
                h.lineTo(44.98583f, 65.07895f);
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
