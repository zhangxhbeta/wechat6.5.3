package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI extends MMActivity implements e {
    private ListView Eq;
    private String biB;
    private p dwg;
    private o ePs;
    private a eQk;
    private LinkedList<String> eQl = new LinkedList();
    private int scene;

    class a extends BaseAdapter {
        final /* synthetic */ DelChatroomMemberUI eQm;
        List<u> eQn = new LinkedList();

        a(DelChatroomMemberUI delChatroomMemberUI) {
            this.eQm = delChatroomMemberUI;
        }

        public final void ai(List<String> list) {
            Object obj = null;
            for (String str : list) {
                Object obj2;
                for (Object obj3 : this.eQn) {
                    if (obj3.field_username.equals(str)) {
                        break;
                    }
                }
                Object obj32 = null;
                if (obj32 != null) {
                    obj2 = 1;
                    this.eQn.remove(obj32);
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj != null) {
                notifyDataSetChanged();
            }
        }

        public final int getCount() {
            return this.eQn.size();
        }

        public final Object getItem(int i) {
            return this.eQn.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(this.eQm, 2130903275, null);
                bVar = new b(this.eQm);
                bVar.dtX = (ImageView) view.findViewById(2131756026);
                bVar.euh = (TextView) view.findViewById(2131756028);
                bVar.eQr = (TextView) view.findViewById(2131756027);
                bVar.eQr.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a eQo;

                    {
                        this.eQo = r1;
                    }

                    public final void onClick(View view) {
                        final u uVar = (u) this.eQo.getItem(((Integer) view.getTag()).intValue());
                        g.a(this.eQo.eQm, this.eQo.eQm.getString(2131234582, new Object[]{this.eQo.c(uVar)}), null, this.eQo.eQm.getString(2131234589), this.eQo.eQm.getString(2131231010), true, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 eQq;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                DelChatroomMemberUI.a(this.eQq.eQo.eQm, uVar.field_username);
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 eQq;

                            {
                                this.eQq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                });
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eQr.setTag(Integer.valueOf(i));
            u uVar = (u) getItem(i);
            CharSequence c = c(uVar);
            bVar.euh.setText(c);
            com.tencent.mm.pluginsdk.ui.d.e.a(this.eQm, c, bVar.euh.getTextSize());
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.dtX, uVar.field_username);
            return view;
        }

        public final String c(u uVar) {
            String b;
            if (be.kS(uVar.field_conRemark)) {
                b = DelChatroomMemberUI.b(this.eQm, uVar.field_username);
            } else {
                b = uVar.field_conRemark;
            }
            if (be.kS(b)) {
                b = uVar.field_conRemark;
            }
            if (be.kS(b)) {
                return uVar.tT();
            }
            return b;
        }
    }

    class b {
        public ImageView dtX;
        final /* synthetic */ DelChatroomMemberUI eQm;
        public TextView eQr;
        public TextView euh;

        b(DelChatroomMemberUI delChatroomMemberUI) {
            this.eQm = delChatroomMemberUI;
        }
    }

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            final com.tencent.mm.plugin.chatroom.c.g gVar = new com.tencent.mm.plugin.chatroom.c.g(delChatroomMemberUI.biB, linkedList, delChatroomMemberUI.scene);
            delChatroomMemberUI.getString(2131231164);
            delChatroomMemberUI.dwg = g.a(delChatroomMemberUI, delChatroomMemberUI.getString(2131234578), true, new OnCancelListener(delChatroomMemberUI) {
                final /* synthetic */ DelChatroomMemberUI eQm;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(gVar);
                }
            });
            ak.vy().a(gVar, 0);
        }
    }

    static /* synthetic */ String b(DelChatroomMemberUI delChatroomMemberUI, String str) {
        return delChatroomMemberUI.ePs == null ? null : delChatroomMemberUI.ePs.er(str);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        ak.vy().a(179, this);
        this.biB = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        String[] split = getIntent().getStringExtra("members").split(",");
        int length = split.length;
        while (i < length) {
            this.eQl.add(split[i]);
            i++;
        }
        this.ePs = ak.yW().wO().LC(this.biB);
        NI();
    }

    public void onDestroy() {
        ak.vy().b(179, this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    protected final void NI() {
        vD(2131234592);
        this.Eq = (ListView) findViewById(2131756029);
        this.eQk = new a(this);
        a aVar = this.eQk;
        List<String> list = this.eQl;
        if (list != null) {
            v.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[]{Integer.valueOf(list.size())});
            aVar.eQn.clear();
            for (String str : list) {
                ak.yW();
                u LX = c.wH().LX(str);
                if (!(LX == null || be.kS(LX.field_username) || !LX.field_username.equals(str))) {
                    aVar.eQn.add(LX);
                }
            }
        }
        this.Eq.setAdapter(this.eQk);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ DelChatroomMemberUI eQm;

            {
                this.eQm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eQm.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903276;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                g.bf(this, getString(2131234590));
                this.eQk.ai(((com.tencent.mm.plugin.chatroom.c.g) kVar).bir);
                this.Eq.post(new Runnable(this) {
                    final /* synthetic */ DelChatroomMemberUI eQm;

                    {
                        this.eQm = r1;
                    }

                    public final void run() {
                        if (this.eQm.eQk.getCount() == 0) {
                            this.eQm.finish();
                        }
                    }
                });
            }
        } else if (i2 == -2024) {
            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
            if (dm != null) {
                dm.a(this, null, null);
            } else {
                g.a(this.nDR.nEl, getString(2131234587), null, getString(2131234588), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ DelChatroomMemberUI eQm;

                    {
                        this.eQm = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else {
            g.a(this, getString(2131234596), null, getString(2131231107), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ DelChatroomMemberUI eQm;

                {
                    this.eQm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
