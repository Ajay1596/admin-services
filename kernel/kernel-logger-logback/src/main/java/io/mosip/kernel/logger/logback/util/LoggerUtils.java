package io.mosip.kernel.logger.logback.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import io.mosip.kernel.logger.logback.constant.LogExeptionCodeConstant;
import io.mosip.kernel.logger.logback.exception.MosipXMLConfigurationParseException;

/**
 * This is utility class for Logger
 * 
 * @author Urvil Joshi
 * @since 1.0.0
 */
public class LoggerUtils {
	/**
	 * COnstructor for this class
	 */
	private LoggerUtils() {
	}

	/**
	 * Unmarshall object from XML file
	 * 
	 * @param file
	 *            XML file provided by user
	 * @param clazz
	 *            clazz whose object is to be extracted
	 * @return unmarshalled object
	 */
	public static Object unmarshall(File file, Class<?> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			throw new MosipXMLConfigurationParseException(
					LogExeptionCodeConstant.MOSIPCONFIGURATIONXMLPARSE,
					LogExeptionCodeConstant.MOSIPCONFIGURATIONXMLPARSEMESSAGE);
		}

	}
}
