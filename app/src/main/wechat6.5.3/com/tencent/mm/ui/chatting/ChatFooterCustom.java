package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.dc;
import com.tencent.mm.e.a.kc;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.n;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.p;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom extends LinearLayout implements OnClickListener, com.tencent.mm.model.bo.b {
    u bhV;
    private String dRA;
    private LinearLayout fqo;
    private Object iPQ;
    c lMv;
    private p nFo;
    private ImageView olM;
    ImageView olN;
    v olO;
    com.tencent.mm.ui.chatting.ChattingUI.a.b olP;
    private int olQ;
    private ax olR;
    private a olS;
    private b olT;
    private List<String> olU;
    private final String olV;
    private final String olW;
    private com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a olX;

    private class a extends com.tencent.mm.sdk.c.c<kc> {
        final /* synthetic */ ChatFooterCustom olY;

        private a(ChatFooterCustom chatFooterCustom) {
            this.olY = chatFooterCustom;
            this.nhz = kc.class.getName().hashCode();
        }

        /* synthetic */ a(ChatFooterCustom chatFooterCustom, byte b) {
            this(chatFooterCustom);
            this.nhz = kc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kc kcVar = (kc) bVar;
            switch (kcVar.bkS.bkU) {
                case 0:
                    this.olY.g(MMBitmapFactory.ERROR_IO_FAILED, kcVar);
                    break;
                case 1:
                    this.olY.g(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, kcVar);
                    break;
            }
            return false;
        }
    }

    private class b extends com.tencent.mm.sdk.c.c<kd> {
        final /* synthetic */ ChatFooterCustom olY;

        private b(ChatFooterCustom chatFooterCustom) {
            this.olY = chatFooterCustom;
            this.nhz = kd.class.getName().hashCode();
        }

        /* synthetic */ b(ChatFooterCustom chatFooterCustom, byte b) {
            this(chatFooterCustom);
            this.nhz = kd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kd kdVar = (kd) bVar;
            switch (kdVar.bkW.bkU) {
                case 0:
                    this.olY.g(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED, kdVar);
                    break;
                case 1:
                    this.olY.g(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, kdVar);
                    break;
            }
            return false;
        }
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.fqo = null;
        this.olM = null;
        this.olN = null;
        this.olO = null;
        this.lMv = null;
        this.olP = null;
        this.olQ = 0;
        this.olU = new LinkedList();
        this.olV = "qrcode";
        this.olW = "barcode";
        this.iPQ = new Object();
    }

    public final void a(p pVar, com.tencent.mm.modelbiz.BizInfo.ExtInfo.b bVar, String str) {
        if (bVar == null || bVar.cCf == null || str == null) {
            throw new IllegalArgumentException(" menuInfo or username is null ! ");
        }
        this.olQ = Math.min(bVar.cCf.size(), 6);
        v.i("ChatCustomFooter", "setMenus, count:" + this.olQ);
        if (this.olQ <= 0) {
            throw new IllegalArgumentException(" mTabCount is invalid ! ");
        }
        if (this.olQ > 3) {
            this.olM.setVisibility(0);
        } else {
            this.olM.setVisibility(8);
        }
        this.fqo.setWeightSum((float) Math.min(this.olQ, 3));
        for (int i = 0; i < 6; i++) {
            FrameLayout frameLayout = (FrameLayout) this.fqo.getChildAt(i);
            TextView textView = (TextView) frameLayout.getChildAt(0).findViewById(2131756083);
            frameLayout.getChildAt(0).findViewById(2131756082).setVisibility(8);
            ImageView imageView = (ImageView) frameLayout.getChildAt(1);
            imageView.setVisibility(8);
            if (i < this.olQ) {
                com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar = (com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a) bVar.cCf.get(i);
                frameLayout.setTag(aVar);
                textView.setText(e.a(getContext(), aVar.name));
                if (aVar.type == 0) {
                    imageView.setVisibility(0);
                }
                frameLayout.setOnClickListener(this);
                frameLayout.setVisibility(0);
            } else if (i < 3 || this.olQ <= 3) {
                frameLayout.setVisibility(8);
            } else {
                frameLayout.setTag(null);
                textView.setText(SQLiteDatabase.KeyEmpty);
                imageView.setVisibility(8);
                frameLayout.setOnClickListener(null);
                frameLayout.setVisibility(0);
            }
        }
        this.nFo = pVar;
        this.dRA = str;
        if (this.olS != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.olS);
        }
        if (this.olT != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.olT);
        }
        this.olS = new a();
        this.olT = new b();
        com.tencent.mm.sdk.c.a.nhr.e(this.olS);
        com.tencent.mm.sdk.c.a.nhr.e(this.olT);
    }

    public final void aWV() {
        if (this.olS != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.olS);
        }
        if (this.olT != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.olT);
        }
    }

    private void bDY() {
        if (this.nFo != null && this.bhV != null && !t.kS(this.dRA)) {
            l.a(this.nFo, 9, this.dRA, this.bhV.field_username);
        }
    }

    private void bDZ() {
        File file = new File(com.tencent.mm.compatible.util.e.cgg);
        if (!file.exists() && !file.mkdir()) {
            Toast.makeText((Activity) getContext(), getContext().getString(2131231905), 1).show();
        } else if (this.nFo != null && !l.a(this.nFo, com.tencent.mm.compatible.util.e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText((Activity) getContext(), getContext().getString(2131234875), 1).show();
        }
    }

    public final void bEa() {
        if (this.olO != null) {
            this.olO.bEd();
        }
    }

    public synchronized void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a) {
            f.ux(8);
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar = (com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a) tag;
            aVar.content = SQLiteDatabase.KeyEmpty;
            switch (aVar.type) {
                case 0:
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    v.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth()));
                    v vVar = this.olO;
                    int width = iArr[0] + (view.getWidth() / 2);
                    int i = iArr[1];
                    if (!vVar.isShowing()) {
                        vVar.a(aVar, width, i, false);
                        break;
                    }
                    vVar.bEd();
                    if (!(aVar == null || (vVar.omf.id == aVar.id && vVar.omf.apU.equals(aVar.apU)))) {
                        vVar.a(aVar, width, i, false);
                        break;
                    }
                case 1:
                    v.i("ChatCustomFooter", "get latest message");
                    bEc();
                    this.olO.bEd();
                    aVar.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCg;
                    b(aVar);
                    d(aVar);
                    this.olP.bGj();
                    break;
                case 2:
                    v.i("ChatCustomFooter", "start webview url");
                    bEc();
                    this.olO.bEd();
                    aVar.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCg;
                    b(aVar);
                    d(aVar);
                    if (!(com.tencent.mm.pluginsdk.j.a.lxU.b(getContext(), aVar.value, new Object[0]) || r.a(aVar.cCj, getContext(), this.nFo, this.dRA))) {
                        Intent intent = new Intent();
                        intent.putExtra("KPublisherId", "custom_menu");
                        intent.putExtra("pre_username", this.dRA);
                        intent.putExtra("prePublishId", "custom_menu");
                        intent.putExtra("preUsername", this.dRA);
                        intent.putExtra("preChatName", this.dRA);
                        intent.putExtra("preChatTYPE", n.F(this.dRA, this.dRA));
                        intent.putExtra("rawUrl", aVar.value);
                        intent.putExtra("geta8key_username", this.dRA);
                        intent.putExtra("from_scence", 1);
                        com.tencent.mm.ay.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        break;
                    }
                case 3:
                    v.i("ChatCustomFooter", "switch to input");
                    this.olO.bEd();
                    bEb();
                    aVar.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCg;
                    b(aVar);
                    d(aVar);
                    break;
                case 4:
                    v.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                    bEc();
                    this.olO.bEd();
                    aVar.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCh;
                    String str = aVar.id + aVar.apU;
                    synchronized (this.iPQ) {
                        this.olU.add(str);
                    }
                    v.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", str, Integer.valueOf(this.olU.size()));
                    g.iuh.h(10809, this.dRA, Integer.valueOf(aVar.id), aVar.apU, com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCh, SQLiteDatabase.KeyEmpty);
                    this.olX = aVar;
                    Intent intent2;
                    com.tencent.mm.sdk.c.b dcVar;
                    switch (aVar.cCm) {
                        case 100:
                            intent2 = new Intent();
                            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                            intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                            intent2.putExtra("key_is_finish_on_scanned", true);
                            intent2.putExtra("key_is_hide_right_btn", true);
                            if (!(com.tencent.mm.as.u.bi(getContext()) || com.tencent.mm.ah.a.aT(getContext()))) {
                                com.tencent.mm.ay.c.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                break;
                            }
                        case MMGIFException.D_GIF_ERR_OPEN_FAILED /*101*/:
                            intent2 = new Intent();
                            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                            intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                            intent2.putExtra("key_is_finish_on_scanned", false);
                            intent2.putExtra("key_is_hide_right_btn", true);
                            if (!(com.tencent.mm.as.u.bi(getContext()) || com.tencent.mm.ah.a.aT(getContext()))) {
                                com.tencent.mm.ay.c.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                break;
                            }
                        case MMGIFException.D_GIF_ERR_READ_FAILED /*102*/:
                            bDZ();
                            break;
                        case MMGIFException.D_GIF_ERR_NOT_GIF_FILE /*103*/:
                            ak.yW();
                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                s.ey(getContext());
                                break;
                            } else {
                                com.tencent.mm.ui.base.g.a(getContext(), null, new String[]{getContext().getString(2131231772), getContext().getString(2131231771)}, null, new com.tencent.mm.ui.base.g.c(this) {
                                    final /* synthetic */ ChatFooterCustom olY;

                                    {
                                        this.olY = r1;
                                    }

                                    public final void gT(int i) {
                                        switch (i) {
                                            case 0:
                                                this.olY.bDZ();
                                                return;
                                            case 1:
                                                this.olY.bDY();
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                });
                                break;
                            }
                        case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                            bDY();
                            break;
                        case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
                            Intent intent3 = new Intent();
                            intent3.putExtra("map_view_type", 0);
                            String str2 = "map_sender_name";
                            v.i("ChatCustomFooter", "getSender " + (this.olR == null) + " " + (this.olR == null ? k.xF() : this.olR.name));
                            intent3.putExtra(str2, this.olR == null ? k.xF() : this.olR.name);
                            intent3.putExtra("map_talker_name", this.bhV == null ? null : this.bhV.field_username);
                            intent3.putExtra("view_type_key", 1);
                            intent3.putExtra("key_get_location_type", 1);
                            com.tencent.mm.ay.c.b(getContext(), "location", ".ui.RedirectUI", intent3);
                            break;
                        case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                            dcVar = new dc();
                            dcVar.bbb.op = 1;
                            dcVar.bbb.userName = this.bhV.field_username;
                            dcVar.bbb.context = getContext();
                            com.tencent.mm.sdk.c.a.nhr.z(dcVar);
                            break;
                        case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                            dcVar = new dc();
                            dcVar.bbb.op = 2;
                            dcVar.bbb.userName = this.bhV.field_username;
                            dcVar.bbb.context = getContext();
                            com.tencent.mm.sdk.c.a.nhr.z(dcVar);
                            break;
                        default:
                            break;
                    }
                default:
                    break;
            }
        }
    }

    private boolean a(com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar) {
        if (aVar == null) {
            return false;
        }
        String str = aVar.id + aVar.apU;
        synchronized (this.iPQ) {
            int i;
            for (int i2 = 0; i2 < this.olU.size(); i2++) {
                if (((String) this.olU.get(i2)).equals(str)) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i >= 0) {
                this.olU.remove(i);
                v.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", str, Integer.valueOf(this.olU.size()));
                return true;
            }
            v.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", str, Integer.valueOf(this.olU.size()));
            return false;
        }
    }

    private void b(com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar) {
        g.iuh.h(10809, this.dRA, Integer.valueOf(aVar.id), aVar.apU, com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCg, SQLiteDatabase.KeyEmpty);
    }

    private void c(com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar) {
        g.iuh.h(10809, this.dRA, Integer.valueOf(aVar.id), aVar.apU, com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCi, aVar.content);
    }

    public final boolean g(int i, Object obj) {
        if (obj != null) {
            switch (i) {
                case 201:
                case 203:
                    i = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                    break;
                case 217:
                    i = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
                    break;
            }
            String stringExtra;
            ArrayList arrayList;
            switch (i) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    v.i("ChatCustomFooter", "return from camera");
                    if (!(obj instanceof Intent)) {
                        v.e("ChatCustomFooter", "type error");
                        break;
                    }
                    stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        File file = new File(stringExtra);
                        if (!file.exists() || !file.isFile()) {
                            v.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                            break;
                        }
                        v.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                        v.i("ChatCustomFooter", "MD5 is %s", com.tencent.mm.a.g.g(file));
                        if (this.olX != null && (this.olX.cCm == MMGIFException.D_GIF_ERR_READ_FAILED || this.olX.cCm == MMGIFException.D_GIF_ERR_NOT_GIF_FILE)) {
                            arrayList = new ArrayList();
                            arrayList.add(stringExtra);
                            this.olX.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCi;
                            this.olX.f(arrayList);
                            if (a(this.olX)) {
                                d(this.olX);
                                c(this.olX);
                                break;
                            }
                        }
                        v.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    v.e("ChatCustomFooter", "return null path");
                    break;
                    break;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    v.i("ChatCustomFooter", "return from albumn");
                    if (!(obj instanceof Intent)) {
                        v.e("ChatCustomFooter", "type error");
                        break;
                    }
                    ArrayList stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                    arrayList = new ArrayList();
                    if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            stringExtra = (String) it.next();
                            v.i("ChatCustomFooter", "retrieving bitmap path %s", stringExtra);
                            if (stringExtra != null) {
                                File file2 = new File(stringExtra);
                                if (file2.exists() && file2.isFile()) {
                                    v.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                                    arrayList.add(com.tencent.mm.a.g.g(file2));
                                    v.i("ChatCustomFooter", "MD5 is %s", stringExtra);
                                } else {
                                    v.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                                }
                            } else {
                                v.e("ChatCustomFooter", "no file contained!");
                            }
                        }
                        if (this.olX != null && (this.olX.cCm == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR || this.olX.cCm == MMGIFException.D_GIF_ERR_NOT_GIF_FILE || this.olX.cCm == MMGIFException.D_GIF_ERR_READ_FAILED)) {
                            this.olX.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCi;
                            this.olX.f(arrayList);
                            if (a(this.olX)) {
                                d(this.olX);
                                c(this.olX);
                                break;
                            }
                        }
                        v.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    break;
                case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                    v.i("ChatCustomFooter", "send qrcode wait msg");
                    if (bl(obj)) {
                        this.olP.bGj();
                        break;
                    }
                    break;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    v.i("ChatCustomFooter", "send qrcode direct");
                    bl(obj);
                    break;
                case MMBitmapFactory.ERROR_IO_FAILED /*1005*/:
                    v.i("ChatCustomFooter", "send current");
                    bk(obj);
                    break;
                case MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT /*1006*/:
                    v.i("ChatCustomFooter", "send selected");
                    bk(obj);
                    break;
                default:
                    break;
            }
        }
        v.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
        return true;
    }

    private boolean bk(Object obj) {
        if (obj instanceof kc) {
            kc kcVar = (kc) obj;
            double d = kcVar.bkS.lat;
            double d2 = kcVar.bkS.lng;
            int i = kcVar.bkS.bhu;
            v.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), kcVar.bkS.label, kcVar.bkS.bkV);
            if (this.olX == null || this.olX.cCm != MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                v.e("ChatCustomFooter", "cache lost or location type is not correct");
            } else {
                this.olX.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCi;
                com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar = this.olX;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", String.valueOf(d));
                    jSONObject.put("y", String.valueOf(d2));
                    jSONObject.put("scale", i);
                    jSONObject.put("label", r5);
                    jSONObject.put("poiname", r6);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("location", jSONObject);
                    aVar.content = jSONObject2.toString();
                    v.v("MicroMsg.BizInfo", aVar.content);
                } catch (JSONException e) {
                    v.e("MicroMsg.BizInfo", e.toString());
                }
                if (a(this.olX)) {
                    d(this.olX);
                    c(this.olX);
                }
            }
        } else {
            v.e("ChatCustomFooter", "send current location data type error!");
        }
        return true;
    }

    private boolean bl(Object obj) {
        if (obj instanceof kd) {
            kd kdVar = (kd) obj;
            if (this.olX == null || !(this.olX.cCm == 100 || this.olX.cCm == MMGIFException.D_GIF_ERR_OPEN_FAILED)) {
                v.e("ChatCustomFooter", "null pointer in cache or type error");
                return false;
            }
            Object obj2;
            switch (kdVar.bkW.bkY) {
                case 0:
                    obj2 = "qrcode";
                    break;
                case 1:
                    obj2 = "barcode";
                    break;
                default:
                    obj2 = SQLiteDatabase.KeyEmpty;
                    break;
            }
            v.i("ChatCustomFooter", "scan type: %s , scan result:%s", obj2, kdVar.bkW.bkZ);
            this.olX.cCl = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.cCi;
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar = this.olX;
            v.v("MicroMsg.BizInfo", "type is %s , result is %s", obj2, r3);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scan_type", obj2);
                jSONObject.put("scan_result", r3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scan_code", jSONObject);
                aVar.content = jSONObject2.toString();
                v.v("MicroMsg.BizInfo", "content: %s", aVar.content);
            } catch (JSONException e) {
                v.e("MicroMsg.BizInfo", e.toString());
            }
            if (a(this.olX)) {
                d(this.olX);
                c(this.olX);
            }
            return true;
        }
        v.e("ChatCustomFooter", "send current location data type error!");
        return false;
    }

    private void d(com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar) {
        v.i("ChatCustomFooter", aVar.getInfo());
        ak.vy().a(new com.tencent.mm.modelbiz.n(this.dRA, 1, aVar.getInfo()), 0);
    }

    public final void h(ViewGroup viewGroup) {
        this.fqo = (LinearLayout) findViewById(2131756086);
        this.olN = (ImageView) findViewById(2131756085);
        this.olN.setVisibility(0);
        this.olN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChatFooterCustom olY;

            {
                this.olY = r1;
            }

            public final void onClick(View view) {
                this.olY.bEb();
            }
        });
        this.olM = (ImageView) findViewById(2131756087);
        this.olM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChatFooterCustom olY;

            {
                this.olY = r1;
            }

            public final void onClick(View view) {
                this.olY.olO.bEd();
                ImageView imageView = (ImageView) view;
                int i;
                int i2;
                if (imageView.getTag() == null) {
                    imageView.setTag(new Object());
                    imageView.setImageResource(2130838698);
                    for (i = 0; i < this.olY.olQ; i++) {
                        View childAt = this.olY.fqo.getChildAt(i);
                        if (i >= 3) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                        childAt.setVisibility(i2);
                    }
                    return;
                }
                imageView.setTag(null);
                imageView.setImageResource(2130838697);
                for (i = 0; i < this.olY.olQ; i++) {
                    childAt = this.olY.fqo.getChildAt(i);
                    if (i < 3) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    childAt.setVisibility(i2);
                }
            }
        });
        this.olO = new v(getContext(), viewGroup);
        this.olO.olZ = new OnItemClickListener(this) {
            final /* synthetic */ ChatFooterCustom olY;

            {
                this.olY = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.olY.onClick(view);
            }
        };
    }

    public final void a(com.tencent.mm.v.d.a aVar) {
        String a = m.a(aVar.czu.mbW);
        v.i("ChatCustomFooter", "SysCmdMsgExtension:" + a);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(a));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                    case 2:
                        a = newPullParser.getName();
                        if (!"sysmsg".equals(a)) {
                            if (!"username".equals(a)) {
                                if (!"data".equals(a)) {
                                    break;
                                }
                                newPullParser.nextText();
                                break;
                            }
                            newPullParser.nextText();
                            break;
                        } else if (!"type".equals(newPullParser.getAttributeName(0))) {
                            break;
                        } else {
                            newPullParser.getAttributeValue(0);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            v.a("ChatCustomFooter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    private void bEb() {
        v.i("ChatCustomFooter", "switch footer");
        if (this.lMv != null) {
            this.olO.bEd();
            this.lMv.im(true);
        }
    }

    private void bEc() {
        if (this.bhV != null && this.bhV.bCs == 1) {
            ak.yW();
            com.tencent.mm.model.c.wK().Mk(this.bhV.field_username);
        }
    }
}
