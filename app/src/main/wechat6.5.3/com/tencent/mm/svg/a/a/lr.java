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

public final class lr extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                g.setColor(-831975);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(54.69f, 66.858f);
                h.lineTo(54.69f, 40.92f);
                h.lineTo(73.104f, 40.92f);
                h.cubicTo(78.45003f, 40.92f, 82.36049f, 42.02549f, 84.8355f, 44.2365f);
                h.cubicTo(87.31051f, 46.44751f, 88.548f, 49.664978f, 88.548f, 53.889f);
                h.cubicTo(88.548f, 58.11302f, 87.31051f, 61.34699f, 84.8355f, 63.591f);
                h.cubicTo(82.36049f, 65.835014f, 78.45003f, 66.924f, 73.104f, 66.858f);
                h.lineTo(54.69f, 66.858f);
                h.close();
                h.moveTo(45.0f, 33.0f);
                h.lineTo(45.0f, 103.5f);
                h.lineTo(54.405f, 103.5f);
                h.lineTo(54.405f, 74.778f);
                h.lineTo(75.987f, 74.778f);
                h.cubicTo(83.115036f, 74.844f, 88.51048f, 73.02902f, 92.1735f, 69.333f);
                h.cubicTo(95.83652f, 65.63698f, 97.668f, 60.489033f, 97.668f, 53.889f);
                h.cubicTo(97.668f, 47.288967f, 95.83652f, 42.157516f, 92.1735f, 38.4945f);
                h.cubicTo(88.51048f, 34.831482f, 83.115036f, 33.0f, 75.987f, 33.0f);
                h.lineTo(45.0f, 33.0f);
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
