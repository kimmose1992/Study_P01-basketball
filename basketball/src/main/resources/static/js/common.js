/**
 * CSRF
 */
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var parameter = $("meta[name='_csrf_parameter']").attr("content");

/**
 * Common JS 
 */
 var com = {
	/**
	 * Ajax 공통 메소드
	 * @param	url, params, callback, isAsync
	 * @return	data
	 */
	callAjax: function(url, params, callback, isAsync) {
		
		// Async 미설정 시, 기본값 true 적용
		if (com.isNull(isAsync)) {
			isAsync = true;
		}
		
		$.ajax({
			type : 'POST'
		  , url : url
	  	  , data : params
	  	  ,	async : isAsync
	  	  , beforeSend : function(xhr) {
				xhr.setRequestHeader(header, token);
        	}	  	  
	  	  , success : function(data) {
				callback(data)
			}
		  , error : function(xhr, status, error) {
				callback(error)
			}	
		});
	},
	/**
	 * 콤보 구성 메소드
	 * @param	N/A 
	 * @return	comboList
	 * @example	com.comboBind(params)
	 */	
	comboBind: function(data) {
		console.log(data);
		console.log(data.comboId);
		console.log(data.cmCodeVOList);
		
		for(var i=0; i<data.cmCodeVOList.length; i++) {
			console.log(i);
		}
	},
	/**
	 * NULL 여부 체크 메소드
	 * @param	param
	 * @return	true/false
	 */	
	isNull: function(param) {
		if (param == null || param == undefined || param == '') {
			return true;
		}
		
		return false;
	}
}