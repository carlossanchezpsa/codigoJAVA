/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MarquePSAType.java,v 1.1 2008/01/21 09:37:39 e243060 Exp $
 */

package com.inetpsa.boz.rpv.rp.xml.types;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class MarquePSAType.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/21 09:37:39 $
 */
public class MarquePSAType implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * The AP type
	 */
	public static final int AP_TYPE = 0;

	/**
	 * The instance of the AP type
	 */
	public static final MarquePSAType AP = new MarquePSAType(AP_TYPE, "AP");

	/**
	 * The AC type
	 */
	public static final int AC_TYPE = 1;

	/**
	 * The instance of the AC type
	 */
	public static final MarquePSAType AC = new MarquePSAType(AC_TYPE, "AC");

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

	private MarquePSAType(int type, java.lang.String value) {
		super();
		this.type = type;
		this.stringValue = value;
	} // -- com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType(int,
		// java.lang.String)

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method enumerate
	 * 
	 * Returns an enumeration of all possible instances of MarquePSAType
	 * 
	 * @return Enumeration
	 */
	public static java.util.Enumeration enumerate() {
		return _memberTable.elements();
	} // -- java.util.Enumeration enumerate()

	/**
	 * Method getType
	 * 
	 * Returns the type of this MarquePSAType
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
		members.put("AP", AP);
		members.put("AC", AC);
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
	 * Returns the String representation of this MarquePSAType
	 * 
	 * @return String
	 */
	public java.lang.String toString() {
		return this.stringValue;
	} // -- java.lang.String toString()

	/**
	 * Method valueOf
	 * 
	 * Returns a new MarquePSAType based on the given String value.
	 * 
	 * @param string
	 * @return MarquePSAType
	 */
	public static com.inetpsa.boz.rpv.rp.xml.types.MarquePSAType valueOf(java.lang.String string) {
		java.lang.Object obj = null;

		if (string != null)
			obj = _memberTable.get(string);

		if (obj == null) {
			String err = "'" + string + "' is not a valid MarquePSAType";
			throw new IllegalArgumentException(err);
		}

		return (MarquePSAType) obj;
	} // -- com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType
		// valueOf(java.lang.String)

}
