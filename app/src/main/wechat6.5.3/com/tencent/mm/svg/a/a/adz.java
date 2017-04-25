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

public final class adz extends c {
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
                g.setColor(-12799249);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(48.11264f, 11.0f);
                h.cubicTo(29.075232f, 11.190086f, 20.986343f, 26.826294f, 20.986343f, 40.877155f);
                h.cubicTo(9.261343f, 52.839657f, 12.905231f, 69.57371f, 16.54523f, 69.57371f);
                h.cubicTo(18.859121f, 69.951294f, 22.617083f, 63.59698f, 22.617083f, 63.59698f);
                h.cubicTo(22.617083f, 63.59698f, 22.73375f, 67.556465f, 25.812454f, 71.13836f);
                h.cubicTo(22.417454f, 72.655174f, 20.195602f, 75.13793f, 20.195602f, 77.949135f);
                h.cubicTo(20.195602f, 82.57069f, 26.175417f, 86.31681f, 33.553936f, 86.31681f);
                h.cubicTo(39.042454f, 86.31681f, 43.753193f, 84.242676f, 45.80912f, 81.27888f);
                h.lineTo(50.492638f, 81.27888f);
                h.cubicTo(52.547268f, 84.242676f, 57.25801f, 86.31681f, 62.74653f, 86.31681f);
                h.cubicTo(70.12375f, 86.31681f, 76.106155f, 82.57198f, 76.106155f, 77.949135f);
                h.cubicTo(76.106155f, 75.13793f, 73.88431f, 72.65646f, 70.4893f, 71.13836f);
                h.cubicTo(73.56801f, 67.556465f, 73.68468f, 63.59698f, 73.68468f, 63.59698f);
                h.cubicTo(73.68468f, 63.59698f, 77.441345f, 69.951294f, 79.75653f, 69.57371f);
                h.cubicTo(83.39653f, 69.57241f, 87.03912f, 52.838364f, 75.31412f, 40.875862f);
                h.cubicTo(75.31412f, 26.826294f, 67.14875f, 11.181034f, 48.11264f, 11.0f);
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
