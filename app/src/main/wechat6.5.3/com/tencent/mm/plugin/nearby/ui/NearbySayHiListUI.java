package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ar.h;
import com.tencent.mm.ar.i;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.j;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class NearbySayHiListUI extends MMActivity implements e {
    private int aGx = 0;
    private int caG = 0;
    private ListView dwO;
    private p dwg = null;
    private d eus = new d(this) {
        final /* synthetic */ NearbySayHiListUI hFX;

        {
            this.hFX = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            l.KE().kI(String.valueOf(this.hFX.hFV));
            this.hFX.hFQ.a(null, null);
            if (this.hFX.hFR > 0) {
                this.hFX.hFR = this.hFX.hFR - 1;
            }
            NearbySayHiListUI.k(this.hFX);
        }
    };
    private com.tencent.mm.plugin.nearby.a.d hEX;
    private i hFP = null;
    private a hFQ;
    private int hFR = 0;
    private int hFS = 0;
    private View hFT;
    private boolean hFU;
    private long hFV;

    class a extends j<h> {
        int aGx = -1;
        private MMActivity aWn;
        protected f euc;
        protected c eud;
        protected MMSlideDelView.d euf = MMSlideDelView.bCp();
        private i hFP;
        final /* synthetic */ NearbySayHiListUI hFX;
        protected MMSlideDelView.e hGa;

        class a {
            TextView cHI;
            ImageView dtz;
            View eum;
            TextView eun;
            final /* synthetic */ a hGb;
            TextView hka;

            a(a aVar) {
                this.hGb = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (h) obj;
            if (obj == null) {
                obj = new h();
            }
            obj.b(cursor);
            return obj;
        }

        public a(NearbySayHiListUI nearbySayHiListUI, Context context, i iVar, int i) {
            this.hFX = nearbySayHiListUI;
            super(context, new h());
            this.aWn = (MMActivity) context;
            this.aGx = i;
            this.hFP = iVar;
        }

        public final void a(f fVar) {
            this.euc = fVar;
        }

        public final void a(MMSlideDelView.e eVar) {
            this.hGa = eVar;
        }

        public final void a(c cVar) {
            this.eud = cVar;
        }

        protected final void Om() {
            Ol();
        }

        public final void Ol() {
            i iVar;
            if (com.tencent.mm.aw.a.bmn()) {
                iVar = this.hFP;
                int i = this.aGx;
                setCursor(iVar.cie.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + iVar.getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i) + ") b left join " + iVar.getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i, null));
            } else {
                iVar = this.hFP;
                setCursor(iVar.cie.rawQuery("SELECT * FROM " + iVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.aGx, null));
            }
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            h hVar = (h) getItem(i);
            if (view == null) {
                a aVar2 = new a(this);
                MMSlideDelView mMSlideDelView = (MMSlideDelView) View.inflate(this.aWn, 2130903162, null);
                View inflate = View.inflate(this.aWn, 2130904285, null);
                aVar2.dtz = (ImageView) inflate.findViewById(2131756891);
                aVar2.cHI = (TextView) inflate.findViewById(2131758942);
                aVar2.hka = (TextView) inflate.findViewById(2131758943);
                aVar2.eum = mMSlideDelView.findViewById(2131755551);
                aVar2.eun = (TextView) mMSlideDelView.findViewById(2131755552);
                mMSlideDelView.setView(inflate);
                mMSlideDelView.euc = this.euc;
                mMSlideDelView.eud = this.eud;
                mMSlideDelView.euf = this.euf;
                mMSlideDelView.gMt = false;
                mMSlideDelView.setTag(aVar2);
                view = mMSlideDelView;
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (hVar.field_flag != 0) {
                charSequence = at.d.MB(hVar.field_content).cID;
            } else {
                charSequence = hVar.field_talker;
            }
            aVar.cHI.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, charSequence, aVar.cHI.getTextSize()));
            aVar.hka.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, hVar.field_sayhicontent, aVar.hka.getTextSize()));
            aVar.eum.setTag(Long.valueOf(hVar.field_svrid));
            aVar.eum.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hGb;

                {
                    this.hGb = r1;
                }

                public final void onClick(View view) {
                    v.v("MicroMsg.SayHiAdapter", "on delView clicked");
                    this.hGb.euf.avn();
                    if (this.hGb.hGa != null) {
                        this.hGb.hGa.aE(view.getTag());
                    }
                }
            });
            b.m(aVar.dtz, hVar.field_sayhiuser);
            return view;
        }
    }

    static /* synthetic */ int a(NearbySayHiListUI nearbySayHiListUI) {
        int i = nearbySayHiListUI.aGx + 8;
        nearbySayHiListUI.aGx = i;
        return i;
    }

    static /* synthetic */ void k(NearbySayHiListUI nearbySayHiListUI) {
        if (nearbySayHiListUI.hFR == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(2131756760);
            textView.setText(2131234735);
            textView.setVisibility(0);
            nearbySayHiListUI.iT(false);
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        NearbySayHiListUI nearbySayHiListUI;
        super.onCreate(bundle);
        this.caG = be.KL(com.tencent.mm.h.j.sU().getValue("ThresholdToCleanLocation"));
        this.hFU = getIntent().getBooleanExtra("show_clear_header", false);
        this.hFP = l.KE();
        vD(2131234732);
        this.hFS = this.hFP.Kw();
        this.hFR = this.hFP.getCount();
        if (com.tencent.mm.aw.a.bmn()) {
            i = this.hFR;
            nearbySayHiListUI = this;
        } else if (this.hFS == 0) {
            i = 8;
            nearbySayHiListUI = this;
        } else {
            i = this.hFS;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.aGx = i;
        this.hFP.Ky();
        NI();
    }

    protected void onResume() {
        super.onResume();
        if (this.hFR != this.hFP.getCount()) {
            this.hFR = this.hFP.getCount();
            if (this.hFR == 0) {
                TextView textView = (TextView) findViewById(2131756760);
                textView.setText(2131234735);
                textView.setVisibility(0);
                iT(false);
            }
            this.hFQ.Ol();
        }
        this.hFQ.notifyDataSetChanged();
        ak.vy().a(148, this);
    }

    public void onDestroy() {
        this.hFQ.avc();
        super.onDestroy();
    }

    public void onPause() {
        ak.vy().b(148, this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903855;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void NI() {
        this.dwO = (ListView) findViewById(2131757692);
        if (!com.tencent.mm.aw.a.bmn()) {
            final View inflate = getLayoutInflater().inflate(2130904286, null);
            inflate.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NearbySayHiListUI hFX;

                public final void onClick(View view) {
                    NearbySayHiListUI.a(this.hFX);
                    v.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + this.hFX.aGx);
                    a c = this.hFX.hFQ;
                    int b = this.hFX.aGx;
                    c.avc();
                    c.aGx = b;
                    c.Ol();
                    if (this.hFX.hFR <= this.hFX.aGx) {
                        this.hFX.dwO.removeFooterView(inflate);
                        v.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + this.hFX.aGx);
                    }
                }
            });
            if (this.hFR > 0 && this.aGx < this.hFR) {
                this.dwO.addFooterView(inflate);
            }
        }
        a(0, getString(2131231012), new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            {
                this.hFX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.hFX.nDR.nEl, true, this.hFX.getResources().getString(2131234730), "", this.hFX.getResources().getString(2131234729), this.hFX.getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass5 hFY;

                    {
                        this.hFY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.hFY.hFX.hFP.Kz();
                        this.hFY.hFX.hFQ.Ol();
                        TextView textView = (TextView) this.hFY.hFX.findViewById(2131756760);
                        textView.setText(2131234735);
                        textView.setVisibility(0);
                        this.hFY.hFX.iT(false);
                    }
                }, null);
                return true;
            }
        });
        if (this.hFR == 0) {
            TextView textView = (TextView) findViewById(2131756760);
            textView.setText(2131234735);
            textView.setVisibility(0);
            iT(false);
        }
        if (this.hFU && this.caG != 0 && this.hFS >= this.caG && be.He()) {
            this.hFT = new CleanLocationHeaderView(this);
            this.hFT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NearbySayHiListUI hFX;

                {
                    this.hFX = r1;
                }

                public final void onClick(View view) {
                    this.hFX.hEX = new com.tencent.mm.plugin.nearby.a.d(2, 0.0f, 0.0f, 0, 0, "", "");
                    ak.vy().a(this.hFX.hEX, 0);
                    NearbySayHiListUI nearbySayHiListUI = this.hFX;
                    ActionBarActivity actionBarActivity = this.hFX.nDR.nEl;
                    this.hFX.getString(2131231164);
                    nearbySayHiListUI.dwg = g.a(actionBarActivity, this.hFX.getString(2131233986), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 hFZ;

                        {
                            this.hFZ = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(this.hFZ.hFX.hEX);
                        }
                    });
                    com.tencent.mm.plugin.report.service.g.iuh.Y(11429, "0");
                }
            });
            this.dwO.addHeaderView(this.hFT);
        }
        this.hFQ = new a(this, this, this.hFP, this.aGx);
        this.hFQ.a(new c(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            {
                this.hFX = r1;
            }

            public final int bN(View view) {
                return this.hFX.dwO.getPositionForView(view);
            }
        });
        this.hFQ.a(new f(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            {
                this.hFX = r1;
            }

            public final void p(View view, int i) {
                this.hFX.dwO.performItemClick(view, i, 0);
            }
        });
        this.hFQ.a(new MMSlideDelView.e(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            {
                this.hFX = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    v.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    return;
                }
                l.KE().kI(obj.toString());
                this.hFX.hFQ.a(null, null);
            }
        });
        this.dwO.setAdapter(this.hFQ);
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.dwO.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.hFX.dwO.getHeaderViewsCount()) {
                    v.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.hFX, this.hFX.eus);
                }
                return true;
            }
        });
        this.dwO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            {
                this.hFX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.hFX.dwO.getHeaderViewsCount() > 0) {
                    i -= this.hFX.dwO.getHeaderViewsCount();
                }
                h hVar = (h) this.hFX.hFQ.getItem(i);
                if (hVar != null && hVar.field_content != null) {
                    at.d MB = at.d.MB(hVar.field_content);
                    Intent intent = new Intent();
                    if (com.tencent.mm.aw.a.bmn()) {
                        intent.putExtra("Chat_User", hVar.field_sayhiencryptuser);
                        intent.putExtra("lbs_mode", true);
                        intent.putExtra("add_scene", 18);
                        com.tencent.mm.plugin.nearby.a.drp.e(intent, this.hFX);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", be.kS(MB.lct) ? hVar.field_sayhiuser : MB.lct);
                        intent2.putExtra("Contact_Alias", MB.bLc);
                        intent2.putExtra("Contact_Nick", MB.cID);
                        intent2.putExtra("Contact_QuanPin", MB.cIF);
                        intent2.putExtra("Contact_PyInitial", MB.cIE);
                        intent2.putExtra("Contact_Sex", MB.bBZ);
                        intent2.putExtra("Contact_Signature", MB.bCj);
                        intent2.putExtra("Contact_Scene", MB.scene);
                        intent2.putExtra("Contact_FMessageCard", true);
                        intent2.putExtra("Contact_City", MB.getCity());
                        intent2.putExtra("Contact_Province", MB.getProvince());
                        intent2.putExtra("Contact_Content", be.kS(hVar.field_sayhicontent) ? this.hFX.getString(2131231796) : hVar.field_sayhicontent);
                        intent2.putExtra("Contact_verify_Scene", MB.scene);
                        intent2.putExtra("Contact_Uin", MB.hWq);
                        intent2.putExtra("Contact_QQNick", MB.cIG);
                        intent2.putExtra("Contact_Mobile_MD5", MB.nvG);
                        intent2.putExtra("User_From_Fmessage", true);
                        intent2.putExtra("Contact_from_msgType", 37);
                        intent2.putExtra("Verify_ticket", MB.hUb);
                        intent2.putExtra("Contact_Source_FMessage", MB.scene);
                        intent2.putExtra("Contact_ShowFMessageList", true);
                        intent2.putExtra("Contact_AlwaysShowRemarkBtn", true);
                        intent2.putExtra("Contact_AlwaysShowSnsPreBtn", true);
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(MB.lct);
                        if (!(LX == null || ((int) LX.chr) < 0 || com.tencent.mm.i.a.ei(LX.field_type))) {
                            int i2 = MB.bdn;
                            if (i2 == 0 || i2 == 2 || i2 == 5) {
                                intent2.putExtra("User_Verify", true);
                            }
                            intent2.putExtra("Contact_IsLBSFriend", true);
                            intent2.putExtra("Sns_from_Scene", 18);
                        }
                        com.tencent.mm.plugin.nearby.a.drp.d(intent2, this.hFX);
                    }
                    com.tencent.mm.e.a.h hVar2 = new com.tencent.mm.e.a.h();
                    hVar2.aWw.scene = MB.scene;
                    com.tencent.mm.sdk.c.a.nhr.z(hVar2);
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            {
                this.hFX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hFX.axg();
                this.hFX.setResult(0);
                this.hFX.finish();
                return true;
            }
        });
        AnonymousClass2 anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ NearbySayHiListUI hFX;

            {
                this.hFX = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.hFX.dwO);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        h hVar = (h) this.hFQ.getItem(adapterContextMenuInfo.position);
        if (hVar == null) {
            v.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        contextMenu.add(0, 0, 0, 2131231020);
        this.hFV = hVar.field_svrid;
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        if (i != 0 || i2 != 0) {
            v.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((com.tencent.mm.plugin.nearby.a.d) kVar).AG() == 2) {
            g.a(this.nDR.nEl, getString(2131233985), "", new DialogInterface.OnClickListener(this) {
                final /* synthetic */ NearbySayHiListUI hFX;

                {
                    this.hFX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hFX.setResult(-1);
                    this.hFX.finish();
                }
            });
            this.hEX = null;
        }
    }
}
