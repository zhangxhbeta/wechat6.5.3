package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.e.a.mh;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> iyw = new HashMap();
    private String iyv = null;
    private ImageView iyx;
    private EditText iyy;
    protected Bitmap mBmp = null;

    public static void a(Bitmap bitmap, String str) {
        if (bitmap != null && !bitmap.isRecycled() && !be.kS(str)) {
            Intent intent = new Intent();
            intent.setClass(aa.getContext(), ConfirmScanBankCardResultUI.class);
            intent.addFlags(268435456);
            intent.putExtra("_card_num_", str);
            String str2 = "_image_cache_key_" + str;
            iyw.put(str2, bitmap);
            intent.putExtra("_image_cache_key_", str2);
            aa.getContext().startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        vD(2131236151);
        if (getIntent() == null) {
            v.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            obj = null;
        } else {
            this.iyv = getIntent().getStringExtra("_image_cache_key_");
            if (be.kS(this.iyv)) {
                v.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                obj = null;
            } else {
                this.mBmp = (Bitmap) iyw.get(this.iyv);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    v.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
        }
        if (obj == null) {
            finish();
            return;
        }
        CharSequence stringExtra = getIntent().getStringExtra("_card_num_");
        if (be.kS(stringExtra)) {
            v.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            return;
        }
        this.iyx = (ImageView) findViewById(2131756430);
        this.iyy = (EditText) findViewById(2131756431);
        this.iyx.setImageBitmap(this.mBmp);
        this.iyy.setText(stringExtra);
        findViewById(2131756432).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ConfirmScanBankCardResultUI iyz;

            {
                this.iyz = r1;
            }

            public final void onClick(View view) {
                if (this.iyz.iyy != null) {
                    String obj = this.iyz.iyy.getEditableText().toString();
                    if (!be.kS(obj)) {
                        mh mhVar = new mh();
                        mhVar.bnu.action = 1;
                        mhVar.bnu.cardNum = obj;
                        com.tencent.mm.sdk.c.a.nhr.z(mhVar);
                        super.finish();
                    }
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ConfirmScanBankCardResultUI iyz;

            {
                this.iyz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iyz.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iyx != null) {
            this.iyx.setImageBitmap(null);
        }
        if (!be.kS(this.iyv)) {
            iyw.remove(this.iyv);
        }
        if (this.mBmp != null) {
            this.mBmp.recycle();
        }
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(268435456);
        intent.setClass(this, BaseScanUI.class);
        startActivity(intent);
        super.finish();
    }

    protected final int getLayoutId() {
        return 2130903405;
    }

    protected final int NO() {
        return 1;
    }
}
