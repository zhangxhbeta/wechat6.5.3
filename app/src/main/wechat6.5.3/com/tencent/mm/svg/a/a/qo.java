package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class qo extends c {
    private final int height = 92;
    private final int width = 92;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 92;
            case 1:
                return 92;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                a.setColor(-2626143);
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(16.932604f, 1.0969148f);
                h.cubicTo(24.994081f, -1.5536036f, 34.3458f, 0.71684045f, 40.396908f, 6.6379986f);
                h.cubicTo(46.988117f, 12.789202f, 49.418564f, 22.60112f, 47.198154f, 31.242811f);
                h.cubicTo(43.57749f, 45.585617f, 33.955727f, 57.447937f, 23.993898f, 68.0f);
                h.cubicTo(16.072445f, 59.688374f, 8.661086f, 50.646606f, 3.860205f, 40.13455f);
                h.cubicTo(1.019684f, 33.84332f, -0.92067206f, 26.781939f, 0.44957933f, 19.860584f);
                h.cubicTo(1.989862f, 11.228896f, 8.511058f, 3.6574156f, 16.932604f, 1.0969148f);
                h.lineTo(16.932604f, 1.0969148f);
                h.close();
                h.moveTo(21.660744f, 13.37389f);
                h.cubicTo(15.35458f, 14.838051f, 11.456952f, 22.040936f, 13.585656f, 28.035152f);
                h.cubicTo(15.224659f, 33.636303f, 21.740694f, 37.291794f, 27.477203f, 35.57214f);
                h.cubicTo(33.683426f, 34.098152f, 37.49111f, 26.983707f, 35.442356f, 21.068104f);
                h.cubicTo(33.853325f, 15.447299f, 27.407246f, 11.781983f, 21.660744f, 13.37389f);
                h.lineTo(21.660744f, 13.37389f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
