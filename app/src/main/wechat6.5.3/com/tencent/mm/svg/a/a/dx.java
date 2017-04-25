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

public final class dx extends c {
    private final int height = 144;
    private final int width = 144;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                Paint a = c.a(g, looper);
                a.setColor(-9276814);
                Path h = c.h(looper);
                h.moveTo(15.052474f, 8.0f);
                h.cubicTo(11.166417f, 8.0f, 8.0f, 11.165231f, 8.0f, 15.049831f);
                h.lineTo(8.0f, 128.9022f);
                h.cubicTo(8.0f, 132.78682f, 11.166417f, 135.95204f, 15.052474f, 135.95204f);
                h.lineTo(76.365814f, 135.95204f);
                h.lineTo(76.365814f, 86.41139f);
                h.lineTo(59.670166f, 86.41139f);
                h.lineTo(59.670166f, 67.084305f);
                h.lineTo(76.365814f, 67.084305f);
                h.lineTo(76.365814f, 52.840763f);
                h.cubicTo(76.365814f, 36.295242f, 86.488754f, 27.32709f, 101.21739f, 27.32709f);
                h.cubicTo(108.26987f, 27.32709f, 114.362816f, 27.854628f, 116.13793f, 28.094418f);
                h.lineTo(116.13793f, 45.35931f);
                h.lineTo(105.91904f, 45.35931f);
                h.cubicTo(97.90704f, 45.35931f, 96.32384f, 49.147995f, 96.32384f, 54.759087f);
                h.lineTo(96.32384f, 67.084305f);
                h.lineTo(115.46627f, 67.084305f);
                h.lineTo(112.97151f, 86.41139f);
                h.lineTo(96.32384f, 86.41139f);
                h.lineTo(96.32384f, 136.0f);
                h.lineTo(128.94753f, 136.0f);
                h.cubicTo(132.83359f, 136.0f, 136.0f, 132.83476f, 136.0f, 128.95016f);
                h.lineTo(136.0f, 15.049831f);
                h.cubicTo(136.0f, 11.117272f, 132.88156f, 8.0f, 128.94753f, 8.0f);
                h.lineTo(15.052474f, 8.0f);
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
