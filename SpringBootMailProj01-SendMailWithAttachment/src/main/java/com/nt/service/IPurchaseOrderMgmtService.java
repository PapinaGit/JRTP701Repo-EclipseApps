package com.nt.service;

public interface IPurchaseOrderMgmtService {
 
	public String purchase(String[] items, double prices[],String[] emails) throws Exception;
}
