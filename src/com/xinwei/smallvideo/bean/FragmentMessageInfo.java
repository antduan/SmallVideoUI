/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-29	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.bean;

import java.io.Serializable;

/**
 * 
 * 类简要描述
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class FragmentMessageInfo implements Serializable
{
	private static final long serialVersionUID = -2169507779343548052L;
	
	private int resourceID;
	
	private String messageTitle;
	
	private String messageContent;
	
	private String lastMessageDate;
	
	private int messageNumber;
	
	public int getResourceID()
	{
		return resourceID;
	}
	
	public void setResourceID(int resourceID)
	{
		this.resourceID = resourceID;
	}
	
	public String getMessageTitle()
	{
		return messageTitle;
	}
	
	public void setMessageTitle(String messageTitle)
	{
		this.messageTitle = messageTitle;
	}
	
	public String getMessageContent()
	{
		return messageContent;
	}
	
	public void setMessageContent(String messageContent)
	{
		this.messageContent = messageContent;
	}
	
	public String getLastMessageDate()
	{
		return lastMessageDate;
	}
	
	public void setLastMessageDate(String lastMessageDate)
	{
		this.lastMessageDate = lastMessageDate;
	}
	
	public int getMessageNumber()
	{
		return messageNumber;
	}
	
	public void setMessageNumber(int messageNumber)
	{
		this.messageNumber = messageNumber;
	}
}
