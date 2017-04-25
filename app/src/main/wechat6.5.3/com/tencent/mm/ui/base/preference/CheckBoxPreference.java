package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public class CheckBoxPreference extends Preference {
    private TextView kLc;
    private int kLd;
    private String kLe;
    private int kLf;
    private MMSwitchBtn nHn;
    public boolean ocf;

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ocf = false;
        this.kLd = -1;
        this.kLe = SQLiteDatabase.KeyEmpty;
        this.kLf = 8;
        setLayoutResource(2130904067);
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.nHn = (MMSwitchBtn) view.findViewById(2131755241);
        this.nHn.pdu = new a(this) {
            final /* synthetic */ CheckBoxPreference ocg;

            {
                this.ocg = r1;
            }

            public final void gB(boolean z) {
                this.ocg.callChangeListener(Boolean.valueOf(z));
            }
        };
        this.nHn.kq(this.ocf);
        this.kLc = (TextView) view.findViewById(2131758294);
        bh(this.kLe, this.kLd);
        sl(this.kLf);
    }

    public final boolean isChecked() {
        if (this.nHn != null) {
            return this.nHn.pdq;
        }
        return this.ocf;
    }

    public final void jx(boolean z) {
        if (this.nHn != null) {
            this.ocf = z;
            this.nHn.kq(z);
        }
    }

    public void bh(String str, int i) {
        this.kLd = i;
        this.kLe = str;
        if (this.kLc != null) {
            if (i > 0) {
                this.kLc.setBackgroundResource(this.kLd);
            }
            if (!TextUtils.isEmpty(this.kLe)) {
                this.kLc.setText(this.kLe);
            }
        }
    }

    public void sl(int i) {
        this.kLf = i;
        if (this.kLc != null) {
            this.kLc.setVisibility(this.kLf);
        }
    }
}
