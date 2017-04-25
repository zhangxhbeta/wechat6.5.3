package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.sns.lucky.b.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;

@a(3)
public class SnsLuckyMoneyNewYearMedalUI extends LuckyMoneyBaseUI {
    private Button fpp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        NI();
        v.aRm();
        oa(0);
        this.fpp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyNewYearMedalUI jgz;

            {
                this.jgz = r1;
            }

            public final void onClick(View view) {
                this.jgz.setResult(-1);
                this.jgz.finish();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        oa(8);
        this.fpp = (Button) findViewById(2131759392);
    }

    protected final int getLayoutId() {
        return 2130904463;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
