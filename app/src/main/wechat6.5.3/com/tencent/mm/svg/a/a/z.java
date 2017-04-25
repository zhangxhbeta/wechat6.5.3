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

public final class z extends c {
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
                g.setColor(-2130706433);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(46.0f, 73.0f);
                h.lineTo(46.0f, 69.99739f);
                h.cubicTo(46.0f, 69.96348f, 46.00085f, 69.929756f, 46.002525f, 69.896255f);
                h.cubicTo(36.447983f, 68.898026f, 29.0f, 60.818798f, 29.0f, 51.0f);
                h.cubicTo(29.0f, 49.89543f, 29.89543f, 49.0f, 31.0f, 49.0f);
                h.cubicTo(32.10457f, 49.0f, 33.0f, 49.89543f, 33.0f, 51.0f);
                h.cubicTo(33.0f, 59.28427f, 39.71573f, 66.0f, 48.0f, 66.0f);
                h.cubicTo(56.28427f, 66.0f, 63.0f, 59.28427f, 63.0f, 51.0f);
                h.cubicTo(63.0f, 49.89543f, 63.89543f, 49.0f, 65.0f, 49.0f);
                h.cubicTo(66.10457f, 49.0f, 67.0f, 49.89543f, 67.0f, 51.0f);
                h.cubicTo(67.0f, 60.818787f, 59.552032f, 68.89801f, 49.9975f, 69.896255f);
                h.lineTo(49.9975f, 69.896255f);
                h.cubicTo(49.99916f, 69.929756f, 50.0f, 69.96348f, 50.0f, 69.99739f);
                h.lineTo(50.0f, 73.0f);
                h.lineTo(57.008846f, 73.0f);
                h.cubicTo(58.110325f, 73.0f, 59.0f, 73.89543f, 59.0f, 75.0f);
                h.cubicTo(59.0f, 76.112274f, 58.10853f, 77.0f, 57.008846f, 77.0f);
                h.lineTo(38.991154f, 77.0f);
                h.cubicTo(37.889675f, 77.0f, 37.0f, 76.10457f, 37.0f, 75.0f);
                h.cubicTo(37.0f, 73.887726f, 37.89147f, 73.0f, 38.991154f, 73.0f);
                h.lineTo(46.0f, 73.0f);
                h.close();
                h.moveTo(48.0f, 20.0f);
                h.cubicTo(41.92487f, 20.0f, 37.0f, 24.920769f, 37.0f, 31.007566f);
                h.lineTo(37.0f, 50.992435f);
                h.cubicTo(37.0f, 57.071747f, 41.92353f, 62.0f, 48.0f, 62.0f);
                h.cubicTo(54.07513f, 62.0f, 59.0f, 57.07923f, 59.0f, 50.992435f);
                h.lineTo(59.0f, 31.007566f);
                h.cubicTo(59.0f, 24.928255f, 54.07647f, 20.0f, 48.0f, 20.0f);
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
