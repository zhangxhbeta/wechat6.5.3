package com.google.android.gms.analytics.internal;

public final class ak extends ab<b> {

    private static class a implements com.google.android.gms.analytics.internal.ab.a<b> {
        private final q afY;
        private final b aiW = new b();

        public a(q qVar) {
            this.afY = qVar;
        }

        public final void c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.aiW.afK = z ? 1 : 0;
                return;
            }
            this.afY.hZ().f("Bool xml configuration name not recognized", str);
        }

        public final void d(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.aiW.afJ = i;
            } else {
                this.afY.hZ().f("Int xml configuration name not recognized", str);
            }
        }

        public final void g(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.aiW.afG = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.aiW.afH = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.aiW.afI = str2;
            } else {
                this.afY.hZ().f("String xml configuration name not recognized", str);
            }
        }

        public final /* synthetic */ aa iA() {
            return this.aiW;
        }
    }

    public ak(q qVar) {
        super(qVar, new a(qVar));
    }
}
