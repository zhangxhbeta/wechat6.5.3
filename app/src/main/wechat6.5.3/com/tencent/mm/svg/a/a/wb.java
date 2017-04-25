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

public final class wb extends c {
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
                g.setColor(-65794);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(77.0f, 25.0f);
                h.lineTo(19.0f, 25.0f);
                h.cubicTo(17.343f, 25.0f, 16.0f, 26.34297f, 16.0f, 27.999935f);
                h.lineTo(16.0f, 68.00007f);
                h.cubicTo(16.0f, 69.65703f, 17.343f, 71.0f, 19.0f, 71.0f);
                h.lineTo(77.0f, 71.0f);
                h.cubicTo(78.656f, 71.0f, 80.0f, 69.65703f, 80.0f, 68.00007f);
                h.lineTo(80.0f, 27.999935f);
                h.cubicTo(80.0f, 26.34297f, 78.657f, 25.0f, 77.0f, 25.0f);
                h.close();
                h.moveTo(72.77142f, 39.42813f);
                h.lineTo(49.779076f, 52.676395f);
                h.cubicTo(49.218597f, 52.999264f, 48.584373f, 53.06992f, 48.000298f, 52.935474f);
                h.cubicTo(47.414253f, 53.06992f, 46.781013f, 52.99828f, 46.22152f, 52.676395f);
                h.lineTo(23.229168f, 39.42813f);
                h.cubicTo(22.054132f, 38.750996f, 21.650982f, 37.250507f, 22.329454f, 36.07681f);
                h.lineTo(22.821102f, 35.226955f);
                h.cubicTo(23.499575f, 34.053257f, 25.004013f, 33.651886f, 26.179049f, 34.329018f);
                h.lineTo(48.000298f, 46.902115f);
                h.lineTo(69.820564f, 34.329018f);
                h.cubicTo(70.9956f, 33.651886f, 72.50004f, 34.053257f, 73.17753f, 35.226955f);
                h.lineTo(73.669174f, 36.07681f);
                h.cubicTo(74.34961f, 37.250507f, 73.94646f, 38.750996f, 72.77142f, 39.42813f);
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
