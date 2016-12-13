package com.computec.sitevisit.ui.bean;

import com.computec.sitevisit.model.common.ADFUtil;
import com.computec.sitevisit.model.common.SQLAuthenticatorAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.event.DialogEvent;

public class CreateUserPanelBean {
    private String userName;
    private String password;
    private String firstName;
              
    public CreateUserPanelBean() {
    }

    public boolean validate(final String username){
            Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
            Matcher matcher = pattern.matcher(username);
            return matcher.matches();
    }

    public void createUser(DialogEvent dialogEvent) {
        SQLAuthenticatorAdapter adapter = new SQLAuthenticatorAdapter();
        adapter.connect();
        try {
            adapter.createUser(getUserName(), getPassword(), getFirstName());
            adapter.close();
            ADFUtil.invokeEL("#{bindings.Execute.execute}");
        } catch (Exception e) {
            e.printStackTrace();
            adapter.close();
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void userNameValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if(!validate(object.toString())) {
            ((EditableValueHolder) uIComponent).setValid(false);
            facesContext.addMessage(uIComponent.getClientId(facesContext),
                                    new FacesMessage("User Name must contain 3 to 15 alphanumerical characters with optional '_' or '-'"));
        }
    }

    public void passwordValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object.toString().length() < 8) {
            ((EditableValueHolder) uIComponent).setValid(false);
            facesContext.addMessage(uIComponent.getClientId(facesContext),
                                    new FacesMessage("Password must be at least 7 characters long."));
        }
    }
}
