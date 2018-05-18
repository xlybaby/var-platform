package com.machintosh1983.var.platform.common;

public class ErrorCode {
	
	public static String _9000 (String ... parms) {
		return  "[9000] Can't borrow remote web driver from pool["+getParamString(parms)+"]";
	}
	
	public static String _9200 (String ... parms) {
		return  "[9200] Can't add remote web driver into pool["+getParamString(parms)+"]";
	}
	
	public static String _9100 (String ... parms) {
		return "[9100] Can't start remote web driver service["+getParamString(parms)+"]";
	}

	private static String getParamString(String ... parms) {
		StringBuffer buf = new StringBuffer();
		if( parms.length > 0 )
			buf.append(parms[0]);
		
		for( int i=1; i<parms.length; i++) {
			buf.append(",").append(parms[i]);
		}
		
		return buf.toString();
	}
}
