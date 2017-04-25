package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.j;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ImageDownloadUI extends MMActivity implements e, f {
    private long bao = 0;
    private long bmL = 0;
    private int cLy;
    private ProgressBar ifM;
    private TextView ifN;
    private TextView ifO;
    private TextView ifP;
    private TextView ifQ;
    private d ifS;
    private j ifT;
    private ImageView oxJ;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bao = getIntent().getLongExtra("img_msg_id", 0);
        this.bmL = getIntent().getLongExtra("img_server_id", 0);
        this.cLy = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        NI();
        if (this.bao > 0) {
            this.ifS = n.GH().ai(this.bao);
        }
        if ((this.ifS == null || this.ifS.cLu <= 0) && this.bmL > 0) {
            this.ifS = n.GH().ah(this.bmL);
        }
        if (this.ifS == null || this.ifS.cLu <= 0) {
            v.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.bao + ", or msgSvrId = " + this.bmL);
            return;
        }
        if (this.bao <= 0 && this.bmL > 0) {
            ak.yW();
            this.bao = c.wJ().S(this.username, this.bmL).field_msgId;
        }
        this.ifT = new j(this.ifS.cLu, this.bao, this.cLy, this);
        ak.vy().a(this.ifT, 0);
    }

    protected final int getLayoutId() {
        return 2130904568;
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b((int) MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, (e) this);
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a((int) MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, (e) this);
    }

    protected final void NI() {
        this.ifN = (TextView) findViewById(2131757991);
        this.ifO = (TextView) findViewById(2131759614);
        this.ifP = (TextView) findViewById(2131759615);
        this.ifQ = (TextView) findViewById(2131759616);
        this.oxJ = (ImageView) findViewById(2131759612);
        this.oxJ.setImageResource(2131165477);
        this.ifN.setVisibility(0);
        this.ifO.setVisibility(8);
        this.ifP.setVisibility(8);
        this.ifQ.setVisibility(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ImageDownloadUI oxK;

            {
                this.oxK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ak.vy().c(this.oxK.ifT);
                this.oxK.finish();
                return true;
            }
        });
        this.ifM = (ProgressBar) findViewById(2131759613);
    }

    public final void a(int i, int i2, k kVar) {
        v.d("ImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
            int i3;
            if (i2 != 0) {
                i3 = ((i * 100) / i2) - 1;
            } else {
                i3 = 0;
            }
            oA(Math.max(0, i3));
        }
    }

    private void oA(int i) {
        this.ifM.setProgress(i);
        this.ifN.setText(getString(2131232891, new Object[]{Integer.valueOf(i)}));
        if (i >= this.ifM.getMax()) {
            d b = n.GH().b(Long.valueOf(this.ifT.cMQ));
            String str = b.cLv;
            if (this.cLy == 1) {
                str = com.tencent.mm.ae.e.c(b);
            }
            str = n.GH().l(str, null, null);
            if (str == null || str.equals(SQLiteDatabase.KeyEmpty) || !com.tencent.mm.a.e.aR(str)) {
                v.d("ImageDownloadUI", "showImg : imgPath is null");
                return;
            }
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_message_id", this.bao);
            intent.putExtra("key_image_path", str);
            intent.putExtra("key_compress_type", this.cLy);
            intent.putExtra("key_favorite", true);
            intent.putExtra("img_gallery_msg_id", this.bao);
            intent.putExtra("img_gallery_talker", this.username);
            finish();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
            if (i == 0 && i2 == 0) {
                oA(this.ifM.getMax());
                return;
            }
            v.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, 2131233292, 1).show();
        }
    }
}
