package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mmdb.database.SQLiteDatabase;

@a(7)
public class TaskRedirectUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, LauncherUI.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }
}
