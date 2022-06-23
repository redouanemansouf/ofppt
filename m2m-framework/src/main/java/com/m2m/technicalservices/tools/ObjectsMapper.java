package com.m2m.technicalservices.tools;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class ObjectsMapper {

	private static Mapper mapper;

	private ObjectsMapper() {
	}

	public static Mapper getMapper() {
		if (mapper == null) {
			mapper = new DozerBeanMapper();
		}
		return mapper;
	}

}
