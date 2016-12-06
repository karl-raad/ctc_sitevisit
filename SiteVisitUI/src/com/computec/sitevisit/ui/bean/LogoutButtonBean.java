package com.computec.sitevisit.ui.bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import weblogic.servlet.security.ServletAuthentication;

public class LogoutButtonBean {
    public void onLogout() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        String url = ectx.getRequestContextPath() + "/adfAuthentication?logout=true&end_url=/faces/Visits.jspx";
        HttpSession session = (HttpSession) ectx.getSession(false);
        session.invalidate();
        HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
        ServletAuthentication.logout(request);
        ServletAuthentication.invalidateAll(request);
        ServletAuthentication.killCookie(request);

        try {
            ectx.redirect(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fctx.responseComplete();
    }
}
