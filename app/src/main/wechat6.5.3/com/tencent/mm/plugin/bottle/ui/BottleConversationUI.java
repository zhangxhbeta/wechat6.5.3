package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.plugin.bottle.a.b;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.l;

public class BottleConversationUI extends MMActivity {
    private String bdo;
    private p dwg = null;
    private TextView euo;
    private ListView eup;
    private a euq;
    private String eur;
    private d eus = new d(this) {
        final /* synthetic */ BottleConversationUI euu;

        {
            this.euu = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            g.a(this.euu, true, this.euu.getString(2131231517), "", this.euu.getString(2131231518), this.euu.getString(2131231010), new OnClickListener(this.euu, this.euu.bdo) {
                final /* synthetic */ BottleConversationUI euu;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    at MH = c.wJ().MH(r9);
                    ak.yW();
                    c.wG().b(new com.tencent.mm.ak.d(r9, MH.field_msgSvrId));
                    ak.yW();
                    c.wG().b(new f(r9, 0));
                    a.drq.ow();
                    this.euu.eut = false;
                    BottleConversationUI bottleConversationUI = this.euu;
                    BottleConversationUI bottleConversationUI2 = this.euu;
                    this.euu.getString(2131231164);
                    bottleConversationUI.dwg = g.a(bottleConversationUI2, this.euu.getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass3 euv;

                        {
                            this.euv = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.euv.euu.eut = true;
                        }
                    });
                    aw.a(r9, new aw.a(this) {
                        final /* synthetic */ AnonymousClass3 euv;

                        {
                            this.euv = r1;
                        }

                        public final boolean zp() {
                            return this.euv.euu.eut;
                        }

                        public final void zo() {
                            if (this.euv.euu.dwg != null) {
                                this.euv.euu.dwg.dismiss();
                                this.euv.euu.dwg = null;
                            }
                        }
                    });
                    ak.yW();
                    c.wK().Mf(r9);
                    b XG = i.XG();
                    String pw = com.tencent.mm.plugin.bottle.a.c.pw(r9);
                    XG.cuX.delete("bottleinfo1", "bottleid= ?", new String[]{pw});
                    a.drq.ow();
                }
            }, null);
        }
    };
    private boolean eut = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final int getLayoutId() {
        return 2130904546;
    }

    public void onDestroy() {
        this.euq.avc();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ak.yW();
        c.wH().a(this.euq);
        ak.yW();
        c.wK().a(this.euq);
        this.euq.a(null, null);
    }

    public void onPause() {
        ak.yW();
        c.wH().b(this.euq);
        ak.yW();
        c.wK().b(this.euq);
        ak.yW();
        at vh = c.wJ().vh(8);
        if (vh != null && vh.field_msgId > 0) {
            v.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + vh.field_createTime);
            ak.yW();
            c.vf().set(12306, Long.valueOf(vh.field_createTime));
        }
        ak.yW();
        ab Mh = c.wK().Mh("floatbottle");
        if (Mh == null || be.ma(Mh.field_username).length() <= 0) {
            v.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            Mh.df(0);
            ak.yW();
            if (c.wK().a(Mh, Mh.field_username, true) == -1) {
                v.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.euq.onPause();
        super.onPause();
    }

    protected final void NI() {
        int xJ = k.xJ() | 4096;
        int xQ = k.xQ() & -65;
        ak.yW();
        c.vf().set(7, Integer.valueOf(xJ));
        ak.yW();
        c.vf().set(34, Integer.valueOf(xQ));
        this.eup = (ListView) findViewById(2131756759);
        this.euo = (TextView) findViewById(2131756760);
        this.euo.setText(2131231519);
        this.euq = new a(this, new j.a(this) {
            final /* synthetic */ BottleConversationUI euu;

            {
                this.euu = r1;
            }

            public final void Oi() {
                BottleConversationUI bottleConversationUI = this.euu;
                String string = this.euu.getString(2131231525);
                int xD = com.tencent.mm.model.g.xD();
                if (xD <= 0) {
                    bottleConversationUI.Fd(string);
                } else {
                    bottleConversationUI.Fd(string + "(" + xD + ")");
                }
                if (this.euu.euq.getCount() <= 0) {
                    this.euu.euo.setVisibility(0);
                    this.euu.eup.setVisibility(8);
                    return;
                }
                this.euu.euo.setVisibility(8);
                this.euu.eup.setVisibility(0);
            }

            public final void Oj() {
            }
        });
        this.euq.a(new MMSlideDelView.c(this) {
            final /* synthetic */ BottleConversationUI euu;

            {
                this.euu = r1;
            }

            public final int bN(View view) {
                return this.euu.eup.getPositionForView(view);
            }
        });
        this.euq.a(new MMSlideDelView.f(this) {
            final /* synthetic */ BottleConversationUI euu;

            {
                this.euu = r1;
            }

            public final void p(View view, int i) {
                this.euu.eup.performItemClick(view, i, 0);
            }
        });
        this.euq.a(new e(this) {
            final /* synthetic */ BottleConversationUI euu;

            {
                this.euu = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    v.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
                } else {
                    g.a(this.euu, true, this.euu.getString(2131231517), "", this.euu.getString(2131231518), this.euu.getString(2131231010), /* anonymous class already generated */, null);
                }
            }
        });
        this.eup.setAdapter(this.euq);
        final l lVar = new l(this);
        this.eup.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BottleConversationUI euu;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.euu.eup.getHeaderViewsCount()) {
                    v.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.euu, this.euu.eus);
                }
                return true;
            }
        });
        this.eup.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BottleConversationUI euu;

            {
                this.euu = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ab abVar = (ab) this.euu.euq.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", abVar.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                a.drp.e(intent, this.euu);
            }
        });
        a.drq.ow();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleConversationUI euu;

            {
                this.euu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.euu.finish();
                return true;
            }
        });
        String stringExtra = getIntent().getStringExtra("conversation_from");
        if (be.kS(stringExtra) && be.kS(this.eur)) {
            a(0, getString(2131232209), new OnMenuItemClickListener(this) {
                final /* synthetic */ BottleConversationUI euu;

                {
                    this.euu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(this.euu, BottleBeachUI.class);
                    this.euu.startActivity(intent);
                    this.euu.finish();
                    return true;
                }
            });
        } else if (!be.kS(stringExtra)) {
            this.eur = stringExtra;
        }
        AnonymousClass11 anonymousClass11 = new View.OnClickListener(this) {
            final /* synthetic */ BottleConversationUI euu;

            {
                this.euu = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.euu.eup);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.bdo = ((ab) this.euq.getItem(adapterContextMenuInfo.position)).field_username;
        Object[] objArr = new Object[1];
        a aVar = this.euq;
        ak.yW();
        objArr[0] = aVar.y(c.wH().LX(this.bdo));
        contextMenu.setHeaderTitle(getString(2131231515, objArr));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, 2131231516);
    }
}
