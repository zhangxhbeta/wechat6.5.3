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

public final class pe extends c {
    private final int height = 61;
    private final int width = 61;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 61;
            case 1:
                return 61;
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
                a.setColor(-10970130);
                Path h = c.h(looper);
                h.moveTo(24.357143f, 31.267857f);
                h.cubicTo(26.82522f, 35.67271f, 22.368435f, 37.603485f, 20.517857f, 38.94643f);
                h.cubicTo(12.49915f, 43.23181f, 9.0f, 44.938072f, 9.0f, 46.625f);
                h.lineTo(9.0f, 50.464287f);
                h.cubicTo(9.0f, 51.156628f, 9.728162f, 52.0f, 10.535714f, 52.0f);
                h.lineTo(50.464287f, 52.0f);
                h.cubicTo(51.27184f, 52.0f, 52.0f, 51.156628f, 52.0f, 50.464287f);
                h.lineTo(52.0f, 46.625f);
                h.cubicTo(52.0f, 44.938072f, 48.50085f, 43.23181f, 40.482143f, 38.94643f);
                h.cubicTo(38.631565f, 37.603485f, 34.17478f, 35.67271f, 36.642857f, 31.267857f);
                h.cubicTo(39.24307f, 27.868282f, 41.103214f, 26.426222f, 41.25f, 20.517857f);
                h.cubicTo(41.103214f, 14.887795f, 36.947693f, 9.0f, 30.5f, 9.0f);
                h.cubicTo(24.052307f, 9.0f, 19.896786f, 14.887795f, 19.75f, 20.517857f);
                h.cubicTo(19.896786f, 26.426222f, 21.756931f, 27.868282f, 24.357143f, 31.267857f);
                h.close();
                h.moveTo(30.714453f, 42.92168f);
                h.cubicTo(26.309618f, 42.92168f, 23.007446f, 38.011597f, 23.007446f, 38.011597f);
                h.cubicTo(23.007446f, 38.011597f, 24.622948f, 50.719337f, 30.714453f, 50.719337f);
                h.cubicTo(36.805958f, 50.719337f, 38.079346f, 38.011597f, 38.079346f, 38.011597f);
                h.cubicTo(38.079346f, 38.011597f, 35.11929f, 42.92168f, 30.714453f, 42.92168f);
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
