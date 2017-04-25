package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.n.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
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
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareImgUI extends AutoLoginActivity implements e {
    private ProgressDialog dwR = null;
    String filePath = null;
    private ac handler = new ac(this) {
        final /* synthetic */ ShareImgUI oUI;

        {
            this.oUI = r1;
        }

        public final void handleMessage(Message message) {
            ShareImgUI.b(this.oUI);
            if (be.kS(this.oUI.filePath)) {
                v.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
                this.oUI.ye(0);
                this.oUI.finish();
                return;
            }
            this.oUI.bJv();
        }
    };
    private Intent intent = null;
    ArrayList<String> oQI = null;
    String text = null;
    Uri uri = null;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] enx = new int[com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a.values().length];

        static {
            try {
                enx[com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a.lFV.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private class a implements Runnable {
        private Uri mUri;
        final /* synthetic */ ShareImgUI oUI;
        private b oUJ;

        public a(ShareImgUI shareImgUI, Uri uri, b bVar) {
            this.oUI = shareImgUI;
            this.mUri = uri;
            this.oUJ = bVar;
        }

        public final void run() {
            this.oUI.filePath = ShareImgUI.a(this.oUI, this.mUri);
            if (be.kS(this.oUI.filePath)) {
                this.oUI.filePath = d.a(this.oUI.getContentResolver(), this.mUri, 1);
            }
            if (this.oUJ != null) {
                this.oUJ.bIZ();
            }
        }
    }

    public interface b {
        void bIZ();
    }

    static /* synthetic */ String a(ShareImgUI shareImgUI, Uri uri) {
        String scheme = uri.getScheme();
        if (be.kS(scheme)) {
            v.e("MicroMsg.ShareImgUI", "input uri error. %s", new Object[]{uri});
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            v.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else if (scheme.equalsIgnoreCase("content")) {
            v.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
            Cursor query = shareImgUI.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                v.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor is null");
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                v.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                return null;
            } else {
                String toLowerCase = uri.toString().toLowerCase();
                if (toLowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || toLowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || toLowerCase.startsWith("content://com.mediatek.calendarimporter") || ((shareImgUI.intent != null && shareImgUI.intent.getType().equals("text/x-vcalendar")) || p.ceJ.cdG == 1)) {
                    return shareImgUI.a(uri, query);
                }
                query.close();
                return be.d(shareImgUI, uri);
            }
        } else {
            v.e("MicroMsg.ShareImgUI", "unknown scheme");
            return null;
        }
    }

    static /* synthetic */ void b(ShareImgUI shareImgUI) {
        if (shareImgUI.dwR != null && shareImgUI.dwR.isShowing()) {
            shareImgUI.dwR.dismiss();
        }
    }

    protected final boolean p(Intent intent) {
        return true;
    }

    protected final boolean aDX() {
        if (ak.uN() && !ak.uG()) {
            return false;
        }
        v.w("MicroMsg.ShareImgUI", "not login");
        this.intent = getIntent();
        bJu();
        return true;
    }

    protected final void a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a aVar, Intent intent) {
        switch (AnonymousClass4.enx[aVar.ordinal()]) {
            case 1:
                this.intent = intent;
                v.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[]{Integer.valueOf(be.getInt(j.sU().getValue("SystemShareControlBitset"), 0))});
                if ((be.getInt(j.sU().getValue("SystemShareControlBitset"), 0) & 1) > 0) {
                    v.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    return;
                }
                v.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[]{r.g(intent, "android.intent.extra.TEXT")});
                if (be.kS(r.g(intent, "android.intent.extra.TEXT"))) {
                    bJu();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                ak.vy().a(1200, this);
                ak.vy().a(new af(format, 15, null), 0);
                return;
            default:
                finish();
                com.tencent.mm.ui.base.b.ew(this);
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1200, this);
    }

    private void bJu() {
        if (this.intent == null) {
            v.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            ye(0);
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle extras = this.intent.getExtras();
        if (be.kS(action)) {
            v.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            ye(0);
            finish();
            return;
        }
        this.text = r.g(this.intent, "android.intent.extra.TEXT");
        if (extras != null) {
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                this.uri = (Uri) parcelable;
                if (!be.l(this.uri)) {
                    v.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[]{this.uri});
                    ye(0);
                    finish();
                    return;
                }
            }
        }
        String g;
        if (action.equals("android.intent.action.SEND")) {
            v.i("MicroMsg.ShareImgUI", "send signal: " + action);
            if (this.uri == null) {
                boolean z;
                Intent intent = getIntent();
                if (intent == null) {
                    v.e("MicroMsg.ShareImgUI", "intent is null");
                    z = false;
                } else {
                    g = r.g(intent, "android.intent.extra.TEXT");
                    if (g == null || g.length() == 0) {
                        v.i("MicroMsg.ShareImgUI", "text is null");
                        z = false;
                    } else {
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(g));
                        wXMediaMessage.description = g;
                        com.tencent.mm.sdk.modelmsg.c.a aVar = new com.tencent.mm.sdk.modelmsg.c.a();
                        aVar.lBj = null;
                        aVar.nhM = wXMediaMessage;
                        Bundle bundle = new Bundle();
                        aVar.t(bundle);
                        bundle.putInt("_mmessage_sdkVersion", 587333634);
                        bundle.putString("_mmessage_appPackage", "com.tencent.mm.openapi");
                        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        intent = new Intent();
                        intent.setClass(this, SelectConversationUI.class);
                        intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                        if (!ak.uN() || ak.uG()) {
                            v.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                        } else {
                            startActivity(intent);
                        }
                        z = true;
                    }
                }
                v.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[]{Boolean.valueOf(z)});
                if (!z) {
                    ye(0);
                }
                finish();
                return;
            }
            showDialog();
            com.tencent.mm.sdk.i.e.a(new a(this, this.uri, new b(this) {
                final /* synthetic */ ShareImgUI oUI;

                {
                    this.oUI = r1;
                }

                public final void bIZ() {
                    this.oUI.handler.sendEmptyMessage(0);
                }
            }), "ShareImgUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && extras != null && extras.containsKey("android.intent.extra.STREAM")) {
            v.i("MicroMsg.ShareImgUI", "send multi: " + action);
            this.oQI = X(extras);
            if (this.oQI == null || this.oQI.size() == 0) {
                v.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
                ye(1);
                finish();
                return;
            }
            Iterator it = this.oQI.iterator();
            while (it.hasNext()) {
                if (!Px((String) it.next())) {
                    v.i("MicroMsg.ShareImgUI", "%s is not image", new Object[]{(String) it.next()});
                    ye(1);
                    finish();
                    return;
                }
            }
            g = getIntent().resolveType(this);
            if (g == null || !g.contains("image")) {
                v.i("MicroMsg.ShareImgUI", "mime type is no timage, try to set it");
                getIntent().setDataAndType(getIntent().getData(), "image/*");
            }
            bJv();
        } else {
            v.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            ye(0);
            finish();
        }
    }

    private void bJv() {
        int i;
        int i2 = 1;
        Intent intent = getIntent();
        String resolveType = intent.resolveType(this);
        if (resolveType == null || resolveType.length() == 0) {
            v.e("MicroMsg.ShareImgUI", "map : mimeType is null");
            i = -1;
        } else {
            resolveType = resolveType.toLowerCase();
            if (resolveType.contains("image")) {
                i = 0;
            } else if (resolveType.contains("video")) {
                i = 1;
            } else {
                v.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
                i = 3;
            }
        }
        v.i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d, text:%s", new Object[]{this.filePath, Integer.valueOf(i), this.text});
        if (i == -1) {
            v.e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
            finish();
        } else if (!be.kS(this.filePath) && be.KX(this.filePath) && !Px(this.filePath)) {
            v.w("MicroMsg.ShareImgUI", "try to share illegal image.");
            ye(0);
            finish();
        } else if (i == 3 && !be.kS(this.filePath)) {
            Py(this.filePath);
            finish();
        } else if (this.text == null || i != 0 || be.kS(this.filePath)) {
            if (r.a(getIntent(), "Intro_Switch", false) || !ak.uN() || ak.uG()) {
                Intent intent2 = new Intent(this, ShareImgUI.class);
                if (!"android.intent.action.SEND".equals(getIntent().getAction())) {
                    if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction())) {
                        i2 = 0;
                    } else if (be.bP(this.oQI)) {
                        i2 = 0;
                    } else {
                        ArrayList arrayList = new ArrayList(this.oQI.size());
                        Iterator it = this.oQI.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Uri.fromFile(new File((String) it.next())));
                        }
                        intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                        intent2.setAction("android.intent.action.SEND_MULTIPLE");
                        intent2.setType(getIntent().getType());
                    }
                    if (i2 == 0) {
                        ye(0);
                    }
                } else if (be.kS(this.filePath)) {
                    i2 = 0;
                    if (i2 == 0) {
                        ye(0);
                    }
                } else {
                    intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.setType(getIntent().getType());
                }
                intent2.addFlags(67108864);
                MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent2);
                if (i2 == 0) {
                    ye(0);
                }
            } else {
                intent.setData(this.uri);
                intent.setClass(this, MsgRetransmitUI.class);
                intent.addFlags(268435456).addFlags(67108864);
                intent.putExtra("Retr_File_Name", this.filePath);
                intent.putStringArrayListExtra("Retr_File_Path_List", this.oQI);
                intent.putExtra("Retr_Msg_Type", i);
                intent.putExtra("Retr_Scene", 1);
                intent.putExtra("Retr_start_where_you_are", false);
                startActivity(intent);
            }
            finish();
        } else {
            Py(this.filePath);
            finish();
        }
    }

    private ArrayList<String> X(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            v.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                v.e("MicroMsg.ShareImgUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[]{parcelable});
            } else {
                Uri uri = (Uri) parcelable;
                if (!be.l(uri) || uri.getScheme() == null) {
                    v.e("MicroMsg.ShareImgUI", "unaccepted uri: " + uri);
                } else {
                    String d = be.d(this, uri);
                    if (!be.kS(d)) {
                        if (be.KX(d) && Px(d)) {
                            v.i("MicroMsg.ShareImgUI", "multisend file path: " + d);
                            arrayList.add(d);
                            i = 1;
                            continue;
                            if (i == 0) {
                                return null;
                            }
                        }
                        v.w("MicroMsg.ShareImgUI", "multisend tries to send illegal img: " + d);
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
            g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 3, decodeResultLogger));
        }
        return a;
    }

    private void Py(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
        } else if (be.ts(str)) {
            String str2 = "";
            int aQ = com.tencent.mm.a.e.aQ(str);
            v.i("MicroMsg.ShareImgUI", "filelength: [%d]", new Object[]{Integer.valueOf(aQ)});
            if (aQ == 0) {
                v.e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
            } else if (aQ > 10485760) {
                v.e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", new Object[]{Integer.valueOf(aQ), str});
                Toast.makeText(this, 2131235303, 1).show();
            } else {
                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
                wXMediaMessage.title = new File(str).getName();
                if (str2.length() > 0) {
                    wXMediaMessage.description = str2;
                } else {
                    wXMediaMessage.description = be.aw((long) aQ);
                }
                if (aQ < 30720) {
                    wXMediaMessage.thumbData = com.tencent.mm.a.e.c(str, 0, -1);
                } else {
                    v.i("MicroMsg.ShareImgUI", "thumb data is exceed 30k, ignore");
                }
                com.tencent.mm.sdk.modelmsg.c.a aVar = new com.tencent.mm.sdk.modelmsg.c.a();
                aVar.lBj = null;
                aVar.nhM = wXMediaMessage;
                Bundle bundle = new Bundle();
                aVar.t(bundle);
                bundle.putInt("_mmessage_sdkVersion", 587333634);
                bundle.putString("_mmessage_appPackage", "com.tencent.mm.openapi");
                bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                Intent intent = new Intent();
                intent.setClass(this, SelectConversationUI.class);
                intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                if (!ak.uN() || ak.uG()) {
                    v.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                    MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                    return;
                }
                startActivity(intent);
            }
        } else {
            v.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
        }
    }

    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileNotFoundException e;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        IOException e2;
        Exception e3;
        FileOutputStream fileOutputStream2 = null;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                try {
                    str = cursor.getString(columnIndex);
                } catch (Exception e4) {
                    v.w("MicroMsg.ShareImgUI", "try to get Vcard Name fail: %s", new Object[]{e4.getMessage()});
                }
                if (!(str == null || str == null)) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                v.i("MicroMsg.ShareImgUI", "vcard file name: " + str);
            }
            cursor.close();
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                try {
                    v.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                            throw th;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e2 = e8;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                v.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e9) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e10) {
                e3 = e10;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                v.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                v.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e11) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            try {
                fileInputStream = openAssetFileDescriptor.createInputStream();
                try {
                    ak.yW();
                    if (c.isSDCardAvailable()) {
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
                        fileOutputStream = new FileOutputStream(str, false);
                    } else {
                        deleteFile(str);
                        String str3 = getFilesDir().getPath() + "/" + str;
                        fileOutputStream = openFileOutput(str, 0);
                        str = str3;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    fileOutputStream = null;
                    v.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e13) {
                    e2 = e13;
                    fileOutputStream = null;
                    v.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e3 = e14;
                    fileOutputStream = null;
                    v.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    v.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 5120);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e15) {
                            return str;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream == null) {
                        return str;
                    }
                    fileOutputStream.close();
                    return str;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    v.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e17) {
                    e2 = e17;
                    v.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e18) {
                    e3 = e18;
                    v.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    v.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                fileOutputStream = null;
                fileInputStream = null;
                v.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (IOException e20) {
                e2 = e20;
                fileOutputStream = null;
                fileInputStream = null;
                v.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e21) {
                e3 = e21;
                fileOutputStream = null;
                fileInputStream = null;
                v.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                v.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
        return null;
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
            final /* synthetic */ ShareImgUI oUI;

            {
                this.oUI = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.oUI.finish();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ak.vy().b(1200, this);
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (i == 0 && i2 == 0) {
            bJu();
        } else {
            finish();
        }
    }
}
