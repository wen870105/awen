package com.test.cglib.lazy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

public class LoaderBean {
	private String loaderName;
	private int loaderValue;
	private PropertyBean propertyBean;

	public LoaderBean() {
		this.loaderName = "loaderNameA";
		this.loaderValue = 123;
		this.propertyBean = createPropertyBean();
	}

	public String getLoaderName() {
		return loaderName;
	}

	public void setLoaderName(String loaderName) {
		this.loaderName = loaderName;
	}

	public int getLoaderValue() {
		return loaderValue;
	}

	public void setLoaderValue(int loaderValue) {
		this.loaderValue = loaderValue;
	}

	public PropertyBean getPropertyBean() {
		return propertyBean;
	}

	public void setPropertyBean(PropertyBean propertyBean) {
		this.propertyBean = propertyBean;
	}

	protected PropertyBean createPropertyBean() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PropertyBean.class);
		return (PropertyBean) enhancer.create(PropertyBean.class, new ConcreteClassLazyLoader());
	}

	public static class PropertyBean {
		private String propertyName;
		private int propertyValue;

		public String getPropertyName() {
			return propertyName;
		}

		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}

		public int getPropertyValue() {
			return propertyValue;
		}

		public void setPropertyValue(int propertyValue) {
			this.propertyValue = propertyValue;
		}

		//setter/getter  
	}

	public static class ConcreteClassLazyLoader implements LazyLoader {
		public Object loadObject() throws Exception {
			System.out.println("LazyLoader loadObject() ...");
			PropertyBean bean = new PropertyBean();
			bean.setPropertyName("lazy-load object propertyName!");
			bean.setPropertyValue(11);
			return bean;
		}
	}

	public static void main(String[] args) {
		LoaderBean loader = new LoaderBean();
		System.out.println(loader.getLoaderName());
		System.out.println(loader.getLoaderValue());
		PropertyBean propertyBean = loader.getPropertyBean();//访问延迟加载对象  
		System.out.println(propertyBean.getPropertyName());
		System.out.println(propertyBean.getPropertyValue());
		System.out.println("after...");
		//当再次访问延迟加载对象时,就不会再执行回调了  
		System.out.println(propertyBean.getPropertyName());
	}
}