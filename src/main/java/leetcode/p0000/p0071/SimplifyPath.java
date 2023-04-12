package leetcode.p0000.p0071;

import java.util.*;
import java.util.stream.Collectors;

public class SimplifyPath {
    public String simplifyPath(String path) {
        var split = path.split("/");
        var list = new ArrayList<String>();
        for (var s : split) {
            if ("..".equals(s)) {
                if (list.size() > 0) list.remove(list.size() - 1);
            } else if (!"".equals(s) && !".".equals(s)) list.add(s);
        }
        return "/" + String.join("/", list);
    }
}
