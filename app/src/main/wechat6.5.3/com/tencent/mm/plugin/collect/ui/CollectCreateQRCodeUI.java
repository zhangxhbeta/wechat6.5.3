package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.collect.b.b;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeUI extends WalletBaseUI {
    private String can = "";
    private WalletFormView eWC;
    private TextView eWD;

    static /* synthetic */ void d(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        if (be.kS(collectCreateQRCodeUI.can)) {
            collectCreateQRCodeUI.eWD.setTextColor(collectCreateQRCodeUI.getResources().getColor(2131689819));
            collectCreateQRCodeUI.eWD.setText(2131231946);
            return;
        }
        g gVar = new g(collectCreateQRCodeUI.nDR.nEl);
        CharSequence a = e.a(collectCreateQRCodeUI, collectCreateQRCodeUI.getString(2131231947, new Object[]{collectCreateQRCodeUI.can, collectCreateQRCodeUI.getString(2131231948)}));
        CharSequence spannableString = new SpannableString(a);
        spannableString.setSpan(gVar, a.length() - r1.length(), a.length(), 33);
        collectCreateQRCodeUI.eWD.setTextColor(collectCreateQRCodeUI.getResources().getColor(2131689792));
        collectCreateQRCodeUI.eWD.setText(spannableString);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        vD(2131231945);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CollectCreateQRCodeUI eWE;

            {
                this.eWE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eWE.setResult(0);
                this.eWE.finish();
                return true;
            }
        });
        this.eWC = (WalletFormView) findViewById(2131756361);
        a.e(this.eWC);
        this.eWC.eXB.setText(q.bLm());
        this.eWC.a(new TextWatcher(this) {
            final /* synthetic */ CollectCreateQRCodeUI eWE;

            {
                this.eWE = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
            }
        });
        d(this.eWC, 2, false);
        ((Button) findViewById(2131756365)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectCreateQRCodeUI eWE;

            {
                this.eWE = r1;
            }

            public final void onClick(View view) {
                double d = be.getDouble(this.eWE.eWC.getText(), 0.0d);
                if (!this.eWE.eWC.Ou()) {
                    s.makeText(this.eWE.nDR.nEl, 2131236020, 0).show();
                } else if (d < 0.01d) {
                    s.makeText(this.eWE.nDR.nEl, 2131234479, 0).show();
                } else {
                    this.eWE.j(new b(d, "1", this.eWE.can));
                }
            }
        });
        this.eWD = (TextView) findViewById(2131756364);
        this.eWD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectCreateQRCodeUI eWE;

            {
                this.eWE = r1;
            }

            public final void onClick(View view) {
                this.eWE.NP();
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(this.eWE, this.eWE.getString(2131231946), this.eWE.can, "", new com.tencent.mm.ui.base.g.b(this) {
                    final /* synthetic */ AnonymousClass4 eWF;

                    {
                        this.eWF = r1;
                    }

                    public final boolean r(CharSequence charSequence) {
                        if (be.kS(charSequence.toString())) {
                            this.eWF.eWE.can = null;
                            CollectCreateQRCodeUI.d(this.eWF.eWE);
                        } else {
                            this.eWF.eWE.can = charSequence.toString();
                            CollectCreateQRCodeUI.d(this.eWF.eWE);
                        }
                        return true;
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 eWF;

                    {
                        this.eWF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ad.g(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 eWG;

                            {
                                this.eWG = r1;
                            }

                            public final void run() {
                                this.eWG.eWF.eWE.axg();
                            }
                        }, 500);
                    }
                });
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903384;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            Intent intent = new Intent();
            intent.putExtra("ftf_pay_url", bVar.eWy);
            intent.putExtra("ftf_fixed_fee", bVar.eWz);
            intent.putExtra("ftf_fixed_fee_type", bVar.cpl);
            intent.putExtra("ftf_fixed_desc", bVar.desc);
            setResult(-1, intent);
            finish();
        }
        return true;
    }
}
