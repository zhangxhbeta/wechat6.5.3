package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.plugin.offline.a.h;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.b.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.f.4;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class g extends b {
    public final b c(Activity activity, Bundle bundle) {
        b(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            D(activity);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        D(activity);
        if (bundle != null && bundle.getBoolean("is_offline_create")) {
            a.H((WalletBaseUI) activity);
        }
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final void D(Activity activity) {
        if (activity != null) {
            b(activity, WalletOfflineEntranceUI.class);
            activity.finish();
        }
    }

    public final d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ g hJN;

            public final /* synthetic */ CharSequence nK(int i) {
                switch (i) {
                    case 0:
                        return this.piR.getString(2131236145);
                    case 1:
                        return this.piR.getString(2131236144);
                    default:
                        return "";
                }
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof h) {
                        v.i("MicroMsg.OfflineProcess", "Offline is Create ");
                        aEJ();
                        this.hJN.fNM.putBoolean("is_offline_create", true);
                    } else if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                        v.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                        f fVar = this.piS;
                        if (fVar.dxy == null || !(fVar.dxy == null || fVar.dxy.isShowing())) {
                            if (fVar.dxy != null) {
                                fVar.dxy.dismiss();
                            }
                            fVar.dxy = com.tencent.mm.wallet_core.ui.g.a(fVar.mContext, false, new 4(fVar));
                        }
                        ql qlVar = new ql();
                        qlVar.bpT = new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 hJO;

                            {
                                this.hJO = r1;
                            }

                            public final void run() {
                                this.hJO.hJN.a(this.hJO.piR, 0, this.hJO.hJN.fNM);
                                this.hJO.piS.beT();
                            }
                        };
                        com.tencent.mm.sdk.c.a.nhr.z(qlVar);
                    } else if (kVar instanceof com.tencent.mm.plugin.offline.a.f) {
                        com.tencent.mm.plugin.offline.a.f fVar2 = (com.tencent.mm.plugin.offline.a.f) kVar;
                        if ("1".equals(fVar2.hKB)) {
                            MMActivity mMActivity = this.piR;
                            String str2 = fVar2.bhT;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("key_authen", new Authen());
                            bundle.putString("key_pwd1", this.hJN.fNM.getString("key_pwd1"));
                            bundle.putString("key_mobile", str2);
                            bundle.putInt("verify_scene", 1);
                            bundle.putInt("offline_add_fee", this.hJN.fNM.getInt("offline_chg_fee", 0));
                            com.tencent.mm.wallet_core.a.a(mMActivity, k.class, bundle);
                            this.hJN.a(mMActivity, 0, this.hJN.fNM);
                        } else {
                            this.hJN.fNM.putBoolean("back_to_coin_purse_ui", true);
                            aEJ();
                        }
                    } else if (kVar instanceof m) {
                        a.xq("");
                        j.aEM();
                        j.aEN().hKX = null;
                        this.hJN.a(this.piR, 0, this.hJN.fNM);
                    }
                    return true;
                } else if (!(kVar instanceof h)) {
                    return false;
                } else {
                    v.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
                    h hVar = (h) kVar;
                    if (i2 != 410) {
                        return false;
                    }
                    final MMActivity mMActivity2 = this.piR;
                    final int i3 = hVar.hKP;
                    com.tencent.mm.ui.base.g.b(mMActivity2, str, "", mMActivity2.getString(2131236326), mMActivity2.getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 hJO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.K(mMActivity2, i3);
                            this.hJO.hJN.a(mMActivity2, 0, this.hJO.hJN.fNM);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 hJO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.hJO.hJN.a(mMActivity2, 0, this.hJO.hJN.fNM);
                        }
                    });
                    return true;
                }
            }

            public final boolean j(Object... objArr) {
                String str = (String) objArr[0];
                this.hJN.fNM.putString("key_pwd1", str);
                Bankcard aFn = a.aFn();
                if (aFn == null) {
                    v.e("MicroMsg.OfflineProcess", "no support bank car for offline");
                    aFn = a.aFo();
                }
                if (aFn == null) {
                    v.e("MicroMsg.OfflineProcess", "no any bank car for offline");
                    return false;
                }
                String string = this.hJN.fNM.getString("oper");
                if (!a.aFk()) {
                    v.i("MicroMsg.OfflineProcess", "Offline is not Create ");
                    this.piS.a(new h(aFn, (String) objArr[0], this.hJN.fNM.getInt("offline_chg_fee", 0)), true, true);
                } else if (string != null) {
                    v.i("MicroMsg.OfflineProcess", "oper == " + string);
                    if (string.equals("create")) {
                        this.piS.a(new h(aFn, (String) objArr[0], this.hJN.fNM.getInt("offline_chg_fee", 0)), true, true);
                    } else if (string.equals("clr")) {
                        this.piS.a(new com.tencent.mm.plugin.offline.a.f(aFn, str, "clr", 0, ""), true, true);
                    } else if (string.equals("changeto")) {
                        this.piS.a(new com.tencent.mm.plugin.offline.a.f(aFn, str, "changeto", this.hJN.fNM.getInt("offline_chg_fee"), ""), true, true);
                    } else if (!string.equals("freeze")) {
                        return false;
                    } else {
                        this.piS.a(new m(str), true, true);
                    }
                }
                return true;
            }

            private void aEJ() {
                this.piS.a(new com.tencent.mm.plugin.offline.a.k(System.currentTimeMillis(), a.hMk), false, true);
            }
        } : super.a(mMActivity, fVar);
    }

    public final String anS() {
        return "OfflineProcess";
    }
}
