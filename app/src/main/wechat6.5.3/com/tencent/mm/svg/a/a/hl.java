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

public final class hl extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(60.0f, 0.0f);
                h.lineTo(60.0f, 60.0f);
                h.lineTo(0.0f, 60.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                g = c.a(g, looper);
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h2 = c.h(looper);
                h2.moveTo(6.0f, 12.0f);
                h2.cubicTo(6.0f, 8.689151f, 8.683541f, 6.0f, 12.0f, 6.0f);
                h2.lineTo(48.0f, 6.0f);
                h2.cubicTo(51.31085f, 6.0f, 54.0f, 8.683541f, 54.0f, 12.0f);
                h2.lineTo(54.0f, 48.0f);
                h2.cubicTo(54.0f, 51.31085f, 51.31646f, 54.0f, 48.0f, 54.0f);
                h2.lineTo(12.0f, 54.0f);
                h2.cubicTo(8.689151f, 54.0f, 6.0f, 51.31646f, 6.0f, 48.0f);
                h2.lineTo(6.0f, 12.0f);
                h2.lineTo(6.0f, 12.0f);
                h2.close();
                h2.moveTo(9.0f, 11.0f);
                h2.cubicTo(9.0f, 9.938929f, 9.936117f, 9.0f, 11.0f, 9.0f);
                h2.lineTo(49.0f, 9.0f);
                h2.cubicTo(50.06107f, 9.0f, 51.0f, 9.936117f, 51.0f, 11.0f);
                h2.lineTo(51.0f, 49.0f);
                h2.cubicTo(51.0f, 50.06107f, 50.063885f, 51.0f, 49.0f, 51.0f);
                h2.lineTo(11.0f, 51.0f);
                h2.cubicTo(9.938929f, 51.0f, 9.0f, 50.063885f, 9.0f, 49.0f);
                h2.lineTo(9.0f, 11.0f);
                h2.lineTo(9.0f, 11.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
