package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public final class b extends View {
    protected static int eTp = 32;
    protected static int eTq;
    protected static int eTr = 1;
    protected static int eTs;
    protected static int eTt = 10;
    protected static int eTu;
    protected static int eTv;
    protected static int eTw;
    protected int Zx;
    public Collection<com.tencent.mm.plugin.chatroom.c.a> eQh = new ArrayList();
    protected Paint eTA;
    protected Paint eTB;
    protected Paint eTC;
    protected int eTD;
    protected int eTE;
    protected int eTF;
    protected int eTG;
    protected int eTH;
    protected int eTI;
    protected int eTJ;
    protected int eTK;
    protected int eTL;
    private final StringBuilder eTM;
    protected boolean eTN = false;
    protected boolean eTO = false;
    protected int eTP = -1;
    protected int eTQ = -1;
    protected int eTR = -1;
    protected int eTS = -1;
    protected int eTT = -1;
    protected int eTU = -1;
    protected int eTV = -1;
    protected int eTW = 1;
    protected int eTX = 7;
    protected int eTY = this.eTX;
    private int eTZ = 0;
    protected int eTx = 80;
    protected Paint eTy;
    protected Paint eTz;
    protected Boolean eUa;
    protected int eUb = eTp;
    protected int eUc = 0;
    final Time eUd;
    private final Calendar eUe;
    private final Calendar eUf;
    private final Boolean eUg;
    public int eUh = 6;
    private DateFormatSymbols eUi = new DateFormatSymbols();
    public a eUj;
    protected int erl;
    protected int erm;
    private Context mContext;

    public interface a {
        void b(com.tencent.mm.plugin.chatroom.c.a aVar);
    }

    public b(Context context, TypedArray typedArray) {
        super(context);
        this.mContext = context;
        Resources resources = context.getResources();
        this.eUf = Calendar.getInstance();
        this.eUe = Calendar.getInstance();
        this.eUd = new Time(Time.getCurrentTimezone());
        this.eUd.setToNow();
        this.eTD = typedArray.getColor(0, resources.getColor(2131689907));
        this.eTE = typedArray.getColor(6, resources.getColor(2131689907));
        this.eTF = typedArray.getColor(7, resources.getColor(2131689907));
        this.eTG = typedArray.getColor(7, resources.getColor(2131689908));
        this.eTH = typedArray.getColor(5, resources.getColor(2131689907));
        this.eTJ = typedArray.getColor(3, resources.getColor(2131689907));
        this.eTK = typedArray.getColor(4, resources.getColor(2131689868));
        this.eTL = typedArray.getColor(1, resources.getColor(2131689984));
        this.eTI = typedArray.getColor(2, resources.getColor(2131689985));
        this.eUa = Boolean.valueOf(typedArray.getBoolean(17, false));
        this.eTM = new StringBuilder(50);
        eTs = typedArray.getDimensionPixelSize(8, resources.getDimensionPixelSize(2131493583));
        eTw = typedArray.getDimensionPixelSize(9, resources.getDimensionPixelSize(2131493585));
        eTu = typedArray.getDimensionPixelSize(10, resources.getDimensionPixelSize(2131493584));
        eTv = typedArray.getDimensionPixelOffset(11, resources.getDimensionPixelOffset(2131493459));
        eTq = typedArray.getDimensionPixelSize(12, resources.getDimensionPixelOffset(2131493554));
        this.eUb = (typedArray.getDimensionPixelSize(13, resources.getDimensionPixelOffset(2131493339)) - eTv) / 6;
        this.eUc = typedArray.getDimensionPixelSize(14, resources.getDimensionPixelOffset(2131493386));
        this.eUg = Boolean.valueOf(typedArray.getBoolean(15, true));
        this.eTB = new Paint();
        this.eTB.setAntiAlias(true);
        this.eTB.setTextSize((float) eTw);
        this.eTB.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.eTB.setColor(this.eTG);
        this.eTB.setTextAlign(Align.LEFT);
        this.eTB.setStyle(Style.FILL);
        this.eTA = new Paint();
        this.eTA.setFakeBoldText(true);
        this.eTA.setAntiAlias(true);
        this.eTA.setColor(this.eTI);
        this.eTA.setTextAlign(Align.CENTER);
        this.eTA.setStyle(Style.FILL);
        this.eTC = new Paint();
        this.eTC.setFakeBoldText(true);
        this.eTC.setAntiAlias(true);
        this.eTC.setColor(this.eTL);
        this.eTC.setTextAlign(Align.CENTER);
        this.eTC.setStyle(Style.FILL);
        this.eTy = new Paint();
        this.eTy.setAntiAlias(true);
        this.eTy.setTextSize((float) eTu);
        this.eTy.setColor(this.eTG);
        this.eTy.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.eTy.setStyle(Style.FILL);
        this.eTy.setTextAlign(Align.CENTER);
        this.eTy.setFakeBoldText(true);
        this.eTz = new Paint();
        this.eTz.setAntiAlias(true);
        this.eTz.setTextSize((float) eTs);
        this.eTz.setStyle(Style.FILL);
        this.eTz.setTextAlign(Align.CENTER);
        this.eTz.setFakeBoldText(false);
    }

    private void b(Canvas canvas) {
        int i = eTv - (eTu / 2);
        int i2 = (this.Zx - (this.eTx * 2)) / (this.eTX * 2);
        for (int i3 = 0; i3 < this.eTX; i3++) {
            int i4 = (((i3 * 2) + 1) * i2) + this.eTx;
            this.eUf.set(7, (this.eTW + i3) % this.eTX);
            canvas.drawText(this.eUi.getShortWeekdays()[this.eUf.get(7)].toUpperCase(Locale.getDefault()), (float) i4, (float) i, this.eTy);
        }
    }

    private int adD() {
        return (this.eTZ < this.eTW ? this.eTZ + this.eTX : this.eTZ) - this.eTW;
    }

    private boolean a(int i, Time time) {
        return this.erl < time.year || ((this.erl == time.year && this.erm < time.month) || (this.erm == time.month && i < time.monthDay));
    }

    private void c(Canvas canvas) {
        int i = (this.Zx - (this.eTx * 2)) / (this.eTX * 2);
        int i2 = (((this.eUb + eTs) / 2) - eTr) + eTv;
        int adD = adD();
        int i3 = 1;
        while (i3 <= this.eTY) {
            if (i3 <= this.eTV || -1 == this.eTV) {
                int i4 = this.eTx + (((adD * 2) + 1) * i);
                if ((this.erm == this.eTR && this.eTP == i3 && this.eTT == this.erl) || ((this.erm == this.eTS && this.eTQ == i3 && this.eTU == this.erl) || (this.eTN && this.eTV == i3 && this.eTP == -1))) {
                    if (this.eUa.booleanValue()) {
                        canvas.drawRoundRect(new RectF((float) (i4 - eTq), (float) ((i2 - (eTs / 3)) - eTq), (float) (eTq + i4), (float) ((i2 - (eTs / 3)) + eTq)), 10.0f, 10.0f, this.eTC);
                    } else {
                        canvas.drawCircle((float) i4, (float) (i2 - (eTs / 3)), (float) eTq, this.eTC);
                    }
                    if (this.eTN && this.eTV == i3 && this.eTP == -1) {
                        this.eTz.setColor(this.eTL);
                        this.eTz.setTypeface(Typeface.defaultFromStyle(0));
                        this.eTz.setTextSize(30.0f);
                        canvas.drawText(this.mContext.getResources().getString(2131235682), (float) i4, (float) ((i2 + 12) + eTq), this.eTz);
                    }
                }
                this.eTz.setTextSize((float) eTs);
                if (!(this.eTN && this.eTV == i3)) {
                    this.eTz.setColor(this.eTH);
                    this.eTz.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.eTP != -1 && this.eTQ != -1 && this.eTT == this.eTU && this.eTR == this.eTS && this.eTP == this.eTQ && i3 == this.eTP && this.erm == this.eTR && this.erl == this.eTT) {
                    this.eTz.setColor(this.eTL);
                }
                if (this.eTP != -1 && this.eTQ != -1 && this.eTT == this.eTU && this.eTT == this.erl && ((this.erm == this.eTR && this.eTS == this.eTR && ((this.eTP < this.eTQ && i3 > this.eTP && i3 < this.eTQ) || (this.eTP > this.eTQ && i3 < this.eTP && i3 > this.eTQ))) || ((this.eTR < this.eTS && this.erm == this.eTR && i3 > this.eTP) || ((this.eTR < this.eTS && this.erm == this.eTS && i3 < this.eTQ) || ((this.eTR > this.eTS && this.erm == this.eTR && i3 < this.eTP) || (this.eTR > this.eTS && this.erm == this.eTS && i3 > this.eTQ)))))) {
                    this.eTz.setColor(this.eTL);
                }
                if (!(this.eTP == -1 || this.eTQ == -1 || this.eTT == this.eTU || (((this.eTT != this.erl || this.erm != this.eTR) && (this.eTU != this.erl || this.erm != this.eTS)) || ((this.eTR >= this.eTS || this.erm != this.eTR || i3 >= this.eTP) && ((this.eTR >= this.eTS || this.erm != this.eTS || i3 <= this.eTQ) && ((this.eTR <= this.eTS || this.erm != this.eTR || i3 <= this.eTP) && (this.eTR <= this.eTS || this.erm != this.eTS || i3 >= this.eTQ))))))) {
                    this.eTz.setColor(this.eTL);
                }
                if (this.eTP != -1 && this.eTQ != -1 && this.eTT == this.eTU && this.erl == this.eTT && ((this.erm > this.eTR && this.erm < this.eTS && this.eTR < this.eTS) || (this.erm < this.eTR && this.erm > this.eTS && this.eTR > this.eTS))) {
                    this.eTz.setColor(this.eTL);
                }
                if (!(this.eTP == -1 || this.eTQ == -1 || this.eTT == this.eTU || ((this.eTT >= this.eTU || ((this.erm <= this.eTR || this.erl != this.eTT) && (this.erm >= this.eTS || this.erl != this.eTU))) && (this.eTT <= this.eTU || ((this.erm >= this.eTR || this.erl != this.eTT) && (this.erm <= this.eTS || this.erl != this.eTU)))))) {
                    this.eTz.setColor(this.eTL);
                }
                if (!this.eUg.booleanValue() && a(i3, this.eUd) && this.eUd.month == this.erm && this.eUd.year == this.erl) {
                    this.eTz.setColor(this.eTJ);
                    this.eTz.setTypeface(Typeface.defaultFromStyle(2));
                }
                for (com.tencent.mm.plugin.chatroom.c.a aVar : this.eQh) {
                    if (aVar.evg == i3 && aVar.month == this.erm && aVar.year == this.erl) {
                        this.eTz.setColor(this.eTK);
                        this.eTz.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                if ((this.erm == this.eTR && this.eTP == i3 && this.eTT == this.erl) || ((this.erm == this.eTS && this.eTQ == i3 && this.eTU == this.erl) || (this.eTN && this.eTV == i3 && this.eTP == -1))) {
                    this.eTz.setTypeface(Typeface.defaultFromStyle(0));
                    this.eTz.setColor(-1);
                }
                canvas.drawText(String.format("%d", new Object[]{Integer.valueOf(i3)}), (float) i4, (float) i2, this.eTz);
                adD++;
                if (adD == this.eTX) {
                    adD = 0;
                    i2 += this.eUb;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    protected final void onDraw(Canvas canvas) {
        int i = (((this.Zx - (this.eTx * 2)) / (this.eTX * 2)) + this.eTx) - (eTw / 2);
        int i2 = ((eTv - eTw) / 2) + eTw;
        this.eTM.setLength(0);
        long timeInMillis = this.eUe.getTimeInMillis();
        StringBuilder stringBuilder = new StringBuilder(DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52).toLowerCase());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        canvas.drawText(stringBuilder.toString(), (float) i, (float) i2, this.eTB);
        canvas.drawLine(0.0f, (float) eTv, (float) this.Zx, (float) (eTv + 1), this.eTB);
        b(canvas);
        c(canvas);
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), ((this.eUb * this.eUh) + eTv) + this.eUc);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.Zx = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            com.tencent.mm.plugin.chatroom.c.a aVar;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = this.eTx;
            if (x < ((float) i) || x > ((float) (this.Zx - this.eTx))) {
                aVar = null;
            } else {
                int adD = ((((int) (((x - ((float) i)) * ((float) this.eTX)) / ((float) ((this.Zx - i) - this.eTx)))) - adD()) + 1) + ((((int) (y - ((float) eTv))) / this.eUb) * this.eTX);
                if (this.erm > 11 || this.erm < 0 || com.tencent.mm.plugin.chatroom.e.a.bt(this.erm, this.erl) < adD || adD <= 0) {
                    aVar = null;
                } else {
                    com.tencent.mm.plugin.chatroom.c.a aVar2 = new com.tencent.mm.plugin.chatroom.c.a(this.erl, this.erm, adD);
                    for (com.tencent.mm.plugin.chatroom.c.a aVar3 : this.eQh) {
                        if (aVar3.equals(aVar2)) {
                            break;
                        }
                    }
                    aVar3 = null;
                }
            }
            if (!(aVar3 == null || this.eUj == null || (!this.eUg.booleanValue() && aVar3.month == this.eUd.month && aVar3.year == this.eUd.year && aVar3.evg < this.eUd.monthDay))) {
                this.eUj.b(aVar3);
            }
        }
        return true;
    }

    public final void c(HashMap<String, Integer> hashMap) {
        int i = 0;
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            int i2;
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.eUb = ((Integer) hashMap.get("height")).intValue();
                if (this.eUb < eTt) {
                    this.eUb = eTt;
                }
            }
            if (hashMap.containsKey("selected_begin_day")) {
                this.eTP = ((Integer) hashMap.get("selected_begin_day")).intValue();
            }
            if (hashMap.containsKey("selected_last_day")) {
                this.eTQ = ((Integer) hashMap.get("selected_last_day")).intValue();
            }
            if (hashMap.containsKey("selected_begin_month")) {
                this.eTR = ((Integer) hashMap.get("selected_begin_month")).intValue();
            }
            if (hashMap.containsKey("selected_last_month")) {
                this.eTS = ((Integer) hashMap.get("selected_last_month")).intValue();
            }
            if (hashMap.containsKey("selected_begin_year")) {
                this.eTT = ((Integer) hashMap.get("selected_begin_year")).intValue();
            }
            if (hashMap.containsKey("selected_last_year")) {
                this.eTU = ((Integer) hashMap.get("selected_last_year")).intValue();
            }
            this.erm = ((Integer) hashMap.get("month")).intValue();
            this.erl = ((Integer) hashMap.get("year")).intValue();
            this.eTN = false;
            this.eTV = -1;
            this.eUe.set(2, this.erm);
            this.eUe.set(1, this.erl);
            this.eUe.set(5, 1);
            this.eTZ = this.eUe.get(7);
            if (hashMap.containsKey("week_start")) {
                this.eTW = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.eTW = this.eUe.getFirstDayOfWeek();
            }
            this.eTY = com.tencent.mm.plugin.chatroom.e.a.bt(this.erm, this.erl);
            for (i2 = 0; i2 < this.eTY; i2++) {
                boolean z;
                int i3 = i2 + 1;
                Time time = this.eUd;
                if (this.erl == time.year && this.erm == time.month && i3 == time.monthDay) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.eTN = true;
                    this.eTV = i3;
                }
                this.eTO = a(i3, this.eUd);
            }
            i2 = adD();
            int i4 = (this.eTY + i2) / this.eTX;
            if ((i2 + this.eTY) % this.eTX > 0) {
                i = 1;
            }
            this.eUh = i4 + i;
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }
}
