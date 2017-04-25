package b.a.e;

import b.a.a.a.b;
import b.a.c.e;
import b.a.d.c;
import b.a.d.g;
import b.a.d.h;
import b.a.d.i;
import b.a.d.j;
import b.a.d.k;
import b.a.f.d;
import java.util.Map.Entry;

public final class a implements b {
    private static /* synthetic */ int[] pPA;
    private b.a.d.a pPy;
    private b pPz;

    private static /* synthetic */ int[] bRu() {
        int[] iArr = pPA;
        if (iArr == null) {
            iArr = new int[h.values().length];
            try {
                iArr[h.Header.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[h.QueryString.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            pPA = iArr;
        }
        return iArr;
    }

    public a(b bVar, b.a.d.a aVar) {
        this.pPz = bVar;
        this.pPy = aVar;
    }

    public final i bRt() {
        this.pPy.sP("obtaining request token from " + this.pPz.bRi());
        c cVar = new c(j.POST, this.pPz.bRi());
        this.pPy.sP("setting oauth_callback to " + this.pPy.pOS);
        cVar.eq("oauth_callback", this.pPy.pOS);
        a(cVar, b.a.d.b.pOY);
        b(cVar);
        this.pPy.sP("sending request...");
        g bRo = cVar.bRo();
        String body = bRo.getBody();
        this.pPy.sP("response status code: " + bRo.aJW);
        this.pPy.sP("response body: " + body);
        return new b.a.c.g().Rd(body);
    }

    private void a(c cVar, i iVar) {
        cVar.eq("oauth_timestamp", new d().bRw());
        cVar.eq("oauth_nonce", new d().getNonce());
        cVar.eq("oauth_consumer_key", this.pPy.pOQ);
        cVar.eq("oauth_signature_method", new b.a.f.a().bRv());
        cVar.eq("oauth_version", "1.0");
        if ((this.pPy.mEw != null ? 1 : null) != null) {
            cVar.eq("scope", this.pPy.mEw);
        }
        this.pPy.sP("generating signature...");
        String a = new b.a.c.c().a(cVar);
        String ac = new b.a.f.a().ac(a, this.pPy.pOR, iVar.mIu);
        this.pPy.sP("base string is: " + a);
        this.pPy.sP("signature is: " + ac);
        cVar.eq("oauth_signature", ac);
        this.pPy.sP("appended additional OAuth parameters: " + b.a.g.b.ab(cVar.pOZ));
    }

    public final i a(i iVar, k kVar) {
        this.pPy.sP("obtaining access token from " + this.pPz.bRj());
        c cVar = new c(j.POST, this.pPz.bRj());
        cVar.eq("oauth_token", iVar.token);
        cVar.eq("oauth_verifier", kVar.value);
        this.pPy.sP("setting token to: " + iVar + " and verifier to: " + kVar);
        a(cVar, iVar);
        b(cVar);
        return new b.a.c.g().Rd(cVar.bRo().getBody());
    }

    public final void a(i iVar, c cVar) {
        this.pPy.sP("signing request: " + cVar.bRm());
        Object obj = ("".equals(iVar.token) && "".equals(iVar.mIu)) ? 1 : null;
        if (obj == null) {
            cVar.eq("oauth_token", iVar.token);
        }
        this.pPy.sP("setting token to: " + iVar);
        a(cVar, iVar);
        b(cVar);
    }

    public final String b(i iVar) {
        return this.pPz.b(iVar);
    }

    private void b(c cVar) {
        switch (bRu()[this.pPy.pOU.ordinal()]) {
            case 1:
                this.pPy.sP("using Http Header signature");
                cVar.addHeader("Authorization", new e().a(cVar));
                return;
            case 2:
                this.pPy.sP("using Querystring signature");
                for (Entry entry : cVar.pOZ.entrySet()) {
                    cVar.er((String) entry.getKey(), (String) entry.getValue());
                }
                return;
            default:
                return;
        }
    }
}
