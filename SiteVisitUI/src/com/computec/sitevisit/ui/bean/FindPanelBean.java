package com.computec.sitevisit.ui.bean;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;


public class FindPanelBean {
    private RichPanelHeader visitForm;
    private RichPopup findPopup;

    public FindPanelBean() {
    }

    public void setVisitForm(RichPanelHeader visitForm) {
        this.visitForm = visitForm;
    }

    public RichPanelHeader getVisitForm() {
        return visitForm;
    }

    public Object processMethodExpression(String methodExpression, Object event, Class eventClass) {
        return processMethodExpression(methodExpression, new Object[] { event }, new Class[] { eventClass });
    }

    private Object processMethodExpression(String methodExpression, Object[] parameters, Class[] expectedParamTypes) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ELContext elctx = fctx.getELContext();
        Application app = fctx.getApplication();
        ExpressionFactory exprFactory = app.getExpressionFactory();
        MethodExpression methodExpr =
            exprFactory.createMethodExpression(elctx, methodExpression, Object.class, expectedParamTypes);
        return methodExpr.invoke(elctx, parameters);
    }

    public void onQuery(QueryEvent queryEvent) {
        //preserve default query behavior, accessing the ADF binding layer
        String mexpr = "#{bindings.DefaultCriteriaQuery.processQuery}";
        processMethodExpression(mexpr, queryEvent, QueryEvent.class);
        //close dialog
        findPopup.hide();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(visitForm);
    }

    public void setFindPopup(RichPopup findPopup) {
        this.findPopup = findPopup;
    }

    public RichPopup getFindPopup() {
        return findPopup;
    }
}
