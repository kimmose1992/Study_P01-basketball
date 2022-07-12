package com.study.basketball.cm.utils;

/**
 * @title	: [공통] 객체 타입 관리 유틸 클래스
 * @author	: 김모세
 * @create	: 2022.07.12
 */
public class ObjectUtils {

	/**
	 * @title	: 객체 Null 여부
	 * @method	: isNull	 
	 * @comment	: 객체 Null 여부를 체크하여 결과를 리턴한다.	 
	 * @param	: Object
	 */
	public static boolean isNull(Object object) {
		return ((object == null) || object.equals(null));
	}
}
