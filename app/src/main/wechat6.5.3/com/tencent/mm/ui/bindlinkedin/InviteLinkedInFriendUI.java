package com.tencent.mm.ui.bindlinkedin;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ag.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;

public class InviteLinkedInFriendUI extends MMActivity implements e {
    private Dialog gpw = null;
    private c ofa = null;
    private EditText ofb = null;
    private EditText ofc = null;
    private String ofd = null;
    private String ofe = null;
    private String off = null;

    private class a implements TextWatcher {
        final /* synthetic */ InviteLinkedInFriendUI ofg;

        private a(InviteLinkedInFriendUI inviteLinkedInFriendUI) {
            this.ofg = inviteLinkedInFriendUI;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            int length = this.ofg.ofb.getText().length();
            int length2 = this.ofg.ofc.getText().length();
            if (length == 0) {
                this.ofg.ofb.setHint(SQLiteDatabase.KeyEmpty);
            }
            if (length2 == 0) {
                this.ofg.ofc.setHint(SQLiteDatabase.KeyEmpty);
            }
            if (length == 0 || length2 == 0) {
                this.ofg.iT(false);
            } else {
                this.ofg.iT(true);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233312);
        NI();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteLinkedInFriendUI ofg;

            {
                this.ofg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ofg.finish();
                return true;
            }
        });
        this.ofd = getIntent().getStringExtra("intent.key.linkedin.id");
        this.ofb = (EditText) findViewById(2131757507);
        this.ofc = (EditText) findViewById(2131757508);
        this.ofe = getIntent().getStringExtra("intent.key.linkedin.from.name");
        this.off = be.ma(getIntent().getStringExtra("intent.key.linkedin.to.name"));
        CharSequence format = String.format(getString(2131233516), new Object[]{be.ma(this.ofe)});
        this.ofb.setText(format);
        this.ofb.setHint(format);
        this.ofb.addTextChangedListener(new a());
        this.ofb.clearFocus();
        String xG = k.xG();
        String xF = k.xF();
        String string = getString(2131233512);
        Object[] objArr = new Object[2];
        objArr[0] = be.ma(this.off);
        if (!be.kS(xG)) {
            xF = xG;
        }
        objArr[1] = xF;
        format = String.format(string, objArr);
        this.ofc.setText(format);
        this.ofc.setHint(format);
        this.ofc.addTextChangedListener(new a());
        this.ofc.clearFocus();
        a(2, getString(2131233515), new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteLinkedInFriendUI ofg;

            {
                this.ofg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.ofg.ofb.getText().toString().trim().length() > 0 && this.ofg.ofc.getText().toString().trim().length() > 0) {
                    this.ofg.ofa = new c(this.ofg.ofd, this.ofg.ofb.getText().toString(), this.ofg.ofc.getText().toString());
                    ak.vy().a(this.ofg.ofa, 0);
                    this.ofg.gpw = g.a(this.ofg, this.ofg.getString(2131233521), false, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass2 ofh;

                        {
                            this.ofh = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                }
                return false;
            }
        }, b.nET);
        axg();
        TextView textView = (TextView) findViewById(2131757506);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        textView.requestFocus();
        textView.requestFocusFromTouch();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(677, (e) this);
    }

    protected void onPause() {
        ak.vy().b(677, (e) this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903810;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.gpw != null) {
            this.gpw.dismiss();
            this.gpw = null;
        }
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.InviteLinkedInFriendUI", "[oneliang][onSceneEnd]:ok");
            ah.FU().iL(this.ofd);
            finish();
        } else if (i2 == 2) {
            this.gpw = g.a((Context) this, false, getString(2131233508), SQLiteDatabase.KeyEmpty, getString(2131233505), getString(2131233506), new OnClickListener(this) {
                final /* synthetic */ InviteLinkedInFriendUI ofg;

                {
                    this.ofg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
                    intent.putExtra("geta8key_username", k.xF());
                    intent.putExtra("geta8key_scene", 17);
                    com.tencent.mm.ay.c.b(this.ofg, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ InviteLinkedInFriendUI ofg;

                {
                    this.ofg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            });
        } else if (i2 == 4) {
            this.gpw = g.a((Context) this, getString(2131233514), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                final /* synthetic */ InviteLinkedInFriendUI ofg;

                {
                    this.ofg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            });
        } else {
            this.gpw = g.a((Context) this, false, getString(2131233511), SQLiteDatabase.KeyEmpty, getString(2131233509), getString(2131233506), new OnClickListener(this) {
                final /* synthetic */ InviteLinkedInFriendUI ofg;

                {
                    this.ofg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.vy().a(this.ofg.ofa, 0);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ InviteLinkedInFriendUI ofg;

                {
                    this.ofg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.vy().c(this.ofg.ofa);
                }
            });
        }
    }
}
