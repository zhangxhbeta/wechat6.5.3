package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMPwdInputView extends LinearLayout {
    public StringBuilder eTM;
    private boolean hZs;
    public int hZt;
    private ImageView hZu;
    private ImageView hZv;
    private ImageView hZw;
    private ImageView hZx;
    public a hZy;
    private int hZz;

    public interface a {
        void f(boolean z, String str);
    }

    public enum b {
        ;

        static {
            hZA = 1;
            hZB = 2;
            hZC = new int[]{hZA, hZB};
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.eTM = new StringBuilder();
        this.hZs = false;
        this.hZz = b.hZB;
        View inflate = inflate(getContext(), 2130904207, null);
        this.hZu = (ImageView) inflate.findViewById(2131758672);
        this.hZv = (ImageView) inflate.findViewById(2131758673);
        this.hZw = (ImageView) inflate.findViewById(2131758674);
        this.hZx = (ImageView) inflate.findViewById(2131758675);
        this.hZu.setImageResource(2130837678);
        this.hZv.setImageResource(2130837678);
        this.hZw.setImageResource(2130837678);
        this.hZx.setImageResource(2130837678);
        addView(inflate);
    }

    public final void aHh() {
        for (int i = 0; i < 4; i++) {
            String str;
            if (this.hZt > i) {
                str = this.eTM.toString().charAt(i);
            } else {
                str = "";
            }
            switch (i) {
                case 0:
                    n(this.hZu, str);
                    break;
                case 1:
                    n(this.hZv, str);
                    break;
                case 2:
                    n(this.hZw, str);
                    break;
                case 3:
                    n(this.hZx, str);
                    break;
                default:
                    break;
            }
        }
    }

    private static void n(ImageView imageView, String str) {
        if (imageView != null) {
            if (str.equals("0")) {
                imageView.setImageResource(2130837668);
            } else if (str.equals("1")) {
                imageView.setImageResource(2130837669);
            } else if (str.equals("2")) {
                imageView.setImageResource(2130837670);
            } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                imageView.setImageResource(2130837671);
            } else if (str.equals("4")) {
                imageView.setImageResource(2130837672);
            } else if (str.equals("5")) {
                imageView.setImageResource(2130837673);
            } else if (str.equals("6")) {
                imageView.setImageResource(2130837674);
            } else if (str.equals("7")) {
                imageView.setImageResource(2130837675);
            } else if (str.equals("8")) {
                imageView.setImageResource(2130837676);
            } else if (str.equals("9")) {
                imageView.setImageResource(2130837677);
            } else {
                imageView.setImageResource(2130837678);
            }
        }
    }

    public final void aHi() {
        if (this.eTM != null) {
            this.hZt = this.eTM.length();
        } else {
            this.hZt = 0;
        }
        if (this.hZt >= 4) {
            this.hZs = true;
        } else {
            this.hZs = false;
        }
        if (this.hZy != null) {
            this.hZy.f(this.hZs, this.eTM.toString());
        }
    }

    public final void Kz() {
        if (this.hZt > 0) {
            this.eTM.delete(0, this.hZt);
        }
        aHi();
        aHh();
    }

    public final void input(String str) {
        if (!TextUtils.isEmpty(str) && !this.hZs) {
            this.eTM.append(str);
            aHi();
            aHh();
        }
    }
}
