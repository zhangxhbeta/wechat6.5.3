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

public final class zi extends c {
    private final int height = 270;
    private final int width = 270;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
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
                g.setColor(-1202386);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(130.84f, 0.0f);
                h.lineTo(137.49f, 0.0f);
                h.cubicTo(169.21f, 0.52f, 200.58f, 12.66f, 224.28f, 33.78f);
                h.cubicTo(252.31f, 58.19f, 269.23f, 94.64f, 270.0f, 131.79f);
                h.lineTo(270.0f, 137.24f);
                h.cubicTo(269.55f, 165.21f, 260.21f, 192.96f, 243.45f, 215.38f);
                h.cubicTo(219.22f, 248.49f, 179.23f, 269.26f, 138.21f, 270.0f);
                h.lineTo(131.99f, 270.0f);
                h.cubicTo(100.68f, 269.36f, 69.79f, 257.4f, 46.26f, 236.73f);
                h.cubicTo(17.95f, 212.27f, 0.75f, 175.62f, 0.0f, 138.21f);
                h.lineTo(0.0f, 132.68f);
                h.cubicTo(0.48f, 94.98f, 17.71f, 57.93f, 46.25f, 33.31f);
                h.cubicTo(69.47f, 12.83f, 99.93f, 0.99f, 130.84f, 0.0f);
                h.lineTo(130.84f, 0.0f);
                h.close();
                h.moveTo(71.0f, 135.0f);
                h.cubicTo(85.65116f, 149.34f, 100.32233f, 163.67f, 114.98349f, 178.0f);
                h.cubicTo(115.003494f, 166.66f, 114.98349f, 155.33f, 114.99349f, 144.0f);
                h.cubicTo(142.32567f, 143.99f, 169.66783f, 144.0f, 197.0f, 144.0f);
                h.lineTo(197.0f, 127.0f);
                h.lineTo(114.99349f, 127.0f);
                h.cubicTo(114.98349f, 115.33f, 115.003494f, 103.67f, 114.98349f, 92.0f);
                h.cubicTo(100.33233f, 106.34f, 85.65116f, 120.66f, 71.0f, 135.0f);
                h.lineTo(71.0f, 135.0f);
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
