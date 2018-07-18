package cn.nfg.mweb.filter;

import cn.nfj.mservice.entity.SysUser;
import cn.nfj.mservice.entity.SysUserOnline;
import cn.nfj.mservice.mapper.SysUserOnlineMapper;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2018/7/16 17:47
 * @Description:
 */
public class OnlineFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println(req.getSession().getId());
        if(req.getSession().getAttribute("user") != null){
            setOnline(req);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    private void setOnline(HttpServletRequest req) throws UnknownHostException {
        if(req.getSession().getAttribute("online") != null){
            SysUserOnline online = (SysUserOnline) req.getSession().getAttribute("online");
            online.setLastAccessTime(new Date());
        }else {
            SysUserOnline online = new SysUserOnline();
            UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
            // 浏览器
            Browser browser = userAgent.getBrowser();
            // ip 地址
            String ip = InetAddress.getLocalHost().getHostAddress();
            // 操作系统
            OperatingSystem os = userAgent.getOperatingSystem();
            SysUser user = (SysUser) req.getSession().getAttribute("user");
            online.setBrowser(browser.toString());
            online.setIpaddr(ip);
            online.setOs(os.toString());
            online.setSessionid(req.getSession().getId());
            online.setLoginName(user.getLoginName());
            online.setStartTimestsamp(new Date());
            online.setStatus("on_line");
            req.getSession().setAttribute("online",online);
        }
    }
}
