package b.a.c;

import b.a.b.b;
import b.a.d.i;
import b.a.g.c;
import b.a.g.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g implements a, f {
    private static final Pattern pOW = Pattern.compile("oauth_token=([^&]+)");
    private static final Pattern pOX = Pattern.compile("oauth_token_secret=([^&]*)");

    public final i Rd(String str) {
        d.es(str, "Response body is incorrect. Can't extract a token from an empty string");
        return new i(b(str, pOW), b(str, pOX), str);
    }

    private static String b(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() > 0) {
            return c.decode(matcher.group(1));
        }
        throw new b("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", null);
    }
}
