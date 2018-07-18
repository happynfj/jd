package cn.nfg.mweb.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/7/16 10:35
 * @Description:
 */
public class MySessionListener implements HttpSessionListener {
    /**
     * 创建session,用户会话
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session出生了");
        //获取在线用户session集合
        Map<String,HttpSession> onLines = (Map<String, HttpSession>) se.getSession().getServletContext().getAttribute("onLine");
        if(onLines == null){
            onLines = Collections.synchronizedMap(new HashMap<String,HttpSession>());
            se.getSession().getServletContext().setAttribute("onLine",onLines);
        }
        onLines.put(se.getSession().getId(),se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session死了");
        Map<String,HttpSession> onLines = (Map<String, HttpSession>) se.getSession().getServletContext().getAttribute("onLine");
        if(onLines.containsKey(se.getSession().getId())){
            onLines.remove(se.getSession().getId());
        }
    }
}
