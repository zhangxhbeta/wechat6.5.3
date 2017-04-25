package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ae.m;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

public class SendImgProxyUI extends MMBaseActivity {
    private static boolean aHp = false;
    private p dwE = null;

    static /* synthetic */ void a(SendImgProxyUI sendImgProxyUI, Intent intent) {
        if (intent == null) {
            v.e("MicroMsg.SendImgProxyUI", "data is empty!");
            return;
        }
        ArrayList ac = ac(intent.getStringArrayListExtra("CropImage_OutputPath_List"));
        if (ac(intent.getStringArrayListExtra("key_select_video_list")).size() <= 0) {
            intent.putStringArrayListExtra("CropImage_OutputPath_List", ac);
            if (ac.size() == 0) {
                Toast.makeText(sendImgProxyUI, sendImgProxyUI.getString(2131233024), 0).show();
                v.e("MicroMsg.SendImgProxyUI", "filelist is empty!");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
            int intExtra = intent.getIntExtra("from_source", 0);
            int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
            String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
            v.d("MicroMsg.SendImgProxyUI", "toUserName : " + stringExtra);
            v.d("MicroMsg.SendImgProxyUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
            m.Gy().a(ac, booleanExtra, intExtra, intExtra2, stringExtra);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[]{Boolean.valueOf(aHp), Integer.valueOf(hashCode())});
        if (aHp) {
            v.w("MicroMsg.SendImgProxyUI", "duplicate instance");
            finish();
            return;
        }
        aHp = true;
        setContentView(2130903145);
        if (!ak.uz()) {
            v.i("MicroMsg.SendImgProxyUI", "AccHasNotReady");
            ak.yY();
        }
        this.dwE = g.a(this, getString(2131233725), false, null);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ SendImgProxyUI oyY;

            {
                this.oyY = r1;
            }

            public final void run() {
                v.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
                SendImgProxyUI.a(this.oyY, this.oyY.getIntent());
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(-1));
                ak.vA().btw();
                v.i("MicroMsg.SendImgProxyUI", "test before finish");
                this.oyY.dwE.dismiss();
                this.oyY.setResult(-1, this.oyY.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
                SendImgProxyUI.aHp = false;
                this.oyY.finish();
            }
        });
    }

    protected void onDestroy() {
        v.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[]{Boolean.valueOf(aHp), Integer.valueOf(hashCode())});
        super.onDestroy();
    }

    public void onResume() {
        v.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[]{Boolean.valueOf(aHp), Integer.valueOf(hashCode())});
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> ac(java.util.ArrayList<java.lang.String> r5) {
        /*
        r2 = new java.util.ArrayList;
        r2.<init>();
        if (r5 == 0) goto L_0x0051;
    L_0x0007:
        r3 = r5.iterator();
    L_0x000b:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0051;
    L_0x0011:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r1 = r0.toLowerCase();
        r4 = ".png";
        r1 = r1.endsWith(r4);
        if (r1 == 0) goto L_0x004b;
    L_0x0024:
        r1 = 0;
        r1 = com.tencent.mm.modelsfs.FileOp.openRead(r0);	 Catch:{ Exception -> 0x003a, all -> 0x0044 }
        r4 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.checkIsImageLegal(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0044 }
        if (r4 == 0) goto L_0x0032;
    L_0x002f:
        r2.add(r0);	 Catch:{ Exception -> 0x0052, all -> 0x0044 }
    L_0x0032:
        if (r1 == 0) goto L_0x000b;
    L_0x0034:
        r1.close();	 Catch:{ Exception -> 0x0038 }
        goto L_0x000b;
    L_0x0038:
        r0 = move-exception;
        goto L_0x000b;
    L_0x003a:
        r0 = move-exception;
        r0 = r1;
    L_0x003c:
        if (r0 == 0) goto L_0x000b;
    L_0x003e:
        r0.close();	 Catch:{ Exception -> 0x0042 }
        goto L_0x000b;
    L_0x0042:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0044:
        r0 = move-exception;
        if (r1 == 0) goto L_0x004a;
    L_0x0047:
        r1.close();	 Catch:{ Exception -> 0x004f }
    L_0x004a:
        throw r0;
    L_0x004b:
        r2.add(r0);
        goto L_0x000b;
    L_0x004f:
        r1 = move-exception;
        goto L_0x004a;
    L_0x0051:
        return r2;
    L_0x0052:
        r0 = move-exception;
        r0 = r1;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.SendImgProxyUI.ac(java.util.ArrayList):java.util.ArrayList<java.lang.String>");
    }
}
