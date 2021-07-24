package com.cn.template.common.bean.base;

import lombok.ToString;

import java.util.List;

@ToString
public class ResourceBean {
	private String serviceName;
	private String serviceCode;
	
	private String listUrl;
	
	private String configAuthUrl;
	
	private List<SystemMenuBean> resources;

	
	public ResourceBean() {
		super();
	}

	/**
	 * 
	 * @param serviceName 服务名称
	 * @param serviceCode 服务编码
	 * @param listUrl 角色对应的权限获取地址
	 * @param configAuthUrl 角色对应权限的设置地址
	 * @param resources 菜单资源
	 */
	public ResourceBean(String serviceName, String serviceCode, String listUrl, String configAuthUrl,
                        List<SystemMenuBean> resources) {
		super();
		this.serviceName = serviceName;
		this.serviceCode = serviceCode;
		this.listUrl = listUrl;
		this.configAuthUrl = configAuthUrl;
		this.resources = resources;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getListUrl() {
		return listUrl;
	}

	public void setListUrl(String listUrl) {
		this.listUrl = listUrl;
	}

	public String getConfigAuthUrl() {
		return configAuthUrl;
	}

	public void setConfigAuthUrl(String configAuthUrl) {
		this.configAuthUrl = configAuthUrl;
	}

	public List<SystemMenuBean> getResources() {
		return resources;
	}

	public void setResources(List<SystemMenuBean> resources) {
		this.resources = resources;
	}
}
