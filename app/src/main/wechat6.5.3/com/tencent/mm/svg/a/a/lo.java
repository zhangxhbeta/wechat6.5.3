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

public final class lo extends c {
    private final int height = 136;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 136;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 45.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                a3.setColor(-8685189);
                Path h = c.h(looper);
                h.moveTo(22.0f, 88.0f);
                h.cubicTo(28.627419f, 88.0f, 34.0f, 90.23858f, 34.0f, 93.0f);
                h.cubicTo(34.0f, 95.76142f, 28.627419f, 98.0f, 22.0f, 98.0f);
                h.cubicTo(15.372582f, 98.0f, 10.0f, 95.76142f, 10.0f, 93.0f);
                h.cubicTo(10.0f, 90.23858f, 15.372582f, 88.0f, 22.0f, 88.0f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                Paint a4 = c.a(a, looper);
                a3.setColor(-4539718);
                a4.setColor(-6184543);
                a4.setStrokeWidth(2.0f);
                h = c.h(looper);
                h.moveTo(19.0f, 46.0f);
                h.cubicTo(19.0f, 42.68629f, 20.343145f, 40.0f, 22.0f, 40.0f);
                h.lineTo(22.0f, 40.0f);
                h.cubicTo(23.656855f, 40.0f, 25.0f, 42.68629f, 25.0f, 46.0f);
                h.lineTo(25.0f, 88.0f);
                h.cubicTo(25.0f, 91.313705f, 23.656855f, 94.0f, 22.0f, 94.0f);
                h.lineTo(22.0f, 94.0f);
                h.cubicTo(20.343145f, 94.0f, 19.0f, 91.313705f, 19.0f, 88.0f);
                h.lineTo(19.0f, 46.0f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a4 = c.a(a, looper);
                a4.setColor(-3342336);
                a4.setStrokeWidth(3.0f);
                h = c.h(looper);
                h.moveTo(22.0f, 0.0f);
                h.cubicTo(34.150265f, 0.0f, 44.0f, 9.849735f, 44.0f, 22.0f);
                h.cubicTo(44.0f, 34.150265f, 34.150265f, 44.0f, 22.0f, 44.0f);
                h.cubicTo(9.849735f, 44.0f, 0.0f, 34.150265f, 0.0f, 22.0f);
                h.cubicTo(0.0f, 9.849735f, 9.849735f, 0.0f, 22.0f, 0.0f);
                h.close();
                g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.FILL);
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.STROKE);
                g2.setColor(WebView.NIGHT_MODE_COLOR);
                g3.setStrokeWidth(1.0f);
                g3.setStrokeCap(Cap.BUTT);
                g3.setStrokeJoin(Join.MITER);
                g3.setStrokeMiter(4.0f);
                g3.setPathEffect(null);
                float[] a5 = c.a(a2, 44.0f, 0.0f, 0.0f, 0.0f, 44.0f, 0.0f);
                d.reset();
                d.setValues(a5);
                WeChatSVGRenderC2Java.setRadialGradient(a3, 0.5f, 0.26408014f, 0.6347034f, new int[]{-114367, -849912}, new float[]{0.0f, 1.0f}, d, 0);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
