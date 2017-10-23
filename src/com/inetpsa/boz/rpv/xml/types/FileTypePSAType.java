/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: ActivityPSAType.java,v 1.1 2008/01/11 17:12:12 e243060 Exp $
 */

package com.inetpsa.boz.rpv.xml.types;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class ActivityPSAType.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/11 17:12:12 $
 */
public class FileTypePSAType implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * The AP type
	 */
	public static final int VM_TYPE = 0;

	/**
	 * The instance of the AP type
	 */
	public static final FileTypePSAType VM = new FileTypePSAType(VM_TYPE, "VM");

	/**
	 * Field _memberTable
	 */
	private static java.util.Hashtable _memberTable = init();

	/**
	 * Field type
	 */
	private int type = -1;

	/**
	 * Field stringValue
	 */
	private java.lang.String stringValue = null;

	// ----------------/
	// - Constructors -/
	// ----------------/

	private FileTypePSAType(int type, java.lang.String value) {
		super();
		this.type = type;
		this.stringValue = value;
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method enumerate
	 * 
	 * Returns an enumeration of all possible instances of ActivityPSAType
	 * 
	 * @return Enumeration
	 */
	public static java.util.Enumeration enumerate() {
		return _memberTable.elements();
	} // -- java.util.Enumeration enumerate()

	/**
	 * Method getType
	 * 
	 * Returns the type of this PSAType
	 * 
	 * @return int
	 */
	public int getType() {
		return this.type;
	} // -- int getType()

	/**
	 * Method init
	 * 
	 * 
	 * 
	 * @return Hashtable
	 */
	private static java.util.Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("VM", VM);
		return members;
	} // -- java.util.Hashtable init()

	/**
	 * Method readResolve
	 * 
	 * will be called during deserialization to replace the deserialized object
	 * with the correct constant instance. <br/>
	 * 
	 * @return Object
	 */
	private java.lang.Object readResolve() {
		return valueOf(this.stringValue);
	} // -- java.lang.Object readResolve()

	/**
	 * Method toString
	 * 
	 * Returns the String representation of this ActivityPSAType
	 * 
	 * @return String
	 */
	public java.lang.String toString() {
		return this.stringValue;
	} // -- java.lang.String toString()

	/**
	 * Method valueOf
	 * 
	 * Returns a new PSAType based on the given String value.
	 * 
	 * @param string
	 * @return PSAType
	 */
	public static com.inetpsa.boz.rpv.xml.types.ActivityPSAType valueOf(
			java.lang.String string) {
		java.lang.Object obj = null;
		if (string != null)
			obj = _memberTable.get(string);
		if (obj == null) {
			String err = "'" + string + "' is not a valid FileTypePSAType";
			throw new IllegalArgumentException(err);
		}
		return (ActivityPSAType) obj;
	}

}
