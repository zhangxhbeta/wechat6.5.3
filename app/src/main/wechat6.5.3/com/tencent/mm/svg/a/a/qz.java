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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class qz extends c {
    private final int height = 70;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 70;
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
                Path h = c.h(looper);
                h.moveTo(69.0f, 50.0f);
                h.lineTo(21.0f, 50.0f);
                h.lineTo(21.0f, 52.008118f);
                h.cubicTo(21.0f, 53.108204f, 20.113445f, 54.0f, 18.994081f, 54.0f);
                h.lineTo(16.005919f, 54.0f);
                h.cubicTo(14.898081f, 54.0f, 14.0f, 53.1066f, 14.0f, 52.008118f);
                h.lineTo(14.0f, 50.0f);
                h.lineTo(0.0f, 50.0f);
                h.lineTo(0.0f, 43.0f);
                h.lineTo(14.0f, 43.0f);
                h.lineTo(14.0f, 43.0f);
                h.lineTo(14.0f, 40.991882f);
                h.cubicTo(14.0f, 39.891796f, 14.886555f, 39.0f, 16.005919f, 39.0f);
                h.lineTo(18.994081f, 39.0f);
                h.cubicTo(20.10192f, 39.0f, 21.0f, 39.8934f, 21.0f, 40.991882f);
                h.lineTo(21.0f, 43.0f);
                h.lineTo(69.0f, 43.0f);
                h.lineTo(69.0f, 40.991882f);
                h.cubicTo(69.0f, 39.891796f, 69.88656f, 39.0f, 71.00592f, 39.0f);
                h.lineTo(73.99408f, 39.0f);
                h.cubicTo(75.10192f, 39.0f, 76.0f, 39.8934f, 76.0f, 40.991882f);
                h.lineTo(76.0f, 43.0f);
                h.lineTo(90.0f, 43.0f);
                h.lineTo(90.0f, 50.0f);
                h.lineTo(76.0f, 50.0f);
                h.lineTo(76.0f, 52.008118f);
                h.cubicTo(76.0f, 53.108204f, 75.11344f, 54.0f, 73.99408f, 54.0f);
                h.lineTo(71.00592f, 54.0f);
                h.cubicTo(69.89808f, 54.0f, 69.0f, 53.1066f, 69.0f, 52.008118f);
                h.lineTo(69.0f, 50.0f);
                h.close();
                h.moveTo(0.0f, 3.99323f);
                h.cubicTo(0.0f, 2.8923995f, 0.8907616f, 2.0f, 2.0059645f, 2.0f);
                h.lineTo(87.99403f, 2.0f);
                h.cubicTo(89.1019f, 2.0f, 90.0f, 2.8954434f, 90.0f, 3.99323f);
                h.lineTo(90.0f, 66.00677f);
                h.cubicTo(90.0f, 67.1076f, 89.10924f, 68.0f, 87.99403f, 68.0f);
                h.lineTo(2.0059645f, 68.0f);
                h.cubicTo(0.898101f, 68.0f, 0.0f, 67.10455f, 0.0f, 66.00677f);
                h.lineTo(0.0f, 3.99323f);
                h.close();
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                g2 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
