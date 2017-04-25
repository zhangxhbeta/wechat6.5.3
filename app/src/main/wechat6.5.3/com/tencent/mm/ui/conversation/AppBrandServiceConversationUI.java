package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.a.a;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
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
import com.tencent.mm.e.a.ji;
import com.tencent.mm.e.a.rf;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.conversation.a.g;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import java.math.BigInteger;
import java.util.HashMap;

@a
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private View dtW;

    @android.support.a.a
    public static class AppBrandServiceConversationFmUI extends b implements d {
        private String bdo = "";
        String dQM;
        private p dwg = null;
        String dzg;
        private TextView euo;
        private boolean eut = false;
        private l eyZ;
        private int fromScene;
        private ab oFp;
        private ListView oJH;
        private a oJI;
        private String oJJ;

        private static class a extends a {
            private HashMap<String, Boolean> oJL = new HashMap();
            private c<ji> ojR = new c<ji>(this) {
                final /* synthetic */ a oJM;

                {
                    this.oJM = r2;
                    this.nhz = ji.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                    boolean z = false;
                    ji jiVar = (ji) bVar;
                    if (jiVar.bjM.aWH != null) {
                        v.d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", new Object[]{jiVar.bjM.aWH, Integer.valueOf(jiVar.bjM.bjN)});
                        if ((jiVar.bjM.bjN & 2) > 0) {
                            z = true;
                        }
                        this.oJM.oJL.remove(jiVar.bjM.aWH);
                        this.oJM.oJL.put(jiVar.bjM.aWH, Boolean.valueOf(z));
                        this.oJM.notifyDataSetChanged();
                    } else {
                        v.e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                    }
                    return true;
                }
            };
            private String username;

            a(Context context, String str, com.tencent.mm.ui.j.a aVar) {
                super(context, aVar);
                this.username = str;
                com.tencent.mm.sdk.c.a.nhr.e(this.ojR);
            }

            public final void Ol() {
                ak.yW();
                setCursor(com.tencent.mm.model.c.wK().b(m.crF, this.ejp, this.username));
                if (this.nDK != null) {
                    this.nDK.Oi();
                }
                super.notifyDataSetChanged();
            }

            protected final void a(String str, g gVar) {
                boolean z;
                Boolean bool = (Boolean) this.oJL.get(str);
                if (bool == null) {
                    com.tencent.mm.e.a.m mVar = new com.tencent.mm.e.a.m();
                    mVar.aWJ.aWH = str;
                    com.tencent.mm.sdk.c.a.nhr.z(mVar);
                    z = mVar.aWK.aWL && (mVar.aWK.aWN & 2) > 0;
                    this.oJL.put(str, bool);
                } else {
                    z = bool.booleanValue();
                }
                if (z) {
                    gVar.oht.setVisibility(0);
                    gVar.oht.setImageResource(2131165372);
                    return;
                }
                gVar.oht.setVisibility(8);
            }

            public final void detach() {
                this.oJL = null;
                com.tencent.mm.sdk.c.a.nhr.f(this.ojR);
            }
        }

        static /* synthetic */ void a(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, int i) {
            if (i <= 0) {
                appBrandServiceConversationFmUI.euo.setVisibility(0);
                appBrandServiceConversationFmUI.oJH.setVisibility(8);
                return;
            }
            appBrandServiceConversationFmUI.euo.setVisibility(8);
            appBrandServiceConversationFmUI.oJH.setVisibility(0);
        }

        public final void onActivityCreated(Bundle bundle) {
            v.i("MicroMsg.AppBrandServiceConversationFmUI", "onActivityCreated");
            super.onActivityCreated(bundle);
            this.oJJ = getStringExtra("Contact_User");
            if (TextUtils.isEmpty(this.oJJ)) {
                this.oJJ = "appbrandcustomerservicemsg";
            }
            this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
            v.i("MicroMsg.AppBrandServiceConversationFmUI", "fromScene:%d", new Object[]{Integer.valueOf(this.fromScene)});
            ak.yW();
            this.dQM = System.currentTimeMillis() + new BigInteger(Integer.toBinaryString(com.tencent.mm.model.c.ww()), 2).toString();
            Fd(getString(2131230919));
            this.oJH = (ListView) findViewById(2131756759);
            this.euo = (TextView) findViewById(2131756760);
            this.euo.setText(2131230934);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.oJK.finish();
                    return true;
                }
            });
            this.oJI = new a(bzo(), this.oJJ, new com.tencent.mm.ui.j.a(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final void Oi() {
                    AppBrandServiceConversationFmUI.a(this.oJK, this.oJK.oJI.getCount());
                }

                public final void Oj() {
                }
            });
            this.oJI.a(new MMSlideDelView.c(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final int bN(View view) {
                    return this.oJK.oJH.getPositionForView(view);
                }
            });
            this.oJI.a(new f(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final void p(View view, int i) {
                    this.oJK.oJH.performItemClick(view, i, 0);
                }
            });
            this.oJH.setAdapter(this.oJI);
            this.eyZ = new l(bzo());
            this.oJH.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.oJK.oFp = (ab) this.oJK.oJI.getItem(i);
                    this.oJK.bdo = this.oJK.oFp.field_username;
                    ab d = this.oJK.oFp;
                    if (d == null) {
                        v.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.oJK.oJI.getCount())});
                        this.oJK.oJI.notifyDataSetChanged();
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("finish_direct", false);
                    bundle.putBoolean("key_need_send_video", false);
                    bundle.putString("key_scene_id", this.oJK.dQM);
                    this.oJK.oJX.a(d.field_username, bundle, true);
                    AppBrandServiceConversationFmUI appBrandServiceConversationFmUI = this.oJK;
                    String str = d.field_username;
                    int e = this.oJK.fromScene;
                    ak.yW();
                    ab Mh = com.tencent.mm.model.c.wK().Mh(str);
                    if (Mh == null) {
                        v.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[]{str});
                        return;
                    }
                    int i2 = Mh.field_unReadCount;
                    String ma = be.ma(appBrandServiceConversationFmUI.dQM);
                    v.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[]{Integer.valueOf(13799), appBrandServiceConversationFmUI.dzg, Integer.valueOf(e), Integer.valueOf(i2), ma});
                    com.tencent.mm.plugin.report.service.g.iuh.h(13799, new Object[]{appBrandServiceConversationFmUI.dzg, Integer.valueOf(e), Integer.valueOf(i2), ma, Long.valueOf(be.Nh())});
                }
            });
            this.oJH.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.oJK.oFp = (ab) this.oJK.oJI.getItem(i);
                    this.oJK.bdo = this.oJK.oFp.field_username;
                    this.oJK.eyZ.a(view, i, j, this.oJK, this.oJK);
                    return true;
                }
            });
            this.oJI.a(new MMSlideDelView.c(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final int bN(View view) {
                    return this.oJK.oJH.getPositionForView(view);
                }
            });
            this.oJI.a(new f(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final void p(View view, int i) {
                    this.oJK.oJH.performItemClick(view, i, 0);
                }
            });
            this.oJI.a(new e(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final void aE(Object obj) {
                    if (obj == null) {
                        v.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
                        return;
                    }
                    this.oJK.Pk(obj.toString());
                }
            });
            a(1, 2131165274, new OnMenuItemClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.oJK.nDR.nEl, ServiceNotifySettingsUI.class);
                    intent.putExtra("mode", 1);
                    intent.putExtra("scene_id", this.oJK.dQM);
                    this.oJK.startActivity(intent);
                    return true;
                }
            });
            ak.yW();
            com.tencent.mm.model.c.wK().a(this.oJI);
            com.tencent.mm.sdk.c.a.nhr.z(new rf());
            bIa();
        }

        protected final int getLayoutId() {
            return 2130904546;
        }

        public final String getUserName() {
            return this.oJJ;
        }

        public final void onDestroy() {
            if (ak.uz()) {
                ak.yW();
                com.tencent.mm.model.c.wK().b(this.oJI);
            }
            if (this.oJI != null) {
                this.oJI.onDestroy();
            }
            super.onDestroy();
        }

        public final void onResume() {
            v.i("MicroMsg.AppBrandServiceConversationFmUI", "on resume");
            if (this.oJI != null) {
                this.oJI.onResume();
            }
            super.onResume();
        }

        public final void onPause() {
            v.i("MicroMsg.AppBrandServiceConversationFmUI", "on pause");
            ak.yW();
            com.tencent.mm.model.c.wK().Mj(this.oJJ);
            if (this.oJI != null) {
                this.oJI.onPause();
            }
            super.onPause();
        }

        private void bIa() {
            String str = "";
            if (this.oJI == null) {
                v.d("MicroMsg.AppBrandServiceConversationFmUI", "adapter is null!");
                return;
            }
            int i;
            int i2;
            ak.yW();
            ab Mh = com.tencent.mm.model.c.wK().Mh("appbrandcustomerservicemsg");
            if (Mh == null || be.kS(Mh.field_username)) {
                i = 0;
            } else {
                i = Mh.field_unReadCount;
            }
            Mh = (ab) this.oJI.getItem(0);
            if (!(Mh == null || be.kS(Mh.field_username))) {
                str = be.ma(Mh.field_content);
                com.tencent.mm.e.a.m mVar = new com.tencent.mm.e.a.m();
                mVar.aWJ.aWH = Mh.field_username;
                com.tencent.mm.sdk.c.a.nhr.z(mVar);
                this.dzg = mVar.aWK.appId;
            }
            String str2 = str;
            if (i > 0) {
                int count = this.oJI.getCount();
                int i3 = 0;
                i2 = 0;
                while (i3 < count) {
                    int i4;
                    Mh = (ab) this.oJI.getItem(i3);
                    if (Mh.field_unReadMuteCount + Mh.field_unReadCount > 0) {
                        i4 = i2 + 1;
                    } else {
                        i4 = i2;
                    }
                    i3++;
                    i2 = i4;
                }
            } else {
                i2 = 0;
            }
            v.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", new Object[]{Integer.valueOf(13797), this.dQM, Integer.valueOf(i), Integer.valueOf(i2), this.dzg, str2});
            com.tencent.mm.plugin.report.service.g.iuh.h(13797, new Object[]{this.dQM, Integer.valueOf(i), Integer.valueOf(i2), this.dzg, Long.valueOf(be.Nh()), Integer.valueOf(0), str2});
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (!(this.bdo == null || this.bdo.isEmpty())) {
                this.bdo = "";
            }
            if (i2 == -1) {
            }
        }

        private void Pk(String str) {
            if (be.kS(str)) {
                v.e("MicroMsg.AppBrandServiceConversationFmUI", "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            v.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[]{str});
            ak.yW();
            at MH = com.tencent.mm.model.c.wJ().MH(str);
            ml mlVar = new ml();
            mlVar.moM = new arf().JF(be.ma(str));
            mlVar.mcb = MH.field_msgSvrId;
            ak.yW();
            com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.j.a(8, mlVar));
            this.eut = false;
            FragmentActivity bzo = bzo();
            getString(2131231164);
            final p a = com.tencent.mm.ui.base.g.a(bzo, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                {
                    this.oJK = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oJK.eut = true;
                }
            });
            v.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(5), this.dzg, this.dQM});
            com.tencent.mm.plugin.report.service.g.iuh.h(13798, new Object[]{Integer.valueOf(5), this.dzg, Integer.valueOf(0), this.dQM, Long.valueOf(be.Nh())});
            aw.a(str, new com.tencent.mm.model.aw.a(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI oJK;

                public final boolean zp() {
                    return this.oJK.eut;
                }

                public final void zo() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ak.yW();
            com.tencent.mm.model.c.wK().Mf(str);
        }

        public final void c(MenuItem menuItem, int i) {
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(this.bdo);
            if (LX == null || ((int) LX.chr) == 0) {
                v.e("MicroMsg.AppBrandServiceConversationFmUI", "changed biz stick status failed, contact is null, talker = " + this.bdo);
                return;
            }
            com.tencent.mm.ui.appbrand.b bVar;
            switch (menuItem.getItemId()) {
                case 1:
                    bVar = new com.tencent.mm.ui.appbrand.b(this.nDR.nEl, this.bdo, 3, this.fromScene, this.dQM, true);
                    return;
                case 2:
                    bVar = new com.tencent.mm.ui.appbrand.b(this.nDR.nEl, this.bdo, 4, this.fromScene, this.dQM, true);
                    return;
                case 3:
                    Pk(this.bdo);
                    return;
                default:
                    return;
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            com.tencent.mm.e.a.m mVar = new com.tencent.mm.e.a.m();
            mVar.aWJ.aWH = this.bdo;
            com.tencent.mm.sdk.c.a.nhr.z(mVar);
            int i = (!mVar.aWK.aWL || (mVar.aWK.aWN & 2) <= 0) ? 0 : 1;
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, 2131230961);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, 2131230962);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, 2131232281);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtW = q.em(this).inflate(2130903184, null);
        setContentView(this.dtW);
        this.oJN = new AppBrandServiceConversationFmUI();
        aS().aW().a(2131755641, this.oJN).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.dtW);
    }

    public final void finish() {
        super.finish();
    }

    protected final ChattingUI.a bHZ() {
        return new AppBrandServiceChattingUI.a();
    }
}
