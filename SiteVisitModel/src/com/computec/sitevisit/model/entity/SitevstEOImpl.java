package com.computec.sitevisit.model.entity;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Oct 17 16:43:31 EEST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SitevstEOImpl extends EntityImpl {
    /**
     * Validation method for HrTo.
     */
    public boolean validateHrTo(String hrto) {
        String hrFrm = getHrFrm();
        String minFrm = getMinFrm();
        String minTo = getMinTo();
        if (hrFrm != null && minFrm != null && minTo != null)
            if (Long.parseLong(hrFrm) * 60 + Long.parseLong(minFrm) >=
                Long.parseLong(hrto) * 60 + Long.parseLong(minTo))
                return false;
        setTimeTo(hrto + ":" + minTo);
        return true;
    }

    /**
     * Validation method for HrFrm.
     */
    public boolean validateHrFrm(String hrfrm) {
        String minFrm = getMinFrm();
        String hrTo = getHrTo();
        String minTo = getMinTo();
        if (minFrm != null && hrTo != null && minTo != null)
                if (Long.parseLong(hrfrm) * 60 + Long.parseLong(minFrm) >=
                    Long.parseLong(hrTo) * 60 + Long.parseLong(minTo))
                    return false;
        setTimeFrm(hrfrm + ":" + minFrm);
        return true;
    }

    /**
     * Validation method for MinFrm.
     */
    public boolean validateMinFrm(String minfrm) {
        String hrFrm = getHrFrm();
        String hrTo = getHrTo();
        String minTo = getMinTo();
        if (hrFrm != null && hrTo != null && minTo != null)
                if (Long.parseLong(hrFrm) * 60 + Long.parseLong(minfrm) >=
                    Long.parseLong(hrTo) * 60 + Long.parseLong(minTo))
                    return false;
        setTimeFrm(hrFrm + ":" + minfrm);
        return true;
    }

    /**
     * Validation method for MinTo.
     */
    public boolean validateMinTo(String minto) {
        String hrFrm = getHrFrm();
        String minFrm = getMinFrm();
        String hrTo = getHrTo();
        if (hrFrm != null && minFrm != null && hrTo != null)
            if (Long.parseLong(hrFrm) * 60 + Long.parseLong(minFrm) >=
                Long.parseLong(hrTo) * 60 + Long.parseLong(minto))
                return false;
        setTimeTo(hrTo + ":" + minto);
        return true;
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        SitevstId,
        Soccode,
        Bracode,
        Batchno,
        DateVst,
        Empno,
        Clino,
        TimeFrm,
        TimeTo,
        CliRsp,
        VstPeriod,
        Sheetno,
        HrFrm,
        MinFrm,
        HrTo,
        MinTo,
        TtlHrs,
        TtlRatedHrs,
        Remarks,
        Client,
        Employee,
        Work;
        private static AttributesEnum[] vals = null;
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


    public static final int SITEVSTID = AttributesEnum.SitevstId.index();
    public static final int SOCCODE = AttributesEnum.Soccode.index();
    public static final int BRACODE = AttributesEnum.Bracode.index();
    public static final int BATCHNO = AttributesEnum.Batchno.index();
    public static final int DATEVST = AttributesEnum.DateVst.index();
    public static final int EMPNO = AttributesEnum.Empno.index();
    public static final int CLINO = AttributesEnum.Clino.index();
    public static final int TIMEFRM = AttributesEnum.TimeFrm.index();
    public static final int TIMETO = AttributesEnum.TimeTo.index();
    public static final int CLIRSP = AttributesEnum.CliRsp.index();
    public static final int VSTPERIOD = AttributesEnum.VstPeriod.index();
    public static final int SHEETNO = AttributesEnum.Sheetno.index();
    public static final int HRFRM = AttributesEnum.HrFrm.index();
    public static final int MINFRM = AttributesEnum.MinFrm.index();
    public static final int HRTO = AttributesEnum.HrTo.index();
    public static final int MINTO = AttributesEnum.MinTo.index();
    public static final int TTLHRS = AttributesEnum.TtlHrs.index();
    public static final int TTLRATEDHRS = AttributesEnum.TtlRatedHrs.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int CLIENT = AttributesEnum.Client.index();
    public static final int EMPLOYEE = AttributesEnum.Employee.index();
    public static final int WORK = AttributesEnum.Work.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SitevstEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.computec.sitevisit.model.entity.SitevstEO");
    }


    /**
     * Gets the attribute value for SitevstId, using the alias name SitevstId.
     * @return the value of SitevstId
     */
    public DBSequence getSitevstId() {
        return (DBSequence) getAttributeInternal(SITEVSTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SitevstId.
     * @param value value to set the SitevstId
     */
    public void setSitevstId(DBSequence value) {
        setAttributeInternal(SITEVSTID, value);
    }

    /**
     * Gets the attribute value for Soccode, using the alias name Soccode.
     * @return the value of Soccode
     */
    public String getSoccode() {
        return (String) getAttributeInternal(SOCCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Soccode.
     * @param value value to set the Soccode
     */
    public void setSoccode(String value) {
        setAttributeInternal(SOCCODE, value);
    }

    /**
     * Gets the attribute value for Bracode, using the alias name Bracode.
     * @return the value of Bracode
     */
    public String getBracode() {
        return (String) getAttributeInternal(BRACODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Bracode.
     * @param value value to set the Bracode
     */
    public void setBracode(String value) {
        setAttributeInternal(BRACODE, value);
    }

    /**
     * Gets the attribute value for Batchno, using the alias name Batchno.
     * @return the value of Batchno
     */
    public String getBatchno() {
        return (String) getAttributeInternal(BATCHNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Batchno.
     * @param value value to set the Batchno
     */
    public void setBatchno(String value) {
        setAttributeInternal(BATCHNO, value);
    }

    /**
     * Gets the attribute value for DateVst, using the alias name DateVst.
     * @return the value of DateVst
     */
    public Timestamp getDateVst() {
        return (Timestamp) getAttributeInternal(DATEVST);
    }

    /**
     * Sets <code>value</code> as the attribute value for DateVst.
     * @param value value to set the DateVst
     */
    public void setDateVst(Timestamp value) {
        setAttributeInternal(DATEVST, value);
    }

    /**
     * Gets the attribute value for Empno, using the alias name Empno.
     * @return the value of Empno
     */
    public String getEmpno() {
        return (String) getAttributeInternal(EMPNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Empno.
     * @param value value to set the Empno
     */
    public void setEmpno(String value) {
        setAttributeInternal(EMPNO, value);
    }

    /**
     * Gets the attribute value for Clino, using the alias name Clino.
     * @return the value of Clino
     */
    public String getClino() {
        return (String) getAttributeInternal(CLINO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Clino.
     * @param value value to set the Clino
     */
    public void setClino(String value) {
        setAttributeInternal(CLINO, value);
    }

    /**
     * Gets the attribute value for TimeFrm, using the alias name TimeFrm.
     * @return the value of TimeFrm
     */
    public String getTimeFrm() {
        return (String) getAttributeInternal(TIMEFRM);
    }

    /**
     * Sets <code>value</code> as the attribute value for TimeFrm.
     * @param value value to set the TimeFrm
     */
    public void setTimeFrm(String value) {
        setAttributeInternal(TIMEFRM, value);
    }

    /**
     * Gets the attribute value for TimeTo, using the alias name TimeTo.
     * @return the value of TimeTo
     */
    public String getTimeTo() {
        return (String) getAttributeInternal(TIMETO);
    }

    /**
     * Sets <code>value</code> as the attribute value for TimeTo.
     * @param value value to set the TimeTo
     */
    public void setTimeTo(String value) {
        setAttributeInternal(TIMETO, value);
    }

    /**
     * Gets the attribute value for CliRsp, using the alias name CliRsp.
     * @return the value of CliRsp
     */
    public String getCliRsp() {
        return (String) getAttributeInternal(CLIRSP);
    }

    /**
     * Sets <code>value</code> as the attribute value for CliRsp.
     * @param value value to set the CliRsp
     */
    public void setCliRsp(String value) {
        setAttributeInternal(CLIRSP, value);
    }

    /**
     * Gets the attribute value for VstPeriod, using the alias name VstPeriod.
     * @return the value of VstPeriod
     */
    public String getVstPeriod() {
        return (String) getAttributeInternal(VSTPERIOD);
    }

    /**
     * Sets <code>value</code> as the attribute value for VstPeriod.
     * @param value value to set the VstPeriod
     */
    public void setVstPeriod(String value) {
        setAttributeInternal(VSTPERIOD, value);
    }

    /**
     * Gets the attribute value for Sheetno, using the alias name Sheetno.
     * @return the value of Sheetno
     */
    public Long getSheetno() {
        return (Long) getAttributeInternal(SHEETNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Sheetno.
     * @param value value to set the Sheetno
     */
    public void setSheetno(Long value) {
        setAttributeInternal(SHEETNO, value);
    }

    /**
     * Gets the attribute value for HrFrm, using the alias name HrFrm.
     * @return the value of HrFrm
     */
    public String getHrFrm() {
        return (String) getAttributeInternal(HRFRM);
    }

    /**
     * Sets <code>value</code> as the attribute value for HrFrm.
     * @param value value to set the HrFrm
     */
    public void setHrFrm(String value) {
        setAttributeInternal(HRFRM, value);
    }

    /**
     * Gets the attribute value for MinFrm, using the alias name MinFrm.
     * @return the value of MinFrm
     */
    public String getMinFrm() {
        return (String) getAttributeInternal(MINFRM);
    }

    /**
     * Sets <code>value</code> as the attribute value for MinFrm.
     * @param value value to set the MinFrm
     */
    public void setMinFrm(String value) {
        setAttributeInternal(MINFRM, value);
    }

    /**
     * Gets the attribute value for HrTo, using the alias name HrTo.
     * @return the value of HrTo
     */
    public String getHrTo() {
        return (String) getAttributeInternal(HRTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for HrTo.
     * @param value value to set the HrTo
     */
    public void setHrTo(String value) {
        setAttributeInternal(HRTO, value);
    }

    /**
     * Gets the attribute value for MinTo, using the alias name MinTo.
     * @return the value of MinTo
     */
    public String getMinTo() {
        return (String) getAttributeInternal(MINTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for MinTo.
     * @param value value to set the MinTo
     */
    public void setMinTo(String value) {
        setAttributeInternal(MINTO, value);
    }


    /**
     * Gets the attribute value for TtlHr, using the alias name TtlHr.
     * @return the value of TtlHr
     */
    public BigDecimal getTtlHrs() {
        return (BigDecimal) getAttributeInternal(TTLHRS);
    }

    /**
     * Sets <code>value</code> as the attribute value for TtlHr.
     * @param value value to set the TtlHr
     */
    public void setTtlHrs(BigDecimal value) {
        setAttributeInternal(TTLHRS, value);
    }

    /**
     * Gets the attribute value for TtlHrRat, using the alias name TtlHrRat.
     * @return the value of TtlHrRat
     */
    public BigDecimal getTtlRatedHrs() {
        return (BigDecimal) getAttributeInternal(TTLRATEDHRS);
    }

    /**
     * Sets <code>value</code> as the attribute value for TtlHrRat.
     * @param value value to set the TtlHrRat
     */
    public void setTtlRatedHrs(BigDecimal value) {
        setAttributeInternal(TTLRATEDHRS, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the value of Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getClient() {
        return (EntityImpl) getAttributeInternal(CLIENT);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setClient(EntityImpl value) {
        setAttributeInternal(CLIENT, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getEmployee() {
        return (EntityImpl) getAttributeInternal(EMPLOYEE);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setEmployee(EntityImpl value) {
        setAttributeInternal(EMPLOYEE, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getWork() {
        return (RowIterator) getAttributeInternal(WORK);
    }

    /**
     * @param sitevstId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence sitevstId) {
        return new Key(new Object[] { sitevstId });
    }


}

