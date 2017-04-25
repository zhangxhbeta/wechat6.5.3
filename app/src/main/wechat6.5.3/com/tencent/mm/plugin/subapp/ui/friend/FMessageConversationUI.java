package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ar.b;
import com.tencent.mm.ar.e;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactUI;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;

public class FMessageConversationUI extends MMActivity {
    private d eus = new d(this) {
        final /* synthetic */ FMessageConversationUI kgq;

        {
            this.kgq = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            e.kE(this.kgq.iag);
        }
    };
    private String iag;
    private b kfZ;
    private ListView kgn;
    private a kgo;
    private TextView kgp;

    class a {
        TextView dID;
        ImageView dQZ;
        final /* synthetic */ FMessageConversationUI kgq;

        public a(FMessageConversationUI fMessageConversationUI, View view) {
            this.kgq = fMessageConversationUI;
            this.dQZ = (ImageView) view.findViewById(2131757076);
            this.dID = (TextView) view.findViewById(2131757077);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232843);
        try {
            ak.oH().qs();
        } catch (Throwable e) {
            v.a("MicroMsg.FMessageConversationUI", e, "try cancel notification fail", new Object[0]);
        }
        if (ak.uz()) {
            NI();
        } else {
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        ak.yW();
        c.vf().set(143618, Integer.valueOf(0));
    }

    protected void onResume() {
        super.onResume();
        if (!ak.uz()) {
            finish();
        } else if (this.kgp != null && be.He()) {
            this.kgp.setText(2131232848);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.model.a.e.gf("1");
        l.KD().Kq();
        if (this.kfZ != null) {
            l.KD().d(this.kfZ);
        }
    }

    protected final void NI() {
        boolean z = true;
        if (f.Aj().ga("1") != null) {
            int i;
            String str = f.Aj().ga("1").value;
            if (str.equals("0")) {
                i = 0;
            } else if (str.equals("1")) {
                r0 = true;
            } else {
                r0 = true;
            }
            com.tencent.mm.model.a.e.ge("1");
            int i2 = i;
        } else {
            boolean z2 = true;
        }
        this.kfZ = new b(this.nDR.nEl);
        l.KD().c(this.kfZ);
        this.kfZ.nDK = new com.tencent.mm.ui.j.a(this) {
            final /* synthetic */ FMessageConversationUI kgq;

            {
                this.kgq = r1;
            }

            public final void Oj() {
            }

            public final void Oi() {
                if (this.kgq.kfZ.getCount() >= 0) {
                    this.kgq.U(0, true);
                } else {
                    this.kgq.U(0, false);
                }
            }
        };
        this.kgn = (ListView) findViewById(2131757069);
        if (i2 != 0) {
            View inflate = LayoutInflater.from(this.nDR.nEl).inflate(2130903657, null);
            inflate.findViewById(2131757078).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FMessageConversationUI kgq;

                {
                    this.kgq = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.ay.c.b(this.kgq.nDR.nEl, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0));
                }
            });
            this.kgn.addHeaderView(inflate);
        }
        this.kgn.setAdapter(this.kfZ);
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.kgn.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ FMessageConversationUI kgq;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.kgq.kgn.getHeaderViewsCount()) {
                    v.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
                } else {
                    View view2 = view;
                    lVar.a(view2, i - this.kgq.kgn.getHeaderViewsCount(), j, this.kgq, this.kgq.eus);
                }
                return true;
            }
        });
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        b bVar = this.kfZ;
        if (this.kgn.getHeaderViewsCount() <= 0) {
            z = false;
        }
        this.kgo = new a(actionBarActivity, bVar, z);
        this.kgn.setOnItemClickListener(this.kgo);
        View findViewById;
        if (i2 == 0) {
            findViewById = findViewById(2131757070);
            findViewById.setVisibility(0);
            ((TextView) findViewById(2131757072)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FMessageConversationUI kgq;

                {
                    this.kgq = r1;
                }

                public final void onClick(View view) {
                    ak.yW();
                    if (be.kS((String) c.vf().get(6, null))) {
                        Intent intent = new Intent(this.kgq.nDR.nEl, BindMContactIntroUI.class);
                        intent.putExtra("key_upload_scene", 5);
                        MMWizardActivity.w(this.kgq, intent);
                        return;
                    }
                    this.kgq.startActivity(new Intent(this.kgq, MobileFriendUI.class));
                }
            });
            this.kgn.setEmptyView(findViewById);
        } else {
            findViewById = findViewById(2131757071);
            findViewById.setVisibility(0);
            this.kgp = (TextView) findViewById.findViewById(2131757074);
            ListView listView = (ListView) findViewById.findViewById(2131757075);
            listView.setAdapter(new BaseAdapter(this) {
                final /* synthetic */ FMessageConversationUI kgq;

                {
                    this.kgq = r1;
                }

                public final View getView(int i, View view, ViewGroup viewGroup) {
                    a aVar;
                    if (view == null || view.getTag() == null) {
                        view = LayoutInflater.from(this.kgq.nDR.nEl).inflate(2130903656, null);
                        aVar = new a(this.kgq, view);
                        view.setTag(aVar);
                    } else {
                        aVar = (a) view.getTag();
                    }
                    if (i == 0) {
                        aVar.dQZ.setImageResource(2131165559);
                        aVar.dID.setText(2131232777);
                    } else {
                        aVar.dQZ.setImageResource(2131165992);
                        aVar.dID.setText(2131232773);
                    }
                    return view;
                }

                public final long getItemId(int i) {
                    return (long) i;
                }

                public final Object getItem(int i) {
                    return Integer.valueOf(i);
                }

                public final int getCount() {
                    return be.He() ? 2 : 1;
                }
            });
            listView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ FMessageConversationUI kgq;

                {
                    this.kgq = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Intent intent;
                    if (i != 0) {
                        if (!n.Fg()) {
                            intent = new Intent(this.kgq, BindGoogleContactUI.class);
                            intent.putExtra("enter_scene", 1);
                            MMWizardActivity.w(this.kgq, intent);
                        }
                        intent = new Intent(this.kgq, GoogleFriendUI.class);
                        intent.putExtra("enter_scene", 1);
                        this.kgq.startActivity(intent);
                    } else if (m.EY() != com.tencent.mm.modelfriend.m.a.cHR) {
                        intent = new Intent(this.kgq.nDR.nEl, BindMContactIntroUI.class);
                        intent.putExtra("key_upload_scene", 5);
                        MMWizardActivity.w(this.kgq.nDR.nEl, intent);
                    } else {
                        this.kgq.startActivity(new Intent(this.kgq.nDR.nEl, MobileFriendUI.class));
                    }
                }
            });
            this.kgn.setEmptyView(findViewById);
        }
        a(0, getString(2131233829), new OnMenuItemClickListener(this) {
            final /* synthetic */ FMessageConversationUI kgq;

            {
                this.kgq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kgq.startActivity(new Intent(this.kgq, AddMoreFriendsUI.class));
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FMessageConversationUI kgq;

            {
                this.kgq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kgq.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903653;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        b bVar = (b) this.kfZ.getItem(adapterContextMenuInfo.position);
        if (bVar == null) {
            v.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        if (!be.kS(bVar.field_displayName)) {
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(this, bVar.field_displayName));
        }
        contextMenu.add(0, 0, 0, 2131231020);
        this.iag = bVar.field_talker;
    }
}
