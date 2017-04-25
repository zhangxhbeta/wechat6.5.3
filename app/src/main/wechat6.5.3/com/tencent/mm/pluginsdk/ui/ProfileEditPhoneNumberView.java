package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView extends ProfileItemView implements com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a {
    public String lHr;
    public String lHs;
    public String[] lHt;
    private LinearLayout lHu;
    private boolean lHv = false;
    public a lHw;

    public interface a {
        void Yj();

        void boN();
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aGY() {
        return 2130904197;
    }

    public final void init() {
        this.lHu = (LinearLayout) findViewById(2131758661);
    }

    public void clearFocus() {
        for (int i = 1; i < this.lHu.getChildCount(); i++) {
            this.lHu.getChildAt(i).clearFocus();
        }
    }

    public final boolean H(u uVar) {
        this.fnD = uVar;
        return true;
    }

    public final boolean aGZ() {
        int i;
        int i2;
        if (be.kS(this.lHr)) {
            i = 0;
            i2 = 0;
        } else {
            aE(this.lHr, true);
            i = 1;
            i2 = 1;
        }
        if (!be.kS(this.lHs)) {
            this.lHt = this.lHs.split(",");
            while (i2 < this.lHt.length + i) {
                aE(this.lHt[i2 - i].trim(), false);
                i2++;
            }
        }
        if (i2 < 5) {
            aE(null, false);
            this.lHv = false;
        } else {
            this.lHv = true;
        }
        return false;
    }

    public final ArrayList<String> boL() {
        int childCount = this.lHu.getChildCount();
        if (childCount == 1) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList(childCount - 1);
        for (int i = 1; i < childCount; i++) {
            String obj = ((MMPhoneNumberEditText) this.lHu.getChildAt(i)).getText().toString();
            if (!be.kS(obj)) {
                arrayList.add(obj);
            }
        }
        if (!be.kS(this.lHr)) {
            arrayList.remove(0);
        }
        return arrayList;
    }

    private void boM() {
        if (this.lHw != null) {
            this.lHw.Yj();
        }
    }

    public final void f(final MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (mMPhoneNumberEditText.lGW) {
            g.a(getContext(), 2131233283, 0, 2131233282, 2131233281, new OnClickListener(this) {
                final /* synthetic */ ProfileEditPhoneNumberView lHy;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lHy.lHr = SQLiteDatabase.KeyEmpty;
                    this.lHy.lHw.boN();
                    this.lHy.h(mMPhoneNumberEditText);
                    if (!this.lHy.lHv) {
                        this.lHy.aE(null, false);
                    }
                }
            }, null);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.lHv) {
            aE(null, false);
            this.lHv = false;
        }
        boM();
    }

    public final void boF() {
        if (this.lHu.getChildCount() - 1 < 5) {
            aE(null, false);
        } else {
            this.lHv = true;
        }
        boM();
    }

    public final void g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (this.lHu.getChildCount() - 1 != 1) {
            h(mMPhoneNumberEditText);
            if (this.lHv) {
                aE(null, false);
            }
            this.lHv = false;
            boM();
        }
    }

    private void aE(String str, boolean z) {
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(2130904196, null);
        if (z) {
            mMPhoneNumberEditText.lGW = true;
            mMPhoneNumberEditText.lGU = mMPhoneNumberEditText.getResources().getDrawable(2131165619);
            mMPhoneNumberEditText.lGU.setBounds(0, 0, mMPhoneNumberEditText.lGU.getIntrinsicWidth(), mMPhoneNumberEditText.lGU.getIntrinsicHeight());
            mMPhoneNumberEditText.setFocusable(false);
            mMPhoneNumberEditText.boD();
        }
        mMPhoneNumberEditText.lGV = this;
        mMPhoneNumberEditText.setText(str);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, com.tencent.mm.bd.a.fromDPToPix(getContext(), 12), 0, 0);
        this.lHu.addView(mMPhoneNumberEditText, layoutParams);
    }

    private void h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.lHu.removeView(mMPhoneNumberEditText);
        this.lHu.getChildAt(this.lHu.getChildCount() - 1).requestFocus();
    }
}
