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

public final class ju extends c {
    private final int height = 192;
    private final int width = 192;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-12206054);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(192.0f, 0.0f);
                h.lineTo(192.0f, 192.0f);
                h.lineTo(0.0f, 192.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(65.454544f, 90.181816f);
                h2.lineTo(58.18182f, 90.181816f);
                h2.lineTo(58.18182f, 103.31862f);
                h2.cubicTo(58.18182f, 122.70565f, 72.80536f, 138.68132f, 91.63636f, 140.84218f);
                h2.lineTo(91.63636f, 149.81818f);
                h2.lineTo(73.72098f, 149.81818f);
                h2.cubicTo(73.172165f, 149.81818f, 72.72727f, 150.27472f, 72.72727f, 150.81836f);
                h2.lineTo(72.72727f, 154.63618f);
                h2.cubicTo(72.72727f, 155.18857f, 73.17303f, 155.63637f, 73.72098f, 155.63637f);
                h2.lineTo(118.27902f, 155.63637f);
                h2.cubicTo(118.827835f, 155.63637f, 119.27273f, 155.17982f, 119.27273f, 154.63618f);
                h2.lineTo(119.27273f, 150.81836f);
                h2.cubicTo(119.27273f, 150.26598f, 118.82698f, 149.81818f, 118.27902f, 149.81818f);
                h2.lineTo(100.36363f, 149.81818f);
                h2.lineTo(100.36363f, 149.81818f);
                h2.lineTo(100.36363f, 140.84218f);
                h2.lineTo(100.36363f, 140.84218f);
                h2.cubicTo(119.19464f, 138.68132f, 133.81818f, 122.70565f, 133.81818f, 103.31862f);
                h2.lineTo(133.81818f, 90.181816f);
                h2.lineTo(126.545456f, 90.181816f);
                h2.lineTo(126.545456f, 102.822685f);
                h2.cubicTo(126.545456f, 119.941025f, 112.86979f, 133.81818f, 96.0f, 133.81818f);
                h2.cubicTo(79.13021f, 133.81818f, 65.454544f, 119.941025f, 65.454544f, 102.822685f);
                h2.lineTo(65.454544f, 90.181816f);
                h2.lineTo(65.454544f, 90.181816f);
                h2.close();
                h2.moveTo(96.0f, 36.363636f);
                h2.cubicTo(83.14683f, 36.363636f, 72.72727f, 46.774685f, 72.72727f, 59.646313f);
                h2.lineTo(72.72727f, 103.26278f);
                h2.cubicTo(72.72727f, 116.121445f, 83.144005f, 126.545456f, 96.0f, 126.545456f);
                h2.cubicTo(108.85317f, 126.545456f, 119.27273f, 116.13441f, 119.27273f, 103.26278f);
                h2.lineTo(119.27273f, 59.646313f);
                h2.cubicTo(119.27273f, 46.787647f, 108.855995f, 36.363636f, 96.0f, 36.363636f);
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
