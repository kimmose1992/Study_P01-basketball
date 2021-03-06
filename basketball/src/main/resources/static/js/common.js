/**
 * JQuery
 */
jQuery.fn.serializeObject = function() {
	var obj = null;
	try {
		if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
			var arr = this.serializeArray();
			if (arr) {
				obj = {};
				jQuery.each(arr, function() {
					obj[this.name] = this.value;
        		});
          	}
		}
	} catch (e) {
		alert(e.message);
	} finally {
		
	}
   
	return obj;
};

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
		if (isAsync == undefined) {
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
	 * POST 방식 전달 메소드
	 * @param	url, params, callback, isAsync
	 * @return	data
	 */
	sendPost: function(url, params) {
		
		if (com.isNull(url)) {
			return;
		}

		if (com.isNull(params)) {
			return;
		}
		
		// form 생성	
    	var form = document.createElement('form');
    
		form.setAttribute('method',	"post");
    	form.setAttribute('action', url);
    	
    	// csrf 설정
		params[parameter] = token;
	
		// form 객체 hidden 값 설정	
		var hiddenField;
	
	    for (var key in params) {
			if (params.hasOwnProperty(key)) {
				hiddenField = document.createElement('input');
				hiddenField.setAttribute('type',  'hidden');
	          	hiddenField.setAttribute('name',  key);
	          	hiddenField.setAttribute('value', params[key]);
	         
	         	form.appendChild(hiddenField);
	       }
	    }

		document.body.appendChild(form);
		form.submit();
	},
	/**
	 * 콤보 구성 메소드
	 * @param	N/A 
	 * @return	comboList
	 * @example	com.comboBind(params)
	 */	
	comboBind: function(data) {
		var comboObj = $("#" + data.comboId);
		var comboList = data.cmCodeDTOList;
		
		// 콤보박스 초기화
		comboObj.empty();
		
		if (com.isNull(comboList)) {
			comboObj.append("<option value=''>정보없음</option>");
		} else {
			// 콤보박스 기본값 설정
			if (!com.isNull(data.comboType)) {
				comboObj.append("<option value=''>" + (data.comboType == 'A' ? '전체' : '선택') + "</option>");
			}
			
			// 콤보박스 데이터 설정
			for(var i=0; i<comboList.length; i++) {
				comboObj.append("<option value='" + comboList[i].cddId + "' data-sub='" + comboList[i].cddDesc + "'>" + comboList[i].cddNm + "</option>");
			}
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