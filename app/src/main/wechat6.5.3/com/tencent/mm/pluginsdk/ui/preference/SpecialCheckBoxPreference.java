package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.mm.ak.k;
import com.tencent.mm.i.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference extends Preference {
    private boolean bhx;
    private boolean eJx = false;
    private boolean ePa;
    private String ePn;
    private u fnD;
    private ToggleButton lQC;
    private ToggleButton lQD;
    private ToggleButton lQE;
    private OnCheckedChangeListener lQF = new OnCheckedChangeListener(this) {
        final /* synthetic */ SpecialCheckBoxPreference lQG;

        {
            this.lQG = r1;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int id = compoundButton.getId();
            if (id == 2131758236) {
                SpecialCheckBoxPreference.a(this.lQG);
            } else if (id == 2131758237) {
                SpecialCheckBoxPreference.b(this.lQG);
            } else if (id == 2131758238) {
                SpecialCheckBoxPreference.c(this.lQG);
            }
        }
    };
    private Context mContext;

    static /* synthetic */ void a(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.fnD != null) {
            ak.yW();
            if (c.wK().Mn(specialCheckBoxPreference.fnD.field_username)) {
                m.m(specialCheckBoxPreference.fnD.field_username, true);
            } else {
                m.l(specialCheckBoxPreference.fnD.field_username, true);
            }
        }
    }

    static /* synthetic */ void b(SpecialCheckBoxPreference specialCheckBoxPreference) {
        int i = 0;
        specialCheckBoxPreference.eJx = !specialCheckBoxPreference.eJx;
        if (specialCheckBoxPreference.bhx) {
            if (!specialCheckBoxPreference.eJx) {
                i = 1;
            }
            ak.yW();
            c.wG().b(new k(specialCheckBoxPreference.ePn, i));
            specialCheckBoxPreference.fnD.cZ(i);
            ak.yW();
            c.wH().a(specialCheckBoxPreference.ePn, specialCheckBoxPreference.fnD);
        }
        specialCheckBoxPreference.bqI();
    }

    static /* synthetic */ void c(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.fnD == null) {
            return;
        }
        if (a.ei(specialCheckBoxPreference.fnD.field_type)) {
            specialCheckBoxPreference.fnD.tq();
            m.r(specialCheckBoxPreference.fnD);
            g.bf(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(2131234642));
            return;
        }
        m.o(specialCheckBoxPreference.fnD);
        g.bf(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(2131234657));
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lQC = (ToggleButton) view.findViewById(2131758236);
        this.lQD = (ToggleButton) view.findViewById(2131758237);
        this.lQE = (ToggleButton) view.findViewById(2131758238);
        this.ePn = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.bhx = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ePa = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        ak.yW();
        this.fnD = c.wH().LX(this.ePn);
        if (this.fnD != null) {
            ToggleButton toggleButton = this.lQC;
            ak.yW();
            toggleButton.setChecked(c.wK().Mn(this.fnD.field_username));
            this.lQE.setChecked(a.ei(this.fnD.field_type));
            this.lQD.setChecked(bqI());
        }
        this.lQC.setOnCheckedChangeListener(this.lQF);
        this.lQD.setOnCheckedChangeListener(this.lQF);
        this.lQE.setOnCheckedChangeListener(this.lQF);
    }

    private boolean bqI() {
        if (this.bhx) {
            this.eJx = this.fnD.bCh == 0;
        } else if (!this.ePa) {
            this.eJx = this.fnD.tM();
        }
        if (!(this.mContext instanceof MMActivity)) {
            return false;
        }
        if (this.eJx) {
            ((MMActivity) this.mContext).vI(0);
            return true;
        }
        ((MMActivity) this.mContext).vI(8);
        return false;
    }
}
