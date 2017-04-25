package com.tencent.mm.ui.bindmobile;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BindMContactStatusUI extends MMWizardActivity {
    private Button emR;
    private ImageView nMR;
    private TextView nMS;
    private TextView ofH;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131231429);
        NI();
    }

    protected final int getLayoutId() {
        return 2130903173;
    }

    protected final void NI() {
        this.nMR = (ImageView) findViewById(2131755585);
        this.ofH = (TextView) findViewById(2131755586);
        this.nMS = (TextView) findViewById(2131755618);
        this.emR = (Button) findViewById(2131755588);
        if (m.EY() == a.SUCC) {
            this.nMR.setImageResource(2131165695);
            ak.yW();
            String str = (String) c.vf().get(6, null);
            if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
                ak.yW();
                str = (String) c.vf().get(4097, null);
            }
            this.nMS.setText(getString(2131231425));
            this.ofH.setText(getString(2131231448, new Object[]{str}));
        } else {
            this.nMR.setImageResource(2131165696);
            this.nMS.setText(2131231436);
            this.ofH.setText(2131231436);
            this.nMS.setVisibility(8);
        }
        this.emR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactStatusUI ofI;

            {
                this.ofI = r1;
            }

            public final void onClick(View view) {
                this.ofI.bAv();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bAv();
        return true;
    }
}
