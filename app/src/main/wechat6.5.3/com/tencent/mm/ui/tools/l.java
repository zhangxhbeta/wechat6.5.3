package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;

public final class l implements OnItemClickListener {
    private LayoutInflater CE;
    private k jXm;
    public c jXn;
    public d jXo;
    private com.tencent.mm.ui.base.l jXp = new com.tencent.mm.ui.base.l();
    private Context mContext;
    private a oTA;
    public com.tencent.mm.ui.base.n.a oTB;
    public b oTC;

    private class a extends BaseAdapter {
        final /* synthetic */ l oTE;

        private class a {
            TextView dID;
            ImageView dQZ;
            final /* synthetic */ a oTF;

            private a(a aVar) {
                this.oTF = aVar;
            }
        }

        private a(l lVar) {
            this.oTE = lVar;
        }

        public final int getCount() {
            return this.oTE.jXp.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.oTE.CE.inflate(2130903994, viewGroup, false);
                a aVar2 = new a();
                aVar2.dID = (TextView) view.findViewById(2131755226);
                aVar2.dQZ = (ImageView) view.findViewById(2131755225);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = this.oTE.jXp.getItem(i);
            aVar.dID.setText(item.getTitle());
            Drawable icon = this.oTE.jXp.getItem(i).getIcon();
            if (icon != null) {
                aVar.dQZ.setVisibility(0);
                aVar.dQZ.setImageDrawable(icon);
            } else if (this.oTE.oTB != null) {
                aVar.dQZ.setVisibility(0);
                this.oTE.oTB.a(aVar.dQZ, item);
            } else {
                aVar.dQZ.setVisibility(8);
            }
            if (this.oTE.oTC != null) {
                this.oTE.oTC.a(aVar.dID, item);
            }
            return view;
        }
    }

    public l(Context context) {
        this.mContext = context;
        this.CE = LayoutInflater.from(context);
        this.jXm = new k(context);
    }

    public final void a(View view, final OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        this.jXo = dVar;
        v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
        if (view instanceof AbsListView) {
            v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ l oTE;

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.oTE.jXp.clear();
                    v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
                    ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(this.oTE.jXp, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : this.oTE.jXp.nWF) {
                        ((m) menuItem).nWJ = adapterContextMenuInfo;
                    }
                    this.oTE.aXZ();
                    return true;
                }
            });
        } else if (view instanceof MMWebView) {
            v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
            view.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ l oTE;

                public final boolean onLongClick(View view) {
                    v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    this.oTE.jXp.clear();
                    onCreateContextMenuListener.onCreateContextMenu(this.oTE.jXp, view, null);
                    this.oTE.aXZ();
                    if (this.oTE.jXp.size() > 0) {
                        return true;
                    }
                    return false;
                }
            });
        } else {
            v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
            view.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ l oTE;

                public final boolean onLongClick(View view) {
                    v.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    this.oTE.jXp.clear();
                    onCreateContextMenuListener.onCreateContextMenu(this.oTE.jXp, view, null);
                    this.oTE.aXZ();
                    return true;
                }
            });
        }
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).dNj) {
            v.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
            return;
        }
        this.jXp.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.jXp, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.jXp.nWF) {
            ((m) menuItem).nWJ = adapterContextMenuInfo;
        }
        aXZ();
        this.jXo = dVar;
    }

    public final void b(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).dNj) {
            v.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
            return;
        }
        this.jXp.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.jXp, view, null);
        aXZ();
        this.jXo = dVar;
    }

    public final void d(OnCancelListener onCancelListener) {
        this.jXm.setOnCancelListener(onCancelListener);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) this.jXp.nWF.get(i);
        if (mVar.performClick()) {
            v.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.jXo != null) {
            this.jXo.c(mVar, i);
        }
        dismiss();
    }

    public final void dismiss() {
        if (this.jXm.isShowing()) {
            this.jXm.dismiss();
        }
    }

    public final Dialog aXZ() {
        if (this.jXn != null) {
            this.jXp.clear();
            this.jXp = new com.tencent.mm.ui.base.l();
            this.jXn.a(this.jXp);
        }
        if (this.jXp.bCl()) {
            v.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
            return null;
        }
        if (this.oTA == null) {
            this.oTA = new a();
        }
        this.jXm.eGK = this.oTA;
        this.jXm.lSE = this;
        this.jXm.setTitle(this.jXp.PF);
        this.jXm.show();
        return this.jXm;
    }
}
