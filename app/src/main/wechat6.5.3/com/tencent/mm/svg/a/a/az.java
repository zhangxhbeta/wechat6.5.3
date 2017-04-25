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

public final class az extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                a.setColor(-36040);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(86.0f, 0.0f);
                h.cubicTo(88.20914f, 0.0f, 90.0f, 1.7908609f, 90.0f, 4.0f);
                h.lineTo(90.0f, 86.0f);
                h.cubicTo(90.0f, 88.20914f, 88.20914f, 90.0f, 86.0f, 90.0f);
                h.lineTo(4.0f, 90.0f);
                h.cubicTo(1.7908609f, 90.0f, 0.0f, 88.20914f, 0.0f, 86.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(35.439392f, 44.5f);
                h.lineTo(35.439392f, 27.263159f);
                h.lineTo(47.676235f, 27.263159f);
                h.cubicTo(51.228886f, 27.263159f, 53.827545f, 27.997799f, 55.47229f, 29.467106f);
                h.cubicTo(57.117035f, 30.93641f, 57.939392f, 33.074547f, 57.939392f, 35.88158f);
                h.cubicTo(57.939392f, 38.68861f, 57.117035f, 40.83771f, 55.47229f, 42.32895f);
                h.cubicTo(53.827545f, 43.820183f, 51.228886f, 44.54386f, 47.676235f, 44.5f);
                h.lineTo(35.439392f, 44.5f);
                h.close();
                h.moveTo(29.0f, 22.0f);
                h.lineTo(29.0f, 68.85008f);
                h.lineTo(35.25f, 68.85008f);
                h.lineTo(35.25f, 49.763157f);
                h.lineTo(49.592106f, 49.763157f);
                h.cubicTo(54.32897f, 49.80702f, 57.914463f, 48.60089f, 60.348682f, 46.144737f);
                h.cubicTo(62.782906f, 43.688583f, 64.0f, 40.267567f, 64.0f, 35.88158f);
                h.cubicTo(64.0f, 31.495592f, 62.782906f, 28.085539f, 60.348682f, 25.651316f);
                h.cubicTo(57.914463f, 23.217093f, 54.32897f, 22.0f, 49.592106f, 22.0f);
                h.lineTo(29.0f, 22.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
