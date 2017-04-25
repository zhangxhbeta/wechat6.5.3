package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.e.a.cd;
import com.tencent.mm.e.a.cn;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.df;
import com.tencent.mm.e.a.di;
import com.tencent.mm.e.a.dj;
import com.tencent.mm.e.a.dv;
import com.tencent.mm.e.a.gs;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI extends MMActivity {
    private long bZz;
    boolean bbp = false;
    String dCf = null;
    String filePath = null;
    private String ftu;
    private at kip;
    private HorizontalListView lOg;
    private boolean nQK;
    boolean ojW = false;
    private HorizontalListView orR;
    private b orS;
    private a orT;
    private int orU;
    private String orV = SQLiteDatabase.KeyEmpty;
    private RelativeLayout orW;
    private RelativeLayout orX;
    private TextView orY;
    private Boolean orZ = Boolean.valueOf(false);
    private b osa;
    private List<c> osb = new ArrayList();
    private List<f> osc = new ArrayList();
    private com.tencent.mm.q.a.a osd;
    private long ose = 0;
    private boolean osf = true;
    boolean osg = false;
    boolean osh = true;
    int osi = 2;
    int osj = -1;
    private HashMap<String, View> osk = new HashMap();
    HashMap<String, c> osl = new HashMap();
    Map<Integer, View> osm = new HashMap();
    Map<String, Integer> osn = new HashMap();
    WXMediaMessage oso = null;
    private com.tencent.mm.sdk.c.c osp = new com.tencent.mm.sdk.c.c<df>(this) {
        final /* synthetic */ ChattingSendDataToDeviceUI osr;

        {
            this.osr = r2;
            this.nhz = df.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return this.osr.bET().A((df) bVar);
        }
    };
    private com.tencent.mm.sdk.c.c osq = new com.tencent.mm.sdk.c.c<dj>(this) {
        final /* synthetic */ ChattingSendDataToDeviceUI osr;

        {
            this.osr = r2;
            this.nhz = dj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return this.osr.bET().A((dj) bVar);
        }
    };

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ ChattingSendDataToDeviceUI osr;
        final /* synthetic */ eh oss;
        final /* synthetic */ c ost;

        AnonymousClass7(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, eh ehVar, c cVar) {
            this.osr = chattingSendDataToDeviceUI;
            this.oss = ehVar;
            this.ost = cVar;
        }

        public final void run() {
            this.oss.ozp.setVisibility(0);
            this.oss.osx.setTextColor(this.osr.getResources().getColor(2131689992));
            this.oss.osx.setText(this.osr.getText(2131231899));
            this.ost.bbt = "send_data_sending";
        }
    }

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ String lma;
        final /* synthetic */ ChattingSendDataToDeviceUI osr;
        final /* synthetic */ eh oss;
        final /* synthetic */ c ost;
        final /* synthetic */ int osu;
        final /* synthetic */ int osv;

        AnonymousClass8(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, int i, eh ehVar, String str, c cVar, int i2) {
            this.osr = chattingSendDataToDeviceUI;
            this.osu = i;
            this.oss = ehVar;
            this.lma = str;
            this.ost = cVar;
            this.osv = i2;
        }

        public final void run() {
            int i = this.osu + 1;
            while (true) {
                if (i >= 100) {
                    try {
                        this.osr.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass8 osw;

                            {
                                this.osw = r1;
                            }

                            public final void run() {
                                this.osw.oss.ozp.setProgress(0);
                                this.osw.osr.osk.remove(this.osw.lma);
                                this.osw.oss.ozp.setVisibility(4);
                                this.osw.oss.osx.setText(this.osw.osr.getText(2131231897));
                                this.osw.oss.osx.setTextColor(this.osw.osr.getResources().getColor(2131689992));
                                this.osw.ost.bbt = "send_data_sucess";
                                this.osw.ost.progress = 0;
                                this.osw.osr.ks(4);
                            }
                        });
                        return;
                    } catch (Exception e) {
                        v.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", e);
                    }
                } else {
                    this.oss.ozp.setProgress(i);
                    i++;
                    Thread.sleep((long) this.osv);
                }
            }
        }
    }

    private class a extends BaseAdapter {
        private Context context;
        private com.tencent.mm.ae.a.a.c fzb;
        private List<Map<String, c>> ojV = new ArrayList();
        final /* synthetic */ ChattingSendDataToDeviceUI osr;
        private Map<String, c> osz;

        public final /* synthetic */ Object getItem(int i) {
            return xf(i);
        }

        public a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, Context context) {
            this.osr = chattingSendDataToDeviceUI;
            this.context = context;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPH = 2130838737;
            this.fzb = aVar.GU();
        }

        public final void an(List<c> list) {
            this.ojV.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.osz = new HashMap();
                this.osz.put("hard_device_info", list.get(i));
                this.ojV.add(this.osz);
            }
        }

        public final int getCount() {
            return this.ojV.size();
        }

        public final c xf(int i) {
            return (c) ((Map) this.ojV.get(i)).get("hard_device_info");
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            eh ehVar;
            View view2;
            c xf = xf(i);
            v.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", Integer.valueOf(i), Integer.valueOf(getCount()));
            if (this.osr.osm.get(Integer.valueOf(i)) == null) {
                ehVar = new eh();
                View inflate = View.inflate(viewGroup.getContext(), 2130904343, null);
                ehVar.fCf = inflate.findViewById(2131755326);
                ehVar.eVA = (TextView) inflate.findViewById(2131756776);
                ehVar.eZn = (ImageView) inflate.findViewById(2131756775);
                ehVar.osx = (TextView) inflate.findViewById(2131759058);
                ehVar.ozp = (SendDataToDeviceProgressBar) inflate.findViewById(2131759057);
                ehVar.ozp.setVisibility(4);
                this.osr.osm.put(Integer.valueOf(i), inflate);
                inflate.setTag(ehVar);
                view2 = inflate;
            } else {
                View view3 = (View) this.osr.osm.get(Integer.valueOf(i));
                ehVar = (eh) view3.getTag();
                view2 = view3;
            }
            this.osr.osn.put(xf.deviceID, Integer.valueOf(i));
            Object obj = xf.caJ;
            int i2 = 8;
            int i3 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            CharSequence stringBuffer2 = new StringBuffer();
            float ds = com.tencent.mm.bd.a.ds(this.context);
            if (ds == 1.125f || ds == 1.25f) {
                i2 = 6;
            } else if (ds == 1.375f) {
                i2 = 5;
            }
            for (int i4 = 0; i4 < obj.length(); i4++) {
                int codePointAt = Character.codePointAt(obj, i4);
                String substring = obj.substring(i4, i4 + 1);
                if (codePointAt < 0 || codePointAt > WebView.NORMAL_MODE_ALPHA) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 <= i2) {
                    stringBuffer = stringBuffer.append(substring);
                } else {
                    stringBuffer2 = stringBuffer2.append(substring);
                }
            }
            ehVar.eVA.setText(stringBuffer.toString());
            if (i3 >= i2) {
                ehVar.osx.setText(stringBuffer2);
            }
            c cVar = null;
            if (this.osr.osl.containsKey(xf(i).deviceID)) {
                cVar = (c) this.osr.osl.get(xf(i).deviceID);
            }
            if (!(cVar == null || cVar.bbt == null)) {
                v.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", Integer.valueOf(i), cVar.bbt);
                if (cVar.bbt.equals("send_data_sending")) {
                    ehVar.osx.setText(this.context.getString(2131231899));
                    ehVar.osx.setTextColor(this.context.getResources().getColor(2131689992));
                    ehVar.ozp.setProgress(xf.progress);
                    ehVar.ozp.setVisibility(0);
                    final c cVar2 = (c) this.osr.osl.get(xf.deviceID);
                    final int i5 = cVar2.progress;
                    if (i5 >= 100) {
                        i3 = 0;
                    } else {
                        i3 = 500 / (100 - i5);
                    }
                    e.c(new Runnable(this) {
                        final /* synthetic */ a osA;

                        public final void run() {
                            int i = i5 + 1;
                            while (this.osA.osr.osh) {
                                if (i >= 100) {
                                    try {
                                        if (cVar2.bbt.equals("send_data_sucess")) {
                                            this.osA.osr.runOnUiThread(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 osB;

                                                {
                                                    this.osB = r1;
                                                }

                                                public final void run() {
                                                    ehVar.ozp.setProgress(0);
                                                    ehVar.ozp.setVisibility(4);
                                                    ehVar.osx.setText(this.osB.osA.osr.getText(2131231897));
                                                    ehVar.osx.setTextColor(this.osB.osA.osr.getResources().getColor(2131689992));
                                                    cVar2.bbt = "send_data_sucess";
                                                    cVar2.progress = 0;
                                                    this.osB.osA.osr.osl.put(cVar2.deviceID, cVar2);
                                                    v.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", cVar2.deviceID);
                                                }
                                            });
                                            return;
                                        } else if (cVar2.bbt.equals("send_data_failed")) {
                                            this.osA.osr.runOnUiThread(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 osB;

                                                {
                                                    this.osB = r1;
                                                }

                                                public final void run() {
                                                    ehVar.ozp.setProgress(0);
                                                    ehVar.ozp.setVisibility(4);
                                                    ehVar.osx.setText(this.osB.osA.osr.getText(2131231895));
                                                    ehVar.osx.setTextColor(this.osB.osA.osr.getResources().getColor(2131689995));
                                                    cVar2.bbt = "send_data_failed";
                                                    cVar2.progress = 0;
                                                    this.osB.osA.osr.osl.put(cVar2.deviceID, cVar2);
                                                    v.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", cVar2.deviceID);
                                                }
                                            });
                                            return;
                                        }
                                    } catch (Exception e) {
                                        v.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", e);
                                    }
                                } else {
                                    ehVar.ozp.setProgress(i);
                                    cVar2.progress = i;
                                    i++;
                                    Thread.sleep((long) i3);
                                }
                            }
                        }
                    }, "SendDataState_handler").start();
                } else if (cVar.bbt.equals("send_data_sucess")) {
                    ehVar.osx.setText(this.context.getString(2131231897));
                    ehVar.osx.setTextColor(this.context.getResources().getColor(2131689992));
                    ehVar.ozp.setVisibility(4);
                } else if (cVar.bbt.equals("send_data_cancel")) {
                    ehVar.osx.setText(this.context.getString(2131231891));
                    ehVar.osx.setTextColor(this.context.getResources().getColor(2131689990));
                    ehVar.ozp.setVisibility(4);
                } else if (cVar.bbt.equals("send_data_failed")) {
                    ehVar.osx.setText(this.context.getString(2131231895));
                    ehVar.osx.setTextColor(this.context.getResources().getColor(2131689995));
                    ehVar.ozp.setVisibility(4);
                }
            }
            v.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", Integer.valueOf(i), xf.caJ);
            n.GL().a(xf.iconUrl, ehVar.eZn, this.fzb);
            ehVar.fCf.setTag(Integer.valueOf(i));
            return view2;
        }
    }

    public class b {
        final /* synthetic */ ChattingSendDataToDeviceUI osr;

        public b(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
            this.osr = chattingSendDataToDeviceUI;
        }

        public final boolean A(com.tencent.mm.sdk.c.b bVar) {
            if (bVar instanceof df) {
                List list = ((df) bVar).bbg.bas;
                List arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    c cVar = new c(this.osr);
                    cVar.aZN = (String) ((Map) list.get(i)).get("deviceType");
                    cVar.deviceID = (String) ((Map) list.get(i)).get("deviceID");
                    cVar.caJ = (String) ((Map) list.get(i)).get("displayName");
                    cVar.iconUrl = (String) ((Map) list.get(i)).get("iconUrl");
                    cVar.bbo = (String) ((Map) list.get(i)).get("ability");
                    cVar.osD = (String) ((Map) list.get(i)).get("abilityInf");
                    if ((this.osr.bbp && ChattingSendDataToDeviceUI.a(cVar, this.osr.ftu)) || (!this.osr.bbp && ChattingSendDataToDeviceUI.a(cVar, this.osr.bZz))) {
                        if (this.osr.osl.containsKey(cVar.deviceID) && ((c) this.osr.osl.get(cVar.deviceID)).bbt != null) {
                            cVar.bbt = ((c) this.osr.osl.get(cVar.deviceID)).bbt;
                            cVar.progress = ((c) this.osr.osl.get(cVar.deviceID)).progress;
                        }
                        arrayList.add(cVar);
                    }
                }
                if (this.osr.osb.size() != arrayList.size()) {
                    this.osr.osb = arrayList;
                    this.osr.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ b osC;

                        {
                            this.osC = r1;
                        }

                        public final void run() {
                            this.osC.osr.orT.an(this.osC.osr.osb);
                            if (this.osC.osr.orT.getCount() > 0) {
                                this.osC.osr.orY.setText(2131231761);
                                this.osC.osr.osf = false;
                            }
                            this.osC.osr.orT.notifyDataSetChanged();
                        }
                    });
                }
            } else if (bVar instanceof dj) {
                dj djVar = (dj) bVar;
                String str = djVar.bbr.bbt;
                String str2 = djVar.bbr.aRh;
                if (str.equals("send_data_sending")) {
                    ChattingSendDataToDeviceUI.a(this.osr, "send_data_sending", str2, djVar.bbr.progress);
                } else if (str.equals("send_data_failed")) {
                    ChattingSendDataToDeviceUI.a(this.osr, "send_data_failed", str2, 0);
                } else if (str.equals("send_data_sucess")) {
                    ChattingSendDataToDeviceUI chattingSendDataToDeviceUI = this.osr;
                    try {
                        eh ehVar = (eh) ((View) chattingSendDataToDeviceUI.osm.get(Integer.valueOf(((Integer) chattingSendDataToDeviceUI.osn.get(str2)).intValue()))).getTag();
                        v.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", Integer.valueOf(ehVar.ozp.getProgress()), str2);
                        c cVar2 = (c) chattingSendDataToDeviceUI.osl.get(str2);
                        chattingSendDataToDeviceUI.runOnUiThread(new AnonymousClass7(chattingSendDataToDeviceUI, ehVar, cVar2));
                        int abs = Math.abs(ehVar.ozp.getProgress());
                        cVar2.progress = abs;
                        v.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", Integer.valueOf(abs >= 100 ? 0 : 500 / (100 - abs)));
                        e.c(new AnonymousClass8(chattingSendDataToDeviceUI, abs, ehVar, str2, cVar2, r6), "progressSuccess_handler").start();
                        chattingSendDataToDeviceUI.osl.put(cVar2.deviceID, cVar2);
                    } catch (Exception e) {
                        v.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", e);
                    }
                }
            }
            return true;
        }
    }

    public class c {
        String aZN;
        String bbo;
        String bbt;
        String caJ;
        String deviceID;
        String iconUrl;
        String osD;
        final /* synthetic */ ChattingSendDataToDeviceUI osr;
        int progress;

        public c(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
            this.osr = chattingSendDataToDeviceUI;
        }
    }

    static /* synthetic */ void OQ(String str) {
        com.tencent.mm.sdk.c.b djVar = new dj();
        djVar.bbr.bbt = str;
        com.tencent.mm.sdk.c.a.nhr.z(djVar);
    }

    static /* synthetic */ void a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, final String str, final String str2, final int i) {
        v.d("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data State:%s progress: %d", str, Integer.valueOf(i));
        chattingSendDataToDeviceUI.runOnUiThread(new Runnable(chattingSendDataToDeviceUI) {
            final /* synthetic */ ChattingSendDataToDeviceUI osr;
            TextView osx;

            public final void run() {
                try {
                    c cVar = (c) this.osr.osl.get(str2);
                    cVar.bbt = str;
                    if (i > cVar.progress) {
                        cVar.progress = i;
                    }
                    View view = (View) this.osr.osm.get(Integer.valueOf(((Integer) this.osr.osn.get(str2)).intValue()));
                    eh ehVar = (eh) view.getTag();
                    if (ehVar == null) {
                        v.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
                        return;
                    }
                    this.osx = ehVar.osx;
                    this.osx.setVisibility(0);
                    if (str.equals("send_data_failed")) {
                        this.osr.ks(5);
                        this.osx.setText(this.osr.getString(2131231895));
                        this.osr.osk.remove(str2);
                        this.osx.setTextColor(this.osr.getResources().getColor(2131689995));
                        ChattingSendDataToDeviceUI.a(false, 0, view);
                    } else if (str.equals("send_data_sending")) {
                        this.osx.setText(this.osr.getString(2131231899));
                        this.osx.setTextColor(this.osr.getResources().getColor(2131689992));
                        ChattingSendDataToDeviceUI.a(true, i, view);
                    } else if (str.equals("send_data_cancel")) {
                        this.osr.ks(6);
                        this.osx.setText(this.osr.getString(2131231891));
                        this.osx.setTextColor(this.osr.getResources().getColor(2131689990));
                        ChattingSendDataToDeviceUI.a(true, 0, view);
                    }
                    this.osr.osl.put(cVar.deviceID, cVar);
                } catch (Exception e) {
                    v.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", e.getMessage());
                }
            }
        });
    }

    static /* synthetic */ void a(boolean z, int i, View view) {
        try {
            eh ehVar = (eh) view.getTag();
            if (ehVar != null) {
                if (z) {
                    ehVar.ozp.setVisibility(0);
                    if (i > ehVar.ozp.getProgress()) {
                        ehVar.ozp.setProgress(i);
                        return;
                    }
                    return;
                }
                ehVar.ozp.setVisibility(4);
                ehVar.ozp.setProgress(0);
            }
        } catch (Exception e) {
            v.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress exception %s", e);
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        int i = 6;
        super.onCreate(bundle);
        this.bbp = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
        v.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.bbp);
        if (!this.bbp) {
            this.bZz = getIntent().getExtras().getLong("Retr_Msg_Id");
            if (this.bZz != -1) {
                ak.yW();
                this.kip = com.tencent.mm.model.c.wJ().ek(this.bZz);
                if (!(this.kip == null || this.kip.field_msgId == 0)) {
                    this.orU = this.kip.field_type;
                    this.nQK = m.dE(this.kip.field_talker);
                    this.orV = this.kip.field_content;
                    if (this.nQK && this.kip.field_isSend == 0) {
                        str = this.kip.field_content;
                        int i2 = this.kip.field_isSend;
                        if (this.nQK && str != null && i2 == 0) {
                            str = aw.fM(str);
                        }
                        this.orV = str;
                    }
                    Long FZ;
                    d j;
                    if (this.kip.field_type == 49) {
                        this.osd = com.tencent.mm.q.a.a.dV(this.orV);
                        if (this.osd == null) {
                            v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
                        } else if (this.osd.type == 3) {
                            this.ose = 16;
                        } else if (this.osd.type == 4) {
                            this.ose = 8;
                        } else if (this.osd.type == 5) {
                            this.ose = 32;
                        } else if (this.osd.type == 6) {
                            FZ = com.tencent.mm.pluginsdk.b.a.FZ(this.osd.coc);
                            if (FZ == null) {
                                v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
                            } else {
                                this.ose = FZ.longValue();
                            }
                        } else if (this.osd.type == 2) {
                            this.ose = 2;
                            j = n.GH().j(this.kip);
                            if (j != null) {
                                this.orV = j.cLF;
                            }
                        } else {
                            v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
                        }
                    } else {
                        if (this.kip.field_type == 3) {
                            j = n.GH().j(this.kip);
                            if (j != null) {
                                this.orV = j.cLF;
                            }
                        } else if (this.kip.field_type == 43) {
                            com.tencent.mm.as.n kZ = k.KV().kZ(this.kip.field_imgPath);
                            if (kZ != null) {
                                this.orV = kZ.Lg();
                            }
                        }
                        FZ = com.tencent.mm.pluginsdk.b.a.FZ(this.orU);
                        if (FZ == null) {
                            v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
                        } else {
                            this.ose = FZ.longValue();
                        }
                    }
                    v.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", Long.valueOf(this.ose));
                }
            }
        }
        this.osi = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
        this.osg = false;
        setFinishOnTouchOutside(true);
        this.osb.clear();
        this.osl.clear();
        this.orW = (RelativeLayout) findViewById(2131756289);
        com.tencent.mm.sdk.c.b cpVar = new cp();
        if (this.bbp) {
            this.ftu = getIntent().getExtras().getString("sns_local_id");
            if (this.ftu != null) {
                cpVar.bay.bap = this.ftu;
                v.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", this.ftu);
            }
        } else {
            cpVar.bay.bao = this.bZz;
        }
        com.tencent.mm.sdk.c.a.nhr.z(cpVar);
        if (cpVar.baz.aZW) {
            this.orZ = Boolean.valueOf(true);
            com.tencent.mm.sdk.c.a.nhr.e(this.osp);
            com.tencent.mm.sdk.c.a.nhr.e(this.osq);
            this.orW.setVisibility(0);
            this.lOg = (HorizontalListView) findViewById(2131755705);
            this.orY = (TextView) findViewById(2131756290);
            this.orY.setText(2131231880);
            this.orT = new a(this, this);
            this.lOg.setAdapter(this.orT);
            this.lOg.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ChattingSendDataToDeviceUI osr;

                {
                    this.osr = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.osr.osg = true;
                    c xf = this.osr.orT.xf(i);
                    String str = xf.aZN;
                    String str2 = xf.deviceID;
                    String str3 = xf.bbo;
                    try {
                        if (this.osr.osk.get(str2) != null) {
                            v.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                            com.tencent.mm.sdk.c.b cdVar = new cd();
                            cdVar.aZK.aRh = str2;
                            com.tencent.mm.sdk.c.a.nhr.z(cdVar);
                            ChattingSendDataToDeviceUI.a(this.osr, "send_data_cancel", str2, 0);
                            xf.bbt = "send_data_cancel";
                            this.osr.osk.remove(str2);
                            eh ehVar = (eh) ((View) this.osr.osm.get(Integer.valueOf(i))).getTag();
                            ehVar.osx.setText(this.osr.getText(2131231891));
                            ehVar.osx.setTextColor(this.osr.getResources().getColor(2131689990));
                            ehVar.ozp.setVisibility(8);
                            ehVar.ozp.setProgress(0);
                            return;
                        }
                        xf.bbt = "send_data_sending";
                        this.osr.osl.put(xf.deviceID, xf);
                        this.osr.osk.put(str2, view);
                        ChattingSendDataToDeviceUI.a(this.osr, "send_data_sending", str2, 1);
                        this.osr.ks(3);
                        com.tencent.mm.sdk.c.b diVar = new di();
                        diVar.bbm.aRh = str2;
                        diVar.bbm.aZN = str;
                        diVar.bbm.data = this.osr.orV;
                        diVar.bbm.bbo = str3;
                        if (this.osr.bbp) {
                            diVar.bbm.bap = this.osr.ftu;
                            diVar.bbm.bbp = this.osr.bbp;
                        } else {
                            diVar.bbm.bao = this.osr.bZz;
                        }
                        com.tencent.mm.sdk.c.a.nhr.z(diVar);
                        if (!diVar.bbn.bbq) {
                            ChattingSendDataToDeviceUI.OQ("send_data_failed");
                            v.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
                        }
                    } catch (Exception e) {
                        ChattingSendDataToDeviceUI.OQ("send_data_failed");
                        v.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", e);
                    }
                }
            });
            bES();
            if (this.bbp) {
                int i3;
                str = this.ftu;
                if (str != null) {
                    com.tencent.mm.sdk.c.b gsVar = new gs();
                    gsVar.bgj.bap = str;
                    com.tencent.mm.sdk.c.a.nhr.z(gsVar);
                    i3 = gsVar.bgk.bgl.mWq.mol;
                    if (i3 == 1) {
                        i3 = 3;
                    } else if (i3 == 4) {
                        i3 = 1;
                    } else if (i3 == 15) {
                        i3 = 6;
                    } else if (i3 == 3) {
                        i3 = 5;
                    }
                    this.osj = i3;
                }
                i3 = 0;
                this.osj = i3;
            } else {
                long j2 = this.bZz;
                if (j2 == -1 || j2 == Long.MIN_VALUE) {
                    i = 0;
                } else {
                    ak.yW();
                    bx ek = com.tencent.mm.model.c.wJ().ek(j2);
                    if (ek.field_msgId != 0) {
                        i2 = ek.field_type;
                        String str2 = ek.field_content;
                        if (ek.bvY()) {
                            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str2);
                            if (dV == null) {
                                v.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                            } else if (dV.type == 3) {
                                i = 1;
                            } else if (dV.type != 4) {
                                if (dV.type == 6) {
                                    i = 4;
                                } else if (dV.type == 2) {
                                    i = 3;
                                } else if (dV.type == 5) {
                                    i = 5;
                                }
                            }
                        } else if (i2 == 3) {
                            i = 3;
                        } else if (i2 == 48) {
                            i = 2;
                        } else if (i2 == 62) {
                        }
                    }
                    i = 0;
                }
                this.osj = i;
            }
            ks(1);
        } else {
            this.orW.setVisibility(8);
        }
        this.orX = (RelativeLayout) findViewById(2131756295);
        this.orR = (HorizontalListView) findViewById(2131756297);
        this.orS = new b(this);
        this.orR.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ChattingSendDataToDeviceUI osr;

            {
                this.osr = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", Integer.valueOf(i));
                if (i == adapterView.getAdapter().getCount() - 1) {
                    Intent intent = new Intent(this.osr, Sort3rdAppUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("KFlag", this.osr.ose);
                    this.osr.startActivity(intent);
                } else if (this.osr.ojW && i == adapterView.getAdapter().getCount() - 2) {
                    if (this.osr.filePath == null || this.osr.dCf == null) {
                        g.bf(this.osr.getBaseContext(), this.osr.getString(2131232300));
                    } else {
                        com.tencent.mm.pluginsdk.ui.tools.a.c(this.osr, this.osr.filePath, this.osr.dCf.toLowerCase(), 1);
                    }
                } else if (i >= 0 && i < adapterView.getAdapter().getCount() - 1) {
                    f fVar = (f) this.osr.osc.get(i);
                    if (com.tencent.mm.pluginsdk.model.app.g.a(this.osr.getBaseContext(), fVar)) {
                        com.tencent.mm.pluginsdk.model.app.g.a(this.osr.getBaseContext(), fVar.field_packageName, this.osr.oso, fVar.field_openId);
                        return;
                    }
                    g.bf(this.osr.getBaseContext(), this.osr.getString(2131231890));
                    fVar.field_status = 4;
                    am.bnB().a(fVar, new String[0]);
                    this.osr.bER();
                }
            }
        });
        this.orR.setAdapter(this.orS);
    }

    private void ks(int i) {
        if (this.bbp) {
            com.tencent.mm.plugin.report.service.g.iuh.h(13197, Integer.valueOf(i), Integer.valueOf(this.osj), SQLiteDatabase.KeyEmpty, Integer.valueOf(2), Integer.valueOf(this.osi));
            return;
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.osj);
        long j = this.bZz;
        String str = SQLiteDatabase.KeyEmpty;
        ak.yW();
        bx ek = com.tencent.mm.model.c.wJ().ek(j);
        if (ek.field_msgId == 0) {
            str = SQLiteDatabase.KeyEmpty;
        } else {
            String str2 = ek.field_content;
            if (ek.field_type == 49) {
                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str2);
                if (dV != null && dV.type == 6) {
                    str = dV.coc;
                }
            }
        }
        objArr[2] = str;
        objArr[3] = Integer.valueOf(1);
        objArr[4] = Integer.valueOf(this.osi);
        gVar.h(13197, objArr);
    }

    protected final int getLayoutId() {
        return 2130903367;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.sdk.c.b cnVar = new cn();
        if (this.bbp) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            cnVar.bam.bap = this.ftu;
            cnVar.bam.baq = string;
            cnVar.bam.bar = i;
        } else {
            cnVar.bam.bao = this.bZz;
        }
        com.tencent.mm.sdk.c.a.nhr.z(cnVar);
        if (cnVar.ban.aZW && this.osb.size() > 0) {
            v.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", Integer.valueOf(this.osb.size()));
            this.orT.an(this.osb);
            if (this.orT.getCount() > 0) {
                this.orY.setText(2131231761);
                this.osf = false;
            }
            this.orT.notifyDataSetChanged();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bER() {
        /*
        r10 = this;
        r9 = 8;
        r8 = 2;
        r1 = 1;
        r2 = 0;
        r0 = r10.orS;
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r4 = r10.ose;
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x003b;
    L_0x0011:
        r3 = "MicroMsg.ChattingSendDataToDeviceUI";
        r4 = "mAppInfoAdapter is null %s, contentFlag %s";
        r5 = new java.lang.Object[r8];
        r0 = r10.orS;
        if (r0 != 0) goto L_0x0039;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        r6 = r10.ose;
        r0 = java.lang.Long.valueOf(r6);
        r5[r1] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
        r0 = r10.orX;
        if (r0 == 0) goto L_0x0038;
    L_0x0033:
        r0 = r10.orX;
        r0.setVisibility(r9);
    L_0x0038:
        return;
    L_0x0039:
        r0 = r2;
        goto L_0x001e;
    L_0x003b:
        r4 = r10.ose;
        r0 = com.tencent.mm.pluginsdk.model.app.g.b(r10, r4, r2);
        r10.osc = r0;
        r4 = r10.ose;
        r0 = com.tencent.mm.pluginsdk.model.app.g.l(r10, r4);
        if (r0 != 0) goto L_0x0054;
    L_0x004b:
        r0 = r10.orX;
        if (r0 == 0) goto L_0x0054;
    L_0x004f:
        r0 = r10.orX;
        r0.setVisibility(r9);
    L_0x0054:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r10.osc;
        if (r0 == 0) goto L_0x00a8;
    L_0x005d:
        r0 = r10.osc;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x00a8;
    L_0x0065:
        r0 = com.tencent.mm.pluginsdk.model.app.am.bnD();
        r4 = r10.ose;
        r0 = r0.dB(r4);
        if (r0 == 0) goto L_0x0081;
    L_0x0071:
        r4 = r0.size();
        if (r4 <= 0) goto L_0x0081;
    L_0x0077:
        r4 = r10.osc;
        r5 = new com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$4;
        r5.<init>(r10, r0);
        java.util.Collections.sort(r4, r5);
    L_0x0081:
        r0 = r10.osc;
        r4 = r0.iterator();
    L_0x0087:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00a8;
    L_0x008d:
        r0 = r4.next();
        r0 = (com.tencent.mm.pluginsdk.model.app.f) r0;
        r5 = new com.tencent.mm.ui.chatting.db;
        r5.<init>();
        r6 = r0.field_appId;
        r5.appId = r6;
        r6 = r0.field_appName;
        r5.caJ = r6;
        r0 = r0.field_appIconUrl;
        r5.iconUrl = r0;
        r3.add(r5);
        goto L_0x0087;
    L_0x00a8:
        r0 = r10.oso;
        if (r0 != 0) goto L_0x00d2;
    L_0x00ac:
        r0 = 0;
        r4 = r10.kip;
        r4 = r4.field_type;
        switch(r4) {
            case 1: goto L_0x01e0;
            case 3: goto L_0x01eb;
            case 43: goto L_0x0272;
            case 48: goto L_0x0258;
            case 49: goto L_0x00e4;
            default: goto L_0x00b4;
        };
    L_0x00b4:
        r2 = new com.tencent.mm.sdk.modelmsg.WXMediaMessage;
        r2.<init>(r0);
        r10.oso = r2;
        r2 = r10.oso;
        r4 = 587333634; // 0x23020002 float:7.047316E-18 double:2.90181371E-315;
        r2.sdkVer = r4;
        r2 = r10.dCf;
        if (r2 == 0) goto L_0x00d2;
    L_0x00c6:
        r2 = r10.filePath;
        if (r2 == 0) goto L_0x00d2;
    L_0x00ca:
        if (r0 == 0) goto L_0x00d2;
    L_0x00cc:
        r0 = r0 instanceof com.tencent.mm.sdk.modelmsg.WXFileObject;
        if (r0 == 0) goto L_0x00d2;
    L_0x00d0:
        r10.ojW = r1;
    L_0x00d2:
        r0 = r10.orS;
        r1 = r10.ojW;
        r0.ojW = r1;
        r0 = r10.orS;
        r0.an(r3);
        r0 = r10.orS;
        r0.notifyDataSetChanged();
        goto L_0x0038;
    L_0x00e4:
        r4 = r10.osd;
        if (r4 == 0) goto L_0x00b4;
    L_0x00e8:
        r4 = r10.osd;
        r4 = r4.type;
        r5 = 3;
        if (r4 != r5) goto L_0x010d;
    L_0x00ef:
        r0 = new com.tencent.mm.sdk.modelmsg.WXMusicObject;
        r0.<init>();
        r2 = r10.osd;
        r2 = r2.url;
        r0.musicUrl = r2;
        r2 = r10.osd;
        r2 = r2.cos;
        r0.musicDataUrl = r2;
        r2 = r10.osd;
        r2 = r2.coa;
        r0.musicLowBandUrl = r2;
        r2 = r10.osd;
        r2 = r2.cot;
        r0.musicLowBandDataUrl = r2;
        goto L_0x00b4;
    L_0x010d:
        r4 = r10.osd;
        r4 = r4.type;
        r5 = 4;
        if (r4 != r5) goto L_0x0126;
    L_0x0114:
        r0 = new com.tencent.mm.sdk.modelmsg.WXVideoObject;
        r0.<init>();
        r2 = r10.osd;
        r2 = r2.url;
        r0.videoUrl = r2;
        r2 = r10.osd;
        r2 = r2.cot;
        r0.videoLowBandUrl = r2;
        goto L_0x00b4;
    L_0x0126:
        r4 = r10.osd;
        r4 = r4.type;
        r5 = 5;
        if (r4 != r5) goto L_0x0138;
    L_0x012d:
        r0 = new com.tencent.mm.sdk.modelmsg.WXWebpageObject;
        r2 = r10.osd;
        r2 = r2.url;
        r0.<init>(r2);
        goto L_0x00b4;
    L_0x0138:
        r4 = r10.osd;
        r4 = r4.type;
        r5 = 6;
        if (r4 != r5) goto L_0x018e;
    L_0x013f:
        r4 = com.tencent.mm.pluginsdk.model.app.am.Wf();
        r5 = r10.osd;
        r5 = r5.aXa;
        r4 = r4.Gu(r5);
        if (r4 == 0) goto L_0x0184;
    L_0x014d:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage fileFullPath %s";
        r6 = new java.lang.Object[r1];
        r7 = r4.field_fileFullPath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r0, r5, r6);
        r0 = new com.tencent.mm.sdk.modelmsg.WXFileObject;
        r2 = r4.field_fileFullPath;
        r0.<init>(r2);
        r2 = r4.field_fileFullPath;
        r10.filePath = r2;
        r2 = r10.osd;
        r2 = r2.coc;
        r10.dCf = r2;
    L_0x016d:
        r2 = r10.filePath;
        r2 = com.tencent.mm.pluginsdk.model.app.p.GH(r2);
        if (r2 == 0) goto L_0x00b4;
    L_0x0175:
        r0 = 2131231889; // 0x7f080491 float:1.8079872E38 double:1.0529684597E-314;
        r0 = r10.getString(r0);
        com.tencent.mm.ui.base.g.bf(r10, r0);
        r10.finish();
        goto L_0x00d2;
    L_0x0184:
        r2 = "MicroMsg.ChattingSendDataToDeviceUI";
        r4 = "getWXMediaMessage attInfo is null";
        com.tencent.mm.sdk.platformtools.v.e(r2, r4);
        goto L_0x016d;
    L_0x018e:
        r4 = r10.osd;
        r4 = r4.type;
        if (r4 != r8) goto L_0x00b4;
    L_0x0194:
        r0 = new com.tencent.mm.sdk.modelmsg.WXImageObject;
        r0.<init>();
        r4 = com.tencent.mm.ae.n.GH();
        r5 = r10.kip;
        r4 = r4.j(r5);
        if (r4 == 0) goto L_0x01c5;
    L_0x01a5:
        r5 = com.tencent.mm.ae.n.GH();
        r6 = r4.cLv;
        r5 = r5.iW(r6);
        r0.imagePath = r5;
        r5 = r0.imagePath;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 == 0) goto L_0x01c5;
    L_0x01b9:
        r5 = com.tencent.mm.ae.n.GH();
        r4 = r4.cLx;
        r4 = r5.iW(r4);
        r0.imagePath = r4;
    L_0x01c5:
        r4 = r0.imagePath;
        r10.filePath = r4;
        r4 = r10.osd;
        r4 = r4.coc;
        r10.dCf = r4;
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage imagePath %s";
        r6 = new java.lang.Object[r1];
        r7 = r0.imagePath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        goto L_0x00b4;
    L_0x01e0:
        r0 = new com.tencent.mm.sdk.modelmsg.WXTextObject;
        r2 = r10.kip;
        r2 = r2.field_content;
        r0.<init>(r2);
        goto L_0x00b4;
    L_0x01eb:
        r0 = new com.tencent.mm.sdk.modelmsg.WXImageObject;
        r0.<init>();
        r4 = com.tencent.mm.ae.n.GH();
        r5 = r10.kip;
        r4 = r4.j(r5);
        if (r4 == 0) goto L_0x0247;
    L_0x01fc:
        r5 = com.tencent.mm.ae.n.GH();
        r6 = r4.cLv;
        r5 = r5.iW(r6);
        r0.imagePath = r5;
        r5 = r0.imagePath;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 == 0) goto L_0x021c;
    L_0x0210:
        r5 = com.tencent.mm.ae.n.GH();
        r4 = r4.cLx;
        r4 = r5.iW(r4);
        r0.imagePath = r4;
    L_0x021c:
        r4 = r0.imagePath;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r4 != 0) goto L_0x0247;
    L_0x0224:
        r4 = r0.imagePath;
        r10.filePath = r4;
        r4 = r0.imagePath;
        r5 = ".";
        r4 = r4.lastIndexOf(r5);
        if (r4 < 0) goto L_0x0247;
    L_0x0233:
        r5 = r0.imagePath;
        r5 = r5.length();
        r5 = r5 + -1;
        if (r4 >= r5) goto L_0x0247;
    L_0x023d:
        r5 = r0.imagePath;
        r4 = r4 + 1;
        r4 = r5.substring(r4);
        r10.dCf = r4;
    L_0x0247:
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage imagePath %s";
        r6 = new java.lang.Object[r1];
        r7 = r0.imagePath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        goto L_0x00b4;
    L_0x0258:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r2 = r10.kip;
        r2 = r2.field_content;
        r2 = r0.MV(r2);
        r0 = new com.tencent.mm.sdk.modelmsg.WXLocationObject;
        r4 = r2.gRK;
        r6 = r2.gRL;
        r0.<init>(r4, r6);
        goto L_0x00b4;
    L_0x0272:
        r0 = new com.tencent.mm.sdk.modelmsg.WXVideoObject;
        r0.<init>();
        com.tencent.mm.as.k.KV();
        r2 = r10.kip;
        r2 = r2.field_imgPath;
        r2 = com.tencent.mm.as.o.lc(r2);
        if (r2 == 0) goto L_0x00b4;
    L_0x0284:
        r0.videoUrl = r2;
        r10.filePath = r2;
        r4 = ".";
        r4 = r2.lastIndexOf(r4);
        if (r4 < 0) goto L_0x00b4;
    L_0x0291:
        r5 = r2.length();
        r5 = r5 + -1;
        if (r4 >= r5) goto L_0x00b4;
    L_0x0299:
        r4 = r4 + 1;
        r2 = r2.substring(r4);
        r10.dCf = r2;
        goto L_0x00b4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.bER():void");
    }

    private void bES() {
        com.tencent.mm.sdk.c.b cnVar = new cn();
        if (this.bbp) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            cnVar.bam.bap = this.ftu;
            cnVar.bam.baq = string;
            cnVar.bam.bar = i;
        } else {
            cnVar.bam.bao = this.bZz;
        }
        com.tencent.mm.sdk.c.a.nhr.z(cnVar);
        if (cnVar.ban.aZW) {
            List list = cnVar.ban.bas;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = new c(this);
                cVar.aZN = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.caJ = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.bbo = (String) ((Map) list.get(i2)).get("ability");
                cVar.osD = (String) ((Map) list.get(i2)).get("abilityInf");
                if (this.bbp && a(cVar, this.ftu)) {
                    this.osb.add(cVar);
                } else if (!this.bbp && a(cVar, this.bZz)) {
                    this.osb.add(cVar);
                }
            }
            if (this.osb.size() > 0) {
                v.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
                this.orT.an(this.osb);
                if (this.orT.getCount() > 0) {
                    this.orY.setText(2131231761);
                    this.osf = false;
                }
                this.orT.notifyDataSetChanged();
            }
        }
    }

    private static boolean a(String str, c cVar) {
        String str2 = cVar.bbo;
        String str3 = cVar.osD;
        String host = Uri.parse(str).getHost();
        if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONObject(str3).getJSONArray("wxmsg_url");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (jSONArray.getString(i).equals(host)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.ChattingSendDataToDeviceUI", e, str3, new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c r8, java.lang.String r9) {
        /*
        r1 = 0;
        r0 = 1;
        if (r9 != 0) goto L_0x0005;
    L_0x0004:
        return r1;
    L_0x0005:
        r2 = new com.tencent.mm.e.a.gs;
        r2.<init>();
        r3 = r2.bgj;
        r3.bap = r9;
        r3 = com.tencent.mm.sdk.c.a.nhr;
        r3.z(r2);
        r2 = r2.bgk;
        r2 = r2.bgl;
        r3 = r2.mWq;
        r3 = r3.mol;
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "isNeedToShowSnsInfo contentStyle %d";
        r6 = new java.lang.Object[r0];
        r7 = java.lang.Integer.valueOf(r3);
        r6[r1] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        r4 = r8.bbo;
        if (r4 != 0) goto L_0x003a;
    L_0x0030:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r2 = "ability is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        goto L_0x0004;
    L_0x003a:
        if (r3 != r0) goto L_0x0047;
    L_0x003c:
        r2 = "wxmsg_image";
        r2 = r4.contains(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0045:
        r1 = r0;
        goto L_0x0004;
    L_0x0047:
        r5 = 4;
        if (r3 != r5) goto L_0x0055;
    L_0x004a:
        r2 = "wxmsg_music";
        r2 = r4.contains(r2);
        if (r2 != 0) goto L_0x0045;
    L_0x0053:
        r0 = r1;
        goto L_0x0045;
    L_0x0055:
        r5 = 15;
        if (r3 != r5) goto L_0x0063;
    L_0x0059:
        r2 = "wxmsg_video";
        r2 = r4.contains(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0062:
        goto L_0x0045;
    L_0x0063:
        r0 = 3;
        if (r3 != r0) goto L_0x0053;
    L_0x0066:
        r0 = r2.mWq;
        r0 = r0.glb;
        r0 = a(r0, r8);
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c, java.lang.String):boolean");
    }

    public void onBackPressed() {
        if (this.osk.size() > 0) {
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
            aVar.wn(2131231892);
            aVar.wp(2131231894).a(new OnClickListener(this) {
                final /* synthetic */ ChattingSendDataToDeviceUI osr;

                {
                    this.osr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    for (String str : this.osr.osk.keySet()) {
                        com.tencent.mm.sdk.c.b cdVar = new cd();
                        cdVar.aZK.aRh = str;
                        com.tencent.mm.sdk.c.a.nhr.z(cdVar);
                    }
                    this.osr.finish();
                }
            });
            aVar.wq(2131231893).b(new OnClickListener(this) {
                final /* synthetic */ ChattingSendDataToDeviceUI osr;

                {
                    this.osr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            aVar.RX().show();
            return;
        }
        super.onBackPressed();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c r9, long r10) {
        /*
        r8 = 3;
        r1 = 0;
        r0 = 1;
        r2 = -1;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r2 = r9.bbo;
        com.tencent.mm.model.ak.yW();
        r3 = com.tencent.mm.model.c.wJ();
        r3 = r3.ek(r10);
        r4 = r3.field_msgId;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x0009;
    L_0x001f:
        if (r2 == 0) goto L_0x0009;
    L_0x0021:
        r4 = r3.field_type;
        r5 = r3.field_content;
        r3 = r3.bvY();
        if (r3 == 0) goto L_0x007c;
    L_0x002b:
        r3 = com.tencent.mm.q.a.a.dV(r5);
        if (r3 != 0) goto L_0x003b;
    L_0x0031:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r2 = "get content is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        goto L_0x0009;
    L_0x003b:
        r4 = r3.type;
        if (r4 != r8) goto L_0x004a;
    L_0x003f:
        r3 = "wxmsg_music";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x0048:
        r1 = r0;
        goto L_0x0009;
    L_0x004a:
        r4 = r3.type;
        r5 = 4;
        if (r4 != r5) goto L_0x0051;
    L_0x004f:
        r0 = r1;
        goto L_0x0048;
    L_0x0051:
        r4 = r3.type;
        r5 = 6;
        if (r4 != r5) goto L_0x0061;
    L_0x0056:
        r3 = "wxmsg_file";
        r2 = r2.contains(r3);
        if (r2 != 0) goto L_0x0048;
    L_0x005f:
        r0 = r1;
        goto L_0x0048;
    L_0x0061:
        r4 = r3.type;
        r5 = 5;
        if (r4 != r5) goto L_0x006d;
    L_0x0066:
        r0 = r3.url;
        r0 = a(r0, r9);
        goto L_0x0048;
    L_0x006d:
        r3 = r3.type;
        r4 = 2;
        if (r3 != r4) goto L_0x005f;
    L_0x0072:
        r3 = "wxmsg_image";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x007b:
        goto L_0x0048;
    L_0x007c:
        if (r4 != r8) goto L_0x0088;
    L_0x007e:
        r3 = "wxmsg_image";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x0087:
        goto L_0x0048;
    L_0x0088:
        r3 = 48;
        if (r4 != r3) goto L_0x0096;
    L_0x008c:
        r3 = "wxmsg_poi";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x0095:
        goto L_0x0048;
    L_0x0096:
        r3 = 62;
        if (r4 != r3) goto L_0x005f;
    L_0x009a:
        r3 = "wxmsg_video";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x00a3:
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c, long):boolean");
    }

    protected void onResume() {
        super.onResume();
        bER();
        if (this.orZ.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) this.lOg.getLayoutParams();
            int i = layoutParams.height;
            float ds = com.tencent.mm.bd.a.ds(this);
            if (ds == 1.125f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(2131493144);
            } else if (ds == 1.375f || ds == 1.25f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(2131493168);
            }
            this.lOg.setLayoutParams(layoutParams);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, 1);
    }

    protected void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
        this.osh = false;
        if (this.orZ.booleanValue()) {
            if (!this.osg) {
                ks(2);
            }
            com.tencent.mm.sdk.c.a.nhr.f(this.osp);
            com.tencent.mm.sdk.c.a.nhr.f(this.osq);
            com.tencent.mm.sdk.c.b dvVar = new dv();
            com.tencent.mm.sdk.c.a.nhr.z(dvVar);
            if (dvVar.bbO.bbq) {
                v.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
            }
        }
        com.tencent.mm.sdk.platformtools.a.cu(getWindow().getDecorView());
        com.tencent.mm.sdk.platformtools.a.dC(this);
    }

    public final b bET() {
        if (this.osa == null) {
            this.osa = new b(this);
        }
        return this.osa;
    }
}
