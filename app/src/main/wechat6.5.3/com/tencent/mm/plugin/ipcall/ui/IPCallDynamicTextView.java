package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView extends TextView {
    private int QW;
    private double gLC;
    private double gLD;
    private double gLE;
    private boolean gLF;
    private int gLG = 4000;
    private int gLH = 50;
    DecimalFormat gLI = new DecimalFormat("0.00");
    private String gLJ = "";
    private String gLK = "";
    private ac mHandler = new ac(this) {
        final /* synthetic */ IPCallDynamicTextView gLL;

        {
            this.gLL = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if ((this.gLL.gLC <= 0.0d || this.gLL.gLD >= this.gLL.gLE) && (this.gLL.gLC >= 0.0d || this.gLL.gLD <= this.gLL.gLE)) {
                        this.gLL.gLF = false;
                        IPCallDynamicTextView.a(this.gLL, this.gLL.gLE);
                        return;
                    }
                    this.gLL.gLF = true;
                    IPCallDynamicTextView.a(this.gLL, this.gLL.gLD);
                    IPCallDynamicTextView.b(this.gLL, this.gLL.gLC);
                    this.gLL.mHandler.sendEmptyMessageDelayed(1, (long) this.gLL.gLH);
                    return;
                default:
                    return;
            }
        }
    };
    private String mValue;

    static /* synthetic */ void a(IPCallDynamicTextView iPCallDynamicTextView, double d) {
        if (d == iPCallDynamicTextView.gLE) {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.mValue);
        } else {
            iPCallDynamicTextView.setText(iPCallDynamicTextView.gLJ + iPCallDynamicTextView.gLI.format(d) + iPCallDynamicTextView.gLK);
        }
    }

    static /* synthetic */ double b(IPCallDynamicTextView iPCallDynamicTextView, double d) {
        double d2 = iPCallDynamicTextView.gLD + d;
        iPCallDynamicTextView.gLD = d2;
        return d2;
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ IPCallDynamicTextView gLL;

            {
                this.gLL = r1;
            }

            public final void onGlobalLayout() {
                if (this.gLL.gLD != this.gLL.gLE) {
                    this.gLL.mHandler.sendEmptyMessage(1);
                }
            }
        });
    }

    public final void bR(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            setText(str2);
            return;
        }
        try {
            this.gLD = Double.parseDouble(uZ(str));
            this.gLJ = "";
            int i = 0;
            while (i < str2.length() && !Character.isDigit(str2.charAt(i))) {
                this.gLJ += str2.charAt(i);
                i++;
            }
            this.gLK = "";
            i = str2.length() - 1;
            while (i > 0 && !Character.isDigit(str2.charAt(i))) {
                this.gLK += str2.charAt(i);
                i--;
            }
            try {
                this.gLE = Double.parseDouble(str2.substring(this.gLJ.length(), str2.length() - this.gLK.length()));
                this.mValue = str2;
                this.gLC = (this.gLE - this.gLD) / ((double) (this.gLG / this.gLH));
                if (this.gLC == 0.0d) {
                    setText(str2);
                    return;
                }
                this.gLC = new BigDecimal(this.gLC).setScale(2, 4).doubleValue();
                if (isShown()) {
                    this.mHandler.sendEmptyMessage(1);
                }
            } catch (NumberFormatException e) {
                setText(str2);
            }
        } catch (NumberFormatException e2) {
            setText(str2);
        }
    }

    public static String uZ(String str) {
        String str2 = "";
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            str2 = str2 + str.charAt(i);
            i++;
        }
        String str3 = "";
        i = str.length() - 1;
        while (i > 0 && !Character.isDigit(str.charAt(i))) {
            str3 = str3 + str.charAt(i);
            i--;
        }
        return str.substring(str2.length(), str.length() - str3.length());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.QW = getMeasuredHeight();
    }
}
