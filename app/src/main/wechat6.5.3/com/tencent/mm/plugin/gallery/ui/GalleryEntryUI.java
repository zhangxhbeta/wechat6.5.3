package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(7)
public final class GalleryEntryUI extends ActionBarActivity {
    private boolean gfU = false;
    private int gfV;
    private boolean gfW = false;
    private int gfw;

    protected final void onCreate(Bundle bundle) {
        v.i("MicroMsg.GalleryEntryUI", "on create");
        super.onCreate(bundle);
        v.i("MicroMsg.GalleryEntryUI", "checktask onCreate:%s#0x%x task:%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(hashCode()), be.ea(this)});
        c.aqp();
        this.gfw = getIntent().getIntExtra("query_source_type", 3);
        this.gfV = getIntent().getIntExtra("query_media_type", 1);
        v.i("MicroMsg.GalleryEntryUI", "query souce: " + this.gfw + ", queryType: " + this.gfV);
        c.aqn().lh(this.gfV);
        c.aqn().li(this.gfw);
    }

    protected final void onRestoreInstanceState(Bundle bundle) {
        v.d("MicroMsg.GalleryEntryUI", "onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        this.gfU = true;
    }

    protected final void onResume() {
        v.i("MicroMsg.GalleryEntryUI", "on resume, init %B", new Object[]{Boolean.valueOf(this.gfU)});
        super.onResume();
        if (!this.gfU) {
            v.e("MicroMsg.GalleryEntryUI", "doRedirect %s", new Object[]{be.bur()});
            Intent intent = getIntent();
            if (intent.getBooleanExtra("preview_image", false)) {
                v.d("MicroMsg.GalleryEntryUI", "jump to preview ui directly");
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                Intent intent2 = new Intent(this, ImagePreviewUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("max_select_count", intent.getIntExtra("max_select_count", 9));
                intent2.putExtra("query_source_type", this.gfw);
                intent2.putExtra("isPreviewPhoto", intent.getBooleanExtra("isPreviewPhoto", false));
                String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
                String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
                if (!be.kS(stringExtra)) {
                    intent2.putExtra("GalleryUI_FromUser", stringExtra);
                }
                if (!be.kS(stringExtra2)) {
                    intent2.putExtra("GalleryUI_ToUser", stringExtra2);
                }
                intent2.putStringArrayListExtra("preview_image_list", stringArrayListExtra);
                startActivityForResult(intent2, 1);
            } else {
                intent.setClass(this, AlbumPreviewUI.class);
                intent.addFlags(67108864);
                intent.putExtra("send_btn_string", getIntent().getStringExtra("send_btn_string"));
                intent.putExtra("max_select_count", getIntent().getIntExtra("max_select_count", 9));
                intent.putExtra("GalleryUI_FromUser", getIntent().getStringExtra("GalleryUI_FromUser"));
                intent.putExtra("GalleryUI_ToUser", getIntent().getStringExtra("GalleryUI_ToUser"));
                intent.putExtra("key_send_raw_image", getIntent().getBooleanExtra("key_send_raw_image", false));
                startActivityForResult(intent, 0);
            }
            this.gfU = true;
        }
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        v.d("MicroMsg.GalleryEntryUI", "on new intent, #0x%x", new Object[]{Integer.valueOf(hashCode())});
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.GalleryEntryUI";
        String str2 = "on activity result, requestCode %d resultCode %d, data:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = intent == null ? "" : intent.toString();
        v.i(str, str2, objArr);
        this.gfW = true;
        switch (i2) {
            case -1:
                if (intent != null) {
                    setResult(-1, intent);
                    break;
                }
                return;
            case 0:
                v.d("MicroMsg.GalleryEntryUI", "user choose canceld");
                setResult(0);
                break;
            case 1:
                setResult(1);
                break;
        }
        if (this.gfW) {
            finish();
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.GalleryEntryUI", "onDestroy %B", new Object[]{Boolean.valueOf(this.gfW)});
        c.dj(this.gfW);
        v.i("MicroMsg.GalleryEntryUI", "checktask onDestroy:%s#0x%x task:%s ", new Object[]{getClass().getSimpleName(), Integer.valueOf(hashCode()), be.ea(this)});
    }
}
