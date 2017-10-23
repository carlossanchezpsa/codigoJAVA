/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: HeaderTypeDescriptor.java,v 1.1 2008/01/21 09:37:38 e243060 Exp $
 */

package com.inetpsa.boz.rpv.rp.xml;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.StringValidator;

/**
 * Class HeaderTypeDescriptor.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/21 09:37:38 $
 */
public class HeaderTypeDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

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

	public HeaderTypeDescriptor() {
		super();
		xmlName = "HeaderType";

		// -- set grouping compositor
		setCompositorAsSequence();
		org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
		org.exolab.castor.mapping.FieldHandler handler = null;
		org.exolab.castor.xml.FieldValidator fieldValidator = null;
		// -- initialize attribute descriptors

		// -- initialize element descriptors

		// -- _TRANSFER_DATE
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_TRANSFER_DATE", "TRANSFER_DATE",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				HeaderType target = (HeaderType) object;
				return target.getTRANSFER_DATE();
			}

			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					HeaderType target = (HeaderType) object;
					target.setTRANSFER_DATE((java.lang.String) value);
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

		// -- validation code for: _TRANSFER_DATE
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _ACTIVITYList
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.inetpsa.boz.rpv.rp.xml.ACTIVITY.class, "_ACTIVITYList", "ACTIVITY",
				org.exolab.castor.xml.NodeType.Element);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object) throws IllegalStateException {
				HeaderType target = (HeaderType) object;
				return target.getACTIVITY();
			}

			public void setValue(java.lang.Object object, java.lang.Object value) throws IllegalStateException, IllegalArgumentException {
				try {
					HeaderType target = (HeaderType) object;
					target.addACTIVITY((com.inetpsa.boz.rpv.rp.xml.ACTIVITY) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return new com.inetpsa.boz.rpv.rp.xml.ACTIVITY();
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
	}

	// -- _FROM
	/*
	 * desc = new
	 * org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class,
	 * "_FROM", "FROM", org.exolab.castor.xml.NodeType.Element);
	 * desc.setImmutable(true); handler = new
	 * org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
	 * getValue( java.lang.Object object ) throws IllegalStateException {
	 * HeaderType target = (HeaderType) object; return target.getFROM(); }
	 * public void setValue( java.lang.Object object, java.lang.Object value)
	 * throws IllegalStateException, IllegalArgumentException { try { HeaderType
	 * target = (HeaderType) object; target.setFROM( (java.lang.String) value);
	 * } catch (java.lang.Exception ex) { throw new
	 * IllegalStateException(ex.toString()); } } public java.lang.Object
	 * newInstance( java.lang.Object parent ) { return null; } };
	 * desc.setHandler(handler); desc.setRequired(true);
	 * desc.setMultivalued(false); addFieldDescriptor(desc);
	 * 
	 * //-- validation code for: _FROM fieldValidator = new
	 * org.exolab.castor.xml.FieldValidator(); fieldValidator.setMinOccurs(1); {
	 * //-- local scope StringValidator typeValidator = new StringValidator();
	 * typeValidator.setWhiteSpace("preserve");
	 * fieldValidator.setValidator(typeValidator); }
	 * desc.setValidator(fieldValidator); //-- _TO desc = new
	 * org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class,
	 * "_TO", "TO", org.exolab.castor.xml.NodeType.Element);
	 * desc.setImmutable(true); handler = new
	 * org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
	 * getValue( java.lang.Object object ) throws IllegalStateException {
	 * HeaderType target = (HeaderType) object; return target.getTO(); } public
	 * void setValue( java.lang.Object object, java.lang.Object value) throws
	 * IllegalStateException, IllegalArgumentException { try { HeaderType target
	 * = (HeaderType) object; target.setTO( (java.lang.String) value); } catch
	 * (java.lang.Exception ex) { throw new
	 * IllegalStateException(ex.toString()); } } public java.lang.Object
	 * newInstance( java.lang.Object parent ) { return null; } };
	 * desc.setHandler(handler); desc.setMultivalued(false);
	 * addFieldDescriptor(desc);
	 * 
	 * //-- validation code for: _TO fieldValidator = new
	 * org.exolab.castor.xml.FieldValidator(); { //-- local scope
	 * StringValidator typeValidator = new StringValidator();
	 * typeValidator.setWhiteSpace("preserve");
	 * fieldValidator.setValidator(typeValidator); }
	 * desc.setValidator(fieldValidator); //-- _EXTRACT_VERSION desc = new
	 * org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class,
	 * "_EXTRACT_VERSION", "EXTRACT_VERSION",
	 * org.exolab.castor.xml.NodeType.Element); desc.setImmutable(true); handler
	 * = new org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
	 * getValue( java.lang.Object object ) throws IllegalStateException {
	 * HeaderType target = (HeaderType) object; return
	 * target.getEXTRACT_VERSION(); } public void setValue( java.lang.Object
	 * object, java.lang.Object value) throws IllegalStateException,
	 * IllegalArgumentException { try { HeaderType target = (HeaderType) object;
	 * target.setEXTRACT_VERSION( (java.lang.String) value); } catch
	 * (java.lang.Exception ex) { throw new
	 * IllegalStateException(ex.toString()); } } public java.lang.Object
	 * newInstance( java.lang.Object parent ) { return null; } };
	 * desc.setHandler(handler); desc.setMultivalued(false);
	 * addFieldDescriptor(desc);
	 * 
	 * //-- validation code for: _EXTRACT_VERSION fieldValidator = new
	 * org.exolab.castor.xml.FieldValidator(); { //-- local scope
	 * StringValidator typeValidator = new StringValidator();
	 * typeValidator.setWhiteSpace("preserve");
	 * fieldValidator.setValidator(typeValidator); }
	 * desc.setValidator(fieldValidator); //-- _AP_AC desc = new
	 * org.exolab.castor
	 * .xml.util.XMLFieldDescriptorImpl(com.inetpsa.boz.rpv.rp.xml
	 * .types.MarquePSAType.class, "_AP_AC", "AP_AC",
	 * org.exolab.castor.xml.NodeType.Element); handler = new
	 * org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
	 * getValue( java.lang.Object object ) throws IllegalStateException {
	 * HeaderType target = (HeaderType) object; return target.getAP_AC(); }
	 * public void setValue( java.lang.Object object, java.lang.Object value)
	 * throws IllegalStateException, IllegalArgumentException { try { HeaderType
	 * target = (HeaderType) object; target.setAP_AC(
	 * (com.inetpsa.boz.rpv.rp.xml.types.MarquePSAType) value); } catch
	 * (java.lang.Exception ex) { throw new
	 * IllegalStateException(ex.toString()); } } public java.lang.Object
	 * newInstance( java.lang.Object parent ) { return null; } }; handler = new
	 * org
	 * .exolab.castor.xml.handlers.EnumFieldHandler(com.inetpsa.boz.rpv.rp.xml
	 * .types.MarquePSAType.class, handler); desc.setImmutable(true);
	 * desc.setHandler(handler); desc.setRequired(true);
	 * desc.setMultivalued(false); addFieldDescriptor(desc);
	 * 
	 * //-- validation code for: _AP_AC fieldValidator = new
	 * org.exolab.castor.xml.FieldValidator(); fieldValidator.setMinOccurs(1); {
	 * //-- local scope } desc.setValidator(fieldValidator); //-- _FILE_TYPE
	 * desc = new
	 * org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class,
	 * "_FILE_TYPE", "FILE_TYPE", org.exolab.castor.xml.NodeType.Element);
	 * desc.setImmutable(true); handler = new
	 * org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
	 * getValue( java.lang.Object object ) throws IllegalStateException {
	 * HeaderType target = (HeaderType) object; return target.getFILE_TYPE(); }
	 * public void setValue( java.lang.Object object, java.lang.Object value)
	 * throws IllegalStateException, IllegalArgumentException { try { HeaderType
	 * target = (HeaderType) object; target.setFILE_TYPE( (java.lang.String)
	 * value); } catch (java.lang.Exception ex) { throw new
	 * IllegalStateException(ex.toString()); } } public java.lang.Object
	 * newInstance( java.lang.Object parent ) { return null; } };
	 * desc.setHandler(handler); desc.setMultivalued(false);
	 * addFieldDescriptor(desc);
	 * 
	 * //-- validation code for: _FILE_TYPE fieldValidator = new
	 * org.exolab.castor.xml.FieldValidator(); { //-- local scope
	 * StringValidator typeValidator = new StringValidator();
	 * typeValidator.setWhiteSpace("preserve");
	 * fieldValidator.setValidator(typeValidator); }
	 * desc.setValidator(fieldValidator); } //--
	 * com.inetpsa.boz.rpv.rrdi.xml.HeaderTypeDescriptor()
	 * 
	 * 
	 * //-----------/ //- Methods -/ //-----------/
	 * 
	 * /** Method getAccessMode
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
		return com.inetpsa.boz.rpv.rp.xml.HeaderType.class;
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
