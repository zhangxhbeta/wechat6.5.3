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

public final class bk extends c {
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
                g2 = c.a(g, looper);
                g2.setColor(-1907998);
                canvas.save();
                g2 = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(90.0f, 0.0f);
                h.lineTo(90.0f, 90.0f);
                h.lineTo(0.0f, 90.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(64.6125f, 40.815067f);
                h2.cubicTo(68.651184f, 36.77639f, 68.615555f, 30.199883f, 64.53532f, 26.11964f);
                h2.cubicTo(60.45597f, 22.040295f, 53.87615f, 22.006195f, 49.83989f, 26.042452f);
                h2.lineTo(40.44245f, 35.43989f);
                h2.cubicTo(36.403774f, 39.47857f, 36.4394f, 46.055077f, 40.51964f, 50.13532f);
                h2.lineTo(42.60796f, 48.046997f);
                h2.cubicTo(39.693443f, 45.13248f, 39.644207f, 40.458885f, 42.552826f, 37.550266f);
                h2.lineTo(51.950264f, 28.152826f);
                h2.cubicTo(54.85723f, 25.245861f, 59.53383f, 25.29479f, 62.447f, 28.20796f);
                h2.cubicTo(65.36151f, 31.122477f, 65.41075f, 35.796074f, 62.502132f, 38.704693f);
                h2.lineTo(57.803413f, 43.40341f);
                h2.lineTo(59.913784f, 45.513786f);
                h2.lineTo(64.6125f, 40.815067f);
                h2.close();
                h2.moveTo(26.042452f, 49.83989f);
                h2.cubicTo(22.003777f, 53.878567f, 22.039398f, 60.455074f, 26.11964f, 64.53532f);
                h2.cubicTo(30.198984f, 68.61466f, 36.77881f, 68.648766f, 40.815067f, 64.6125f);
                h2.lineTo(50.212505f, 55.215065f);
                h2.cubicTo(54.251183f, 51.176388f, 54.215557f, 44.59988f, 50.13532f, 40.51964f);
                h2.lineTo(48.046997f, 42.60796f);
                h2.cubicTo(50.961514f, 45.522476f, 51.01075f, 50.19607f, 48.10213f, 53.104694f);
                h2.lineTo(38.704693f, 62.502132f);
                h2.cubicTo(35.797726f, 65.409096f, 31.121128f, 65.36017f, 28.20796f, 62.447f);
                h2.cubicTo(25.293442f, 59.53248f, 25.244205f, 54.858883f, 28.152826f, 51.950264f);
                h2.lineTo(32.851543f, 47.251545f);
                h2.lineTo(30.74117f, 45.14117f);
                h2.lineTo(26.042452f, 49.83989f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
