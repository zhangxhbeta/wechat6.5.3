package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class c extends DatePicker implements g {
    public boolean dZf = true;
    public boolean dZg = true;
    public boolean dZh = true;
    public NumberPicker dZi;
    public NumberPicker dZj;
    public NumberPicker dZk;
    private Date dZl;
    private Date dZm;
    private final Calendar dZn;
    private final String[] dZo = new String[12];

    public c(Context context) {
        super(new ContextThemeWrapper(context, 2131559156));
        for (int i = 0; i < this.dZo.length; i++) {
            this.dZo[i] = (i + 1);
        }
        this.dZn = Calendar.getInstance(Locale.US);
        this.dZi = oM("mYearSpinner");
        this.dZj = oM("mMonthSpinner");
        this.dZk = oM("mDaySpinner");
        h.a(this.dZi);
        h.a(this.dZj);
        h.a(this.dZk);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        Drawable drawable = getResources().getDrawable(2130839544);
        h.a(this.dZi, drawable);
        h.a(this.dZj, drawable);
        h.a(this.dZk, drawable);
        OnValueChangeListener anonymousClass1 = new OnValueChangeListener(this) {
            final /* synthetic */ c dZp;

            {
                this.dZp = r1;
            }

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                this.dZp.bRP();
            }
        };
        if (this.dZi != null) {
            this.dZi.setOnValueChangedListener(anonymousClass1);
            this.dZi.setMinValue(1900);
        }
        if (this.dZj != null) {
            this.dZj.setOnValueChangedListener(anonymousClass1);
        }
        if (this.dZk != null) {
            this.dZk.setOnValueChangedListener(anonymousClass1);
        }
        bRP();
        h.c(this.dZi);
        h.c(this.dZj);
        h.c(this.dZk);
    }

    private void bRP() {
        int i = 0;
        if (this.dZi != null && this.dZj != null && this.dZk != null) {
            int i2;
            this.dZj.setDisplayedValues(null);
            if (this.dZi.getValue() != this.dZi.getMaxValue() || this.dZm == null) {
                this.dZj.setMaxValue(11);
                i2 = 0;
            } else {
                this.dZj.setMaxValue(this.dZm.getMonth());
                if (this.dZj.getValue() == this.dZj.getMaxValue() && this.dZm != null) {
                    this.dZk.setMaxValue(this.dZm.getDate());
                    i2 = 1;
                }
                i2 = 0;
            }
            if (i2 == 0) {
                this.dZn.set(this.dZi.getValue(), this.dZj.getValue(), 1);
                this.dZk.setMaxValue(this.dZn.getActualMaximum(5));
            }
            if (this.dZi.getValue() != this.dZi.getMinValue() || this.dZl == null) {
                this.dZj.setMinValue(0);
            } else {
                this.dZj.setMinValue(this.dZl.getMonth());
                if (this.dZj.getValue() == this.dZj.getMinValue() && this.dZl != null) {
                    this.dZk.setMinValue(this.dZl.getDate());
                    i = 1;
                }
            }
            if (i == 0) {
                this.dZk.setMinValue(1);
            }
            this.dZj.setDisplayedValues((String[]) Arrays.copyOfRange(this.dZo, this.dZj.getMinValue(), this.dZj.getMaxValue() + 1));
        }
    }

    public final void setMaxDate(long j) {
        super.setMaxDate(j);
        this.dZm = new Date(j);
        if (this.dZi != null) {
            this.dZi.setMaxValue(this.dZm.getYear() + 1900);
        }
    }

    public final void setMinDate(long j) {
        super.setMinDate(j);
        this.dZl = new Date(j);
        if (this.dZi != null) {
            this.dZi.setMinValue(this.dZl.getYear() + 1900);
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.b(this.dZi);
        h.b(this.dZj);
        h.b(this.dZk);
    }

    public final String To() {
        if (this.dZh) {
            return String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth())});
        } else if (this.dZg) {
            return String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth())});
        } else {
            return String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(getYear())});
        }
    }

    public final View getView() {
        return this;
    }

    public final void aEU() {
        bRP();
    }

    public final void init(int i, int i2, int i3, OnDateChangedListener onDateChangedListener) {
        super.init(i, Math.max(i2 - 1, 0), i3, onDateChangedListener);
        bRP();
    }

    public final int getYear() {
        if (this.dZi != null) {
            return this.dZi.getValue();
        }
        return super.getYear();
    }

    public final int getMonth() {
        int value;
        if (this.dZj != null) {
            value = this.dZj.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        return Math.max(Math.min(value, 12), 0);
    }

    public final int getDayOfMonth() {
        if (this.dZk != null) {
            return this.dZk.getValue();
        }
        return super.getDayOfMonth();
    }

    private NumberPicker oM(String str) {
        if (VERSION.SDK_INT >= 21) {
            return oO(str);
        }
        return oN(str);
    }

    private NumberPicker oN(String str) {
        try {
            return (NumberPicker) new com.tencent.mm.compatible.loader.c(this, str, null).get();
        } catch (Exception e) {
            return null;
        }
    }

    private NumberPicker oO(String str) {
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(this, "mDelegate", null).get();
            if (obj != null) {
                return (NumberPicker) new com.tencent.mm.compatible.loader.c(obj, str, null).get();
            }
        } catch (Exception e) {
        }
        return null;
    }
}
