package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.e.r;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.DragSortListView.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiSortUI extends EmojiBaseActivity implements a, e {
    ProgressDialog eZg;
    private com.tencent.mm.plugin.emoji.a.e fhT;
    private DragSortListView fhU;
    private r fhV;
    private g fhW = new g(this) {
        final /* synthetic */ EmojiSortUI fhY;

        {
            this.fhY = r1;
        }

        public final void bz(int i, int i2) {
            com.tencent.mm.storage.a.a aVar = (com.tencent.mm.storage.a.a) this.fhY.fhT.getItem(i);
            this.fhY.fhT.remove(aVar);
            this.fhY.fhT.insert(aVar, i2);
        }
    };
    private l fhX = new l(this) {
        final /* synthetic */ EmojiSortUI fhY;

        {
            this.fhY = r1;
        }

        public final void remove(int i) {
            this.fhY.fhT.remove(this.fhY.fhT.getItem(i));
        }
    };
    private ArrayList<com.tencent.mm.storage.a.a> mData = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        this.mData = com.tencent.mm.plugin.emoji.model.g.afx().fci.bxC();
        this.fhU = (DragSortListView) findViewById(16908298);
        this.fhU.oZO = this.fhW;
        this.fhU.oZP = this.fhX;
        this.fhT = new com.tencent.mm.plugin.emoji.a.e(this.nDR.nEl, this.mData);
        this.fhU.setAdapter(this.fhT);
        com.tencent.mm.plugin.emoji.model.g.afx().fci.c(this);
        ak.vy().a(717, this);
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.emoji.model.g.afx().fci.d(this);
        ak.vy().b(717, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903481;
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiSortUI fhY;

            {
                this.fhY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fhY.finish();
                return true;
            }
        });
        Fd(getString(2131235006));
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiSortUI fhY;

            {
                this.fhY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (com.tencent.mm.sdk.platformtools.ak.isConnected(aa.getContext())) {
                    EmojiSortUI emojiSortUI = this.fhY;
                    emojiSortUI.getString(2131231164);
                    emojiSortUI.eZg = com.tencent.mm.ui.base.g.a(emojiSortUI, emojiSortUI.getString(2131231182), true, new OnCancelListener(emojiSortUI) {
                        final /* synthetic */ EmojiSortUI fhY;

                        {
                            this.fhY = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (this.fhY.fhV != null) {
                                ak.vy().c(this.fhY.fhV);
                            }
                        }
                    });
                    List arrayList = new ArrayList();
                    if (!(this.fhY.fhT == null || this.fhY.fhT.eZk == null)) {
                        for (com.tencent.mm.storage.a.a aVar : this.fhY.fhT.eZk) {
                            arrayList.add(aVar.field_productID);
                        }
                    }
                    this.fhY.fhV = new r(arrayList, 2);
                    ak.vy().a(this.fhY.fhV, 0);
                } else {
                    com.tencent.mm.ui.base.g.a(this.fhY, this.fhY.getString(2131232364), "", this.fhY.getString(2131232363), new OnClickListener(this.fhY) {
                        final /* synthetic */ EmojiSortUI fhY;

                        {
                            this.fhY = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        });
        ((TextView) findViewById(16908310)).setText(2131232386);
    }

    public final void a(String str, i iVar) {
        if (str != null && str.equals("event_update_group") && this.fhT != null) {
            com.tencent.mm.plugin.emoji.a.e eVar = this.fhT;
            ArrayList bxC = com.tencent.mm.plugin.emoji.model.g.afx().fci.bxC();
            eVar.clear();
            Iterator it = bxC.iterator();
            while (it.hasNext()) {
                eVar.insert((com.tencent.mm.storage.a.a) it.next(), eVar.getCount());
            }
            eVar.notifyDataSetChanged();
        }
    }

    public final void f(Message message) {
    }

    public final void g(Message message) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i + "   errCode:" + i2);
        if (this.eZg != null) {
            this.eZg.dismiss();
        }
        if (i == 0 && i == 0) {
            this.fhT.aeL();
            finish();
            return;
        }
        com.tencent.mm.ui.base.g.a(this, getString(2131232362), "", new OnClickListener(this) {
            final /* synthetic */ EmojiSortUI fhY;

            {
                this.fhY = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
