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

public final class adm extends c {
    private final int height = 34;
    private final int width = 34;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 34;
            case 1:
                return 34;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(13.0f, 0.0f);
                h.lineTo(21.0f, 0.0f);
                h.cubicTo(27.69f, 0.44f, 33.42f, 6.1f, 34.0f, 13.0f);
                h.lineTo(34.0f, 21.0f);
                h.cubicTo(33.56f, 27.72f, 27.92f, 33.41f, 21.0f, 34.0f);
                h.lineTo(13.0f, 34.0f);
                h.cubicTo(6.3f, 33.58f, 0.58f, 27.91f, 0.0f, 21.0f);
                h.lineTo(0.0f, 13.0f);
                h.cubicTo(0.44f, 6.3f, 6.1f, 0.62f, 13.0f, 0.0f);
                h.lineTo(13.0f, 0.0f);
                h.close();
                h.moveTo(11.0f, 4.0f);
                h.cubicTo(6.2619376f, 5.2345805f, 2.7374582f, 10.576861f, 3.0f, 16.0f);
                h.cubicTo(2.4991837f, 21.251474f, 4.504662f, 27.081224f, 9.0f, 30.0f);
                h.cubicTo(12.725139f, 31.349081f, 16.597101f, 31.030733f, 20.0f, 31.0f);
                h.cubicTo(25.691252f, 30.483572f, 30.4766f, 25.668554f, 31.0f, 20.0f);
                h.cubicTo(31.181498f, 15.700277f, 31.231138f, 10.626603f, 28.0f, 7.0f);
                h.cubicTo(23.973688f, 2.3992918f, 17.004154f, 2.5186725f, 11.0f, 4.0f);
                h.lineTo(11.0f, 4.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(15.0f, 6.0f);
                h.cubicTo(16.379942f, 5.8667493f, 17.790102f, 5.85669f, 19.0f, 6.0f);
                h.cubicTo(19.059246f, 9.588673f, 19.079391f, 12.747278f, 19.0f, 16.0f);
                h.cubicTo(21.940002f, 15.9260025f, 24.79054f, 15.9260025f, 28.0f, 16.0f);
                h.cubicTo(28.124561f, 17.243765f, 28.124561f, 18.642f, 28.0f, 20.0f);
                h.cubicTo(23.410599f, 19.647926f, 19.089464f, 20.5432f, 15.0f, 19.0f);
                h.cubicTo(15.100726f, 15.040789f, 15.090653f, 10.715309f, 15.0f, 6.0f);
                h.lineTo(15.0f, 6.0f);
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
