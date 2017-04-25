package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView extends LinearLayout {
    private int eZC = 100;
    private int gRw;
    private Context mContext;
    private int mScreenWidth;
    private String nUA;
    public ArrayList<MMAutoSwitchEditText> nUB = new ArrayList();
    private c nUC = new c();
    public a nUD;
    public b nUE;
    private int nUy;
    private int nUz;

    public interface a {
        void Og(String str);
    }

    public interface b {
        void bAM();
    }

    private class c implements com.tencent.mm.ui.base.MMAutoSwitchEditText.b, com.tencent.mm.ui.base.MMAutoSwitchEditText.c, d {
        final /* synthetic */ MMAutoSwitchEditTextView nUF;

        private c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView) {
            this.nUF = mMAutoSwitchEditTextView;
        }

        public final void ws(int i) {
            String str = SQLiteDatabase.KeyEmpty;
            Iterator it = this.nUF.nUB.iterator();
            while (it.hasNext()) {
                String str2;
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (be.kS(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (be.kS(str) || str.length() != this.nUF.nUy * this.nUF.gRw) {
                if (this.nUF.nUE != null) {
                    this.nUF.nUE.bAM();
                }
                if (this.nUF.nUB != null && i < this.nUF.nUB.size() - 1) {
                    mMAutoSwitchEditText = (MMAutoSwitchEditText) this.nUF.nUB.get(i + 1);
                    if (mMAutoSwitchEditText != null) {
                        mMAutoSwitchEditText.requestFocus();
                    }
                }
            } else if (this.nUF.nUD != null) {
                this.nUF.nUD.Og(str);
            }
        }

        public final void wr(int i) {
            if (this.nUF.nUB != null && i < this.nUF.nUB.size() && i != 0) {
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) this.nUF.nUB.get(i - 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
        }

        public final void bBQ() {
            String str = SQLiteDatabase.KeyEmpty;
            Iterator it = this.nUF.nUB.iterator();
            while (it.hasNext()) {
                String str2;
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (be.kS(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (this.nUF.nUE != null) {
                this.nUF.nUE.bAM();
            }
        }
    }

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aOV);
        this.nUy = obtainStyledAttributes.getInteger(0, 3);
        this.gRw = obtainStyledAttributes.getInteger(1, 4);
        this.nUz = obtainStyledAttributes.getInteger(2, 2);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.nUA = context.getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (context instanceof Activity) {
            this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
            this.eZC = ((this.mScreenWidth - 80) - ((this.nUy - 1) * 20)) / this.nUy;
        }
        setPadding(com.tencent.mm.bd.a.fromDPToPix(context, 20), 0, com.tencent.mm.bd.a.fromDPToPix(context, 20), 0);
        bBR();
    }

    private void bBR() {
        for (int i = 0; i < this.nUy; i++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, 2130903142, null);
            mMAutoSwitchEditText.setInputType(this.nUz);
            if (this.nUA != null && this.nUA.length() > 0) {
                mMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.nUA));
            }
            mMAutoSwitchEditText.nUt.mIndex = i;
            mMAutoSwitchEditText.nUt.nUx = this.gRw;
            mMAutoSwitchEditText.nUt.nUu = this.nUC;
            mMAutoSwitchEditText.nUt.nUv = this.nUC;
            mMAutoSwitchEditText.nUt.nUw = this.nUC;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eZC, -2);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            } else {
                layoutParams.leftMargin = 0;
            }
            layoutParams.weight = 1.0f;
            mMAutoSwitchEditText.setLayoutParams(layoutParams);
            this.nUB.add(mMAutoSwitchEditText);
            addView(mMAutoSwitchEditText);
        }
    }
}
