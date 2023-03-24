package leetcode.p1400.p1472;

public class BrowserHistory {
    public BrowserHistory(String homepage) {
        cur = new Page(homepage);
    }

    public void visit(String url) {
        Page newPage = new Page(url);
        cur.next = newPage;
        newPage.prev = cur;

        cur = newPage;
    }

    public String back(int steps) {
        while (steps-- > 0) {
            if (cur.prev != null) cur = cur.prev;
        }

        return cur.s;
    }

    public String forward(int steps) {
        while (steps-- > 0) {
            if (cur.next != null) cur = cur.next;
        }
        return cur.s;
    }

    private Page cur;

    public static class Page {
        Page next;
        Page prev;
        String s;

        Page(String s1) {
            s = s1;
        }
    }
}
