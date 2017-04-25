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

public final class et extends c {
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
                g.setColor(-8617594);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(39.0f, 87.17454f);
                h.cubicTo(41.636593f, 87.715576f, 44.36543f, 88.0f, 47.160282f, 88.0f);
                h.cubicTo(52.397297f, 88.0f, 57.40235f, 87.001335f, 62.0f, 85.18495f);
                h.lineTo(39.0f, 62.0f);
                h.lineTo(39.0f, 87.17454f);
                h.close();
                h.moveTo(84.18153f, 34.0f);
                h.lineTo(61.0f, 57.0f);
                h.lineTo(86.17404f, 57.0f);
                h.cubicTo(86.71542f, 54.364433f, 87.0f, 51.636253f, 87.0f, 48.841667f);
                h.cubicTo(87.0f, 43.60351f, 86.00011f, 38.59756f, 84.18153f, 34.0f);
                h.lineTo(84.18153f, 34.0f);
                h.close();
                h.moveTo(68.36796f, 82.0f);
                h.cubicTo(74.77223f, 77.61014f, 79.888794f, 71.36405f, 83.0f, 64.0f);
                h.lineTo(51.0f, 64.0f);
                h.lineTo(68.36796f, 82.0f);
                h.close();
                h.moveTo(7.0f, 48.134434f);
                h.cubicTo(7.0f, 53.381317f, 8.00163f, 58.394844f, 9.8239765f, 63.0f);
                h.lineTo(33.0f, 40.0f);
                h.lineTo(7.8198056f, 40.0f);
                h.cubicTo(7.2825346f, 42.628418f, 7.0f, 45.348637f, 7.0f, 48.134434f);
                h.lineTo(7.0f, 48.134434f);
                h.close();
                h.moveTo(24.616856f, 15.0f);
                h.cubicTo(18.216589f, 19.392467f, 13.105181f, 25.63808f, 10.0f, 33.0f);
                h.lineTo(42.0f, 33.0f);
                h.lineTo(24.616856f, 15.0f);
                h.close();
                h.moveTo(63.0f, 11.0f);
                h.lineTo(63.0f, 43.0f);
                h.lineTo(81.0f, 25.622782f);
                h.cubicTo(76.60968f, 19.219759f, 70.3637f, 14.106408f, 63.0f, 11.0f);
                h.lineTo(63.0f, 11.0f);
                h.close();
                h.moveTo(32.0f, 84.0f);
                h.lineTo(32.0f, 52.0f);
                h.lineTo(14.0f, 69.37412f);
                h.cubicTo(18.39201f, 75.77617f, 24.637726f, 80.88998f, 32.0f, 84.0f);
                h.lineTo(32.0f, 84.0f);
                h.close();
                h.moveTo(56.0f, 8.82031f);
                h.cubicTo(53.37215f, 8.282693f, 50.65258f, 8.0f, 47.867496f, 8.0f);
                h.cubicTo(42.61948f, 8.0f, 37.60506f, 9.003309f, 33.0f, 10.826928f);
                h.lineTo(56.0f, 34.0f);
                h.lineTo(56.0f, 8.82031f);
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
