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

public final class bg extends c {
    private final int height = 71;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 71;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 27.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(19.357758f, 25.260746f);
                h.lineTo(28.45082f, 25.260746f);
                h.cubicTo(34.51505f, 25.260746f, 39.44799f, 20.333082f, 39.44799f, 14.254499f);
                h.lineTo(39.44799f, 11.0062475f);
                h.cubicTo(39.44799f, 4.930493f, 34.52439f, 1.2726757E-7f, 28.45082f, 1.046543E-7f);
                h.lineTo(11.339516f, 4.0945043E-8f);
                h.cubicTo(5.2752895f, 1.8366562E-8f, 0.34234652f, 4.9276648f, 0.34234652f, 11.006247f);
                h.lineTo(0.34234652f, 14.160372f);
                h.lineTo(4.420356f, 14.160372f);
                h.cubicTo(4.3753934f, 13.817222f, 4.3521967f, 13.467262f, 4.3521967f, 13.111929f);
                h.lineTo(4.352197f, 12.010028f);
                h.cubicTo(4.352197f, 7.5904274f, 7.9322853f, 4.0076337f, 12.355284f, 4.0076337f);
                h.lineTo(27.42606f, 4.0076337f);
                h.cubicTo(31.846043f, 4.0076337f, 35.429146f, 7.593756f, 35.429146f, 12.010028f);
                h.lineTo(35.429146f, 13.111929f);
                h.cubicTo(35.429146f, 17.531528f, 31.849058f, 21.114323f, 27.42606f, 21.114323f);
                h.lineTo(19.357758f, 21.114323f);
                h.lineTo(19.357758f, 25.260746f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                c = c.a(a2, -1.0f, 0.0f, 40.0f, 0.0f, -1.0f, 26.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(19.357758f, 25.260746f);
                h.lineTo(28.45082f, 25.260746f);
                h.cubicTo(34.51505f, 25.260746f, 39.44799f, 20.333082f, 39.44799f, 14.254499f);
                h.lineTo(39.44799f, 11.0062475f);
                h.cubicTo(39.44799f, 4.930493f, 34.52439f, 1.2726757E-7f, 28.45082f, 1.046543E-7f);
                h.lineTo(11.339516f, 4.0945043E-8f);
                h.cubicTo(5.2752895f, 1.8366562E-8f, 0.34234652f, 4.9276648f, 0.34234652f, 11.006247f);
                h.lineTo(0.34234652f, 14.160372f);
                h.lineTo(4.420356f, 14.160372f);
                h.cubicTo(4.3753934f, 13.817222f, 4.3521967f, 13.467262f, 4.3521967f, 13.111929f);
                h.lineTo(4.352197f, 12.010028f);
                h.cubicTo(4.352197f, 7.5904274f, 7.9322853f, 4.0076337f, 12.355284f, 4.0076337f);
                h.lineTo(27.42606f, 4.0076337f);
                h.cubicTo(31.846043f, 4.0076337f, 35.429146f, 7.593756f, 35.429146f, 12.010028f);
                h.lineTo(35.429146f, 13.111929f);
                h.cubicTo(35.429146f, 17.531528f, 31.849058f, 21.114323f, 27.42606f, 21.114323f);
                h.lineTo(19.357758f, 21.114323f);
                h.lineTo(19.357758f, 25.260746f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
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
