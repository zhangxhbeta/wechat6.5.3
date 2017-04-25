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

public final class ol extends c {
    private final int height = 36;
    private final int width = 33;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
            case 1:
                return 36;
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
                g.setColor(-4547478);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(30.0f, 12.851442f);
                h.lineTo(30.0f, 33.0f);
                h.lineTo(3.0f, 33.0f);
                h.lineTo(3.0f, 13.013662f);
                h.cubicTo(5.0812554f, 14.928909f, 9.102742f, 16.658638f, 10.767557f, 17.279522f);
                h.cubicTo(10.767557f, 16.999113f, 10.605591f, 15.996458f, 10.828888f, 14.5339985f);
                h.cubicTo(6.8218164f, 12.432947f, 3.0067377f, 8.4492855f, 3.0172813f, 5.8101797f);
                h.cubicTo(3.016516f, 5.641232f, 3.0105f, 5.515129f, 3.0f, 5.427509f);
                h.lineTo(3.0f, 3.0f);
                h.lineTo(30.0f, 3.0f);
                h.lineTo(30.0f, 5.425335f);
                h.cubicTo(29.998358f, 5.479269f, 29.997364f, 5.5399776f, 29.997057f, 5.6077538f);
                h.cubicTo(30.007599f, 8.24686f, 26.007072f, 12.432947f, 22.0f, 14.5339985f);
                h.cubicTo(22.223297f, 15.996458f, 22.06133f, 16.999113f, 22.06133f, 17.279522f);
                h.cubicTo(23.773027f, 16.641155f, 27.97599f, 14.830612f, 30.0f, 12.851442f);
                h.close();
                h.moveTo(0.0f, 3.0074198f);
                h.cubicTo(0.0f, 1.3464677f, 1.3345109f, 0.0f, 3.0013576f, 0.0f);
                h.lineTo(29.998642f, 0.0f);
                h.cubicTo(31.656246f, 0.0f, 33.0f, 1.3455393f, 33.0f, 3.0074198f);
                h.lineTo(33.0f, 32.99258f);
                h.cubicTo(33.0f, 34.653534f, 31.66549f, 36.0f, 29.998642f, 36.0f);
                h.lineTo(3.0013576f, 36.0f);
                h.cubicTo(1.3437536f, 36.0f, 0.0f, 34.65446f, 0.0f, 32.99258f);
                h.lineTo(0.0f, 3.0074198f);
                h.close();
                h.moveTo(16.5f, 21.014084f);
                h.cubicTo(18.985281f, 21.014084f, 21.0f, 18.996214f, 21.0f, 16.507042f);
                h.cubicTo(21.0f, 14.017872f, 18.985281f, 12.0f, 16.5f, 12.0f);
                h.cubicTo(14.014719f, 12.0f, 12.0f, 14.017872f, 12.0f, 16.507042f);
                h.cubicTo(12.0f, 18.996214f, 14.014719f, 21.014084f, 16.5f, 21.014084f);
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
