package com.computec.sitevisit.model.uiview;


import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Dec 01 10:44:24 EET 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UsersVORowImpl extends ViewRowImpl {


    public static final int ENTITY_USERSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        UName,
        UPassword,
        UDescription,
        Employee;
        private static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int UNAME = AttributesEnum.UName.index();
    public static final int UPASSWORD = AttributesEnum.UPassword.index();
    public static final int UDESCRIPTION = AttributesEnum.UDescription.index();
    public static final int EMPLOYEE = AttributesEnum.Employee.index();

    /**
     * This is the default constructor (do not remove).
     */
    public UsersVORowImpl() {
    }

    /**
     * Gets UsersEO entity object.
     * @return the UsersEO
     */
    public EntityImpl getUsersEO() {
        return (EntityImpl) getEntity(ENTITY_USERSEO);
    }

    /**
     * Gets the attribute value for U_NAME using the alias name UName.
     * @return the U_NAME
     */
    public String getUName() {
        return (String) getAttributeInternal(UNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for U_NAME using the alias name UName.
     * @param value value to set the U_NAME
     */
    public void setUName(String value) {
        setAttributeInternal(UNAME, value);
    }

    /**
     * Gets the attribute value for U_PASSWORD using the alias name UPassword.
     * @return the U_PASSWORD
     */
    public String getUPassword() {
        return (String) getAttributeInternal(UPASSWORD);
    }

    /**
     * Sets <code>value</code> as attribute value for U_PASSWORD using the alias name UPassword.
     * @param value value to set the U_PASSWORD
     */
    public void setUPassword(String value) {
//        DBLoginModuleSHA1Encoder pwEncoder = new DBLoginModuleSHA1Encoder();
//        String encodedPassword = pwEncoder.getKeyDigestString(value, null);
//        String wlsEncodedPassword = "{SHA-1}" + encodedPassword;
//        setAttributeInternal(UPASSWORD, wlsEncodedPassword);
        setAttributeInternal(UPASSWORD, value);
    }

    /**
     * Gets the attribute value for U_DESCRIPTION using the alias name UDescription.
     * @return the U_DESCRIPTION
     */
    public String getUDescription() {
        return (String) getAttributeInternal(UDESCRIPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for U_DESCRIPTION using the alias name UDescription.
     * @param value value to set the U_DESCRIPTION
     */
    public void setUDescription(String value) {
        setAttributeInternal(UDESCRIPTION, value);
    }


    /**
     * Gets the associated <code>ViewRowImpl</code> using master-detail link Employee.
     */
    public ViewRowImpl getEmployee() {
        return (ViewRowImpl) getAttributeInternal(EMPLOYEE);
    }

    /**
     * Sets the master-detail link Employee between this object and <code>value</code>.
     */
    public void setEmployee(ViewRowImpl value) {
        setAttributeInternal(EMPLOYEE, value);
    }
}

