package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.k;
import com.tencent.mm.ar.l;
import com.tencent.mm.i.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;

public class ShakeSayHiListUI extends MMActivity {
    private int aGx = 0;
    private long bgU;
    private ListView dwO;
    private d eus = new d(this) {
        final /* synthetic */ ShakeSayHiListUI iSP;

        {
            this.iSP = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            l.KF().kI(String.valueOf(this.iSP.bgU));
            this.iSP.iSO.a(null, null);
        }
    };
    private int hFR = 0;
    private int hFS = 0;
    private k iQF = null;
    private int iSN = 0;
    private b iSO;

    static /* synthetic */ int a(ShakeSayHiListUI shakeSayHiListUI) {
        int i = shakeSayHiListUI.aGx + 8;
        shakeSayHiListUI.aGx = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iSN = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.iSN == 1) {
            this.iQF = l.KF();
            vD(2131234734);
        } else {
            vD(2131234732);
        }
        this.hFS = this.iQF.Kw();
        this.aGx = this.hFS == 0 ? 8 : this.hFS;
        this.hFR = this.iQF.getCount();
        k kVar = this.iQF;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (kVar.cie.update(kVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            kVar.Ls();
        }
        NI();
    }

    protected void onResume() {
        super.onResume();
        if (this.hFR != this.iQF.getCount()) {
            this.hFR = this.iQF.getCount();
            if (this.hFR == 0) {
                TextView textView = (TextView) findViewById(2131756760);
                textView.setText(2131234735);
                textView.setVisibility(0);
                iT(false);
            }
            this.iSO.Ol();
        }
        this.iSO.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.iSO.avc();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.iSO.euf != null) {
            this.iSO.euf.avm();
        }
    }

    protected final int getLayoutId() {
        return 2130903855;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void NI() {
        final View inflate = getLayoutInflater().inflate(2130904286, null);
        this.dwO = (ListView) findViewById(2131757692);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            public final void onClick(View view) {
                ShakeSayHiListUI.a(this.iSP);
                v.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + this.iSP.aGx);
                this.iSP.iSO.pr(this.iSP.aGx);
                if (this.iSP.hFR <= this.iSP.aGx) {
                    this.iSP.dwO.removeFooterView(inflate);
                    v.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + this.iSP.aGx);
                }
            }
        });
        a(0, getString(2131231012), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            {
                this.iSP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.iSP.nDR.nEl, true, this.iSP.getString(2131234730), "", this.iSP.getString(2131234729), this.iSP.getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 iSQ;

                    {
                        this.iSQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iSQ.iSP.iQF.Kz();
                        this.iSQ.iSP.iSO.Ol();
                        TextView textView = (TextView) this.iSQ.iSP.findViewById(2131756760);
                        textView.setText(2131234735);
                        textView.setVisibility(0);
                        this.iSQ.iSP.iT(false);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 iSQ;

                    {
                        this.iSQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        if (this.hFR == 0) {
            TextView textView = (TextView) findViewById(2131756760);
            textView.setText(2131234735);
            textView.setVisibility(0);
            iT(false);
        }
        if (this.hFR > 0 && this.aGx < this.hFR) {
            this.dwO.addFooterView(inflate);
        }
        this.iSO = new b(this, this.iQF, this.aGx);
        this.iSO.a(new c(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            {
                this.iSP = r1;
            }

            public final int bN(View view) {
                return this.iSP.dwO.getPositionForView(view);
            }
        });
        this.iSO.a(new f(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            {
                this.iSP = r1;
            }

            public final void p(View view, int i) {
                this.iSP.dwO.performItemClick(view, i, 0);
            }
        });
        this.iSO.a(new e(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            {
                this.iSP = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    v.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    return;
                }
                l.KF().kI(obj.toString());
                this.iSP.iSO.a(null, null);
            }
        });
        this.dwO.setAdapter(this.iSO);
        this.dwO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            {
                this.iSP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                j jVar = (j) this.iSP.iSO.getItem(i);
                if (jVar != null && jVar.field_content != null) {
                    at.d MB = at.d.MB(jVar.field_content);
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", MB.lct);
                    intent.putExtra("Contact_Encryptusername", MB.nvR);
                    intent.putExtra("Contact_Alias", MB.bLc);
                    intent.putExtra("Contact_Nick", MB.cID);
                    intent.putExtra("Contact_QuanPin", MB.cIF);
                    intent.putExtra("Contact_PyInitial", MB.cIE);
                    intent.putExtra("Contact_Sex", MB.bBZ);
                    intent.putExtra("Contact_Signature", MB.bCj);
                    intent.putExtra("Contact_Scene", MB.scene);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", MB.getCity());
                    intent.putExtra("Contact_Province", MB.getProvince());
                    intent.putExtra("Contact_Content", be.kS(jVar.field_sayhicontent) ? this.iSP.getString(2131231796) : jVar.field_sayhicontent);
                    intent.putExtra("Contact_verify_Scene", MB.scene);
                    intent.putExtra("Contact_Uin", MB.hWq);
                    intent.putExtra("Contact_QQNick", MB.cIG);
                    intent.putExtra("Contact_Mobile_MD5", MB.nvG);
                    intent.putExtra("User_From_Fmessage", true);
                    intent.putExtra("Contact_from_msgType", 37);
                    intent.putExtra("Verify_ticket", MB.hUb);
                    intent.putExtra("Contact_ShowFMessageList", true);
                    intent.putExtra("Contact_Source_FMessage", MB.scene);
                    intent.putExtra("Contact_AlwaysShowRemarkBtn", true);
                    intent.putExtra("Contact_AlwaysShowSnsPreBtn", true);
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(MB.lct);
                    if (!(LX == null || ((int) LX.chr) < 0 || a.ei(LX.field_type))) {
                        int i2 = MB.bdn;
                        if (i2 == 0 || i2 == 2 || i2 == 5) {
                            intent.putExtra("User_Verify", true);
                        }
                        intent.putExtra("Contact_IsLBSFriend", true);
                        intent.putExtra("Sns_from_Scene", 18);
                    }
                    com.tencent.mm.plugin.shake.a.drp.d(intent, this.iSP);
                }
            }
        });
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.dwO.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.iSP.dwO.getHeaderViewsCount()) {
                    v.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.iSP, this.iSP.eus);
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            {
                this.iSP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iSP.axg();
                this.iSP.finish();
                return true;
            }
        });
        AnonymousClass10 anonymousClass10 = new OnClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI iSP;

            {
                this.iSP = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.iSP.dwO);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.bgU = ((j) this.iSO.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, 2131231020);
    }
}
