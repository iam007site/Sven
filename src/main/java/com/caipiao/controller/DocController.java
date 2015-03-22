package com.caipiao.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;




import com.caipiao.controller.DocController.RequestModel.Parameter;
//import com.galaxy.front.web.rest.interceptor.AuthApiHandlerInterceptor;

@Controller()
@RequestMapping(value="doc")
public class DocController {
	private final RequestMappingHandlerMapping handlerMapping;

	@Autowired
	public DocController(RequestMappingHandlerMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}

	String getValue(RequestMapping mapping) {
		if(mapping==null){
			return "";
		}
		if (mapping.value() != null && mapping.value().length > 0) {
			return mapping.value()[0];
		}
		return "";
	}
	String getMethod(RequestMapping mapping) {
		if(mapping==null){
			return "";
		}
		if (mapping.method() != null && mapping.method().length > 0) {
			return mapping.method()[0].name();
		}
		return "";
	}

	@RequestMapping(value = "doc", method = RequestMethod.GET)
	public void show(Model model) {
		Map<RequestMappingInfo, HandlerMethod> methodsMap = handlerMapping
				.getHandlerMethods();
		Set<Entry<RequestMappingInfo, HandlerMethod>> entrySet=methodsMap.entrySet();
		List<RequestModel> modelList=new LinkedList<RequestModel>();
		for(Entry<RequestMappingInfo, HandlerMethod> entry:entrySet){
			RequestMappingInfo mappingItem=entry.getKey();
			HandlerMethod handlerMethod=entry.getValue();
			 
			RestController restAnn=AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), RestController.class);
			if(restAnn==null){
				continue;
			}
			RequestMapping beanMappingAnn=AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), RequestMapping.class);
			RequestMapping methodMappingAnn=handlerMethod.getMethodAnnotation(RequestMapping.class);
			StringBuilder sb=new StringBuilder();  
			sb.append(getValue(beanMappingAnn)); 
			String methodPath=getValue(methodMappingAnn);
			if(sb.length()>0&&sb.charAt(sb.length()-1)=='/'){
				if(methodPath.startsWith("/")){
					sb.deleteCharAt(sb.length()-1).append(methodPath);
				}else{
					sb.append(methodPath);
				}
			}else{
				if(methodPath.startsWith("/")){
					sb.append(methodPath);
				}else{
					sb.append("/").append(methodPath);
				}
			}
			RequestModel requestModel=new RequestModel();
			requestModel.url=sb.toString();
			if(!requestModel.url.startsWith("/")){
				requestModel.url="/"+requestModel.url;
			}
			requestModel.method=getMethod(methodMappingAnn);
			requestModel.pack=handlerMethod.getBeanType().getPackage().getName();
			modelList.add(requestModel);
			MethodParameter[] parameters=handlerMethod.getMethodParameters();
			for(MethodParameter parameter:parameters){
				RequestParam paramAnn=parameter.getParameterAnnotation(RequestParam.class);
				Parameter p=new Parameter();
				p.name=parameter.getParameterName();
				p.type=parameter.getParameterType();
				
				if(paramAnn!=null){
					p.name=paramAnn.value();
				} 
				requestModel.paramters.add(p);
			}
			
			Parameter p=new Parameter();
			p.name="_token_";
//			p.name=AuthApiHandlerInterceptor.TOKEN_PARAM_NAME;
			p.type=String.class; 
			p.value="token value";
			requestModel.paramters.add(p); 
			requestModel.setId(requestModel.url.replaceAll("[/]", "_"));
			if(requestModel.getId().startsWith("_")){
				requestModel.setId(requestModel.getId().substring(1));
			}
			 
		}
		 
		model.addAttribute("modelList",
				modelList);
	}
	
	public static class RequestModel{
		String url;
		String pack;
		String method;
		String id;
		
		List<Parameter> paramters=new LinkedList<Parameter>();
		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getPack() {
			return pack;
		}

		public void setPack(String pack) {
			this.pack = pack;
		}

		public List<Parameter> getParamters() {
			return paramters;
		}

		public void setParamters(List<Parameter> paramters) {
			this.paramters = paramters;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		

		public static class Parameter{
			Class<?> type;
			String name;

			String value;
			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}
			public Class<?> getType() {
				return type;
			}
			public void setType(Class<?> type) {
				this.type = type;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			@Override
			public String toString() {
				return "Parameter [type=" + type + ", name=" + name + "]";
			}
			
		}
	}
}