package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI extends MMActivity {
    private String dFj;
    private ArrayList<e> fBH;
    private boolean fBI;
    private ListView fBJ;
    private a fBK;
    private final int fBL = 30;

    class a extends BaseAdapter {
        final /* synthetic */ ExdeviceLikeUI fBM;

        class a {
            ImageView dtz;
            TextView dxO;
            NoMeasuredTextView fBN;
            TextView fBO;
            final /* synthetic */ a fBP;

            a(a aVar) {
                this.fBP = aVar;
            }
        }

        a(ExdeviceLikeUI exdeviceLikeUI) {
            this.fBM = exdeviceLikeUI;
        }

        public final int getCount() {
            return this.fBM.fBH == null ? 0 : this.fBM.fBH.size();
        }

        public final Object getItem(int i) {
            return this.fBM.fBH.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            a aVar;
            e eVar = (e) this.fBM.fBH.get(i);
            if (view == null) {
                if (this.fBM.fBI) {
                    inflate = LayoutInflater.from(this.fBM).inflate(2130903553, viewGroup, false);
                } else {
                    inflate = LayoutInflater.from(this.fBM).inflate(2130903552, viewGroup, false);
                }
                a aVar2 = new a(this);
                aVar2.dtz = (ImageView) inflate.findViewById(2131756809);
                aVar2.fBN = (NoMeasuredTextView) inflate.findViewById(2131756811);
                aVar2.dxO = (TextView) inflate.findViewById(2131756812);
                aVar2.fBO = (TextView) inflate.findViewById(2131756810);
                aVar2.fBN.G(this.fBM.getResources().getDimension(2131493169));
                aVar2.fBN.setTextColor(this.fBM.getResources().getColor(2131689547));
                aVar2.fBN.bCo();
                aVar2.fBN.oaP = true;
                inflate.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                inflate = view;
            }
            b.p(aVar.dtz, eVar.field_username);
            aVar.fBN.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.fBM, l.er(eVar.field_username), aVar.fBN.gl.getTextSize()));
            if (!be.kS(eVar.field_liketips) && aVar.dxO != null) {
                aVar.dxO.setVisibility(0);
                aVar.dxO.setText(eVar.field_liketips);
            } else if (aVar.dxO != null) {
                aVar.dxO.setVisibility(8);
            }
            if (((int) ((((System.currentTimeMillis() / 1000) - ((long) eVar.field_timestamp)) / 60) + 1)) <= 30) {
                aVar.fBO.setText(this.fBM.getString(2131232549, new Object[]{Integer.valueOf(r3)}));
            } else {
                aVar.fBO.setText(o.c(this.fBM, ((long) eVar.field_timestamp) * 1000, true));
            }
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dFj = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.fBI = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (be.kS(stringExtra)) {
            stringExtra2 = getIntent().getStringExtra("rank_id");
            Assert.assertTrue(!be.kS(stringExtra2));
            this.fBH = ac.ajv().sn(stringExtra2);
        } else {
            ArrayList arrayList;
            String str = this.dFj;
            v.d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (be.kS(stringExtra)) {
                v.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(stringExtra, stringExtra2);
                if (B != null) {
                    Map map = B.cnZ;
                    ArrayList arrayList2 = new ArrayList();
                    if (!(map == null || map.isEmpty())) {
                        int i = 0;
                        while (true) {
                            stringExtra = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                            if (be.kS(stringExtra)) {
                                break;
                            }
                            stringExtra2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".rankid");
                            String str2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".liketip");
                            String str3 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".timestamp");
                            e eVar = new e();
                            eVar.field_appusername = str;
                            eVar.field_rankID = stringExtra2;
                            eVar.field_username = stringExtra;
                            eVar.field_timestamp = be.getInt(str3, 0);
                            eVar.field_liketips = str2;
                            arrayList2.add(eVar);
                            i++;
                        }
                        v.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[]{Integer.valueOf(i)});
                        arrayList = arrayList2;
                        this.fBH = arrayList;
                    }
                }
            }
            arrayList = null;
            this.fBH = arrayList;
        }
        this.fBJ = (ListView) findViewById(2131756813);
        this.fBJ.setEmptyView(findViewById(2131755597));
        this.fBK = new a(this);
        this.fBJ.setAdapter(this.fBK);
        if (!this.fBI) {
            this.fBJ.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ExdeviceLikeUI fBM;

                {
                    this.fBM = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    e eVar = (e) this.fBM.fBK.getItem(i);
                    Intent intent = new Intent(this.fBM, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", eVar.field_appusername);
                    intent.putExtra("rank_id", eVar.field_rankID);
                    intent.putExtra("device_type", 1);
                    this.fBM.startActivity(intent);
                    this.fBM.finish();
                }
            });
        }
        vD(2131232550);
        if (!this.fBI) {
            a(0, getString(2131232548), new OnMenuItemClickListener(this) {
                final /* synthetic */ ExdeviceLikeUI fBM;

                {
                    this.fBM = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.fBM, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", this.fBM.dFj);
                    intent.putExtra("rank_id", "#");
                    intent.putExtra("key_is_latest", true);
                    intent.putExtra("device_type", 1);
                    this.fBM.startActivity(intent);
                    this.fBM.finish();
                    return false;
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceLikeUI fBM;

            {
                this.fBM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fBM.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903554;
    }
}
