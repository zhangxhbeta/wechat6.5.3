package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.wallet_core.id_verify.a.d;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import java.util.LinkedList;
import java.util.List;

public class WalletRealNameVerifyUI extends WalletBaseUI implements OnClickListener {
    private Button fzj;
    private TextView gOh;
    private WalletFormView kMl;
    private WalletFormView kMm;
    private CheckBox kMn;
    private ElementQuery kMo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pjH.gQ(1616);
        this.kMo = (ElementQuery) this.uA.getParcelable("elemt_query");
        NI();
    }

    protected final void NI() {
        vD(2131236415);
        this.fzj = (Button) findViewById(2131756365);
        this.kMl = (WalletFormView) findViewById(2131759831);
        this.kMm = (WalletFormView) findViewById(2131758526);
        this.kMl.setFocusable(true);
        this.kMl.ioA.setVisibility(8);
        a.c(this.kMm);
        b bVar = this.kMm.pkm;
        if (bVar instanceof a.a) {
            ((a.a) bVar).yE(1);
        }
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI kMp;

            {
                this.kMp = r1;
            }

            public final void onClick(View view) {
                String text = this.kMp.kMl.getText();
                String text2 = this.kMp.kMm.getText();
                if (!be.kS(text) && !be.kS(text2)) {
                    this.kMp.b(new d(text, text2, this.kMp.uA.getInt("entry_scene", -1)), true);
                }
            }
        });
        d(this.kMm, 1, false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI kMp;

            {
                this.kMp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ((a) this.kMp.bLC()).d(this.kMp, 0);
                this.kMp.finish();
                return true;
            }
        });
        this.kMn = (CheckBox) findViewById(2131759869);
        this.gOh = (TextView) findViewById(2131760002);
        this.kMn.setChecked(true);
        this.kMn.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI kMp;

            {
                this.kMp = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    this.kMp.fzj.setEnabled(true);
                    this.kMp.fzj.setClickable(true);
                    return;
                }
                this.kMp.fzj.setEnabled(false);
                this.kMp.fzj.setClickable(false);
            }
        });
        this.gOh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI kMp;

            {
                this.kMp = r1;
            }

            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.kMp.getString(2131236058));
                linkedList2.add(Integer.valueOf(0));
                if (this.kMp.kMo != null && this.kMp.kMo.kOt) {
                    linkedList.add(this.kMp.getString(2131236057));
                    linkedList2.add(Integer.valueOf(1));
                }
                g.a(this.kMp, "", linkedList, linkedList2, "", new g.d(this) {
                    final /* synthetic */ AnonymousClass4 kMq;

                    {
                        this.kMq = r1;
                    }

                    public final void bw(int i, int i2) {
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", this.kMq.kMp.getString(2131235974, new Object[]{u.bsY()}));
                                break;
                            case 1:
                                if (this.kMq.kMp.kMo != null) {
                                    intent.putExtra("rawUrl", this.kMq.kMp.getString(2131235973, new Object[]{u.bsY(), this.kMq.kMp.kMo.hMt}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        c.b(this.kMq.kMp.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            v.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (kVar instanceof d) {
            com.tencent.mm.wallet_core.b bLC = bLC();
            Bundle bundle = null;
            if (bLC != null) {
                bundle = bLC.fNM;
            }
            String str2 = ((d) kVar).token;
            v.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
            if (bLC != null) {
                bundle.putString("key_real_name_token", str2);
                bLC.a((Activity) this, 0, bundle);
            }
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return 2130904676;
    }

    public void onClick(View view) {
    }
}
