package com.tencent.mm.ui.e.a;

import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a {
    c oNa;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String oNb;
        final /* synthetic */ Bundle oNc;
        final /* synthetic */ String oNd;
        final /* synthetic */ a oNe;
        final /* synthetic */ Object oNf = null;
        final /* synthetic */ a oNg;

        public AnonymousClass1(a aVar, String str, Bundle bundle, String str2, a aVar2, Object obj) {
            this.oNg = aVar;
            this.oNb = str;
            this.oNc = bundle;
            this.oNd = str2;
            this.oNe = aVar2;
        }

        public final void run() {
            try {
                this.oNe.Oh(this.oNg.oNa.a(this.oNb, this.oNc, this.oNd));
            } catch (FileNotFoundException e) {
                this.oNe.a(e);
            } catch (MalformedURLException e2) {
                this.oNe.a(e2);
            } catch (IOException e3) {
                this.oNe.a(e3);
            }
        }
    }

    public interface a {
        void Oh(String str);

        void a(FileNotFoundException fileNotFoundException);

        void a(IOException iOException);

        void a(MalformedURLException malformedURLException);
    }

    public a(c cVar) {
        this.oNa = cVar;
    }
}
