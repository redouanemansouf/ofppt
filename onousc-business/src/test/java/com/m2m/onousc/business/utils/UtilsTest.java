///*
// * UtilsTest.java
// *
// * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
// */
//
//package com.m2m.onousc.business.utils;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import com.m2m.technicalservices.security.RoleEntity;
//import com.m2m.technicalservices.security.UserEntity;
//
///**
// * The Class UtilsTest.
// * 
// * @author aelhachimi
// */
//public class UtilsTest {
//
//	/**
//	 * Serialize object to json string test.
//	 */
//	@Test
//	public void serializeObjectToJsonStringTest() {
//
//		String expectedJsonString = "{\"firstName\":\"first name\",\"lastName\":\"last name\",\"username\":null,\"password\":null,\"roles\":[{\"role\":\"role1\"}]}";
//
//		UserEntity userEntity = new UserEntity();
//		userEntity.setFirstName("first name");
//		userEntity.setLastName("last name");
//
//		RoleEntity roleEntity = new RoleEntity();
//		roleEntity.setRole("role1");
//		Set<RoleEntity> roles = new HashSet<RoleEntity>(1);
//		roles.add(roleEntity);
//
//		userEntity.setRoles(roles);
//
//		String result = Utils.serializeObjectToJsonString(userEntity);
//		Assert.assertEquals(expectedJsonString, result);
//	}
//}
