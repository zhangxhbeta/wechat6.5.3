package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.plugin.accountsync.ui.InviteFacebookFriendsUI;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.v.e;

@Deprecated
public class FacebookFriendUI extends MMActivity implements a, e {
    private ListView dwO;
    private View dwQ;
    private ProgressDialog dwR = null;
    String dwS;
    private boolean gYJ = false;
    d nIo;
    private TextView nIp = null;

    static /* synthetic */ void f(FacebookFriendUI facebookFriendUI) {
        v.e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.al(facebookFriendUI.getString(2131231164), facebookFriendUI.getString(2131232616));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232771);
        ak.vy().a(32, (e) this);
        NI();
    }

    protected void onResume() {
        super.onResume();
        n.AX().d(this);
        this.nIo.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
        n.AX().e(this);
    }

    public void onDestroy() {
        ak.vy().b(32, (e) this);
        this.nIo.avc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903632;
    }

    protected final void NI() {
        this.dwO = (ListView) findViewById(2131757013);
        this.nIp = (TextView) findViewById(2131757014);
        this.nIp.setText(2131232617);
        final TextView textView = (TextView) findViewById(2131756760);
        textView.setText(2131232615);
        p pVar = new p(true, true);
        pVar.oUs = new b(this) {
            final /* synthetic */ FacebookFriendUI nIq;

            {
                this.nIq = r1;
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void ml(String str) {
                this.nIq.dwS = be.lZ(str);
                FacebookFriendUI facebookFriendUI = this.nIq;
                if (facebookFriendUI.nIo != null) {
                    facebookFriendUI.nIo.uU(facebookFriendUI.dwS);
                }
            }

            public final void Of() {
            }

            public final void Og() {
            }

            public final void Oh() {
            }
        };
        a(pVar);
        this.nIo = new d(this, new j.a(this) {
            final /* synthetic */ FacebookFriendUI nIq;

            public final void Oi() {
                if (k.yh() && this.nIq.gYJ) {
                    if (this.nIq.nIo.getCount() == 0) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                this.nIq.gYJ = false;
            }

            public final void Oj() {
            }
        });
        this.nIo.nIk = new d.a(this) {
            final /* synthetic */ FacebookFriendUI nIq;

            {
                this.nIq = r1;
            }

            public final void vT(int i) {
                if (i > 0) {
                    this.nIq.nIp.setVisibility(8);
                } else {
                    this.nIq.nIp.setVisibility(0);
                }
            }
        };
        this.dwO.setAdapter(this.nIo);
        this.dwQ = findViewById(2131757015);
        this.dwO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FacebookFriendUI nIq;

            {
                this.nIq = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                h hVar = (h) this.nIq.nIo.getItem(i - this.nIq.dwO.getHeaderViewsCount());
                if (hVar.status == 100 || hVar.status == MMGIFException.D_GIF_ERR_OPEN_FAILED) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", hVar.getUsername());
                    intent.putExtra("Contact_Nick", hVar.EG());
                    intent.putExtra("Contact_KFacebookId", hVar.bCb);
                    intent.putExtra("Contact_KFacebookName", hVar.EQ());
                    intent.putExtra("Contact_Scene", 31);
                    com.tencent.mm.plugin.a.a.drp.d(intent, this.nIq);
                }
                if (hVar.status != MMGIFException.D_GIF_ERR_READ_FAILED) {
                }
            }
        });
        v.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + k.yh());
        if (k.yh()) {
            this.dwO.setVisibility(0);
            this.dwQ.setVisibility(8);
            ak.yW();
            long d = be.d((Long) c.vf().get(65831, null));
            ak.yW();
            String ma = be.ma((String) c.vf().get(65830, null));
            if (be.ay(d) > 86400000 && ma.length() > 0) {
                com.tencent.mm.ui.e.a.c cVar = new com.tencent.mm.ui.e.a.c("290293790992170");
                cVar.Po(ma);
                new h(cVar, new com.tencent.mm.r.a(this) {
                    final /* synthetic */ FacebookFriendUI nIq;

                    {
                        this.nIq = r1;
                    }

                    public final void k(Bundle bundle) {
                        super.k(bundle);
                    }

                    public final void onError(int i, String str) {
                        super.onError(i, str);
                        if (i == 3) {
                            FacebookFriendUI.f(this.nIq);
                        }
                    }
                }).bAT();
            }
            final com.tencent.mm.v.k xVar = new x();
            xVar.Fu();
            final ah ahVar = new ah(new ah.a(this) {
                final /* synthetic */ FacebookFriendUI nIq;

                public final boolean oU() {
                    ak.yW();
                    c.vf().set(65829, Integer.valueOf(1));
                    ak.vy().a(xVar, 0);
                    return false;
                }
            }, false);
            ak.yW();
            if (be.f((Integer) c.vf().get(65829, null)) > 0) {
                ak.yW();
                c.vf().set(65829, Integer.valueOf(1));
                ak.vy().a(xVar, 0);
            } else {
                ahVar.ea(5000);
            }
            Context context = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(context, getString(2131234263), true, new OnCancelListener(this) {
                final /* synthetic */ FacebookFriendUI nIq;

                public final void onCancel(DialogInterface dialogInterface) {
                    ahVar.QI();
                    ak.vy().c(xVar);
                }
            });
            a(0, getString(2131232772), new OnMenuItemClickListener(this) {
                final /* synthetic */ FacebookFriendUI nIq;

                {
                    this.nIq = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.nIq.startActivity(new Intent(this.nIq, InviteFacebookFriendsUI.class));
                    return true;
                }
            });
        } else {
            this.dwO.setVisibility(8);
            this.dwQ.setVisibility(0);
            ((TextView) findViewById(2131757016)).setText(2131232761);
            this.dwQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FacebookFriendUI nIq;

                {
                    this.nIq = r1;
                }

                public final void onClick(View view) {
                    this.nIq.startActivity(new Intent(this.nIq, FacebookAuthUI.class));
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FacebookFriendUI nIq;

            {
                this.nIq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nIq.axg();
                this.nIq.finish();
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ FacebookFriendUI nIq;

            {
                this.nIq = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.nIq.dwO);
            }
        };
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32) {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (i == 4 && i2 == -68) {
                if (be.kS(str)) {
                    str = "error";
                }
                al(getString(2131231164), str);
            } else if (i == 0 && i2 == 0) {
                this.nIo.a(null, null);
            } else {
                Toast.makeText(this, 2131233852, 0).show();
            }
        }
    }

    private void al(String str, String str2) {
        g.a((Context) this, str2, str, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacebookFriendUI nIq;

            {
                this.nIq = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(this.nIq.nDR.nEl, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                this.nIq.nDR.nEl.startActivity(intent);
                this.nIq.finish();
            }
        }, null);
    }

    public final void gM(String str) {
        this.nIo.notifyDataSetChanged();
    }
}
