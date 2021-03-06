package com.study.basketball.cm.info.issue;

public class IssueInfo {

	/************************************************************************
	 * ■ a 태그 URL 호출 시, 중복 호출되는 현상
	 ************************************************************************/
	/*
	 * [현상]
	 * 1. 관리자 메인 페이지 접속
	 * 2. aside 메뉴 - 공통코드 관리 클릭 (EX. /ad/codeList)
	 * 3. /ad/codeList 중복 호출
	 * 
	 * [특이사항]
	 * 1. 컨트롤러는 @RestController 로 구현
	 * 2. 최초 호출 시, URL은 호출하나 컨트롤러 디버깅에는 걸리지 않음
	 * 3. 최초 호출 외에는 정상적으로 한번만 호출됨
	 * 
	 * [원인]
	 * 1. TODO a 태그 호출 시 중복이 발생한 이유
	 *
	 * [조치]
	 * 1. URL 호출 시, POST 방식으로 변경
	 * 
	 * [Note]
	 * 1. TODO a 태그 호출 시 컨트롤러 디버깅을 타지 않는 이유
	 * 2. TODO POST 방식으로 변경해서 중복 호출이 해결된 이유
	 */
}
