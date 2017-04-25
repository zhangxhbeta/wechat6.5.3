package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b {
    public Tag hHZ;
    public byte[] hIa = null;

    public boolean a(Tag tag) {
        this.hHZ = tag;
        if (tag != null) {
            this.hIa = tag.getId();
        }
        return true;
    }
}
