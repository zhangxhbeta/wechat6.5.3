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

public final class ib extends c {
    private final int height = 292;
    private final int width = 378;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return 292;
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
                a.setColor(-13092808);
                Path h = c.h(looper);
                h.moveTo(373.0f, 236.0006f);
                h.cubicTo(373.0f, 242.0656f, 368.063f, 247.0006f, 361.993f, 247.0006f);
                h.lineTo(16.007f, 247.0006f);
                h.cubicTo(9.938f, 247.0006f, 5.0f, 242.0656f, 5.0f, 236.0006f);
                h.lineTo(5.0f, 15.9996f);
                h.cubicTo(5.0f, 9.9346f, 9.938f, 5.0006f, 16.007f, 5.0006f);
                h.lineTo(361.993f, 5.0006f);
                h.cubicTo(368.063f, 5.0006f, 373.0f, 9.9346f, 373.0f, 15.9996f);
                h.lineTo(373.0f, 236.0006f);
                h.lineTo(373.0f, 236.0006f);
                h.close();
                h.moveTo(361.993f, 1.9996f);
                h.lineTo(16.007f, 1.9996f);
                h.cubicTo(8.276f, 1.9996f, 2.0f, 8.2676f, 2.0f, 15.9996f);
                h.lineTo(2.0f, 236.0006f);
                h.cubicTo(2.0f, 243.7296f, 8.271f, 249.9996f, 16.007f, 249.9996f);
                h.lineTo(361.993f, 249.9996f);
                h.cubicTo(369.724f, 249.9996f, 376.0f, 243.7326f, 376.0f, 236.0006f);
                h.lineTo(376.0f, 15.9996f);
                h.cubicTo(376.0f, 8.2696f, 369.729f, 1.9996f, 361.993f, 1.9996f);
                h.lineTo(361.993f, 1.9996f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-13092808);
                Path h2 = c.h(looper);
                h2.moveTo(243.0f, 288.0001f);
                h2.lineTo(134.0f, 288.0001f);
                h2.lineTo(134.0f, 286.5041f);
                h2.lineTo(155.712f, 282.5561f);
                h2.lineTo(159.658f, 250.0001f);
                h2.lineTo(217.342f, 250.0001f);
                h2.lineTo(221.288f, 282.5561f);
                h2.lineTo(243.0f, 286.5041f);
                h2.lineTo(243.0f, 288.0001f);
                h2.close();
                h2.moveTo(220.0f, 247.0001f);
                h2.lineTo(157.0f, 247.0001f);
                h2.lineTo(153.0f, 280.0001f);
                h2.lineTo(131.0f, 284.0001f);
                h2.lineTo(131.0f, 291.0001f);
                h2.lineTo(246.0f, 291.0001f);
                h2.lineTo(246.0f, 284.0001f);
                h2.lineTo(224.0f, 280.0001f);
                h2.lineTo(220.0f, 247.0001f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-13092808);
                h2 = c.h(looper);
                h2.moveTo(4.0f, 201.0f);
                h2.lineTo(376.0f, 201.0f);
                h2.lineTo(376.0f, 198.0f);
                h2.lineTo(4.0f, 198.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
