package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends DatePickerDialog {
    private boolean pcm;
    private long pcn;
    private int pco;

    class a {
        final /* synthetic */ g pcp;

        a(g gVar) {
            this.pcp = gVar;
        }

        @TargetApi(11)
        public final NumberPicker j(ViewGroup viewGroup) {
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    NumberPicker numberPicker;
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof NumberPicker) {
                        numberPicker = (NumberPicker) childAt;
                        if (numberPicker.getMaxValue() >= 28 && numberPicker.getMaxValue() <= 31) {
                            return numberPicker;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        numberPicker = j((ViewGroup) childAt);
                        if (numberPicker != null) {
                            return numberPicker;
                        }
                    }
                }
            }
            return null;
        }
    }

    class b {
        final /* synthetic */ g pcp;

        b(g gVar) {
            this.pcp = gVar;
        }

        public final View d(ViewGroup viewGroup, int i) {
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt = viewGroup.getChildAt(i2);
                    Class cls = childAt.getClass();
                    v.d("MicroMsg.MMDatePickerDialog", "NAME = " + cls.getName());
                    v.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + cls.getSimpleName());
                    if ("NumberPicker".equals(cls.getSimpleName()) && i2 == i) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        childAt = d((ViewGroup) childAt, i);
                        if (childAt != null) {
                            return childAt;
                        }
                    }
                    i2++;
                }
            }
            return null;
        }
    }

    public g(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.pcm = true;
        this.pcm = true;
        this.pcn = j;
        this.pco = 1;
    }

    public g(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, byte b) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.pcm = true;
        this.pcm = true;
        this.pcn = j;
        this.pco = 2;
    }

    public g(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, String str) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.pcm = true;
        this.pcm = true;
        this.pcn = j;
        if (str != null) {
            if (str.equals("month")) {
                this.pco = 2;
                return;
            }
        }
        this.pco = 1;
    }

    @SuppressLint({"DefaultLocale"})
    public final void show() {
        int i = 1;
        super.show();
        if (this.pcm) {
            View j;
            if (VERSION.SDK_INT >= 11) {
                j = new a(this).j((ViewGroup) getWindow().getDecorView());
                if (j != null && this.pco > 1) {
                    j.setVisibility(8);
                }
            } else {
                Object string = System.getString(getContext().getContentResolver(), "date_format");
                if (string != null) {
                    string = string.toLowerCase();
                }
                if ("dd/mm/yyyy".equals(string) || "dd-mm-yyyy".equals(string)) {
                    i = 0;
                } else if (!("mm/dd/yyyy".equals(string) || "mm-dd-yyyy".equals(string))) {
                    i = ("yyyy/mm/dd".equals(string) || "yyyy-mm-dd".equals(string)) ? 2 : -1;
                }
                if (i != -1) {
                    j = new b(this).d((ViewGroup) getWindow().getDecorView(), i);
                    if (j != null) {
                        j.setVisibility(8);
                    }
                }
            }
            int year = getDatePicker().getYear();
            i = getDatePicker().getMonth();
            getDatePicker().getDayOfMonth();
            dz(year, i);
        }
        this.pcm = false;
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        super.onDateChanged(datePicker, i, i2, i3);
        dz(i, i2);
    }

    private void dz(int i, int i2) {
        if (this.pco > 1) {
            setTitle(getContext().getString(2131232940, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1)}));
        }
    }
}
