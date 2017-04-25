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

public final class m extends c {
    private final int height = 30;
    private final int width = 30;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -30.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(48.870228f, 11.038835f);
                h.lineTo(46.0f, 13.9090605f);
                h.lineTo(47.16861f, 15.077669f);
                h.lineTo(50.038834f, 12.207443f);
                h.lineTo(52.90906f, 15.077669f);
                h.lineTo(54.07767f, 13.9090605f);
                h.lineTo(51.207443f, 11.038835f);
                h.lineTo(54.07767f, 8.168609f);
                h.lineTo(52.90906f, 7.0f);
                h.lineTo(50.038834f, 9.870226f);
                h.lineTo(47.16861f, 7.0f);
                h.lineTo(46.0f, 8.168609f);
                h.lineTo(48.870228f, 11.038835f);
                h.close();
                h.moveTo(37.99703f, 7.0f);
                h.cubicTo(37.446384f, 7.0f, 37.0f, 7.4530363f, 37.0f, 7.9970303f);
                h.lineTo(37.0f, 14.00297f);
                h.cubicTo(37.0f, 14.553615f, 37.453037f, 15.0f, 37.99703f, 15.0f);
                h.lineTo(44.00297f, 15.0f);
                h.cubicTo(44.553616f, 15.0f, 45.0f, 14.546964f, 45.0f, 14.00297f);
                h.lineTo(45.0f, 7.9970303f);
                h.cubicTo(45.0f, 7.4463854f, 44.546963f, 7.0f, 44.00297f, 7.0f);
                h.lineTo(37.99703f, 7.0f);
                h.close();
                h.moveTo(37.99703f, 16.0f);
                h.cubicTo(37.446384f, 16.0f, 37.0f, 16.453035f, 37.0f, 16.99703f);
                h.lineTo(37.0f, 23.00297f);
                h.cubicTo(37.0f, 23.553614f, 37.453037f, 24.0f, 37.99703f, 24.0f);
                h.lineTo(44.00297f, 24.0f);
                h.cubicTo(44.553616f, 24.0f, 45.0f, 23.546965f, 45.0f, 23.00297f);
                h.lineTo(45.0f, 16.99703f);
                h.cubicTo(45.0f, 16.446386f, 44.546963f, 16.0f, 44.00297f, 16.0f);
                h.lineTo(37.99703f, 16.0f);
                h.close();
                h.moveTo(46.99703f, 16.0f);
                h.cubicTo(46.446384f, 16.0f, 46.0f, 16.453035f, 46.0f, 16.99703f);
                h.lineTo(46.0f, 23.00297f);
                h.cubicTo(46.0f, 23.553614f, 46.453037f, 24.0f, 46.99703f, 24.0f);
                h.lineTo(53.00297f, 24.0f);
                h.cubicTo(53.553616f, 24.0f, 54.0f, 23.546965f, 54.0f, 23.00297f);
                h.lineTo(54.0f, 16.99703f);
                h.cubicTo(54.0f, 16.446386f, 53.546963f, 16.0f, 53.00297f, 16.0f);
                h.lineTo(46.99703f, 16.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
