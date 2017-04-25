package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;

public class RegByMobileSetPwdUI extends SetPwdUI {
    private TextView iLR;
    private TextView khi;
    private String lPG = null;
    private View nLe;
    private TextView nLf;
    private boolean nLg = false;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] nKo = new int[a.bBj().length];

        static {
            try {
                nKo[a.nMx - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nKo[a.nMy - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nKo[a.nMA - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nKo[a.nMz - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lPG = getIntent().getStringExtra("kintent_hint");
        this.iPt = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.nLg = getIntent().getBooleanExtra("from_unbind", false);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904271;
    }

    protected final void NI() {
        TextView textView;
        TextView textView2;
        EditText editText;
        EditText editText2;
        float measureText;
        float measureText2;
        float max;
        if (!this.iPt) {
            bAb();
        }
        vD(2131234438);
        this.iLR = (TextView) findViewById(2131758815);
        this.nLe = findViewById(2131758866);
        this.khi = (TextView) findViewById(2131758865);
        this.nLf = (TextView) findViewById(2131758867);
        if (this.lPG != null && this.lPG.length() > 0) {
            this.khi.setText(this.lPG);
        }
        if (!this.nLg) {
            ak.yW();
            if (c.ww() != 0) {
                this.nLe.setVisibility(0);
                CharSequence xG = k.xG();
                if (be.kS(xG)) {
                    xG = k.xF();
                    if (u.LL(xG)) {
                        xG = null;
                    }
                }
                if (be.kS(xG)) {
                    ak.yW();
                    String str = (String) c.vf().get(6, null);
                    ak.yW();
                    String str2 = (String) c.vf().get(5, null);
                    if (!be.kS(str)) {
                        if (be.KT(str).booleanValue()) {
                            al alVar = new al();
                            str2 = "86";
                            if (str.startsWith("+")) {
                                str2 = str.replace("+", SQLiteDatabase.KeyEmpty);
                                str = al.vl(str2);
                                if (str != null) {
                                    str2 = str2.substring(str.length());
                                }
                            } else {
                                String str3 = str2;
                                str2 = str;
                                str = str3;
                            }
                            xG = al.formatNumber(str, str2);
                            this.nLf.setText(2131235056);
                            this.iLR.setText(xG);
                        }
                        this.khi.setText(2131234440);
                    } else if (be.kS(str2)) {
                        this.nLe.setVisibility(8);
                    } else {
                        this.iLR.setText(str2);
                        this.nLf.setText(2131235003);
                        this.khi.setText(2131234439);
                    }
                } else {
                    this.nLf.setText(2131235196);
                    this.iLR.setText(xG);
                }
                textView = (TextView) findViewById(2131758868);
                textView2 = (TextView) findViewById(2131758870);
                editText = (EditText) findViewById(2131758869);
                editText2 = (EditText) findViewById(2131758871);
                if (!com.tencent.mm.sdk.platformtools.u.bsU()) {
                    textView.setTextSize(1, 14.0f);
                    textView2.setTextSize(1, 14.0f);
                    editText.setTextSize(1, 14.0f);
                    editText2.setTextSize(1, 14.0f);
                }
                measureText = this.nLf.getPaint().measureText(this.nLf.getText().toString());
                measureText2 = textView.getPaint().measureText(textView.getText().toString());
                max = Math.max(Math.max(measureText, measureText2), textView2.getPaint().measureText(textView2.getText().toString()));
                this.nLf.setWidth((int) max);
                textView.setWidth((int) max);
                textView.setWidth((int) max);
            }
        }
        this.nLe.setVisibility(8);
        textView = (TextView) findViewById(2131758868);
        textView2 = (TextView) findViewById(2131758870);
        editText = (EditText) findViewById(2131758869);
        editText2 = (EditText) findViewById(2131758871);
        if (com.tencent.mm.sdk.platformtools.u.bsU()) {
            textView.setTextSize(1, 14.0f);
            textView2.setTextSize(1, 14.0f);
            editText.setTextSize(1, 14.0f);
            editText2.setTextSize(1, 14.0f);
        }
        measureText = this.nLf.getPaint().measureText(this.nLf.getText().toString());
        measureText2 = textView.getPaint().measureText(textView.getText().toString());
        max = Math.max(Math.max(measureText, measureText2), textView2.getPaint().measureText(textView2.getText().toString()));
        this.nLf.setWidth((int) max);
        textView.setWidth((int) max);
        textView.setWidth((int) max);
    }

    protected final String bAU() {
        return ((EditText) findViewById(2131758869)).getText().toString();
    }

    protected final String bAV() {
        return ((EditText) findViewById(2131758871)).getText().toString();
    }

    protected final void vU(int i) {
        switch (AnonymousClass1.nKo[i - 1]) {
            case 1:
                g.f(this, 2131234428, 2131234430);
                return;
            case 2:
                g.f(this, 2131234429, 2131234430);
                return;
            case 3:
                g.f(this, 2131235779, 2131234430);
                return;
            case 4:
                g.f(this, 2131235781, 2131234430);
                return;
            default:
                return;
        }
    }

    protected final boolean p(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return k(i, i2, str);
        }
        finish();
        return true;
    }

    public final boolean bAY() {
        return true;
    }
}
