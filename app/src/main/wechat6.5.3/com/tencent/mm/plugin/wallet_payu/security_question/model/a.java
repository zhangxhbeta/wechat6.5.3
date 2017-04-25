package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public final class a extends d {
    private Bundle fNM;

    public a(MMActivity mMActivity, f fVar, Bundle bundle) {
        super(mMActivity, fVar);
        this.fNM = bundle;
    }

    public final boolean o(Object... objArr) {
        this.piS.a(new c(this.fNM.getString("payu_reference")), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof c) && i == 0 && i2 == 0) {
            c cVar = (c) kVar;
            this.fNM.putParcelable("key_security_question", new PayUSecurityQuestion(cVar.id, cVar.laC));
            return false;
        } else if (!(kVar instanceof b)) {
            return false;
        } else {
            b bVar = (b) kVar;
            if (i != 0 || i2 != 0 || !bVar.kRC) {
                return false;
            }
            this.fNM.putString("payu_reference", bVar.laB);
            com.tencent.mm.wallet_core.a.k(this.piR, this.fNM);
            return true;
        }
    }

    public final boolean j(Object... objArr) {
        PayUSecurityQuestion payUSecurityQuestion = (PayUSecurityQuestion) this.fNM.getParcelable("key_security_question");
        String string = this.fNM.getString("key_question_answer");
        this.piS.a(new b(this.fNM.getString("payu_reference"), payUSecurityQuestion.id, string), true);
        return false;
    }
}
