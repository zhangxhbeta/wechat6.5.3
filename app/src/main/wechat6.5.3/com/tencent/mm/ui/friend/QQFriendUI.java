package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ag;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.k;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.d.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.v.e;

public class QQFriendUI extends MMActivity implements e {
    private int NW;
    private ListView dwO;
    private ProgressDialog dwR = null;
    String dwS;
    private p eSv;
    private boolean gYJ = false;
    private TextView nIp = null;
    d oOD;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(143, this);
        String stringExtra = getIntent().getStringExtra("qqgroup_name");
        this.NW = getIntent().getIntExtra("qqgroup_id", -1);
        ag FQ = ah.FQ();
        int i = this.NW;
        v.d("MicroMsg.QQListStorage", "delete: GroupID:" + i);
        FQ.cuX.dF("qqlist", "update qqlist set reserved4=0 where groupid=" + i);
        if (m.fp(this.NW)) {
            final y yVar = new y(this.NW);
            ak.vy().a(yVar, 0);
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(actionBarActivity, getString(2131234263), true, new OnCancelListener(this) {
                final /* synthetic */ QQFriendUI oOF;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(yVar);
                }
            });
        }
        Fd(stringExtra);
        NI();
    }

    protected void onResume() {
        super.onResume();
        n.AX().d(this.oOD);
        this.oOD.notifyDataSetChanged();
    }

    public void onDestroy() {
        com.tencent.mm.model.a.e.gf("2");
        ah.FQ().b(this.oOD);
        ak.vy().b(143, this);
        this.oOD.avc();
        n.Bq().cancel();
        super.onDestroy();
    }

    public void onPause() {
        n.AX().e(this.oOD);
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130904208;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        v.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void NI() {
        boolean z;
        this.dwO = (ListView) findViewById(2131758676);
        this.nIp = (TextView) findViewById(2131758677);
        this.nIp.setText(2131234266);
        this.eSv = new p(true, true);
        this.eSv.oUs = new b(this) {
            final /* synthetic */ QQFriendUI oOF;

            {
                this.oOF = r1;
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void ml(String str) {
                this.oOF.dwS = be.lZ(str);
                this.oOF.gYJ = true;
                QQFriendUI qQFriendUI = this.oOF;
                if (qQFriendUI.oOD != null) {
                    qQFriendUI.oOD.uU(qQFriendUI.dwS);
                }
            }

            public final void Of() {
            }

            public final void Og() {
            }

            public final void Oh() {
            }
        };
        a(this.eSv);
        if (f.Aj().ga("2") != null) {
            String str = f.Aj().ga("2").value;
            if (str.equals("0")) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            com.tencent.mm.model.a.e.ge("2");
        } else {
            z = true;
        }
        if (z) {
            this.oOD = new f(this, this.NW);
        } else {
            this.oOD = new e(this, this.NW);
        }
        this.oOD.a(new a(this) {
            final /* synthetic */ QQFriendUI oOF;

            {
                this.oOF = r1;
            }

            public final void vT(int i) {
                if (this.oOF.gYJ) {
                    if (i > 0) {
                        this.oOF.nIp.setVisibility(8);
                    } else {
                        this.oOF.nIp.setVisibility(0);
                    }
                }
                this.oOF.gYJ = false;
            }
        });
        this.dwO.setAdapter(this.oOD);
        this.dwO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ QQFriendUI oOF;

            {
                this.oOF = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.oOF.dwO.getHeaderViewsCount()) {
                    v.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[]{Integer.valueOf(i - this.oOF.dwO.getHeaderViewsCount()), Integer.valueOf(this.oOF.dwO.getHeaderViewsCount())});
                    af afVar = (af) this.oOF.oOD.getItem(r0);
                    Intent intent;
                    if (this.oOF.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                        ke keVar = new ke();
                        keVar.bla.opType = 0;
                        keVar.bla.blc = afVar.cIA + "@qqim";
                        keVar.bla.bld = afVar.getDisplayName();
                        com.tencent.mm.sdk.c.a.nhr.z(keVar);
                        if (keVar.blb.aYN) {
                            intent = new Intent();
                            intent.putExtra("Chat_User", afVar.cIA + "@qqim");
                            intent.putExtra("key_need_send_video", false);
                            com.tencent.mm.plugin.a.a.drp.e(intent, this.oOF);
                        }
                    } else if (afVar.cIB == 1 || afVar.cIB == 2) {
                        ak.yW();
                        u LX = c.wH().LX(afVar.getUsername());
                        if (LX != null && LX.bvm()) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(10298, afVar.getUsername() + ",12");
                        }
                        intent = new Intent();
                        intent.putExtra("Contact_User", afVar.getUsername());
                        intent.putExtra("Contact_Nick", afVar.FC());
                        intent.putExtra("Contact_Uin", afVar.cIA);
                        intent.putExtra("Contact_QQNick", afVar.getDisplayName());
                        intent.putExtra("Contact_Scene", 12);
                        intent.putExtra("Contact_RemarkName", afVar.FG());
                        k iH = ah.FN().iH(afVar.getUsername());
                        if (iH != null) {
                            intent.putExtra("Contact_Sex", iH.bBZ);
                        }
                        intent.putExtra("Contact_ShowUserName", false);
                        if (be.kS(afVar.getUsername())) {
                            v.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[]{afVar.toString()});
                            return;
                        }
                        com.tencent.mm.plugin.a.a.drp.d(intent, this.oOF);
                    } else if (afVar.cIB == 0) {
                        intent = new Intent(this.oOF, InviteFriendUI.class);
                        intent.putExtra("friend_type", 0);
                        intent.putExtra("friend_user_name", afVar.getUsername());
                        intent.putExtra("friend_num", afVar.cIA);
                        intent.putExtra("friend_nick", afVar.getDisplayName());
                        intent.putExtra("friend_weixin_nick", afVar.FC());
                        intent.putExtra("friend_scene", 12);
                        this.oOF.startActivity(intent);
                    }
                }
            }
        });
        ah.FQ().a(this.oOD);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ QQFriendUI oOF;

            {
                this.oOF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oOF.axg();
                this.oOF.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new OnClickListener(this) {
            final /* synthetic */ QQFriendUI oOF;

            {
                this.oOF = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.oOF.dwO);
            }
        };
    }

    public void onConfigurationChanged(Configuration configuration) {
        v.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((yh) ((y) kVar).cif.czk.czs).gly == 1) {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (i == 0 && i2 == 0) {
                this.oOD.Ol();
            } else {
                Toast.makeText(this, 2131234262, 0).show();
            }
        }
    }
}
