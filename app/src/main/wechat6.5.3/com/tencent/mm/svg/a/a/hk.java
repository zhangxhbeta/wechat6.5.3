package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class hk extends c {
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
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                Paint a = c.a(g, looper);
                a.setColor(-5592406);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 6.0f);
                h2.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0f, 0.0f);
                h2.lineTo(42.0f, 0.0f);
                h2.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0f);
                h2.lineTo(48.0f, 42.0f);
                h2.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 42.0f, 48.0f);
                h2.lineTo(6.0f, 48.0f);
                h2.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 42.0f);
                h2.lineTo(0.0f, 6.0f);
                h2.lineTo(0.0f, 6.0f);
                h2.close();
                h2.moveTo(3.0f, 5.0f);
                h2.cubicTo(3.0f, 3.9389288f, 3.936117f, 3.0f, 5.0f, 3.0f);
                h2.lineTo(43.0f, 3.0f);
                h2.cubicTo(44.06107f, 3.0f, 45.0f, 3.936117f, 45.0f, 5.0f);
                h2.lineTo(45.0f, 43.0f);
                h2.cubicTo(45.0f, 44.06107f, 44.063885f, 45.0f, 43.0f, 45.0f);
                h2.lineTo(5.0f, 45.0f);
                h2.cubicTo(3.9389288f, 45.0f, 3.0f, 44.063885f, 3.0f, 43.0f);
                h2.lineTo(3.0f, 5.0f);
                h2.lineTo(3.0f, 5.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
