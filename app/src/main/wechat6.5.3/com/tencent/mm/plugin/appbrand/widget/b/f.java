package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.mm.compatible.loader.c;
import java.util.Locale;

public final class f extends TimePicker implements g {
    public int dKX = -1;
    public int dKY = -1;
    public int dKZ = -1;
    public int dLa = -1;
    private NumberPicker dZA;
    public NumberPicker dZz;

    public f(Context context) {
        super(new ContextThemeWrapper(context, 2131559156));
        setIs24HourView(Boolean.valueOf(true));
        this.dZz = oM("mHourSpinner");
        this.dZA = oM("mMinuteSpinner");
        h.a(this.dZz);
        h.a(this.dZA);
        Drawable drawable = getResources().getDrawable(2130839544);
        h.a(this.dZz, drawable);
        h.a(this.dZA, drawable);
        if (this.dZz != null) {
            this.dZz.setOnValueChangedListener(new OnValueChangeListener(this) {
                final /* synthetic */ f dZB;

                {
                    this.dZB = r1;
                }

                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    this.dZB.Tp();
                }
            });
        }
        if (this.dZA != null && VERSION.SDK_INT >= 21) {
            this.dZA.setOnValueChangedListener(new OnValueChangeListener(this) {
                final /* synthetic */ f dZB;

                {
                    this.dZB = r1;
                }

                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                }
            });
        }
        h.c(this.dZz);
        h.c(this.dZA);
    }

    public final void Tp() {
        if (i.hN(this.dKX) && i.hM(this.dKY) && this.dZz != null && this.dZA != null) {
            if (this.dZz.getValue() == this.dKX) {
                this.dZA.setMinValue(this.dKY);
            } else {
                this.dZA.setMinValue(0);
            }
        }
        if (i.hN(this.dKZ) && this.dZz != null && this.dZA != null) {
            if (this.dZz.getValue() == this.dKZ) {
                this.dZA.setMaxValue(this.dLa);
            } else {
                this.dZA.setMaxValue(59);
            }
        }
    }

    public final void setCurrentMinute(Integer num) {
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        Tp();
    }

    public final void setCurrentHour(Integer num) {
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        Tp();
    }

    private NumberPicker oM(String str) {
        if (VERSION.SDK_INT >= 21) {
            return oO(str);
        }
        return oN(str);
    }

    private NumberPicker oN(String str) {
        try {
            return (NumberPicker) new c(this, str, null).get();
        } catch (Exception e) {
            return null;
        }
    }

    private NumberPicker oO(String str) {
        try {
            Object obj = new c(this, "mDelegate", null).get();
            if (obj != null) {
                return (NumberPicker) new c(obj, str, null).get();
            }
        } catch (Exception e) {
        }
        return null;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.b(this.dZz);
        h.b(this.dZA);
    }

    public final String To() {
        return String.format(Locale.US, "%02d:%02d", new Object[]{getCurrentHour(), getCurrentMinute()});
    }

    public final View getView() {
        return this;
    }

    public final void aEU() {
    }
}
