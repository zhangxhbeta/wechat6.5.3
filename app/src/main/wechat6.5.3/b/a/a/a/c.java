package b.a.a.a;

import b.a.d.i;

public class c extends b {

    public static class a extends c {
        public final String bRj() {
            return "https://api.twitter.com/oauth/access_token";
        }

        public final String bRi() {
            return "https://api.twitter.com/oauth/request_token";
        }
    }

    public String bRj() {
        return "http://api.twitter.com/oauth/access_token";
    }

    public String bRi() {
        return "http://api.twitter.com/oauth/request_token";
    }

    public final String b(i iVar) {
        return String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[]{iVar.token});
    }
}
