package com.tencent.mm.plugin.appbrand.widget.b;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.mm.compatible.loader.c;

final class h {
    static void a(NumberPicker numberPicker, Drawable drawable) {
        if (numberPicker != null) {
            try {
                new c(numberPicker, "mSelectionDivider", null).set(drawable);
            } catch (Exception e) {
            }
        }
    }

    static void a(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                EditText editText = (EditText) new c(numberPicker, "mInputText", null).get();
                if (editText != null) {
                    editText.setClickable(false);
                    editText.setFocusable(false);
                    editText.setFocusableInTouchMode(false);
                }
            } catch (Exception e) {
            }
        }
    }

    static void b(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                EditText editText = (EditText) new c(numberPicker, "mInputText", null).get();
                if (editText != null) {
                    editText.setFilters(new InputFilter[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    static void c(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                Runnable runnable = (Runnable) new c(numberPicker, "mSetSelectionCommand", null).get();
                if (runnable != null) {
                    numberPicker.removeCallbacks(runnable);
                }
            } catch (Exception e) {
            }
        }
    }
}
