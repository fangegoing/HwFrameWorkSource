package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

@Deprecated
final class SoundexUtils {
    SoundexUtils() {
    }

    static String clean(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int len = str.length();
        char[] chars = new char[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(str.charAt(i))) {
                int count2 = count + 1;
                chars[count] = str.charAt(i);
                count = count2;
            }
        }
        if (count == len) {
            return str.toUpperCase();
        }
        return new String(chars, 0, count).toUpperCase();
    }

    static int difference(StringEncoder encoder, String s1, String s2) throws EncoderException {
        return differenceEncoded(encoder.encode(s1), encoder.encode(s2));
    }

    static int differenceEncoded(String es1, String es2) {
        int i = 0;
        if (es1 == null || es2 == null) {
            return 0;
        }
        int lengthToMatch = Math.min(es1.length(), es2.length());
        int diff = 0;
        while (i < lengthToMatch) {
            if (es1.charAt(i) == es2.charAt(i)) {
                diff++;
            }
            i++;
        }
        return diff;
    }
}
