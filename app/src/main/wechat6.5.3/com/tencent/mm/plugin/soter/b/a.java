package com.tencent.mm.plugin.soter.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.sdk.platformtools.v;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public abstract class a {

    static class a extends a {
        public final AlgorithmParameterSpec aYH() {
            return null;
        }

        public final a v(String... strArr) {
            return null;
        }

        public final a w(String... strArr) {
            return null;
        }

        public final a aYI() {
            return null;
        }
    }

    @TargetApi(23)
    static class b extends a {
        private Builder kcI = null;

        public b(String str, int i) {
            this.kcI = new Builder(str, 4);
        }

        public final AlgorithmParameterSpec aYH() {
            return this.kcI.build();
        }

        public final a v(String... strArr) {
            this.kcI.setDigests(strArr);
            return this;
        }

        public final a w(String... strArr) {
            this.kcI.setSignaturePaddings(strArr);
            return this;
        }

        public final a aYI() {
            this.kcI.setUserAuthenticationRequired(true);
            return this;
        }
    }

    static class c extends a {
        private final String kcJ;
        private int kcK;
        private int kcL = -1;
        private AlgorithmParameterSpec kcM;
        private X500Principal kcN;
        private BigInteger kcO;
        private Date kcP;
        private Date kcQ;
        private Date kcR;
        private Date kcS;
        private Date kcT;
        private String[] kcU;
        private String[] kcV;
        private String[] kcW;
        private String[] kcX;
        private boolean kcY = true;
        private boolean kcZ;
        private int kda = -1;

        public c(String str, int i) {
            if (str == null) {
                throw new NullPointerException("keystoreAlias == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            } else {
                this.kcJ = str;
                this.kcK = 4;
            }
        }

        public final a v(String... strArr) {
            this.kcU = a.x(strArr);
            return this;
        }

        public final a w(String... strArr) {
            this.kcW = a.x(strArr);
            return this;
        }

        public final a aYI() {
            this.kcZ = true;
            return this;
        }

        public final AlgorithmParameterSpec aYH() {
            return (AlgorithmParameterSpec) Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[]{String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, String[].class, String[].class, String[].class, String[].class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE}).newInstance(new Object[]{this.kcJ, Integer.valueOf(this.kcL), this.kcM, this.kcN, this.kcO, this.kcP, this.kcQ, this.kcR, this.kcS, this.kcT, Integer.valueOf(this.kcK), this.kcU, this.kcV, this.kcW, this.kcX, Boolean.valueOf(this.kcY), Boolean.valueOf(this.kcZ), Integer.valueOf(this.kda)});
        }
    }

    public abstract AlgorithmParameterSpec aYH();

    public abstract a aYI();

    public abstract a v(String... strArr);

    public abstract a w(String... strArr);

    public static a Ci(String str) {
        if (!k.gA(false)) {
            v.e("MicroMsg.KeyGenParameterSpecCompactBuilder", "hy: not support soter. return dummy");
            return new a();
        } else if (VERSION.SDK_INT >= 23) {
            return new b(str, 4);
        } else {
            return new c(str, 4);
        }
    }

    public static String[] x(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}
