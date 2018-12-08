package com.framework.v1.business.base.model;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * 
 * 该类是ajax请求结果封装类
 * 
 * @version 2015年8月25日
 * @author leibf
 */
@JsonSerialize(include = Inclusion.NON_NULL)
public class JsonResult extends HashMap<String, Object>
{
	public static final String SUCCESS_PROP = "success";

	public static final String MESSAGE_PROP = "message";

	public static final String DATA_PROP = "data";

	public static final String TOTALCOUNT_PROP = "totalCount";

	public static final String START_PROP = "start";

	public static final String LIMIT_PROP = "limit";


	public static final String MESSAGE_OF_BEAN_VALIDATE = "INVALID_BEAN";

	public JsonResult()
	{
		super();
		this.setSuccess(true);
	}

	public JsonResult(Object data)
	{
		super();
		this.setSuccess(true);
		this.setData(data);
	}



	public JsonResult(Object data, int totalCount)
	{
		super();
		this.setSuccess(true);
		this.setData(data);
	}

	public JsonResult(Object data, int totalCount, int start, int limit)
	{
		super();
		this.setSuccess(true);
		this.setData(data);
		this.setTotalCount(totalCount);
		this.setStart(start);
		this.setLimit(limit);


	}

	public JsonResult(boolean success, String message)
	{
		super();
		this.setSuccess(success);
		this.setMessage(message);
	}

	public JsonResult(boolean success, String message, Object data)
	{
		super();
		this.setSuccess(success);
		this.setMessage(message);
		this.setData(data);
	}

	public boolean getSuccess()
	{
		return (Boolean) this.get(SUCCESS_PROP);
	}

	public JsonResult setSuccess(boolean value)
	{
		this.put(SUCCESS_PROP, value);
		return this;
	}

	public String getMessage()
	{
		return (String) this.get(MESSAGE_PROP);
	}

	public JsonResult setMessage(String value)
	{
		this.put(MESSAGE_PROP, value);
		return this;
	}

	public Object getData()
	{
		Object r = this.get(DATA_PROP);
		return r;
	}

	public Object getTotalCount()
	{
		Object r = this.get(TOTALCOUNT_PROP);
		return r;
	}

	public Object getStart()
	{
		Object r = this.get(START_PROP);
		return r;
	}

	public Object getLimit()
	{
		Object r = this.get(LIMIT_PROP);
		return r;
	}

	public JsonResult setData(Object value)
	{
		this.put(DATA_PROP, value);
		return this;
	}

	public JsonResult setTotalCount(Object value)
	{
		this.put(TOTALCOUNT_PROP, value);
		return this;
	}

	public JsonResult setStart(Object value)
	{
		this.put(START_PROP, value);
		return this;
	}

	public JsonResult setLimit(Object value)
	{
		this.put(LIMIT_PROP, value);
		return this;
	}

	/***
	 * Serialize class, except for null values, into a Json string.
	 * 
	 * @return String
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public String toJson() throws JsonGenerationException, JsonMappingException, IOException
	{
		return this.toJson(true);
	}

	/**
	 * 注意在PO上增加@JsonSerialize(include=Inclusion.NON_NULL)
	 * 
	 * @param serializeNulls
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String toJson(boolean serializeNulls) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return new String(mapper.writeValueAsBytes(this), "UTF-8");
	}

	public byte[] toJsonBytes() throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsBytes(this);
	}

	@Override
	public String toString()
	{
		String str = "";
		try
		{
			str = "JsonResult [getSuccess()=" + getSuccess() + ", getMessage()=" + getMessage() + ", toJson()=" + toJson() + "]";

		}
		catch (JsonGenerationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}


}
