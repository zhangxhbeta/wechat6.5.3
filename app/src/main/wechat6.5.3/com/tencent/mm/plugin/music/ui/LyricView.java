package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class LyricView extends View {
    public static int hDM = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 16);
    public static int hDN = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10);
    private long cvV;
    private float gLd;
    com.tencent.mm.plugin.music.a.a hDF;
    private GestureDetector hDG;
    TextPaint hDH;
    TextPaint hDI;
    private int hDJ;
    private int hDK;
    private int hDL = -1;
    private int hDO = (hDM + hDN);
    private int hDP = this.hDO;
    private boolean hDQ;
    private boolean hDR;
    private int hDS;
    private int height;
    private float hnh;
    private int width;

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ LyricView hDT;

        private a(LyricView lyricView) {
            this.hDT = lyricView;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            CharSequence a = LyricView.a(this.hDT, motionEvent.getX(), motionEvent.getY());
            if (be.kS(a)) {
                v.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
                return;
            }
            if (i.aDc().hDi == null) {
                i.aDc().hDi = (ClipboardManager) aa.getContext().getSystemService("clipboard");
            }
            i.aDc().hDi.setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", a));
            Toast.makeText(this.hDT.getContext(), this.hDT.getContext().getString(2131233964, new Object[]{a}), 0).show();
        }
    }

    static /* synthetic */ String a(LyricView lyricView, float f, float f2) {
        v.i("MicroMsg.Music.LyricView", "getSentenceByXY %f, %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        if (lyricView.hDF != null && lyricView.hDF.hCk.size() > 0) {
            int i = (lyricView.height / 2) - lyricView.hDP;
            int i2 = i - ((hDM + hDN) / 2);
            i += (hDM + hDN) / 2;
            if (f2 >= ((float) i2) && f2 <= ((float) i)) {
                return lyricView.hDF.nt(lyricView.hDL).content;
            }
            if (f2 < ((float) i2)) {
                i = (lyricView.hDL - (((int) (((float) i2) - f2)) / (hDM + hDN))) - 1;
                if (i < lyricView.hDF.hCk.size() && i >= 0) {
                    return lyricView.hDF.nt(i).content;
                }
            } else if (f2 > ((float) i)) {
                i = ((((int) (f2 - ((float) i))) / (hDM + hDN)) + lyricView.hDL) + 1;
                if (i < lyricView.hDF.hCk.size() && i >= 0) {
                    return lyricView.hDF.nt(i).content;
                }
            }
        }
        return "";
    }

    public final void cl(long j) {
        if (this.cvV != j) {
            this.cvV = j;
            if (this.hDF != null && this.hDF.hCk.size() != 0) {
                int i = -1;
                int i2 = 0;
                while (i2 < this.hDF.hCk.size() && this.hDF.nt(i2).timestamp < j) {
                    if (!this.hDF.nt(i2).hCs) {
                        i = i2;
                    }
                    i2++;
                }
                if (!this.hDR && i != this.hDL) {
                    this.hDL = i;
                    this.hDJ = (hDM + hDN) * this.hDL;
                    this.hDK = (hDM + hDN) * ((this.hDF.hCk.size() - this.hDL) - 1);
                    if (this.hDP == 0) {
                        this.hDP = -this.hDO;
                    }
                    this.hDQ = true;
                    invalidate();
                }
            }
        }
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    public LyricView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    private void NI() {
        this.hDH = new TextPaint();
        this.hDH.setTextSize((float) hDM);
        this.hDH.setColor(-1);
        this.hDH.setAntiAlias(true);
        this.hDH.setTextAlign(Align.CENTER);
        this.hDI = new TextPaint();
        this.hDI.setTextSize((float) hDM);
        this.hDI.setColor(-1);
        this.hDI.setAlpha(127);
        this.hDI.setAntiAlias(true);
        this.hDI.setTextAlign(Align.CENTER);
        this.hDG = new GestureDetector(getContext(), new a());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hDF == null) {
            v.v("MicroMsg.Music.LyricView", "lyricObj is null");
            return;
        }
        if (this.height == 0 || this.width == 0) {
            this.height = getMeasuredHeight();
            this.width = getMeasuredWidth();
        }
        if (this.hDL >= 0) {
            int i = this.hDP;
            if (this.hDF != null && this.hDF.hCk.size() > this.hDL) {
                int i2;
                int i3 = (this.height / 2) - i;
                if (i3 < this.height && i3 > 0) {
                    canvas.drawText(this.hDF.nt(this.hDL).content, (float) (this.width / 2), (float) i3, this.hDH);
                }
                for (i = this.hDL - 1; i >= 0; i--) {
                    i2 = i3 - ((this.hDL - i) * (hDM + hDN));
                    if (i2 > 0 && i2 < this.height) {
                        canvas.drawText(this.hDF.nt(i).content, (float) (this.width / 2), (float) i2, this.hDI);
                    }
                }
                for (i = this.hDL + 1; i < this.hDF.hCk.size(); i++) {
                    i2 = ((i - this.hDL) * (hDM + hDN)) + i3;
                    if (i2 < this.height && i2 > 0) {
                        canvas.drawText(this.hDF.nt(i).content, (float) (this.width / 2), (float) i2, this.hDI);
                    }
                }
            }
            if (this.hDQ) {
                if ((this.hDP != 0 ? 1 : null) != null) {
                    this.hDP = (int) (((float) this.hDP) * 0.9f);
                    invalidate();
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.height = i2;
        this.width = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.hDG.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.gLd = motionEvent.getY();
                this.hnh = motionEvent.getX();
                this.hDS = this.hDP;
                this.hDR = true;
                this.hDQ = false;
                break;
            case 1:
                this.hDR = false;
                break;
            case 2:
                int x = (int) (motionEvent.getX() - this.hnh);
                int y = this.hDS - ((int) (motionEvent.getY() - this.gLd));
                if (y > 0) {
                    this.hDP = y > this.hDK ? this.hDK : y;
                } else {
                    this.hDP = y < (-this.hDJ) ? -this.hDJ : y;
                }
                invalidate();
                v.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[]{Integer.valueOf(x), Integer.valueOf(r3), Integer.valueOf(y), Integer.valueOf(this.hDS)});
                break;
        }
        return true;
    }
}
