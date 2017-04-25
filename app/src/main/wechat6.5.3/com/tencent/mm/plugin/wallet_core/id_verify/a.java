package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.e.a.qs;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.a.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class a extends b {
    private int aKK = 0;
    private boolean eDI = false;
    private String kLK = null;
    private String kLL = null;
    private boolean kLM = false;
    private int kLN = -1;
    private int mMode;

    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        boolean z;
        t("start", activity, bundle);
        if (this.fNM == null) {
            this.fNM = new Bundle();
        }
        if (bundle == null) {
            bundle = this.fNM;
        }
        if (bundle != null) {
            this.mMode = bundle.getInt("real_name_verify_mode", 0);
        } else {
            this.mMode = 0;
        }
        this.kLN = this.mMode;
        bundle.putBoolean("key_is_realname_verify_process", true);
        this.kLK = bundle.getString("realname_verify_process_jump_plugin", "");
        this.kLL = bundle.getString("realname_verify_process_jump_activity", "");
        if (bundle.getInt("realname_verify_process_allow_idverify", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.kLM = z;
        v.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[]{Boolean.valueOf(this.kLM), this.kLK, this.kLL});
        switch (this.mMode) {
            case 0:
                b(activity, SwitchRealnameVerifyModeUI.class, bundle);
                break;
            case 1:
                bundle.putBoolean("key_need_bind_response", true);
                super.c(activity, bundle);
                break;
            case 2:
                b(activity, WalletRealNameVerifyUI.class, bundle);
                break;
        }
        return this;
    }

    public final void d(Activity activity, int i) {
        t("back", activity, Integer.valueOf(i));
        if (activity instanceof SwitchRealnameVerifyModeUI) {
            if (i == 0) {
                d(activity, this.fNM);
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.kLN != 0) {
                d(activity, this.fNM);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            d(activity, this.fNM);
        }
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        t("forward", activity, "actionCode:" + i, bundle);
        int i2 = this.fNM.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i2) {
            this.mMode = i2;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                b(activity, WalletSetPasswordUI.class, bundle);
            } else if (activity instanceof WalletSetPasswordUI) {
                b(activity, WalletPwdConfirmUI.class, bundle);
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                b(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (k.bga().bgv()) {
                    b(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    b(activity, WalletBankcardIdUI.class, bundle);
                }
            } else if (activity instanceof WalletCheckPwdUI) {
                b(activity, WalletBankcardIdUI.class, bundle);
            } else {
                super.a(activity, i, bundle);
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final void d(final Activity activity, Bundle bundle) {
        Bundle bundle2;
        t("end", activity, bundle);
        if (bundle == null) {
            bundle2 = this.fNM;
        } else {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (this.mMode == 1) {
            bKY();
            if (bundle2.getBoolean("intent_bind_end", false)) {
                this.aKK = -1;
            } else {
                this.aKK = 0;
            }
        } else if (bundle2.containsKey("realname_verify_process_ret")) {
            this.aKK = bundle2.getInt("realname_verify_process_ret", -1);
        } else {
            this.aKK = 0;
        }
        if (bundle2.containsKey("intent_bind_end")) {
            bundle2.remove("intent_bind_end");
        }
        if (bundle2.containsKey("key_is_bind_reg_process")) {
            bundle2.remove("key_is_bind_reg_process");
        }
        bundle2.putInt("realname_verify_process_ret", this.aKK);
        final Intent intent = new Intent();
        intent.putExtras(bundle2);
        if (this.aKK == -1) {
            Toast.makeText(activity, activity.getString(2131234344), 0).show();
        }
        final ql qlVar = new ql();
        qlVar.bpT = new Runnable(this) {
            final /* synthetic */ a kLP;

            public final void run() {
                if (!this.kLP.eDI) {
                    qlVar.bpT = null;
                    this.kLP.eDI = true;
                    if (be.kS(this.kLP.kLK) || be.kS(this.kLP.kLL)) {
                        this.kLP.af(activity);
                        if (this.kLP.aKK == -1) {
                            qs qsVar = new qs();
                            qsVar.bsl.bpc = this.kLP.aKK;
                            com.tencent.mm.sdk.c.a.nhr.z(qsVar);
                            return;
                        }
                        return;
                    }
                    v.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + this.kLP.kLK + this.kLP.kLL);
                    final boolean z = this.kLP.fNM.getBoolean("process_finish_stay_orgpage", true);
                    ad.g(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 kLR;

                        public final void run() {
                            intent.putExtra("key_process_is_end", true);
                            intent.putExtra("key_process_is_stay", z);
                            this.kLR.kLP.a(activity, this.kLR.kLP.kLK, this.kLR.kLP.kLL, this.kLR.kLP.aKK, intent, z);
                            if (this.kLR.kLP.aKK == -1) {
                                qs qsVar = new qs();
                                qsVar.bsl.bpc = this.kLR.kLP.aKK;
                                com.tencent.mm.sdk.c.a.nhr.z(qsVar);
                            }
                        }
                    }, 500);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qlVar);
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (!(mMActivity instanceof WalletPwdConfirmUI)) {
            return mMActivity instanceof WalletRealNameVerifyUI ? new d(this, mMActivity, fVar) {
                final /* synthetic */ a kLP;

                public final CharSequence nK(int i) {
                    if (i != 0) {
                        return null;
                    }
                    String string = this.piR.getString(2131236409);
                    String string2 = this.piR.getString(2131236407);
                    string = this.piR.getString(2131236414, new Object[]{string, string2});
                    g gVar = new g(this.piR);
                    SpannableString spannableString = new SpannableString(string);
                    spannableString.setSpan(gVar, string.length() - string2.length(), string.length(), 33);
                    return spannableString.subSequence(0, spannableString.length());
                }

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    return false;
                }
            } : super.a(mMActivity, fVar);
        } else {
            if (this.mMode == 2) {
                return new d(this, mMActivity, fVar) {
                    final /* synthetic */ a kLP;

                    public final boolean j(Object... objArr) {
                        l lVar = (l) objArr[0];
                        String string = this.kLP.fNM.getString("key_real_name_token");
                        if (lVar == null || be.kS(lVar.kQj)) {
                            v.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
                        } else if (be.kS(string)) {
                            v.e("MicroMsg.RealNameVerifyProcess", "get token error");
                        } else {
                            this.piS.a(new c(lVar.kQj, string, this.kLP.fNM.getInt("entry_scene", -1)), true);
                        }
                        return true;
                    }

                    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        if (!(kVar instanceof c) || i != 0 || i2 != 0) {
                            return false;
                        }
                        this.kLP.fNM.putInt("realname_verify_process_ret", -1);
                        v.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                        k.bga().amB();
                        com.tencent.mm.sdk.c.a.nhr.z(new ql(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 kLS;

                            {
                                this.kLS = r1;
                            }

                            public final void run() {
                                v.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                            }
                        }));
                        this.kLP.d(this.piR, this.kLP.fNM);
                        return true;
                    }
                };
            }
            return super.a(mMActivity, fVar);
        }
    }

    public final String anS() {
        return "realname_verify_process";
    }

    public final int d(MMActivity mMActivity, int i) {
        return 2131236220;
    }
}
