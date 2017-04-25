package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.e.a.c;
import com.tencent.mm.ui.e.a.d;

public class ShowNonWeixinFriendUI extends MMActivity implements a {
    private long nMC = 0;
    private String nMD = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233310);
        this.nMC = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.nMD = getIntent().getStringExtra("Contact_KFacebookName");
        NI();
    }

    protected void onPause() {
        super.onPause();
        n.AX().e(this);
    }

    protected void onResume() {
        super.onResume();
        n.AX().d(this);
    }

    protected final int getLayoutId() {
        return 2130903587;
    }

    protected final void NI() {
        ImageView imageView = (ImageView) findViewById(2131756903);
        TextView textView = (TextView) findViewById(2131756904);
        TextView textView2 = (TextView) findViewById(2131756905);
        imageView.setBackgroundDrawable(com.tencent.mm.bd.a.a(this, 2131165453));
        imageView.setImageBitmap(b.gy(this.nMC));
        textView.setText(this.nMD);
        textView2.setText(getString(2131233308, new Object[]{this.nMD}));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowNonWeixinFriendUI nME;

            {
                this.nME = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nME.axg();
                this.nME.finish();
                return true;
            }
        });
        ((Button) findViewById(2131756906)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowNonWeixinFriendUI nME;

            {
                this.nME = r1;
            }

            public final void onClick(View view) {
                c cVar = new c("290293790992170");
                Bundle bundle = new Bundle();
                bundle.putString("message", this.nME.getString(2131232618));
                bundle.putString("to", Long.toString(this.nME.nMC));
                cVar.a(this.nME, "apprequests", bundle, new c.a(this) {
                    final /* synthetic */ AnonymousClass2 nMF;

                    {
                        this.nMF = r1;
                    }

                    public final void a(d dVar) {
                        v.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                    }

                    public final void a(com.tencent.mm.ui.e.a.b bVar) {
                        v.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                    }

                    public final void k(Bundle bundle) {
                        v.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
                        g.a(this.nMF.nME.nDR.nEl, 2131232623, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 nMG;

                            {
                                this.nMG = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.nMG.nMF.nME.finish();
                            }
                        });
                    }

                    public final void onCancel() {
                        v.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
                    }
                });
            }
        });
    }

    public final void gM(String str) {
        NI();
    }
}
