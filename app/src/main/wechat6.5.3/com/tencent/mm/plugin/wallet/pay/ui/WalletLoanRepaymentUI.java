package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.wallet.pay.a.b;
import com.tencent.mm.plugin.wallet_core.b.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_core.ui.k.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(7)
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private String desc;
    private String fTP;
    private String hNg = "CNY";
    private double irx;
    protected k kFo;
    private String kIJ;
    private String kIK;
    private String kIL;
    private String kIM;
    private String kIN;
    private String kIO;
    private String kIP;
    private String kIQ;
    private String token;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.kIO = intent.getStringExtra("appId");
        this.kIJ = intent.getStringExtra("timeStamp");
        this.kIK = intent.getStringExtra("nonceStr");
        this.kIL = intent.getStringExtra("packageExt");
        this.kIM = intent.getStringExtra("signtype");
        this.kIN = intent.getStringExtra("paySignature");
        this.kIP = intent.getStringExtra("url");
        gQ(580);
        p(new com.tencent.mm.plugin.wallet_core.b.a(this.kIO, this.kIJ, this.kIK, this.kIL, this.kIM, this.kIN, this.kIP));
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void CW(String str) {
        b(new b(str), true);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
                this.token = ((com.tencent.mm.plugin.wallet_core.b.a) kVar).axY();
                CW(this.token);
                return true;
            } else if (kVar instanceof b) {
                b bVar = (b) kVar;
                this.hNg = bVar.hNg;
                this.irx = bVar.irx;
                this.desc = bVar.desc;
                y bgb = com.tencent.mm.plugin.wallet_core.model.k.bgb();
                if (bgb.bgl()) {
                    Bankcard bgm = bgb.bgm();
                    if (bgm == null || !be.kS(bgm.field_forbidWord)) {
                        bfa();
                    } else {
                        a(bgm, this.irx, this.hNg);
                    }
                } else {
                    g.b(this, getResources().getString(2131236222), "", getString(2131236326), getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ WalletLoanRepaymentUI kIR;

                        {
                            this.kIR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
                            this.kIR.bfb();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletLoanRepaymentUI kIR;

                        {
                            this.kIR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.kIR.ayJ()) {
                                this.kIR.finish();
                            }
                        }
                    });
                }
                return true;
            } else if (kVar instanceof j) {
                j jVar = (j) kVar;
                if (jVar.bfB()) {
                    v.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.fTP);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", jVar.kLq);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", jVar.kLp);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.ui.j.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", jVar.kLn);
                    intent.putExtra("bind_serial", this.kIQ);
                    setResult(-1, intent);
                    finish();
                }
                return true;
            }
        }
        return false;
    }

    private void a(Bankcard bankcard, double d, String str) {
        AnonymousClass1 anonymousClass1 = new c(this) {
            final /* synthetic */ WalletLoanRepaymentUI kIR;

            {
                this.kIR = r1;
            }

            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                this.kIR.fTP = str;
                this.kIR.j(new j(this.kIR.fTP, this.kIR.token));
            }
        };
        View.OnClickListener anonymousClass2 = new View.OnClickListener(this) {
            final /* synthetic */ WalletLoanRepaymentUI kIR;

            {
                this.kIR = r1;
            }

            public final void onClick(View view) {
                this.kIR.bfa();
                if (this.kIR.kFo != null) {
                    this.kIR.kFo.dismiss();
                }
            }
        };
        OnCancelListener anonymousClass3 = new OnCancelListener(this) {
            final /* synthetic */ WalletLoanRepaymentUI kIR;

            {
                this.kIR = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.kIR.kFo != null) {
                    this.kIR.kFo.cancel();
                    this.kIR.setResult(0);
                    this.kIR.finish();
                }
            }
        };
        this.kIQ = bankcard.field_bindSerial;
        this.kFo = k.a(this, this.desc, d, str, bankcard, anonymousClass1, anonymousClass2, anonymousClass3);
    }

    private void bfa() {
        v.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    }

    protected final void bfb() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, bundle, new com.tencent.mm.wallet_core.b.a(this) {
            final /* synthetic */ WalletLoanRepaymentUI kIR;

            {
                this.kIR = r1;
            }

            public final Intent e(int i, Bundle bundle) {
                if (i == -1) {
                    this.kIR.CW(this.kIR.token);
                } else {
                    y bgb = com.tencent.mm.plugin.wallet_core.model.k.bgb();
                    if (bgb.bgl()) {
                        this.kIR.a(bgb.bgm(), this.kIR.irx, this.kIR.hNg);
                    } else {
                        this.kIR.setResult(0, null);
                    }
                }
                return null;
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        v.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            v.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            CW(this.token);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            v.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.kIQ);
            setResult(-1, intent2);
            finish();
        } else {
            v.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            int intExtra = intent.getIntExtra("ret", DownloadResult.CODE_UNDEFINED);
            if (intExtra == -1003) {
                v.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                bfb();
            } else if (intExtra == 0) {
                v.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                a(com.tencent.mm.plugin.wallet_core.model.k.bgb().Dc(intent.getStringExtra("bindSerial")), this.irx, this.hNg);
            } else {
                v.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
            }
        } else {
            y bgb = com.tencent.mm.plugin.wallet_core.model.k.bgb();
            if (bgb.bgl()) {
                a(bgb.bgm(), this.irx, this.hNg);
            } else {
                v.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
            }
        }
    }

    protected final int NO() {
        return 1;
    }
}
