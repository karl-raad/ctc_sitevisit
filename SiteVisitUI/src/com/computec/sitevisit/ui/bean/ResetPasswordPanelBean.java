package com.computec.sitevisit.ui.bean;

import com.computec.sitevisit.model.common.SQLAuthenticatorAdapter;

import java.util.StringTokenizer;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

public class ResetPasswordPanelBean {
    private String newPassword;
    private String confirmPassword;
    private RichTable userTable;
    private String userName;
    private RichPopup popup;
    private String dialogTitle;

    public ResetPasswordPanelBean() {
    }

    public void resetPassword(DialogEvent dialogEvent) {
        SQLAuthenticatorAdapter adapter = new SQLAuthenticatorAdapter();
        adapter.connect();
        try {
            adapter.resetUserPassword(getUserName(), getNewPassword());
            adapter.close();
        } catch (Exception e) {
            e.printStackTrace();
            adapter.close();
        }
        getPopup().hide();
    }

    public void setUserTable(RichTable userTable) {
        this.userTable = userTable;
    }

    public RichTable getUserTable() {
        return userTable;
    }

    public void openPopupDialog() {
        setUserName(new StringTokenizer(userTable.getSelectedRowData().toString(), " ").nextToken());
        setDialogTitle("User " + getUserName() + " Password Reset");
        getPopup().show(new RichPopup.PopupHints());
    }

    public void setPopup(RichPopup popup) {
        this.popup = popup;
    }

    public RichPopup getPopup() {
        return popup;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    public String getDialogTitle() {
        return dialogTitle;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void newPasswordValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object.toString().length() < 8) {
            ((EditableValueHolder) uIComponent).setValid(false);
            facesContext.addMessage(uIComponent.getClientId(facesContext),
                                    new FacesMessage("Password must be at least 7 characters long."));
        }
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void confirmPasswordValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        String newPwd = getNewPassword();
        String confPwd = object.toString();
        if (!confPwd.equals(newPwd)) {
            ((EditableValueHolder) uIComponent).setValid(false);
            facesContext.addMessage(uIComponent.getClientId(facesContext),
                                    new FacesMessage("New Password does not match Confirm Password."));
        }
    }
}
