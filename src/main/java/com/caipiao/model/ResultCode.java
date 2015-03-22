package com.caipiao.model;


/*author:huangshanqi
 *time  :2014年10月7日 下午2:23:25
 *email :hsqmobile@gmail.com
 */
public enum ResultCode {

	OK("20000", "ok"),
	USER_CREATE_ERROR("50000","创建用户失败"),
	USER_MODIFY_USERNAME_ERROR("50001","修改用户名失败"),
	USER_MODIFY_PASSWORD_ERROR("50002","修改用户密码失败"),
	USER_LOGIN_SUCCCESS("50003","登陆成功"),
	USER_LOGIN_FAILED("50004","登陆失败"),
	USER_LOGIN_PASSWORD_ERROR("50004","登陆密码错误"),
	
	CATEGORY_CREATE_ERROR("50010","创建分类失败"),
	CATEGORY_DELETE_ERROR("50011","删除分类失败"),
	TAG_CREATE_ERROR("50020","创建标签失败"),
	TAG_DELETE_ERROR("50021","删除标签失败"),
	
	Blog_CREATE_ERROR("50030","创建新博文错误"),
	
	
	
	Zixun_Detail_Error("51000","资讯详情页找不到"),
	Zixun_GetList_Error("51001","无法获取资讯列表内容"),
	Dlt_GetHistoryList_Error("51001","无法获取历史开奖信息"),
	Ssq_GetHistoryList_Error("51002","无法获取历史开奖信息"),
	Pl3_GetHistoryList_Error("51003","无法获取历史开奖信息"),
	Fc3d_GetHistoryList_Error("51004","无法获取历史开奖信息"),
	
	Ad_getList_Error("51005","无法获取广告列表"),
	Website_getList_Error("51006","无法获取展示站点列表"),
	
	Website_Commment_Error("51007","展示站点评论失败"),
	AppFeedback_Create_Error("51008","app反馈提交失败"),
	
	
	
	;
	
	
	private  String code;// 错误码
	private String  message; // 错误信息

	private ResultCode(String code, String message) {
		this.code = code;
		this.message = message;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
