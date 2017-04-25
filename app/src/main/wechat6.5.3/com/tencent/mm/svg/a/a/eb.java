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

public final class eb extends c {
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
                g.setColor(-8683387);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(68.0f, 68.0f);
                h.lineTo(68.0f, 73.0f);
                h.cubicTo(62.75382f, 77.365776f, 55.755802f, 80.0f, 48.0f, 80.0f);
                h.cubicTo(43.030067f, 80.0f, 38.205288f, 78.816f, 34.0f, 77.0f);
                h.lineTo(48.0f, 52.0f);
                h.lineTo(44.0f, 48.0f);
                h.lineTo(36.0f, 48.0f);
                h.lineTo(28.0f, 40.0f);
                h.lineTo(44.0f, 24.0f);
                h.lineTo(38.0f, 18.0f);
                h.cubicTo(40.952587f, 16.616444f, 44.470387f, 16.0f, 48.0f, 16.0f);
                h.cubicTo(52.40803f, 16.0f, 56.485584f, 16.82889f, 60.0f, 18.0f);
                h.lineTo(60.0f, 24.0f);
                h.lineTo(64.0f, 28.0f);
                h.lineTo(73.0f, 28.0f);
                h.cubicTo(75.21601f, 30.406666f, 76.81651f, 33.097332f, 78.0f, 36.0f);
                h.lineTo(64.0f, 36.0f);
                h.lineTo(56.0f, 44.0f);
                h.lineTo(56.0f, 56.0f);
                h.lineTo(68.0f, 68.0f);
                h.close();
                h.moveTo(24.0f, 69.0f);
                h.cubicTo(19.024445f, 63.343204f, 16.0f, 55.91894f, 16.0f, 48.0f);
                h.cubicTo(16.0f, 46.501648f, 16.08311f, 45.241016f, 16.0f, 44.0f);
                h.lineTo(24.0f, 52.0f);
                h.lineTo(24.0f, 69.0f);
                h.close();
                h.moveTo(48.0f, 8.0f);
                h.cubicTo(25.908443f, 8.0f, 8.0f, 25.908443f, 8.0f, 48.0f);
                h.cubicTo(8.0f, 70.09155f, 25.908443f, 88.0f, 48.0f, 88.0f);
                h.cubicTo(70.09155f, 88.0f, 88.0f, 70.09155f, 88.0f, 48.0f);
                h.cubicTo(88.0f, 25.908443f, 70.09155f, 8.0f, 48.0f, 8.0f);
                h.lineTo(48.0f, 8.0f);
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
