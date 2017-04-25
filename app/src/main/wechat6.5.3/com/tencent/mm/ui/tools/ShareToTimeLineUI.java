package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ay.c;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.n.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareToTimeLineUI extends AutoLoginActivity implements e {
    private ProgressDialog dwR = null;
    private Intent intent;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] enx = new int[a.values().length];

        static {
            try {
                enx[a.lFV.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    protected final boolean aDX() {
        if (ak.uN() && !ak.uG()) {
            return false;
        }
        v.w("MicroMsg.ShareToTimeLine", "not login");
        bJv();
        return true;
    }

    private void bJv() {
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
            bIY();
            finish();
            return;
        }
        String action = intent.getAction();
        Bundle T = r.T(intent);
        if (be.kS(action)) {
            v.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
            bIY();
            finish();
            return;
        }
        String g = r.g(intent, "Kdescription");
        String resolveType = getIntent().resolveType(this);
        if (be.kS(resolveType)) {
            bIY();
            finish();
        } else if (!resolveType.contains("image")) {
            bIY();
            finish();
        } else if (action.equals("android.intent.action.SEND") && T != null) {
            v.i("MicroMsg.ShareToTimeLine", "send signal: " + action);
            Parcelable parcelable = T.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                Uri uri = (Uri) parcelable;
                if (be.l(uri)) {
                    String d = be.d(this, uri);
                    if (be.kS(d)) {
                        action = d.a(getContentResolver(), uri, 2);
                    } else {
                        action = d;
                    }
                    if (be.kS(action) || !be.KX(action)) {
                        if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                            dZ(action, g);
                            return;
                        }
                        bIY();
                        finish();
                        return;
                    } else if (Px(action)) {
                        dZ(action, g);
                        return;
                    } else {
                        bIY();
                        finish();
                        return;
                    }
                }
                v.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[]{uri});
                bIY();
                finish();
            } else if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                dZ(null, g);
            } else {
                bIY();
                finish();
            }
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && T != null && T.containsKey("android.intent.extra.STREAM")) {
            v.i("MicroMsg.ShareToTimeLine", "send multi: " + action);
            ArrayList X = X(T);
            if (X == null || X.size() == 0) {
                bIY();
                finish();
                return;
            }
            c(X, g);
        } else {
            v.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
            bIY();
            finish();
        }
    }

    private static boolean Px(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean a = o.a(str, decodeResultLogger);
        if (a || decodeResultLogger.getDecodeResult() < 2000) {
            return a;
        }
        g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
        return a;
    }

    private ArrayList<String> X(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            v.e("MicroMsg.ShareToTimeLine", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) ((Parcelable) it.next());
            if (uri == null || !be.l(uri) || uri.getScheme() == null) {
                v.e("MicroMsg.ShareToTimeLine", "unaccepted uri: " + uri);
            } else {
                String d = be.d(this, uri);
                if (!be.kS(d)) {
                    if (Px(d)) {
                        v.i("MicroMsg.ShareToTimeLine", "multisend file path: " + d);
                        arrayList.add(d);
                    } else {
                        v.w("MicroMsg.ShareToTimeLine", "not image: " + d);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private void dZ(String str, String str2) {
        Intent intent = new Intent();
        if (!be.kS(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!be.kS(str2)) {
            intent.putExtra("Kdescription", str2);
        }
        if (ak.uN() && !ak.uG()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            intent.putExtra("Ksnsupload_source", 12);
            c.b(this, "sns", ".ui.SnsUploadUI", intent);
        } else if (be.kS(str)) {
            bIY();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(32768).addFlags(268435456);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), intent);
        }
        finish();
    }

    private void c(ArrayList<String> arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            finish();
            return;
        }
        if (arrayList.size() > 9) {
            arrayList.subList(9, arrayList.size()).clear();
        }
        if (!ak.uN() || ak.uG()) {
            Intent intent = new Intent(this, ShareToTimeLineUI.class);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.addFlags(32768).addFlags(268435456);
            intent.setType("image/*");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), intent);
        } else {
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
            if (!be.kS(str)) {
                intent2.putExtra("Kdescription", str);
            }
            intent2.putExtra("K_go_to_SnsTimeLineUI", true);
            intent2.putExtra("Ksnsupload_source", 12);
            c.b(this, "sns", ".ui.SnsUploadUI", intent2);
        }
        finish();
    }

    private void bIY() {
        Toast.makeText(this, 2131235306, 1).show();
    }

    protected final boolean p(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        switch (AnonymousClass2.enx[aVar.ordinal()]) {
            case 1:
                this.intent = intent;
                v.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[]{Integer.valueOf(be.getInt(j.sU().getValue("SystemShareControlBitset"), 0))});
                if ((be.getInt(j.sU().getValue("SystemShareControlBitset"), 0) & 2) > 0) {
                    v.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
                    finish();
                    return;
                }
                v.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[]{r.g(intent, "android.intent.extra.TEXT")});
                if (be.kS(r.g(intent, "android.intent.extra.TEXT"))) {
                    bJv();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                getString(2131231164);
                this.dwR = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ ShareToTimeLineUI oUM;

                    {
                        this.oUM = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.oUM.finish();
                    }
                });
                ak.vy().a(1200, this);
                ak.vy().a(new af(format, 15, null), 0);
                return;
            default:
                finish();
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ak.vy().b(1200, this);
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (i == 0 && i2 == 0) {
            bJv();
        } else {
            finish();
        }
    }
}
