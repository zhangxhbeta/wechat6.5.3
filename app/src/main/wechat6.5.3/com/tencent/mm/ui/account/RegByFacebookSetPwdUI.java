package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;

public class RegByFacebookSetPwdUI extends SetPwdUI {

    static /* synthetic */ class AnonymousClass2 {
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
        this.bax = getIntent().getStringExtra("setpwd_ticket");
        vD(2131234419);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904267;
    }

    protected final void NI() {
        vD(2131234419);
    }

    protected final ProgressDialog a(Context context, String str, String str2, OnCancelListener onCancelListener) {
        return g.a(context, getString(2131234410), true, onCancelListener);
    }

    protected final k a(String str, String str2, are com_tencent_mm_protocal_c_are) {
        return new ac(str);
    }

    protected final String bAU() {
        return ((EditText) findViewById(2131758855)).getText().toString();
    }

    protected final String bAV() {
        return ((EditText) findViewById(2131758856)).getText().toString();
    }

    protected final int bAW() {
        return 382;
    }

    protected final void vU(int i) {
        switch (AnonymousClass2.nKo[i - 1]) {
            case 1:
                g.f(this, 2131234406, 2131234408);
                return;
            case 2:
                g.f(this, 2131234407, 2131234408);
                return;
            case 3:
                g.f(this, 2131235779, 2131231040);
                return;
            case 4:
                g.f(this, 2131235781, 2131231040);
                return;
            default:
                return;
        }
    }

    protected final boolean p(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return k(i, i2, str);
        }
        ak.yW();
        c.vf().set(57, Integer.valueOf(0));
        ak.yW();
        g.a((Context) this, getString(2131234417, new Object[]{(String) c.vf().get(5, null)}), getString(2131234408), new OnClickListener(this) {
            final /* synthetic */ RegByFacebookSetPwdUI nKn;

            {
                this.nKn = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.nKn.finish();
            }
        });
        return true;
    }
}
