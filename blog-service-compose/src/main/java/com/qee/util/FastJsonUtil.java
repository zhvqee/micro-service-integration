package com.qee.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class FastJsonUtil {
	private FastJsonUtil() {
	}

	public static SerializerPair buildSerializerPair(Class<?> clazz, ObjectSerializer objectSerializer) {
		return new SerializerPair(clazz, objectSerializer);
	}

	public static String toJSONString(Object obj) {
		return toJSONString(obj, SerializeConfig.getGlobalInstance(), SerializerFeature.DisableCircularReferenceDetect);
	}

	public static String toJSONString(Object obj, SerializerFeature... serializerFeatures) {
		return toJSONString(obj, SerializeConfig.getGlobalInstance(), null, serializerFeatures);
	}

	public static String toJSONString(Object obj, SerializeFilter[] filters, SerializerFeature... serializerFeatures) {
		return toJSONString(obj, SerializeConfig.getGlobalInstance(), filters, serializerFeatures);
	}

	public static String toJSONString(Object obj, SerializeConfig serializeConfigs, SerializeFilter[] filters,
                                      SerializerFeature... serializerFeatures) {
		if (null != serializerFeatures && 0 != serializerFeatures.length) {
			boolean flg = false;
			for (SerializerFeature serializerFeature : serializerFeatures) {
				if (serializerFeature.getMask() == SerializerFeature.DisableCircularReferenceDetect.getMask()) {
					// 已经包含SerializerFeature.DisableCircularReferenceDetect
					flg = true;
				}
			}
			if (!flg) {
				// 所有操作必须加上SerializerFeature.DisableCircularReferenceDetect
				List<SerializerFeature> featureList = new ArrayList<>(Arrays.asList(serializerFeatures));
				featureList.add(SerializerFeature.DisableCircularReferenceDetect);
				serializerFeatures = featureList.toArray(serializerFeatures);
			}
		} else {
			serializerFeatures = new SerializerFeature[] { SerializerFeature.DisableCircularReferenceDetect };
		}
		if (null == filters) {
			return JSON.toJSONString(obj, serializeConfigs, serializerFeatures);
		}
		return JSON.toJSONString(obj, serializeConfigs, filters, serializerFeatures);
	}

	public static String toJSONString(Object obj, SerializeConfig serializeConfigs,
	        SerializerFeature... serializerFeatures) {
		return toJSONString(obj, serializeConfigs, null, serializerFeatures);
	}

	/**
	 * 可以增加自定义方式的序列化 该增加的自定义方式不会影响全局 但也不能使用SerializeConfig.getGlobalInstance()中新增加的序列化方式
	 * 
	 * @param obj
	 * @param serializerPairs
	 * @return
	 */
	public static String toJSONString(Object obj, SerializerPair[] serializerPairs, SerializeFilter[] filters,
	        SerializerFeature... serializerFeatures) {
		// 不使用SerializeConfig.getGlobalInstance()，不影响全局
		SerializeConfig serializeConfig = new SerializeConfig();
		if (null != serializerPairs || 0 != serializerPairs.length) {
			for (SerializerPair serializerPair : serializerPairs) {
				serializeConfig.put(serializerPair.getClazz(), serializerPair.getObjectSerializer());
			}
		}
		return toJSONString(obj, serializeConfig, filters, serializerFeatures);
	}

	public static String toJSONString(Object obj, SerializerPair[] serializerPairs,
	        SerializerFeature... serializerFeatures) {
		return toJSONString(obj, serializerPairs, null, serializerFeatures);
	}

	/**
	 * 把json解析为Java对象
	 * 
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T parse(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		if (!json.trim().startsWith("{")) {
			return null;
		}
		return JSON.parseObject(json, clazz, Feature.AllowUnQuotedFieldNames);
	}

	/**
	 * 把json数组解析为List 默认也是Feature.AllowUnQuotedFieldNames的
	 * 
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> parseList(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		if (!json.trim().startsWith("[")) {
			return new ArrayList<>();
		}
		return JSON.parseArray(json, clazz);
	}

	public static <T> List<T> parseList(JSONArray jsonArray, Class<T> clazz) {
		List<T> list = new ArrayList<>();
		if (null == jsonArray || jsonArray.isEmpty()) {
			return list;
		}
		for (int inc = 0; inc < jsonArray.size(); inc++) {
			list.add(jsonArray.getObject(inc, clazz));
		}
		return list;
	}

	/**
	 * 把json解析为map
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> parseMap(String json) {
		if (StringUtils.isBlank(json)) {
			return new HashMap<>();
		}
		if (!json.trim().startsWith("{")) {
			return new HashMap<>();
		}
		return JSON.parseObject(json, Feature.AllowUnQuotedFieldNames);
	}

	/**
	 * {@linkplain FastJsonUtil#parseMap(String)}
	 * 
	 * @param json
	 * @return
	 */
	public static Map parseMap2(String json) {
		return parseMap(json);
	}

	/**
	 * 把json数组解析为List<Map>
	 * 
	 * @param json
	 * @return
	 */
	public static List<Map<String, Object>> parseListMap(String json) {
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		List<JSONObject> list = parseList(json, JSONObject.class);
		List<Map<String, Object>> result = new ArrayList<>();
		for (JSONObject jsonObject : list) {
			result.add(jsonObject);
		}
		return result;
	}

	/**
	 * {@linkplain FastJsonUtil#parseListMap(String)} 为了兼容
	 * 
	 * @param json
	 * @return
	 */
	public static List<Map> parseListMap2(String json) {
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		List<Map<String, Object>> list = parseListMap(json);
		List<Map> result = new ArrayList<>();
		for (Map<String, Object> map : list) {
			result.add(map);
		}
		return result;
	}

	/**
	 * {@linkplain FastJsonUtil#parseListMap(String)} 为了兼容
	 * 
	 * @param json
	 * @return
	 */
	public static List<Map<String, String>> parseListMap3(String json) {
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		List<Map<String, Object>> list = parseListMap(json);
		List<Map<String, String>> result = new ArrayList<>();
		for (Map<String, Object> map : list) {
			Map<String, String> strMap = new HashMap<>();
			for (String key : map.keySet()) {
				if (null != map.get(key)) {
					strMap.put(key, map.get(key).toString());
				}
			}
			result.add(strMap);
		}
		return result;
	}

}
