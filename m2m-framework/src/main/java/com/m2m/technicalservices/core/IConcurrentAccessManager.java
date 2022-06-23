package com.m2m.technicalservices.core;

public interface IConcurrentAccessManager {

	ProcessResult doCheckConcurrentAccess(UseCaseController useCaseController);

}
