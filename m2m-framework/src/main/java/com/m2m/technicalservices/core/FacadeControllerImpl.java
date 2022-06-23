package com.m2m.technicalservices.core;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;

/**
 * Cette classe est une implémentation du pattern GOF « Facade Pattern » elle
 * simplifie l’accès au cœur métier )
 */
public class FacadeControllerImpl implements IFacadeController {

	private static final ILogger LOGGER = SL4JLogger
			.getInstance(FacadeControllerImpl.class);

	private ClientParameters clientParameters;

	public FacadeControllerImpl(ClientParameters clientParameters) {
		this.clientParameters = clientParameters;
	}

	private void logParams() {
		String ucName = clientParameters.getDomaine()
				+ "_"
				+ clientParameters.getCommand()
				+ "_UC"
				+ "_"
				+ DateUtil.formatCalendarDDMMYYHHMMSSConcat(Calendar
						.getInstance());
		final File ucpf = new File(ucName);

		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new FileOutputStream(ucpf));
			encoder.writeObject(clientParameters);
			encoder.flush();
		} catch (final IOException e) {
			LOGGER.error("IOException : error logParams", e);
		} finally {
			encoder.close();
		}
	}

	public ProcessResult useCaseProcess() {
		// logParams();
		String ucName = clientParameters.getDomaine() + "_"
				+ clientParameters.getCommand() + "_UC";
		IUseCaseController useCaseController = (IUseCaseController) BeansLookuper
				.lookup(ucName);
		UserContext.setClientParameters(clientParameters);
		/**
		 * @author amtarji cas d'une list de vos
		 */
		if (clientParameters.isOnCollection()) {
			UserContext.setSubject(clientParameters.getVos());
		} else {
			UserContext.setSubject(clientParameters.getVo());
		}
		ProcessResult processResult = useCaseController.process();
		// ProcessResult processResult = new ProcessResult();
		// processResult.addMessage(new ProcessMsg("KEYISMESSAGE1", true));
		// processResult.addMessage(new ProcessMsg("KEYNOTMESSAGE2", false));
		return processResult;

	}

}
