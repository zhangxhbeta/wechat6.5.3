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

public final class mq extends c {
    private final int height = 68;
    private final int width = 68;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 68;
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
                h.moveTo(34.0f, 67.0f);
                h.cubicTo(52.225395f, 67.0f, 67.0f, 52.225395f, 67.0f, 34.0f);
                h.cubicTo(67.0f, 15.774603f, 52.225395f, 1.0f, 34.0f, 1.0f);
                h.cubicTo(15.774603f, 1.0f, 1.0f, 15.774603f, 1.0f, 34.0f);
                h.cubicTo(1.0f, 52.225395f, 15.774603f, 67.0f, 34.0f, 67.0f);
                h.close();
                h.moveTo(34.0f, 62.0f);
                h.cubicTo(49.463974f, 62.0f, 62.0f, 49.463974f, 62.0f, 34.0f);
                h.cubicTo(62.0f, 18.536028f, 49.463974f, 6.0f, 34.0f, 6.0f);
                h.cubicTo(18.536028f, 6.0f, 6.0f, 18.536028f, 6.0f, 34.0f);
                h.cubicTo(6.0f, 49.463974f, 18.536028f, 62.0f, 34.0f, 62.0f);
                h.close();
                h.moveTo(23.0f, 27.320242f);
                h.cubicTo(23.0f, 24.934238f, 24.933071f, 23.0f, 27.320242f, 23.0f);
                h.lineTo(40.679756f, 23.0f);
                h.cubicTo(43.06576f, 23.0f, 45.0f, 24.933071f, 45.0f, 27.320242f);
                h.lineTo(45.0f, 40.679756f);
                h.cubicTo(45.0f, 43.06576f, 43.06693f, 45.0f, 40.679756f, 45.0f);
                h.lineTo(27.320242f, 45.0f);
                h.cubicTo(24.934238f, 45.0f, 23.0f, 43.06693f, 23.0f, 40.679756f);
                h.lineTo(23.0f, 27.320242f);
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
