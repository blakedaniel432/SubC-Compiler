/**
 * <h1>SubCRuntimeException</h1>
 *
 * <p>
 * SubC Runtime Library: Exception thrown for an error while executing the
 * generated code.
 * </p>
 *
 * <p>
 * Copyright (c) 2009 by Ronald Mak
 * </p>
 * <p>
 * For instructional purposes only. No warranties.
 * </p>
 */
public class SubCRuntimeException extends Exception {
	public SubCRuntimeException(String message) {
		super(message);
	}
}
