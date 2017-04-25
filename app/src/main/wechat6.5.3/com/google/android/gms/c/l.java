package com.google.android.gms.c;

import android.graphics.drawable.Drawable;
import java.util.Arrays;

public final class l extends o<a, Drawable> {

    public static final class a {
        public final int ayj;
        public final int ayk;

        public a(int i, int i2) {
            this.ayj = i;
            this.ayk = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return aVar.ayj == this.ayj && aVar.ayk == this.ayk;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.ayj), Integer.valueOf(this.ayk)});
        }
    }
}
