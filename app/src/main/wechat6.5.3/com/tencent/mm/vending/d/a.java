package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;

public final class a {
    Bundle mExtras = null;

    public a(Intent intent) {
        this.mExtras = intent.getExtras();
    }

    public final int getIntExtra(String str, int i) {
        if (this.mExtras == null) {
            return i;
        }
        return this.mExtras.getInt(str, i);
    }

    public final String getStringExtra(String str) {
        return this.mExtras == null ? null : this.mExtras.getString(str);
    }
}
