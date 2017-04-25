package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.a.e;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.n.d;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.modelmsg.WXFileObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.snackbar.b.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141010", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class AddFavoriteUI extends MMActivity {
    private ProgressDialog dwR = null;
    String filePath = null;
    private ac handler = new ac(this) {
        final /* synthetic */ AddFavoriteUI oQL;

        {
            this.oQL = r1;
        }

        public final void handleMessage(Message message) {
            AddFavoriteUI.d(this.oQL);
            if (be.kS(this.oQL.filePath) || (be.KX(this.oQL.filePath) && !AddFavoriteUI.Px(this.oQL.filePath))) {
                v.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
                this.oQL.bIY();
                this.oQL.finish();
                return;
            }
            AddFavoriteUI.h(this.oQL);
        }
    };
    private Intent intent = null;
    ArrayList<String> oQI = null;
    private ac oQJ = new ac(this) {
        final /* synthetic */ AddFavoriteUI oQL;

        {
            this.oQL = r1;
        }

        public final void handleMessage(Message message) {
            AddFavoriteUI.d(this.oQL);
            v.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[]{Boolean.valueOf(AddFavoriteUI.e(this.oQL))});
        }
    };
    private ac oQK = new ac(this) {
        final /* synthetic */ AddFavoriteUI oQL;

        {
            this.oQL = r1;
        }

        public final void handleMessage(Message message) {
            AddFavoriteUI.d(this.oQL);
            AddFavoriteUI.f(this.oQL);
        }
    };
    Uri uri = null;

    private class a implements Runnable {
        private Uri mUri;
        final /* synthetic */ AddFavoriteUI oQL;
        private b oQM;

        public a(AddFavoriteUI addFavoriteUI, Uri uri, b bVar) {
            this.oQL = addFavoriteUI;
            this.mUri = uri;
            this.oQM = bVar;
        }

        public final void run() {
            this.oQL.filePath = AddFavoriteUI.a(this.oQL, this.mUri);
            if (be.kS(this.oQL.filePath)) {
                this.oQL.filePath = d.a(this.oQL.getContentResolver(), this.mUri, 3);
            }
            if (this.oQM != null) {
                this.oQM.bIZ();
            }
        }
    }

    public interface b {
        void bIZ();
    }

    static /* synthetic */ String a(AddFavoriteUI addFavoriteUI, Uri uri) {
        String scheme = uri.getScheme();
        if (be.kS(scheme)) {
            v.e("MicroMsg.AddFavoriteUI", "input uri error. %s", new Object[]{uri});
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            v.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else if (scheme.equalsIgnoreCase("content")) {
            v.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
            Cursor query = addFavoriteUI.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                v.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor is null");
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                v.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                return null;
            } else {
                String toLowerCase = uri.toString().toLowerCase();
                if (toLowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || toLowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || toLowerCase.startsWith("content://com.mediatek.calendarimporter") || ((addFavoriteUI.intent != null && addFavoriteUI.intent.getType().equals("text/x-vcalendar")) || p.ceJ.cdG == 1)) {
                    return addFavoriteUI.a(uri, query);
                }
                query.close();
                return be.d(addFavoriteUI, uri);
            }
        } else {
            v.e("MicroMsg.AddFavoriteUI", "unknown scheme");
            return null;
        }
    }

    static /* synthetic */ void d(AddFavoriteUI addFavoriteUI) {
        if (addFavoriteUI.dwR != null && addFavoriteUI.dwR.isShowing()) {
            addFavoriteUI.dwR.dismiss();
        }
    }

    static /* synthetic */ boolean e(AddFavoriteUI addFavoriteUI) {
        boolean z = false;
        addFavoriteUI.intent = addFavoriteUI.getIntent();
        if (addFavoriteUI.intent == null) {
            v.e("MicroMsg.AddFavoriteUI", "intent is null");
            return false;
        }
        String g = r.g(addFavoriteUI.intent, "android.intent.extra.TEXT");
        if (g == null || g.length() == 0) {
            v.i("MicroMsg.AddFavoriteUI", "text is null");
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(g));
        wXMediaMessage.description = g;
        com.tencent.mm.sdk.modelmsg.c.a aVar = new com.tencent.mm.sdk.modelmsg.c.a();
        aVar.lBj = null;
        aVar.nhM = wXMediaMessage;
        int type = aVar.nhM.getType();
        Bundle bundle = new Bundle();
        aVar.t(bundle);
        bundle.putInt("_mmessage_sdkVersion", 587333634);
        bundle.putString("_mmessage_appPackage", "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        if (!ak.uN() || ak.uG()) {
            v.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class), addFavoriteUI.getIntent().addFlags(67108864));
            addFavoriteUI.finish();
        } else {
            bp bpVar = new bp();
            String str = e.aT(addFavoriteUI.filePath) + "." + e.aS(addFavoriteUI.filePath);
            if (type == 1) {
                if (be.kS(g)) {
                    v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    bpVar.aZd.aZk = 2131232653;
                } else {
                    v.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[]{g, Integer.valueOf(13)});
                    qf qfVar = new qf();
                    qg qgVar = new qg();
                    qgVar.Jn(k.xF());
                    qgVar.Jo(k.xF());
                    qgVar.uN(13);
                    qgVar.dV(be.Ni());
                    qfVar.a(qgVar);
                    bpVar.aZd.desc = g;
                    bpVar.aZd.aZf = qfVar;
                    bpVar.aZd.type = 1;
                    z = true;
                }
                Boolean.valueOf(z);
            } else {
                Boolean.valueOf(com.tencent.mm.pluginsdk.model.d.a(bpVar, 13, addFavoriteUI.filePath, str, ""));
            }
            bpVar.aZd.aXH = addFavoriteUI;
            bpVar.aZd.aZm = new OnClickListener(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oQL.finish();
                }
            };
            bpVar.aZd.aZn = new c(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void aEU() {
                }

                public final void onHide() {
                    this.oQL.finish();
                }

                public final void blD() {
                }
            };
            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        }
        return true;
    }

    static /* synthetic */ void f(AddFavoriteUI addFavoriteUI) {
        v.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int Pz = Pz(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (Pz == -1) {
            v.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
        } else if (Pz == 8 && !be.kS(addFavoriteUI.filePath)) {
            addFavoriteUI.Py(addFavoriteUI.filePath);
        } else if (r.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !ak.uN() || ak.uG()) {
            ArrayList arrayList;
            Intent intent = new Intent(addFavoriteUI, AddFavoriteUI.class);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            if (be.bP(addFavoriteUI.oQI)) {
                arrayList = new ArrayList(0);
            } else {
                ArrayList arrayList2 = new ArrayList(addFavoriteUI.oQI.size());
                Iterator it = addFavoriteUI.oQI.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Uri.fromFile(new File((String) it.next())));
                }
                arrayList = arrayList2;
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.addFlags(268435456).addFlags(32768);
            intent.setType(addFavoriteUI.getIntent().getType());
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
            addFavoriteUI.finish();
        } else {
            bp bpVar = new bp();
            List<String> list = addFavoriteUI.oQI;
            if (list == null || list.isEmpty()) {
                v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or paths is empty");
                bpVar.aZd.aZk = 2131232653;
            } else if (list.size() > 9) {
                bpVar.aZd.aZk = 2131232660;
            } else {
                v.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple images), paths %s sourceType %d", new Object[]{list, Integer.valueOf(13)});
                qf qfVar = new qf();
                qg qgVar = new qg();
                for (String str : list) {
                    if (!be.kS(str)) {
                        pw pwVar = new pw();
                        pwVar.uG(2);
                        pwVar.IK(str);
                        pwVar.ip(true);
                        qfVar.mtR.add(pwVar);
                    }
                }
                qgVar.Jn(k.xF());
                qgVar.Jo(k.xF());
                qgVar.uN(13);
                qgVar.dV(be.Ni());
                qfVar.a(qgVar);
                bpVar.aZd.title = "";
                bpVar.aZd.aZf = qfVar;
                bpVar.aZd.type = 2;
            }
            bpVar.aZd.aXH = addFavoriteUI;
            bpVar.aZd.aZm = new OnClickListener(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oQL.finish();
                }
            };
            bpVar.aZd.aZn = new c(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void aEU() {
                }

                public final void onHide() {
                    this.oQL.finish();
                }

                public final void blD() {
                }
            };
            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        }
    }

    static /* synthetic */ void h(AddFavoriteUI addFavoriteUI) {
        v.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int Pz = Pz(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (Pz == -1) {
            v.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
        } else if (Pz == 8 && !be.kS(addFavoriteUI.filePath)) {
            addFavoriteUI.Py(addFavoriteUI.filePath);
        } else if (r.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !ak.uN() || ak.uG()) {
            addFavoriteUI.finish();
            addFavoriteUI.bIX();
        } else {
            bp bpVar = new bp();
            com.tencent.mm.pluginsdk.model.d.a(bpVar, 13, addFavoriteUI.filePath);
            bpVar.aZd.aXH = addFavoriteUI;
            bpVar.aZd.aZm = new OnClickListener(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oQL.finish();
                }
            };
            bpVar.aZd.aZn = new c(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void aEU() {
                }

                public final void onHide() {
                    this.oQL.finish();
                }

                public final void blD() {
                }
            };
            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        }
    }

    public void onCreate(Bundle bundle) {
        v.i("MicroMsg.AddFavoriteUI", "on create");
        super.onCreate(bundle);
        vB(8);
        int a = r.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.pZ();
                NI();
                return;
            case 1:
                finish();
                return;
            default:
                v.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        v.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    protected void onNewIntent(Intent intent) {
        v.i("MicroMsg.AddFavoriteUI", "on NewIntent");
        super.onNewIntent(intent);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        v.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
        super.onRestoreInstanceState(bundle);
    }

    protected void onDestroy() {
        v.i("MicroMsg.AddFavoriteUI", "on Destroy");
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void NI() {
        this.intent = getIntent();
        if (this.intent == null) {
            v.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
            bIY();
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle T = r.T(this.intent);
        if (be.kS(action)) {
            v.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
            bIY();
            finish();
            return;
        }
        if (T != null) {
            Parcelable parcelable = T.getParcelable("android.intent.extra.STREAM");
            if (parcelable instanceof Uri) {
                this.uri = (Uri) parcelable;
                if (!be.l(this.uri)) {
                    v.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[]{this.uri});
                    bIY();
                    finish();
                    return;
                }
            } else if (parcelable != null) {
                v.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[]{parcelable});
                bIY();
                finish();
                return;
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            v.i("MicroMsg.AddFavoriteUI", "send signal: " + action);
            if (this.uri == null) {
                showDialog();
                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                    final /* synthetic */ AddFavoriteUI oQL;

                    {
                        this.oQL = r1;
                    }

                    public final void run() {
                        this.oQL.oQJ.sendEmptyMessage(0);
                    }
                }, "AddFavoriteUI_dealWithTextHandler");
                return;
            }
            showDialog();
            com.tencent.mm.sdk.i.e.a(new a(this, this.uri, new b(this) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void bIZ() {
                    this.oQL.handler.sendEmptyMessage(0);
                }
            }), "AddFavoriteUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && T != null && T.containsKey("android.intent.extra.STREAM")) {
            v.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[]{action, getIntent().resolveType(this)});
            if (be.ah(getIntent().resolveType(this), "").contains("image")) {
                this.oQI = X(T);
                if (this.oQI == null || this.oQI.size() == 0) {
                    v.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
                    ye(1);
                    finish();
                    return;
                }
                showDialog();
                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                    final /* synthetic */ AddFavoriteUI oQL;

                    {
                        this.oQL = r1;
                    }

                    public final void run() {
                        this.oQL.oQK.sendEmptyMessage(0);
                    }
                }, "AddFavoriteUI_dealWithMultiItemHandler");
                return;
            }
            v.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
            ye(1);
            finish();
        } else {
            v.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
            bIY();
            finish();
        }
    }

    private void bIX() {
        Intent intent = new Intent(this, AddFavoriteUI.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", be.kS(this.filePath) ? null : Uri.fromFile(new File(this.filePath)));
        intent.addFlags(268435456).addFlags(32768);
        intent.setType(getIntent().getType());
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
    }

    private ArrayList<String> X(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            v.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                v.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[]{parcelable});
            } else {
                Uri uri = (Uri) parcelable;
                if (!be.l(uri) || uri.getScheme() == null) {
                    v.e("MicroMsg.AddFavoriteUI", "unaccepted uri: " + uri);
                } else {
                    String d = be.d(this, uri);
                    if (!be.kS(d)) {
                        if (be.KX(d) && Px(d)) {
                            v.i("MicroMsg.AddFavoriteUI", "multisend file path: " + d);
                            arrayList.add(d);
                            i = 1;
                            continue;
                            if (i == 0) {
                                return null;
                            }
                        }
                        v.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: " + d);
                    }
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return null;
            }
        }
        return arrayList.size() > 0 ? arrayList : null;
    }

    private static boolean Px(String str) {
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean a = o.a(str, decodeResultLogger);
        if (!a && decodeResultLogger.getDecodeResult() >= 2000) {
            g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 5, decodeResultLogger));
        }
        return a;
    }

    private void Py(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
            return;
        }
        int aQ = e.aQ(str);
        v.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[]{Integer.valueOf(aQ)});
        if (aQ == 0) {
            v.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
            Toast.makeText(this, 2131232669, 1).show();
        } else if (aQ > 26214400) {
            v.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
            Toast.makeText(this, 2131232747, 1).show();
        } else if (!ak.uN() || ak.uG()) {
            v.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            finish();
            bIX();
        } else {
            WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
            wXMediaMessage.title = new File(str).getName();
            if (be.kS(null)) {
                wXMediaMessage.description = be.aw((long) aQ);
            } else {
                wXMediaMessage.description = null;
            }
            if (aQ < 30720) {
                wXMediaMessage.thumbData = e.c(str, 0, -1);
            } else {
                v.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
            }
            com.tencent.mm.sdk.modelmsg.c.a aVar = new com.tencent.mm.sdk.modelmsg.c.a();
            aVar.lBj = null;
            aVar.nhM = wXMediaMessage;
            Bundle bundle = new Bundle();
            aVar.t(bundle);
            bundle.putInt("_mmessage_sdkVersion", 587333634);
            bundle.putString("_mmessage_appPackage", "com.tencent.mm.openapi");
            bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
            bp bpVar = new bp();
            com.tencent.mm.pluginsdk.model.d.a(bpVar, 13, str, e.aT(str) + "." + e.aS(str), "");
            bpVar.aZd.aXH = this;
            bpVar.aZd.aZm = new OnClickListener(this) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oQL.finish();
                }
            };
            bpVar.aZd.aZn = new c(this) {
                final /* synthetic */ AddFavoriteUI oQL;

                {
                    this.oQL = r1;
                }

                public final void aEU() {
                }

                public final void onHide() {
                    this.oQL.finish();
                }

                public final void blD() {
                }
            };
            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        }
    }

    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileInputStream createInputStream;
        Throwable e;
        FileNotFoundException e2;
        IOException e3;
        Exception e4;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                str = cursor.getString(columnIndex);
                if (str != null) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                v.i("MicroMsg.AddFavoriteUI", "vcard file name: " + str);
            }
            cursor.close();
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
                try {
                    createInputStream = openAssetFileDescriptor.createInputStream();
                    try {
                        byte[] bArr = new byte[((int) openAssetFileDescriptor.getDeclaredLength())];
                        if (createInputStream.read(bArr) > 0) {
                            ak.yW();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                String str2 = com.tencent.mm.compatible.util.e.cnj + "share";
                                str = com.tencent.mm.compatible.util.e.cnj + "share/" + str;
                                File file = new File(str2);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                File file2 = new File(str);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                if (e.b(str, bArr, bArr.length) == 0) {
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e5) {
                                            v.a("MicroMsg.AddFavoriteUI", e5, e5.getMessage(), new Object[0]);
                                            return str;
                                        }
                                    }
                                    if (openAssetFileDescriptor == null) {
                                        return str;
                                    }
                                    openAssetFileDescriptor.close();
                                    return str;
                                }
                            }
                            deleteFile(str);
                            FileOutputStream openFileOutput = openFileOutput(str, 0);
                            openFileOutput.write(bArr);
                            openFileOutput.flush();
                            openFileOutput.close();
                            str = getFilesDir().getPath() + "/" + str;
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                } catch (Throwable e52) {
                                    v.a("MicroMsg.AddFavoriteUI", e52, e52.getMessage(), new Object[0]);
                                    return str;
                                }
                            }
                            if (openAssetFileDescriptor == null) {
                                return str;
                            }
                            openAssetFileDescriptor.close();
                            return str;
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e6) {
                                v.a("MicroMsg.AddFavoriteUI", e6, e6.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                    } catch (FileNotFoundException e7) {
                        e2 = e7;
                        try {
                            v.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e2.getMessage());
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                } catch (Throwable e62) {
                                    v.a("MicroMsg.AddFavoriteUI", e62, e62.getMessage(), new Object[0]);
                                }
                            }
                            if (openAssetFileDescriptor != null) {
                                openAssetFileDescriptor.close();
                            }
                            return null;
                        } catch (Throwable th) {
                            e62 = th;
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                } catch (Throwable e522) {
                                    v.a("MicroMsg.AddFavoriteUI", e522, e522.getMessage(), new Object[0]);
                                    throw e62;
                                }
                            }
                            if (openAssetFileDescriptor != null) {
                                openAssetFileDescriptor.close();
                            }
                            throw e62;
                        }
                    } catch (IOException e8) {
                        e3 = e8;
                        v.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e622) {
                                v.a("MicroMsg.AddFavoriteUI", e622, e622.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        return null;
                    } catch (Exception e9) {
                        e4 = e9;
                        v.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e6222) {
                                v.a("MicroMsg.AddFavoriteUI", e6222, e6222.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        return null;
                    }
                } catch (FileNotFoundException e10) {
                    e2 = e10;
                    createInputStream = null;
                    v.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e2.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    return null;
                } catch (IOException e11) {
                    e3 = e11;
                    createInputStream = null;
                    v.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    return null;
                } catch (Exception e12) {
                    e4 = e12;
                    createInputStream = null;
                    v.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    e6222 = th2;
                    createInputStream = null;
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    throw e6222;
                }
            } catch (FileNotFoundException e13) {
                e2 = e13;
                createInputStream = null;
                openAssetFileDescriptor = null;
                v.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e2.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                return null;
            } catch (IOException e14) {
                e3 = e14;
                createInputStream = null;
                openAssetFileDescriptor = null;
                v.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                return null;
            } catch (Exception e15) {
                e4 = e15;
                createInputStream = null;
                openAssetFileDescriptor = null;
                v.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                return null;
            } catch (Throwable th3) {
                e6222 = th3;
                createInputStream = null;
                openAssetFileDescriptor = null;
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                throw e6222;
            }
        }
        return null;
    }

    private static int Pz(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains("image") || toLowerCase.equals("application/vnd.google.panorama360+jpg")) {
            return 2;
        }
        v.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
        return 8;
    }

    private void bIY() {
        ye(0);
        Toast.makeText(this, 2131235304, 1).show();
    }

    private void ye(int i) {
        switch (i) {
            case 1:
                Toast.makeText(this, 2131235302, 1).show();
                return;
            default:
                Toast.makeText(this, 2131235304, 1).show();
                return;
        }
    }

    private void showDialog() {
        getString(2131231164);
        this.dwR = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ AddFavoriteUI oQL;

            {
                this.oQL = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }
}
