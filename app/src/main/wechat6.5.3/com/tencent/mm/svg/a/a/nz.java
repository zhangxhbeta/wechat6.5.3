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

public final class nz extends c {
    private final int height = 46;
    private final int width = 66;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 46;
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
                g.setColor(-9537135);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(66.0f, 0.0f);
                h.lineTo(66.0f, 46.0f);
                h.lineTo(12.0f, 46.0f);
                h.cubicTo(12.01f, 41.1f, 11.99f, 36.19f, 12.01f, 31.29f);
                h.cubicTo(8.14f, 28.86f, 0.15407985f, 23.0f, 0.15407985f, 23.0f);
                h.cubicTo(3.3064237f, 20.753471f, 8.0f, 17.27f, 12.0f, 14.71f);
                h.cubicTo(11.99f, 9.81f, 12.01f, 4.9f, 12.0f, 0.0f);
                h.lineTo(66.0f, 0.0f);
                h.close();
                h.moveTo(25.162472f, 17.326578f);
                h.cubicTo(21.008757f, 18.444845f, 19.530993f, 24.33572f, 22.736143f, 27.251204f);
                h.cubicTo(25.651731f, 30.486193f, 31.642666f, 28.988512f, 32.69108f, 24.765055f);
                h.cubicTo(34.268692f, 20.401814f, 29.5059f, 15.709083f, 25.162472f, 17.326578f);
                h.lineTo(25.162472f, 17.326578f);
                h.close();
                h.moveTo(49.15318f, 17.331114f);
                h.cubicTo(45.00983f, 18.449194f, 43.542187f, 24.3291f, 46.71709f, 27.234114f);
                h.cubicTo(49.622425f, 30.478544f, 55.602825f, 29.011063f, 56.681095f, 24.798294f);
                h.cubicTo(58.288513f, 20.435783f, 53.516174f, 15.693925f, 49.15318f, 17.331114f);
                h.lineTo(49.15318f, 17.331114f);
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
