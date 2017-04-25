package com.tencent.mapsdk.rastercore.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class a extends View {
    private e a;
    private final int[] b = new int[]{12000000, 6000000, 3000000, 1500000, 800000, 400000, 200000, 100000, 50000, 25000, 12000, 6000, 3000, 1500, 800, 400, 200, 100, 50, 25, 17, 8, 4};
    private int c = 0;
    private String d = "";
    private int e = 0;
    private int f = 0;
    private Paint g;
    private Paint h;
    private Paint i;
    private Rect j;
    private String k;
    private int l = 10;
    private int m = 0;
    private int n = 10;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private Paint r;
    private AlphaAnimation s = null;
    private AlphaAnimation t = null;

    public a(e eVar) {
        super(e.a());
        this.a = eVar;
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setColor(-16777216);
        this.h.setStrokeWidth(6.0f * eVar.f().b());
        this.h.setStyle(Style.STROKE);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setColor(Color.rgb(100, 100, 100));
        this.i.setStrokeWidth(10.0f * eVar.f().b());
        this.i.setStyle(Style.STROKE);
        this.r = new Paint();
        this.r.setAntiAlias(true);
        this.r.setColor(Color.rgb(255, 255, 255));
        this.r.setStrokeWidth(7.0f * eVar.f().b());
        this.r.setStyle(Style.STROKE);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setColor(-16777216);
        this.g.setTextSize(25.0f * eVar.f().b());
        this.j = new Rect();
    }

    public static void b() {
    }

    public static void c() {
    }

    public final void a() {
        clearAnimation();
        this.h = null;
        this.g = null;
        this.j = null;
        this.d = null;
        this.i = null;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void d() {
        if (isShown()) {
            clearAnimation();
            this.t = new AlphaAnimation(1.0f, 0.0f);
            this.t.setDuration(2000);
            this.t.setFillAfter(true);
            startAnimation(this.t);
        }
    }

    public final void e() {
        clearAnimation();
        this.s = new AlphaAnimation(0.0f, 1.0f);
        this.s.setDuration(500);
        this.s.setFillAfter(true);
        startAnimation(this.s);
    }

    protected final void onDraw(Canvas canvas) {
        double e = this.a.b().e();
        int i = this.b[this.a.c().d().a()];
        e = ((double) i) / e;
        this.p = this.a.c().getWidth();
        while (e < ((double) (this.p / 5))) {
            e *= 2.0d;
            i *= 2;
        }
        while (e > ((double) ((this.p - (this.n * 2)) - 80))) {
            e /= 2.0d;
            i /= 2;
        }
        while (e > ((double) ((this.p - (this.n * 2)) - 80))) {
            e /= 2.0d;
            i /= 2;
        }
        this.f = (int) e;
        String str = "m";
        if (i > 2000) {
            i /= BaseReportManager.MAX_READ_COUNT;
            str = "km";
        }
        this.d = i + str;
        this.k = (i / 2);
        this.e = i / 2;
        if (!this.d.equals("") && this.f != 0) {
            this.g.getTextBounds(this.d, 0, this.d.length(), this.j);
            this.o = (int) (((float) (getHeight() - 8)) - this.h.getStrokeWidth());
            this.p = this.a.c().getWidth();
            if (this.c == 1) {
                this.l = (this.p / 2) - (this.f / 2);
                this.m = (this.p / 2) + (this.f / 2);
            } else if (this.c == 2) {
                this.l = (this.p - this.n) - this.f;
                this.m = this.p - this.n;
            } else {
                this.l = this.n;
                this.m = this.n + this.f;
            }
            this.q = (this.l + this.m) / 2;
            canvas.drawLine((float) this.l, (float) this.o, (float) this.m, (float) this.o, this.i);
            Canvas canvas2 = canvas;
            canvas2.drawLine((this.a.f().b() * 4.0f) + ((float) this.l), (float) this.o, (float) this.q, (float) this.o, this.h);
            canvas.drawText("0", ((float) this.l) - (6.0f * this.a.f().b()), (float) (this.o - this.n), this.g);
            canvas.drawText(this.d, ((float) this.m) - (((float) (this.d.length() * 6)) * this.a.f().b()), (float) (this.o - this.n), this.g);
            if (this.e != 0) {
                canvas.drawText(this.k, ((float) this.q) - (((float) (this.k.length() * 6)) * this.a.f().b()), (float) (this.o - 10), this.g);
                canvas.drawLine((float) this.q, (float) this.o, ((float) this.m) - (this.a.f().b() * 4.0f), (float) this.o, this.r);
                return;
            }
            canvas.drawLine((float) this.q, (float) this.o, ((float) this.m) - (this.a.f().b() * 4.0f), (float) this.o, this.h);
        }
    }
}
