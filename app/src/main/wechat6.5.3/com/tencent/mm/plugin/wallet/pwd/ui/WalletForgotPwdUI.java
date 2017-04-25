package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.mg;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private ListView dyx;
    private ArrayList<Bankcard> kGO = new ArrayList();
    private Button kHi;
    private List<ElementQuery> kKr = new LinkedList();
    private Bankcard kKs;
    private a kKt;
    private LinearLayout kKu;
    private WalletFormView kKv;
    private WalletFormView kKw;
    private int kKx = 1;
    private boolean kKy = false;
    c kKz = new c<mg>(this) {
        final /* synthetic */ WalletForgotPwdUI kKA;

        {
            this.kKA = r2;
            this.nhz = mg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mg mgVar = (mg) bVar;
            if (mgVar instanceof mg) {
                WalletForgotPwdUI.a(this.kKA, mgVar.bnr.bns, mgVar.bnr.bnt);
                return true;
            }
            v.f("MicroMsg.WalletForgotPwdUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };

    public class a extends BaseAdapter {
        private Context context;
        List<Bankcard> cwd = new ArrayList();
        final /* synthetic */ WalletForgotPwdUI kKA;

        public final /* synthetic */ Object getItem(int i) {
            return sh(i);
        }

        public a(WalletForgotPwdUI walletForgotPwdUI, Context context) {
            this.kKA = walletForgotPwdUI;
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = (WalletFormView) View.inflate(this.context, 2130904610, null);
            } else {
                WalletFormView walletFormView = (WalletFormView) view;
            }
            final Bankcard sh = sh(i);
            if (sh != null) {
                view.setText(((Bankcard) this.cwd.get(i)).field_desc);
            }
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a kKB;

                public final void onClick(View view) {
                    this.kKB.kKA.kKs = sh;
                    this.kKB.kKA.kKy = false;
                    this.kKB.kKA.bfv();
                }
            });
            return view;
        }

        public final int getCount() {
            return this.cwd.size();
        }

        private Bankcard sh(int i) {
            if (i < 0 || i > this.cwd.size() - 1) {
                return null;
            }
            return (Bankcard) this.cwd.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI, String str, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(walletForgotPwdUI);
        if (ae != null) {
            ae.a((Activity) walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
    }

    static /* synthetic */ void c(WalletForgotPwdUI walletForgotPwdUI) {
        if (!"1".equals(k.bfX().bgT().field_reset_passwd_flag)) {
            v.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
        } else if (be.kS(k.bfX().bgT().field_find_passwd_url)) {
            v.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(2131759908)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(2131759902)).setOnClickListener(new OnClickListener(walletForgotPwdUI) {
                final /* synthetic */ WalletForgotPwdUI kKA;

                {
                    this.kKA = r1;
                }

                public final void onClick(View view) {
                    this.kKA.kKy = true;
                    this.kKA.bfv();
                }
            });
        } else {
            v.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(2131759909)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(2131759903);
            g gVar = new g(walletForgotPwdUI);
            gVar.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(walletForgotPwdUI) {
                final /* synthetic */ WalletForgotPwdUI kKA;

                {
                    this.kKA = r1;
                }

                public final void onClick(View view) {
                    this.kKA.kKy = true;
                    this.kKA.bfv();
                }
            };
            String string = walletForgotPwdUI.getString(2131236278);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 12, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236311);
        if (!this.uA.getBoolean("key_is_force_bind", false)) {
            j(new l(null, 6));
            oa(4);
        }
        NI();
        com.tencent.mm.sdk.c.a.nhr.e(this.kKz);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.kKz);
        super.onDestroy();
    }

    public void NI() {
        this.dyx = (ListView) findViewById(2131759905);
        this.kKu = (LinearLayout) findViewById(2131759906);
        this.kKw = (WalletFormView) findViewById(2131759831);
        this.kKv = (WalletFormView) findViewById(2131759907);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kKv);
        this.kKw.pkk = this;
        this.kKv.pkk = this;
        this.kHi = (Button) findViewById(2131756365);
        this.kHi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletForgotPwdUI kKA;

            {
                this.kKA = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11353, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                this.kKA.bfv();
            }
        });
        this.kKy = false;
        com.tencent.mm.plugin.wallet.a.k.beN();
        this.kGO = com.tencent.mm.plugin.wallet.a.k.beO().bgG();
        if (this.kGO == null || this.kGO.size() == 0 || this.uA.getBoolean("key_is_force_bind", false)) {
            v.d("MicroMsg.WalletForgotPwdUI", "No bound bankcard process");
            this.kGO = new ArrayList();
            this.kKu.setVisibility(0);
            this.dyx.setVisibility(8);
            vD(2131236170);
            ((TextView) findViewById(2131759904)).setText(getString(2131236282));
            WalletFormView walletFormView = this.kKw;
            com.tencent.mm.plugin.wallet.a.k.beN();
            walletFormView.setText(e.PU(com.tencent.mm.plugin.wallet.a.k.beO().bgB()));
        } else {
            v.d("MicroMsg.WalletForgotPwdUI", "domestic process!");
            if (com.tencent.mm.wallet_core.a.ae(this) != null) {
                p(new com.tencent.mm.plugin.wallet_core.b.k());
            }
            this.kKu.setVisibility(8);
            this.kHi.setVisibility(8);
            this.kKt = new a(this, this);
            this.dyx.setAdapter(this.kKt);
            this.kKt.cwd = this.kGO;
            this.kKt.notifyDataSetChanged();
        }
        Ox();
        a(this.kKv, 0, false, false);
        this.kKv.k(new OnClickListener(this) {
            final /* synthetic */ WalletForgotPwdUI kKA;

            {
                this.kKA = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
                MMActivity mMActivity = this.kKA;
                com.tencent.mm.plugin.wallet.a.k.beN();
                e.d(mMActivity, com.tencent.mm.plugin.wallet.a.k.beO().bgB());
            }
        });
        this.kKv.ioA.setImageResource(2131166019);
        this.kKv.ioA.setVisibility(0);
    }

    private void bfu() {
        this.uA.remove("elemt_query");
        this.uA.remove("key_bankcard");
        this.uA.remove("bank_name");
        this.uA.remove("key_card_id");
    }

    private void bfv() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", this.uA.getBoolean("key_is_reset_with_new_card", false));
        bfu();
        if (this.kKs == null && !this.kKy) {
            j(new com.tencent.mm.plugin.wallet_core.b.k(null, this.kKv.getText(), null));
        } else if (this.kKy) {
            aa bgT = k.bfX().bgT();
            if (be.kS(bgT.field_find_passwd_url)) {
                bundle.putBoolean("key_is_force_bind", true);
                bundle.putBoolean("key_is_reset_with_new_card", true);
                if (bLC() != null) {
                    bLC().a((Activity) this, 0, bundle);
                    return;
                }
                return;
            }
            v.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
            e.l(this, bgT.field_find_passwd_url, false);
        } else {
            com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
            bundle.putParcelable("key_bankcard", this.kKs);
            ElementQuery elementQuery = new ElementQuery();
            for (Parcelable parcelable : this.kKr) {
                v.i("MicroMsg.WalletForgotPwdUI", "helios:::" + parcelable.hMt);
                if (!be.kS(parcelable.hMt) && !be.kS(this.kKs.field_bankcardType) && parcelable.hMt.trim().equals(this.kKs.field_bankcardType.trim())) {
                    break;
                }
            }
            Object obj = elementQuery;
            bundle.putParcelable("elemt_query", parcelable);
            if (ae != null) {
                ae.a((Activity) this, 0, bundle);
            }
        }
    }

    protected final int getLayoutId() {
        return 2130904644;
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.WalletForgotPwdUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k) {
                com.tencent.mm.plugin.wallet_core.b.k kVar2 = (com.tencent.mm.plugin.wallet_core.b.k) kVar;
                Bundle bundle = new Bundle();
                if (be.kS(kVar2.eAS)) {
                    this.kKr = kVar2.kLr;
                    return true;
                } else if (kVar2.kLs != null) {
                    if (kVar2.kLs.isError()) {
                        com.tencent.mm.ui.base.g.f(this, 2131236023, 2131231164);
                        return true;
                    } else if (this.kGO == null || this.kGO.size() == 0) {
                        bfu();
                        bundle.putString("bank_name", kVar2.kLs.kNS);
                        bundle.putParcelable("elemt_query", kVar2.kLs);
                        bundle.putString("key_card_id", this.kKv.getText());
                        com.tencent.mm.wallet_core.a.k(this, bundle);
                        return true;
                    }
                }
            } else if ((kVar instanceof l) && this.kKt != null) {
                ArrayList arrayList = null;
                if (k.bga() != null) {
                    arrayList = k.bga().bgG();
                }
                com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
                if (ae != null) {
                    ae.bKU();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Bankcard bankcard = (Bankcard) it.next();
                        if (bankcard.field_bankcardTag == 1) {
                            arrayList2.add(bankcard);
                        } else if (bankcard.field_bankcardTag == 2) {
                            arrayList3.add(bankcard);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        this.kGO = arrayList2;
                    } else {
                        this.kGO = arrayList3;
                    }
                }
                this.kKt.cwd = this.kGO;
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ WalletForgotPwdUI kKA;

                    {
                        this.kKA = r1;
                    }

                    public final void run() {
                        this.kKA.kKt.notifyDataSetChanged();
                        WalletForgotPwdUI.c(this.kKA);
                    }
                });
            }
        }
        return false;
    }

    public final boolean ayM() {
        return true;
    }

    private boolean Ox() {
        if (this.dyx.getVisibility() == 0 || (this.kKw.Ou() && this.kKv.Ou())) {
            this.kHi.setEnabled(true);
            this.kHi.setClickable(true);
            return true;
        }
        this.kHi.setEnabled(false);
        this.kHi.setClickable(false);
        return false;
    }

    public final void fc(boolean z) {
        Ox();
    }

    protected boolean beY() {
        return true;
    }

    protected final int NO() {
        return 1;
    }

    public final boolean ayJ() {
        if ((this.kGO == null || this.kGO.size() == 0) && !be.kS(k.bfX().bgT().field_find_passwd_url)) {
            return true;
        }
        return false;
    }

    protected final boolean ayL() {
        oa(ayJ() ? 4 : 0);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && 1 == i) {
            this.kKv.Qa(intent.getStringExtra("key_bankcard_id"));
            bfv();
        }
    }
}
