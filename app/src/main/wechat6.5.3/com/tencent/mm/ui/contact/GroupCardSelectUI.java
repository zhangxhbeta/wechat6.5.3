package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI extends MMActivity {
    private TextView euo;
    private List<u> hjK;
    private boolean oGB = true;
    private boolean oGC;
    private boolean oGD = false;
    private List<String> oGE = null;
    private int oGF;
    private ListView oGG;
    private a oGH;
    private HashMap<String, Long> oGI;

    class a extends BaseAdapter {
        final /* synthetic */ GroupCardSelectUI oGJ;

        public a(GroupCardSelectUI groupCardSelectUI) {
            this.oGJ = groupCardSelectUI;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            u uVar = (u) this.oGJ.hjK.get(i);
            if (view == null) {
                b bVar2 = new b(this.oGJ);
                view = View.inflate(this.oGJ, 2130903782, null);
                bVar2.gRt = (TextView) view.findViewById(2131757432);
                bVar2.oGK = (TextView) view.findViewById(2131757431);
                bVar2.cHH = (ImageView) view.findViewById(2131757430);
                bVar2.hRU = (CheckBox) view.findViewById(2131755510);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.cHH, uVar.field_username);
            bVar.oGK.setText(e.a(this.oGJ, l.er(uVar.field_username), com.tencent.mm.bd.a.N(this.oGJ.nDR.nEl, 2131493169)));
            bVar.gRt.setText("(" + i.el(uVar.field_username) + ")");
            if (this.oGJ.oGD) {
                bVar.hRU.setVisibility(0);
                if (this.oGJ.oGE.contains(uVar.field_username)) {
                    bVar.hRU.setChecked(true);
                } else {
                    bVar.hRU.setChecked(false);
                }
            }
            return view;
        }

        public final int getCount() {
            return this.oGJ.hjK.size();
        }

        public final Object getItem(int i) {
            return this.oGJ.hjK.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    class b {
        ImageView cHH;
        TextView gRt;
        CheckBox hRU;
        final /* synthetic */ GroupCardSelectUI oGJ;
        TextView oGK;

        b(GroupCardSelectUI groupCardSelectUI) {
            this.oGJ = groupCardSelectUI;
        }
    }

    static /* synthetic */ void a(GroupCardSelectUI groupCardSelectUI, u uVar) {
        int i = 1;
        if (groupCardSelectUI.oGD) {
            if (groupCardSelectUI.oGE.contains(uVar.field_username)) {
                groupCardSelectUI.oGE.remove(uVar.field_username);
            } else {
                if (!groupCardSelectUI.oGD || groupCardSelectUI.oGE.size() < groupCardSelectUI.oGF) {
                    i = 0;
                } else {
                    g.a(groupCardSelectUI.nDR.nEl, groupCardSelectUI.getString(2131234866, new Object[]{Integer.valueOf(groupCardSelectUI.oGF)}), groupCardSelectUI.getString(2131231139), new OnClickListener(groupCardSelectUI) {
                        final /* synthetic */ GroupCardSelectUI oGJ;

                        {
                            this.oGJ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                if (i == 0) {
                    groupCardSelectUI.oGE.add(uVar.field_username);
                }
            }
            groupCardSelectUI.oGH.notifyDataSetChanged();
        } else if (!groupCardSelectUI.oGB) {
            r0 = new Intent();
            r0.putExtra("Select_Contact", be.b(ak.yW().wO().LF(uVar.field_username), ","));
            r0.putExtra("Select_room_name", l.er(uVar.field_username));
            groupCardSelectUI.setResult(-1, r0);
            groupCardSelectUI.finish();
        } else if (groupCardSelectUI.oGC) {
            r0 = new Intent();
            r0.putExtra("Select_Conv_User", uVar.field_username);
            groupCardSelectUI.setResult(-1, r0);
            groupCardSelectUI.finish();
        } else {
            r0 = new Intent(groupCardSelectUI, ChattingUI.class);
            r0.addFlags(67108864);
            r0.putExtra("Chat_User", uVar.field_username);
            groupCardSelectUI.startActivity(r0);
            groupCardSelectUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd(getString(2131230874));
        this.oGB = getIntent().getBooleanExtra("group_select_type", true);
        this.oGC = getIntent().getBooleanExtra("group_select_need_result", false);
        this.oGD = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.oGD) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (be.kS(stringExtra)) {
                this.oGE = new LinkedList();
            } else {
                this.oGE = t.g(stringExtra.split(","));
            }
            this.oGF = getIntent().getIntExtra("max_limit_num", 0);
        }
        bHF();
        NI();
        if (this.oGD) {
            a(1, getString(2131231107), new OnMenuItemClickListener(this) {
                final /* synthetic */ GroupCardSelectUI oGJ;

                {
                    this.oGJ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_User", be.b(this.oGJ.oGE, ","));
                    this.oGJ.setResult(-1, intent);
                    this.oGJ.finish();
                    return true;
                }
            }, com.tencent.mm.ui.k.b.nET);
            U(1, true);
            NN();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void NI() {
        this.oGG = (ListView) findViewById(2131757428);
        this.oGH = new a(this);
        this.oGG.setAdapter(this.oGH);
        this.oGG.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ GroupCardSelectUI oGJ;

            {
                this.oGJ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                u uVar = (u) this.oGJ.oGH.getItem(i);
                if (uVar == null) {
                    v.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                    return;
                }
                GroupCardSelectUI.a(this.oGJ, uVar);
                this.oGJ.NN();
            }
        });
        this.euo = (TextView) findViewById(2131757429);
        if (this.oGH.getCount() <= 0) {
            this.euo.setVisibility(0);
        } else {
            this.euo.setVisibility(8);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GroupCardSelectUI oGJ;

            {
                this.oGJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oGJ.finish();
                return true;
            }
        });
    }

    private void bHF() {
        HashMap hashMap;
        int i;
        ak.yW();
        ac wK = c.wK();
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap2 = new HashMap();
        Cursor query = wK.cie.query("rconversation", new String[]{"username", "conversationTime"}, null, null, null, null, null);
        if (query.getCount() <= 0) {
            query.close();
            hashMap = hashMap2;
        } else {
            query.moveToFirst();
            while (true) {
                i = query == null ? 0 : (query.isClosed() || query.isBeforeFirst() || query.isAfterLast()) ? 0 : 1;
                if (i == 0) {
                    break;
                }
                hashMap2.put(query.getString(0), Long.valueOf(query.getLong(1)));
                query.moveToNext();
            }
            query.close();
            v.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - currentTimeMillis));
            hashMap = hashMap2;
        }
        this.oGI = hashMap;
        this.hjK = new LinkedList();
        List<u> yq = m.yq();
        if (yq.size() != 0) {
            int i2 = 0;
            for (u uVar : yq) {
                if (this.oGI.containsKey(uVar.field_username)) {
                    a(i2, uVar, ((Long) this.oGI.get(uVar.field_username)).longValue());
                    i = i2 + 1;
                } else if (com.tencent.mm.i.a.ei(uVar.field_type)) {
                    this.hjK.add(uVar);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            yq.clear();
        }
    }

    private void a(int i, u uVar, long j) {
        int i2 = 0;
        while (i2 < i && j <= ((Long) this.oGI.get(((u) this.hjK.get(i2)).field_username)).longValue()) {
            i2++;
        }
        this.hjK.add(i2, uVar);
    }

    protected final int getLayoutId() {
        return 2130903781;
    }

    private void NN() {
        if (this.oGD) {
            String format;
            StringBuilder append = new StringBuilder().append(getString(2131231107));
            if (this.oGE.size() > 0) {
                format = String.format("(%s)", new Object[]{Integer.valueOf(this.oGE.size())});
            } else {
                format = SQLiteDatabase.KeyEmpty;
            }
            aq(1, append.append(format).toString());
        }
    }
}
