package com.tencent.mm.plugin.accountsync.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.e.a.d;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI extends MMActivity implements e {
    private ListView dwO;
    a dwP;
    private View dwQ;
    private ProgressDialog dwR = null;
    String dwS;
    private final int dwT = 5;

    public static class a extends j<h> {
        private int[] cHB;
        String dxb;
        private boolean[] dxc;

        public static class a {
            TextView cHI;
            ImageView dtz;
            TextView dxd;
            CheckBox dxe;
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (h) obj;
            if (obj == null) {
                obj = new h();
            }
            obj.b(cursor);
            return obj;
        }

        public a(Context context, com.tencent.mm.ui.j.a aVar) {
            super(context, new h());
            this.nDK = aVar;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            h hVar = (h) getItem(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, 2130903585, null);
                aVar2.dtz = (ImageView) view.findViewById(2131756891);
                aVar2.cHI = (TextView) view.findViewById(2131756892);
                aVar2.dxd = (TextView) view.findViewById(2131756897);
                aVar2.dxe = (CheckBox) view.findViewById(2131756898);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.cHI.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, hVar.EQ(), aVar.cHI.getTextSize()));
            Bitmap gy = b.gy(hVar.bCb);
            if (gy == null) {
                aVar.dtz.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2131165440));
            } else {
                aVar.dtz.setImageBitmap(gy);
            }
            aVar.dxe.setChecked(this.dxc[i]);
            if (ah.FP().iK(Long.toString(hVar.bCb))) {
                aVar.dxd.setVisibility(0);
            } else {
                aVar.dxd.setVisibility(8);
            }
            return view;
        }

        public final long[] Ok() {
            int i;
            int i2 = 0;
            int i3 = 0;
            for (boolean z : this.dxc) {
                if (z) {
                    i3++;
                }
            }
            long[] jArr = new long[i3];
            int i4 = 0;
            while (i4 < getCount()) {
                if (this.dxc[i4]) {
                    i = i2 + 1;
                    jArr[i2] = ((h) getItem(i4)).bCb;
                    i3 = i;
                } else {
                    i3 = i2;
                }
                i4++;
                i2 = i3;
            }
            return jArr;
        }

        public final void gO(int i) {
            if (i >= 0 && i < this.dxc.length) {
                this.dxc[i] = !this.dxc[i];
                super.notifyDataSetChanged();
            }
        }

        public final void Ol() {
            i FM = ah.FM();
            String str = this.dxb;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" where facebookfriend.status = 102 ");
            if (str != null && str.length() > 0) {
                stringBuilder.append(" and ( ");
                stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
            }
            setCursor(FM.cuX.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null));
            this.cHB = new int[getCount()];
            this.dxc = new boolean[getCount()];
            super.notifyDataSetChanged();
        }

        protected final void Om() {
            Ol();
        }
    }

    static /* synthetic */ void c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        v.e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.al(inviteFacebookFriendsUI.getString(2131231164), inviteFacebookFriendsUI.getString(2131232616));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232622);
        ak.vy().a(32, (e) this);
        NI();
    }

    protected void onDestroy() {
        ak.vy().b(32, (e) this);
        this.dwP.avc();
        super.onDestroy();
    }

    protected final void NI() {
        this.dwO = (ListView) findViewById(2131757013);
        final TextView textView = (TextView) findViewById(2131756760);
        textView.setText(2131232615);
        p pVar = new p(true, true);
        pVar.oUs = new p.b(this) {
            final /* synthetic */ InviteFacebookFriendsUI dwU;

            {
                this.dwU = r1;
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void ml(String str) {
                this.dwU.dwS = be.lZ(str);
                InviteFacebookFriendsUI inviteFacebookFriendsUI = this.dwU;
                if (inviteFacebookFriendsUI.dwP != null) {
                    a aVar = inviteFacebookFriendsUI.dwP;
                    aVar.dxb = be.lZ(inviteFacebookFriendsUI.dwS.trim());
                    aVar.avc();
                    aVar.Ol();
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
        this.dwP = new a(this, new com.tencent.mm.ui.j.a(this) {
            final /* synthetic */ InviteFacebookFriendsUI dwU;

            public final void Oi() {
                if (!k.yh()) {
                    return;
                }
                if (this.dwU.dwP.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }

            public final void Oj() {
            }
        });
        this.dwO.setAdapter(this.dwP);
        this.dwQ = findViewById(2131757015);
        this.dwO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI dwU;

            {
                this.dwU = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.dwU.dwP.Ok().length >= 50) {
                    g.f(this.dwU, 2131232621, 2131231164);
                    return;
                }
                this.dwU.dwP.gO(i - this.dwU.dwO.getHeaderViewsCount());
                if (this.dwU.dwP.Ok().length > 0) {
                    this.dwU.iU(true);
                } else {
                    this.dwU.iU(false);
                }
            }
        });
        v.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + k.yh());
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
                new com.tencent.mm.ui.account.h(cVar, new com.tencent.mm.r.a(this) {
                    final /* synthetic */ InviteFacebookFriendsUI dwU;

                    {
                        this.dwU = r1;
                    }

                    public final void k(Bundle bundle) {
                        super.k(bundle);
                    }

                    public final void onError(int i, String str) {
                        super.onError(i, str);
                        if (i == 3) {
                            InviteFacebookFriendsUI.c(this.dwU);
                        }
                    }
                }).bAT();
            }
            final com.tencent.mm.v.k xVar = new x();
            xVar.Fu();
            final com.tencent.mm.sdk.platformtools.ah ahVar = new com.tencent.mm.sdk.platformtools.ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ InviteFacebookFriendsUI dwU;

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
                final /* synthetic */ InviteFacebookFriendsUI dwU;

                public final void onCancel(DialogInterface dialogInterface) {
                    ahVar.QI();
                    ak.vy().c(xVar);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI dwU;

            {
                this.dwU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dwU.axg();
                this.dwU.finish();
                return true;
            }
        });
        AnonymousClass9 anonymousClass9 = new OnClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI dwU;

            {
                this.dwU = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.dwU.dwO);
            }
        };
        a(0, getString(2131232619), new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI dwU;

            {
                this.dwU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.e.a.c cVar = new com.tencent.mm.ui.e.a.c("290293790992170");
                Bundle bundle = new Bundle();
                bundle.putString("message", this.dwU.getString(2131232618));
                final long[] Ok = this.dwU.dwP.Ok();
                String l = Long.toString(Ok[0]);
                for (int i = 1; i < Ok.length; i++) {
                    l = (l + ",") + Long.toString(Ok[i]);
                }
                bundle.putString("to", l);
                cVar.a(this.dwU, "apprequests", bundle, new com.tencent.mm.ui.e.a.c.a(this) {
                    final /* synthetic */ AnonymousClass10 dwZ;

                    public final void a(d dVar) {
                        v.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    }

                    public final void a(com.tencent.mm.ui.e.a.b bVar) {
                        v.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    }

                    public final void k(Bundle bundle) {
                        v.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
                        List arrayList = new ArrayList();
                        arrayList.add(new com.tencent.mm.ak.i.a(33, Integer.toString(Ok.length)));
                        ak.yW();
                        c.wG().b(new com.tencent.mm.ak.i(arrayList));
                        for (long j : Ok) {
                            q qVar = new q();
                            qVar.username = Long.toString(j);
                            qVar.cHW = 5;
                            qVar.cCe = (int) be.Nh();
                            ah.FP().a(qVar);
                        }
                        g.a(this.dwZ.dwU, 2131232620, 2131231164, 2131231183, 2131231104, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 dxa;

                            {
                                this.dxa = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.dxa.dwZ.dwU.dwP.Ol();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 dxa;

                            {
                                this.dxa = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.dxa.dwZ.dwU.finish();
                            }
                        });
                    }

                    public final void onCancel() {
                        v.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
                    }
                });
                return true;
            }
        });
        iU(false);
    }

    private void al(String str, String str2) {
        g.a((Context) this, str2, str, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI dwU;

            {
                this.dwU = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(this.dwU.nDR.nEl, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                this.dwU.nDR.nEl.startActivity(intent);
                this.dwU.finish();
            }
        }, null);
    }

    protected final int getLayoutId() {
        return 2130903632;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
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
                this.dwP.a(null, null);
            } else {
                Toast.makeText(this, 2131233852, 0).show();
            }
        }
    }
}
