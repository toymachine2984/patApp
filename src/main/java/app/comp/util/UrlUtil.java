package app.comp.util;

import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

public class UrlUtil {

    public static String encodeUrlPathSegment(String pathSegment, HttpServletRequest request) {
        String enc = request.getCharacterEncoding() != null ? request.getCharacterEncoding() : WebUtils.DEFAULT_CHARACTER_ENCODING;
        return UriUtils.encodePathSegment(pathSegment, enc);
    }
}
