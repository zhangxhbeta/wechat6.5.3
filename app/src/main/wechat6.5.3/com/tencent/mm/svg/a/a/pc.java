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

public final class pc extends c {
    private final int height = 30;
    private final int width = 55;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 55;
            case 1:
                return 30;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(30.0f, 0.0f);
                h.cubicTo(32.20914f, 0.0f, 34.0f, 1.7908609f, 34.0f, 4.0f);
                h.lineTo(34.0f, 26.0f);
                h.cubicTo(34.0f, 28.209139f, 32.20914f, 30.0f, 30.0f, 30.0f);
                h.lineTo(4.0f, 30.0f);
                h.cubicTo(1.7908609f, 30.0f, 0.0f, 28.209139f, 0.0f, 26.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(38.71698f, 13.0f);
                h.cubicTo(43.57647f, 8.820671f, 48.100197f, 4.1560574f, 54.0f, 1.0f);
                h.cubicTo(54.131836f, 10.646817f, 54.07152f, 20.353184f, 54.0f, 30.0f);
                h.lineTo(52.981133f, 30.0f);
                h.cubicTo(47.165295f, 25.652977f, 41.495552f, 21.266256f, 35.660378f, 17.0f);
                h.cubicTo(34.679802f, 14.844969f, 37.29351f, 13.584531f, 38.71698f, 13.0f);
                h.lineTo(38.71698f, 13.0f);
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
