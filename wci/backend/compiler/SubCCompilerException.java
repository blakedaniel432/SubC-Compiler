package wci.backend.compiler;

/**
 * <h1>SubCCompilerException</h1>
 *
 * <p>
 * Error during the SubC compiler's code generation.
 * </p>
 *
 * <p>
 * Copyright (c) 2009 by Ronald Mak
 * </p>
 * <p>
 * For instructional purposes only. No warranties.
 * </p>
 */
public class SubCCompilerException extends Exception {
	public SubCCompilerException(String message) {
		super(message);
	}
}
