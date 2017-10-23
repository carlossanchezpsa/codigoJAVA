/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MsgDealerTypeDescriptor.java,v 1.1 2008/01/11 17:12:11 e243060 Exp $
 */

package com.inetpsa.boz.rpv.rp.xml;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.StringValidator;

/**
 * Class MsgDealerTypeDescriptor.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/11 17:12:11 $
 */
public class MsgSubsidiaryTypeDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field nsPrefix
	 */
	private java.lang.String nsPrefix;

	/**
	 * Field nsURI
	 */
	private java.lang.String nsURI;

	/**
	 * Field xmlName
	 */
	private java.lang.String xmlName;

	/**
	 * Field identity
	 */
	private org.exolab.castor.xml.XMLFieldDescriptor identity;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public MsgSubsidiaryTypeDescriptor() {
		super();
		xmlName = "MsgSubsidiaryType";

		// -- set grouping compositor
		setCompositorAsSequence();
		org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
		org.exolab.castor.mapping.FieldHandler handler = null;
		org.exolab.castor.xml.FieldValidator fieldValidator = null;
		// -- initialize attribute descriptors

		// -- initialize element descriptors

		// -- _COUNTRY_CODE
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_COUNTRY_CODE", "COUNTRY_CODE",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				MsgSubsidiaryType target = (MsgSubsidiaryType) object;
				return target.getCOUNTRY_CODE();
			}

			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					MsgSubsidiaryType target = (MsgSubsidiaryType) object;
					target.setCOUNTRY_CODE((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _COUNTRY_CODE
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			// typeValidator.setMinLength(1);
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_AP_AC", "AP_AC",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				MsgSubsidiaryType target = (MsgSubsidiaryType) object;
				return target.getAP_AC();
			}

			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					MsgSubsidiaryType target = (MsgSubsidiaryType) object;
					target.setAP_AC((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _AP_AC
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			// typeValidator.setMinLength(1);
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);
		// -- _AP_AC
		/*
		 * desc = new
		 * org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.inetpsa
		 * .boz.rpv.rp.xml.types.MarquePSAType.class, "_AP_AC", "AP_AC",
		 * org.exolab.castor.xml.NodeType.Element); handler = new
		 * org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
		 * getValue(java.lang.Object object) throws IllegalStateException {
		 * MsgSubsidiaryType target = (MsgSubsidiaryType) object; return
		 * target.getAP_AC(); }
		 * 
		 * public void setValue(java.lang.Object object, java.lang.Object value)
		 * throws IllegalStateException, IllegalArgumentException { try {
		 * MsgSubsidiaryType target = (MsgSubsidiaryType) object;
		 * target.setAP_AC((com.inetpsa.boz.rpv.rp.xml.types.MarquePSAType)
		 * value); } catch (java.lang.Exception ex) { throw new
		 * IllegalStateException(ex.toString()); } }
		 * 
		 * public java.lang.Object newInstance(java.lang.Object parent) { return
		 * null; } }; handler = new
		 * org.exolab.castor.xml.handlers.EnumFieldHandler
		 * (com.inetpsa.boz.rpv.rp.xml.types.MarquePSAType.class, handler);
		 * desc.setImmutable(true); desc.setHandler(handler);
		 * desc.setRequired(true); desc.setMultivalued(false);
		 * addFieldDescriptor(desc);
		 * 
		 * // -- validation code for: _AP_AC fieldValidator = new
		 * org.exolab.castor.xml.FieldValidator();
		 * fieldValidator.setMinOccurs(1); { // -- local scope }
		 * desc.setValidator(fieldValidator);
		 */

		// -- _DEALERList
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.inetpsa.boz.rpv.rp.xml.DEALER.class, "_DEALERList", "DEALER",
				org.exolab.castor.xml.NodeType.Element);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				MsgSubsidiaryType target = (MsgSubsidiaryType) object;
				return target.getDEALER();
			}

			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					MsgSubsidiaryType target = (MsgSubsidiaryType) object;
					target.addDEALER((com.inetpsa.boz.rpv.rp.xml.DEALER) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return new com.inetpsa.boz.rpv.rp.xml.DEALER();
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(true);
		addFieldDescriptor(desc);

		// -- validation code for: _DEALERList
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(0);
		{ // -- local scope
		}
		desc.setValidator(fieldValidator);
		// -- _INDIVIDUALList
		/*
		 * desc = new
		 * org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.inetpsa
		 * .boz.rpv.opp.xml.INDIVIDUAL.class, "_INDIVIDUALList", "INDIVIDUAL",
		 * org.exolab.castor.xml.NodeType.Element); handler = new
		 * org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
		 * getValue( java.lang.Object object ) throws IllegalStateException {
		 * MsgDealerType target = (MsgDealerType) object; return
		 * target.getINDIVIDUAL(); } public void setValue( java.lang.Object
		 * object, java.lang.Object value) throws IllegalStateException,
		 * IllegalArgumentException { try { MsgDealerType target =
		 * (MsgDealerType) object; target.addINDIVIDUAL(
		 * (com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL) value); } catch
		 * (java.lang.Exception ex) { throw new
		 * IllegalStateException(ex.toString()); } } public java.lang.Object
		 * newInstance( java.lang.Object parent ) { return new
		 * com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL(); } };
		 * desc.setHandler(handler); desc.setMultivalued(true);
		 * addFieldDescriptor(desc);
		 * 
		 * //-- validation code for: _INDIVIDUALList fieldValidator = new
		 * org.exolab.castor.xml.FieldValidator();
		 * fieldValidator.setMinOccurs(0); { //-- local scope }
		 * desc.setValidator(fieldValidator);
		 */
	} // -- com.inetpsa.boz.rpv.xml.MsgDealerTypeDescriptor()

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method getAccessMode
	 * 
	 * 
	 * 
	 * @return AccessMode
	 */
	public org.exolab.castor.mapping.AccessMode getAccessMode() {
		return null;
	} // -- org.exolab.castor.mapping.AccessMode getAccessMode()

	/**
	 * Method getExtends
	 * 
	 * 
	 * 
	 * @return ClassDescriptor
	 */
	public org.exolab.castor.mapping.ClassDescriptor getExtends() {
		return null;
	} // -- org.exolab.castor.mapping.ClassDescriptor getExtends()

	/**
	 * Method getIdentity
	 * 
	 * 
	 * 
	 * @return FieldDescriptor
	 */
	public org.exolab.castor.mapping.FieldDescriptor getIdentity() {
		return identity;
	} // -- org.exolab.castor.mapping.FieldDescriptor getIdentity()

	/**
	 * Method getJavaClass
	 * 
	 * 
	 * 
	 * @return Class
	 */
	public java.lang.Class getJavaClass() {
		return com.inetpsa.boz.rpv.rp.xml.MsgSubsidiaryType.class;
	} // -- java.lang.Class getJavaClass()

	/**
	 * Method getNameSpacePrefix
	 * 
	 * 
	 * 
	 * @return String
	 */
	public java.lang.String getNameSpacePrefix() {
		return nsPrefix;
	} // -- java.lang.String getNameSpacePrefix()

	/**
	 * Method getNameSpaceURI
	 * 
	 * 
	 * 
	 * @return String
	 */
	public java.lang.String getNameSpaceURI() {
		return nsURI;
	} // -- java.lang.String getNameSpaceURI()

	/**
	 * Method getValidator
	 * 
	 * 
	 * 
	 * @return TypeValidator
	 */
	public org.exolab.castor.xml.TypeValidator getValidator() {
		return this;
	} // -- org.exolab.castor.xml.TypeValidator getValidator()

	/**
	 * Method getXMLName
	 * 
	 * 
	 * 
	 * @return String
	 */
	public java.lang.String getXMLName() {
		return xmlName;
	} // -- java.lang.String getXMLName()

}
