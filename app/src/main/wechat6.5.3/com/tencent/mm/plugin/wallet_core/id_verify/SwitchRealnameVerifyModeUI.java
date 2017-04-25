package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements OnClickListener {
    private int cKI = 0;
    private View kLU;
    private View kLV;
    private View kLW;
    private TextView kLX;
    private TextView kLY;
    private TextView kLZ;
    private TextView kMa;
    private TextView kMb;
    private TextView kMc;
    private TextView kMd;
    private String kMe;
    private String kMf;
    private String kMg;
    private boolean kMh;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        bLC();
        this.cKI = this.uA.getInt("entry_scene", this.cKI);
        e.b(13, be.Nh(), this.cKI);
    }

    protected final void NI() {
        vD(2131236415);
        this.kLU = findViewById(2131760007);
        this.kLV = findViewById(2131760011);
        this.kLW = findViewById(2131760003);
        this.kLV.setOnClickListener(this);
        this.kLU.setOnClickListener(this);
        this.kLW.setOnClickListener(this);
        this.kLX = (TextView) findViewById(2131760008);
        this.kLY = (TextView) findViewById(2131760009);
        this.kLZ = (TextView) findViewById(2131760012);
        this.kMa = (TextView) findViewById(2131760013);
        this.kMb = (TextView) findViewById(2131760014);
        this.kMc = (TextView) findViewById(2131760004);
        this.kMd = (TextView) findViewById(2131760005);
        if (!hj(false)) {
            b bVar = new b();
            gQ(1666);
            j(bVar);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SwitchRealnameVerifyModeUI kMi;

            {
                this.kMi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.wallet_core.b bLC = this.kMi.bLC();
                if (bLC == null) {
                    return false;
                }
                e.b(14, be.Nh(), this.kMi.cKI);
                bLC.d(this.kMi, 0);
                this.kMi.finish();
                return true;
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof a) {
            if (i == 0 && i2 == 0) {
                gR(580);
                ((a) kVar).axY();
                com.tencent.mm.wallet_core.b bLC = bLC();
                if (bLC == null) {
                    return true;
                }
                Bundle bundle = bLC.fNM;
                bundle.putInt("real_name_verify_mode", 1);
                com.tencent.mm.wallet_core.a.k(this, bundle);
                return true;
            }
        } else if (kVar instanceof b) {
            gR(1666);
            hj(true);
        }
        return false;
    }

    protected final int getLayoutId() {
        return 2130904677;
    }

    public void onClick(View view) {
        int id = view.getId();
        final com.tencent.mm.wallet_core.b bLC = bLC();
        if (bLC != null) {
            Bundle bundle = bLC.fNM;
            if (id == 2131760007) {
                e.b(15, be.Nh(), this.cKI);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (be.kS(str)) {
                        str = getString(2131236492);
                    }
                    g.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SwitchRealnameVerifyModeUI kMi;

                        {
                            this.kMi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kMi.finish();
                        }
                    });
                    return;
                } else {
                    gQ(580);
                    p(new a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")));
                    return;
                }
            } else if (id == 2131760011) {
                e.b(17, be.Nh(), this.cKI);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == 2131760003) {
                e.b(16, be.Nh(), this.cKI);
                if (!this.kMh || be.kS(this.kMg)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    g.a(this, this.kMg, "", this.kMf, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SwitchRealnameVerifyModeUI kMi;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bundle bundle = bLC.fNM;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            com.tencent.mm.wallet_core.a.k(this.kMi, bundle);
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.wallet_core.a.k(this, bundle);
        }
    }

    private static JSONObject bfD() {
        ak.yW();
        Object obj = c.vf().get(t.a.nsC, "");
        if (obj != null) {
            String str = (String) obj;
            if (!be.kS(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = jSONObject.getLong("timestamp");
                    long j2 = jSONObject.getLong("cache_time");
                    v.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j + ";cachetime=" + j2);
                    if (currentTimeMillis - j <= j2) {
                        return jSONObject;
                    }
                    v.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                    return null;
                } catch (Throwable e) {
                    v.a("MicroMsg.SwitchRealnameVerifyModeUI", e, "", new Object[0]);
                    v.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    return null;
                }
            }
        }
        v.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        return null;
    }

    private boolean hj(boolean z) {
        JSONObject bfD = bfD();
        if (z && bfD == null) {
            bfD = new JSONObject();
        }
        if (bfD == null) {
            return z;
        }
        if (bfD.optBoolean("isShowBindCardVerify", false)) {
            this.kMc.setText(bfD.optString("bindCardVerifyTitle"));
            this.kMd.setText(bfD.optString("bindCardVerifySubtitle"));
            this.kLW.setVisibility(0);
        } else {
            this.kLW.setVisibility(8);
        }
        if (bfD.optBoolean("isShowBindCard", false)) {
            this.kLX.setText(bfD.optString("bindcardTitle", getString(2131235601)));
            this.kLY.setText(bfD.optString("bindcardSubTitle", getString(2131235602)));
            this.kLU.setVisibility(0);
        } else {
            this.kLU.setVisibility(8);
        }
        if (bfD.optBoolean("isShowBindId", false)) {
            this.kLZ.setText(bfD.optString("bindIdTitle", getString(2131235603)));
            this.kMa.setText(bfD.optString("bindIdSubTitle", getString(2131235604)));
            this.kLV.setVisibility(0);
        } else {
            this.kLV.setVisibility(8);
        }
        this.kMf = bfD.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.kMg = bfD.optString("bindCardVerifyAlertViewContent", "");
        this.kMh = bfD.optBoolean("isShowBindCardVerifyAlertView", false);
        CharSequence optString = bfD.optString("extral_wording", "");
        if (be.kS(optString)) {
            this.kMb.setVisibility(8);
        } else {
            this.kMb.setText(optString);
            this.kMb.setVisibility(0);
        }
        this.kMf = bfD.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.kMg = bfD.optString("bindCardVerifyAlertViewContent");
        this.kMh = bfD.optBoolean("isShowBindCardVerifyAlertView", false);
        boolean optBoolean = bfD.optBoolean("question_answer_switch", false);
        this.kMe = bfD.optString("question_answer_url", "");
        if (optBoolean && !be.kS(this.kMe)) {
            a(0, 2130839531, new OnMenuItemClickListener(this) {
                final /* synthetic */ SwitchRealnameVerifyModeUI kMi;

                {
                    this.kMi = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e.b(18, be.Nh(), this.kMi.cKI);
                    e.l(this.kMi.nDR.nEl, this.kMi.kMe, false);
                    return true;
                }
            });
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            com.tencent.mm.wallet_core.b bLC = bLC();
            if (bLC != null) {
                e.b(14, be.Nh(), this.cKI);
                bLC.d((Activity) this, 0);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
