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

public final class ea extends c {
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
                h.moveTo(68.0f, 79.0f);
                h.lineTo(59.0f, 70.0f);
                h.lineTo(63.0f, 66.0f);
                h.lineTo(68.0f, 71.0f);
                h.lineTo(78.0f, 61.0f);
                h.lineTo(82.0f, 65.0f);
                h.lineTo(68.0f, 79.0f);
                h.close();
                h.moveTo(71.0f, 50.0f);
                h.cubicTo(60.282974f, 50.0f, 52.0f, 58.28252f, 52.0f, 69.0f);
                h.cubicTo(52.0f, 78.717026f, 60.282974f, 87.0f, 71.0f, 87.0f);
                h.cubicTo(80.71748f, 87.0f, 89.0f, 78.717026f, 89.0f, 69.0f);
                h.cubicTo(89.0f, 58.28252f, 80.71748f, 50.0f, 71.0f, 50.0f);
                h.lineTo(71.0f, 50.0f);
                h.close();
                h.moveTo(63.0f, 43.0f);
                h.cubicTo(63.592392f, 40.275383f, 64.00275f, 37.06338f, 64.0f, 34.0f);
                h.cubicTo(63.988037f, 19.506426f, 55.133587f, 10.0f, 44.0f, 10.0f);
                h.cubicTo(33.308323f, 10.0f, 24.469494f, 19.506426f, 24.0f, 34.0f);
                h.cubicTo(24.490173f, 44.4049f, 28.598263f, 53.310444f, 35.0f, 58.0f);
                h.lineTo(35.0f, 58.0f);
                h.cubicTo(34.57108f, 57.90625f, 35.94963f, 59.25173f, 36.0f, 61.0f);
                h.lineTo(36.0f, 62.0f);
                h.cubicTo(35.94963f, 63.946545f, 34.789806f, 64.65647f, 34.0f, 65.0f);
                h.lineTo(13.0f, 71.0f);
                h.cubicTo(12.8413925f, 71.04397f, 12.81474f, 71.05081f, 13.0f, 71.0f);
                h.lineTo(13.0f, 71.0f);
                h.lineTo(13.0f, 71.0f);
                h.cubicTo(9.304023f, 72.2868f, 7.0f, 75.31949f, 7.0f, 79.0f);
                h.lineTo(7.0f, 83.0f);
                h.lineTo(8.0f, 83.0f);
                h.lineTo(22.0f, 83.0f);
                h.lineTo(48.0f, 83.0f);
                h.cubicTo(45.77918f, 78.8504f, 44.220955f, 73.92154f, 44.0f, 69.0f);
                h.cubicTo(44.220955f, 56.749657f, 52.038273f, 46.68843f, 63.0f, 43.0f);
                h.lineTo(63.0f, 43.0f);
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
